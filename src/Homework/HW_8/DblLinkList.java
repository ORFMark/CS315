package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class DblLinkList {
	protected DblLink head;
	protected DblLink tail;
	
	public DblLinkList() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insertAtHead(DblLink newLink) {
		newLink.setNext(head);
		if (isEmpty())
			tail = newLink;
		else
			head.setPrevious(newLink);
		head = newLink;
	}

}
