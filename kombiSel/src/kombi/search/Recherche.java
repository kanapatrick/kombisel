package kombi.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanskombi.Article;
import kombi.dao.KombiCrudDao;

public class Recherche extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6348991318502806908L;
	private static final String VUE = "/importFile/recherche.jsp"; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		//int action = Integer.parseInt(req.getParameter("action"));
		String nomarticle = req.getParameter("recherchearticle");
		
		@SuppressWarnings("unchecked")
		List<Article> list = KombiCrudDao.selectionnerPlusieursElements( "SELECT a FROM Article a");
		List<Article> listart = new ArrayList<Article>();
		
			if(list != null ){
				
				for(int j =0 ; j <list.size();j++){
					
					if(list.get(j).getNomArticle().toLowerCase().toString().equals(nomarticle) || list.get(j).getNomArticle().toLowerCase().toString().contains(nomarticle)){
						
						listart.add(list.get(j));
						System.out.println("article:"+list.get(j).getNomArticle());
					}
				}
			}
			
			String resultat = "Aucun Article de ce type n'a été trouve !!!!";
			req.setAttribute("resultat", resultat);
			req.setAttribute("listart", listart);
			this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
