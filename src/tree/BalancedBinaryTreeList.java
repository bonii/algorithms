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
 * BalancedBinaryTreeList.java created on Jan 27, 2015
 *
 **/
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Simple Balanced Binary Tree Implementation
 * 
 */
public class BalancedBinaryTreeList<T extends Processor> implements
		BinaryTree<T> {
	private BinaryTreeNode<T> root = null;

	private void add(T data, BinaryTreeNode<T> node) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data, null, null);
		if (node == null) {
			node = newNode;
			if (root == null) {
				root = newNode;
				return;
			}
		}
		Queue<BinaryTreeNode<T>> levelQueue = new ConcurrentLinkedDeque<>();
		levelQueue.add(node);
		while (!levelQueue.isEmpty()) {
			BinaryTreeNode<T> currentNode = levelQueue.poll();
			if (currentNode.getLeftTree() == null) {
				currentNode.setLeftTree(newNode);
				return;
			} else if (currentNode.getRightTree() == null) {
				currentNode.setRightTree(newNode);
				return;
			} else {
				levelQueue.offer(currentNode.getLeftTree());
				levelQueue.offer(currentNode.getRightTree());
			}
		}
	}

	private void delete(T data, BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}
		// Not implemented
	}

	public void add(T data) {
		if (data == null) {
			return;
		}
		add(data, root);
	}

	public void delete(T data) {
		delete(data, root);
	}

	private void processInPreOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultSet) {
		if (node == null || resultSet == null) {
			return;
		}
		resultSet.add(node);
		processInPreOrder(node.getLeftTree(), resultSet);
		processInPreOrder(node.getRightTree(), resultSet);
	}

	private void processInOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultSet) {
		if (node == null) {
			return;
		}
		processInOrder(node.getLeftTree(), resultSet);
		resultSet.add(node);
		processInOrder(node.getRightTree(), resultSet);
	}

	private void processInPostOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultSet) {
		if (node == null) {
			return;
		}
		processInPostOrder(node.getLeftTree(), resultSet);
		processInPostOrder(node.getRightTree(), resultSet);
		resultSet.add(node);
	}

	public void processInPreOrder() {
		List<BinaryTreeNode<T>> resultSet = new ArrayList<>();
		processInPreOrder(root, resultSet);
		for (BinaryTreeNode<T> node : resultSet) {
			node.getData().process();
		}
	}

	public void processInOrder() {
		List<BinaryTreeNode<T>> resultSet = new ArrayList<>();
		processInOrder(root, resultSet);
		for (BinaryTreeNode<T> node : resultSet) {
			node.getData().process();
		}
	}

	public void processInPostOrder() {
		List<BinaryTreeNode<T>> resultSet = new ArrayList<>();
		processInPostOrder(root, resultSet);
		for (BinaryTreeNode<T> node : resultSet) {
			node.getData().process();
		}
	}

	public static void main(String[] args) {
		BalancedBinaryTreeList<StringProcessor> myList = new BalancedBinaryTreeList<>();
		myList.add(new StringProcessor("a"));
		myList.add(new StringProcessor("b"));
		myList.add(new StringProcessor("c"));
		myList.add(new StringProcessor("d"));
		myList.add(new StringProcessor("e"));
		myList.add(new StringProcessor("f"));
		myList.add(new StringProcessor("g"));
		myList.processInPreOrder();
		System.out.println();
		myList.processInOrder();
		System.out.println();
		myList.processInPostOrder();
	}

}
