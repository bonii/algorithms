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

import interfaces.BinaryTree;

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

	private void setChild(List<BinaryTreeNode<T>> bfsNodeList, int childIndex, BinaryTreeNode<T> newNode) {
		if(bfsNodeList == null) {
			return;
		}
		int parentIndex = (childIndex - 1) / 2;
		if(bfsNodeList.size() - 1 < parentIndex) {
			return;
		}
		if(childIndex % 2 == 1) {
			bfsNodeList.get(parentIndex).setLeftTree(newNode);
		} else {
			bfsNodeList.get(parentIndex).setRightTree(newNode);
		}
	}

	public void add(T data) {
		if (data == null) {
			return;
		}

		BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data, null, null);
		if (root == null) {
			root = newNode;
			return;
		}

		List<BinaryTreeNode<T>> bfsList = new ArrayList<>();
		traverseInBreadthFirstOrder(root, bfsList, true);
		// We need to append at the end of the list so we need to find the right
		// parent
		setChild(bfsList, bfsList.size(), newNode);		
	}

	public void delete(T data) {
		List<BinaryTreeNode<T>> bfsTreeList = new ArrayList<>();
		traverseInBreadthFirstOrder(root, bfsTreeList, true);
		int counter = 0;
		for (BinaryTreeNode<T> aNode : bfsTreeList) {
			if (aNode.getData().equals(data)) {
				//Found the node to be deleted
				if(counter == bfsTreeList.size() - 1) {
					//Its the last node
					if(counter == 0) {
						//Single node in a tree 
						root = null;
						return;
					} else {
						setChild(bfsTreeList, counter, null);
						return;
					}
				} else {
					aNode.setData(bfsTreeList.get(bfsTreeList.size()-1).getData());
					setChild(bfsTreeList, bfsTreeList.size()-1,null);
					return;
				}
			}
			counter++;
		}
	}

	private void processNodes(List<BinaryTreeNode<T>> nodeList) {
		if (nodeList == null)
			return;

		for (BinaryTreeNode<T> node : nodeList) {
			node.getData().process();
		}
	}

	private void traverseInBreadthFirstOrder(BinaryTreeNode<T> rootNode,
			List<BinaryTreeNode<T>> resultList, boolean leftToRight) {
		if (rootNode == null || resultList == null) {
			return;
		}
		Queue<BinaryTreeNode<T>> levelQueue = new ConcurrentLinkedDeque<>();
		levelQueue.add(rootNode);
		while (!levelQueue.isEmpty()) {
			BinaryTreeNode<T> node = levelQueue.poll();
			resultList.add(node);
			if (leftToRight) {
				if (node.getLeftTree() != null) {
					levelQueue.add(node.getLeftTree());
				}
				if (node.getRightTree() != null) {
					levelQueue.add(node.getRightTree());
				}
			} else {
				if (node.getRightTree() != null) {
					levelQueue.add(node.getRightTree());
				}
				if (node.getLeftTree() != null) {
					levelQueue.add(node.getLeftTree());
				}
			}
		}
	}

	private void traverseInPreOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultList) {
		if (node == null || resultList == null) {
			return;
		}
		resultList.add(node);
		traverseInPreOrder(node.getLeftTree(), resultList);
		traverseInPreOrder(node.getRightTree(), resultList);
	}

	private void traverseInOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultList) {
		if (node == null) {
			return;
		}
		traverseInOrder(node.getLeftTree(), resultList);
		resultList.add(node);
		traverseInOrder(node.getRightTree(), resultList);
	}

	private void traverseInPostOrder(BinaryTreeNode<T> node,
			List<BinaryTreeNode<T>> resultList) {
		if (node == null) {
			return;
		}
		traverseInPostOrder(node.getLeftTree(), resultList);
		traverseInPostOrder(node.getRightTree(), resultList);
		resultList.add(node);
	}

	public void traverseAndProcess(TreeTraversalType traversalType) {
		List<BinaryTreeNode<T>> resultList = new ArrayList<>();
		// Java needs inline case labels as constant expressions so no class
		// qualifiers before the enum
		switch (traversalType) {
		case DEPTH_FIRST_PRE_ORDER:
			traverseInPreOrder(root, resultList);
			break;
		case DEPTH_FIRST_IN_ORDER:
			traverseInOrder(root, resultList);
			break;
		case DEPTH_FIRST_POST_ORDER:
			traverseInPostOrder(root, resultList);
			break;
		case BREADTH_FIRST_LEFT_TO_RIGHT:
			traverseInBreadthFirstOrder(root, resultList, true);
			break;
		case BREADTH_FIRST_RIGHT_TO_LEFT:
			traverseInBreadthFirstOrder(root, resultList, false);
		}
		processNodes(resultList);
	}
	
	public boolean isEmpty() {
		return (root == null);
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
		myList.traverseAndProcess(TreeTraversalType.DEPTH_FIRST_PRE_ORDER);
		System.out.println();
		myList.traverseAndProcess(TreeTraversalType.DEPTH_FIRST_IN_ORDER);
		System.out.println();
		myList.traverseAndProcess(TreeTraversalType.DEPTH_FIRST_POST_ORDER);
		System.out.println();
		myList.traverseAndProcess(TreeTraversalType.BREADTH_FIRST_LEFT_TO_RIGHT);
		System.out.println();
		myList.traverseAndProcess(TreeTraversalType.BREADTH_FIRST_LEFT_TO_RIGHT);
		System.out.println();
		myList.traverseAndProcess(TreeTraversalType.BREADTH_FIRST_RIGHT_TO_LEFT);
	}

}
