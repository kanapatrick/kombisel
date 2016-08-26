package kombi.categorie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import beanskombi.Categorie;

public class SuprimerCategorie extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_CAT = "categorie";
	private static final String VUE_SUP = "/gestionespace";
	
	
	public void doGet(HttpServletRequest req , HttpServletResponse rep)throws IOException , ServletException{
		
		String resultat = null;
		
		System.out.println(req.getParameter(ATT_CAT));
		
		int idcat = Integer.parseInt(req.getParameter(ATT_CAT));
		
		System.out.print(idcat);
		
		Categorie cat = ModifierCatUtil.renvoieCatSelect(idcat);
	
		System.out.print(cat);
		if(cat != null ){
			
			KombiCrudDao.supprimer(cat);
			
			req.setAttribute("cat", cat);
		}else{
			resultat = " aucun element selectionner ";
			
		}
		
	
		
		this.getServletContext().getRequestDispatcher(VUE_SUP).forward(req, rep);
		
	}
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException , ServletException{
		
	}

}
