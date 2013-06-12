/**
 * SpikeTestGen.java
 * TestGen4J is licensed under Open Software License 2.1
 * For details, please refer to:
 * http://www.opensource.org/licenses/osl-2.1.php   
 */
package testgenviewsemiautomatico.testgent4j;

import com.sun.javadoc.ClassDoc;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.RootDoc;
import java.lang.reflect.Modifier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.Class;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 * SpikeTestGen is a doclet, which, with the help of class and method signatures
 * given by Classdoc , * generates unit test cases requiring just the class
 * files of the package under test. It decouples the test code and test data
 * using the open source tool called JTestCase. Unit Test cases are then fed to
 * JUnit and results are taken.
 */
public final class SpikeTestGen {
	/**
	 * The custom option value -d used to specify the directory, where the unit
	 * test cases are generated.
	 */

	private SpikeTestGen() {

	}

	/**
	 * Specifies the output directory.
	 */
	protected static final String OPTION_OUTPUT_DIR = "-d";

	/**
	 * String variable which stores the output directory.
	 */
	private static String outputDIR = null;

	/**
	 * Copyright and Start-up Notice.
	 */
	private static String copyRIGHT = "\n*****************************************"
			+ "*****************************************\n"
			+ "*********** Copyright (C) 2005 SpikeSource,"
			+ " Inc. (www.spikesource.com) ***********\n"
			+ "************************************************"
			+ "**********************************\n";

	/**
	 * Important Information.
	 */
	private static String note = "Please Note that for classes having no methods,"
			+ " including the main method, no test \n"
			+ "cases are created, and there is no entry for "
			+ "them in the Test Suite.\n\n";

