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
 * Utility.java created on Jan 28, 2015
 *
 **/
package utils;

/**
 * @author bonii
 * 
 */
public class Utility {

	/**
	 * Swap two elements in an array
	 * @param input the array which contains the elements
	 * @param index1 the index of first element to be sorted
	 * @param index2 the index of second element to be sorted
	 */
	public static <T> void swap(T[] input, int index1, int index2) {
		if (input == null) {
			return;
		}

		T temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

	/**
	 * Check if two elements are in correct order depending on the sort order
	 * @param firstElement the first element to be checked
	 * @param secondElement the second  element to be checked
	 * @param ascendingSortOrder the order which is needed
	 * @return true if they are in order, false otherwise
	 */
	public static <T extends Comparable<? super T>> boolean areElementsOrdered(
			T firstElement, T secondElement, boolean ascendingSortOrder) {
		if (ascendingSortOrder) {
			return firstElement.compareTo(secondElement) <= 0;
		} else {
			return firstElement.compareTo(secondElement) >= 0;
		}
	}

}
