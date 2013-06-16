package testgenviewsemiautomatico.repository;
/**
* Generated by CESSOFT
*
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* This class log successful and failed test cases.
*/
public final class SampleTestLogTestCase {

/**
* Local object of SampleTestPackageTestSuite class.
*/

    private static SampleTestPackageTestSuite pkgsuite;

/**
* Private constructor for LogTestCase.
*/

 private SampleTestLogTestCase() {

 }

/**
* Logs successful test cases for original
* method having more than one arguments.

* @param testClassName
*                      Name of the test class.
* @param methodName
*                      Test method name.
* @param parameters
*                      Arguments of the original method.

* @param successfulTestCase
*                      Successful test case number.

* @throws IOException
*                      Throws IOException.
*/

 public static void logSuccessfulTest(
    final String testClassName,
    final String methodName,
    final Object[] parameters,
    final String successfulTestCase)
     throws IOException {

    File logFile = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "TestSuccess.log");
    File testOK = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "TestOK.txt");
 try{ testOK.createNewFile(); }catch (Exception e){System.out.println(e);}
    BufferedWriter out;

    out = new BufferedWriter(
        new FileWriter(logFile, true));
    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();
    out.write("* Congratulation: Asserting test"
       + "result Succeed"); out.newLine();
    out.write("* Test Class: "       + testClassName); out.newLine();
    out.write("* Test Method: "       + methodName); out.newLine();
    out.write("* Test Case No: "       + successfulTestCase); out.newLine();

    for (int i = 0;
      i < parameters.length;
    i++) {
            if (parameters[i] == null) {
              out.write("* var" + (i + 1)
               + ": Value--> NULL"); out.newLine();
            } else {
              out.write("* var" + (i + 1)
               + " : Value--> " + parameters[i].
               toString()); out.newLine();
            }
         }

    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.flush();
    out.close();
  }

/**
* Logs successful test cases for original
* method having only one arguments.

* @param testClassName
*                      Name of the test class.
* @param methodName
*                      Test method name.
* @param parameters
*                      Argument of the original method.

* @param successfulTestCase
*                      Successful test case number.

* @throws IOException
*                      Throws IOException.
*/

 public static void logSuccessfulTest(
    final String testClassName,
    final String methodName,
    final Object parameters,
    final String successfulTestCase)
     throws IOException {

    File logFile = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "TestSuccess.log");
    File testOK = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "TestOK.txt");
 try{ testOK.createNewFile(); }catch (Exception e){System.out.println(e);}    BufferedWriter out;

    out = new BufferedWriter(
        new FileWriter(logFile, true));
    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();
    out.write("* Congratulation: Asserting test"
       + "result Succeed"); out.newLine();
    out.write("* Test Class: "       + testClassName); out.newLine();
    out.write("* Test Method: "       + methodName); out.newLine();
    out.write("* Test Case No: "       + successfulTestCase); out.newLine();

    if (parameters == null) {
              out.write("* var1"
               + ": Value--> NULL"); out.newLine();
    } else {
              out.write("* var1"
               + " : Value--> " + parameters.
               toString()); out.newLine();
    }

    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.flush();
    out.close();
  }

