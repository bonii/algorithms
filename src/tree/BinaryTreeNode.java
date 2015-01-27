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
 * BinaryTreeNode.java created on Jan 27, 2015
 *
 **/
package tree;

/**
 * Represents a binary tree node
 */
public class BinaryTreeNode<T> {
	private T data = null;
	private BinaryTreeNode<T> leftTree = null;
	private BinaryTreeNode<T> rightTree = null;
	
	public BinaryTreeNode(T data, BinaryTreeNode<T> leftTree, BinaryTreeNode<T> rightTree) {
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BinaryTreeNode<T> getLeftTree() {
		return leftTree;
	}
	public void setLeftTree(BinaryTreeNode<T> leftTree) {
		this.leftTree = leftTree;
	}
	public BinaryTreeNode<T> getRightTree() {
		return rightTree;
	}
	public void setRightTree(BinaryTreeNode<T> rightTree) {
		this.rightTree = rightTree;
	}
	
	
}
