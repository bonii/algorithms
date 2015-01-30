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
 * LinkedList.java created on Jan 24, 2015
 *
 **/
package linkedlist;

import interfaces.SimpleCollection;
import interfaces.SimpleQueue;
import interfaces.SimpleStack;

import java.util.HashSet;
import java.util.Set;

/**
 * Simple linked list implementation
 * 
 */
public class SinglyLinkedList<T> implements SimpleCollection<T>,
		SimpleQueue<T>, SimpleStack<T> {
	private Node<T> head = null;
	private Node<T> tail = null;

	private void addAtHead(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(head);
		head = newNode;
		if (tail == null)
			tail = newNode;
	}

	private void addAtTail(T data) {
		Node<T> newNode = new Node<>(data);
		if (tail != null)
			tail.setNext(newNode);
		tail = newNode;
		if (head == null)
			head = newNode;
	}

	private void removeHead() {
		if (head == null) {
			return;
		}
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
		}
	}

	private void removeTail() {
		if (tail == null) {
			return;
		}
		if (head == tail) {
			head = tail = null;
		} else {
			Node<T> current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
	}

	private Node<T> getNodeAfter(Node<T> startNode, int offset) {
		Node<T> current = startNode;
		for (int i = 0; i < offset; i++) {
			if (current == null) {
				return null;
			}
			current = current.getNext();
		}
		return current;
	}

	/**
	 * In order to get relative to the last node, beforeNode can be null
	 */
	private Node<T> getNodeBefore(Node<T> beforeNode, int offset) {
		if (head == null) {
			return null;
		}

		Node<T> current = head;
		Node<T> runner = head;
		for (int i = 0; i < offset; i++) {
			runner = runner.getNext();
			if (runner == null) {
				return null;
			}
		}
		// Runner is offset nodes ahead
		while ((beforeNode != null && runner != beforeNode)
				|| (beforeNode == null && runner.getNext() != null)) {
			current = current.getNext();
			runner = runner.getNext();
		}
		return current;
	}

	private void deleteNode(Node<T> node) {
		if (node != null) {
			if (node.getNext() != null) {
				if (node.getNext() == tail) {
					tail = node;
				}
				node.setData(node.getNext().getData());
				node.setNext(node.getNext().getNext());
			} else {
				// We need to delete the tail node, do a full traversal in a
				// single list, better implementations are possible (use a guard
				// element)
				removeTail();
			}
		}
	}

	private boolean matchingNode(Node<T> node, T data) {
		return ((data == null && node.getData() == null) || data.equals(node
				.getData()));
	}

	public void add(T data) {
		addAtTail(data);
	}

	public void addAfter(int offset, T data) {
		Node<T> appendAtNode = getNodeAfter(head, offset);
		if (appendAtNode != null) {
			Node<T> newNode = new Node<>(data, appendAtNode.getNext());
			appendAtNode.setNext(newNode);
		} else {
			addAtTail(data);
		}
	}

	public void addBefore(int offset, T data) {
		Node<T> appendAtNode = getNodeBefore(null, offset);
		if (appendAtNode != null) {
			Node<T> newNode = new Node<>(data, appendAtNode.getNext());
			appendAtNode.setNext(newNode);
		} else {
			addAtHead(data);
		}
	}

	public Set<Integer> hasOcccurencesOf(T data) {
		Node<T> current = head;
		int offset = 0;
		Set<Integer> occurenceIndexSet = new HashSet<>();
		while (current != null) {
			if (matchingNode(current, data)) {
				occurenceIndexSet.add(offset);
			}
			offset++;
			current = current.getNext();
		}
		return occurenceIndexSet;
	}

	public T get(int position) {
		Node<T> resultNode = getNodeAfter(head, position);
		return (resultNode == null ? null : resultNode.getData());
	}

	public int delete(T data) {
		Node<T> current = head;
		int deletedNodes = 0;
		while (current.getNext() != null) {
			if (matchingNode(current.getNext(), data)) {
				deleteNode(current.getNext());
				deletedNodes++;
			} else {
				current = current.getNext();
			}
		}
		if (matchingNode(head, data)) {
			removeHead();
			deletedNodes++;
		}
		return deletedNodes;
	}

	public void deleteAfter(int position) {
		Node<T> getNodeToDelete = getNodeAfter(head, position);
		deleteNode(getNodeToDelete);
	}

	public void deleteBefore(int position) {
		Node<T> getNodeToDelete = getNodeBefore(null, position);
		deleteNode(getNodeToDelete);
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[");
		Node<T> current = head;
		while (current != null) {
			result.append(current.getData() + ",");
			current = current.getNext();
		}
		result.append("]");
		if (result.length() > 2)
			result.deleteCharAt(result.indexOf(",]"));
		return result.toString();
	}

	public void push(T data) {
		addAtHead(data);
	}

	public T pop() {
		T element = get(0);
		removeHead();
		return element;
	}

	public void enqueue(T data) {
		add(data);
	}

	public T dequeue() {
		return pop();
	}

	public T peek() {
		return get(0);
	}

	public void reverse() {
		if (head == null) {
			return;
		}
		Node<T> current = head;
		Node<T> previous = null;
		tail = head;
		while (current != null) {
			Node<T> temp = current.getNext();
			current.setNext(previous);
			previous = current;
			current = temp;
		}
		head = previous;
	}

	public boolean isEmpty() {
		return (head == null && tail == null); // Defensive programming to find
												// bugs in head tail assignments
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();
		System.out.println(newList);
		newList.add(1);
		newList.add(2);
		newList.add(3);
		newList.add(4);
		newList.add(5);
		newList.add(6);
		newList.add(7);
		System.out.println(newList);
		newList.reverse();
		System.out.println(newList);

		SimpleQueue<Integer> myQueue = new SinglyLinkedList<>();
		myQueue.enqueue(1);
		myQueue.enqueue(2);
		System.out.println(myQueue);
		myQueue.dequeue();
		System.out.println(myQueue);
		myQueue.dequeue();
		System.out.println(myQueue);

		SimpleStack<Integer> myStack = new SinglyLinkedList<>();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack);
		myStack.pop();
		System.out.println(myStack);
		myStack.pop();
		System.out.println(myStack);
	}

}
