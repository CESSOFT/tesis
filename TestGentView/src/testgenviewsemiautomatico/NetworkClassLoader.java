package testgenviewsemiautomatico;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NetworkClassLoader extends ClassLoader {

    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        String namefile=new File(name).getName();
        return defineClass(namefile.substring(0, namefile.indexOf(".")), b, 0, b.length);
    }

    private byte[] loadClassData(String name) {
   	 FileInputStream fis=null;
   	 byte[] buffer =null;
		try {
			fis = new FileInputStream(name);
			 BufferedInputStream bis = new BufferedInputStream(fis);
       	  buffer = new byte[(int)new File(name).length()];

       	 bis.read(buffer);
       	 fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

   	 return buffer;
        // load the class data from the connection
    
    }
}
