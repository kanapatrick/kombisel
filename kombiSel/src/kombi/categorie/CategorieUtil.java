package kombi.categorie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;
import beanskombi.Categorie;

public class CategorieUtil {
	
	private static final String ATT_CATEGORIE = "nomcat";
	
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

	
	public void setErreur(String val1 , String val2) {
		erreur.put(val1, val2);
	}
	
	public Categorie verifierCategorie(HttpServletRequest req){
		
		String  nomcatego = getValeur(req,ATT_CATEGORIE);
		
		Categorie cat = new Categorie();
		
		
		try{
			verifierNomCat( nomcatego , cat );
			
		}catch(Exception e){
			
			erreur.put(ATT_CATEGORIE, e.getMessage());
			
		}
		
		cat.setNomCategorie(nomcatego);
			
		if( getErreur().isEmpty() ){
			
			resultat =" succes de creation";
			
		}else{
			
			resultat = "echec de creation";
		}
		return cat;
		
			
	}
	
	private void verifierNomCat(String cate , Categorie cat )throws Exception{
		
		cat = verifierexistance(cate);
		
		if(cate == null){
			throw new Exception("vous devez rempli ce champ ");
	
		}else{
			if(cat == null){
				if(cate.length() > 4){ 
					//throw new Exception("good");
					if(cate.matches("[a-z A-Z 0-9 & ]+")){
						
					}else{
						throw new Exception("caractere invalide");
					}
				}else{
					throw new Exception("nom trop court");
				}
				
			}else{
				
				throw new Exception("ce nom de categorie existe deja"); 
			}
		}
	}
	
	public Categorie verifierexistance(String nomcat){
		
		
		Categorie cat = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.nomCategorie=?", nomcat);
	
		return cat;
		
	}
	
	


	public String getValeur(HttpServletRequest req , String valeur){
		
		String val = req.getParameter(valeur);
		
		if(val != null ){
			
			return val.trim();
		}else{
			return null;
		}
     }
	
	public static ArrayList<Categorie> renvoieAllCat(){
			
		List listcate = KombiCrudDao.selectionnerPlusieursElements("SELECT ca FROM Categorie ca");
		
		ArrayList<Categorie> categ = new ArrayList<Categorie>();
		
		for(Object o : listcate){
			
			categ.add((Categorie)o);
		}
		
		return categ;
		
	}
	
}
