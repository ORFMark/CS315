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

	// For remove, the parent must be known for replacing its child
	// Replacing the root is special because its parent is not a node
	public boolean remove(int value) {
		// if tree is empty
		// else if root is the node to replace
		//     getReplacement and make it the new root
		// else node to replace must be deeper in the tree
		//     call recursive remove to replace a deeper node
		if(root == null) {
			System.out.println("Empty Tree");
			return false;
		}
		else if (root.data == value) {
			Node replace = getReplacement(root);
			replace.left = root.left;
			replace.right = root.right;
			root = replace;
			return true;
		}
		else {
			return remove(root, value);
		}
	}

	private boolean remove(Node parentNode, int value) {
		if(parentNode == null) {
			return false;
		}
		else if (parentNode.data < value) {
			if (parentNode.right != null) {
				if (parentNode.right.data == value) {
					Node replacement = getReplacement(parentNode.right);
					parentNode.right = replacement;
					return true;
				}
				else {
					return remove(parentNode.right, value);
				}
			}
			else {
				return false;
			}
		}
		else if(parentNode.data > value) {
			if (parentNode.left != null) {
				if (parentNode.left.data == value) {
					Node replacement = getReplacement(parentNode.left);
					parentNode.left = replacement;
					return true;
				}
				else {
					return remove(parentNode.left, value);
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	private Node getReplacement(Node goner) {
		if (goner.right != null) {
			Node replacement = extricateSubtreeMin(goner.right);
			replacement.left = goner.left;
			replacement.right = goner.right;
			return replacement;
		}
		else if (goner.left != null) {
			return goner.left;
		}
		else {
			return null;
		}

	}

	private Node extricateSubtreeMin(Node parent) {
		// get subtree's min node and fix subtree where removed
		if(parent.left != null && parent.left.left != null) {
			return extricateSubtreeMin(parent.left);
		}
		else if (parent.left != null && parent.left.left == null) {
			Node min = parent.left;
			parent.left = min.right;
			return min;
		}
		else  {
			Node min = new Node(99);
			min.left = null;
			min.right = null;
			if (parent.right != null) {
				System.out.print("|");
				parent.data = parent.right.data;
				parent.left = parent.right.left;
				parent.right = parent.right.right;
			}
			else {
				System.out.print("!");
				parent = null;
			}
			return min;
		}
	}



	public void displayBreadthFirst() {
		// use a queue to create the list of Nodes in BFT order

	}
}