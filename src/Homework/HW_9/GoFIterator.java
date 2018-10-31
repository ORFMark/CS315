package Homework.HW_9;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public abstract class GoFIterator {
    public abstract boolean isDone();
    public abstract void first();
    public abstract void next();
    public abstract Tree.Node currentItem();
}
