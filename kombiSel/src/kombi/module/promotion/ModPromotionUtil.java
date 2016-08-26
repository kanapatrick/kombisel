package kombi.module.promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kombi.dao.KombiCrudDao;

import beanskombi.Article;
import beanskombi.Promotion;
import beanskombi.SousCategorie;

public class ModPromotionUtil {

	public ModPromotionUtil() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<Promotion> getPromotionEnCours() {
		ArrayList<Promotion> promotion = new ArrayList<Promotion>();
		
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT pr FROM Promotion pr");
		for(Object o: list) {
			Promotion promo = (Promotion) o;
			if(promo.getDateFin().after(new Date()))
				promotion.add(promo);
		}
		return promotion;
	}
	
	public static Promotion getPromotionById(int id) {
		Promotion promo = (Promotion) KombiCrudDao.selectionnerUnElement("SELECT pr FROM Promotion pr WHERE pr.idProduitPromotion = ?", id);
		if (promo != null)
			return promo;
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Article> getAllArticle() {
		ArrayList<Article> articles = new ArrayList<Article>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar");
		for(Object o: list) 
			articles.add((Article)o);
		return articles;
	}

	@SuppressWarnings("rawtypes")
	public static ArrayList<Article> getArticleBySousCategorieId(int idSousCat) {
		ArrayList<Article> articles = new ArrayList<Article>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar, ProduitPromotion pp WHERE ar.idArticle <> pp.article.idArticle AND ar.sousCategorie = ?", new SousCategorie(idSousCat));		
		for (Object o : list)
			articles.add((Article) o);
		return articles;
	}

}
