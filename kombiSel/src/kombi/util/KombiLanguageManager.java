package kombi.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;


public class KombiLanguageManager {

	/**
	 * Map contenant les diff�rents fichiers de langue (de base, de module et de composants).
	 */
	private HashMap<String, Properties> languageFiles;
	
	/**
	 * Constructeur � un argument.
	 * 
	 * @param languageTags
	 * La liste des tags de langues install�es sur le site.
	 * @throws KombiElementNotFoundException
	 */
	public KombiLanguageManager(ArrayList<String> languageTags) {
		try {
			this.initLanguageFiles(languageTags);
		} catch (KombiElementNotFoundException e) {
			System.out.println("Elt du doc not found");
			e.printStackTrace();
		}
	}

	/**
	 * Initialisation des fichiers de langue de base.
	 * 
	 * @param languageTags
	 * La liste des tags de langues install�es sur le site.
	 * @throws KombiElementNotFoundException
	 */
	private void initLanguageFiles(ArrayList<String> languageTags) throws KombiElementNotFoundException{
		languageFiles = new HashMap<String, Properties>();
		Properties languageFile;
    	InputStream propertiesFile;
    	for(String languageTag : languageTags){
    		languageFile = new Properties();
    		propertiesFile = null;
        	try {
				propertiesFile = getClass().getResource("/document/config/lang/language-"+ languageTag + ".properties").openStream();
	        
		        if (propertiesFile == null)
		        	throw new KombiElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
		        
	            languageFile.load(propertiesFile);
	            languageFiles.put(languageTag, languageFile);
        	}catch (FileNotFoundException e){
        		throw new KombiElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
			}catch (IOException e){
				throw new KombiElementNotFoundException("Le fichier de langue language-"+languageTag + ".properties est introuvable.");
			}
    	}
	}

	/**
	 * Cette m�thode permet de r�cup�rer un �l�ment de langue dans les fichiers de langue de base.
	 * Les fichiers de langue de base peuvent �tre consult�s directement sur la plateforme.<br />
	 * Si la cl� n'a aucune valeur associ�e alors la chaine vide est retourn�e.
	 * 
	 * @param languageKey
	 * La cl� de l'�l�ment de langue.
	 * @param languageTag
	 * Le tag de la langue pour laquelle vous voulez l'�l�ment de langue.
	 * @return
	 * L'�l�ment de langue correspondant � la cl� et � la langue que vous avez sp�cifi�.
	 */
	public String getLanguageValue(String languageKey, String languageTag) {
		try{
			return this.languageFiles.get(languageTag).getProperty(languageKey, "");
		}catch(Exception e){
			return "";
		}
	}
}
