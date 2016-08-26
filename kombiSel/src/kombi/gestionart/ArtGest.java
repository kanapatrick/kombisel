package kombi.gestionart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanskombi.Article;
import kombi.Gestion.GestionUtil;
import kombi.dao.KombiCrudDao;
import kombi.module.myarticles.ModMyArticlesUtil;

public class ArtGest extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = req.getParameter("action");
		
		if(action.equals("modifier")){
			int id = Integer.parseInt(req.getParameter("doc"));
			
			Article art = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.idArticle = ?", id);
			req.setAttribute("categorie",  GestionUtil.getALLCategorie());
	        req.setAttribute("sousCategorie", ModMyArticlesUtil.getAllSousCategorie());
			req.setAttribute("art", art);
			this.getServletContext().getRequestDispatcher("/module/import/modif.jsp").forward(req, resp);
		}
		
		if(action.equals("supprimer")){
			int id = Integer.parseInt(req.getParameter("doc"));
			Article art = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.idArticle = ?", id);
			KombiCrudDao.supprimer(art);
			String result = "Suppression OK";
			req.setAttribute("result", result);
			System.out.println("supression ok");
		}
		
	}

}
