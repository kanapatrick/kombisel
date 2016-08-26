package kombi.module.panier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Article;
import beanskombi.ArticleCommande;
import beanskombi.ArticleCommandePK;
import beanskombi.Commande;
import beanskombi.CommandePromotion;
import beanskombi.ConcernePromotion;
import beanskombi.ConcernePromotionPK;
import beanskombi.KombiUser;
import beanskombi.ParticiperPromotion;
import beanskombi.ParticiperPromotionPK;
import beanskombi.ProduitPromotion;


@WebServlet("/ModPanier")
public class ModPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VALIDATE_PANIER = "valider";
	public static final String REMOVE_ARTICLE = "remove";
	public static final String ADD_ARTICLE = "add";
	public static final String PASSER_COMMANDE = "commander";
	public static final String JSP_VALIDATION = "/module/valider/valider_achat.jsp";
	public static final String PREVIEW_VALIDATION = "/module/valider/confirmer_achat.jsp";
	public static final String VALIDER_COMMANDE_PASSER = "validerCommande";
	public static final String CONNEXION_ACHAT = "/erreurconnexion";
	private static final String INCREMENTER_QTE = "incrementer";
    public ModPanier() {
        super();        
    }

	
	@SuppressWarnings({ "unused", "unchecked", "null" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat = "invalide";
		String rapport;		
		
		String dispacher = "/index";
		
		String action = request.getParameter("action");
		
		Article article = new Article();
        KombiUser user = (KombiUser) request.getSession().getAttribute("user");
        
        Map<Article, Integer> listeAchat = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");        
        ArrayList<Article> selectedArticle = (ArrayList<Article>) request.getSession().getAttribute("selectedArticle");
		ArrayList<ProduitPromotion> selectedPromo = (ArrayList<ProduitPromotion>) request.getSession().getAttribute("selectedPromo");
		
		if(action.equals(INCREMENTER_QTE) && action != null && user != null ) {
			int idArticle = Integer.parseInt(request.getParameter("idArticle"));
			Article art = ModPanierUtil.getArticleById(idArticle);
			int qte = Integer.parseInt(request.getParameter("quantite"));
			System.out.println(qte);
			
			if (ModPanierUtil.isAvaiblePromotion(art)) {
				if(ModPanierUtil.getProduitPromotionByArticle(art).getQuantitePromotion() < qte)
					rapport = "Erreur la valeur entrée est trop grande";
				else
					listeAchat.put(art, qte);
			}
			else {
				if (art.getQuantite() < qte)
					rapport = "Erreur la valeur entrée est trop grande";
				else
					listeAchat.put(art, qte);
			}
			System.out.println(listeAchat);
    		dispacher = JSP_VALIDATION;
    	}

        if ((action != null) && (action.equals(ADD_ARTICLE))) {     
        	
        	int idArticle = Integer.parseInt(request.getParameter("idArticle"));        	
        	listeAchat = ModPanierUtil.addPanier(request, idArticle);   
        	System.out.println(listeAchat);
        	if (listeAchat != null || !listeAchat.isEmpty()) {
        		for (Article a : listeAchat.keySet()) {
	    			article = ModPanierUtil.getArticleById(a.getIdArticle());
	    			if ((ModPanierUtil.isAvaiblePromotion(article)) ) {
	    				if(selectedPromo.contains(ModPanierUtil.getProduitPromotionByArticle(article))) {
	    					System.out.println("j s8 dja dans la liste");
	    				}else {
	    					System.out.println("j s8 pas encore dans la liste");
	    					selectedPromo.add(ModPanierUtil.getProduitPromotionByArticle(article));
	    					System.out.println("Les articles promo sont : ");
	    				}
	    			}
	    			else {
	    				if (selectedArticle.contains(article)) {
	    				}
	    				else {
	    					selectedArticle.add(article);
	    					System.out.println("Les articles max sont : ");
	    				}
	    			}
	    		}    			
    		}
        	dispacher = "/module/valider/panier.jsp";    		
        	resultat = "valide";
        	/*try{
				Thread.sleep(500);
			}catch(Exception e){
				
			}*/        	
        }
        
        if(action.equals(VALIDATE_PANIER) && action != null && user != null ) {   
        	
        	if((listeAchat != null) && (!listeAchat.isEmpty())) {
        		
        		for (Article a : listeAchat.keySet()) {
        			
        			article = ModPanierUtil.getArticleById(a.getIdArticle());
        			
        			if(article != null) {
        				
        				if (ModPanierUtil.isAvaiblePromotion(article)) {
        					
        					ProduitPromotion produitPromo = ModPanierUtil.getProduitPromotionByArticle(article);        				
	        				if(produitPromo.getQuantitePromotion() < listeAchat.get(article)) {
	            				listeAchat.put(article, produitPromo.getQuantitePromotion());
	            				rapport = "La Quantité requise à  été reduite ";
	            			}
	        				//selectedPromo.add(produitPromo);
        				}
        				else if ( !ModPanierUtil.isAvaiblePromotion(article)) {
        					if(article.getQuantite() < listeAchat.get(article)) {
	            				listeAchat.put(article, article.getQuantite());
	            				rapport = "La Quantité requise a été réduite ";
        					}
        					//selectedArticle.add(article);
        				}        			        			        			        			
        			}    			
        		}
        		System.out.println("Validation du panier");        		
        		
        		dispacher = JSP_VALIDATION;
        	}
        }
        	
        	if(action.equals(VALIDATE_PANIER) && action != null && user == null ) {
        		dispacher = JSP_VALIDATION;
        	}
        	if(action.equals(PASSER_COMMANDE) && action != null && user != null ) {        		        		
        		dispacher = PREVIEW_VALIDATION;
        	}
        	if (action.equals(REMOVE_ARTICLE) && action != null) {
        		
        		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
        		
        		Article art = ModPanierUtil.getArticleById(idArticle);
        		
        		listeAchat = ModPanierUtil.removePanier(request, idArticle);
        		
        		if (ModPanierUtil.isAvaiblePromotion(art))
        			
        			selectedPromo.remove(art);
        		else
        			
        			selectedArticle.remove(art);
        			
        	}
        	request.getSession().setAttribute("selectedPromo", selectedPromo);
    		request.getSession().setAttribute("selectedArticle", selectedArticle);
    		request.getSession().setAttribute("listeAchat", listeAchat);
    		this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
        }        	               
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article article = new Article();
		String action = request.getParameter("action");
		String dispacher = CONNEXION_ACHAT;
		String rapport = "Une erreur est survenue lors de l'enregistrement";
		KombiUser user = (KombiUser) request.getSession().getAttribute("user");
        Map<Article, Integer> listeAchat = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");
        ArrayList<Article> selectedArticle = new ArrayList<Article>();
        ArrayList<ProduitPromotion> selectedPromo = new ArrayList<ProduitPromotion>();
        if(action.equals(VALIDATE_PANIER) && action != null && user == null ) {
    		this.getServletContext().getRequestDispatcher(CONNEXION_ACHAT).forward(request, response);
    	}
        

		if(action != null && action.equals(PASSER_COMMANDE) && user != null) {
    		listeAchat = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");
    		double prixTotalArticle = 0, prixTotalPromo = 0;
    		if (listeAchat != null && !listeAchat.isEmpty()) {    	
    			
        		for (Article a : listeAchat.keySet()) {
        			article = ModPanierUtil.getArticleById(a.getIdArticle());
        			if (ModPanierUtil.isAvaiblePromotion(article)) {        				
        				ProduitPromotion produitPromo = ModPanierUtil.getProduitPromotionByArticle(article);
        				
        				int nbrePromo = Integer.parseInt(request.getParameter(""+produitPromo.getArticle().getIdArticle()));
        				listeAchat.put(produitPromo.getArticle(), nbrePromo);
        				
        				float prixPromo = ModPanierUtil.getPrixPromo(produitPromo.getPromotion().getReduction(), article); 
        				System.out.println(prixPromo + " et " + article.getPrix());
        				prixTotalPromo = prixTotalPromo + listeAchat.get(article)*prixPromo;
        			}        			
        			if (!ModPanierUtil.isAvaiblePromotion(article)) {
        				int nbre = Integer.parseInt(request.getParameter(""+article.getIdArticle()));
        				System.out.println("la quantite commander est de : "+ nbre);
        				listeAchat.put(article, nbre);
        				prixTotalArticle = prixTotalArticle + (article.getPrix()*listeAchat.get(article));
        			//else
        				//prixTotal = prixTotal + (article.getPrixArticle()*listeAchat.get(article));
        			}
        		}
        		System.out.println(prixTotalPromo);
        		request.setAttribute("prixTotalArticle", prixTotalArticle);
        		request.setAttribute("prixTotalPromo", prixTotalPromo);
    		}        		
    		dispacher = PREVIEW_VALIDATION;
    	}
		
		if(action.equals("commander")){
			
			if(user == null){
				System.out.println("utilisateur absent");
				dispacher=CONNEXION_ACHAT;
			}else{
				
			}
		}
	
	if(action != null && action.equals(VALIDER_COMMANDE_PASSER) && user != null) {
		try {

			listeAchat = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");
			ArrayList<ArticleCommande> listeArticle = new ArrayList<ArticleCommande>();
			ArrayList<ConcernePromotion> listeArticlePromotion = new ArrayList<ConcernePromotion>();
			Commande cmd;		ParticiperPromotion pp;
			ConcernePromotion conPromo;		ArticleCommande artCmd;
			ParticiperPromotionPK ppPK;		CommandePromotion cmdPromotion;					
			
			cmd = new Commande();		 cmdPromotion = new CommandePromotion();
			conPromo = new ConcernePromotion(); artCmd = new ArticleCommande();
			pp = new ParticiperPromotion();		ppPK = new ParticiperPromotionPK();
			ProduitPromotion produitPromo = new ProduitPromotion();
			if (listeAchat != null && !listeAchat.isEmpty()) { 
				
				// Sauvegarde de la commande
				cmd.setDateCommande(new Date());	cmd.setIdUser(user.getIdUser());
				cmd = (Commande) KombiCrudDao.sauvegarderOuMettreAJour(cmd);
				
				// Sauvegarde d'une commande de promotion
				cmdPromotion.setIdUser(user.getIdUser());
				cmdPromotion.setDateCommandePromotion(new Date());
				cmdPromotion = (CommandePromotion) KombiCrudDao.sauvegarderOuMettreAJour(cmdPromotion);
				
	    		for (Article a : listeAchat.keySet()) {
	    			article = ModPanierUtil.getArticleById(a.getIdArticle());
	    			System.out.println(article.getNomArticle() + " et "+ article.getPrix());
	    			
	    			if (article != null) {
	    				if (ModPanierUtil.isAvaiblePromotion(article)) {    					
	    					produitPromo = ModPanierUtil.getProduitPromotionByArticle(article);
	    	    			pp.setKombiUser(user);		pp.setQteReserve(listeAchat.get(article));
	    	    			pp.setParticiperPromotionPK(new ParticiperPromotionPK(user.getIdUser(), produitPromo.getIdProduitPromotion()));
	    	    			pp.setPromotion(produitPromo.getPromotion());  
	    	    			pp = (ParticiperPromotion) KombiCrudDao.sauvegarderOuMettreAJour(pp);
	    	    			System.out.println(cmdPromotion.getIdCommandePromotion()+"c'est lid de la cmd");
	    	    			conPromo.setCommandePromotion(cmdPromotion  );	//conPromo.setIdConcernePromotion(1);
	    					int reduction = ModPanierUtil.getProduitPromotionByArticle(article).getPromotion().getReduction();
	    					conPromo.setPrixUnitairePromotionCmd(ModPanierUtil.getPrixPromo(reduction, article));
	    					conPromo.setQtePromotionCommande(listeAchat.get(article));
	    					conPromo.setConcernePromotionPK(new ConcernePromotionPK(cmdPromotion.getIdCommandePromotion(), ModPanierUtil.getProduitPromotionByArticle(article).getIdProduitPromotion()));
	    					
	    					conPromo = (ConcernePromotion) KombiCrudDao.sauvegarderOuMettreAJour(conPromo);
	    					
	    					produitPromo.setQuantitePromotion(produitPromo.getArticle().getQuantite() - listeAchat.get(produitPromo.getArticle()));
	    					KombiCrudDao.MettreAJour(produitPromo);
	    	    			listeArticlePromotion.add(conPromo);
	    				}
	    				else {    	
	    					
	    					artCmd.setArticle(article);		artCmd.setPrixUnitaire(article.getPrix());
	    					artCmd.setCommande(cmd);		artCmd.setQteCommander(listeAchat.get(article));
	    					artCmd.setArticleCommandePK(new ArticleCommandePK(cmd.getIdCommande(), article.getIdArticle()));
	    					
	    					article.setQuantite((article.getQuantite() - listeAchat.get(article)));
	    					KombiCrudDao.MettreAJour(article);
	    				
	    					artCmd = (ArticleCommande) KombiCrudDao.sauvegarderOuMettreAJour(artCmd);
	    	    			    	    			
	    					listeArticle.add(artCmd);
	    				}
	    			}
	    			
	    		}
	    				
	        			        			      		
	    		cmdPromotion.setConcernePromotionList(listeArticlePromotion);
						    			
				cmd.setArticleCommandeList(listeArticle);					    				    				
	    				
				cmd = (Commande) KombiCrudDao.sauvegarderOuMettreAJour(cmd);
				cmdPromotion = (CommandePromotion) KombiCrudDao.sauvegarderOuMettreAJour(cmdPromotion);
				
				String commande = "Achat de "+cmd.getArticleCommandeList().size()+" Article";
				KombiConstants.sauvegarderAction(user, commande);	    		
	    			
				}    		
					listeAchat.clear();
					ArrayList<Article> liste = (ArrayList<Article>) request.getSession().getAttribute("selectedArticle");
					liste.clear();
					request.getSession().setAttribute("selectedArticle", liste);
					dispacher = "/accueil";
					rapport = "Votre commande a bien ete enregistre";
			
		}catch (Exception e) {
			rapport = "Une erreur est survenue lors de la tentative de sauvegarde";
			e.printStackTrace();
		}
	}    			    		 			
		request.setAttribute("rapport", rapport);
		this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
	}
	
}


