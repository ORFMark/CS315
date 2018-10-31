package Homework.HW_9;
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
        newLink.setPrevious(null);
        if (isEmpty())
            tail = newLink;
        else
            head.setPrevious(newLink);
        head = newLink;
    }
    
    public void insertAtTail(DblLink newLink) {
        newLink.setPrevious(tail);
        newLink.setNext(null);
        if (head == null)
            head = newLink;
        else
            tail.setNext(newLink);
        tail = newLink;
    }

    public DblLink removeHead() {
        if (isEmpty())
            return null;
        else {
            DblLink temp = head;
            if (head == tail)
                tail = null;
            else
                head.getNext().setPrevious(null);
            head = head.getNext();
            // good practice would set temp's ptrs to null here
            return temp;
        }
    }

    public DblLink removeTail() {
        if (isEmpty())
            return null;
        else {
            DblLink temp = tail;
            if (head == tail) // or head == temp
                head = null;
            else
                tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
            // good practice would set temp's ptrs to null here
            return temp;
        }
    }

}
