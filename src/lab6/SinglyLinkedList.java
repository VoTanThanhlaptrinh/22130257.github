package lab6;

import java.util.LinkedList;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return size;
	}

	// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the first element in the list.
	public E first() {
		return head.getData();
	}

	// Returns (but does not remove) the last element in the list.
	public E last() {
		return tail.getData();
	}

	Node<E> extraNode;

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		Node<E> node = new Node<E>(e, head);
		head = node;
		if (head == null) {
			tail = node;
		}
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> node = new Node<E>(e, null);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		E e = head.getData();
		Node<E> node = head;
		head = head.getNext();
		node.setData(null);
		node.setNext(null);
		size--;
		return e;

	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node<E> node = head;
		for (int i = 0; i < size - 1; i++) {
			head = head.getNext();
		}
		E e = head.getData();
		head.setNext(null);
		tail = head;
		head = node;
		size--;
		return e;
	}

	public static void main(String[] args) {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		list.addFirst("A");
		list.addFirst("B");
		list.addFirst("C");
		list.addFirst("C");
		int a = list.size();
		for (int i = 0; i < a; i++) {
			System.out.println(list.removeLast());
		}
	}
}
