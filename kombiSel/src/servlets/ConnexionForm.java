package servlets;

import javax.servlet.http.HttpServletRequest;

import beanskombi.KombiUser;
import kombi.dao.KombiCrudDao;

public class ConnexionForm {
    //définition des constantes
    //public static final String INDEX              = "/WEB-INF/index.jsp";
    public static final String CHAMP_EMAIL       = "pseudo";
    public static final String CHAMP_MOT_DE_PASSE = "motpasse";
    
    public KombiUser connexion(HttpServletRequest request) {
        //récupération des champs
        String pseudo = request.getParameter(CHAMP_EMAIL);
        String password = request.getParameter(CHAMP_MOT_DE_PASSE);
        
        KombiUser user = appartiendPlateForme(pseudo, password);
        
        return user;
    }
    
    public KombiUser appartiendPlateForme(String pseudo, String password) {
    	KombiUser user = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.pseudo = MD5(?) AND us.passwdUser = MD5(?)", pseudo, password);
        return user;
    }
    
}
