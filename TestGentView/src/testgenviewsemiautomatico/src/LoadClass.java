package testgenviewsemiautomatico.src;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;
import javax.tools.JavaFileManager.Location;


public class LoadClass {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String sourceFile = "E:\\TESIS\\repositorio\\";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler ();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager (null, null, null);

		List<File> sourceClass = new ArrayList <File> ();
		Iterable<? extends File> algo= sourceClass;
		sourceClass.add(new File(sourceFile));
		
		Location location=StandardLocation.CLASS_OUTPUT;//El tipo de Location
		try {
			fileManager.setLocation(location, algo);//Carga las clases algo son las listas de file que representan .class
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ClassLoader clas=fileManager.getClassLoader(location);

		try {
			Class sample=clas.loadClass("SampleTest");//cargo la clase SampleTest
			System.out.println("MMM:"+sample.getName());
			Method[] metodos=sample.getDeclaredMethods();
			Method main=metodos[0];
			Object obj=sample.newInstance();
			main.invoke(obj,null );
			for(Method me:metodos){
				System.out.println(" :"+me);	
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
