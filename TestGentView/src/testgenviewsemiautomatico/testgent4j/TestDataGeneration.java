/**
 * TestDataGeneration.java
 * TestGen4J is licensed under Open Software License 2.1
 * For details, please refer to:
 * http://www.opensource.org/licenses/osl-2.1.php   
 */
package testgenviewsemiautomatico.testgent4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 * Generates the XML data file for the test cases. The XML file
 * generated has the actual test cases to be executed. A rules file,
 * an another XML file, has boundary conditions for primitive data
 * types. This file is parsed and according to the rules for each
 * attribute as a data type, all possible combinations of the test
 * cases are generated.
 *
 */
public class TestDataGeneration {
    /**
     * Main method of the class.
     *
     * @param args
     *             Command line parameters.
     */
    public static void main(final String[] args) {
    }

    /**
     * Creates the top, common block of the XML data file.
     *
     * @param outputDIR
     *                         The output directory where data file is created.
     * @return
     *                         Returns the name of the created file.
     */
    public final String createXMLDataFile(final String outputDIR) {
        String xmlFileName = "data.xml";

        File handle = new File(outputDIR, xmlFileName);

        if (handle.exists()) {
            handle.delete();
        }

        try {
            BufferedWriter out = new
                 BufferedWriter(new FileWriter(handle, true));
            out.write("<?xml version =\"1.0\" encoding = \"UTF-8\"?>");
            out.newLine();
            out.write(" <tests xmlns:xsi=\"http://www.w3.org/"
                + "2001/XMLSchema-instance\"");
            out.newLine();
            out.write("   xsi:noNamespaceSchemaLocation=\"/usr/bin/"
                + "jtestcase-2.2.0/config/jtestcase.xsd\">");
            out.newLine();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xmlFileName;
    }

    /**
     * Writes Class details,viz., name of the class, any global
     * parameters, to the data file.
     *
     * @param classname
     *                         name of the original class under test
     * @param outputDIR
     *                         name of the output directory
     * @param filename
     *                         name of the XML data file
     */
    public final void writeClassDetailsToXMLDataFile(
        final String classname,
        final String outputDIR,
        final String filename) {

        String className = classname;
        className = className + "Test";

        File handle = new File(outputDIR, filename);

        try {
            BufferedWriter out = new BufferedWriter(
                   new FileWriter(handle, true));
            out.write("     <class name=\"" + className + "\">");
            out.newLine();
            out.write("       <!-- global params -->");
            out.newLine();
            out.write("         <params>");

            /* Global parameters will go go. I am not writing them right now.*/
            out.write("         </params>");
            out.newLine();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is the main method of this class. This method looks for the
     * type of parameters of the method under test and according to the
     * type retrieves the rules for those types from the rules file. All
     * possible combinations of the rules of all parameters forms the unit test
     * case data.
     *
     * @param methodName
     *                         Original name of the method under test.
     * @param methodReturnType
     *                         Return type of the method under test.
     * @param methodParams
     *                         All Parameters of the method under test.
     * @param numOfParams
     *                  Total number of parameters of the method in test.
     * @param outputDIR
     *                         The output directory.
     * @param filename
     *                         XML data file name.
     * @throws IOException
     *                         Throws IOException.
     */
    public final void writeMethodDetailsToXMLDataFile(
        final String methodName,
        final String methodReturnType,
        final String[] methodParams,
        final int numOfParams,
        final String outputDIR,
        final String filename) throws IOException {

        int k = 0;
        int tempCount = 0;
        int maxCount = 0;
        int getThisCount = 0;
        int u = 1;
        boolean setBreakingCondition = false;
        int[] arrayCount = new int[numOfParams];
        int[] flag = new int[numOfParams];
        String thisCombination = null;
        String name = methodName;

        String nameTmp = name.charAt(0) + "";
        nameTmp.trim();
        name = "test" + nameTmp.toUpperCase() + name.substring(1);

        File handle = new File(outputDIR, filename);

        for (int x = 0; x < numOfParams; x++) {
            StringTokenizer temp = new StringTokenizer(methodParams[x], ",");
            tempCount = temp.countTokens();

            if (maxCount < tempCount) {
                maxCount = tempCount;
            }
        }

        Object[][] paramConditions = new Object[numOfParams][maxCount];

        if ((maxCount > 1) && (numOfParams > 1)) {
            for (int p = 0; p < numOfParams; p++) {
                for (int q = 0; q < maxCount; q++) {
                    paramConditions[p][q] = "NOTFILLED";
                }
            }

            for (int i = 0; i < numOfParams; i++) {
                StringTokenizer paramDetails = new
                           StringTokenizer(methodParams[i],
                        ",");
                k = paramDetails.countTokens();

                for (int j = 0; j < k; j++) {
                    paramConditions[i][j] = (Object) paramDetails.nextToken();
                }
            } //End For

            for (int tmpvar = 0; tmpvar < numOfParams; tmpvar++) {
                arrayCount[tmpvar] = 1;
                flag[tmpvar] = 0;
            }

                BufferedWriter out = new BufferedWriter(new FileWriter(handle,
                            true));

                while (!setBreakingCondition) {
                    /* Combination of the test data happens here.*/
                    for (int m = 1; m < paramConditions[0].length; m++) {
                        thisCombination = paramConditions[0][m] + ",";
                        for (int somevar = 1; somevar < numOfParams;
                                somevar++) {
                            if (somevar < (numOfParams - 1)) {
                                thisCombination = thisCombination
                                + paramConditions[somevar][arrayCount[somevar]]
                                + ",";
                            } else if (somevar == (numOfParams - 1)) {
                                thisCombination = thisCombination
                                + paramConditions[somevar][arrayCount[somevar]];
                            }
                        }
                        thisPermutation1(out, paramConditions, thisCombination,
                            name, methodReturnType, numOfParams);
                     //if was here
                    }

                    /* End of Combination*/
                    /* Set flags for arrayCount here */
                    for (u = 1; u < numOfParams; u++) {
                        if ((arrayCount[u] == (maxCount - 1))) {
                            flag[u] = 1;
                        }
                    }

                    /*Set flags ends here */
                    /* Just check flags, process flagIncrementNextCounter */
                    for (int flagcnt = 1; flagcnt < numOfParams; flagcnt++) {
                        for (int flagCheck = 1; flagCheck < (flagcnt + 1);
                                flagCheck++) {
                            if (flag[flagCheck] != 1) {
                                break;
                            } else if (flag[flagCheck] == 1) {
                                getThisCount = flagCheck;
                            }
                        }
                    }

                    /* End processing flagIncrementNextCounter */
                    /* Start arrayCount Incrementation */
                    for (int flagcnt = 1; flagcnt < numOfParams; flagcnt++) {
                        if (getThisCount == (numOfParams - 1)) {
                            setBreakingCondition = true;
                        }

                        if (flagcnt == 1) {
                            arrayCount[flagcnt]
                            = (arrayCount[flagcnt] + 1) % (maxCount - 1);

                            if (arrayCount[flagcnt] == 0) {
                                arrayCount[flagcnt] = (maxCount - 1);
                            }
                        }

                        if (flagcnt < (getThisCount + 1)) {
                            if (flagcnt < (numOfParams - 1)) {
                                if ((arrayCount[(flagcnt + 1) % numOfParams])
                                      == (maxCount - 1)) {
                                       arrayCount[(flagcnt + 1) % numOfParams]
                                      = (arrayCount[(flagcnt + 1) % numOfParams]
                                      + 1) % (maxCount - 1);
                                } else {
                                    arrayCount[(flagcnt + 1) % numOfParams]++;
                                }
                            } else if (flagcnt == (numOfParams - 1)) {
                                System.out.println("Done");
                            }

                            flag[flagcnt] = 0;
                        }
                    }
                    /* End arrayCount incrementation */
                    getThisCount = 0;
                } //End While
                out.close();
        } else if ((maxCount > 1) && (numOfParams == 1)) { //End if (maxCount>2)

            StringTokenizer temp = new StringTokenizer(methodParams[0], ",");
            int numOfConditions = temp.countTokens();

            for (int i = 0; i < numOfConditions; i++) {
                paramConditions[0][i] = temp.nextToken();
            }

                BufferedWriter out = new BufferedWriter(new FileWriter(handle,
                            true));
                thisPermutation2(out, paramConditions, name,
                    methodReturnType, numOfConditions, numOfParams);
                out.close();
        } // End else if((maxCount>2)&&(numOfParams==1))
    }

    /**
     * The method writes the test cases in the data file for the
     * orginal methods having more than one argument.
     *
     * @param out
     *                          BufferedWriter Object.
     * @param paramConditions
     *                          Boundary condition of arguments.
     * @param thisCombination
     *                          Current combination of the values
     *                          of the arguments set in the rules.xml
     *                          file.
     * @param name
     *                          Test method name.
     * @param methodReturnType
     *                          Return type of the method.
     * @param numOfParams
     *                          No. of arguments.
     * @throws IOException
     *                          Throws IOException.
     */
    public final void thisPermutation1(
        final BufferedWriter out,
        final Object[][] paramConditions,
        final String thisCombination,
        final String name,
        final String methodReturnType,
        final int numOfParams) throws IOException {

        int paramNumber = 0;
        int caseNumber = 0;
        String varNumber = null;

        if (thisCombination.indexOf("NOTFILLED") == -1) {
            caseNumber++;

            StringTokenizer boundaryConditions = new
            StringTokenizer(thisCombination, ",");

            out.write("         <method name=\"" + name
               + "\" test-case=\"" + caseNumber + "\">");
            out.newLine();
            out.write("             <params>");
            out.newLine();

            for (int param = 0; param < numOfParams; param++) {
                paramNumber++;
                varNumber = "var" + (param + 1);

                String prm = "<param name=\"" + varNumber
                  + "\" type=\"" + paramConditions[param][0]
                  + "\">" + boundaryConditions.nextToken()
                  + "</param>";
                out.write("                " + prm);
                out.newLine();
            }

            paramNumber = 0;
            out.write("             </params>");
            out.newLine();
            out.write("            <asserts>");
            out.newLine();
            out.write("               <assertgroup name"
                  + "=\"testResult\">");
            out.newLine();

            if (methodReturnType.equals("int")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">-2147483648</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTGT\">2147483647</assert>");
                out.newLine();
            } else if (methodReturnType.equals("short")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">-32768</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTGT\">32767</assert>");
                out.newLine();
            } else if (methodReturnType.equals("float")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">1.4E-45</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
               + "\" action=\"NOTGT\">3.4028235E+38</assert>");
                out.newLine();
            } else if (methodReturnType.equals("long")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">-9223372036854775808"
                 + "</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTGT\">9223372036854775807"
                 + "</assert>");
                out.newLine();
            } else if (methodReturnType.equals("double")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">4.9E-324</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTGT\">1.7976931348623157E+308"
                 + "</assert>");
                out.newLine();
            } else if (methodReturnType.equals("String")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">null</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">\"\"</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult3\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">\" \"</assert>");
                out.newLine();
            } else if (methodReturnType.equals("char")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"NOTLT\">0</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult2\" type=\"" + methodReturnType
                 + "\" action=\"NOTGT\">9</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult3\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">'\0'</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult4\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">''</assert>");
                out.newLine();
                out.write("                 <assert name="
                 + "\"testResult5\" type=\"" + methodReturnType
                 + "\" action=\"NOTEQUALS\">' '</assert>");
                out.newLine();
            } else if (methodReturnType.equals("void")) {
                out.write("                 <assert name="
                 + "\"testResult1\" type=\"" + methodReturnType
                 + "\" action=\"EQUALS\">null</assert>");
                out.newLine();
            } else {
                out.write("                       <assert name="
                    + "\"testResult1\" type=\""
                    + methodReturnType
                    + "\" action=\"NOTEQUALS\">null</assert>");
                out.newLine();
            }

            out.write("                </assertgroup>");
            out.newLine();
            out.write("             </asserts>");
            out.newLine();
            out.write("             <exception>java.lang."
               + "NullPointerException</exception>");
            out.newLine();
            out.write("         </method>");
            out.newLine();
            out.flush();
        }
    }

    /**
     * The method writes the test cases in the data file for the
     * orginal methods having more than one argument.
     *
     * @param out
     *                          BufferedWriter Object.
     * @param paramConditions
     *                          Boundary condition of arguments.
     * @param name
     *                          Test method name.
     * @param methodReturnType
     *                          Return type of the method.
     * @param numOfConditions
     *                          Total number of boundary conditions
     *                          for the data type of the argument.
     * @param numOfParams
     *                          No. of arguments.
     * @throws IOException
     *                          Throws IOException.
     */
    public final void thisPermutation2(
        final BufferedWriter out,
        final Object[][] paramConditions,
        final String name,
        final String methodReturnType,
        final int numOfConditions,
        final int numOfParams) throws IOException {

        for (int i = 1; i < numOfConditions; i++) {
            //varNumber = "var" + i;
            out.write("        <method name=\"" + name
             + "\" test-case=\"" + i + "\">"); out.newLine();
            out.write("             <params>");
            out.newLine();
            out.write("               <param name=\"var1\" type=\""
             + paramConditions[0][0] + "\">" + paramConditions[0][i]
             + "</param>");
            out.newLine();
            out.write("             </params>");
            out.newLine();
            out.write("             <asserts>");
            out.newLine();
            out.write("                <assertgroup name="
             + "\"testResult\">"); out.newLine();

            if (methodReturnType.equals("int")) {
                out.write("                     <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">-2147483648</assert>");
                out.newLine();
                out.write("                     <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTGT\">2147483647</assert>");
                out.newLine();
            } else if (methodReturnType.equals("short")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">-32768</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTGT\">32767</assert>");
                out.newLine();
            } else if (methodReturnType.equals("float")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">1.4E-45</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTGT\">3.4028235E+38</assert>");
                out.newLine();
            } else if (methodReturnType.equals("long")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">-9223372036854775808</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTGT\">9223372036854775807</assert>");
                out.newLine();
            } else if (methodReturnType.equals("double")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">4.9E-324</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
              + "\" action=\"NOTGT\">1.7976931348623157E+308</assert>");
                out.newLine();
            } else if (methodReturnType.equals("String")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">null</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">\"\"</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult3\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">\" \"</assert>");
                out.newLine();
            } else if (methodReturnType.equals("boolean")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"EQUALS\">true</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"EQUALS\">false</assert>");
                out.newLine();
            } else if (methodReturnType.equals("char")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTLT\">0</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult2\" type=\"" + methodReturnType
                + "\" action=\"NOTGT\">9</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult3\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">'\0'</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult4\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">''</assert>");
                out.newLine();
                out.write("                <assert name="
                + "\"testResult5\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">' '</assert>");
                out.newLine();
            } else if (methodReturnType.equals("void")) {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"EQUALS\">null</assert>");
                out.newLine();
            } else {
                out.write("                <assert name="
                + "\"testResult1\" type=\"" + methodReturnType
                + "\" action=\"NOTEQUALS\">null</assert>");
                out.newLine();
            }

            out.write("                </assertgroup>");
            out.newLine();
            out.write("             </asserts>");
            out.newLine();
            out.write("             <exception>java.lang."
                + "NullPointerException</exception>");
            out.newLine();
            out.write("        </method>");
            out.newLine();
        }
        out.flush();
    }

    /**
     * End the class tag in the XML data file as test data for all methods
     * of this class are written to the data file.
     *
     * @param outputDIR
     *                         The output directory.
     * @param filename
     *                         Filename of the XML data file.
     */
    public final void endClassInXMLDataFile(
        final String outputDIR,
        final String filename) {

        File handle = new File(outputDIR, filename);

        try {
            BufferedWriter out = new
              BufferedWriter(new FileWriter(handle, true));

            out.newLine();
            out.write("     </class>");
            out.newLine();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * End the <tests> tag in the XML data file, which closes the data file.
     * </tests>
     * @param outputDIR
     *                         The output directory.
     * @param filename
     *                         name of the XML data file.
     */
    public final void endXMLDataFile(
        final String outputDIR,
        final String filename) {
        File handle = new File(outputDIR, filename);

        try {
            BufferedWriter out = new
               BufferedWriter(new FileWriter(handle, true));

            out.newLine();
            out.write(" </tests>");
            out.newLine();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
