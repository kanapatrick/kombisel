package kombi.module.ajouter_article;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import beanskombi.Article;
import beanskombi.Categorie;
import beanskombi.SousCategorie;
import kombi.util.KombiConstants;

/**
 * @author MAX LE BLEU
 * 
 */
public class VerifieAjout {

    private String              resultat;
    private Map<String, String> erreurs   = new HashMap<String, String>();
    ArrayList<String>           allChemin = new ArrayList<String>();
    ArrayList<String>           allImage  = new ArrayList<String>();
    public static final String  ARTICLE_NAME = "nom", ARTICLE_DESC = "description",
    							ARTICLE_QTE = "qte", ARTICLE_IMAGE = "image",
    							ARTICLE_CATEGORIE = "categorie", ARTICLE_PRIX = "prix",
    							ARTICLE_SOUS_CATEGORIE = "sous_categorie";
    							
								
    
    public VerifieAjout() {
		
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
    
    public void initExtension() {
        allImage.add("jpeg");
        allImage.add("jpg");
        allImage.add("png");
        allImage.add("gif");
    }
    
    public Article verifieForm(HttpServletRequest request) {
        String nom, desc, image, /*categorie,*/ prix, qte, chemin, sous_categorie;
        float nbrePrix = 0;
        int nbreQte = 0;
        String nomImg = null;
        initExtension();
        
        List<FileItem> items = null;
        DiskFileItemFactory diskFile = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFile);
        URL url = getClass().getResource("/../../" + KombiConstants.DOSSIER_IMAGES);
        System.out.println("l'url est : " + url);
        File fRecu = new File(url.getFile().replace("%20", " "));
        diskFile.setRepository(fRecu);
        try {
            items = upload.parseRequest(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Article art = new Article();
        
        BufferedInputStream input = null;
        
        for (FileItem item : items) {
            if (item.isFormField()) {
                if (item.getFieldName().equals(ARTICLE_NAME)) {
                    nom = item.getString();
                    try {
                        verifieNom(nom);
                        System.out.println("Le nom est bon");
                    } catch (Exception e) {
                        setErreurs("nom", e.getMessage());
                    }
                    art.setNomArticle(nom);
                }
                if (item.getFieldName().equals(ARTICLE_DESC)) {
                    desc = item.getString();
                    try {
                        verifieDescription(desc);
                    } catch (Exception e) {
                        setErreurs("description", e.getMessage());
                    }
                    art.setDescription(desc);
                }
                if (item.getFieldName().equals(ARTICLE_QTE)) {
                    qte = item.getString();
                    try {
                        nbreQte = verifieQte(qte);
                    } catch (Exception e) {
                        setErreurs("quantite", e.getMessage());
                    }
                    art.setQuantite(nbreQte);
                }
                if (item.getFieldName().equals(ARTICLE_SOUS_CATEGORIE)) {
                    sous_categorie = item.getString();
                    art.setSousCategorie(new SousCategorie(Integer.parseInt(sous_categorie)));
                }
                if (item.getFieldName().equals(ARTICLE_PRIX)) {
                    prix = item.getString();
                    try {
                        nbrePrix = verifiePrix(prix);
                    } catch (Exception e) {
                        setErreurs("prix", e.getMessage());
                    }
                    art.setPrix(nbrePrix);               
                } 
            }else {                
            	System.out.println("le nom du champ est " + item.getFieldName());
                if (item.getFieldName().equals(ARTICLE_IMAGE)) {
                    image = item.getName();
                    
                    try {
                    	System.out.println(image);
                        image = image.toLowerCase();
                        verifieImage(image);
                        nomImg = FilenameUtils.getName(item.getName());
                        nomImg = nomImg.substring(nomImg.lastIndexOf('/') + 1).substring(nomImg.lastIndexOf('\\') + 1);
                        input = new BufferedInputStream(item.getInputStream());
                        String context = request.getContextPath() + "/WebContent/" + KombiConstants.DOSSIER_IMAGES;
                        chemin = fRecu.getPath().substring(0, fRecu.getPath().lastIndexOf("workspace") + 9) + context;
                        System.out.println("le chemin final de l�mage est: " + chemin);
                        ModAddArticleUtil.copyBufferedStream(input, chemin + "/" + nomImg);
                        
                        art.setImageArticle(KombiConstants.DOSSIER_IMAGES + "/" + item.getName());
                    } catch (Exception e) {
                        setErreurs("image", e.getMessage());
                    }
                }
            }
        }
        if (erreurs.isEmpty() || erreurs == null)
            resultat = "Succes";
        else
            resultat ="échec importation";
        System.out.println("le doc envoyer est " + art);
        return art;
    }
    
    public void verifieNom(String nom) throws Exception {
        if (nom.isEmpty()) {throw new Exception("Veuillez remplir le champ nom");}
        if (nom.length() < 3) { throw new Exception("Le nom doit avoir au moins 3 lettres"); }
        if (!nom.matches("[a-z,A-Z,0-9 ]+")) {throw new Exception("Le nom doit être une chaine valide");}
        if (ModAddArticleUtil.nameExists(nom)) {throw new Exception("Un article de m�me titre existe deja"); }
        
    }
    
    public void verifieDescription(String description) throws Exception {
        if (description.isEmpty()) {throw new Exception("Veuillez remplir le champ description");} 
        if (description.length() < 10) { throw new Exception("Votre description est trop courte"); }
        //if (!description.matches("[a-z,A-Z ]+")) {throw new Exception("Entrée invalide");}
    }
    
    public int verifieQte(String qte) throws Exception {
    	int quantite = Integer.valueOf(qte).intValue();
        if (qte.isEmpty()) {
        	quantite = -1;
            throw new Exception("Veuillez Entrez la quantité d'article ");
        }
        else if (!qte.matches("^\\d+$")) {
        	quantite = -1;
        	throw new Exception("La quantité doit être un nombre valide");
        }
        return quantite;
    }
    
    public float verifiePrix(String prix) throws Exception {
    	float price;
    	try {
    		price = Float.valueOf(prix).floatValue();
    	}catch(Exception e) {
    		throw new Exception("Entrée incorrecte");
    	}
        if (prix.isEmpty()) {
        	price = -1;
            throw new Exception("Veuillez Entrez le prix de l'article ");
        }
        else if (!prix.matches("(([0-9]+.)+[0-9]+$)")) {
        	price = -1;
        	throw new Exception("Le prix doit être un nombre valide");
        }
        return price;
    }
    
    public void verifieImage(String image) throws Exception {
    	if (image.isEmpty()) {throw new Exception("Veuillez choisir une image");}
        if (!allImage.contains(image.substring(image.lastIndexOf(".") + 1))) { throw new Exception("Extension image Incorrecte"); }
        if (image.length() > 100) {throw new Exception("Le nom de l'image est trop long" );}
        if (ModAddArticleUtil.imageExists(image)) {throw new Exception("Une image de m�me nom existe deja"); }
    }
    
}
