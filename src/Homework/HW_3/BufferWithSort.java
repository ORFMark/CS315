package Homework.HW_3;

import Homework.HW_1.BufferOfDoubles;

public class BufferWithSort extends BufferOfDoubles {
	protected int compareCount = 0;
	protected int moveCount = 0;

	public BufferWithSort(int size) {
		super(size);
	}

	private void swap(int indexA, int indexB) {
		double temp = arrayOfValues[indexA];
		arrayOfValues[indexA] = arrayOfValues[indexB];
		arrayOfValues[indexB] = temp;
		moveCount += 3;
	}

	private void bubble(int lengthOverWhichToBubble) {
		for (int i = 0; i < lengthOverWhichToBubble; i++) {
			if (arrayOfValues[i] > arrayOfValues[i + 1]) {
				compareCount++;
				swap(i, i + 1);
			}
		}
	}

	private int indexOfMax(int lengthToConsider) {
		double max = arrayOfValues[0];
		int maxIndex = 0;
		for (int i = 0; i < lengthToConsider; i++) {
			compareCount++;
			if (arrayOfValues[i] > max) {
				max = arrayOfValues[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public void bubbleSort() {
		for (int i = numberOfValues - 1; i > 1; i--) {
			bubble(i);
		}
	}

	public void selectionSort() {
		int maxIndex = 0;
		for (int i = numberOfValues - 1; i > 0; i--) {
			maxIndex = indexOfMax(i);
			swap(maxIndex, i);
		}
	}

	private void shiftRight(int indexToVacate, int sizeSoFar) {
		for (int i = sizeSoFar; i > indexToVacate; i--) {
			arrayOfValues[i] = arrayOfValues[i - 1];
			moveCount++;
		}
		
	}

	private void addInOrder(double value, int lengthOfSortedData) {
		int i = 0;
		while (i < lengthOfSortedData && arrayOfValues[i] <= value) {
			compareCount++;
			i++;
		}
		if (i != lengthOfSortedData) {
			shiftRight(i, lengthOfSortedData);
			arrayOfValues[i] = value;
			moveCount++;
		}
	}

	public void insertionSort() {
		for (int i = 1; i < numberOfValues; i++) {
			addInOrder(arrayOfValues[i], i);
		}

	}

	public void shuffle() {
		int randomIndex;
		for (int i = 0; i < numberOfValues; i++) {
			randomIndex = HW3b.randBetween(0, numberOfValues - 1);
			swap(i, randomIndex);
		}
	}

}
