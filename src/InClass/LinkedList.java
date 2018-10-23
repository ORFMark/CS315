package InClass;

public class LinkedList {
	//chap 5 book
	//space created as you go
	private class Link {
		private int data;
		private Link next;
		
		Link() {
			data = 0;
			next = null;
		}
		Link(int d) {
			data = d;
			next = null;
		}
		Link(int d, Link n) {
			data = d;
			next = n;
		}
		public int getData()
		{
			return data;
		}
		
		public void setData(int d) {
			data = d;
		}
		public Link getNext()
		{
			return next;
		}
		public void setNext(Link n) {
			next = n;
		}
		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}
	Link head;
	Link tail;
	
	LinkedList() {
		head = null;
		tail = null;
	}
	public void insertAsHead(Link newHead) {
			newHead.setNext(head);
			head = newHead;
	}
	public void insertAsTail(Link newTail) {
		tail.setNext(newTail);
		tail = newTail;
		tail.setNext(null);
	}
	
	public void insert(Link newLink, int key) {
		Link test = new Link(0, head);
		while(test.getNext() != null) {
			test = test.getNext();
			if (test.getData() == key) {
				
			}
		}
	}
	@Override
	public String toString() {
		String list = null;
		for(Link current = head; current != null; current = current.getNext()) {
			if(list == null) {
				list = current.toString() + ", ";
			}
			else {
				list += current.toString() + ", ";
			}
		}
		return list;
	}
}
