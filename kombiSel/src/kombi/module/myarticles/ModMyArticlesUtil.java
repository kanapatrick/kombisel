package kombi.module.myarticles;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Article;
import beanskombi.Categorie;
import beanskombi.ProduitPromotion;
import beanskombi.Promotion;
import beanskombi.SousCategorie;

/**
 * @author MAX LE BLEU
 *
 */
public class ModMyArticlesUtil {

	public ModMyArticlesUtil() {
	
	}
	@SuppressWarnings("rawtypes")
	public static ArrayList<Article> getAllArticles() {
		ArrayList<Article> art = new ArrayList<Article>();
		
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar");
		if (list != null) {
			for (Object o : list) {
				Article article = (Article) o;
				if (article.getQuantite() > 0) {
					art.add(article);
				}				
			}
			return art;
		}
		return null;		
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Article> getAllActivedArticles() {
		ArrayList<Article> art = new ArrayList<Article>();
		//List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar, Promotion pr WHERE ar.statusArticle = ? AND ar.idArticle <> pr.idArticle.idArticle", KombiConstants.ACTIVED_ARTICLE);
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar WHERE ar.statusArticle = ?", KombiConstants.ACTIVED_ARTICLE);
		if (list != null) {
			for (Object o : list) {
				Article article = (Article) o;
				if (article.getQuantite() > 0) {
					art.add(article);
				}				
			}
			return art;
		}
		return null;		
	}		
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public static ArrayList<Article> getArticlesPasEnPromotion() {
		ArrayList<Article> art = new ArrayList<Article>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar, ProduitPromotion pp WHERE ar.statusArticle = ? AND ar.idArticle NOT IN pp.article.idArticle", KombiConstants.ACTIVED_ARTICLE);
			if (list != null) {
			for (Object o : list) {
				Article article = (Article) o;
				if (article.getQuantite() > 0) {
					art.add(article);
				}				
			}
			return art;
		}
		return null;		
	}	
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Promotion> getAllPromotion() {
		ArrayList<Promotion> promotion = new ArrayList<Promotion>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT pr FROM Promotion pr");		
		if (list != null) {
			for (Object o : list) {
				promotion.add((Promotion) o);				
			}
			return promotion;
		}
		return null;		
	}		
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<ProduitPromotion> getProduitPromotionEnCours() {
		ArrayList<ProduitPromotion> art = new ArrayList<ProduitPromotion>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT pp FROM ProduitPromotion pp WHERE pp.article.statusArticle = ?", KombiConstants.ACTIVED_ARTICLE);
			if (list != null) {
				ProduitPromotion pPromo = new ProduitPromotion();
			for (Object o : list) 
				pPromo = (ProduitPromotion) o;			 	
				if (pPromo.getPromotion().getDateFin().after(new Date())) {
					art.add(pPromo);
				}				
			
			return art;
		}
		return null;		
	}		

	
	
		@SuppressWarnings("rawtypes")
		public static ArrayList<Categorie> getAllCategorie(){
			
	       List catego = KombiCrudDao.selectionnerPlusieursElements("SELECT c FROM Categorie c");
	       ArrayList<Categorie> cate = new ArrayList<Categorie>();


		     if(catego != null ){
		        	
		        	for(Object ca : catego){
		        		cate.add((Categorie) ca);
		        	}
		        
		        	
		        }
		     
			return cate;
			
		}
		
		@SuppressWarnings("rawtypes")
		public static ArrayList<SousCategorie> getAllSousCategorie(){
			
			 List sous_cat = KombiCrudDao.selectionnerPlusieursElements("SELECT s FROM SousCategorie s");
			 
		     ArrayList<SousCategorie> souscat = new ArrayList<SousCategorie>();
		     
		     if(sous_cat != null){
		        	
		        	for(Object soca : sous_cat ){
		        		souscat.add((SousCategorie) soca);
		        	}
		        }
		     
			
			return souscat;
			
		}

		@SuppressWarnings("rawtypes")
		public static Map<String , ArrayList<Article>> getAllArticleByCategorie(){
			
			List list = KombiCrudDao.selectionnerPlusieursElements("SELECT ar FROM Article ar");
			
		    List catego = KombiCrudDao.selectionnerPlusieursElements("SELECT s FROM SousCategorie s");
		    
		    ArrayList<SousCategorie> ca = new ArrayList<SousCategorie>();
		    ArrayList<Article> art = new ArrayList<Article>();
		    ArrayList<Article> arti = new ArrayList<Article>();
		    Map<String , ArrayList<Article>>  catarticle = new HashMap<String,ArrayList<Article>>();
		    
		    if(list != null && catego != null){
		    	
		    	for(Object o : list){
		    		art.add((Article)o);
		    	}
		    	
		    	for(Object at: catego){
		    		ca.add((SousCategorie) at);
		    	}
		    	
		    
		    	
		        for(int i=0 ; i< ca.size() ; i++){
			    	
			    	for(int j =0 ; j < art.size() ; j++){
			    		
			    		if(ca.get(i).getIdCategorie() == art.get(j).getSousCategorie().getIdCategorie()){
			    		
			    				arti.add(art.get(j));
			    				
			    				catarticle.put(ca.get(i).getNomSousCategorie(), arti);
			    		
			    		}
			    	
			    	}
			    }
		    }		    					
			return  catarticle;			
		}
	}


