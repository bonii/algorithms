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
 * ReverseString.java created on Jan 24, 2015

 *
 **/
package strings;

import java.util.Scanner;
import java.util.Stack;

/**
 * Reverse a string
 * 
 */
public class ReverseString {
	private String someString = null;

	public ReverseString(String someString) {
		this.someString = someString;
	}

	public String reverseUsingStack() {
		if (someString == null) {
			return null;
		}
		Stack<Character> characterStack = new Stack<>();
		for (Character ch : someString.toCharArray()) {
			characterStack.push(ch);
		}
		StringBuilder reversedString = new StringBuilder();
		while (!characterStack.empty()) {
			reversedString.append(characterStack.pop());
		}
		return reversedString.toString();
	}

	public String reverseUsingCharArray() {
		if (someString == null) {
			return null;
		}
		char[] charArrayOfString = someString.toCharArray();
		int length = charArrayOfString.length;
		for (int i = 0; i < length / 2; i++) {
			char ch = charArrayOfString[i];
			charArrayOfString[i] = charArrayOfString[length - i - 1];
			charArrayOfString[length - i - 1] = ch;
		}
		return new String(charArrayOfString);
	}

	public String reverseUsingStringBuilder() {
		if (someString == null) {
			return null;
		} else {
			return new StringBuilder(someString).reverse().toString();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ReverseString inputString = new ReverseString(in.nextLine());
		System.out.println(inputString.reverseUsingStack());
		System.out.println(inputString.reverseUsingCharArray());
		System.out.println(inputString.reverseUsingStringBuilder());
	}

}
