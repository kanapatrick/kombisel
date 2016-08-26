package kombi.module.promotion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import beanskombi.Article;
import beanskombi.Promotion;

/**
 * @author MAX LE BLEU
 * 
 */
public class VerifiePromotion {

    private String              resultat;
    private Map<String, String> erreurs   = new HashMap<String, String>();
    ArrayList<String>           allChemin = new ArrayList<String>();
    ArrayList<String>           allImage  = new ArrayList<String>();
    
    public static final String  ARTICLE_REDUCTION = "reduction",  ARTICLE_ID = "article",
    							ARTICLE_SOUS_CATEGORIE = "sous_categorie", ARTICLE_PRIX = "prix",
    							PROMOTION_DATE = "dateFin";
    public static final String FORMAT_DATE            = "yyyy-MM-dd",
    							FORMAT_TIME = " HH:mm:ss";
    							
								
    
    public VerifiePromotion() {
		
	}    
    public String getResultat() {
        return resultat;
    }
    
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public void setErreurs(String cle, String valeur) {
        this.erreurs.put(cle, valeur);
    }
       
    
	@SuppressWarnings("unused")
	public Promotion verifieForm(HttpServletRequest request) {
        String date, sous_categorie, prix, article, reduction;
        float price = 0;
        int qte = 0, reduc = 0;        
        DateTime dateFinal = null;
                
        Promotion promo = new Promotion();
        Article art = new Article(); 
        
        date = request.getParameter(PROMOTION_DATE);        
        reduction = request.getParameter(ARTICLE_REDUCTION);        
                
        try {                	                                
            dateFinal = new DateTime(); 
            System.out.println("La date entrée est : "+ date);
			dateFinal = verifieDate(date);						
			} catch (Exception e) {
				setErreurs("dateFin", e.getMessage());
			}                    
        System.out.println(dateFinal);
        promo.setDateFin(dateFinal.toDate());
               
        try {
        	//qte = Integer.parseInt(request.getParameter(ARTICLE_QTE));
        	reduc = verifieReduction(reduction);
        }catch (Exception e) {
        	setErreurs("reduction", e.getMessage());
        }
        promo.setReduction(reduc);
        
        if (erreurs.isEmpty() || erreurs == null) {
            resultat = "Succes";                    	
        }
        else
            resultat ="échec d'importation";
        System.out.println(erreurs);
        System.out.println("le doc envoyer est " + promo);
        return promo;
		}
	
    public int verifieReduction(String qte) throws Exception {
    	int quantite = Integer.valueOf(qte).intValue();    	
        if (qte.isEmpty() || qte == null || quantite == 0) {
        	quantite = -1;
            throw new Exception("Veuillez Entrez la quantité d'article ");
        }
        else if (!qte.matches("^\\d+$")) {
        	quantite = -1;
        	throw new Exception("La quantité doit être un nombre valide");
        }        
        return quantite;
    }
    
    public DateTime verifieDate(String date) throws Exception {
    	DateTime dateFin = new DateTime(date);
    	dateFin = DateTime.parse(date);
    	System.out.println("The new date is "+dateFin.toString());
    	DateTime currentDate = new DateTime(new Date());
    	try {
    		DateTimeFormatter format = DateTimeFormat.forPattern(FORMAT_DATE);				
    		dateFin = format.parseDateTime(date);
    	}catch (Exception e) {
    		throw new Exception("Format de date incorrect");
    	}
    	if (dateFin.isBeforeNow()) {
	    	throw new Exception("Cette date est deja Passe ");
    	}		    			    		
    	else if (dateFin.isEqualNow()){
    		throw new Exception("Cette journee est en cours");
    	}
		return dateFin;    			    	    	
    }
}