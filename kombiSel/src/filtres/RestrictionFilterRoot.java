package filtres;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanskombi.KombiUser;

public class RestrictionFilterRoot implements Filter {
    public static final String ATTR_USER   = "user";
    public static final String DECONNEXION = "/deconnexion";
    
    public void init(FilterConfig config) throws ServletException {
        
    }
    
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        //cast de nos objets
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        //recuperation de l'objet session s'il existe, et creation sinon
        HttpSession session = request.getSession();
        
        KombiUser user = (KombiUser) session.getAttribute(ATTR_USER);
        
        //il faut être au moins un modérateur pour avoir accès au dossier moderateur
        String chemin = request.getRequestURI().substring(request.getContextPath().length());
        if (chemin.startsWith("/WEB-INF/root")) {
            if (user.getGroupe().getIdGroupe() == 1) {
                chain.doFilter(request, response);
                return;
            } else {
                response.sendRedirect(request.getContextPath() + DECONNEXION);
            }
        }
    }
    
    public void destroy() {
        
    }
}
