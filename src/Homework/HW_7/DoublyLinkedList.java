package Homework.HW_7;

/**
 * @author Mark Burrell burrelm1 @ my.erau.edu
 * @version 1.0 Homework assignment 7
 */

public class DoublyLinkedList {
	DoubleLink head = null;
	DoubleLink tail = null;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		// TODO
		return head == null;
	}

	public void insertAsHead(DoubleLink newLink) {
		// TODO
		newLink.setNext(head);
		newLink.setPrevious(null);
		if (head != null) {
			head.setPrevious(newLink);
			head = newLink;
		}
		if (tail == null) {
			head = newLink;
			tail = newLink;
		}

	}

	public void insertAsTail(DoubleLink newLink) {
		// ToDo
		newLink.setNext(null);
		newLink.setPrevious(tail);
		if (tail != null) {
			tail.setNext(newLink);
		}
		tail = newLink;
		if (head == null) {
			head = tail;
		}
	}

	public DoubleLink removeHead() {
		DoubleLink oldHead = null;
		if (!isEmpty()) {
			oldHead = head;
			head = head.getNext();
			if (head != null) {
				head.setPrevious(null);
			} else {
				tail = null;
			}
		}
		return oldHead;
	}

	public DoubleLink removeTail() {
		DoubleLink oldTail = null;
		if (!isEmpty()) {
			oldTail = tail;
			tail = tail.getPrevious();
			if (tail != null) {
				tail.setNext(null);
			} else {
				head = null;
			}
		}
		return oldTail;
	}

	public void display() {
		// TODO
		for (DoubleLink i = head; i != null; i = i.getNext()) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
