package objectequalmethodtests;

import java.util.*;

/**
 * @author Sage Fremont
 * This class shows examples of the equal() method in use
 * Also provides examples of what ideally can be done,
 * what should not be done, and what deprecation is.
 */

public class ObjectsEqualMethodTests {

	@SuppressWarnings("deprecation") //suppresses deprecation warnings

	public static void main(String[] args) {

		/** equal() method for Strings */
		String str1="hello";  
		String str2="hello";
		String str3="Hello"; 
		String str4="goodbye";  
		System.out.println("str1 equals str2: " + str1.equals(str2)); //true 
		System.out.println("str1 equals str3: " + str1.equals(str3)); //false; case is not the same
		System.out.println("str2 equals str4: " + str2.equals(str4) + "\n"); //false; content is not the same


		/** equal() method for Dates (deprecated)
		 * Deprecated means this method is still usable, but you should NOT use it. 
		 * This method will be gradually be phased out. 
		 * However, I still see programmers still using this method often. */
		Date date1 = new Date(70, 1, 10); // (year, month, day)
		Date date2 = new Date(70, 1, 10);
		Date date3 = new Date(85, 5, 10);
		boolean check1 = date1.equals(date2);
		boolean check2 = date1.equals(date3);
		System.out.println("date1 equals date2: " + check1); //true
		System.out.println("date2 equals date3: " + check2 + "\n"); //false


		/** equal() method for Dates to the exact second in epoch long format
		 * Represents the specified number of seconds since the standard base time 
		 * known as "the epoch", namely January 1, 1970, 00:00:00 GMT. */
		Date longDate1 = new Date();
		Date longDate2 = new Date();
		Date longDate3 = new Date();
		longDate1.setTime(1531681177L); // July 15th, 2018 : 18H 59M 36S
		longDate2.setTime(1531681177L); // July 15th, 2018 : 18H 59M 36S
		longDate3.setTime(1531681809L); // July 15th, 2018 : 19H 10M 08S
		boolean longCheck1 = longDate1.equals(longDate2);
		boolean longCheck2 = longDate2.equals(longDate3);
		System.out.println("LongDate1 equals LongDate2: " + longCheck1); //true
		System.out.println("LongDate2 equals LongDate3: " + longCheck2 + "\n"); //false

	}
}
