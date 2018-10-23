package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public abstract class GoFIterator {
    // isDone() returns true if there are no more items to visit
	public abstract boolean isDone();
	// first() sets the cursor position to the first item
	public abstract void first();
	// next() advances the cursor position to the next item
	public abstract void next();
	// currentItem() returns the data at the current cursor position
	public abstract int currentItem();
}
