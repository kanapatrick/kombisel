package kombiuser.param;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;


import beanskombi.KombiUser;

@SuppressWarnings("serial")
public class UserParam extends HttpServlet {
	private static final String VUE_PARAM ="/module/profil/userparam.jsp";
	
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep )throws IOException ,ServletException{
		KombiUser user = (KombiUser) req.getSession().getAttribute("user");
		KombiUser kombi = ProfilUserUtil.getUser(user.getIdUser());
		req.setAttribute("kombi", kombi);
		this.getServletContext().getRequestDispatcher(VUE_PARAM).forward(req, rep);

	}
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException, ServletException{
		
		UserParamUtil form = new UserParamUtil();
		KombiUser user = new KombiUser();
		try{
		user = form.modifierUser(req);
		
		KombiUser user1 = (KombiUser) req.getSession().getAttribute("user");
		user1.setPseudo(user.getPseudo());
		user1.setEmailUser(user.getEmailUser());
		
		System.out.print(form.getErreur());
		
		if(form.getErreur().isEmpty() && user != null){
			
				System.out.println("mise a jour en cours");
				
				KombiCrudDao.MettreAJour(user1);
				
				System.out.println("mise a jour ok");
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		req.setAttribute("user", user);
		req.setAttribute("form", form);
		this.getServletContext().getRequestDispatcher(VUE_PARAM).forward(req, rep);
	}
}
