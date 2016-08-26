package kombiuser.param;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import beanskombi.KombiUser;

public class ProfilUser extends HttpServlet {
	
	private static final String CHAMP_PROFIL = "/module/profil/profil.jsp";
	
	private static final String ATT_ACTION = "action";
	
	public void doGet(HttpServletRequest req ,HttpServletResponse rep )throws IOException , ServletException{
		
		KombiUser user = (KombiUser) req.getSession().getAttribute("user");
		
		KombiUser kombi = ProfilUserUtil.getUser(user.getIdUser());
		
		String action = req.getParameter(ATT_ACTION);
		
		String resultat , etat = null;
		String resul ;
		
		if(kombi.getStatusUser() == 1){
			
			resultat = "ACTIF";
		
		}else{
			resultat = "INACTIF";
			etat = "inactif";
		}
		/*
		if(action.equals("modif")){
			
			resul = "desactivation en cours...";
			
			try{
				
				KombiCrudDao.executeInsUpdDelCreSQLQuery("UPDATE KombiUser SET status_user = '"+ 0 +"'WHERE id_user = '"+kombi.getStatusUser() +"'");				
			}catch(Exception e){
				
				e.printStackTrace();
			}
				
			
		}*/	
		
		req.setAttribute("resultat", resultat);
		req.setAttribute("etat", etat);
		req.setAttribute("kombi", kombi);
		
		
		
		this.getServletContext().getRequestDispatcher(CHAMP_PROFIL).forward(req, rep);
	}

	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{
		
	
}
}