/**
* Logs failed test cases for original
* method having more than one arguments.

* @param testClassName
*                      Name of the test class.
* @param methodName
*                      Test method name.
* @param parameters
*                      Argument of the original method.

* @param failedTestCase
*                      Failed test case number.

* @param error
*                      Error description.

* @throws IOException
*                      Throws IOException.
*/

 public static void logFailedTest(
    final String testClassName,
    final String methodName,
    final Object[] parameters,
    final String failedTestCase,
    final String error)
     throws IOException {

    File logFile = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\", "TestFailure.log");
    File TestFail = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\", "TestFail.txt");
 try{ TestFail.createNewFile(); }catch (Exception e){System.out.println(e);}
    File failedXMLDataFile = new File(
     "C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "failedData.xml");
    BufferedWriter out;

    if (!pkgsuite.excludeFileExists) {
       out = new BufferedWriter(new FileWriter(
          failedXMLDataFile, true));
       out.write("                <class name"
       + "= \"" + testClassName + "\" > ");
       out.newLine();
       out.write("                               <method name"
       + "= \"" + methodName + "\" test-case"
       + "= \"" + failedTestCase + "\" > ");
       out.newLine();
       out.write("                        </method>");
       out.newLine();
       out.write("                </class>");
       out.newLine();
       out.flush();
       out.close();
    }

    out = new BufferedWriter(new FileWriter(
        logFile, true));
    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.write("* Error: " + error); out.newLine();
    out.write("* Test Class: " + testClassName);
    out.newLine();
    out.write("* Test Method: " + methodName);
    out.newLine();
    out.write("* Failed Test Case: "        + failedTestCase);
    out.newLine();

    for (int i = 0;
      i < parameters.length;
    i++) {
            if (parameters[i] == null) {
              out.write("* var" + (i + 1)
               + ": Value--> NULL"); out.newLine();
            } else {
              out.write("* var" + (i + 1)
               + " : Value--> " + parameters[i].
               toString()); out.newLine();
            }
         }

    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.flush();
    out.close();
  }

/**
* Logs failed test cases for original
* method having only one argument.

* @param testClassName
*                      Name of the test class.
* @param methodName
*                      Test method name.
* @param parameters
*                      Argument of the original method.

* @param failedTestCase
*                      Failed test case number.

* @param error
*                      Error description.

* @throws IOException
*                      Throws IOException.
*/

 public static void logFailedTest(
    final String testClassName,
    final String methodName,
    final Object parameters,
    final String failedTestCase,
    final String error)
     throws IOException {

    File logFile = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\", "TestFailure.log");
    File TestFail = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\", "TestFail.txt");
 try{ TestFail.createNewFile(); }catch (Exception e){System.out.println(e);}
    File failedXMLDataFile = new File(
     "C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\" , "failedData.xml");
    BufferedWriter out;

    if (!pkgsuite.excludeFileExists) {
       out = new BufferedWriter(new FileWriter(
          failedXMLDataFile, true));
       out.write("                <class name"
       + "= \"" + testClassName + "\" > ");
       out.newLine();
       out.write("                               <method name"
       + "= \"" + methodName + "\" test-case"
       + "= \"" + failedTestCase + "\" > ");
       out.newLine();
       out.write("                        </method>");
       out.newLine();
       out.write("                </class>");
       out.newLine();
       out.flush();
       out.close();
    }

    out = new BufferedWriter(new FileWriter(
        logFile, true));
    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.write("* Error: " + error); out.newLine();
    out.write("* Test Class: " + testClassName);
    out.newLine();
    out.write("* Test Method: " + methodName);
    out.newLine();
    out.write("* Failed Test Case: "        + failedTestCase);
    out.newLine();

            if (parameters == null) {
              out.write("* var1"
               + ": Value--> NULL"); out.newLine();
            } else {
              out.write("* var1"
               + " : Value--> " + parameters.
               toString()); out.newLine();
            }

    out.write("***********************************"
       + "*************************************"
       + "**************"); out.newLine();

    out.flush();
    out.close();
  }

/**
* Creates an XML file to store
* failed test cases.

* @param outputDIR
*                   Name of the output directory.
* @throws IOException
*                      Throws IOException.
*/

 public static void createFailedXMLDataFile(
  final String outputDIR) throws IOException {

  File file = new File(outputDIR, "failedData.xml");
  BufferedWriter out = new
     BufferedWriter(new FileWriter(file, true));
  out.write("<?xml version = \"1.0\" encoding = \"UTF-8\"?>");
  out.newLine();
  out.write("<tests xmlns:xsi = \"http://"
 + "www.w3.org/2001/XMLSchema-instance\"");
  out.newLine();
  out.write("        xsi:noNamespaceSchemaLocation"
     + "= \"/root/workspace/spiketestgen/src/com/"
     + "spikesource/unitfab/failedData.xsd\">");
  out.newLine();
  out.flush();
  out.close();
 }

/**
* Ends XML file that stores failed test cases.

* @param outputDIR
*                   Name of the output directory.
* @throws IOException
*                      Throws IOException.
*/

 public static void endFailedXMLDataFile(
  final String outputDIR) throws IOException {

  File file = new File(outputDIR, "failedData.xml");
  BufferedWriter out = new
    BufferedWriter(new FileWriter(file, true));
  out.write("</tests>");
  out.flush();
  out.close();
 }

/**
* Ends XML file that stores failed test cases.

* @param outputDIR
*                   Name of the output directory.
* @throws IOException
*                      Throws IOException.
*/

 public static void createFailedTestLog(
  final String outputDIR) throws IOException {

  File file = new File(outputDIR, "TestFailure.log");
  BufferedWriter out = new
    BufferedWriter(new FileWriter(file, true));
  out.write("This File contains Test Cases which failed");
  out.newLine();
  out.newLine();
  out.newLine();
  out.flush();
  out.close();
 }
}

