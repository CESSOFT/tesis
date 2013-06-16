package testgenviewsemiautomatico.util;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

import testgenviewsemiautomatico.DtoXMLCasoPrueba;
import testgenviewsemiautomatico.dto.DtoXmlTree;
import testgenviewsemiautomatico.src.Compilar;
import testgenviewsemiautomatico.src.EjecutarTest;
import testgenviewsemiautomatico.src.GeneraDoc;

/**
 *
 * @author Eduardo
 */
public class UtilTestGen {
	
	private static final Class[] parameters = new Class[]{URL.class};
    public String loadFile
	(Frame f, String title, String defDir, String fileType) {
		FileDialog fd = new FileDialog(f, title, FileDialog.LOAD);
		fd.setFile(fileType);
		fd.setDirectory(defDir);
		fd.setLocation(50, 50);
		fd.show();
		return fd.getDirectory()+fd.getFile();
	}
    	static public void ejecutarBatComp(String filePatch){
		Runtime aplicacion = Runtime.getRuntime();
        try{
        	System.out.println("Ejutar .bat");
                UtilTestGen.clearDirectory("E:\\TESIS\\Repositorio\\");
        	aplicacion.exec("cmd.exe /C start E:\\TESIS\\testGen4j\\test2EduG_1.bat "+filePatch);
                Thread.sleep(2000);
        }catch(Exception e){
        	System.out.println(e);
        	}
        }

        static public void ejecutarBatRun(String filePatch){
		Runtime aplicacion = Runtime.getRuntime();
        try{
        	System.out.println("Ejutar .bat");
                UtilTestGen.clearDirectory("E:\\TESIS\\Repositorio\\");
        	aplicacion.exec("cmd.exe /C start E:\\TESIS\\testGen4j\\test2EduG_Ejecu.bat "+filePatch);
                Thread.sleep(2000);
        }catch(Exception e){
        	System.out.println(e);
        	}
        }


