package kombi.categorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanskombi.Categorie;
import beanskombi.SousCategorie;

public class Test extends HttpServlet {
	
	private static final String CHAMP_TEST = "/WEB-INF/test.jsp";

	protected void doGet(HttpServletRequest req , HttpServletResponse rep)throws IOException , ServletException{
		
		Map<Categorie , ArrayList<SousCategorie> > listsous = SousCategorieUtil.getAllSousCate();
		
		System.out.println(listsous);
		
		req.setAttribute("listsous",listsous);
		this.getServletContext().getRequestDispatcher(CHAMP_TEST).forward(req, rep);
	}
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep)throws IOException , ServletException{
		
		
	}
}
