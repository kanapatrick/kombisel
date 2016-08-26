package kombi.Gestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Categorie;
import beanskombi.KombiUser;
import beanskombi.SousCategorie;

public class GestionUtil {

	@SuppressWarnings("rawtypes")
	public static ArrayList<KombiUser> getAllUser(){
		List kom = KombiCrudDao.selectionnerPlusieursElements("SELECT k FROM KombiUser k");
		
		ArrayList<KombiUser> komb = new ArrayList<KombiUser>();
 		
		for(Object u : kom){
			komb.add((KombiUser)u);
		}
		return komb;
		
	}
	
	@SuppressWarnings("rawtypes")
	public  static ArrayList<KombiUser> getOnlyUser(){
		
		List kom = KombiCrudDao.selectionnerPlusieursElements("SELECT us FROM KombiUser us WHERE us.idUser = ? " , KombiConstants.KOMBI_GROUPE_USER);
		
		ArrayList<KombiUser> komb = new ArrayList<KombiUser>();
 		
		for(Object u : kom){
			komb.add((KombiUser)u);
		}
		
		for(int k =0 ; k < komb.size();k++){
			System.out.println(komb.get(k));
		}
	
		return komb;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static  ArrayList<KombiUser> getOnlyModerateur(){
		List kom = KombiCrudDao.selectionnerPlusieursElements("SELECT k FROM KombiUser k WHERE k.idUser = ? ",KombiConstants.KOMBI_GROUPE_MODERATEUR);
		
		ArrayList<KombiUser> komb = new ArrayList<KombiUser>();
 		
		for(Object u : kom){
			komb.add((KombiUser)u);
		}
		return komb;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<KombiUser> getOnlyAdmin(){
		List kom = KombiCrudDao.selectionnerPlusieursElements("SELECT k FROM KombiUser k WHERE k.idUser = ? ",KombiConstants.KOMBIUSER_ADMIN);
		
		ArrayList<KombiUser> komb = new ArrayList<KombiUser>();
 		
		for(Object u : kom){
			komb.add((KombiUser)u);
		}
		return komb;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Categorie> getALLCategorie(){
		List cat = KombiCrudDao.selectionnerPlusieursElements("SELECT ca FROM Categorie ca");
		ArrayList<Categorie> cate = new ArrayList<Categorie>();
		
		for(Object o : cat){
			cate.add((Categorie)o);
		}
		return cate;
		
 	}
	
	@SuppressWarnings({ "rawtypes" })
	public static Map<Categorie , ArrayList<SousCategorie>> getAllSousCate(){
		
		List souscat = KombiCrudDao.selectionnerPlusieursElements("SELECT sc FROM SousCategorie sc");
		
		Map<Categorie , ArrayList<SousCategorie> > catsc = new HashMap<Categorie,ArrayList<SousCategorie>>();
		
		ArrayList<SousCategorie> sct = new ArrayList<SousCategorie>();
		ArrayList<SousCategorie> scto = new ArrayList<SousCategorie>();
		
		
		for(Object o : souscat){
			
			sct.add((SousCategorie)o);
		}
		
		ArrayList<Categorie> cat = getALLCategorie();

		for(int i =0 ; i < cat.size() ; i++){
			for(int j=0 ; j < sct.size();j++){
				ArrayList<SousCategorie> scte = null;
				if(cat.get(i).getIdCategorie() == sct.get(j).getIdCategorie()){
					scte = new ArrayList<SousCategorie>();
					for(int k = 0 ; k < sct.size(); k++){
						
						if(sct.get(k).getIdCategorie() == sct.get(j).getIdCategorie() ){
							
							scte.add(sct.get(k));
						}
							
					}				
					catsc.put(cat.get(i),scte);
					
				}
				
			}

		}
		
		return catsc;
		
		
	}
	
}
