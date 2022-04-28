package strings;

import java.util.Scanner;

/**
 * The MIT License (MIT) Copyright (c) 2015 Vivek Shah Permission is hereby
 * granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * Author Vivek Shah <bonii at kernelspace.in> Reverse.java created on Jan 23,
 * 2015
 * 
 * RotatedString checks if a two strings are rotated versions of each other, all
 * whitespaces and special characters count as well
 * 
 **/
public class RotatedString {
	private String rotatedString = null;

	public RotatedString(String rotatedString) {
		this.rotatedString = rotatedString;
	}

	public boolean isRotationOf(String originalString) {
		if (originalString == null || rotatedString == null
				|| originalString.length() == 0 || rotatedString.length() == 0) {
			return false;
		}

		if (originalString.length() != rotatedString.length()) {
			return false;
		}

		StringBuilder repeatedOriginal = new StringBuilder(originalString);
		repeatedOriginal.append(originalString);

		return (repeatedOriginal.indexOf(rotatedString) < 0 ? false : true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			String original = in.next();
			String checkString = in.next();

			RotatedString stringToCheck = new RotatedString(checkString);
			if (stringToCheck.isRotationOf(original)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} finally {
			in.close();
		}
	}
}
