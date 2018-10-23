package Homework.HW_7;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 7
 */

public class DoubleLink {
    private String data;
    private DoubleLink next;
    private DoubleLink previous;
    
    public DoubleLink(String data) {
        this.data = data;
    }

    public DoubleLink getNext() {
        return next;
    }

    public void setNext(DoubleLink next) {
        this.next = next;
    }

    public DoubleLink getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLink previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return data;
    }

}
