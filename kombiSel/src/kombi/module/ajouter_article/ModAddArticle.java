package kombi.module.ajouter_article;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.module.myarticles.ModMyArticlesUtil;
import kombi.util.KombiConstants;
import beanskombi.Article;
import beanskombi.KombiUser;
import beanskombi.MettreArticle;
import beanskombi.MettreArticlePK;

public class ModAddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SOUS_CATEGORIE = "sous_categorieAjout";
	
    public ModAddArticle() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dispacher = "/module/import/import.jsp";
		KombiUser user = (KombiUser) request.getSession().getAttribute("user");
		String action = request.getParameter("action");		
		request.setAttribute("jsp_article", "/module/mesarticles/mes_articles.jsp");
		//System.out.println(user.getGroupe().getNomGroupe());
		if (action != null && action.equals(SOUS_CATEGORIE)) {
			System.out.println(request.getParameter("idCategorie"));
			int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
			request.setAttribute("sousCate", ModAddArticleUtil.getSousCategorieById(idCategorie));
			dispacher = "/module/import/sous_categorie.jsp";
		}
		if ((user != null) && (user.getGroupe().getIdGroupe() < (KombiConstants.KOMBI_GROUPE_MODERATEUR))) {
			dispacher = "/module/import/import.jsp";
			request.setAttribute("jsp_article", "/module/import/import.jsp");
			//System.out.println(ModAddArticleUtil.getAllCategories());
			request.setAttribute("categories", ModAddArticleUtil.getAllCategories());
			request.setAttribute("sousCategorie", ModAddArticleUtil.getAllSousCategories());
		}
		 //request.setAttribute("sousCate", ModAddArticleUtil.getAllSousCategories());
	
		 request.setAttribute("categorie",ModAddArticleUtil.getAllCategories());	     
		this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dispacher = "/module/import/import.jsp";
		
        VerifieAjout verif = new VerifieAjout();
        String rapport = null;
        Article art = new Article();
        art = verif.verifieForm(request);
        System.out.println("Votre article est : " + art.getNomArticle());
        request.setAttribute("art", art);
        request.setAttribute("verif", verif);
        System.out.println("le resultat de la verification est : " + verif.getResultat());
        if (verif.getResultat().equals("Succes")) {
        	try {
        	art.setStatusArticle(KombiConstants.ACTIVED_ARTICLE);
        	request.setAttribute("jsp_article", "/module/import/import.jsp");
            System.out.println("Maintenant j'essaye de sauvegarder");
            KombiUser user = (KombiUser) request.getSession().getAttribute("user");            
            Article art_up = (Article) KombiCrudDao.sauvegarderOuMettreAJour(art);
            System.out.println(user);
            MettreArticle mettreArticle = new MettreArticle();
            MettreArticlePK maPK = new MettreArticlePK();
            
            maPK.setIdArticle(art_up.getIdArticle());
            maPK.setIdUser(user.getIdUser());
            mettreArticle.setMettreArticlePK(maPK);
            mettreArticle.setArticle(art_up);
            mettreArticle.setKombiUser(user);
            mettreArticle.setDateMiseEnLigne(new Date());
            KombiCrudDao.sauvegarder(mettreArticle);
            
            // Sauvegarde de l'action dans l'historique
            String action = "Enregistrement de l'Article de titre " + art.getNomArticle();
            KombiConstants.sauvegarderAction(user, action);
             rapport = "Votre article a bien ete ajouter";
        	}catch (Exception e) {
        		rapport = "une erreur s'est produite au cours de la sauvegarde veuillez réessayer plutard";        	
        		e.printStackTrace();
        	}
        }
        request.setAttribute("rapport", rapport);                	
        request.setAttribute("categorie", ModAddArticleUtil.getAllCategories());
        this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
    
	}

}
