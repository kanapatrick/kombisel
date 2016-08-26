package kombi.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import filtres.FiltreModule;


public class KombiApplication implements ServletContextListener{

	/**
	 * Destruction du contexte.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	/**
	 * Initialisation du contexte. Nous pla�ons l'objet de configuration dans le contexte.
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		KombiLanguageManager lang = null;
		try {
			lang = new KombiLanguageManager((new FiltreModule()).getLangTags());
		} catch (Exception e) {
			System.out.println("le filtre de langue est"+ (new FiltreModule()).getLangTags());
			System.out.println("Echec creation "+ e.getMessage());
		}
		servletContext.setAttribute("languageManager", lang);
	}

}
