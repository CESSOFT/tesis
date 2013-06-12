/**
 * TestCaseLogger.java
 * TestGen4J is licensed under Open Software License 2.1
 * For details, please refer to:
 * http://www.opensource.org/licenses/osl-2.1.php   
 */
package testgenviewsemiautomatico.testgent4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Generates LogTestCase.java that logs successful and failed test cases
 * while test case execution.
 *
 */
public class TestCaseLogger {
    /**
     * This method logs the test cases which are failed.
     *
     * @param outputDIR
     *                      Name of output directory.
     * @param classname 
     * @throws IOException
     *                      Throws IOException.
     */
    public final void logTestCase(
       final String outputDIR, String classname) throws IOException {

            BufferedWriter out = logTestCase1(outputDIR,classname);
            logTestCase2(out, outputDIR);
            logTestCase3(out, outputDIR);
            logTestCase4(out, outputDIR);
            out.write("/**"); out.newLine();
            out.write("* Creates an XML file to store");
            out.newLine();
            out.write("* failed test cases.");
            out.newLine(); out.newLine();
            out.write("* @param outputDIR"); out.newLine();
            out.write("*                   Name of the output directory.");
            out.newLine();
            out.write("* @throws IOException"); out.newLine();
            out.write("*                      "
                  + "Throws IOException."); out.newLine();
            out.write("*/"); out.newLine(); out.newLine();
            out.write(" public static void createFailedXMLDataFile(");
            out.newLine();
            out.write("  final String outputDIR) throws IOException {");
            out.newLine(); out.newLine();
            out.write("  File file = new File(outputDIR, \"failedData.xml\");");
            out.newLine();
            out.write("  BufferedWriter out = new"); out.newLine();
            out.write("     BufferedWriter(new FileWriter(file, true));");
            out.newLine();
            out.write("  out.write(\"<?xml version = \\\"1.0\\\" "
                 + "encoding = \\\"UTF-8\\\"?>\");");
            out.newLine();
            out.write("  out.newLine();"); out.newLine();
            out.write("  out.write(\"<tests xmlns:xsi = \\\"http://\"");
            out.newLine();
            out.write(" + \"www.w3.org/2001/XMLSchema-instance\\\"\");");
            out.newLine();
            out.write("  out.newLine();"); out.newLine();
            out.write("  out.write(\"        xsi:noNamespaceSchemaLocation\"");
            out.newLine();
            out.write("     + \"= \\\"/root/workspace/spiketestgen/src/com/\"");
            out.newLine();
            out.write("     + \"spikesource/unitfab/failedData.xsd\\\">\");");
            out.newLine(); out.write("  out.newLine();");
            out.newLine(); out.write("  out.flush();");
            out.newLine(); out.write("  out.close();");
            out.newLine();
            out.write(" }");
            out.newLine(); out.newLine();
            out.write("/**"); out.newLine();
            out.write("* Ends XML file that stores failed test cases.");
            out.newLine(); out.newLine();
            out.write("* @param outputDIR"); out.newLine();
            out.write("*                   Name of the output directory.");
            out.newLine();
            out.write("* @throws IOException"); out.newLine();
            out.write("*                      "
                  + "Throws IOException."); out.newLine();
            out.write("*/"); out.newLine(); out.newLine();
            out.write(" public static void endFailedXMLDataFile(");
            out.newLine();
            out.write("  final String outputDIR) throws IOException {");
            out.newLine(); out.newLine();
            out.write("  File file = new File(outputDIR, \"failedData.xml\");");
            out.newLine();
            out.write("  BufferedWriter out = new"); out.newLine();
            out.write("    BufferedWriter(new FileWriter(file, true));");
            out.newLine();
            out.write("  out.write(\"</tests>\");");
            out.newLine();
            out.write("  out.flush();");
            out.newLine();
            out.write("  out.close();");
            out.newLine();
            out.write(" }");
            out.newLine(); out.newLine();

            out.write("/**"); out.newLine();
            out.write("* Ends XML file that stores failed test cases.");
            out.newLine(); out.newLine();
            out.write("* @param outputDIR"); out.newLine();
            out.write("*                   Name of the output directory.");
            out.newLine();
            out.write("* @throws IOException"); out.newLine();
            out.write("*                      "
                  + "Throws IOException."); out.newLine();
            out.write("*/"); out.newLine(); out.newLine();
            out.write(" public static void createFailedTestLog(");
            out.newLine();
            out.write("  final String outputDIR) throws IOException {");
            out.newLine(); out.newLine();
            out.write("  File file = new File("
                  + "outputDIR, \"TestFailure.log\");");
            out.newLine();
           /* out.write("  File TestFail = new File("
                  + "outputDIR, \"TestFail.txt\");");
            out.newLine();
            out.write(" try{ TestFail.createNewFile(); }catch (Exception e){System.out.println(e);}");
            out.newLine();CES*/
            out.write("  BufferedWriter out = new"); out.newLine();
            out.write("    BufferedWriter(new FileWriter(file, true));");
            out.newLine();
            out.write("  out.write(\"This File contains Test Cases ");
            out.write("which failed\");");
            out.newLine();
            out.write("  out.newLine();");
            out.newLine();
            out.write("  out.newLine();");
            out.newLine();
            out.write("  out.newLine();");
            out.newLine();
            out.write("  out.flush();");
            out.newLine();
            out.write("  out.close();");
            out.newLine();
            out.write(" }");
            out.newLine();
            out.write("}"); out.newLine(); out.newLine();
            out.flush();
            out.close();
    }

