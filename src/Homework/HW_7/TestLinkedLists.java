package Homework.HW_7;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 7
 */

public class TestLinkedLists {

    public static void run(String[] args) {
        LinkedList test1 = new LinkedList();
        test1.insertAsHead(new SingleLink("Sally"));
        test1.insertAsHead(new SingleLink("Johnny"));
        test1.insertAsHead(new SingleLink("Leslie"));
        test1.display();
        System.out.println(test1.removeHead() + "\t\t: RemoveHead()");
        test1.display();
        System.out.println(test1.removeTail() + "\t\t: RemoveTail()");
        test1.display();
        System.out.println(test1.removeTail() + "\t\t: RemoveTail()");
        test1.display();
        System.out.println(test1.removeHead() + "\t\t: RemoveHead()");
        System.out.println(test1.removeTail() + "\t\t: RemoveTail()");
        System.out.println("Done");

        DoublyLinkedList test2 = new DoublyLinkedList();
        test2.insertAsHead(new DoubleLink("Sally"));
        test2.insertAsHead(new DoubleLink("Johnny"));
        test2.insertAsTail(new DoubleLink("Leslie"));
        test2.display();
        System.out.println(test2.removeHead() + "\t\t: RemoveHead()");
        test2.display();
        System.out.println(test2.removeTail() + "\t\t: RemoveTail()");
        test2.display();
        System.out.println(test2.removeTail() + "\t\t: RemoveTail()");
        test2.display();
        System.out.println(test2.removeHead() + "\t\t: RemoveHead()");
        System.out.println(test2.removeTail() + "\t\t: RemoveTail()");
        System.out.println("Done");
    }

}
