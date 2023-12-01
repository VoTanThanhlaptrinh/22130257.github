package lab11;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		super();
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		if (root == null) {
			root = new BNode<E>(e);
		} else {
			root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {
		if (root == null) {
			return -1;
		} else {
			return root.depth(node, 0);
		}
	}

	// compute the height of BST
	public int height() {
		if (root == null) {
			return -1;
		}
		return root.height();

	}

	// Compute total nodes in BST
	public int size() {
		if (root == null) {
			return 0;
		}
		return root.size();
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		// TODO
		if (root == null) {
			return false;
		}
		return root.contains(e);
	}

	// Find the minimum element in BST
	public E findMin() {
		if (root == null) {
			return null;
		}
		return root.findMin();
	}

	// Find the maximum element in BST
	public E findMax() {
		if (root == null) {
			return null;
		}
		return root.findMax();
	}

	// Remove element e from BST
	public boolean remove(E e) {
		if (root == null) {
			return false;
		}
		root.remove(e);
		return true;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		if (root == null) {
			return null;
		}
		return root.descendants(data, new LinkedList<E>());
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		if (root == null) {
			return null;
		}
		return root.ancestors(data, new LinkedList<E>());
	}

	public void preorder() {
		if (root == null) {
			return;
		} else {
			root.preorder();
		}

	}

	public void inorder() {
		if (root == null) {
			return;
		} else {
			root.inorder();
		}

	}

	public void postorder() {
		if (root == null) {
			return;
		} else {
			root.postorder();
		}

	}

	public static void main(String[] args) {
		BST<Integer> bst = new BST<Integer>();
		bst.add(25);
		bst.add(15);
		bst.add(50);
		bst.add(10);
		bst.add(22);
		bst.add(35);
		bst.add(70);
		bst.add(4);
		bst.add(12);
		bst.add(18);
		bst.add(24);
		bst.add(31);
		bst.add(44);
		bst.add(66);
		bst.add(90);
		System.out.println(bst.height());
		System.out.println(bst.size());
		System.out.println(bst.contains(50));
		System.out.println(bst.depth(0));
		System.out.println(bst.findMin());
		System.out.println(bst.findMax());
		System.out.println(bst.descendants(15));
		System.out.println(bst.ancestors(12));
		bst.preorder();
		System.out.println(bst.remove(25));
		bst.preorder();
	}
}
