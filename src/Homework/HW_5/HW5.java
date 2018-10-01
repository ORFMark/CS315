package Homework.HW_5;
public class HW5 {
    final static long MYRAND_MAX = 32768L;
    static long next = 1L;

    public static void run() {
        System.out.println("Stack test");
        StackOfInts stack = new StackOfInts(100);
        // 3 * (4 + 2) in reverse Polish is 3 4 2 + *
        stack.push(3);
        stack.push(4);
        stack.push(2);
        // compute and store 4 + 2
        stack.push(stack.pop() + stack.pop());
        // compute and store 3 * the result of the above
        stack.push(stack.pop() * stack.pop());
        System.out.println("3 * (4 + 2) = " + stack.pop());
        System.out.println("Queue test");
        QueueOfInts queue = new QueueOfInts(100);
        // queue test has numbers arriving and going out
        // 1 2 3 4 5 d d 6 7 8 d d
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.print(" " + queue.dequeue());
        System.out.print(" " + queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.print(" " + queue.dequeue());
        System.out.print(" " + queue.dequeue());
        System.out.println();

        System.out.println("Statistics test, run 1");
        BufferWithStats test = new BufferWithStats(1000);
        for (int i = 0; i < 1000; i++)
            test.add(getRandomIntegerBetween(1, 200));
        System.out.println("The max is " + test.getMax());
        System.out.println("The min is " + test.getMin());
        System.out.println("The sum is " + test.getSum());
        System.out.println("The mean is " + test.getMean());
        System.out.println("The mode is " + test.getMode());
        System.out.println("The frequency of the mode is "
                + test.getFrequencyOfValue(test.getMode()));
        System.out.println("Statistics test, run 2");
        test.clear();
        for (int i = 0; i < 1000; i++)
            test.add(getRandomIntegerBetween(1, 200));
        System.out.println("The max is " + test.getMax());
        System.out.println("The min is " + test.getMin());
        System.out.println("The sum is " + test.getSum());
        System.out.println("The mean is " + test.getMean());
        System.out.println("The mode is " + test.getMode());
        System.out.println("The frequency of the mode is "
                + test.getFrequencyOfValue(test.getMode()));

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
