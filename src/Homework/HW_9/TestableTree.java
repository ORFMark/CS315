package Homework.HW_9;

public class TestableTree extends DrawableTree {

	public TestableTree() {
	}

	public static void run(String[] args) {
		// This test has a main that is part of the Tree class
		TestableTree t = new TestableTree();
		int count = repopulateTree(t);
		System.out.println("Testing print in order display() code");
		t.display();
		System.out.println("Printing a tree view of your tree");
		t.displayTree();
		System.out.println("Max: " + t.getMax());
		System.out.println("Min: " + t.getMin());
		System.out.println("Find 37: " + t.find(37));
		System.out.println("Find 38: " + t.find(38));
		for (int i = 1; i <= count; i++) {
			repopulateTree(t);
			int value = t.getNthValue(i);
			System.out.print(i + " (" + value + "): ");
			t.remove(value);
			t.display();
			//t.displayTree();
		}
		repopulateTree(t);
		System.out.println("Testing print breadth first: ");
		t.displayBreadthFirst();
	}

	public static int repopulateTree(TestableTree t) {
		t.clear();
		t.insert(30);
		t.insert(40);
		t.insert(37);
		t.insert(20);
		t.insert(18);
		t.insert(26);
		t.insert(12);
		t.insert(39);
		t.insert(19);
		t.insert(17);
		t.insert(47);
		t.insert(24);
		return 12;
	}

	private class Memo {
		private int val;

		protected Memo(int val) {
			this.val = val;
		}

		protected int getVal() {
			return val;
		}

		protected void setVal(int val) {
			this.val = val;
		}

		// decrement and return true if just reached zero
		protected boolean decrement() {
			val--;
			return val == 0;
		}
	}

	private void getNthValue(Memo count, Memo value, Node node) {
		if (node != null) {
			getNthValue(count, value, node.left);
			if (count.getVal() <= 0)
				// already got the requested item (on the left)
				;
			else if (count.decrement()) {
				// we are the requested item
				value.setVal(node.data);
			} else
				// requested item yet to come (on the right)
				getNthValue(count, value, node.right);
		}
	}

	public int getNthValue(int count) {
		Memo value = new Memo(0);
		getNthValue(new Memo(count), value, root);
		return value.getVal();
	}

}
