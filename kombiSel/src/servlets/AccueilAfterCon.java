package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanskombi.Article;
import beanskombi.KombiUser;
import beanskombi.ProduitPromotion;
import kombi.Gestion.GestionUtil;
import kombi.module.myarticles.ModMyArticlesUtil;


public class AccueilAfterCon extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/accueilRes.jsp";
    public static Map<Article, Integer> listeAchat;   
    ArrayList<Article> selectedArticle; 
	ArrayList<ProduitPromotion> selectedPromo;
	
	protected void doGet(HttpServletRequest request , HttpServletResponse rep)throws IOException,ServletException{
		request.setAttribute("jsp_article", "/module/mesarticles/mes_articles.jsp"); 
		if (listeAchat == null) {
			listeAchat  = new HashMap<Article, Integer>();	
			selectedArticle = new ArrayList<Article>();
			selectedPromo = new ArrayList<ProduitPromotion>();
		} 	
		
		System.out.println("le lien est ou.....");
			request.getSession().setAttribute("listeAchat", listeAchat);
	    	request.getSession().setAttribute("selectedArticle", selectedArticle);
	    	request.getSession().setAttribute("selectedPromo", selectedPromo);
		    request.setAttribute("articles",ModMyArticlesUtil.getAllActivedArticles());
			//request.setAttribute("promotion", ModMyArticlesUtil.getProduitPromotionEnCours());
	        request.setAttribute("categorie",  GestionUtil.getALLCategorie());
	        request.setAttribute("sousCategorie", ModMyArticlesUtil.getAllSousCategorie());
	        HttpSession session = request.getSession();
	        Object user = request.getSession().getAttribute("user");
           session.setAttribute("user", user);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, rep);
		//System.out.print("le lien ne marche pas");
	}

	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{
		
		
	}
}
