package kombi.module.panier;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Article;
import beanskombi.ProduitPromotion;

/**
 * @author MAX LE BLEU
 *
 */
public class ModPanierUtil {
	private static String errors = "";
	
	public String getErrors() {
		return errors;
	}

	public ModPanierUtil() {
		
	}
	
	public static float getPrixPromo(int reduction, Article art) {
		float reduc = 0;
		if (art != null) {
			System.out.println(art.getPrix()+"FCFA" + reduction);
		
			float pourcent =(float) reduction / 100;
			reduc = pourcent*art.getPrix();
			reduc = art.getPrix() - reduc;
			System.out.println(reduc+"Dollar "+ pourcent);
		}
		return reduc;
	}
	public static Article getArticleById(int id) {		
		Article art = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.idArticle = ? AND ar.quantite > ? AND ar.statusArticle = ?", id, 0, KombiConstants.ACTIVED_ARTICLE);					
		return art;
	}
	
	public static ProduitPromotion getProduitPromotionByArticle(Article art) {		
		ProduitPromotion produitPromo = (ProduitPromotion) KombiCrudDao.selectionnerUnElement("SELECT pp FROM ProduitPromotion pp WHERE pp.article = ? ", art);					
		return produitPromo;
	}
	
	public static boolean isAvaiblePromotion(Article article) {
		ProduitPromotion produitPromo = (ProduitPromotion) KombiCrudDao.selectionnerUnElement("SELECT pp FROM ProduitPromotion pp WHERE pp.article = ?", article);
		if (produitPromo != null) 
			return true;
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Article, Integer> addPanier(HttpServletRequest request, int id) {
		Map<Article, Integer> liste = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");
		Article art = getArticleById(id);
		if ((art != null) && (liste != null) ) {									
			boolean param = true;
			int i=0;
			while ( i < liste.size() && !liste.containsKey(art))
				i++;
			 if (liste.containsKey(art) && param == true){
					int qte = (Integer) liste.get(art);
					qte++;
					System.out.println("la taille de la liste est "+ liste.size());
					liste.put(art, qte);
					param = false;
				}			
			if (i >= liste.size() && param == true) {
				liste.put(art, 1);
				System.out.println("la taille de la liste pour la 2e fois est "+ liste.size());
				param = false;
			}
		}
		else
			errors = "L'identifiant de cet Article n'existe pas";
		
		return liste;
	}
		
	@SuppressWarnings("unchecked")
	
	public static Map<Article, Integer> removePanier(HttpServletRequest request, int id) {
		
		Map<Article, Integer> liste = (Map<Article, Integer>) request.getSession().getAttribute("listeAchat");
		
		Article art = getArticleById(id);
		
		if ( art!= null ) {						
			liste.remove(art);				
		}
		else
			errors = "Article d'identifiant inexistant";
		
		return liste;
	}
		
}
