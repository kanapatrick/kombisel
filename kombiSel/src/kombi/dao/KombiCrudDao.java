package kombi.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;

/**
 * @author kana
 *
 */
public class KombiCrudDao {
	private static SessionFactory sessionFactory;
	private static final ThreadLocal<Session> threadSession=new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction=new ThreadLocal<Transaction>();
	//private static Configuration config;

	static {
    	try{
    		sessionFactory = new AnnotationConfiguration().configure("kombi/dao/hibernate.cfg.xml").buildSessionFactory();
    	}catch(Throwable ex){
    		throw new ExceptionInInitializerError(ex);
    	}
    }
	
	public static void closeSession() {
		Session session = threadSession.get();
		try {
			threadSession.set(null);
			if (session != null && session.isOpen()) 
				session.close();
		}catch(HibernateException ex) {
			throw ex;
		}
	}
	
	public static Session getSession() {
		Session session = threadSession.get();
		try {
			if (session == null) {
				session = getSessionFactory().openSession();
			}
			threadSession.set(session);
		}catch(HibernateException ex) {
			throw ex;
		}
		return session;
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public static void setSessionFactory(SessionFactory sessionFactory) {
		KombiCrudDao.sessionFactory = sessionFactory;
	}

	public static void beginOperation() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction == null) {
				transaction = getSession().beginTransaction();
				threadTransaction.set(transaction);
			}
		}catch(HibernateException ex) {
			throw ex;
		}
	}
	public static void withDrawTransaction() {
		Transaction transaction = threadTransaction.get();
		threadTransaction.set(null);
		try {
			if (transaction != null && !transaction.wasCommitted() && transaction.wasRolledBack()) {
				transaction.rollback();
			}
		}catch (HibernateException ex) {
			throw ex;
		} finally {
			closeSession();
		}
	}
	public static void madeTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction != null && !transaction.wasCommitted()) {
				transaction.commit();
			}
			threadTransaction.set(null);
		}catch (HibernateException ex) {
			withDrawTransaction();
			throw ex;
		}
	}
	
	public static Object sauvegarderOuMettreAJour(Object object) {
		try {
			beginOperation();
			Session session = getSession();
			Object obj = session.merge(object);
			madeTransaction();
			session.clear();
			return obj;
		}catch (HibernateException ex) {
			withDrawTransaction();
			throw ex;
		} finally {
			closeSession();
		}
	}
	
	public static void sauvegarder(Object object) {
		try {
			beginOperation();
			Session session = getSession();
			session.save(object);
			madeTransaction();
			session.clear();
		}catch (HibernateException ex) {
			withDrawTransaction();
			throw ex;
		} finally {
			closeSession();
		}
	}
	
	public static void MettreAJour(Object object) {
		try {
			beginOperation();
			Session session = getSession();
			session.update(object);
			madeTransaction();
			session.clear();
		}catch (HibernateException ex) {
			withDrawTransaction();
			throw ex;
		} finally {
			closeSession();
		}
	}
	
	public static int executeInsUpdDelCreSQLQuery(String sqlQuery, Object ... params) throws Exception{
		try{
			beginOperation();
			Session s = getSession();
	    	SQLQuery q = s.createSQLQuery(sqlQuery);
	    	for(int i = 0; i < params.length; i++){
	    		q.setParameter(i, params[i]);
			}
	    	int l = q.executeUpdate();
	    	madeTransaction();
			s.clear();
	    	return l;
		}catch(Exception e){
   		 	withDrawTransaction();
   		 	throw new HibernateException(e);
	   	}finally{
	   		closeSession();
	   	}
	}
	
	public static void supprimer(Object object) {
		try {
			beginOperation();
			Session session = getSession();
			session.delete(object);
			madeTransaction();
			session.clear();
		}catch (HibernateException ex) {
			withDrawTransaction();
			throw ex;
		} finally {
			closeSession();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List selectionnerPlusieursElements(String request, Object... params) throws HibernateException {
		Session session = getSession();
		Query query = session.createQuery(request);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		List list = query.list(); 
		closeSession();
		return list;
	}
	
	public static Object selectionnerUnElement(String request, Object... params) throws HibernateException{
		Session session = getSession();
		Query query = session.createQuery(request);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		Object obj = query.uniqueResult();
		closeSession();
		return obj;
	}

}
