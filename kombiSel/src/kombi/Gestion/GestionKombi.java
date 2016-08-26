package kombi.Gestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;


import beanskombi.Categorie;
import beanskombi.KombiUser;
import beanskombi.SousCategorie;





@SuppressWarnings("serial")
public class GestionKombi extends HttpServlet {
	
	private static final String VUE_CAT = "/WEB-INF/administrateur/gestionCat.jsp";
	private static final String ATT_ACTION ="action";
	private static final String VUE_USE ="/WEB-INF/administrateur/gestionUser.jsp";
	private static final String VUE_COMMU = "/WEB-INF/administrateur/gestionCommu.jsp";
	
	protected void doGet(HttpServletRequest req , HttpServletResponse rep)throws ServletException,IOException{
				
		String action = req.getParameter(ATT_ACTION);
		
		if(action != null && action.equals("cate")){
			
			HashMap<Categorie,ArrayList<SousCategorie>> souscat = (HashMap<Categorie, ArrayList<SousCategorie>>) GestionUtil.getAllSousCate();
			
			//System.out.print(souscat);
			ArrayList<Categorie> cato = GestionUtil.getALLCategorie();
			ArrayList<SousCategorie>  sct =null;
			if(souscat != null){
				for(int j=0 ; j < cato.size();j++){
		
					System.out.println(cato.get(j).getNomCategorie()+"\t\t\t\t"+souscat.get(cato.get(j)));
					  sct = souscat.get(cato.get(j));
						if(sct !=null){
							for(int k =0 ; k < sct.size(); k++){
								
								System.out.println("Nom "+sct.get(k).getNomSousCategorie()+"\t\tid"+sct.get(k).getIdSousCategorie());
							}
							}
				}
			
			}else{
				System.out.print("il y a rien ici");
			}
			req.setAttribute("souscategorie", souscat);
			req.setAttribute("listeCategorie", GestionUtil.getALLCategorie());
			this.getServletContext().getRequestDispatcher(VUE_CAT).forward(req, rep);

		}
		
		if(action != null && action.equals("commu")){
			
			this.getServletContext().getRequestDispatcher(VUE_COMMU).forward(req, rep);
		}
		ArrayList<KombiUser> kom = GestionUtil.getOnlyUser();
	
		System.out.println("la nouvelle est :"+action);
		if(action!=null && action.equals("inscrit")){
			
			req.setAttribute("moderateur", GestionUtil.getOnlyModerateur());
			req.setAttribute("inscrit", GestionUtil.getOnlyUser());
			req.setAttribute("moderateur", GestionUtil.getOnlyModerateur());
			this.getServletContext().getRequestDispatcher(VUE_USE).forward(req, rep);
		}
	}
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws ServletException , IOException{
		
	}

}
