/** 
 * The MIT License (MIT) 
 * Copyright (c) 2015 Vivek Shah
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * 
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.

 * Author Vivek Shah <bonii at kernelspace.in>
 * PermutationChecker.java created on Jan 24, 2015
 *
 **/
package strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Checks if two string are permutations of each other
 */
public class PermutationChecker {
	private String input = null;

	public PermutationChecker(String input) {
		this.input = input;
	}

	public boolean isPermutationOf(String checkString) {
		if (input == null || checkString == null || input.length() == 0
				|| checkString.length() == 0
				|| input.length() != checkString.length()) {
			return false;
		}
		char[] characterArray1 = input.toCharArray();
		char[] characterArray2 = checkString.toCharArray();

		Arrays.sort(characterArray1);
		Arrays.sort(characterArray2);

		for (int i = 0; i < characterArray1.length; i++) {
			if (characterArray1[i] != characterArray2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PermutationChecker checker = new PermutationChecker(in.nextLine());
		System.out.println(checker.isPermutationOf(in.nextLine()));
		in.close();
	}

}
