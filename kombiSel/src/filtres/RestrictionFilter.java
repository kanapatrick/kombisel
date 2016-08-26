package filtres;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kombi.util.KombiLanguageManager;

public class RestrictionFilter implements Filter {
    //déclaration des constantes
    public static final String ATTR_USER = "sessionUser";
    //private static final String ACCUEIL = "/index";
    public static final String CONNEXION = "/index";
    private static final String ERRO_CONX = "/erreurconnexion";
    protected KombiLanguageManager languageManager;
    
    public void init(FilterConfig config) throws ServletException {
    	languageManager = (KombiLanguageManager)config.getServletContext().getAttribute("languageManager");
    }
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        //cast de nos objets
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        FiltreModule filtre = new FiltreModule();
        
        
		
        //non filtrage des ressources statiques
        String chemin = request.getRequestURI().substring(request.getContextPath().length());
        if ( chemin.startsWith("/importFile") || chemin.startsWith("/img") ||chemin.startsWith("/bootstrap")|| chemin.startsWith("/template") || chemin.startsWith("/jquery.mobile") || chemin.startsWith("/scriptjs") || chemin.startsWith("/style") || chemin.startsWith("/ressource") || chemin.startsWith("/forum")) {
            chain.doFilter(request, response);
            return;
        }
        
        //recuperation de l'objet session s'il existe, et creation sinon
        HttpSession session = request.getSession();
        
        //si la personne n'est pas encore connecté, on le renvoie vers la page d'inscription
        
        if (session.getAttribute(ATTR_USER) == null) {
        	
        	String tag = (String)request.getSession().getAttribute("tag");
    		if(tag == null){
    			tag = filtre.getLangTags().get(0);
    			request.getSession().setAttribute("tag", tag);
    		}
    		String action = request.getParameter("lang");
    		if(action != null && action.equals("switch")){
    			String value = request.getParameter("val");
    			if(filtre.getLangTags().contains(value) && !tag.equals(value)){
    				tag = value;
    				System.out.println("le tag de langue courant est "+ tag);
    				request.getSession().setAttribute("tag", tag);
    			}
    		}
    		
    		ArrayList<String> tags = filtre.getLangTags();
    		ArrayList<String> names = filtre.getLangNames();
    		ArrayList<String> link = new ArrayList<String>();
    		for(int i = 0; i < tags.size(); i++){
    			link.add("<a href=\"index.jsp?lang=switch&val="+tags.get(i)+"\">"+names.get(i)+"</a>");
    		}
    		request.setAttribute("langItems", link);
            request.getRequestDispatcher(CONNEXION).forward(request, response);
        } else {
        	String tag = (String)request.getSession().getAttribute("tag");
    		if(tag == null){
    			tag = filtre.getLangTags().get(0);
    			request.getSession().setAttribute("tag", tag);
    		}
    		String action = request.getParameter("lang");
    		if(action != null && action.equals("switch")){
    			String value = request.getParameter("val");
    			if(filtre.getLangTags().contains(value) && !tag.equals(value)){
    				tag = value;
    				System.out.println("le tag de langue courant est "+ tag);
    				request.getSession().setAttribute("tag", tag);
    			}
    		}
    		
    		ArrayList<String> tags = filtre.getLangTags();
    		ArrayList<String> names = filtre.getLangNames();
    		ArrayList<String> link = new ArrayList<String>();
    		for(int i = 0; i < tags.size(); i++){
    			link.add("<a href=\"accueil?lang=switch&val="+tags.get(i)+"\">"+names.get(i)+"</a>");
    		}
    		request.setAttribute("langItems", link);
            chain.doFilter(request, response);
        }
    }
    
    public void destroy() {
        
    }
}
