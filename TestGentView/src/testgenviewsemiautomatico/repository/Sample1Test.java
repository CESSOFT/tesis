package testgenviewsemiautomatico.repository;
/**
* Generated by CESSOFT

*/

import java.util.Vector;
import java.util.HashMap;
import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import org.jtestcase.JTestCase;
import org.jtestcase.JTestCaseException;
import org.jtestcase.TestCaseInstance;
import java.util.Iterator;


/**
* Test cases for class Sample1.
 */
public class Sample1Test extends TestCase  {

/**
* JTestCase Instance to be used in this example.
*/
private JTestCase jtestcase = null;

/**
* local object for class Sample1LogTestCase.
*/
private static Sample1LogTestCase logObject;

/**
* local object for class Sample1PackageTestSuite.
*/
private static Sample1PackageTestSuite pkgsuite;

/**
* Main method to run the example from command line.
* @param args
*             command line parameters
*/
public static void main(final String[] args) {
    junit.textui.TestRunner.run(suite());
}

/**
* Read the XML file with the test data
* and build the JTestCase instance.
*

* @param name
*        Test method name.
*/

public Sample1Test(final String name) {
 super(name);

 try {
     File excludedTestsFile = new File("C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\", "failedData.xml");
     String dataFile = "C:\\Users\\tpbm68\\Documents\\TesisProject\\TestGentView\\src\\testgenviewsemiautomatico\\repository\\data.xml";
       jtestcase = new JTestCase(dataFile,
        "Sample1Test");
 } catch (Exception e) {
       e.printStackTrace();
 }

}

/**
* Suite method that collects all test cases.
*
* @return
*         The test suite
*/
public static Test suite() {
    TestSuite retval = new TestSuite();
    retval.addTest(new Sample1Test(
      "testAddition"));
    retval.addTest(new Sample1Test(
      "testSubtraction"));
    retval.addTest(new Sample1Test(
      "testDivision"));
    retval.addTest(new Sample1Test(
      "testOtraCosa"));
    retval.addTest(new Sample1Test(
      "testAlgoRaro"));
    return retval;
}


/**
* Tests for the method addition.
*
* @throws IOException
*                     Throws IOException
*/
public final void testAddition() throws IOException {

    String failedTestCase = "", successfulTestCase = "", variable = "var";
    final int max = 2;
    Object[] parameters = new Object[max];
    boolean succeed = false, excludeTestCase = false;
    String methodName = "testAddition";
    Sample1ParseFailedDataFile fd = null;

    try {
        /**
        * Running test cases in a loop.
        */
        Vector testCases = jtestcase.getTestCasesInstancesInMethod(
methodName);
        String[] failedTestCases = fd.getFailedTestCases(
            "Sample1Test",
            "testAddition");

        // for each test case
        for (int i = 0; i < testCases.size(); i++) {
            // retrieve name of test case
            TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);


        if (pkgsuite.excludeFileExists) {
            for (int k = 0; k < failedTestCases.length; k++)  {
                if (failedTestCases[k].equals(testCase)) {
                         System.out.println("This test case is not going to be"
                           + "executed  " + pkgsuite.excludeFileExists);
                         excludeTestCase = true;
                }
            }
        }

        if (!excludeTestCase) {
             pkgsuite.totalTestCases++;
            try {            // get hashed params for this test case
 HashMap<String, Object> params = testCase.getTestCaseParams();
          for (int j = 0; j < params.size(); j++) {
                variable = variable + (j + 1);
                parameters[j] = params.get(variable);
                variable = "var";
            }

            int var1 = ((Integer) params.get("var1")).intValue();

            int var2 = ((Integer) params.get("var2")).intValue();

            /* Now comes to what we need to test.
               we don't want Exceptions to break our tests,
            so we catch Exceptions here. */



            Sample1 tempObject = new Sample1();

            int
            result
            =
            tempObject.addition(var1,
            var2);
            // asserting result:
if (testCase.getTestCaseAssertValues() != null && !testCase.getTestCaseAssertValues().keySet().isEmpty()) {Iterator<String[]> iterator = testCase.getTestCaseAssertValues().keySet().iterator();	while (iterator.hasNext()) {		String[] a = iterator.next();		boolean succeedd = testCase.assertTestVariable(a[0], result);		succeed=succeedd;	}}            if (succeed) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                   methodName, parameters,
                  successfulTestCase);

            } else {
                String myError = "Fail to test "
                  + "addition when asserting result!";
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
            }
            } catch (JTestCaseException e) {
                String myError = "Unexpected exception is thrown"
                  + "from JTestCase: " + e.getMessage();
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
 System.err.print("Error executing test case  " + testCase.getTestCaseName()); e.printStackTrace(); continue;        } catch (Exception e) {
            String exc ="testAddition"+ failedTestCase;
            if (exc != null && e.toString().startsWith(exc)) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                  methodName, parameters,
                  successfulTestCase);

            } else {
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase,
                  "Unexpected exception is caught");
              e.printStackTrace();
            }
 }
        }
        excludeTestCase = false;
      }
    } catch (Exception e) {
        if (e instanceof java.lang.NullPointerException) {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, "Null Pointer Exception caught");
        } else {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName,
                  parameters, failedTestCase, "Unexpected "
                  + "exception is caught");
    }
 }
}

