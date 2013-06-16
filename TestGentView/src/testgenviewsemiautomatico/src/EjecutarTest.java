package testgenviewsemiautomatico.src;

import java.io.IOException;
import java.lang.reflect.*;

import org.jtestcase.core.type.TypeConversionException;

import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

import testgenviewsemiautomatico.util.UtilTestGen;

public class EjecutarTest {



	public static void main(String [] arg) throws NoSuchMethodException, java.lang.Exception{
		System.out.println("Ejecutando : "+arg);
		UtilTestGen.removeFile();
		Class clase=null;
		try {
			clase = Class.forName("testgenviewsemiautomatico.repository."+arg[0]+"PackageTestSuite");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ClassNotFoundException(":Error al quere ejecutar");
		}// forName(String className);
		catch (SecurityException e) {
			// TODO Auto-generated catch block
			throw new SecurityException(":Error al quere ejecutar");
		}
		//El arreglo de parámetros
		Object[] args_value = { arg };
		//El arreglo con los tipos de datos de los parámetros
		Class[] args_class = { String [].class };
		//Buscando el método
		Method m = null;
		try {
			m = clase.getMethod("main", args_class);
		} catch (SecurityException e) {
			throw new SecurityException(":Error al quere ejecutar");
		} catch (NoSuchMethodException e) {
			 throw new NoSuchMethodException(":Error al quere ejecutar");
		}
		//Invocando el método
		Object result = new Object();
		try {
			result = m.invoke(clase, args_value);
		} catch (IllegalArgumentException e) {
			 throw new IllegalArgumentException(e);
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException(e+"");
		} catch (InvocationTargetException e) {
			throw new InvocationTargetException(e);
		}catch (RuntimeException e){
			throw new RuntimeException(e);
		}

        //PackageTestSuite.main(arg);

	}  


}
