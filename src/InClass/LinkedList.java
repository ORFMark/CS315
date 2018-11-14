package InClass;
/**
 * @author      Mark Burrell burrelm1 @ my.erau.edu
 * @version     1.0 Homework assignment 7
 */

public class LinkedList {
	SingleLink head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		// TODO
		return head == null;
	}

	public void insertAsHead(SingleLink newLink) {
		// TODO
		newLink.setNext(head);
		head = newLink;
	}

	public SingleLink removeHead() {
		// TODO
		if(!isEmpty()) {
			SingleLink oldHead = head;
			head = head.getNext();
			return oldHead;
		}
		else {
			return null;
		}
	}

	public SingleLink removeTail() {
		SingleLink oldTail;
		SingleLink i = head;
		if(!isEmpty()) {
			if(i.getNext() != null) {
				while(i.getNext().getNext() != null) {
					i = i.getNext();
				}
				oldTail = i.getNext();
				i.setNext(null);
				return oldTail;
			}
			else {
				oldTail = head;
				head = null;
				return oldTail;
			}
		}
		else {
			return null;
		}
	}
	
	public boolean hasValue(String value) {
		SingleLink current = head;
		while(current != null) {
			if (current.toString().equals(value)) {
				return true;
			}
		}
		return false;
	}
	public void display() {
		// TODO
		for(SingleLink i = head; i != null; i = i.getNext()) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
