package kombiuser.param;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;

import beanskombi.KombiUser;

public class ControlParamUtil {
	private static final String ATT_ANCIE_PWD ="passwdac"; 
	private static final String ATT_NEW_PWD ="newpasswd";
	private static final String ATT_VEF_PWD ="veripasswd";
	private static final String ATT_ANC_TEL ="telactuel";
	private static final String ATT_NEW_TEL ="newtel";
	
	private String resultat;
	
	private Map<String , String > erreur = new HashMap<String,String>();
	
	
	public String getResultat() {
		return resultat;
	}


	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


	public Map<String, String> getErreur() {
		return erreur;
	}


	public void setErreur(String val1 , String erreur1) {
		erreur.put(val1, erreur1);
	}


	public KombiUser modifierPwd(HttpServletRequest req ){
		
		String ancienpwd =getValeur(req,ATT_ANCIE_PWD);
		String nouvpwd = getValeur(req,ATT_NEW_PWD);
		String vefiepwd = getValeur(req,ATT_VEF_PWD);
		KombiUser usr = (KombiUser) req.getSession().getAttribute("user");
		KombiUser komuser = new KombiUser();
		
			try{
				verifiertelexistante(ancienpwd);
			}catch(Exception e){
				setErreur(ATT_ANCIE_PWD,e.getMessage());
			}
			
			komuser.setPasswdUser(ancienpwd);
			
			try{
				verifierancipwd(ancienpwd, nouvpwd , vefiepwd, komuser , usr.getIdUser());
			}catch(Exception e){
				setErreur(ATT_NEW_PWD,e.getMessage());
			}
		
			komuser.setPasswdUser(nouvpwd);
			
			if(getErreur().isEmpty()){
				resultat = "mot de passe modifiez avec succes";
			}else{
				resultat = "echec de modification du mot de passe";
			}
			return komuser;
		
	}
	public KombiUser changerTelUser(HttpServletRequest req ){
		
		String anctel = getValeur(req,ATT_ANC_TEL);
		String newtel = getValeur(req,ATT_NEW_TEL);
		KombiUser user = new KombiUser();
		KombiUser kom = (KombiUser) req.getSession().getAttribute("user");

		
		try{
			verifiernewtel(newtel , user , kom.getTelephoneUser() );
		}catch(Exception e){
			setErreur(ATT_NEW_TEL,e.getMessage());
		}
		user.setTelephoneUser(newtel);
		
		if(getErreur().isEmpty()){
			resultat ="mise a jour du numero ok!!!";
		}else{
			resultat = "echec de mise a jour";
		}
		return user;
		
	}

	private void verifiernewtel(String netel , KombiUser komu , String telcour)throws Exception{
		
		komu = usetelExiste(telcour);
		if(netel != null ){
			
			if(komu != null ){
				
				if(netel.length() >= 9 && netel.matches("^\\d+$")){
					//throw new Exception("good");
				}else{
					throw new Exception("numero court ou contient des caracteres indesirable");
				}
			}
		}else{
			throw new Exception("ce champ est obligatoire");
		}
	}
	private static KombiUser usetelExiste(String tel){
		
		KombiUser kom = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.telephoneUser = ? ",tel);
		return kom;
	}
	private void verifiertelexistante(String tel)throws Exception{
		
		if(tel == null ){
			throw new Exception("veillez rempli ce champ");
		}else{
			if(tel.length() > 4){
				//throw new Exception("good");
			}else{
				throw new Exception("mot de trop court");
			}
		}
	}
	private void verifierancipwd(String anciepwd , String newpwd , String vefpwd ,KombiUser kom , int idus)throws Exception{
		
		kom =exiteuser(anciepwd,idus); 
		
		if(newpwd != null && vefpwd != null){
			if(kom != null ){
				
				if(newpwd.equals(vefpwd)){
					//throw new Exception("good");
				}else{
					throw new Exception("mot de passe different");
				}
			}
			
		}else{
			throw new Exception("veillez rempli ce champ");
		}
	}
	
	private static KombiUser exiteuser(String val , int iduser){
		
		KombiUser kom = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.idUser = ? AND us.passwdUser= MD5(?)",iduser, val);
		return kom;
		
	}
	
	private static String getValeur(HttpServletRequest req , String valeur){
		
		String val = req.getParameter(valeur);
		
		if(val != null){
			return val.trim();
		}else{
			return null;
		}
	}

}
