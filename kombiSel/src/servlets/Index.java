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

import kombi.Gestion.GestionUtil;
import kombi.dao.KombiCrudDao;
import kombi.module.myarticles.ModMyArticlesUtil;
import kombi.util.KombiConstants;
import beanskombi.Article;
import beanskombi.Categorie;
import beanskombi.KombiUser;
import beanskombi.ProduitPromotion;





public class Index extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8769419101076099672L;
	//définition des constantes
    public static final String INDEX  = "/WEB-INF/index.jsp";
    public static final String ACCUEIL        = "/accueil";
    public static final String MODERATEUR     = "/WEB-INF/moderateur.jsp";
    public static final String ADMINISTRATEUR = "/WEB-INF/administrateur.jsp";
    public static final String ROOT           = "/WEB-INF/root.jsp";
    private static final String VUE_ERRO = "/WEB-INF/Acconnexion.jsp";
    public static final String ATTR_RESULTAT  = "resultat";
    public static Map<Article, Integer> listeAchat;   
    ArrayList<Article> selectedArticle; 
	ArrayList<ProduitPromotion> selectedPromo;
	
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	request.setAttribute("jsp_article", "/module/mesarticles/mes_articles.jsp");    	
    	if (listeAchat == null) {
			listeAchat  = new HashMap<Article, Integer>();	
			selectedArticle = new ArrayList<Article>();
			selectedPromo = new ArrayList<ProduitPromotion>();
		} 	
    	//ArrayList<ProduitPromotion> promotion = ModMyArticlesUtil.getProduitPromotionEnCours();
    	ArrayList<Article> articles = ModMyArticlesUtil.getArticlesPasEnPromotion();
    	//Promotion promo;    	
    	//Days date = Days.daysBetween(new DateTime(promotion.get(0).getDateMiseEnPromotion()), new DateTime(promotion.get(0).getDateValidite()));
    	//System.out.println(date.getDays());
    	//request.setAttribute("date", date);
    	System.out.print(request.getAttribute("action"));
    	if(request.getParameter("action") != null ){
    		int idart = Integer.parseInt(request.getParameter("action"));
    		System.out.println("ceci est id :"+idart);
        	Article articlecourant = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.idArticle = ?",idart);
        	request.setAttribute("articlecourant", articlecourant);
    	}
    	ArrayList<Categorie> tencate = GestionUtil.getALLCategorie();
    	
    	ArrayList<Categorie> tencat = new ArrayList<Categorie>();
    	
		for(int k = 0,j=0 ; k < 10 && j < tencate.size(); k++ ,j++){
    			tencat.add(tencate.get(j));
    	}
    	System.out.println("les articles son:"+articles);
    	request.getSession().setAttribute("listeAchat", listeAchat);
    	request.getSession().setAttribute("selectedArticle", selectedArticle);
    	request.getSession().setAttribute("selectedPromo", selectedPromo);
    	request.setAttribute("articles",ModMyArticlesUtil.getAllActivedArticles());
		//request.setAttribute("promotion", ModMyArticlesUtil.getProduitPromotionEnCours());
        request.setAttribute("categorie",  GestionUtil.getALLCategorie());
        request.setAttribute("sousCategorie", ModMyArticlesUtil.getAllSousCategorie());
        request.setAttribute("listecats", GestionUtil.getAllSousCate());
        request.setAttribute("listcat", tencat);        
       // request.setAttribute("catarticle", articl);
        this.getServletContext().getRequestDispatcher(INDEX).forward(request, response);
    
    }
    
    /* root 1 administrateur 2 moderateur 3 user 4 */
    
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnexionForm form = new ConnexionForm();
        
        KombiUser user = form.connexion(request);   
    	
        if (user == null) {
            String resultat = "Erreur! le Pseudo ou le mot de passe saisis est invalide";
            request.setAttribute(ATTR_RESULTAT, resultat);
            //response.sendRedirect(request.getContextPath()+VUE_ERRO);
            this.getServletContext().getRequestDispatcher(VUE_ERRO).forward(request, response);
            
        } else {
            
            //on sauvegarde l'action
            String action = "connexion";
            KombiConstants.sauvegarderAction(user, action);
            
            //on le sauvegarde dans la session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("pseudo", request.getParameter("pseudo"));
            session.setAttribute("pseudo", request.getParameter("pseudo"));
            response.sendRedirect(request.getContextPath() + ACCUEIL);
            
        }
    }
}
