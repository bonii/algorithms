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
 * SimpleQueue.java created on Jan 26, 2015
 *
 **/
package interfaces;

/**
 * Simple queue operations
 *
 */
public interface SimpleQueue<T> extends BasicDataStructure {

	/**
	 * Enqueue an element at the end of the queue
	 * @param data the element to be enqueued
	 */
	public void enqueue(T data) ;
	
	/**
	 * Dequeue an element from the front of the queue
	 * @return the element at the front of the queue
	 */
	public T dequeue();
	
	/**
	 * Peek into the queue
	 * @return the element at the front of the queue
	 */
	public T peek();
	
	/**
	 * Convert the queue to string
	 * @return the string representation
	 */
	public String toString();
}
