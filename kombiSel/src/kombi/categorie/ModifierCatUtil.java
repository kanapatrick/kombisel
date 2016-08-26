package kombi.categorie;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;
import beanskombi.Categorie;

public class ModifierCatUtil {
	
	
	private static final String ATT_NOUV_CAT = "nouveaunomcat" ;
 	
	public String resultat ;
	public Map<String , String > erreur = new HashMap<String , String>();
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Map<String, String> getErreur() {
		return erreur;
	}

	public void setErreur(String erreur1 , String erreur2) {
		
		erreur.put(erreur1, erreur2);
	}

	public Categorie updateCategorie(HttpServletRequest req ){
		
		//String ancnomcat = getValeur(req,ATT_ANCIEN_CAT);
	   String  newnomcat = getValeur(req,ATT_NOUV_CAT);
		//String newName = req.getParameter(ATT_NOUV_CAT);
		Categorie cat = new Categorie();
		
		
		try{
			
			verifierNewcat(newnomcat , cat);
		}catch(Exception e ){
			
			setErreur(ATT_NOUV_CAT,e.getMessage());
		}
		
		cat.setNomCategorie(newnomcat);
		System.out.println(erreur);
		if(!getErreur().isEmpty()){
			resultat = "echec de mise à jour";
		}else{
			resultat = "mise à jour ok";
		}
		
		
		return cat;
		
	}
	
	public static  Categorie renvoieCatSelect( int idcat ){
		
		Categorie cat = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.idCategorie =? ", idcat);
		
		return cat;
		
	}
	
	public static Categorie renvoieNomCat(String nomcat){
		
		Categorie catego = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.nomCategorie = ? ", nomcat);
		
		return catego;
	}

	private static String getValeur(HttpServletRequest req , String vale){
		
		String valeur = req.getParameter(vale);
		if(valeur != null){
			
			return valeur;
		}else{
			return null;
		}
	}
	
	private void verifierNewcat(String catego , Categorie cate)throws Exception {
		
		//cate = verifierExistance(catego);
		Categorie cat = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.nomCategorie =?", catego);
		if(catego == null){
			throw new Exception("ce champ est obligatoire");
		}else{
			
			if(cate == null){
				//throw new Exception("good");
			}else{
				
				throw new Exception("cette categorie existe déjà");
			}
		}
		
	}
	
	public static Categorie verifierExistance(String nomcat){
		
		Categorie cat = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.nomCategorie =?", nomcat);
		
		return cat;
	}
	
	public static void suprimerCat(Categorie cat){
		
			KombiCrudDao.supprimer(cat);
	}
}
