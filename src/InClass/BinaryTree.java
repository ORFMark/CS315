package InClass;

/*
 * Simplifed garph
 * called a binary structure
 * Trees contain subtrees
 * root: aka head
 */
public class BinaryTree {
	private BinaryNode root;


	BinaryTree(BinaryNode root) {
		this.root = root;
	}

	public boolean insertValue(int data, BinaryNode branch) {
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
		System.out.print(node.getData());
		if(node.getRight() != null) {
			displayTree(node.getRight());
		}
	}
	
}

