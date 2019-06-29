package common;

import org.testng.Reporter;

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
