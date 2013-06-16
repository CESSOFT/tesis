package testgenviewsemiautomatico.src;

import testgenviewsemiautomatico.util.UtilTestGen;

import com.sun.tools.javadoc.Main;




public class GeneraDoc {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
                String arg[]={""};
                arg[0]="E:\\TESIS\\TestGen4j\\Sample1.java";
		String[] para={"-doclet",
                "testgenviewsemiautomatico.testgent4j.SpikeTestGen",
                args[0],
                "-d",
                UtilTestGen.getPatchRepoDoble()};
		Main.execute(para);
		}

	}
