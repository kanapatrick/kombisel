package kombi.util;

import java.util.Date;

import kombi.dao.KombiCrudDao;
import beanskombi.Historique;
import beanskombi.KombiUser;

/**
 * @author MAX LE BLEU
 * 
 */
public class KombiConstants {
    public static final String  KOMBIUSER_SUPER_USER = "superutilisateur",
			    				KOMBIUSER_ADMIN = "administrateur",
			    				KOMBIUSER_MODERATEUR = "moderateur", 
			    				KOMBIUSER_USER = "user";
    
    public static final int     KOMBI_GROUPE_SUPER_USER = 1, 
			    				KOMBI_GROUPE_ADMIN = 2,
			    				KOMBI_GROUPE_MODERATEUR = 3, 
			    				KOMBI_GROUPE_USER = 4;
    
    public static final String DOSSIER_IMAGES = "ressources/images";
    
    public static final int    TAILLE_TAMPON         = 10240;                 // 10 ko
    
    public static final int     DESACTIVED_ARTICLE   = 0,
    							ACTIVED_ARTICLE = 1,
					    		DESACTIVED_USER  = 0,
								ACTIVED_USER = 1;
    public static void sauvegarderAction(KombiUser user, String action) {
        Historique hist = new Historique();
        hist.setKombiUser(user);
        hist.setAction(action);
        hist.setDateHistorique(new Date());
        KombiCrudDao.sauvegarderOuMettreAJour(hist);
    }
    

}
