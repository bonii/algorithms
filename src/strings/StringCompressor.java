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
 * StringCompressor.java created on Jan 24, 2015
 *
 **/
package strings;

import java.util.Scanner;

/**
 * Compress a run of characters by their counts
 */
public class StringCompressor {
	private String input = null;

	public StringCompressor(String input) {
		this.input = input;
	}

	public void addCharacters(StringBuilder result, char ch, int counter) {
		if (counter >= 2) { // You can also add both char if the count is 2
			result.append(ch);
			result.append(counter);
		} else if (counter == 1) {
			result.append(ch);
		}
	}

	public String compressString() {
		if (input == null) {
			return null;
		} else if (input.length() == 0) {
			return input;
		}
		StringBuilder compressedString = new StringBuilder();
		char previousCharacter = input.charAt(0);
		int counter = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == previousCharacter) {
				counter++;
			} else {
				addCharacters(compressedString, previousCharacter, counter);
				counter = 1;
				previousCharacter = input.charAt(i);
			}
		}
		addCharacters(compressedString, previousCharacter, counter);
		return compressedString.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringCompressor compressor = new StringCompressor(in.nextLine());
		System.out.println(compressor.compressString());
		in.close();
	}

}
