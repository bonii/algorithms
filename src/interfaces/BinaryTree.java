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
 * BinaryTree.java created on Jan 27, 2015
 *
 **/
package interfaces;

import tree.TreeTraversalType;

/**
 * Interface for a binary tree
 * 
 */
public interface BinaryTree<T> extends BasicDataStructure {

	/**
	 * Add an element to the binary tree
	 * 
	 * @param data
	 *            the element to be added
	 */
	public void add(T data);

	/**
	 * Delete a node from the tree
	 * 
	 * @param data
	 *            the element to be deleted
	 */
	public void delete(T data);

	/**
	 * Process the nodes by traversing the tree in the way specified
	 * 
	 * @param traversalType
	 *            the way to traverse the tree
	 */
	public void traverseAndProcess(TreeTraversalType traversalType);

}
