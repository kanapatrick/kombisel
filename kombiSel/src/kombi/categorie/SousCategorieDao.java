package kombi.categorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import beanskombi.Categorie;
import beanskombi.SousCategorie;

public class SousCategorieDao extends HttpServlet {

	private static final String ATT_CAT = "choix";
	private static final String ATT_SOUS_CAT = "nomsouscat";
	private static final String ATT_CHOIX = "choix";
	private static final String CHAMP_ATT = "/module/categorie/creerSousCat.jsp";
	private static final String CHAMP_TEST = "/WEB-INF/test.jsp";
	
	@SuppressWarnings("rawtypes")
	protected  void doGet(HttpServletRequest req , HttpServletResponse rep )throws IOException , ServletException{
		
		ArrayList<Categorie> listecategorie = CategorieUtil.renvoieAllCat();
		
		Map<Categorie , ArrayList<SousCategorie> > listsous = SousCategorieUtil.getAllSousCate();
		
		String action = req.getParameter("action");
	
		if(action.equals("creercat")){
			
			req.setAttribute("listecategorie", listecategorie);
			this.getServletContext().getRequestDispatcher(CHAMP_ATT).forward(req, rep);
		}
			
		
		if(action.equals("souscat")){
			req.setAttribute("listsous",listsous);
			this.getServletContext().getRequestDispatcher(CHAMP_TEST).forward(req, rep);
		}
		
		
		
		
	}
	
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException, ServletException{
		
		int idcat =  Integer.parseInt(req.getParameter(ATT_CHOIX));
		
		SousCategorieUtil souscatutil  = new SousCategorieUtil();
		
		SousCategorie souscate = new  SousCategorie();
		Categorie cat = new Categorie(idcat);
		
		try{
			
			souscate = souscatutil.verifiercreation(req);
			souscate.setIdCategorie(idcat);
			System.out.println("sauvergarde en cour....");
			System.out.println(souscatutil.getErreur());
			if(souscatutil.getErreur().isEmpty()){
				KombiCrudDao.sauvegarderOuMettreAJour(souscate);
				System.out.println("sauver ok");
			
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//req.setAttribute("souscat", souscatutil);
		req.setAttribute("souscate", souscate);
		ArrayList<Categorie> listecategorie = CategorieUtil.renvoieAllCat();
		List souscat  = KombiCrudDao.selectionnerPlusieursElements("SELECT s FROM SousCategorie s");
		
		ArrayList<SousCategorie> sous = new ArrayList<SousCategorie>();
		
		for(Object o : souscat){
			sous.add((SousCategorie)o);
		}			
		req.setAttribute("listecategorie", listecategorie);
		req.setAttribute("souscat", souscat);
		this.getServletContext().getRequestDispatcher(CHAMP_ATT).forward(req, rep);
	}
}
