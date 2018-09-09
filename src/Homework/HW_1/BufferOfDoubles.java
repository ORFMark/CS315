package Homework.HW_1;

/*
 * File: hw1_MarkBurrell.cpp
 * Project: CS315 Assignment 1
 * Author: Mark Burrell
 * Version: 1.0 August 29, 2018
 *			
 *
 * Copywrite (c) 2018 Mark Burrell all rights reserved
 */


public class BufferOfDoubles {
	private double[] arrayOfValues;
	private int numberOfValues;
	
	//Constructor, inits arrayOfValues to an actual array
	public BufferOfDoubles(int size) {
		arrayOfValues = new double[size];
		numberOfValues = 0;
	}
	
	//shifts all values from a specific point down
	private void shiftDown(int index) {
		for (int i = index; i < numberOfValues-1; i++) {
			arrayOfValues[i] = arrayOfValues[i+1];
		}
	}
	//adds values to the buffer, and insures we don't go off the end of the array
	public boolean add(double value) {
		if (numberOfValues < arrayOfValues.length) {
			arrayOfValues[numberOfValues] = value;
			numberOfValues++;
			return true;
		}
		else {
			return false;
		}
	}
	
	//adds an array of values to the buffer and returns the number of values added
	public int addArray(double[] array, int firstIndex, int lastIndex) {
		int k = 0;
		int i = firstIndex;
		while(numberOfValues < arrayOfValues.length && i < lastIndex 
				&& i < array.length) {
			arrayOfValues[numberOfValues] = array[i];
			numberOfValues++;
			k++;
			i++;
		}
		return k;
	}
	
	//finds the first occurance of something in the buffer and returns the index
	public int findFirst(double value) {
		for(int i = 0; i < numberOfValues; i++) {
			if (value == arrayOfValues[i]) {
				return i;
			}
		}
		return -1;
	}
	
	//finds the last occurance of a value in the buffer and returns the index
	public int findLast(double value) {
		for (int i = numberOfValues; i > 0; i--) {
			if (value == arrayOfValues[i]) {
				return i;
			}
		}
		return -1;
	}
	
	//removes a value from the buffer while preserving order
	public boolean removeStable(int index) {
		if (index < numberOfValues && index >= 0) {
			shiftDown(index);
			numberOfValues--;
			return true;
		}
		
		return false;
	}
	
	//quickly removes a value from the buffer, does not preserve order
	public boolean removeQuick(int index) {
		if (index < numberOfValues && index >= 0) {
			arrayOfValues[index] = arrayOfValues[numberOfValues];
			numberOfValues--;
			return true;
		}
		return false;
	}
	
	//clears the buffer
	public void clear() {
		numberOfValues = 0;		
	}
	
	//displays the contents of the buffer to the 1/100 place
	public void display() {
		for (int i = 0; i < numberOfValues; i++) {
			System.out.printf("%.02f ", arrayOfValues[i]);
		}
		System.out.println();
		
	}
	
	//prints the buffer as a table
	public void displayAsTable(int columnsPerRow)  {
		for (int i = 0; i < numberOfValues; i++) {
			if (i % columnsPerRow == 0 && i != 0) {
				System.out.println();
			}
			System.out.printf("%8.02f", arrayOfValues[i]);
			
		}
		System.out.println();
	}

}
