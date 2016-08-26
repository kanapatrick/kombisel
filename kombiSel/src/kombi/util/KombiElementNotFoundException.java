package kombi.util;

/**
 * Cette exception doit être levée si un élément requis n'a pas été trouvé.
 */
public class KombiElementNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public KombiElementNotFoundException(String message) {
        super( message );
    }
    public KombiElementNotFoundException(String message, Throwable cause) {
        super( message, cause );
    }
    public KombiElementNotFoundException(Throwable cause) {
        super( cause );
    }
}
