package Homework.HW_9;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class DblLink {
    private Tree.Node node;
    private DblLink next;
    private DblLink previous;

    public DblLink(Tree.Node node) {
        this.node = node;
        next = null;
        previous = null;
    }

    public Tree.Node getNode() {
        return node;
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
