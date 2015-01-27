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
 * MergeSort.java created on Jan 25, 2015
 *
 **/
package sorting;

import java.lang.reflect.Array;

/**
 * Classic Merge Sort (Split in half and merge)
 */
public class MergeSort<T extends Comparable<? super T>> {
	private T[] input = null;
	private T[] output = null; // Allocated when the sorting begins and
								// destroyed later, used only internally
	private boolean ascendingSortOrder = true;

	MergeSort(T[] input, boolean sortAscendingOrder) {
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

	private void merge(int beginIndex, int middleIndex, int endIndex) {
		int beginIndex1 = beginIndex, endIndex1 = middleIndex, beginIndex2 = middleIndex + 1, endIndex2 = endIndex,beginIndexResult=beginIndex,endIndexResult=endIndex;
		while(beginIndexResult <= endIndexResult && (beginIndex1 <= endIndex1) && (beginIndex2 <= endIndex2)) {
			if(areElementsOrdered(input[beginIndex1], input[beginIndex2])) {
				output[beginIndexResult++] = input[beginIndex1++];
			} else {
				output[beginIndexResult++] = input[beginIndex2++];
			}
		}
		while(beginIndex1 <= endIndex1) {
			output[beginIndexResult++] = input[beginIndex1++];
		}
		while(beginIndex2 <= endIndex2) {
			output[beginIndexResult++] = input[beginIndex2++];
		}
	}

	private void sort(int beginIndex, int endIndex) {
		if (input == null) {
			return;
		}
		if (beginIndex < endIndex) {
			int middleIndex = (beginIndex + endIndex )/ 2;
			sort(beginIndex, middleIndex);
			sort(middleIndex+1, endIndex);
			merge(beginIndex, middleIndex, endIndex);
			for(int i=beginIndex;i<=endIndex;i++) {
				input[i] = output[i];
			}	
		}
	}

	public void sort() {
		if (input == null) {
			return;
		}
		//Create a generic array on the fly, yay reflection :-)
		output = (T[])Array.newInstance(input.getClass().getComponentType(),input.length);
		sort(0, input.length - 1);
		output = null; // Garbage collector pick it up
	}

	public T[] getInput() {
		return input;
	}

	public static void main(String[] args) {
		Integer[] array = { 41, 95, -2, 100, 82, 34, 51, 12 };
		MergeSort<Integer> sorter = new MergeSort<>(array, true);
		sorter.sort();
		for (Integer num : sorter.getInput()) {
			System.out.print(num + " ");
		}
	}
}