    /**
     * LogTestCase 1.
     *
     * @param outputDIR
     *                      Output Directory.
     * @param classname 
     * @return
     *                      BufferedWriter object.
     * @throws IOException
     *                      Throws IOException.
     */
    public final BufferedWriter logTestCase1(
        final String outputDIR, String classname) throws IOException {
        BufferedWriter out;
        String testClassFileName = classname+"LogTestCase.java";
        File file = new File(outputDIR, testClassFileName);

        if (file.exists()) {
            file.delete();
        }

        out = new BufferedWriter(new FileWriter(file, true));
        out.write("package testgenviewsemiautomatico.repository;");
        out.newLine();
        out.write("/**"); out.newLine();
        out.write("* Generated by CESSOFT");
        out.newLine();
        out.write("*");
        out.newLine();
        out.write("*/"); out.newLine(); out.newLine();
        out.write("import java.io.BufferedWriter;");
        out.newLine();
        out.write("import java.io.File;");
        out.newLine();
        out.write("import java.io.FileWriter;");
        out.newLine();
        out.write("import java.io.IOException;");
        out.newLine();
        out.newLine();
        out.write("/**");
        out.newLine();
        out.write("* This class log successful and failed test cases.");
        out.newLine();
        out.write("*/");
        out.newLine();
        out.write("public final class "+classname+"LogTestCase {");
        out.newLine();
        out.newLine();
        out.write("/**");
        out.newLine();
        out.write("* Local object of "+classname+"PackageTestSuite class.");
        out.newLine();
        out.write("*/");
        out.newLine(); out.newLine();
        out.write("    private static "+classname+"PackageTestSuite pkgsuite;");
        out.newLine(); out.newLine();
        out.write("/**"); out.newLine();
        out.write("* Private constructor for LogTestCase.");
        out.newLine();
        out.write("*/");
        out.newLine(); out.newLine();
        out.write(" private "+classname+"LogTestCase() {"); out.newLine();
        out.newLine();
        out.write(" }");
        out.newLine(); out.newLine();
        out.write("/**"); out.newLine();
        out.write("* Logs successful test cases for original");
        out.newLine();
        out.write("* method having more than one arguments.");
        out.newLine(); out.newLine();
        out.write("* @param testClassName"); out.newLine();
        out.write("*                      Name of the test class.");
        out.newLine();
        out.write("* @param methodName"); out.newLine();
        out.write("*                      Test method name.");
        out.newLine();
        out.write("* @param parameters"); out.newLine();
        out.write("*                      "
              + "Arguments of the original method.");
        out.newLine(); out.newLine();
        out.write("* @param successfulTestCase"); out.newLine();
        out.write("*                      "
              + "Successful test case number.");
        out.newLine(); out.newLine();
        out.write("* @throws IOException"); out.newLine();
        out.write("*                      "
                + "Throws IOException.");
          out.newLine();
        out.write("*/"); out.newLine(); out.newLine();
        out.write(" public static void logSuccessfulTest(");
        out.newLine();
        out.write("    final String testClassName,"); out.newLine();
        out.write("    final String methodName,"); out.newLine();
        out.write("    final Object[] parameters,"); out.newLine();
        out.write("    final String successfulTestCase)"); out.newLine();
        out.write("     throws IOException {");
        out.newLine(); out.newLine();
        out.write("    File logFile = new File(\"" + outputDIR
            + "\" , \"TestSuccess.log\");");
        out.newLine();
          out.write("    File testOK = new File(\"" + outputDIR
            + "\" , \"TestOK.txt\");");
        out.newLine();
        out.write(" try{ testOK.createNewFile(); }catch (Exception e){System.out.println(e);}");
        out.newLine();
        out.write("    BufferedWriter out;");
        out.newLine(); out.newLine();
        out.write("    out = new BufferedWriter("); out.newLine();
        out.write("        new FileWriter(logFile, true));");
        out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Congratulation: Asserting test\"");
        out.newLine();
        out.write("       + \"result Succeed\"); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Class: \""
          + "       + testClassName); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Method: \""
          + "       + methodName); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Case No: \""
          + "       + successfulTestCase); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    for (int i = 0;"); out.newLine();
        out.write("      i < parameters.length;"); out.newLine();
        out.write("    i++) {"); out.newLine();
        out.write("            if (parameters[i] == null) {");
        out.newLine();
        out.write("              out.write(\"* var\" + (i + 1)");
        out.newLine();
        out.write("               + \": Value--> NULL\"); out.newLine();");
        out.newLine();
        out.write("            } else {"); out.newLine();
        out.write("              out.write(\"* var\" + (i + 1)");
        out.newLine();
        out.write("               + \" : Value--> \" + parameters[i].");
        out.newLine();
        out.write("               toString()); out.newLine();");
        out.newLine();
        out.write("            }");
        out.newLine();
        out.write("         }");
        out.newLine(); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.flush();");
        out.newLine();
        out.write("    out.close();");
        out.newLine();
        out.write("  }");
        out.newLine(); out.newLine();
        out.flush(); return out; //out.close();
    }

    /**
     * LogTestCase Method 2.
     *
     * @param out
     *                       BufferedWriter Object.
     * @param outputDIR
     *                       Output directory.
     * @throws IOException
     *                       Throws IOException.
     */
    public final void logTestCase2(
        final BufferedWriter out,
        final String outputDIR) throws IOException {

        out.write("/**"); out.newLine();
        out.write("* Logs successful test cases for original");
        out.newLine();
        out.write("* method having only one arguments.");
        out.newLine(); out.newLine();
        out.write("* @param testClassName"); out.newLine();
        out.write("*                      Name of the test class.");
        out.newLine();
        out.write("* @param methodName"); out.newLine();
        out.write("*                      Test method name.");
        out.newLine();
        out.write("* @param parameters"); out.newLine();
        out.write("*                      "
              + "Argument of the original method.");
        out.newLine(); out.newLine();
        out.write("* @param successfulTestCase"); out.newLine();
        out.write("*                      "
              + "Successful test case number.");
        out.newLine(); out.newLine();
        out.write("* @throws IOException"); out.newLine();
        out.write("*                      "
              + "Throws IOException."); out.newLine();
        out.write("*/"); out.newLine(); out.newLine();
        out.write(" public static void logSuccessfulTest(");
        out.newLine();
        out.write("    final String testClassName,"); out.newLine();
        out.write("    final String methodName,"); out.newLine();
        out.write("    final Object parameters,"); out.newLine();
        out.write("    final String successfulTestCase)"); out.newLine();
        out.write("     throws IOException {");
        out.newLine();
        out.newLine();
        out.write("    File logFile = new File(\"" + outputDIR
            + "\" , \"TestSuccess.log\");");
        out.newLine();
        out.write("    File testOK = new File(\"" + outputDIR
            + "\" , \"TestOK.txt\");");
        out.newLine();
        out.write(" try{ testOK.createNewFile(); }catch (Exception e){System.out.println(e);}");
        out.write("    BufferedWriter out;");
        out.newLine(); out.newLine();
        out.write("    out = new BufferedWriter("); out.newLine();
        out.write("        new FileWriter(logFile, true));");
        out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Congratulation: Asserting test\"");
        out.newLine();
        out.write("       + \"result Succeed\"); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Class: \""
          + "       + testClassName); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Method: \""
          + "       + methodName); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Case No: \""
          + "       + successfulTestCase); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    if (parameters == null) {");
        out.newLine();
        out.write("              out.write(\"* var1\"");
        out.newLine();
        out.write("               + \": Value--> NULL\"); out.newLine();");
        out.newLine();
        out.write("    } else {"); out.newLine();
        out.write("              out.write(\"* var1\"");
        out.newLine();
        out.write("               + \" : Value--> \" + parameters.");
        out.newLine();
        out.write("               toString()); out.newLine();");
        out.newLine();
        out.write("    }");
        out.newLine(); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.flush();");
        out.newLine();
        out.write("    out.close();");
        out.newLine();
        out.write("  }");
        out.newLine(); out.newLine();
        out.flush(); //out.close();
    }

    /**
     * LogTestCase Method 3.
     *
     * @param out
     *                      BufferedWriter object.
     * @param outputDIR
     *                      Output Directory.
     * @throws IOException
     *                      Throws IOException.
     */
    public final void logTestCase3(
        final BufferedWriter out,
        final String outputDIR) throws IOException {

        out.write("/**"); out.newLine();
        out.write("* Logs failed test cases for original");
        out.newLine();
        out.write("* method having more than one arguments.");
        out.newLine(); out.newLine();
        out.write("* @param testClassName"); out.newLine();
        out.write("*                      Name of the test class.");
        out.newLine();
        out.write("* @param methodName"); out.newLine();
        out.write("*                      Test method name.");
        out.newLine();
        out.write("* @param parameters"); out.newLine();
        out.write("*                      "
              + "Argument of the original method.");
        out.newLine(); out.newLine();
        out.write("* @param failedTestCase"); out.newLine();
        out.write("*                      "
              + "Failed test case number.");
        out.newLine(); out.newLine();
        out.write("* @param error"); out.newLine();
        out.write("*                      "
              + "Error description.");
        out.newLine(); out.newLine();
        out.write("* @throws IOException"); out.newLine();
        out.write("*                      "
              + "Throws IOException."); out.newLine();
        out.write("*/"); out.newLine(); out.newLine();
        out.write(" public static void logFailedTest(");
        out.newLine();
        out.write("    final String testClassName,"); out.newLine();
        out.write("    final String methodName,"); out.newLine();
        out.write("    final Object[] parameters,"); out.newLine();
        out.write("    final String failedTestCase,"); out.newLine();
        out.write("    final String error)"); out.newLine();
        out.write("     throws IOException {");
        out.newLine(); out.newLine();
        out.write("    File logFile = new File(\"" + outputDIR
            + "\", \"TestFailure.log\");");
        out.newLine();
         out.write("    File TestFail = new File(\"" + outputDIR
            + "\", \"TestFail.txt\");");
        out.newLine();
        out.write(" try{ TestFail.createNewFile(); }catch (Exception e){System.out.println(e);}");
        out.newLine();
        out.write("    File failedXMLDataFile = new File(");
        out.newLine();
        out.write("     \"" + outputDIR + "\" , \"failedData.xml\");");
        out.newLine();
        out.write("    BufferedWriter out;");
        out.newLine(); out.newLine();
        out.write("    if (!pkgsuite.excludeFileExists) {");
        out.newLine();
        out.write("       out = new BufferedWriter(new FileWriter(");
        out.newLine();
        out.write("          failedXMLDataFile, true));");
        out.newLine();
        out.write("       out.write(\"                <class name\"");
        out.newLine();
        out.write("       + \"= \\\"\" + testClassName + \"\\\" > \");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                        ");
        out.write("       <method name\"");
        out.newLine();
        out.write("       + \"= \\\"\" + methodName + \"\\\" test-case\"");
        out.newLine();
        out.write("       + \"= \\\"\" + failedTestCase + \"\\\" > \");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                        ");
        out.write("</method>\");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                </class>\");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.flush();"); out.newLine();
        out.write("       out.close();"); out.newLine();
        out.write("    }"); out.newLine(); out.newLine();
        out.write("    out = new BufferedWriter(new FileWriter(");
        out.newLine();
        out.write("        logFile, true));"); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.write(\"* Error: \" + error); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Class: \" + testClassName);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.write("    out.write(\"* Test Method: \" + methodName);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.write("    out.write(\"* Failed Test Case: \" "
                  + "       + failedTestCase);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.newLine();
        out.write("    for (int i = 0;"); out.newLine();
        out.write("      i < parameters.length;"); out.newLine();
        out.write("    i++) {"); out.newLine();
        out.write("            if (parameters[i] == null) {");
        out.newLine();
        out.write("              out.write(\"* var\" + (i + 1)");
        out.newLine();
        out.write("               + \": Value--> NULL\"); out.newLine();");
        out.newLine();
        out.write("            } else {"); out.newLine();
        out.write("              out.write(\"* var\" + (i + 1)");
        out.newLine();
        out.write("               + \" : Value--> \" + parameters[i].");
        out.newLine();
        out.write("               toString()); out.newLine();");
        out.newLine();
        out.write("            }");
        out.newLine();
        out.write("         }");
        out.newLine(); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.flush();");
        out.newLine();
        out.write("    out.close();");
        out.newLine();
        out.write("  }");
        out.newLine(); out.newLine();
        out.flush(); //out.close();
    }

    /**
     * LogTestCase Method 4.
     *
     * @param out
     *                       BufferedWriter object.
     * @param outputDIR
     *                       Output directory.
     * @throws IOException
     *                       Throws IOException.
     */
    public final void logTestCase4(
        final BufferedWriter out,
        final String outputDIR) throws IOException {

        out.write("/**"); out.newLine();
        out.write("* Logs failed test cases for original");
        out.newLine();
        out.write("* method having only one argument.");
        out.newLine(); out.newLine();
        out.write("* @param testClassName"); out.newLine();
        out.write("*                      Name of the test class.");
        out.newLine();
        out.write("* @param methodName"); out.newLine();
        out.write("*                      Test method name.");
        out.newLine();
        out.write("* @param parameters"); out.newLine();
        out.write("*                      "
              + "Argument of the original method.");
        out.newLine(); out.newLine();
        out.write("* @param failedTestCase"); out.newLine();
        out.write("*                      "
              + "Failed test case number.");
        out.newLine(); out.newLine();
        out.write("* @param error"); out.newLine();
        out.write("*                      "
              + "Error description.");
        out.newLine(); out.newLine();
        out.write("* @throws IOException"); out.newLine();
        out.write("*                      "
              + "Throws IOException."); out.newLine();
        out.write("*/"); out.newLine(); out.newLine();
        out.write(" public static void logFailedTest(");
        out.newLine();
        out.write("    final String testClassName,"); out.newLine();
        out.write("    final String methodName,"); out.newLine();
        out.write("    final Object parameters,"); out.newLine();
        out.write("    final String failedTestCase,"); out.newLine();
        out.write("    final String error)"); out.newLine();
        out.write("     throws IOException {");
        out.newLine(); out.newLine();
        out.write("    File logFile = new File(\"" + outputDIR
            + "\", \"TestFailure.log\");");
        out.newLine();
          out.write("    File TestFail = new File(\"" + outputDIR
            + "\", \"TestFail.txt\");");
        out.newLine();
        out.write(" try{ TestFail.createNewFile(); }catch (Exception e){System.out.println(e);}");
        out.newLine();
        out.write("    File failedXMLDataFile = new File(");
        out.newLine();
        out.write("     \"" + outputDIR + "\" , \"failedData.xml\");");
        out.newLine();
        out.write("    BufferedWriter out;");
        out.newLine(); out.newLine();
        out.write("    if (!pkgsuite.excludeFileExists) {");
        out.newLine();
        out.write("       out = new BufferedWriter(new FileWriter(");
        out.newLine();
        out.write("          failedXMLDataFile, true));");
        out.newLine();
        out.write("       out.write(\"                <class name\"");
        out.newLine();
        out.write("       + \"= \\\"\" + testClassName + \"\\\" > \");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                        ");
        out.write("       <method name\"");
        out.newLine();
        out.write("       + \"= \\\"\" + methodName + \"\\\" test-case\"");
        out.newLine();
        out.write("       + \"= \\\"\" + failedTestCase + \"\\\" > \");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                        ");
        out.write("</method>\");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.write(\"                </class>\");");
        out.newLine();
        out.write("       out.newLine();"); out.newLine();
        out.write("       out.flush();"); out.newLine();
        out.write("       out.close();"); out.newLine();
        out.write("    }"); out.newLine(); out.newLine();
        out.write("    out = new BufferedWriter(new FileWriter(");
        out.newLine();
        out.write("        logFile, true));"); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.write(\"* Error: \" + error); out.newLine();");
        out.newLine();
        out.write("    out.write(\"* Test Class: \" + testClassName);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.write("    out.write(\"* Test Method: \" + methodName);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.write("    out.write(\"* Failed Test Case: \" "
                  + "       + failedTestCase);");
        out.newLine(); out.write("    out.newLine();"); out.newLine();
        out.newLine();
        out.write("            if (parameters == null) {");
        out.newLine();
        out.write("              out.write(\"* var1\"");
        out.newLine();
        out.write("               + \": Value--> NULL\"); out.newLine();");
        out.newLine();
        out.write("            } else {"); out.newLine();
        out.write("              out.write(\"* var1\"");
        out.newLine();
        out.write("               + \" : Value--> \" + parameters.");
        out.newLine();
        out.write("               toString()); out.newLine();");
        out.newLine();
        out.write("            }");
        out.newLine(); out.newLine();
        out.write("    out.write(\"***********************************\"");
        out.newLine();
        out.write("       + \"*************************************\"");
        out.newLine();
        out.write("       + \"**************\"); out.newLine();");
        out.newLine(); out.newLine();
        out.write("    out.flush();");
        out.newLine();
        out.write("    out.close();");
        out.newLine();
        out.write("  }");
        out.newLine(); out.newLine();
        out.flush(); //out.close();
    }

}

