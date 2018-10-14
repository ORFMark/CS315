package Homework.HW_6;
public class Merger {
    final static long MYRAND_MAX = 32768L;
    static long next = 1L;

    public static void run(String [] args) {
        OrderedBuffer source1 = new OrderedBuffer(15);
        OrderedBuffer source2 = new OrderedBuffer(25);
        SubMerge destination1 = new SubMerge(40);
        SubMerge destination2 = new SubMerge(40);
        SubMerge destination3 = new SubMerge(40);
        System.out.println("Source 1 (left)");
        for (int i = 0; i < source1.getArrayLength(); i++)
            source1.add(getRandomIntegerBetween(1, 500));
        source1.displayAsTable(10);
        System.out.println("Source 2 (right)");
        for (int i = 0; i < source2.getArrayLength(); i++)
            source2.add(getRandomIntegerBetween(1, 500));
        source2.displayAsTable(10);
        System.out.println("Destination 1 (loop for compares, then loop to finish)");
        destination1.copyMerge1(source1, source2);
        destination1.displayAsTable(10);
        System.out.println("Destination 2 (one loop four cases)");
        destination2.copyMerge2(source1, source2);
        destination2.displayAsTable(10);
        System.out.println("Destination 3 (while while while)");
        destination3.copyMerge3(source1, source2);
        destination3.displayAsTable(10);
    }
    
    public static double myrand() {
        next = next * 1103515245L + 12345;
        long randomLong = Long.divideUnsigned(next, 65536) % MYRAND_MAX;
        return (double) randomLong / (double) MYRAND_MAX;
    }

    public static int getRandomIntegerBetween(int lower, int upper) {
        double range = 1 + upper - lower;
        return (int) Math.floor(myrand() * range) + lower;
    }

}
