package Homework.HW_2;

import Homework.HW_1.*;
public class HW2 {
    final static long MYRAND_MAX = 32768L;
    static long next = 1L;
    
    public static void run() {
        BufferOfDoubles test = new BufferOfDoubles(24);
        test.add(12.75);
        test.add(7.92654);
        test.add(-87.58125);
        test.add(12.17);
        test.add(36.894);
        test.add(567.1234567);
        test.add(12.75);
        test.display();
        System.out.println("testing findFirst: " + test.findFirst(12.75));
        System.out.println("testing findLast: " + test.findLast(12.75));
        System.out.println("testing removeStable: " + test.removeStable(2));
        System.out.println("testing removeQuick: " + test.removeQuick(4));
        System.out.println("testing remove: " + test.removeStable(25));
        System.out.println("testing remove: " + test.removeQuick(-10));
        System.out.println("testing displayAsTable ");
        test.displayAsTable(5);
        test.clear();
        System.out.println("testing clear:");
        test.displayAsTable(1);
        System.out.println("testing addArray: " + test.addArray(randomDoubles(50, -50, 50), 4, 44));
        test.displayAsTable(6);
        System.out.println("tested displayAsTable");
        stressTest(test);
        test = new BufferOfDoubles(0);
        stressTest(test);
    }
    
    public static void stressTest(BufferOfDoubles victim) {
        System.out.println("Starting stress tests");
        double[] data = {0, -8.7, -5, 0, 77};
        victim.clear();
        for (int i = 0; i < 100; i++)
            victim.add(1 + i / 2);
        victim.displayAsTable(8);
        System.out.println("table of 8 columns");
        victim.displayAsTable(9);
        System.out.println("table of 9 columns");
        System.out.println("Find first, last, not there");
        System.out.println(victim.findFirst(1));
        System.out.println(victim.findLast(1));
        System.out.println(victim.findFirst(100));
        System.out.println("add array to full buffer");
        System.out.println(victim.addArray(data, 0, 5));
        System.out.println("Remove bad index");
        System.out.println(victim.removeStable(-1));
        System.out.println(victim.removeQuick(-1));
        System.out.println(victim.removeStable(-1));
        System.out.println(victim.removeQuick(-1));
        System.out.println("Remove stable elements 0, 23, and 24");
        System.out.println(victim.removeStable(24));
        System.out.println(victim.removeStable(23));
        System.out.println(victim.removeStable(0));
        victim.displayAsTable(8);
        System.out.println("Remove quick element 0, 23, and 24");
        System.out.println(victim.removeQuick(24));
        System.out.println(victim.removeQuick(23));
        System.out.println(victim.removeQuick(0));
        victim.displayAsTable(8);
        System.out.println(victim.addArray(data, -2, 3));
        victim.displayAsTable(8);
    }
    
    public static double myrand() {
        next = next * 1103515245L + 12345;
        return (double)(Long.divideUnsigned(next, 65536) % MYRAND_MAX) / MYRAND_MAX;
    }

    public static double[] randomDoubles(int count, double min, double max) {
        double arr[] = new double[count];
        for (int i = 0; i < arr.length; i++)
            arr[i] = myrand() * (max - min) + min;
        return arr;
    }

}