/**
* Tests for the method subtraction.
*
* @throws IOException
*                     Throws IOException
*/
public final void testSubtraction() throws IOException {

    String failedTestCase = "", successfulTestCase = "", variable = "var";
    final int max = 2;
    Object[] parameters = new Object[max];
    boolean succeed = false, excludeTestCase = false;
    String methodName = "testSubtraction";
    Sample1ParseFailedDataFile fd = null;

    try {
        /**
        * Running test cases in a loop.
        */
        Vector testCases = jtestcase.getTestCasesInstancesInMethod(
methodName);
        String[] failedTestCases = fd.getFailedTestCases(
            "Sample1Test",
            "testSubtraction");

        // for each test case
        for (int i = 0; i < testCases.size(); i++) {
            // retrieve name of test case
            TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);


        if (pkgsuite.excludeFileExists) {
            for (int k = 0; k < failedTestCases.length; k++)  {
                if (failedTestCases[k].equals(testCase)) {
                         System.out.println("This test case is not going to be"
                           + "executed  " + pkgsuite.excludeFileExists);
                         excludeTestCase = true;
                }
            }
        }

        if (!excludeTestCase) {
             pkgsuite.totalTestCases++;
            try {            // get hashed params for this test case
 HashMap<String, Object> params = testCase.getTestCaseParams();
          for (int j = 0; j < params.size(); j++) {
                variable = variable + (j + 1);
                parameters[j] = params.get(variable);
                variable = "var";
            }

            int var1 = ((Integer) params.get("var1")).intValue();

            int var2 = ((Integer) params.get("var2")).intValue();

            /* Now comes to what we need to test.
               we don't want Exceptions to break our tests,
            so we catch Exceptions here. */



            Sample1 tempObject = new Sample1();

            int
            result
            =
            tempObject.subtraction(var1,
            var2);
            // asserting result:
if (testCase.getTestCaseAssertValues() != null && !testCase.getTestCaseAssertValues().keySet().isEmpty()) {Iterator<String[]> iterator = testCase.getTestCaseAssertValues().keySet().iterator();	while (iterator.hasNext()) {		String[] a = iterator.next();		boolean succeedd = testCase.assertTestVariable(a[0], result);		succeed=succeedd;	}}            if (succeed) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                   methodName, parameters,
                  successfulTestCase);

            } else {
                String myError = "Fail to test "
                  + "subtraction when asserting result!";
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
            }
            } catch (JTestCaseException e) {
                String myError = "Unexpected exception is thrown"
                  + "from JTestCase: " + e.getMessage();
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
 System.err.print("Error executing test case  " + testCase.getTestCaseName()); e.printStackTrace(); continue;        } catch (Exception e) {
            String exc ="testSubtraction"+ failedTestCase;
            if (exc != null && e.toString().startsWith(exc)) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                  methodName, parameters,
                  successfulTestCase);

            } else {
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase,
                  "Unexpected exception is caught");
              e.printStackTrace();
            }
 }
        }
        excludeTestCase = false;
      }
    } catch (Exception e) {
        if (e instanceof java.lang.NullPointerException) {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, "Null Pointer Exception caught");
        } else {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName,
                  parameters, failedTestCase, "Unexpected "
                  + "exception is caught");
    }
 }
}

