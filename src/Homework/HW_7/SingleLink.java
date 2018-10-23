package Homework.HW_7;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 7
 */

public class SingleLink {
    private String data;
    private SingleLink next;
    
    public SingleLink(String data) {
        this.data = data;
    }
        
    protected SingleLink getNext() {
        return next;
    }

    protected void setNext(SingleLink next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return data;
    }

}
