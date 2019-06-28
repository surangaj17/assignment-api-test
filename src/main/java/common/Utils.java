package common;

import org.testng.Reporter;

public class Utils {

	
	public static void Print(String text) {
		System.out.println(text);
		Reporter.log(text);
	}
}