/**
* Tests for the method division.
*
* @throws IOException
*                     Throws IOException
*/
public final void testDivision() throws IOException {

    String failedTestCase = "", successfulTestCase = "", variable = "var";
    final int max = 2;
    Object[] parameters = new Object[max];
    boolean succeed = false, excludeTestCase = false;
    String methodName = "testDivision";
    Sample1ParseFailedDataFile fd = null;

    try {
        /**
        * Running test cases in a loop.
        */
        Vector testCases = jtestcase.getTestCasesInstancesInMethod(
methodName);
        String[] failedTestCases = fd.getFailedTestCases(
            "Sample1Test",
            "testDivision");

        // for each test case
        for (int i = 0; i < testCases.size(); i++) {
            // retrieve name of test case
            TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);


        if (pkgsuite.excludeFileExists) {
            for (int k = 0; k < failedTestCases.length; k++)  {
                if (failedTestCases[k].equals(testCase)) {
                         System.out.println("This test case is not going to be"
                           + "executed  " + pkgsuite.excludeFileExists);
                         excludeTestCase = true;
                }
            }
        }

        if (!excludeTestCase) {
             pkgsuite.totalTestCases++;
            try {            // get hashed params for this test case
 HashMap<String, Object> params = testCase.getTestCaseParams();
          for (int j = 0; j < params.size(); j++) {
                variable = variable + (j + 1);
                parameters[j] = params.get(variable);
                variable = "var";
            }

            int var1 = ((Integer) params.get("var1")).intValue();

            int var2 = ((Integer) params.get("var2")).intValue();

            /* Now comes to what we need to test.
               we don't want Exceptions to break our tests,
            so we catch Exceptions here. */



            Sample1 tempObject = new Sample1();

            float
            result
            =
            tempObject.division(var1,
            var2);
            // asserting result:
if (testCase.getTestCaseAssertValues() != null && !testCase.getTestCaseAssertValues().keySet().isEmpty()) {Iterator<String[]> iterator = testCase.getTestCaseAssertValues().keySet().iterator();	while (iterator.hasNext()) {		String[] a = iterator.next();		boolean succeedd = testCase.assertTestVariable(a[0], result);		succeed=succeedd;	}}            if (succeed) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                   methodName, parameters,
                  successfulTestCase);

            } else {
                String myError = "Fail to test "
                  + "division when asserting result!";
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
            }
            } catch (JTestCaseException e) {
                String myError = "Unexpected exception is thrown"
                  + "from JTestCase: " + e.getMessage();
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
 System.err.print("Error executing test case  " + testCase.getTestCaseName()); e.printStackTrace(); continue;        } catch (Exception e) {
            String exc ="testDivision"+ failedTestCase;
            if (exc != null && e.toString().startsWith(exc)) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                  methodName, parameters,
                  successfulTestCase);

            } else {
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase,
                  "Unexpected exception is caught");
              e.printStackTrace();
            }
 }
        }
        excludeTestCase = false;
      }
    } catch (Exception e) {
        if (e instanceof java.lang.NullPointerException) {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, "Null Pointer Exception caught");
        } else {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName,
                  parameters, failedTestCase, "Unexpected "
                  + "exception is caught");
    }
 }
}

/**
* Tests for the method OtraCosa.
*
* @throws IOException
*                     Throws IOException
*/
public final void testOtraCosa() throws IOException {

    String failedTestCase = "", successfulTestCase = "", variable = "var";
    final int max = 3;
    Object[] parameters = new Object[max];
    boolean succeed = false, excludeTestCase = false;
    String methodName = "testOtraCosa";
    Sample1ParseFailedDataFile fd = null;

    try {
        /**
        * Running test cases in a loop.
        */
        Vector testCases = jtestcase.getTestCasesInstancesInMethod(
methodName);
        String[] failedTestCases = fd.getFailedTestCases(
            "Sample1Test",
            "testOtraCosa");

        // for each test case
        for (int i = 0; i < testCases.size(); i++) {
            // retrieve name of test case
            TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);


        if (pkgsuite.excludeFileExists) {
            for (int k = 0; k < failedTestCases.length; k++)  {
                if (failedTestCases[k].equals(testCase)) {
                         System.out.println("This test case is not going to be"
                           + "executed  " + pkgsuite.excludeFileExists);
                         excludeTestCase = true;
                }
            }
        }

        if (!excludeTestCase) {
             pkgsuite.totalTestCases++;
            try {            // get hashed params for this test case
 HashMap<String, Object> params = testCase.getTestCaseParams();
          for (int j = 0; j < params.size(); j++) {
                variable = variable + (j + 1);
                parameters[j] = params.get(variable);
                variable = "var";
            }

            float var1 = ((Float) params.get("var1")).floatValue();

            String temp = (String)params.get("var2");
            char var2;            if ((temp.equals("NULL")) || (temp.equals("null"))) {
            var2 = ' ';
            } else if (temp.equals("SPACE")) {
            var2 = ' ';
            } else {
            var2 = temp.trim().charAt(0);
            }

            short var3 = ((Short) params.get("var3")).shortValue();

            /* Now comes to what we need to test.
               we don't want Exceptions to break our tests,
            so we catch Exceptions here. */



            Sample1 tempObject = new Sample1();

            float
            result
            =
            tempObject.OtraCosa(var1,
            var2,
            var3);
            // asserting result:
if (testCase.getTestCaseAssertValues() != null && !testCase.getTestCaseAssertValues().keySet().isEmpty()) {Iterator<String[]> iterator = testCase.getTestCaseAssertValues().keySet().iterator();	while (iterator.hasNext()) {		String[] a = iterator.next();		boolean succeedd = testCase.assertTestVariable(a[0], result);		succeed=succeedd;	}}            if (succeed) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                   methodName, parameters,
                  successfulTestCase);

            } else {
                String myError = "Fail to test "
                  + "OtraCosa when asserting result!";
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
            }
            } catch (JTestCaseException e) {
                String myError = "Unexpected exception is thrown"
                  + "from JTestCase: " + e.getMessage();
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
 System.err.print("Error executing test case  " + testCase.getTestCaseName()); e.printStackTrace(); continue;        } catch (Exception e) {
            String exc ="testOtraCosa"+ failedTestCase;
            if (exc != null && e.toString().startsWith(exc)) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                  methodName, parameters,
                  successfulTestCase);

            } else {
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase,
                  "Unexpected exception is caught");
              e.printStackTrace();
            }
 }
        }
        excludeTestCase = false;
      }
    } catch (Exception e) {
        if (e instanceof java.lang.NullPointerException) {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, "Null Pointer Exception caught");
        } else {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName,
                  parameters, failedTestCase, "Unexpected "
                  + "exception is caught");
    }
 }
}

