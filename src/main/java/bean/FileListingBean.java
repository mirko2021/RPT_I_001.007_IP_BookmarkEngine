package bean;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Листање свих УРЛ ХТМЛ страница и боокмаркинг. 
 * @author MV
 * @version 1.0
 */
public class FileListingBean implements Serializable{
	private static final long serialVersionUID = 6290811586730289496L;
	public String PATH = "E:\\Enviroment\\Y28-Java\\Workspace\\IP_02\\007_IP_BookmarkEngine\\src\\main\\webapp\\";

	public List<File> files(){
		ArrayList<File> destionation = new ArrayList<>();
		destionation.addAll(recursive(new File(PATH)));
		Collections.sort(destionation);
		return destionation; 
	}
	
	public List<File> recursive(File dir){
		ArrayList<File> results = new ArrayList<>();
		if(dir==null) return results; 
		for(File file: dir.listFiles()) {
			if(file.isFile()) results.add(file);
			else if(file.isDirectory()) results.addAll(recursive(file));
		}
		return results;
	}
		
	public String relative(File file) {
		if(file==null) return "";
		if(!file.getAbsolutePath().startsWith(PATH)) return "";
		return file.getAbsolutePath().substring(PATH.length()); 
	}
	
	public String web(HttpServletRequest request, File file) {
		return request.getContextPath()+"/"+relative(file);
	}
}
