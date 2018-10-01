package Homework.HW_4;
/**
 * @author Michael Van Hilst vanhilsm @ erau.edu
 * @version 1.0 Homework assignment 4 (9/25/2018)
 */
public class HW4 {
    final static long MYRAND_MAX = 32768L;
    static long next = 1L;

    public static void run() {
        mainTest();
        // extraCreditTest();
    }
        
    public static void mainTest() {
        final int BUFSZ = 20;
        BufferOfInts test1 = new BufferOfInts(BUFSZ);
        for (int i = 0; i < BUFSZ; i++)
            test1.add(getRandBetween(-10, 10));
        System.out.println("Original data");
        test1.displayAsTable(10);
        BufferOfInts test2 = new BufferOfInts(BUFSZ);
        System.out.println("Copy using direct assignment");
        test2.copyByDirectAssignment(test1);
        test2.displayAsTable(10);
        System.out.println("Testing that it checks length");
        BufferOfInts test2a = new BufferOfInts(7);
        test2a.copyByDirectAssignment(test1);
        test2a.displayAsTable(10);
        System.out.println("Copy using addArray()");
        BufferOfInts test3 = new BufferOfInts(BUFSZ);
        test3.copyUsingAddArray(test1);
        test3.displayAsTable(10);
        System.out.println("Clone");
        BufferOfInts test4 = test1.clone();
        if (test4 != null) {
            test4.displayAsTable(10);
            System.out.println("Verify clone has own array");
            test4.removeQuick(0);
            System.out.println(test1.getValueAtIndex(0) + " vs "
                    + test4.getValueAtIndex(0));
        }
        System.out.println("OrderedSet");
        OrderedSet test10 = new OrderedSet(BUFSZ);
        for (int i = 0; i < BUFSZ; i++)
            test10.add(getRandBetween(-10, 10));
        test10.displayAsTable(10);
        System.out.print("Binary search: ");
        System.out.print(test10.binarySearch(-25) + ", ");
        System.out.print(test10.binarySearch(-7) + ", ");
        System.out.print(test10.binarySearch(0) + ", ");
        System.out.print(test10.binarySearch(2) + ", ");
        System.out.print(test10.binarySearch(9) + ", ");
        System.out.println(test10.binarySearch(50));
    }
    
	/*
    public static void extraCreditTest() {
        final int BUFSZ = 20;
        BubbleVariants test1 = new BubbleVariants(BUFSZ);
        BubbleVariants test2 = new BubbleVariants(BUFSZ);
        BubbleVariants test3 = new BubbleVariants(BUFSZ);

        for (int i = 0; i < BUFSZ; i++)
            test2.add(i - BUFSZ / 2);
        test1.copyUsingAddArray(test2);
        test1.shuffle();
        test3.copyUsingAddArray(test2);
        test3.reverseOrder();
        testBubbleVariants(test1);
        testBubbleVariants(test2);
        testBubbleVariants(test3);        
    }
    
    public static void testBubbleVariants(BubbleVariants data) {
        BubbleVariants test = new BubbleVariants(data.getArrayLength());
        test.copyByDirectAssignment(data);
        test.startTest("Bubble1");
        test.bubbleSort1();
        test.finishTest();
        
        test.copyByDirectAssignment(data);
        test.startTest("Bubble2");
        test.bubbleSort2();
        test.finishTest();

        test.copyByDirectAssignment(data);
        test.startTest("Bubble3");
        test.bubbleSort3();
        test.finishTest();
        System.out.println();
    }
	*/

    public static double myrand() {
        next = next * 1103515245L + 12345;
        long randomLong = Long.divideUnsigned(next, 65536) % MYRAND_MAX;
        return (double) randomLong / (double) MYRAND_MAX;
    }

    public static int getRandBetween(int lower, int upper) {
        double range = 1 + upper - lower;
        return (int) Math.floor(myrand() * range) + lower;
    }

}