/**
* Tests for the method AlgoRaro.
*
* @throws IOException
*                     Throws IOException
*/
public final void testAlgoRaro() throws IOException {

    String failedTestCase = "", successfulTestCase = "", variable = "var";
    final int max = 3;
    Object[] parameters = new Object[max];
    boolean succeed = false, excludeTestCase = false;
    String methodName = "testAlgoRaro";
    Sample1ParseFailedDataFile fd = null;

    try {
        /**
        * Running test cases in a loop.
        */
        Vector testCases = jtestcase.getTestCasesInstancesInMethod(
methodName);
        String[] failedTestCases = fd.getFailedTestCases(
            "Sample1Test",
            "testAlgoRaro");

        // for each test case
        for (int i = 0; i < testCases.size(); i++) {
            // retrieve name of test case
            TestCaseInstance testCase = (TestCaseInstance) testCases.elementAt(i);


        if (pkgsuite.excludeFileExists) {
            for (int k = 0; k < failedTestCases.length; k++)  {
                if (failedTestCases[k].equals(testCase)) {
                         System.out.println("This test case is not going to be"
                           + "executed  " + pkgsuite.excludeFileExists);
                         excludeTestCase = true;
                }
            }
        }

        if (!excludeTestCase) {
             pkgsuite.totalTestCases++;
            try {            // get hashed params for this test case
 HashMap<String, Object> params = testCase.getTestCaseParams();
          for (int j = 0; j < params.size(); j++) {
                variable = variable + (j + 1);
                parameters[j] = params.get(variable);
                variable = "var";
            }

            long var1 = ((Long) params.get("var1")).longValue();

            long var2 = ((Long) params.get("var2")).longValue();

             byte var3 = ((Byte) params.get("var3")).byteValue();

            /* Now comes to what we need to test.
               we don't want Exceptions to break our tests,
            so we catch Exceptions here. */



            Sample1 tempObject = new Sample1();

            float
            result
            =
            tempObject.AlgoRaro(var1,
            var2,
            var3);
            // asserting result:
if (testCase.getTestCaseAssertValues() != null && !testCase.getTestCaseAssertValues().keySet().isEmpty()) {Iterator<String[]> iterator = testCase.getTestCaseAssertValues().keySet().iterator();	while (iterator.hasNext()) {		String[] a = iterator.next();		boolean succeedd = testCase.assertTestVariable(a[0], result);		succeed=succeedd;	}}            if (succeed) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                   methodName, parameters,
                  successfulTestCase);

            } else {
                String myError = "Fail to test "
                  + "AlgoRaro when asserting result!";
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
            }
            } catch (JTestCaseException e) {
                String myError = "Unexpected exception is thrown"
                  + "from JTestCase: " + e.getMessage();
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, myError);
 System.err.print("Error executing test case  " + testCase.getTestCaseName()); e.printStackTrace(); continue;        } catch (Exception e) {
            String exc ="testAlgoRaro"+ failedTestCase;
            if (exc != null && e.toString().startsWith(exc)) {
                logObject.logSuccessfulTest(
                  "Sample1Test",
                  methodName, parameters,
                  successfulTestCase);

            } else {
                logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase,
                  "Unexpected exception is caught");
              e.printStackTrace();
            }
 }
        }
        excludeTestCase = false;
      }
    } catch (Exception e) {
        if (e instanceof java.lang.NullPointerException) {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName, parameters,
                  failedTestCase, "Null Pointer Exception caught");
        } else {
        logObject.logFailedTest(
                  "Sample1Test",
                  methodName,
                  parameters, failedTestCase, "Unexpected "
                  + "exception is caught");
    }
 }
}


}


