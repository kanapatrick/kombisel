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

@SuppressWarnings("serial")
public class SousCatConsult extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int action = Integer.parseInt(req.getParameter("action"));
		@SuppressWarnings("unchecked")
		List<Article> list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar");
		List<Article> listart = new ArrayList<Article>();
		
		if(list != null ){
			
			for(int i =0 ; i < list.size() ; i++){
				if(list.get(i).getSousCategorie().getIdSousCategorie() == action ){
				listart.add(list.get(i));
				System.out.println("sous-cat :"+list.get(i));
				}
			}
		}
		
		String resultat = "Aucun article de cette sous-catégorie n'est disponible pour le momment!!!";
		req.setAttribute("resultat", resultat);
		req.setAttribute("listart", listart);
		req.getServletContext().getRequestDispatcher("/importFile/recherche.jsp").forward(req, resp);
		
	}

}
