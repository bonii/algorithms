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
 * List.java created on Jan 24, 2015
 *
 **/
package interfaces;

import java.util.Set;

/**
 * Operations available on a list
 */
public interface SimpleCollection<T> extends BasicDataStructure {

	/**
	 * Add element at the end of list
	 * @param data element to be added
	 */
	public void add(T data) ;

	/**
	 * Add element at a position relative to first element
	 * @param offset offset from the first element
	 * @param data element to be added
	 */
	public void addAfter(int offset, T data);
	
	/**
	 * Add element at a position relative to last element
	 * @param offset offset from the last element
	 * @param data element to be added
	 */
	public void addBefore(int offset, T data);
	
	/**
	 * Return the position of the occurences
	 * @param data element to be checked
	 * @return the count of occurences
	 */
	public Set<Integer> hasOcccurencesOf(T data);
	
	/**
	 * Get the element at a position
	 * @param position the offset from the first element
	 * @return the element
	 */
	public T get(int position) ;
	
	/**
	 * Delete matching elements from the list
	 * @param data element to be deleted
	 * @return the number of nodes deleted
	 */
	public int delete (T data) ; 
	
	/**
	 * Delete the element at a position relative to the first element
	 * @param position the offset from the first element
	 */
	public void deleteAfter(int position);
	
	/**
	 * Delete the element at a position relative to the last element
	 * @param position the offset from the last element
	 */
	public void deleteBefore(int position);
	
	/**
	 * Convert the collection to string
	 * @return the string representation
	 */
	public String toString();
	
	/**
	 * Reverses a linked list in place
	 */
	public void reverse();
	
}
