package testgenviewsemiautomatico.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
	public static void main(String[] args) {
		Properties prop = new Properties();

		try {
			// set the properties value
			prop.setProperty(
					"repository",
			"C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\");
			// prop.setProperty("dbuser", "mkyong");
			// prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(new FileOutputStream("config.properties"), null);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


}
