package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class BufferOfInts {
	protected int buffer[];
	protected int numberOfValues;
	
	public BufferOfInts(int size) {
		buffer = new int[size];
		numberOfValues = 0;
	}
	
	public boolean add(int value) {
		if (numberOfValues < buffer.length) {
			buffer[numberOfValues] = value;
			numberOfValues++;
			return true;
		} else
			return false;
	}
	

}
