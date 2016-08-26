package kombi.util;

/**
 * Cette exception doit être levée pour des erreurs d'accès aux données.
 * 
 * @author MAX LE BLEU
 * @version 1.0
 */
public class KombiDaoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public KombiDaoException(String message) {
        super( message );
    }
    public KombiDaoException(String message, Throwable cause) {
        super( message, cause );
    }
    public KombiDaoException(Throwable cause) {
        super( cause );
    }
}
