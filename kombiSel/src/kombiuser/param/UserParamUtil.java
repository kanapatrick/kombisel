package kombiuser.param;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;

import beanskombi.KombiUser;

public class UserParamUtil {

	private static final String CHMP_PSEUDO ="pseudouser";
	private static final String CHMP_EMAIL = "emailuser";
	private String resultat;
	private Map<String,String> erreur = new HashMap<String,String>();
	
	public KombiUser modifierUser(HttpServletRequest req){
		String pseudo = getValeur(req,CHMP_PSEUDO);
		String email = getValeur(req,CHMP_EMAIL);
		
		KombiUser usekom = new KombiUser();
		
		try{
			verifierPseudo(pseudo,usekom);
		}catch(Exception e){
			setErreur(CHMP_PSEUDO,e.getMessage());
		}
		usekom.setPseudo(pseudo);
		
		try{
			verifierEmail(email,usekom);
		}catch(Exception e){
			setErreur(CHMP_EMAIL,e.getMessage());
		}
		
		usekom.setEmailUser(email);
		
		if(getErreur().isEmpty()){
			resultat = "modification ok";
					
		}else{
			resultat = "echec de modification";
		}
		return usekom;
		
	}
	
	private void verifierEmail(String emai , KombiUser kombi)throws Exception{
		
		kombi = existeEmail(emai);
		
		if(emai == null ){
			throw new Exception("ce champ est obligatoire");
		}else{
			
			if(kombi == null){
					if(!emai.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
					
					throw new Exception("email invalide ");
				}
				//throw new Exception("good");
			}else{
				throw new Exception("email deja occupé");
			}
		}
	}

	private void verifierPseudo(String val , KombiUser user)throws Exception{
		
		user = existePseudo(val);
		
		if(val == null ){
			throw new Exception("veillez rempli ce champ");
		}else{
			if(user == null){
				/*if(val.matches("[a-z A-Z 0-9]")){
					//throw new Exception("ce champ contient des caracteres invalides");
				}else{
					throw new Exception("ce champ contient des caracteres invalides");
				} */
			}else{
				
				throw new Exception("pseudo deja occupé");
			}
		}
	}
	private static KombiUser existePseudo(String pseu){
		
		KombiUser kom = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.pseudo = MD5(?)",pseu);
		
		return kom;
	}
	
	private static KombiUser existeEmail(String email){
		KombiUser kom = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.emailUser =?", email);
		
		return kom;
	}
	public static String getValeur(HttpServletRequest req , String valeur){
		
		String val = req.getParameter(valeur);
		if(val != null ){
			return val.trim();
		}else{
			return null;
		}
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

	public void setErreur(String erreur1, String erreur2) {
		erreur.put(erreur1, erreur2);
	}
}
