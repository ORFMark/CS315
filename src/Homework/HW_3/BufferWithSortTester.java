package Homework.HW_3;

public class BufferWithSortTester extends BufferWithSort {

	public BufferWithSortTester(int size) {
		super(size);
	}

	public void displayAsTable(int numberOfColumns, int columnWidth, int decimalPlaces) {
		String formatString = "%" + Integer.toString(columnWidth) + "." + Integer.toString(decimalPlaces) + "f";
		for (int i = 0; i < numberOfValues; i++) {
			// Print newline if this value should be starting a new row.
			if (i > 0 && i % numberOfColumns == 0)
				System.out.println();
			// Column width is fixed as 8 characters with 3 decimal places.
			System.out.format(formatString, arrayOfValues[i]);
			/*
			 * It is common to think of this problem in terms of "Should I put a newline on
			 * the end of this value?" But that way of looking at it adds the complexity of
			 * having to consider whether or not another value will actually follow. Looking
			 * for alternatives leads to the cleaner solution shown here.
			 */
		}
		System.out.println();
	}

	public void startTest(String nameOfTest, int numberOfColumns, int columnWidth, int decimalPlaces) {
		shuffle();
		System.out.println("Shuffled:");
		displayAsTable(numberOfColumns, columnWidth, decimalPlaces);
		moveCount = 0;
		compareCount = 0;
		System.out.println(nameOfTest + " test");
	}
	
	public void finishTest(int numberOfColumns, int columnWidth, int decimalPlaces) {
		displayAsTable(numberOfColumns, columnWidth, decimalPlaces);
		System.out.println("  " + compareCount + " compares.");
		System.out.println("  " + moveCount + " moves.");
	}

}
