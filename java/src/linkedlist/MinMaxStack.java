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
 * MinMaxStack.java created on Jan 30, 2015
 *
 **/
package linkedlist;

import interfaces.MinMax;
import interfaces.SimpleStack;

/**
 * A MinMaxStack supports O(1) min and max operations in addition to stack
 * operations
 */
public class MinMaxStack<T extends Comparable<? super T>> implements
		SimpleStack<T>, MinMax<T> {
	SimpleStack<T> dataStack = new SinglyLinkedList<>();
	SimpleStack<T> minStack = new SinglyLinkedList<>();
	SimpleStack<T> maxStack = new SinglyLinkedList<>();

	public void push(T data) {
		if (data == null) {
			return;
		}
		if (dataStack.isEmpty()) {
			minStack.push(data);
			maxStack.push(data);
		} else {
			if (data.compareTo(minStack.peek()) <= 0) {
				minStack.push(data);
			} else if (data.compareTo(maxStack.peek()) >= 0) {
				maxStack.push(data);
			}
		}
		dataStack.push(data);
	}

	public T pop() {
		T data = dataStack.pop();
		if (!dataStack.isEmpty()) {
			if (data.equals(minStack.peek())) {
				minStack.pop();
			} else {
				maxStack.pop();
			}
		} else {
			minStack.pop();
			maxStack.pop();
		}
		return data;
	}

	public T peek() {
		return dataStack.peek();
	}

	public T getMin() {
		return minStack.peek();
	}

	public T getMax() {
		return maxStack.peek();
	}

	public boolean isEmpty() {
		return (dataStack.isEmpty());
	}

	public String toString() {
		return dataStack.toString();
	}

	public static void main(String[] args) {
		MinMaxStack<Integer> myMinMaxStack = new MinMaxStack<>();
		myMinMaxStack.push(1);
		myMinMaxStack.push(2);
		myMinMaxStack.push(3);
		myMinMaxStack.push(-4);
		System.out.println(myMinMaxStack);
		while (!myMinMaxStack.isEmpty()) {
			System.out.print(myMinMaxStack.getMax() + " , ");
			System.out.print(myMinMaxStack.getMin());
			System.out.println();
			myMinMaxStack.pop();
		}
		System.out.println(myMinMaxStack);
	}
}
