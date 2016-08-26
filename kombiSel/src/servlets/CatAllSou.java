package servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kombi.Gestion.GestionUtil;

@SuppressWarnings("serial")
public class CatAllSou extends HttpServlet {
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{	
		
		req.setAttribute("categorie", GestionUtil.getALLCategorie());
		req.setAttribute("souscatlist", GestionUtil.getAllSousCate());
		this.getServletContext().getRequestDispatcher("/module/categorie/touscategorie.jsp").forward(req, rep);
	}

}
