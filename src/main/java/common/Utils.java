package common;

import org.testng.Reporter;

/**
 * This is a utility class which contains all the common methods across the framework.
 * @author Suranga J
 *
 */
public class Utils {

	/**
	 * This will print the given text message in the console  log and testng report
	 * @param text This is the required text message which needs to be print
	 */
	public static void Print(String text) {
		System.out.println(text);
		Reporter.log(text);
	}
}
