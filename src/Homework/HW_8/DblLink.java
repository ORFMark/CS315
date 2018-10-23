package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class DblLink {
	private int data;
	private DblLink next;
	private DblLink previous;

	public DblLink(int data) {
		this.data = data;
		next = null;
		previous = null;
	}

	public int getData() {
		return data;
	}

	public DblLink getNext() {
		return next;
	}

	public void setNext(DblLink next) {
		this.next = next;
	}

	public DblLink getPrevious() {
		return previous;
	}

	public void setPrevious(DblLink previous) {
		this.previous = previous;
	}
	
}
