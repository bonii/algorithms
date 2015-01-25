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
 * QuickSort.java created on Jan 25, 2015
 *
 **/
package sorting;

/**
 * Classic Quick Sort
 * 
 */
public class QuickSort<T extends Comparable<? super T>> {
	private T[] input = null;
	private boolean ascendingSortOrder = true;

	QuickSort(T[] input, boolean sortAscendingOrder) {
		this.input = input;
		this.ascendingSortOrder = sortAscendingOrder;
	}

	public boolean areElementsOrdered(T firstElement, T secondElement) {
		if (ascendingSortOrder) {
			return firstElement.compareTo(secondElement) < 0;
		} else {
			return firstElement.compareTo(secondElement) > 0;
		}
	}

	private void swap(T[] input, int index1, int index2) {
		if (input == null) {
			return;
		}

		T temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

	/**
	 ** An initial pivot can also be a random integer between these 2 indices or
	 * median value of the first element, last element and middle element of a
	 * partition (Sedgewick),
	 */
	private int chooseInitialPivot(int beginIndex, int endIndex) {
		return beginIndex + (endIndex - beginIndex) / 2; // Guard against
															// boundary
															// overflows

	}

	private int pivot(T[] input, int beginIndex, int endIndex) {
		int pivotIndex = chooseInitialPivot(beginIndex, endIndex);
		T pivotValue = input[pivotIndex];

		swap(input, pivotIndex, endIndex);
		int storeIndex = beginIndex;

		for (int i = beginIndex; i < endIndex; i++) {
			if (areElementsOrdered(input[i], pivotValue)) {
				swap(input, storeIndex, i);
				storeIndex++;
			}
		}
		swap(input, storeIndex, endIndex);
		return storeIndex;
	}

	private void sort(T[] input, int beginIndex, int endIndex) {
		if (input == null) {
			return;
		}
		if (beginIndex < endIndex) {
			int pivotIndex = pivot(input, beginIndex, endIndex);
			sort(input, beginIndex, pivotIndex - 1);
			sort(input, pivotIndex + 1, endIndex);
		}
	}

	public void sort() {
		if (input == null) {
			return;
		}
		sort(input, 0, input.length - 1);
	}

	public T[] getInput() {
		return input;
	}

	public static void main(String[] args) {
		Integer[] array = { 41, 95, -2, 100, 82, 34, 51, 12 };
		QuickSort<Integer> sorter = new QuickSort<>(array, true);
		sorter.sort();
		for (Integer num : sorter.getInput()) {
			System.out.print(num + " ");
		}
	}

}
