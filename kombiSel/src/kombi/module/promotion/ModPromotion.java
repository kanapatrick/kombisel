package kombi.module.promotion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.module.ajouter_article.ModAddArticleUtil;
import kombi.module.myarticles.ModMyArticlesUtil;
import kombi.module.panier.ModPanierUtil;
import kombi.util.KombiConstants;

import beanskombi.Article;
import beanskombi.KombiUser;
import beanskombi.MettreEnPromotion;
import beanskombi.ProduitPromotion;
import beanskombi.Promotion;

public class ModPromotion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD_PROMOTION = "ajouter_promotion";
	private static final String CREATE_PROMOTION = "creer_promotion";
	private static final String SOUS_CATEGORIE = "sous_categoriePromotion";
	private static final String SOUS_ARTICLE = "sous_article", CREATE_PROMO = "creer_promo";
       
   public ModPromotion() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dispacher = "/accueil";
		KombiUser user = (KombiUser) request.getSession().getAttribute("user");
		String action = request.getParameter("action");
		String rapport = null;
		if (user != null) {
		if (action != null && action.equals(SOUS_ARTICLE)) {
			int idSousCat;
			System.out.println("Je s8 dja entree");			
			try {
				 idSousCat = Integer.parseInt(request.getParameter("idArticle"));
				 request.setAttribute("articles", ModPromotionUtil.getArticleBySousCategorieId(idSousCat));
				 System.out.println(ModPromotionUtil.getArticleBySousCategorieId(idSousCat) +" et " + idSousCat);				 
			}catch (Exception e) {
				e.printStackTrace();
			}
			dispacher = "/module/ajouter_promotion/list_article.jsp";
			
		}
		if (action != null && action.equals(SOUS_CATEGORIE)) {
			System.out.println(request.getParameter("idCategorie"));
			int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
			request.setAttribute("sousCategorie", ModAddArticleUtil.getSousCategorieById(idCategorie));
			dispacher = "/module/ajouter_promotion/sous_categorie_promotion.jsp";
		}
		
		if (user != null && user.getGroupe().getIdGroupe().equals(KombiConstants.KOMBI_GROUPE_ADMIN)) {					
			if (action != null && action.equals(ADD_PROMOTION)) {
				request.setAttribute("categorie", ModAddArticleUtil.getAllCategories());
				request.setAttribute("promotion", ModPromotionUtil.getPromotionEnCours());
				//request.setAttribute("sousCategorie", ModAddArticleUtil.getAllSousCategories());
				dispacher = "/module/ajouter_promotion/ajouter_promotion.jsp";
			}
			if (action != null && action.equals(CREATE_PROMOTION)) {
				//request.setAttribute("pro", promo);
				request.setAttribute("articles", ModPromotionUtil.getAllArticle());
				dispacher = "/module/ajouter_promotion/creer_promotion.jsp";
			}			
		}
		request.setAttribute("rapport", rapport);
		this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
		}
		else 
			response.sendRedirect(request.getContextPath() + "/index");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dispacher = "/WEB-INF/index.jsp";
		String rapport = "Une erreur est survenu lors de l'enregistrement";
		String action =request.getParameter("action");
		VerifiePromotion verifiePromo = new VerifiePromotion();
		System.out.println("l'action est :"+ action);
		KombiUser user = (KombiUser) request.getSession().getAttribute("user");
		if(action != null && !action.isEmpty()&& action.equals(CREATE_PROMO)) {
			Promotion promo = verifiePromo.verifieForm(request);
			dispacher = "/module/ajouter_promotion/creer_promotion.jsp";
			request.setAttribute("verif", verifiePromo);
			request.setAttribute("pro", promo);
			if (verifiePromo.getResultat() == "Succes") {
			try {
				System.out.println("Tentative de sauvegarde");
				promo.setDateDebut(new Date());
				Promotion pro = (Promotion) KombiCrudDao.sauvegarderOuMettreAJour(promo);			
				
				// Mise a jour de l'historique
				String saveArticle = "creation d'une promotion avec " + pro.getReduction()+ "% de reduction";
				KombiConstants.sauvegarderAction(user, saveArticle);				
				rapport = "Enregistrement reussie";
			}catch (Exception e) {
				rapport = "Une erreur est survenu lors de la sauvegarde veuillez réessayer plutard";				
			}
		}
		else {
			System.out.println("Tentative de sauvegarde echoué");
			rapport = "Une erreur est survenu lors de la sauvegarde veuillez réessayer plutard";
		}
	}
		
		if(action != null && !action.isEmpty()&& action.equals(ADD_PROMOTION)) {
			try {
				System.out.println("Test de l'ajout");
			ProduitPromotion produitPromo = new ProduitPromotion();
			int idArt = Integer.parseInt(request.getParameter("article"));
			int idPromo = Integer.parseInt(request.getParameter("promotion"));
			int qte = Integer.parseInt(request.getParameter("quantite"));
			Article art = ModPanierUtil.getArticleById(idArt);
			if (idArt != 0 && idPromo != 0 && art.getQuantite() >= qte) {
				produitPromo.setArticle(art);
				produitPromo.setPromotion(ModPromotionUtil.getPromotionById(idPromo));
				produitPromo.setQuantitePromotion(qte);
				KombiCrudDao.sauvegarderOuMettreAJour(produitPromo);
				rapport = "Mise en Promotion Reussie";
			}
			else 
				rapport =" la Quantite entrée est trop grande la valeur Max est"+ art.getQuantite();
			}catch (Exception e) {
				e.printStackTrace();
				rapport =" Une erreur est survenue lors de l'enregistrement veuillez réessayer plutard";
			}
			dispacher = "/module/ajouter_promotion/ajouter_promotion.jsp";
		}
		
		request.setAttribute("rapport", rapport);
		request.setAttribute("categorie", ModAddArticleUtil.getAllCategories());
		//request.setAttribute("sousCategorie", ModAddArticleUtil.getAllSousCategories());
		dispacher = "/module/ajouter_promotion/ajouter_promotion.jsp";
		
		this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
	}

}
