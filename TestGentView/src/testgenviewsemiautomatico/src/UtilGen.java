package testgenviewsemiautomatico.src;

import java.util.StringTokenizer;

//import com.sun.xml.internal.bind.util.Which;


public class UtilGen {


	public static String generaPatch(String args,String sep) {
		StringTokenizer tok = new StringTokenizer(args,sep);
		String result="";
		while (tok.hasMoreElements()) {
			result = result+tok.nextToken()+"\\\\";
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		generaPatch(args[0],args[1]);

	}

}
