package kombi.inscription;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kombi.dao.KombiCrudDao;
import beanskombi.KombiUser;

public class InscriptionUserUtil {
	
	private static final String CHAMP_NOMUSER ="nomuser";
	private static final String CHAMP_PRENOMUSER ="prenomuser";
	private static final String CHAMP_PSEUDOUSER ="pseudo";
	private static final String CHAMP_MOTPASSUSER ="motpasse";
	private static final String CHAMP_CONFMOTPASSEUSER ="confmotpasse";
	private static final String CHAMP_EMAILUSER ="emailuser";
	private static final String CHAMP_TELEPHONEUSER ="telephoneuser";
	private static final String CHAMP_ADRESSE ="adresse";


	
	public String resultat;
	public Map<String,String> erreurs = new HashMap<String,String>();
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public void setErreurs(String champ1 , String champ2) {
		erreurs.put(champ1, champ2);
	}
	

	public KombiUser getTraitementInscrire(HttpServletRequest req){
			String nomuser = getValeur(req,CHAMP_NOMUSER);
			String prenomuser = getValeur(req,CHAMP_PRENOMUSER);
			String pseudouser = getValeur(req,CHAMP_PSEUDOUSER);
			String motpasseuser = getValeur(req,CHAMP_MOTPASSUSER);
			String confmotpasseuser = getValeur(req,CHAMP_CONFMOTPASSEUSER);
			String emailuser = getValeur(req,CHAMP_EMAILUSER);
			String telephoneuser = getValeur(req,CHAMP_TELEPHONEUSER);
			String adresse = getValeur(req,CHAMP_ADRESSE);
			KombiUser kombi = new KombiUser();
			
		
			try{
				verifierNomUser(nomuser);
			}catch(Exception e){
				
				setErreurs(CHAMP_NOMUSER,e.getMessage());
			}
				kombi.setNomUser(nomuser);
				
			try{
				verifierPrenomUser(prenomuser);
			}catch(Exception e){
				setErreurs(CHAMP_PRENOMUSER,e.getMessage());
			}
				kombi.setPrenomUser(prenomuser);
			
			try{
				verifierPseudo(pseudouser , kombi);
			}catch(Exception e){
				setErreurs(CHAMP_PSEUDOUSER,pseudouser);
			}
				kombi.setPseudo(pseudouser);
				
			try{
				verifierPassWord(motpasseuser,confmotpasseuser);
			}catch(Exception e ){
				setErreurs(CHAMP_MOTPASSUSER,e.getMessage());
				setErreurs(CHAMP_CONFMOTPASSEUSER,null);
			}
			kombi.setPasswdUser(motpasseuser);
			
			try{
				verifierEmail(emailuser,kombi);
			}catch(Exception e){
				setErreurs(CHAMP_EMAILUSER,e.getMessage());
	
			}
			
			kombi.setEmailUser(emailuser);
			
			try{
				verifierTelUser(telephoneuser , kombi);
			}catch(Exception e){
				setErreurs(CHAMP_TELEPHONEUSER,e.getMessage());
			}
			kombi.setTelephoneUser(telephoneuser);
			
			try{
				verifierAdresse(adresse);
			}catch(Exception e){
				
				setErreurs(CHAMP_ADRESSE,e.getMessage());
			}
			
			kombi.setAddresse(adresse);
			
			if(!getErreurs().isEmpty()){
				resultat = "echec d'inscription ";
			}else{
				resultat = "inscription reussie";
			}
			
			
			
		return kombi;
		
	}
	
	private String getValeur(HttpServletRequest request , String champ ){
		
		String champ1 = request.getParameter(champ);
		
		if(champ1 == null || champ1.trim().length() == 0){
			return null;
		}else{
			return champ1.trim();
		}
	}
	
	
	private void verifierAdresse(String adres)throws Exception{
		
		if(adres == null ){
			throw new Exception("ce champ est obligatoire");
		}else{
			if(adres.length() < 6){
				throw new Exception("adresse trop courte");
			}
		}
	}
	private void verifierNomUser(String nomuser)throws Exception{
		
		if(nomuser != null ){
			
			if(nomuser.length() >= 3){
				if(nomuser.matches("[a-zA-Z0-9 ]+")){
					//throw new Exception("goute");
				}else{
					
					throw new Exception("ce champ contient des caracteres indesirable");
				}
			}else{
				
				throw new Exception("nom trop court");
			}
		}else{
			throw new Exception("ce champ est obligatiore");
		}
	}
	
	private void verifierPrenomUser(String prenomuser)throws Exception{
		
			
			if(prenomuser.length() >= 3){
				
				if(prenomuser.matches("[a-zA-Z0-9 ]+")){
					//throw new Exception("goute");
				}else{
					throw new Exception("ce champ contient des caracteres indesirable");
					}
			}else{
				throw new Exception("prenom trop court");

			}
		
	}
	
	private void verifierPseudo(String pseudo, KombiUser user) throws Exception{
		
			user = ExisteDejaP(pseudo);
			
			if(pseudo == null ){
				throw new Exception("ce champ est obligatiore");
					
				}else{
				
					if(user == null){
						
						if( pseudo.length() > 3 && pseudo.matches("[a-zA-Z0-9 ]+")){
							//throw new Exception("goute");
						}else{
							throw new Exception("trop court ou contient des caracteres indesirable");
							}
				}else{
					
					throw new Exception("ce pseudo est déjà occupé");

				}

				}
			}
	
	private void verifierPassWord(String password , String confpasswd )throws Exception{
		
		
		if(password  == null  &&  confpasswd == null ){
			
			throw new Exception("ce champ est obligatiore");
				
			}else{
				
				if(password.length() >= 4 && confpasswd.length() >=4 ){
					
					if(password.equals(confpasswd)){
						//throw new Exception("goute");
					}else{
						throw new Exception("mot de passe different");
					}
					
				}else{
					throw new Exception("mot de passe trop court");
				}
		
			
		}
	}
	
	
	private void verifierEmail(String email , KombiUser user )throws Exception{
		
		user = ExisteDejaM(email);
		
		if(email == null ){
			throw new Exception("ce champ est obligatiore");
		
			
		}else{
			if(user == null){
				if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")){
					throw new Exception("email invalide");
				}
			}else{
				throw new Exception("cet adresse email est deja associe a quelque d autre");
			}
		}
	}
	
	private void verifierTelUser(String teluser , KombiUser user )throws Exception{
		
		user = ExisteDejaN(teluser);
		if(teluser == null){
			throw new Exception("ce champ est obligatoire");
			
		}else{
			if(user == null ){
				
				if(!teluser.matches("^\\d+$")){
					throw new Exception("ce champ de doit conteni que des chiffre");
				}else if(teluser.length() < 9){
					throw new Exception("ce champ doit conteni au moins 9 chiffres");
				}else{
					//throw new Exception("goute");
				}
			}else{
				
				throw new Exception("ce numero est deja associe a quelqu'un d autre");
			}
		}
	}
	
	public KombiUser ExisteDejaP(String nom ){
		
		KombiUser user = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.pseudo =MD5(?)" , nom);
		return user;
		
	}
	public KombiUser ExisteDejaN(String nom ){
		
		KombiUser user = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.telephoneUser = ? " , nom);
		return user;
		
	}
	
	public KombiUser ExisteDejaM(String nom){
		
		KombiUser user = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.emailUser = ? ", nom);
		 
		return user;
		
	}
}


