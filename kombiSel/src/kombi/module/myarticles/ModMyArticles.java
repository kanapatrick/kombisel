package kombi.module.myarticles;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanskombi.KombiUser;

import kombi.util.KombiConstants;
import kombi.util.KombiLanguageManager;

@WebServlet("/ModMyArticles")
public class ModMyArticles extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    protected KombiLanguageManager languageManager;
    //private static final String ALL_ART = "tout";
    
    public ModMyArticles() {
        super();
        
    }
    @Override
   	public void init(ServletConfig config) throws ServletException {
   		super.init(config);
   		//languageManager = (KombiLanguageManager)config.getServletContext().getAttribute("languageManager");
   		System.out.println("la langue est: "+ languageManager);
   	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
        String dispacher = "/module/mesarticles/mes_articles.jsp";
        
        KombiUser user = (KombiUser) request.getSession().getAttribute("user");                       
        if (user.getGroupe().getIdGroupe() <= KombiConstants.KOMBI_GROUPE_MODERATEUR){
        	request.setAttribute("articles", ModMyArticlesUtil.getAllArticles());   
        	session.setAttribute("articles", ModMyArticlesUtil.getAllActivedArticles());
    } else {
        	request.setAttribute("articles", ModMyArticlesUtil.getAllActivedArticles());
        	 session.setAttribute("articles", ModMyArticlesUtil.getAllActivedArticles());
        }        	        
       
        this.getServletContext().getRequestDispatcher(dispacher).forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
   
}
