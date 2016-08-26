package kombi.categorie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;
import beanskombi.Categorie;
import beanskombi.SousCategorie;

public class SousCategorieUtil {
	
	private static final String ATT_CAT ="choix";
	private static final String ATT_SOUS_CAT = "nomsouscat";
	
	private String resultat ;
	
	private Map<String,String> erreur = new HashMap<String ,String >();	
	
	public SousCategorie verifiercreation(HttpServletRequest req){
		
		int choixcat = Integer.parseInt(getValeur(req , ATT_CAT));
		String nomsouscat = getValeur(req , ATT_SOUS_CAT);
		SousCategorie souscat = new SousCategorie();
		
		
		try{
			verifierSouscat(nomsouscat , souscat , choixcat);
		}catch(Exception e){
			
			setErreur(ATT_SOUS_CAT,e.getMessage());
		}
		
		souscat.setNomSousCategorie(nomsouscat);
		
		
		if(getErreur().isEmpty()){
			
			resultat =" creation avec succes"; 
			
		}else{
			
			resultat = "echec de creation ";
		}
		
		
		
		return souscat;
		
	}

	private void verifierSouscat(String souca , SousCategorie souCat , int idcat )throws Exception{
		
		souCat = cherchersous(idcat);
		
		if(souca == null ){
			throw new Exception("ce champ est obligatoire");
		}else{
			
			if(souCat == null ){
				//throw new Exception("good");
			}else{
				throw new Exception("cette sous categorie existe deja ");
			}
			
		}
	}
	
	public SousCategorie cherchersous(int idcat){
		
		SousCategorie soucat = (SousCategorie) KombiCrudDao.selectionnerUnElement("SELECT soca FROM SousCategorie soca WHERE soca.idSousCategorie= ?", idcat);
		
		return soucat;
		
	}
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public Map<String, String> getErreur() {
		return erreur;
	}

	public void setErreur(String champ1, String champ2) {
		erreur.put(champ1, champ2);
	}

	private static String getValeur(HttpServletRequest req , String champ){
		
		String champ1 = req.getParameter(champ);
		
		if(champ1 != null ){
			return champ1;
		}else{
			return null;
		}
	}
	
	public static Map<Categorie, ArrayList<SousCategorie>> getAllSousCate(){
		
		List souscatego = KombiCrudDao.selectionnerPlusieursElements("SELECT s FROM SousCategorie s");
		
		List Catego = KombiCrudDao.selectionnerPlusieursElements("SELECT c FROM Categorie c");
		
		ArrayList<SousCategorie> soucat = new ArrayList<SousCategorie>();
		
		ArrayList<SousCategorie> soucate = new ArrayList<SousCategorie>();
		
		ArrayList<Categorie> cate = new ArrayList<Categorie>();
		
		Map<Categorie , ArrayList<SousCategorie> > resul = new HashMap<Categorie, ArrayList<SousCategorie>>();
		
		
		
		if(souscatego != null && Catego != null ){
			
			for(Object sc : souscatego){
				soucat.add((SousCategorie)sc);
			}
			
			for(Object cat : Catego){
				
				cate.add((Categorie) cat);
			}
		}
		
		System.out.println(cate+"\t\t\t\t\t"+soucat);
		
		for(int i = 0 ; i < cate.size(); i++ ){
			
			for(int j = 0 ; j < soucat.size() ; j++){
				
				soucate.add(soucat.get(j));
				resul.put(cate.get(i), soucate);
			}
		}
		/*
		for(int j =0 ; j<cate.size() ;j++){
			for(int i =0 ; i < soucat.size() ; i++){
				
				if(cate.get(j).getIdCategorie() == soucat.get(i).getIdCategorie()){
					for(int k =0 ; k < soucat.size() ; k++ ){
						
						ArrayList<SousCategorie> succes = new  ArrayList<SousCategorie>();
							
						succes.add(soucat.get(i));
						
						resul.put(cate.get(i), succes );
						
					}
				}
			}
		}*/
	
		return resul;
		
	}
}
