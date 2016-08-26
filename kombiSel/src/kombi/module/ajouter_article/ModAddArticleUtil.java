package kombi.module.ajouter_article;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import beanskombi.Article;
import beanskombi.Categorie;
import beanskombi.SousCategorie;
import kombi.dao.KombiCrudDao;
import kombi.util.KombiConstants;

public class ModAddArticleUtil {

	public ModAddArticleUtil() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("rawtypes")
	public static ArrayList<SousCategorie> getSousCategorieById(int id) {
		ArrayList<SousCategorie> categorie = new ArrayList<SousCategorie>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT sc FROM SousCategorie sc WHERE sc.idCategorie = ?", id);
		for (Object o : list)
			categorie.add((SousCategorie) o);
		return categorie;
	}
	
	public static void copyFile(File file, String dest) {
		try {
			byte[] bytes = new byte[1024];
			BufferedInputStream input = null;
			BufferedOutputStream output = null;
			int i = 0;
			input = new BufferedInputStream(new FileInputStream(file.getName()));
			output = new BufferedOutputStream(new FileOutputStream(dest));	
			while((i = input.read(bytes)) != -1) {
				output.write(bytes, 0, i);
			}
			output.flush();
			output.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void copyBufferedStream(BufferedInputStream input, String dest) {
		try {
			FileOutputStream f = new FileOutputStream(dest);
			BufferedOutputStream output = new BufferedOutputStream(f);
			byte[] bytes = new byte[KombiConstants.TAILLE_TAMPON];
			int i = 0;
			while((i = input.read(bytes)) != -1) {
				output.write(bytes, 0, i);
			}
			output.flush();
			output.close();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<Categorie> getAllCategories() {
		ArrayList<Categorie> categorie = new ArrayList<Categorie>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT cg FROM Categorie cg");
		for (Object o : list)
			categorie.add((Categorie) o);
		return categorie;
	}
	
	@SuppressWarnings("rawtypes")
	public static ArrayList<SousCategorie> getAllSousCategories() {
		ArrayList<SousCategorie> categorie = new ArrayList<SousCategorie>();
		List list = KombiCrudDao.selectionnerPlusieursElements("SELECT cg FROM SousCategorie cg");
		for (Object o : list)
			categorie.add((SousCategorie) o);
		return categorie;
	}
	
	public static int getIdCategorie(String categorie) {
		Categorie cat = (Categorie) KombiCrudDao.selectionnerUnElement("SELECT ct FROM Categorie ct WHERE ct.nomCategorie = ?", categorie);
		if (cat != null)
			return cat.getIdCategorie();
		return 0;
	}
	
	public static boolean nameExists(String nom) {
		Article art = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.nomArticle = ?", nom);
		if (art != null)
			return true;
		return false;
	}

	public static boolean imageExists(String image) {
		Article art = (Article) KombiCrudDao.selectionnerUnElement("SELECT ar FROM Article ar WHERE ar.imageArticle = ?", KombiConstants.DOSSIER_IMAGES + "/" + image);
			if (art != null)
				return true;
			return false;
	}
		
}

