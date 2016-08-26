package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanskombi.KombiUser;
import kombi.util.KombiConstants;

public class Deconnexion extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String INDEX = "/index";
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        //sauvegarde de l'action
        KombiUser user = (KombiUser) session.getAttribute("user");
        String action = "deconnexion";
        //KombiConstants.sauvegarderAction(user, action);
     
        session.invalidate();
        
        response.sendRedirect(request.getContextPath() + INDEX);
        
        System.out.println("deconnexion ok");
    }
    
}
