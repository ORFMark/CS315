package Homework.HW_13;
import java.util.Random;

/**
 * Assignment 13: 
 * Code to test the student implementation of a heap
 * and optionally also heap sort
 * 
 * @author Michael Van Hilst
 * @version 1.0
 * @since 2018-11-29
 */
public class HeapTest {

    /**
     * @param args - command line arguments
     */
    public static void run(String[] args) {
        Heap h = new Heap(20);
        Random r = new Random();
        for (int i = 0; i < 15; i++)
            h.insert(r.nextInt(100));
        System.out.println("Current heap array:");
        h.display();
        System.out.println("Values removed in descending order:");
        for (int i = 0; i < 15; i++)
            System.out.print(" " + h.remove());
        System.out.println("\nEnd of main part.\n");
        for (int i = 0; i < 15; i++)
            h.rawInsert(r.nextInt(100));
        System.out.println("Unordered array:");
        h.display();
        System.out.println("Heapified array:");
        h.heapify();
        h.display();
        System.out.println("Sorted array:");
        h.sort();
        h.display();
    }

}
