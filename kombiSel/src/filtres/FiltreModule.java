/**
 * 
 */
package filtres;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

/**
 * @author MAX LE BLEU
 *
 */
public class FiltreModule {
	Document document = null;
	DOMParser parser;

	public FiltreModule() {
		parser = new DOMParser();
		try {
			String filePath = getClass().getResource("/kombi/config/xml/config.xml").getFile().replace("%20", " ");
			parser.parse(filePath);
			document = parser.getDocument();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean moduleExist(String name) {
		NodeList nodeList = document.getElementsByTagName("module"); 
		if (nodeList != null) {
			for(int i= 0; i<nodeList.getLength(); i++) {
				if(nodeList.item(i).getTextContent().equals(name)) 
					return true;		
			}
		}
		return false;
	}
	
	public String getDefaultModule() {
		NodeList nodeList = document.getElementsByTagName("default");
		String chaine = null;
		if (nodeList != null && nodeList.getLength() != 0) {
			chaine = nodeList.item(0).getTextContent();
		}
		return chaine; 
	}
	
	public ArrayList<String> getLangTags(){
		NodeList nodeList = document.getElementsByTagName("tag");
		ArrayList<String> tags = new ArrayList<String>();
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			tags.add(nodeList.item(i).getTextContent());
		return tags;
	}
	
	public ArrayList<String> getLangNames(){
		NodeList nodeList = document.getElementsByTagName("name");
		ArrayList<String> names = new ArrayList<String>();
		int length = nodeList.getLength();
		for(int i=0; i<length; i++)
			names.add(nodeList.item(i).getTextContent());
		return names;
	}

}
