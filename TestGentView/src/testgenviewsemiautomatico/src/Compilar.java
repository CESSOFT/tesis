package testgenviewsemiautomatico.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import testgenviewsemiautomatico.UtilTestGen;



public class Compilar {

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//JavaCompiler 
		 String sourceFile = UtilTestGen.getPatchRepo();
	        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler ();
	        try {
	        StandardJavaFileManager fileManager = compiler.getStandardFileManager (null, null, null);
	        // prepare the source file(s) to compile
	        List<File> sourceFileList = new ArrayList <File> ();
	       
	        File listclass=new File (sourceFile);
	        if(listclass.isDirectory()){
	        	String []archivos=listclass.list();
	        	int i=0;
	        	for(String arch:archivos){
	        		
	        		if(arch.endsWith(".java")){
	        		
	        			sourceFileList.add (new File (sourceFile+arch));
	        		}
	        	}
	        		
	        } 
	        // para que compile EjecutarTest.java
	        sourceFileList.add(new File(UtilTestGen.getPatchRunTest()+"EjecutarTest.java"));
	        List<String> options=new ArrayList<String>();
	        options.add("-Xlint");
	        Iterable<? extends JavaFileObject> compilationUnits =fileManager.getJavaFileObjectsFromFiles (sourceFileList);
                CompilationTask task = compiler.getTask (null,fileManager, null, options, null, compilationUnits);
	        //task.
	        boolean result = task.call(); 
	     
	       
	        if (result) {
	            System.out.println ("Compilation was successful");
	        } else {
	            System.out.println ("Compilation failed");
	        }
	       
	            fileManager.close ();
	        } catch (IOException e) {
	        	System.out.println ("Compilation failed :"+e );
	        }

	}

}


