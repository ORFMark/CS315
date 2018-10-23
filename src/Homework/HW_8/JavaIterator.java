package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public abstract class JavaIterator {
    // hasNext() is the opposite of isDone()
    public abstract boolean hasNext();
    // next() returns the current data and advances to the next
    public abstract int next();
    // remove() removes the last value returned by next()
    public abstract void remove();
}
