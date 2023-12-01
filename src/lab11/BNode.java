package lab11;

import java.util.List;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	private int size = 1;

	public void add(E e) {
		BNode<E> n = new BNode<E>(e);
		if (!data.equals(e)) {
			size++;
			if (data.compareTo(e) > 0) {
				if (left == null) {
					left = n;
				} else {
					left.add(e);
				}
			}
			if (data.compareTo(e) < 0) {
				if (right == null) {
					right = n;
				} else {
					right.add(e);
				}
			}
		}
	}

	public int depth(E e, int n) {
		if (data.equals(e)) {
			return n;
		} else {
			if (data.compareTo(e) > 0) {
				if (left == null) {
					return -1;
				} else {
					n++;
					return left.depth(e, n);
				}
			}
			if (data.compareTo(e) < 0) {
				if (right == null) {
					return -1;
				} else {
					n++;
					return right.depth(e, n);
				}
			}
			return -1;
		}
	}

	public int height() {
		int a = depth(findMin(), 0), b = depth(findMax(), 0);
		if (a > b)
			return a + 1;
		return b + 1;
	}

	public int size() {
		return size;
	}

	public boolean contains(E e) {
		if (data.equals(e)) {
			return true;
		} else {
			if (data.compareTo(e) > 0) {
				if (left == null) {
					return false;
				}
				return left.contains(e);
			}
			if (data.compareTo(e) < 0) {
				if (right == null) {
					return false;
				}
				return right.contains(e);
			}
		}
		return false;

	}

	public E findMin() {
		if (left == null) {
			return data;
		} else {
			return left.findMin();
		}
	}

	public E findMax() {
		if (right == null) {
			return data;
		} else {
			return right.findMax();
		}
	}

	private void removeRoot(E e) {
		if (left == null && right == null) {
			data = null;
			return;
		}
		if (left != null) {
			e = left.findMax();
			remove(left.findMax());
			data = e;
			return;
		}
		if (right != null) {
			e = right.findMin();
			remove(right.findMin());
			data = e;
			return;
		}

	}

	public E remove(E e) {
		if (data.compareTo(e) == 0) {
			removeRoot(e);
			return null;
		}
		E re = helpRemove(e);
		if (data.compareTo(re) == 0) {
			if (left != null) {
				if (left.data.compareTo(e) == 0) {
					if (left.left == null && left.right == null) {
						left = null;
					} else if (left.right.findMax() != null) {
						e = left.right.findMax();
						left.remove(left.right.findMax());
						left.data = e;
					} else {
						left.data = left.left.data;
					}
				}
			}
			if (right != null) {
				if (right.data.compareTo(e) == 0) {
					if (right.left == null && right.right == null) {
						right = null;
					} else if (right.left.findMin() != null) {
						e = right.left.findMin();
						right.remove(right.left.findMin());
						right.data = e;

					} else {
						right.data = right.right.data;
					}
				}
			}
			return null;
		} else {
			if (data.compareTo(re) > 0) {
				if (left == null) {
					return null;
				}
				return left.remove(e);
			}
			if (data.compareTo(re) < 0) {
				if (right == null) {
					return null;
				}
				return right.remove(e);
			}
		}
		return null;
	}

// trả về data của node cha kề cận node cần xoá
	private E helpRemove(E e) {
		if (data.compareTo(e) == 0) {
			return data;
		} else {
			if (data.compareTo(e) > 0) {
				if (left == null) {
					return null;
				}
				if (left.data.compareTo(e) == 0) {
					return data;
				} else {
					return left.helpRemove(e);
				}
			}
			if (data.compareTo(e) < 0) {
				if (right == null) {
					return null;
				}
				if (right.data.compareTo(e) == 0) {
					return data;
				} else {
					return right.helpRemove(e);
				}
			}
		}
		return null;
	}

	public List<E> descendants(E e, List<E> list) {
		if (data.compareTo(e) == 0) {
			if (left != null) {
				list.add(left.data);
			}
			if (right != null) {
				list.add(right.data);
			}
		} else {
			if (data.compareTo(e) > 0) {
				if (left != null) {
					left.descendants(left.data, list);
				}
			}
			if (data.compareTo(e) < 0) {
				if (right != null) {
					right.descendants(right.data, list);
				}
			}
		}
		return list;

	}

	public List<E> ancestors(E e, List<E> list) {
		if (data.compareTo(e) == 0) {
			return list;
		} else {
			if (data.compareTo(e) > 0) {
				if (left == null) {
					return null;
				} else {
					list.add(data);
					return left.ancestors(e, list);
				}
			}
			if (data.compareTo(e) < 0) {
				if (right == null) {
					return null;
				} else {
					list.add(data);
					return right.ancestors(e, list);
				}
			}

		}
		return null;
	}

	public void inorder() {
		if (left != null) {
			left.inorder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.inorder();
		}

	}

	public void preorder() {
		System.out.print(data + " ");
		if (left != null) {
			left.preorder();
		}
		if (right != null) {
			right.preorder();
		}
	}

	public void postorder() {
		if (left != null) {
			left.postorder();
		}
		if (right != null) {
			right.postorder();
		}
		System.out.print(data + " ");
	}
}
