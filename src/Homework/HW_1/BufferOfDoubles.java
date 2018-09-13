package Homework.HW_1;

/*
 * File: BufferOfDoubles.java
 * Project: CS315 Assignment 1
 * Author: Mark Burrell
 * Version: 1.0 August 29, 2018
 *			1.1 September 9 2018, Fixed various bugs that caused index errors
 *			1.2 September 10 2018, fixed an issue with removeLast that could cause it to run off the end
 *								   Cleaned up comments
 *			1.3 September 12 2018, fixed an out of bounds error in addArray
 *				1.3.1 Sept 12 2018:
 *									edited addArray to comply with the requested out
 * Copywrite (c) 2018 Mark Burrell all rights reserved
 */

public class BufferOfDoubles {
	private double[] arrayOfValues;
	private int numberOfValues;

	// Constructor, inits arrayOfValues to an actual array
	public BufferOfDoubles(int size) {
		arrayOfValues = new double[size];
		numberOfValues = 0;
	}

	// shifts all values from a specific point down, replacing the value at that
	// point
	private void shiftDown(int index) {
		for (int i = index; i < numberOfValues - 1; i++) {
			arrayOfValues[i] = arrayOfValues[i + 1];
		}
		numberOfValues--;
	}

	// adds values to the buffer, and insures we don't go off the end of the array
	public boolean add(double value) {
		if (numberOfValues < arrayOfValues.length) {
			arrayOfValues[numberOfValues] = value;
			numberOfValues++;
			return true;
		} else {
			return false;
		}
	}

	// adds an array of values to the buffer and returns the number of values added
	public int addArray(double[] array, int firstIndex, int lastIndex) {
		int count = 0;
		//bounds check for the array to insure we don't read anything we shouldnt
		
			for (int i = firstIndex; i <= lastIndex; i++) {
				if (i >= 0 && i < array.length) {
					if (add(array[i]))
						count++;
				}
			}
		return count;
	}

	// finds the first occurrence of something in the buffer and returns the index
	public int findFirst(double value) {
		for (int i = 0; i < numberOfValues; i++) {
			if (value == arrayOfValues[i]) {
				return i;
			}
		}
		return -1;
	}

	// finds the last occurrence of a value in the buffer and returns the index
	public int findLast(double value) {
		for (int i = numberOfValues - 1; i >= 0; i--) {
			if (value == arrayOfValues[i]) {
				return i;
			}
		}
		return -1;
	}

	// removes a value from the buffer while preserving order
	public boolean removeStable(int index) {
		if (index < numberOfValues && index >= 0) {
			shiftDown(index);
			return true;
		} else
			return false;
	}

	// quickly removes a value from the buffer, does not preserve order
	public boolean removeQuick(int index) {
		if (index < numberOfValues && index >= 0) {
			numberOfValues--;
			arrayOfValues[index] = arrayOfValues[numberOfValues];
			return true;
		} else
			return false;
	}

	// clears the buffer
	public void clear() {
		numberOfValues = 0;
	}

	// displays the contents of the buffer to the 1/100 place
	public void display() {
		for (int i = 0; i < numberOfValues; i++) {
			System.out.printf("%.02f ", arrayOfValues[i]);
		}
		System.out.println();

	}

	// prints the buffer as a table
	public void displayAsTable(int columnsPerRow) {
		for (int i = 0; i < numberOfValues; i++) {
			if (i % columnsPerRow == 0 && i != 0) {
				System.out.println();
			}
			System.out.printf("%8.03f", arrayOfValues[i]);
		}
		System.out.println();
	}

}
