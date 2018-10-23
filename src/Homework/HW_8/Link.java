package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class Link {
	private int data;
	protected Link next;
	
	public Link(int data) {
		this.data = data;
		next = null;
	}
	
	public int getData() {
		return data;
	}
	
	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

}
