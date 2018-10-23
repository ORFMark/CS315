package Homework.HW_8;
/**
 * @author      Michael Van Hilst vanhilsm @ erau.edu
 * @version     1.0 Homework assignment 8
 */
public class HW8 {

    public static void run(String[] args) {
        System.out.println("Testing GoF iterator on array buffer");
        IterableBufferOfInts ibuf = new IterableBufferOfInts(20);
        ibuf.add(17);
        ibuf.add(8);
        ibuf.add(-5);
        ibuf.add(4);
        displayGoF(ibuf.getGoFIterator());
        
        System.out.println("Testing GoF iterator on singly linked list");
        IterableLinkList ilist = new IterableLinkList();
        ilist.insertAtHead(new Link(64));
        ilist.insertAtHead(new Link(-9));
        ilist.insertAtHead(new Link(3));
        ilist.insertAtHead(new Link(11));
        displayGoF(ilist.getGoFIterator());
        
        System.out.println("Testing GoF iterator on doubly linked list");
        IterableDblLinkList dlist = new IterableDblLinkList();
        dlist.insertAtHead(new DblLink(-25));
        dlist.insertAtHead(new DblLink(37));
        dlist.insertAtHead(new DblLink(18));
        dlist.insertAtHead(new DblLink(-61));
        dlist.insertAtHead(new DblLink(1918));
        dlist.insertAtHead(new DblLink(2));
        displayGoF(dlist.getGoFIterator());
        
        System.out.println("Testing Java iterator on doubly linked list");
        displayJava(dlist.getJavaIterator());
        
        // Extra credit: test the Java Iterator remove method
        System.out.println("\nTesting Java iterator remove function");
        JavaIterator jiter = dlist.getJavaIterator();
        // remove nothing
        jiter.remove();
        // remove first
        System.out.print(" Removing: " + jiter.next() + " then leaving ");
        jiter.remove();
        System.out.println(jiter.next());
        // remove 3rd
        System.out.println(" Removing: " + jiter.next() + " and tail");
        jiter.remove();
        // remove last
        while (jiter.hasNext())
            jiter.next();
        jiter.remove();
        displayJava(dlist.getJavaIterator());
    }

    public static void displayGoF(GoFIterator iter) {
        for (iter.first(); !iter.isDone(); iter.next())
            System.out.print(" " + iter.currentItem());
        System.out.println();
    }

    public static void displayJava(JavaIterator iter) {
        while (iter.hasNext())
            System.out.print(" " + iter.next());
        System.out.println();
    }
}
