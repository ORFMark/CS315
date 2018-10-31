package InClass;

/*
 * Simplifed garph
 * called a binary structure
 * Trees contain subtrees
 * root: aka head
 */
public class BinaryTree {
	private BinaryNode root;


	public BinaryTree(BinaryNode root) {
		this.root = root;
	}

	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}

	public boolean insertValue(int data, BinaryNode branch) {
		if (branch == null) {
			root = new BinaryNode(data);
			return true;
		}
		if ( data > branch.getData()) {
			if (branch.getRight() != null) {
				branch = branch.getRight();
				return insertValue(data, branch);
			}
			else {
				BinaryNode temp = new BinaryNode(data);
				temp.setParent(branch);
				branch.setRight(temp);
				return true;
			}
		}
		else if (data <= branch.getData()) {
			if (branch.getLeft() != null) {
				branch = branch.getLeft();
				return insertValue(data, branch);
			}
			else {
				BinaryNode temp = new BinaryNode(data);
				temp.setParent(branch);
				branch.setLeft(temp);
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public void displayTree(BinaryNode node) {
		if(node.getLeft() != null) {
			displayTree(node.getLeft());
		}
		System.out.print(node.getData() + ", ");
		if(node.getRight() != null) {
			displayTree(node.getRight());
		}
	}
	
	public void testPopulation() {
		insertValue(30,root);
		insertValue(40,root);
		insertValue(20,root);
		insertValue(18,root);
		insertValue(26,root);
		insertValue(12,root);
		insertValue(39,root);
		insertValue(19,root);
		insertValue(17,root);
		insertValue(47, root);
		insertValue(24,root);
	}
	public boolean find(BinaryNode n, int value) {
		if (n == null) {
			return false;
		}
		else if (value < n.getData()){
			n = n.getLeft();
			return find(n, value);
		}
		else if (value > n.getData()) {
			n = n.getRight();
			return find(n, value);
		}
		else {
			return true;
		}
	}
	public BinaryNode getMin(BinaryNode n) {
		if (n != null) {
			if (n.getLeft() == null) {
				return n;
			}
			else {
				return getMin(n.getLeft());
			}
		}
		return null;
	}
	public BinaryNode getMax(BinaryNode n) {
		if (n != null) {
			if (n.getRight() == null) {
				return n;
			}
			else {
				return getMin(n.getRight());
			}
		}
		return null;
	}
	
	public void remove(BinaryNode r) {
		if(r == root) {
			root = getMin(root);
		}
		else if (r.getLeft() != null && r.getRight() == null){
			BinaryNode tempR = r.getRight();
			BinaryNode tempL = r.getLeft();
			r = getMin(r);
		}
	}
	public void test() {
		testPopulation();
		displayTree(root);
		System.out.println();
		System.out.println(find(root, root.getData()) + " " + find(root, 24) + " " + find(root, 52));
		System.out.println("Removing the head");
		remove(root);
		displayTree(root);
	}
	
}

