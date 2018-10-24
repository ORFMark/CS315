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
	
}

