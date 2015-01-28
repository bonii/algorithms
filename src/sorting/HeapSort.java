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
 * HeapSort.java created on Jan 28, 2015
 *
 **/
package sorting;

import utils.Utility;

/**
 * Simple heap sort
 * 
 */
public class HeapSort<T extends Comparable<? super T>> {
	private T[] input = null;
	boolean ascendingSortOrder = true;

	public HeapSort(T[] input, boolean sortAscendingOrder) {
		this.input = input;
		this.ascendingSortOrder = sortAscendingOrder;
	}

	private void heapify(int index, int maxIndex) {
		int left = 2 * index + 1;
		int right = 2 * index + 2;
		int swapIndex = index;

		if (left <= maxIndex
				&& !Utility.areElementsOrdered(input[left], input[swapIndex],
						ascendingSortOrder)) {
			swapIndex = left;
		}

		if (right <= maxIndex
				&& !Utility.areElementsOrdered(input[right], input[swapIndex],
						ascendingSortOrder)) {
			swapIndex = right;
		}

		if (index != swapIndex) {
			Utility.swap(input, index, swapIndex);
			heapify(swapIndex, maxIndex);
		}
	}

	private void buildHeap() {
		int lastIndex = input.length - 1;
		int start = input.length / 2 - 1;
		while (start >= 0) {
			heapify(start, lastIndex);
			start--;
		}
	}

	public void sort() {
		if (input == null) {
			return;
		}
		// Build heap first
		buildHeap();
		int lastIndex = input.length - 1;
		while (lastIndex > 0) {
			Utility.swap(input, 0, lastIndex);
			lastIndex--;
			heapify(0, lastIndex);
		}
	}

	public T[] getInput() {
		return input;
	}

	public static void main(String[] args) {
		Integer[] array = { 41, 95, -2, 100, 82, 34, 51, 12 };
		HeapSort<Integer> sorter = new HeapSort<>(array, true);
		sorter.sort();
		for (Integer num : sorter.getInput()) {
			System.out.print(num + " ");
		}
	}

}
