package InClass;

public class BinaryNode {
	protected BinaryNode left;
	protected BinaryNode right;
	protected BinaryNode parent;
	protected int data;
	
	BinaryNode(int data) {
		this.data = data;
		parent = null;
		left = null;
		right = null;
	}
	public BinaryNode getLeft() {
		return left;
	}
	public void setLeft(BinaryNode left) {
		this.left = left;
	}
	public BinaryNode getRight() {
		return right;
	}
	public void setRight(BinaryNode right) {
		this.right = right;
	}
	public BinaryNode getParent() {
		return parent;
	}
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}
	
}
