package testgenviewsemiautomatico.src;

import java.io.IOException;
import java.lang.reflect.*;
import testgenviewsemiautomatico.UtilTestGen;

public class EjecutarTest {



	public static void main(String [] arg) {
		System.out.println("Ejecutando : "+arg);
		UtilTestGen.removeFile();
		Class clase=null;
		try {
			clase = Class.forName("testgenviewsemiautomatico.repository."+arg[0]+"PackageTestSuite");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// forName(String className);
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//El arreglo de par�metros
		Object[] args_value = { arg };
		//El arreglo con los tipos de datos de los par�metros
		Class[] args_class = { String [].class };
		//Buscando el m�todo
		Method m = null;
		try {
			m = clase.getMethod("main", args_class);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		//Invocando el m�todo
		Object result = new Object();
		try {
			result = m.invoke(clase, args_value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

        //PackageTestSuite.main(arg);

	}  


}
