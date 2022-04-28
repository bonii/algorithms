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
 * StringPermutationGenerator.java created on Jan 24, 2015
 *
 **/
package strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Generate permutations of a string (only unique characters count)
 * It would be more efficient to use a character array representation
 */
public class StringPermutationGenerator {
	private String inputString = null;

	public StringPermutationGenerator(String inputString) {
		this.inputString = inputString;
	}

	private Set<String> generatePermutations(String someString) {
		Set<String> result = new HashSet<>();
		if (someString.length() == 1) {
			result.add(new String(someString));
			return result;
		}
		char head = someString.charAt(0);
		String tail = someString.substring(1);
		for (String tailPermutation : generatePermutations(tail)) {
			if (tailPermutation.length() == 0) {
				result.add(new String()+head);
			} else {
				for (int i = 0; i <= tailPermutation.length(); i++) {
					String preInsertString = tailPermutation.substring(0, i);
					String postInsertString = tailPermutation.substring(i);
					result.add(preInsertString + head + postInsertString);
				}
			}
		}
		return result;
	}

	public Set<String> generatePermutations() {
		if (inputString == null || inputString.length() == 0) {
			return new HashSet<>();
		} else {
			return generatePermutations(inputString);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringPermutationGenerator generator = new StringPermutationGenerator(
				in.nextLine());
		System.out.println(generator.generatePermutations());
		in.close();
	}

}
