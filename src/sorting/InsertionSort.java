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
 * SelectionSort.java created on Jan 25, 2015
 *
 **/
package sorting;

/**
 * Insertion Sort
 * Best case -> n
 */
public class InsertionSort<T extends Comparable<? super T>> {
	private T[] input = null;
	boolean ascendingSortOrder = true;

	public InsertionSort(T[] input, boolean sortAscendingOrder) {
		this.input = input;
		this.ascendingSortOrder = sortAscendingOrder;
	}

	public boolean areElementsOrdered(T firstElement, T secondElement) {
		if (ascendingSortOrder) {
			return firstElement.compareTo(secondElement) <= 0;
		} else {
			return firstElement.compareTo(secondElement) >= 0;
		}
	}

	public void sort() {
		if (input == null) {
			return;
		}

		for (int i = 1; i < input.length; i++) {
			T value = input[i];
			int sortedIndex = i;
			//Check elements to the left with value to determine the correct place of value
			while (sortedIndex > 0
					&& (!areElementsOrdered(input[sortedIndex - 1], value))) {
				input[sortedIndex] = input[sortedIndex - 1];
				sortedIndex--;
			}
			input[sortedIndex] = value;
		}
	}

	public T[] getInput() {
		return input;
	}

	public static void main(String[] args) {
		Integer[] array = { 41, 95, -2, 100, 82, 34, 51, 12 };
		InsertionSort<Integer> sorter = new InsertionSort<>(array, true);
		sorter.sort();
		for (Integer num : sorter.getInput()) {
			System.out.print(num + " ");
		}
	}

}