        static public String parserPatch(String pat) {
              String [] patchs=pat.split("\\W");
                
                String patch="";
                for(int i=0;i<patchs.length-2;i++){
                    if(i==0){
                        patch=patch.concat(patchs[i]+":\\");
                    }else{
                        patch=patch.concat(patchs[i]+"\\");
                    }
                    
                }
                System.out.println("Patch .........:"+patch);

            return patch;
        }
        static public DtoXMLCasoPrueba SetDtoCaso(DtoXmlTree dtoTree) {
            DtoXMLCasoPrueba dtoCaso=new DtoXMLCasoPrueba();
            dtoCaso.setClaseName(dtoTree.getClassName());
            String metodo=(String)dtoTree.getMetodoNameParam().toArray()[0];
            dtoCaso.setMetodo(metodo);
            Set<String> paraname=dtoTree.getParameTipo().get(metodo).keySet();
            HashMap<String, String> parameTipo=new HashMap<String, String>();
            HashMap<String, String> parameValor=new HashMap<String, String>();
            for(String in:paraname){
               parameTipo.put(in,dtoTree.getParameTipo().get(metodo).get(in));
               parameValor.put(in,dtoTree.getParameValor().get(metodo).get(in));
            }
            dtoCaso.setPatch(dtoTree.getPatch());
            dtoCaso.setTypeassert(dtoTree.getParameRetorno().get(metodo));
            dtoCaso.setValorassert(dtoTree.getParameRetornoValor().get(metodo));
            dtoCaso.setParameTipo(parameTipo);
            dtoCaso.setParameValor(parameValor);
            return dtoCaso;
        }
        static public JFormattedTextField getFormatotype(String type){
        System.out.println("......."+type+"..........");
        String typetrim=type.trim();
           Pattern Patte=Pattern.compile("--");
           JFormattedTextField jformattred=null;
            if("int".equals(typetrim)){
            	DefaultFormatter editFormat = new DefaultFormatter();
            		editFormat.setValueClass(Integer.class);          	
               jformattred=new JFormattedTextField(editFormat);
 
           }
           if("char".equals(typetrim)){
                Character c='a';
                try {
                MaskFormatter fm=new MaskFormatter("*");
                jformattred=new JFormattedTextField(fm);
                }catch (Exception e){
                    
                }

           
           }
           if("byte".equals(typetrim)){
                DefaultFormatter editFormat = new DefaultFormatter();
        		editFormat.setValueClass(Byte.class);
               jformattred=new JFormattedTextField(editFormat);
           }
           if("short".equals(typetrim)){
        	   DefaultFormatter editFormat = new DefaultFormatter();
       		   editFormat.setValueClass(Short.class);
               jformattred=new JFormattedTextField(editFormat);
           }
           if("long".equals(typetrim)){
        	   DefaultFormatter editFormat = new DefaultFormatter();
       		   editFormat.setValueClass(Long.class);
               jformattred=new JFormattedTextField(editFormat);
           }
           if("float".equals(typetrim)){
        	   DefaultFormatter editFormat = new DefaultFormatter();
       		   editFormat.setValueClass(Float.class);
               jformattred=new JFormattedTextField(editFormat);
           }
           if("double".equals(typetrim)){
        	   DefaultFormatter editFormat = new DefaultFormatter();
       		   editFormat.setValueClass(Double.class);
               jformattred=new JFormattedTextField(editFormat);
           }
             if("boolean".equals(typetrim)){
            	DefaultFormatter editFormat = new DefaultFormatter();
         		editFormat.setValueClass(Double.class);
               jformattred=new JFormattedTextField(editFormat);
           }
            return jformattred;
        }
        private static void clearDirectory(String patch){
            File file=new File(patch);
            String [] dirlist=file.list();
            for(String in:dirlist){
                File f=new File(in);
                if(f.isFile()){
                    f.delete();
                }
            }
        }
        public static boolean ejecutarTest(String classnametest)throws Exception{
           String[] arg={classnametest.substring(0, classnametest.indexOf("Test"))};
           try{
            EjecutarTest.main(arg);
            if(System.err.checkError()){
            	throw new Exception(":Error al quere ejecutar");
            }
            return true;
           }catch(Exception e){
               throw new Exception(e+":Error al quere ejecutar");
           }
            
        }
        public static String parsearResultado(){
            String patch=getPatchRepo();
            File testFailure=new File(patch+"TestFail.txt");
             File testSuccess=new File(patch+"TestOK.txt");
             if(testSuccess.exists()){
                 return "Caso de prueba ejecutado: OK";
             }if(testFailure.exists()){
                 return "Caso de prueba ejecutado: FAIL";
             }else  {
                 return "Caso de prueba ejecutado no correctamente";
             }

        }
        public static boolean deleteFileResult(String patch){
            patch=getPatchRepo();
            File testSuccess=new File(patch+"TestSuccess.log");
            File testFailure=new File(patch+"TestFailure.log");
            if(testSuccess.exists()){
                testSuccess.delete();
                if(testFailure.exists()){
                    testFailure.delete();
                }
            }
            return true;
        }
        public static void generarDoc(String filepatch)throws Exception{
             String patchD=getPatchRepo();
            File src=new File(filepatch);
            File dst=new File(patchD+src.getName());
            
            try{
                parsearClase(src, dst);
             
            }catch (IOException ioe){
                throw new Exception(ioe+"Error al copiar Class origen"+src.getAbsolutePath());
            }
            //Genera los documento necesario para la compilacion

                String args[]={filepatch};
                GeneraDoc.main(args);
                
   

            
        }
        public static void compilaDoc()throws Exception{
            String[] arg={};
            try{
            Compilar.main(arg);
            copyFileClass();
            }catch (Exception e){
                 throw new Exception(e);
            }

        }
       public static void copiarClass(){
           String sourceFiles = getPatchRepo();
           File source=new File(sourceFiles);
           
           String destinyFile = getPatchRepoBuildin(); 
          
           
           String[] listFile=source.list();
           
           for(String arch:listFile){
               
               if(arch.indexOf(".class")>0){
                   try{
                    File fileClass=new File(sourceFiles+arch);
                     File destiny=new File(destinyFile+arch);
                     copyFile(fileClass, destiny);
                     fileClass.delete();
                   }catch (Exception e){
                       System.out.println("Error tratando de copiar las .class :"+arch+e);
                   }
                   
                   
               }
               
           }
           
           
       }

