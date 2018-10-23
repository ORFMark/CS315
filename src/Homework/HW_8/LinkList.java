package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class LinkList {
	protected Link head;
	
	public void insertAtHead(Link newLink) {
		newLink.next = head;
		head = newLink;
	}

}
