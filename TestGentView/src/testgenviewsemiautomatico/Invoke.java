package testgenviewsemiautomatico;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invoke {

	public static void main(String[] args) {
		new Invoke();
	}

	public Invoke() {
		//inicio
		System.out.println("... START.");

		int i = 56;

		Object result = new Object();

		//La clase a la que quiero buscarle el método
		Class c = this.getClass();
		//El arreglo de parámetros
		Object[] args_value = { new Integer(i) };
		//El arreglo con los tipos de datos de los parámetros
		Class[] args_class = { Integer.class };

		//Buscando el método
		Method m = null;
		try {
			m = c.getMethod("test", args_class);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

		//Invocando el método
		try {
			result = m.invoke(this, args_value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		//Imprimiendo resultado
		System.out.println("Result= '" + result + "'");
		
		//fin
		System.out.println("... END.");
	}

	/**
	 * Método a buscar por reflexión.
	 * @param i
	 * @return
	 */
	public String test(Integer i) {
		return "Integer=" + i.toString();
	}
}