     /** 
     * Copia un solo archivo 
     * @param src 
     * @param dst 
     * @throws IOException 
     */ 
    public static void copyFile(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src); 
        OutputStream out = new FileOutputStream(dst); 
         
         
        byte[] buf = new byte[1024]; 
        int len; 
        while ((len = in.read(buf)) > 0) { 
            out.write(buf, 0, len); 
        } 
        in.close(); 
        out.close(); 
    }
    public static String getPatchRepo(){
    	Properties prop = new Properties();
    	try {
            //load a properties file
    		prop.load(new FileInputStream("config.properties"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        return prop.getProperty("repository");
    }
    public static String getPatchRunTest(){
    	Properties prop = new Properties();
    	try {
            //load a properties file
    		prop.load(new FileInputStream("config.properties"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        return prop.getProperty("runtest");
    }
     public static String getPatchRepoBuildin(){
    	 Properties prop = new Properties();
     	try {
             //load a properties file
     		prop.load(new FileInputStream("config.properties"));

     	} catch (IOException ex) {
     		System.out.println("Error getPatchRepoBuildin"+ex);
         }
         return prop.getProperty("pathcompile");
    }
    public static void removeFile(){
        //File failedData=new File(getPatchRepo()+"failedData.xml");
        File TestSuccess=new File(getPatchRepo()+"TestSuccess.log");
        File TestFailure=new File(getPatchRepo()+"TestFailure.log");
        File TestOK=new File(getPatchRepo()+"TestOK.txt");
        File TestFile=new File(getPatchRepo()+"TestFile.txt");
        //borramosArchivos
        //failedData.delete();
        TestFailure.delete();
        TestSuccess.delete();
        TestOK.delete();
        TestFile.delete();
    
    }
    public static void limpiarDirectorios(){
        File directorio=new File(getPatchRepo());
        String[] lista=directorio.list();
        for(String ind:lista){
            File arch=new File(getPatchRepo()+ind);
            if(arch.isFile()){
                arch.delete();
            }
        }
        File directoriobuildin=new File(getPatchRepoBuildin());
        String[] listab=directoriobuildin.list();
         
        for(String ind:listab){
            System.out.println("Archivo :"+ind);
            File arch=new File(getPatchRepoBuildin()+ind);
            if(arch.isFile()){
                 arch.delete();
            }
        }
        System.out.println("Termino borrado de archivos....");
    }
    public static void copyFileClass(){

        File src=new File(getPatchRepo());
        File destino= null;
        String[] lista=src.list();
        for (String ind:lista){

            if(ind.endsWith(".class")){
                 System.out.println("Archivos :"+ind);
                try{
                    destino=new File(getPatchRepoBuildin()+ind);
                    addFile(destino);
                    copyFile(new File(getPatchRepo()+ind),destino);
                    destino.delete();
                }catch(Exception e){
                    System.out.println("Fallo copia de .class"+e);
                }

            }
        }
        try {
			//addFile(getPatchRepoBuildin());
			addFile(src);
		} catch (IOException e) {
			 System.out.println("Fallo a cargar URL en el classpath "+e);
		}

    }
    public static void parsearClase(File org,File dest)throws IOException{
    
         try {
        	 FileWriter fw=new FileWriter(dest);
 			 BufferedWriter bw=new BufferedWriter(fw);
 			 bw.write("package testgenviewsemiautomatico.repository;");
 			 bw.newLine();
        	 FileReader fr=new FileReader(org);
        	 BufferedReader br=new BufferedReader(fr);
        	 while(br.ready()){
        		 String line=br.readLine();
        		 if(line.contains("package")){
        			 line="";
        		 }
        		bw.write(line);
        		bw.newLine();
        	 }
        	br.close();
        	bw.flush();
        	bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    public static String parsearTest(String in){
        String ret="";
        if(in.contains("Test")){
              ret=in.replace("Test", "");
        }
       if(in.contains("test")){
              ret=in.replace("test", "");
        }
        return ret;
    }
	public static String getPatchRepoDoble() {
		Properties prop = new Properties();
    	try {
            //load a properties file
    		prop.load(new FileInputStream("config.properties"));

    	} catch (IOException ex) {
    		ex.printStackTrace();
        }
        return prop.getProperty("repositorydoble");
	}
	
	public static void addFile(String s) throws IOException {
		   File f = new File(s);
		   addFile(f);
		}//end method

	public static void addFile(File f) throws IOException {
		   addURL(f.toURI().toURL());
		}//end method


	public static void addURL(URL u) throws IOException {

		  URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		  Class sysclass = URLClassLoader.class;

		  try {
		     Method method = sysclass.getDeclaredMethod("addURL", parameters);
		     method.setAccessible(true);
		     method.invoke(sysloader, new Object[]{u});
		     System.out.println("Cargando class ... :"+u.getPath());
		     
		     /*NetworkClassLoader classloader=new NetworkClassLoader();
		     classloader.findClass(u.getPath());
		     
		     ClassLoader.getSystemClassLoader().loadClass("testgenviewsemiautomatico.repository.Sample1");//("Sample1.class");
		     Class.forName("testgenviewsemiautomatico.repository.Sample1.class", true,   ClassLoader.getSystemClassLoader());
		     Class.forName("testgenviewsemiautomatico.repository.Sample1");*/
		  } catch (Throwable t) {
		     t.printStackTrace();
		     throw new IOException("Error, could not add URL to system classloader");
		  }//end try catch

		   }//end method
	   


}
