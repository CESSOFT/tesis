package testgenviewsemiautomatico.src;


import com.sun.javadoc.*;
import com.sun.tools.javadoc.Main;
import java.io.*;
import java.util.*;

public class PruebaDoclet {


	 

	    
		
		
		public static boolean start(RootDoc root) {
	        ClassDoc[] classes = root.classes();
	        for (int i = 0; i < classes.length; ++i) {
	            System.out.println(classes[i]);
	        }
	        return true;
	    }
	    
	    
	    
	  public static void main(String [] arg) {
		  System.out.println("Test");
		  Main.execute("javadoc","com.spikesource.spiketestgen.SpikeTestGen",processOptionsFile("E:\\TESIS\\testGen4j\\Sample.java"));
		  
	  }  
	  
	  private static String[] processOptionsFile( final String filename )
	  {
	      final String options = readOptionsFile( filename );
	      final StringTokenizer tokens = new StringTokenizer( options );
	      final String[] jargs = new String[tokens.countTokens()];
	 
	      for ( int i = 0; i < jargs.length; ++i )
	      {
	          jargs[i] = tokens.nextToken();
	      }
	      return jargs;
	  }
	 
	  private static String readOptionsFile( final String filename )
	  {
	      final StringBuffer buffer = new StringBuffer();
	      BufferedReader br = null;
	      try
	      {
	          br = new BufferedReader( new FileReader( filename ) );
	          String line;
	          while ( (line = br.readLine()) != null )
	          {
	              buffer.append( line ).append( "\n" );
	          }
	      }
	      catch ( final IOException ioe )
	      {
	          ioe.printStackTrace();
	          buffer.setLength( 0 );
	      }
	      finally
	      {
	          if ( br != null )
	          {
	              try
	              {
	                  br.close();
	              }
	              catch ( IOException ioe )
	              {
	                  ioe.printStackTrace();
	              }
	          }
	      }
	 
	      return buffer.toString();
	  }
	
	  
}
