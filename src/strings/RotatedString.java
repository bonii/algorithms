package strings;

import java.util.Scanner;

/**
 * Checks if a string is a rotated copy of another
 * watermelon <-> melonwater
 * @author bonii
 *
 */
public class RotatedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			String original = in.next();
			String checkString = in.next();
			if (original.length() != checkString.length()
					|| original.length() == 0) {
				System.out.println("NO");

				return;
			}
			StringBuilder repeatedOriginal = new StringBuilder(original);
			repeatedOriginal.append(original);

			if (repeatedOriginal.indexOf(checkString) < 0) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		} finally {
			in.close();
		}
	}
}
