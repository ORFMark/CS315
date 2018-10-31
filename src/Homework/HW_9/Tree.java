package Homework.HW_9;

public class Tree {
	protected Node root;

	// node class for use with the tree, contains the pointers and stuff
	protected class Node {
		protected int data;
		protected Node left;
		protected Node right;
		// Added variables used to print tree
		protected int depth;
		protected int leftOffset;

		protected Node(int data) {
			this.data = data;
			left = null;
			right = null;
			depth = 0;
			leftOffset = 0;
		}
	}

	// basic constructor
	public Tree() {
		root = null;
	}

	// deletes the tree
	public void clear() {
		root = null;
	}

	// deals with adding nodes to the tree. duplicates are allowed and go to the
	// right
	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			while (true) {
				if (value < current.data) {
					// value being inserted is lower than current
					if (current.left != null) {
						current = current.left;
					} else {
						current.left = newNode;
						return;
					}
				} else {
					// value being inserted is higher (or same)
					if (current.right != null) {
						current = current.right;
					} else {
						current.right = newNode;
						return;
					}
				}
			}
		}
	}

	// publicly veiwable display (not recursive)
	public void display() {
		display(root);
		System.out.println();
	}

	private void display(Node node) {
		// in order traversal: display value between left and right
		if (node.left != null) {
			display(node.left);
		}
		System.out.print(Integer.toString(node.data) + ", ");
		if (node.right != null) {
			display(node.right);
		}
	}

	// publicly veiwable, non-recursive min.
	public int getMin() {
		if (root == null)
			return 0;
		else
			return getMin(root);
	}

	// finds the min by going as a far left as possible
	private int getMin(Node node) {
		if (node != null) {
			if (node.left != null) {
				return getMin(node.left);
			} else {
				return node.data;
			}

		}
		return 0;
	}

	public int getMax() {
		if (root == null)
			return 0;
		else
			return getMax(root);
	}

	// finds the max by going as far right as possible
	private int getMax(Node node) {
		if (node != null) {
			if (node.right != null) {
				return getMax(node.right);
			} else {
				return node.data;
			}
		}
		return 0;
	}

	public boolean find(int value) {
		return find(root, value);
	}

	private boolean find(Node node, int value) {
		// if no more to search, didn't find return false
		// else if this is it, return true
		// else if less search left (return that result)
		// else search right (return that result)
		if (node == null) {
			return false;
		} else if (node.data == value) {
			return true;
		} else if (value < node.data) {
			return find(node.left, value);
		} else if (value > node.data) {
			return find(node.right, value);
		}
		return false;
	}

	public boolean remove(int value) {
		// if tree is empty
		// else if root is the node to replace
		// getReplacement and make it the new root
		// else node to replace must be deeper in the tree
		// call recursive remove
		/*
		 * Node temp = null; if (root == null) { return false; } else if (root.data ==
		 * value) { temp = getReplacement(root); temp.right = root.right; temp.left =
		 * root.left; root = temp; } else { temp = root; while (temp != null) { if
		 * (value < temp.data) { temp = temp.left; } else if (value > temp.data) { temp
		 * = temp.right; } else { break; } } if (temp != null) { Node replacement =
		 * getReplacement(temp); replacement.left; } }
		 */

		return false;
	}

	// gets the replacement node of a node to be replaced
	private Node getReplacement(Node node) {
		Node current = null;
		if (node.right != null) {
			current = node.right;
			while (current.left != null) {
				current = current.left;
			}
			return current;
		} else if (current.left != null) {
			return current.left;
		} else {
			return null;
		}
	}

}
