package kombi.categorie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Categorie;
import beanskombi.KombiUser;

public class CategorieKombi extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private static final String ATT_VUE = "/module/categorie/creerCat.jsp";
		public static final  String ATT_ID_CATE = "idCategorie";

		protected void doGet(HttpServletRequest req , HttpServletResponse rep)throws IOException, ServletException{
			
			//int idCategorie = Integer.valueOf(req.getParameter("idCategorie")).intValue();
			//System.out.print(idCategorie);
			
			this.getServletContext().getRequestDispatcher(ATT_VUE).forward(req, rep);
		}
		
		protected void doPost(HttpServletRequest req , HttpServletResponse rep)throws ServletException,IOException{
			
			CategorieUtil form = new CategorieUtil();
			Categorie cat = new Categorie();
			
			try{
				cat = form.verifierCategorie(req);
				
				System.out.println(form.getErreur());
				
				if(form.getErreur().isEmpty()){
					
				System.out.println("en cour de sauverggg");
				Categorie ca = (Categorie) KombiCrudDao.sauvegarderOuMettreAJour(cat);
				System.out.println("sauverggg ok...");
				//String nomca = ca.getNomCategorie();
				
				String action = "creation d' categorie";
				
				KombiUser user = (KombiUser) req.getSession().getAttribute("user");
				
				KombiConstants.sauvegarderAction(user, action);
				System.out.println("sauverggg action ok");
				}
				
			}catch(Exception e){
				
				System.out.println("il y a un probleme de creation");
			}
			
			req.setAttribute("form", form);
			req.setAttribute("cat", cat);
			this.getServletContext().getRequestDispatcher(ATT_VUE).forward(req, rep);
		}
}
