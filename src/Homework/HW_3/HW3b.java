package Homework.HW_3;

public class HW3b {
	final static long MYRAND_MAX = 32768L;
	static long next = 1L;

	public static void run() {
		double[] array = new double[30];
		BufferWithSortTester test = new BufferWithSortTester(50);
		for (int i = 0; i < array.length; i++)
			array[i] = 15 - i;
		test.addArray(array, 0, array.length - 1);
		System.out.println("Initial data");
		test.displayAsTable(10, 6, 1);
		test.startTest("Bubble Sort", 10, 6, 1);
		test.bubbleSort();
		test.finishTest(10, 6, 1);
		test.startTest("Selection Sort", 10, 6, 1);
		test.selectionSort();
		test.finishTest(10, 6, 1);
		test.startTest("Insertion Sort", 10, 6, 1);
		test.insertionSort();
		test.finishTest(10, 6, 1);
	}

	public static double myrand() {
		next = next * 1103515245L + 12345;
		long randomLong = Long.divideUnsigned(next, 65536) % MYRAND_MAX;
		return (double) randomLong / (double) MYRAND_MAX;
	}

	public static int randBetween(int lower, int upper) {
		double range = 1 + upper - lower;
		return (int) Math.floor(myrand() * range) + lower;
	}

}
