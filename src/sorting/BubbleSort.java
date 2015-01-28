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
 * BubbleSort.java created on Jan 25, 2015
 *
 **/
package sorting;

import utils.Utility;

/**
 * Classic BubbleSort or Sinking Sort (Art of Computer Programming)
 * Best case -> n
 * 
 */
public class BubbleSort<T extends Comparable<? super T>> {
	private T[] input = null;
	private boolean ascendingSortOrder = true;

	BubbleSort(T[] input, boolean sortAscendingOrder) {
		this.input = input;
		this.ascendingSortOrder = sortAscendingOrder;
	}

	public void sort() {
		if (input == null) {
			return;
		}
		int lastSwapped = input.length - 1;
		while (lastSwapped > 0) {
			int lastSwappedCopy = 0;
			for (int i = 0; i < lastSwapped; i++) {
				if (!Utility.areElementsOrdered(input[i], input[i + 1],ascendingSortOrder)) {
					Utility.swap(input, i, i+1);
					lastSwappedCopy = i + 1;
				}
			}
			lastSwapped = lastSwappedCopy;
		}
	}
	
	public T[] getInput() {
		return input;
	}

	public static void main(String[] args) {
		Integer[] array = { 41, 95, -2, 100, 82, 34, 51, 12 };
		BubbleSort<Integer> sorter = new BubbleSort<>(array, true);
		sorter.sort();
		for (Integer num : sorter.getInput()) {
			System.out.print(num + " ");
		}
	}
}
