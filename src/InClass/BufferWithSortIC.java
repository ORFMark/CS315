package InClass;

import Homework.HW_1.BufferOfDoubles;

public class BufferWithSortIC extends BufferOfDoubles {

	public BufferWithSortIC(int size) {
		super(size); //runs the constructor for BufferOfDoubles
	}
	public boolean add(double value) {
		if(findFirst(value) == -1) {
			return super.add(value);
		}
		else {
			return false;
		}
	}

}
