package kombiuser.param;

import beanskombi.KombiUser;
import kombi.dao.KombiCrudDao;

public class ProfilUserUtil {
	
	public static  KombiUser getUser(int idUser){
		
		KombiUser user = (KombiUser) KombiCrudDao.selectionnerUnElement("SELECT us FROM KombiUser us WHERE us.idUser = ?", idUser);
		
		return user;
		
	}

}
