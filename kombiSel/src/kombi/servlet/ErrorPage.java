package kombi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPage extends HttpServlet {
	
	private static final String  VUE= "/WEB-INF/Acconnexion.jsp";
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{
		
		this.getServletContext().getRequestDispatcher(VUE).forward(req,rep);
	}

	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException,ServletException{
		
	}
}
