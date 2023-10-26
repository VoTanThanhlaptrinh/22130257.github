package lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if (size == elements.length) {
			int newSize = size * 2;
			E[] es = (E[]) new Object[newSize];
			for (int i = 0; i < size(); i++) {
				es[i] = elements[i];
			}
			elements = es;
		}
	}

	// Returns the number of elements in this list.
	public int size() {
		return size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i];
		}
	}

	// Replaces the element at index i with e, and returns the replaced element.∗/

	public E set(int i, E e) throws IndexOutOfBoundsException {
		E e1;
		if (i < 0 || i > size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			e1 = elements[i];
			elements[i] = e;
		}
		return e1;
	}

	// It is used to append the specified element at the end of a list.

	public boolean add(E e) {
		growSize();
		elements[size] = e;
		size++;
		return true;
	}

	// Inserts element e to be at index i, shifting all subsequent elements later.

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i - size > 1) {
			throw new IndexOutOfBoundsException();
		} else {
			growSize();
			if (i < size) {
				for (int j = size + 1; j > i; j--) {
					elements[j] = elements[j - 1];
				}
			}
			elements[i] = e;
			size++;
		}

	}

	// Removes and returns the element at index i, shifting subsequent elements
	// earlier.

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		} else {
			E e = elements[i];
			for (int j = i; j < size(); j++) {
				elements[j] = elements[j + 1];
			}
			size--;
			return e;
		}

	}

	// It is used to clear all elements in the list.
	public void clear() {
		for (E e : elements) {
			e = null;
		}
		size = 0;
	}

	// It is used to return the index in this list of the last occurrence of
	// the specified element, or-1 if the list does not contain this element.

	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size() - 1; i >= 0; i--) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	// It is used to return an array containing all of the elements in this list in
	// the correct order

	public E[] toArray() {
		E[] e = (E[]) new Object[size];
		for (int i = 0; i < elements.length; i++) {
			e[i] = elements[i];
		}
		return e;
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() {
		MyArrayList<E> arrayList = new MyArrayList<E>();
		arrayList.elements = elements;
		arrayList.size = size;
		return arrayList;
	}
	// It returns true if the list contains the specified element

	public boolean contains(E o) {
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the first occurrence of
	// the specified element, or-1 if the List does not contain this element.

	public int indexOf(E o) {
		if (o == null) {
			for (int i = 0; i < size(); i++) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size(); i++) {
				if (elements[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.

	public boolean remove(E e) {
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(e)) {
				for (int j = i; j < size(); j++) {
					elements[j] = elements[j + 1];
				}
				size--;
				return false;
			}
		}
		return true;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> a = new MyArrayList<Integer>();
	}
}
