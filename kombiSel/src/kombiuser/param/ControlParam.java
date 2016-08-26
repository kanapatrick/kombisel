package kombiuser.param;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;

import beanskombi.KombiUser;



@SuppressWarnings("serial")
public class ControlParam extends HttpServlet{
	
	private static final String ATT_ACTION ="action";
	private static final String VUE_PWD ="/module/profil/changepasswd.jsp"; 
	private static final String VUE_TEL ="/module/profil/changetel.jsp";
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep)throws IOException,ServletException{
		
		String action = req.getParameter(ATT_ACTION);
		
		if(action != null && action.equals("passwd")){
			
			this.getServletContext().getRequestDispatcher(VUE_PWD).forward(req, rep);
		}
		
		if(action != null && action.equals("mobile")){
			
			this.getServletContext().getRequestDispatcher(VUE_TEL).forward(req, rep);
			
		}
		
	}
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException ,ServletException{
		
		ControlParamUtil  form = new ControlParamUtil();
		
		String action = req.getParameter("changePwd");
		
		String action1 = req.getParameter("mobile");
		
		KombiUser  user = new KombiUser(); 
		System.out.println(action+" "+action1);
		if( action != null && action.equals("pwd")){
			
		try{
			user = form.modifierPwd(req);
			
			KombiUser user1 = (KombiUser) req.getSession().getAttribute("user");
			
			user1.setPasswdUser(user.getPasswdUser());
			System.out.println(form.getErreur());
			if(form.getErreur().isEmpty()){
				
				System.out.println("modif du passwd en cour");
				//KombiCrudDao.MettreAJour(user1);
				KombiCrudDao.executeInsUpdDelCreSQLQuery("UPDATE kombi_user SET passwd_user = MD5('"+user.getPasswdUser() +"') WHERE id_user =?",user1.getIdUser());
				System.out.println("modif ok");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		req.setAttribute("form", form);
		this.getServletContext().getRequestDispatcher(VUE_PWD).forward(req, rep);
		}
		
		
		
		if(action1 != null && action1.equals("mobil")){
			KombiUser user1 = new KombiUser();
			try{
				user = form.changerTelUser((HttpServletRequest) req);
				user1 = (KombiUser) req.getSession().getAttribute("user");
				
				user1.setTelephoneUser(user.getTelephoneUser());
				System.out.println(form.getErreur());
				if(form.getErreur().isEmpty()){
					System.out.println("mise ajout du tel  en cou");
					KombiCrudDao.executeInsUpdDelCreSQLQuery("UPDATE kombi_user SET telephone_user ='"+user.getTelephoneUser()+"' WHERE id_user = ?", user1.getIdUser());
					System.out.print("mise a jour ok");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			req.setAttribute("user1", user1);
			req.setAttribute("form", form);
			this.getServletContext().getRequestDispatcher(VUE_TEL).forward(req, rep);
		}
	}

}
