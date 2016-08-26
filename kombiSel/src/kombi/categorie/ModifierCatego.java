package kombi.categorie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;
import beanskombi.Categorie;
import beanskombi.KombiUser;

public class ModifierCatego extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ATT_CATEGO = "categorie";
	private static final String VUE_MODIF = "/module/categorie/modifCat.jsp";
	private static final String VUE_SELC = "/gestionespace";
	private static final String VUE_SUP = "/gestionespace";
	private static final String ATT_CHOIX = "choix";
	

	protected void doGet(HttpServletRequest req , HttpServletResponse rep )throws IOException , ServletException{
		
		int idcat = Integer.parseInt(req.getParameter(ATT_CATEGO));
		//String element = req.getParameter(ATT_CATEGO);
		String choix = req.getParameter(ATT_CHOIX);
		
		String test = req.getParameter(ATT_CATEGO);
		Categorie cat = ModifierCatUtil.renvoieCatSelect(idcat);
		String resultat = null;
		
		System.out.print(choix);
		
		if(choix.equals("modif")){
			try{
			if(test != null ){
				if(cat != null ){
					System.out.println("il y a koi....");
					req.setAttribute("cat", cat);
				}
				this.getServletContext().getRequestDispatcher(VUE_MODIF).forward(req, rep);
			}else{
				
				resultat = "aucun element selectionner";
				
				System.out.println(resultat);
				
				req.setAttribute("resultat", resultat);
				
				
			}
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
			req.setAttribute("test", test);
			this.getServletContext().getRequestDispatcher(VUE_SELC).forward(req, rep);
			
		}
		
		if(choix.equals("supri")){
			
			System.out.println(req.getParameter(ATT_CATEGO));
			System.out.print(idcat);		
			System.out.print(cat);
			if(cat != null ){
				
				KombiCrudDao.supprimer(cat);
				
				req.setAttribute("cat", cat);
			}else{
				resultat = " aucun element selectionner ";
				
			}
			
		
			
			this.getServletContext().getRequestDispatcher(VUE_SUP).forward(req, rep);
			
		}
	}
		
	
	
	protected void doPost(HttpServletRequest req , HttpServletResponse rep )throws IOException , ServletException{
		
		String nomcat = req.getParameter("anciencategorie");
		
		String newnomcat = req.getParameter("nouveaunomcat");
		
		System.out.println(nomcat+"\t\t"+newnomcat);
		
		Categorie cat = ModifierCatUtil.renvoieNomCat(nomcat);
		
		System.out.println(cat.getNomCategorie());
		
		ModifierCatUtil modif = new ModifierCatUtil();
		
		Categorie catego = new Categorie();
		
		String resultat = null;
		if(cat != null ){
				if(newnomcat != null && KombiCrudDao.selectionnerUnElement("SELECT ca FROM Categorie ca WHERE ca.nomCategorie = ?", newnomcat) == null) {
					
				
				//catego = modif.updateCategorie(req)	;
				//System.out.println(catego);
				try{
					System.out.print("modification en cour ");
					
					if(modif.getErreur().isEmpty()){
						
						
						KombiCrudDao.executeInsUpdDelCreSQLQuery("UPDATE Categorie SET nom_categorie = '"+newnomcat+"'WHERE id_categorie = ?", cat.getIdCategorie());
						modif.resultat="mise a jour ok ";
						modif.erreur.put(newnomcat, " ");
						String action = "mise à jour categorie";
						KombiUser user1 = (KombiUser) req.getSession().getAttribute("user");
						KombiConstants.sauvegarderAction(user1, action);
						System.out.println("modification ok ");
					}
					
				}catch(Exception e){
					
					e.printStackTrace();
					System.out.print("echec modification ");
					resultat = " echec modification "; 
				}
				}else {
					resultat =" echec modification 222222222 ";
					
					modif.resultat="échec de mise à jour";
					modif.erreur.put(newnomcat, "ce nom existe deja");
				}
				req.setAttribute("resultat", resultat );
				req.setAttribute("cat", cat);
				req.setAttribute("modif", modif);
				req.setAttribute("catego", catego);
				
				this.getServletContext().getRequestDispatcher(VUE_MODIF).forward(req, rep);
		}
	}
}
