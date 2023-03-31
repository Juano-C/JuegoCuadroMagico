package ejemplosFileManager;

import java.io.File;
import java.io.IOException;

public class EjemploFileManager {
	
	private File _file;
	private String _user_dir;
	private String _pathFile;
	private final String _separador = "\\" ;
	
	public EjemploFileManager() {
		_user_dir = System.clearProperty("user.dir");
	}
	
	public boolean crearArchivo(String nameFile) {
		
	    try {
	        File fileToCreate = new File(_user_dir + _separador + nameFile);
	        
	        String showMessage = fileToCreate.createNewFile()? "File created: " + fileToCreate.getName(): 
	        												   "File already exists.";
	        System.out.println(showMessage);
	        
	        return true;
	        
	      } catch (IOException e) {
	    	  
	        System.out.println("An error occurred.");
//	        e.printStackTrace();
	        
	        return false;
	      }
	}
	
	public boolean eliminarArchivo(String nameFile) {
	    File fileToDelete = new File(nameFile);
	    boolean deleteComplete = fileToDelete.delete();
	    String showMessage =  deleteComplete? "Deleted the file: " + fileToDelete.getName(): "Failed to delete the file.";
		System.out.println(showMessage);
		return deleteComplete;
	}
	
	public void imprimirDir() {
		System.out.println(_user_dir);
	}

 	public static void main(String[] args) {
 		EjemploFileManager fm = new EjemploFileManager();
 		
// 		fm.imprimirDir();
// 		fm.crearArchivo("resources\\puntajes.txt");
// 		fm.eliminarArchivo("resources\\puntajes.txt");
 		

	}

}
