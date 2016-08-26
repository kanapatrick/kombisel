package kombi.inscription;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Groupe;
import beanskombi.KombiUser;

public class InscriptionUser  extends HttpServlet{
	/**
	 * @author PATRICK KANA
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String VUE = "/WEB-INF/inscription.jsp";
	public static final String ATT_KOMBI_USER = "user"; 
	public static final String ATT_KOMBI_METIER = "form";
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep)throws IOException ,ServletException{
		
		this.getServletContext().getRequestDispatcher(VUE).forward(req, rep);
		
	}
	
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{
			String chemin = "/inscription";
			InscriptionUserUtil form = new  InscriptionUserUtil();
			KombiUser user =  new KombiUser(); //form.getTraitementInscrire(req);
		
		try{
			user = form.getTraitementInscrire(req);
			Groupe usergroupe = new Groupe(KombiConstants.KOMBI_GROUPE_USER);
			user.setGroupe(usergroupe);
			user.setStatusUser(KombiConstants.ACTIVED_USER);
			System.out.println(form.getErreurs());
			
		if(form.getErreurs().isEmpty()){
			System.out.println("sauvegarde en courssssss");
			KombiUser u = (KombiUser) KombiCrudDao.sauvegarderOuMettreAJour(user);
			
			KombiCrudDao.executeInsUpdDelCreSQLQuery("UPDATE kombi_user SET  pseudo= MD5('" + user.getPseudo() + "'), passwd_user= MD5('" + user.getPasswdUser() + "') WHERE id_user = '" + u.getIdUser() + "' ");
			System.out.println("sauvegarde reussie");
			String nom = u.getNomUser();
			
			String prenom = u.getPrenomUser();
			
			String action = "Inscription de Mr/Mme\t:" + prenom  +"  "+nom;
			
			KombiUser user1 =(KombiUser) req.getSession().getAttribute("user");
			
			KombiConstants.sauvegarderAction(user1, action);
		
		}else{
			System.out.println("il y a des problemes  d inscription");
		}
		
		}catch(Exception e){
			
			System.out.println("il y a un probleme de connexion");
			
		}
	
	
	
			//System.out.println("inscription reussi avec succes");
		
			//rep.sendRedirect(req.getContextPath()+chemin);
		req.setAttribute("form", form);
		req.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, rep);
	
		
		
	
	}

}