	/**
	 * Main method of the doclet. Parses the information given by Classdoc in
	 * the form of class and method signatures.
	 * 
	 * @param root
	 *            Contains parsed information from Classdoc/Javadoc.
	 * @return Returns true if the operations in the method are valid.
	 */
	public static boolean start(final RootDoc root) {
		StringBuffer allParams = new StringBuffer();
		String className = "", suiteName = "";
		String dataFile;
		String packageName;
		String returnType = null;
		int flagCreateClassTestSuite = 0;
		TestDataGeneration td = new TestDataGeneration();
		TestCodeGeneration cd = new TestCodeGeneration();
		TestCaseLogger lg = new TestCaseLogger();
		ClassDoc[] classes = null;
		PackageDoc[] packageDocs;
		boolean isTestingClassNecessary = true;
		boolean isTestingMethodNecessary = true;
		packageDocs = root.specifiedPackages();
		Parameter[] pp = null;

		outputDIR = readOptions(root.options());

		dataFile = td.createXMLDataFile(outputDIR);

		printNotice(copyRIGHT);

		classes = root.classes();
		if (classes != null && classes.length > 0) {
			if ((classes.length > 0) && (flagCreateClassTestSuite != 1)) {
				flagCreateClassTestSuite = 1;
				suiteName = cd.startClassTestSuite(outputDIR, packageDocs,
						"PackageTestSuite",classes[0].typeName());
			}

			generateTestCasesForClasses(allParams, className, suiteName,
					dataFile, "", flagCreateClassTestSuite, td, cd,
					classes, isTestingClassNecessary, isTestingMethodNecessary);
		}

		for (int pkgNum = 0; pkgNum < packageDocs.length; pkgNum++) {
			packageName = packageDocs[pkgNum].toString();

			classes = packageDocs[pkgNum].ordinaryClasses();

			printNotice("\nGenerating TestSuites and TestCases for package: \""
					+ packageName + "\"\n");

			if ((classes.length > 0) && (flagCreateClassTestSuite != 1)) {
				flagCreateClassTestSuite = 1;
				suiteName = cd.startClassTestSuite(outputDIR, packageDocs,
						"PackageTestSuite",classes[0].typeName());
			}

			generateTestCasesForClasses(allParams, className, suiteName,
					dataFile, packageName, flagCreateClassTestSuite, td, cd,
					classes, isTestingClassNecessary, isTestingMethodNecessary);

		}
		if (flagCreateClassTestSuite == 1) {
			cd.endClassTestSuite(outputDIR, suiteName);
		}

		td.endXMLDataFile(outputDIR, dataFile);
		try {
			lg.logTestCase(outputDIR,classes[0].typeName());
			cd.createClassParseFailedDataFile(outputDIR,classes[0].typeName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		printNotice(note);

		return true;
	}

	private static void generateTestCasesForClasses(StringBuffer allParams,
			String className, String suiteName, String dataFile,
			String packageName, int flagCreateClassTestSuite,
			TestDataGeneration td, TestCodeGeneration cd, ClassDoc[] classes,
			boolean isTestingClassNecessary, boolean isTestingMethodNecessary) {
		String returnType;
		Parameter[] pp;
		for (int i = 0; i < classes.length; i++) {
			if ((classes[i].isAbstract()) || (classes[i].isInterface())
					|| (!classes[i].isPublic())
					|| (classes[i].toString().indexOf("$") != -1)) {
				isTestingClassNecessary = false;
			}

			if (isTestingClassNecessary) {
				MethodDoc[] methods = classes[i].methods();

				if (classes[i].toString().indexOf('.') != -1) {
					StringTokenizer name = new StringTokenizer(classes[i]
							.toString(), ".");
					className = getToken(name, name.countTokens());
				} else if (classes[i].toString().indexOf('.') == -1) {
					className = classes[i].toString();
				}

				if (methods.length > 0) {
					printNotice("Writing TestCase " + classes[i] + "Test");

					String[] methodArray = new String[methods.length];
					int[] methodNumArray = new int[methods.length];

					for (int a = 0; a < methodArray.length; a++) {
						methodArray[a] = "10101010";
						methodNumArray[a] = 0;
					}

					td.writeClassDetailsToXMLDataFile(className, outputDIR,
							dataFile);

					cd.generateTop(packageName, classes[i], outputDIR);

					for (int j = 0; j < methods.length; j++) {
						if (!methods[j].isPublic()) {
							isTestingMethodNecessary = false;
						}

						pp = methods[j].parameters();
						for (int x = 0; x < pp.length; x++) {
							if (pp[x].type().qualifiedTypeName().toString()
									.indexOf("$") != -1) {
								isTestingMethodNecessary = false;
							}
						}

						returnType = getMethodReturnType(methods[j]);

						if (returnType.indexOf("$") != -1) {
							StringTokenizer t = new StringTokenizer(returnType,
									"$");
							String mainClass = t.nextToken();
							String innerClass = t.nextToken();
							try {
								Constructor[] c = Class.forName(mainClass)
										.getConstructors();
								Class[] d = Class.forName(mainClass)
										.getDeclaredClasses();
								for (int dd = 0; dd < d.length; dd++) {
									if (d[dd].getName().equals(returnType)) {
										if (!Modifier.isPublic(d[dd]
												.getModifiers())) {
											System.out
													.println("Caught!!, The method: "
															+ methods[j]
															+ " returns: "
															+ returnType
															+ " which has an inner class"
															+ " and it is not public");
											isTestingMethodNecessary = false;
										}
									}
								}
								Constructor[] c1 = Class.forName(returnType)
										.getConstructors();
								if (c.length == 0) {
									System.out
											.println("Caught!!, The class "
													+ Class.forName(mainClass)
															.getName()
													+ " does not have a public constructor"
													+ " and so it cannot be instantiated.");
									isTestingMethodNecessary = false;
								}
							} catch (java.lang.ClassNotFoundException cnf) {
								cnf.printStackTrace();
							}
						}

						try {
							if (isTestingMethodNecessary) {
								System.out.println("Method " + methods[j]);
								testMethod(allParams, methods[j], methodArray,
										methodNumArray, j, className, dataFile);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						isTestingMethodNecessary = true;
					}

					cd.endMethodTestSuite(className, outputDIR);

					endTestClass(className);

					td.endClassInXMLDataFile(outputDIR, dataFile);

					if (flagCreateClassTestSuite == 1) {
						cd.continueClassTestSuite(outputDIR, suiteName,
								className);
					}
				}
			}

			isTestingClassNecessary = true;
		}
	}

	/**
	 * Get the method Parameter list.
	 * 
	 * @param allParams
	 *            All parameters of the method.
	 * @param method
	 *            Array of all methods.
	 * 
	 * @param methodArray
	 *            Method name for overridden methods.
	 * 
	 * @param methodNumArray
	 *            Number of overridden methods.
	 * 
	 * @param currentMethod
	 *            Integer value of current method.
	 * 
	 * @param className
	 *            Name of the original class.
	 * 
	 * @param dataFile
	 *            Name of the XML data file.
	 * @throws IOException
	 *             Throws IOException.
	 */
	public static void testMethod(final StringBuffer allParams,
			final MethodDoc method, final String[] methodArray,
			final int[] methodNumArray, final int currentMethod,
			final String className, final String dataFile) throws IOException {

		int l = 0;
		String methodName, methodReturnType;
		boolean overloaded = false;
		TestDataGeneration td = new TestDataGeneration();
		TestCodeGeneration cd = new TestCodeGeneration();

		String[] methodParams = new String[method.parameters().length];

		l = method.parameters().length;
		StringTokenizer st = new StringTokenizer(method.toString(), "(");

		methodName = st.nextToken();

		for (int a = 0; a < methodArray.length; a++) {
			if (methodArray[a].equals(methodName)) {
				overloaded = true;
				methodNumArray[currentMethod]++;
			}
		}

		methodArray[currentMethod] = methodName;

		String finalToken = st.nextToken();

		if (!finalToken.equals(")")) {
			for (int k = 0; k < (finalToken.length() - 1); k++) {
				allParams.append(finalToken.charAt(k));
			}

			methodParams = getParameters(allParams, method);
		}

		allParams.setLength(0);

		StringTokenizer getMethodName = new StringTokenizer(methodName
				.toString(), ".");

		String name = getToken(getMethodName, getMethodName.countTokens());

		if (overloaded) {
			name = name + methodNumArray[currentMethod];
		}

		methodReturnType = getMethodReturnType(method);
		td.writeMethodDetailsToXMLDataFile(name, methodReturnType,
				methodParams, l, outputDIR, dataFile);
		cd.writeTestMethod(name, methodName, methodReturnType, method
				.isStatic(), methodParams, l, outputDIR);
		cd.addTestMethodToTestSuite(className, name, outputDIR);

	}

	/**
	 * Get the method Parameter list.
	 * 
	 * @param allParams
	 *            All parameters of the method.
	 * @param method
	 *            Array of all methods.
	 * @return method Parameters
	 */
	public static String[] getParameters(final StringBuffer allParams,
			final MethodDoc method) {
		String scanType;
		String tempScanType;
		int l = 0;

		RulesEngine rules = new RulesEngine();

		System.out.println("getParameters of " + method.name());
		
		String[] methodParams = new String[method.parameters().length];

		if (allParams.toString().indexOf(",") != -1) {
			StringTokenizer singleParam = new StringTokenizer(allParams
					.toString(), ",");

			while (singleParam.hasMoreTokens()) {
				scanType = singleParam.nextToken();
				tempScanType = scanType;

				StringTokenizer dType = new StringTokenizer(scanType, ".");

				String argumentType = getToken(dType, dType.countTokens());

				argumentType = argumentType.trim();

				if (rules.getConditions(argumentType) != null) {
					methodParams[l] = argumentType + ","
							+ rules.getConditions(argumentType);
					l++;
				} else {
					methodParams[l] = tempScanType + "," + "NULL";
					l++;
				}

				scanType = "";
				tempScanType = "";
			}
		} else if (allParams.toString().indexOf(",") == -1) {
			tempScanType = allParams.toString();

			StringTokenizer dType = new StringTokenizer(allParams.toString(),
					".");

			String argumentType = getToken(dType, dType.countTokens());
			argumentType = argumentType.trim();

			if (rules.getConditions(argumentType) != null) {
				methodParams[l] = argumentType + ","
						+ rules.getConditions(argumentType);
				l++;
			} else {
				methodParams[l] = tempScanType + "," + "NULL";
				l++;
			}
		}
		return methodParams;
	}

	/**
	 * Returns the return type of original method.
	 * 
	 * @param method
	 *            Name of the original class.
	 * @return return type of the method.
	 */
	public static String getMethodReturnType(final MethodDoc method) {
		String methodReturnType;

		methodReturnType = method.returnType().qualifiedTypeName().toString();

		if ((methodReturnType.indexOf('.') != -1)
				&& (method.returnType().toString().indexOf('.') == -1)) {
			methodReturnType = "";
			StringTokenizer getMethodReturnType = new StringTokenizer(method
					.returnType().qualifiedTypeName().toString(), ".");

			int tokens = getMethodReturnType.countTokens();

			for (int r = 0; r < (tokens - 1); r++) {
				methodReturnType = methodReturnType
						+ getMethodReturnType.nextToken() + ".";
			}

			methodReturnType.trim();

			methodReturnType = methodReturnType
					+ method.returnType().toString();

		} else {
			methodReturnType = "";
			methodReturnType = method.returnType().toString();
		}
		return methodReturnType;
	}

	/**
	 * End the testclass file.
	 * 
	 * @param className
	 *            Name of the original class.
	 */
	public static void endTestClass(final String className) {
		BufferedWriter out;
		String classFileName = className + "Test.java";
		String tempFileName = className + "Test.temp.java";

		File handle = new File(outputDIR, tempFileName);
		File handle1 = new File(outputDIR, classFileName);
		String copy = "";

		try {
			if (handle.exists()) {
				BufferedReader in = new BufferedReader(new FileReader(handle));

				out = null;

				try {
					out = new BufferedWriter(new FileWriter(handle1, true));

					while ((copy = in.readLine()) != null) {
						out.write(copy);
						out.newLine();
					}

					out.newLine();
					out.write("}");
					out.newLine();
					out.newLine();
					out.newLine();
					out.flush();
					out.close();
					in.close();

					if (handle.exists()) {
						handle.delete();
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			} else {
				try {
					out = new BufferedWriter(new FileWriter(handle1, true));
					out.newLine();
					out.write("}");
					out.flush();
					out.close();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a particular token from the array of tokens, given the token
	 * number to be retrieved.
	 * 
	 * @param tokens
	 *            An array of tokens, which is an Object of StringTokenizer.
	 * @param tokenReqNum
	 *            Token Number, specifying the index of the token in request
	 * @return Returns the requested token.
	 */
	public static String getToken(final StringTokenizer tokens,
			final int tokenReqNum) {

		for (int k = 1; k < tokenReqNum; k++) {
			tokens.nextToken();
		}

		return tokens.nextToken();
	}

	/**
	 * Read the complete doclet options.
	 * 
	 * @param options
	 *            Read doclet options.
	 * 
	 * @return Output directory.
	 */
	private static String readOptions(final String[][] options) {
		Properties p = new Properties(System.getProperties());
		String outputDir = null;

		for (int i = 0; i < options.length; i++) {
			String[] opt = options[i];
			if (opt[0].equals("-d")) {
				outputDir = opt[1];
			}
		}

		if (outputDir == null) {
			outputDir = p.getProperty("user.dir");
		}

		return outputDir;
	}

	/**
	 * Retrieve the option length for a particular option.
	 * 
	 * @param option
	 *            Get the option length.
	 * @return Option length.
	 */
	public static int optionLength(final String option) {
		if (option.equals("-d")) {
			return 2;
		}
		return 0;
	}

	/**
	 * Verify if the options given are valid.
	 * 
	 * @param options
	 *            Doclet options
	 * @param reporter
	 *            Error reporter
	 * @return Returns true if the -d option is valid.
	 */
	public static boolean validOptions(final String[][] options,
			final DocErrorReporter reporter) {
		boolean foundDirOption = false;
		for (int i = 0; i < options.length; i++) {
			String[] opt = options[i];
			if (opt[0].equals("-d")) {
				if (foundDirOption) {
					reporter.printError("Only one -d option allowed.");
					return false;
				} else {
					foundDirOption = true;
				}
			}
		}
		if (!foundDirOption) {
			reporter.printError("Usage: javadoc -d " + "outputDir -doclet "
					+ "com.spikesource.spiketestgen.SpikeTestGen "
					+ "-docletpath myTestGen4JDir/bin/ "
					+ "-sourcepath myPackageSource " + "-package myPackage");
		}
		return foundDirOption;
	}

	/**
	 * This function prints the important information passed in form of String
	 * to the Standard Output.
	 * 
	 * @param msg
	 *            String to be printed as a Notice.
	 */
	public static void printNotice(final String msg) {
		System.out.println(msg);
	}
}
