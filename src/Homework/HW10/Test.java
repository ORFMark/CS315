package Homework.HW10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void run(String[] args) {
        HashTable table;
        System.out.println("\n*** Separate Chain Hash Table ***");
        table = new HashTableTestSC(10000);
        testTable(table);
        System.out.println("\n*** Open Address Hash Table ***");
        table = new HashTableTestOA(10000);
        testTable(table);
    }
    
    public static void testTable(HashTable table) {
        // Phase 1: Testing insert()
        // readNames("test.txt", table);
        readNames("bigListOfNames.txt", table);
        System.out.println("HashTable holds "
                + table.getNumberOfThingies() + " names.");
        int index = ((ChainTest) table).reportMaxChain();
        ((ChainTest) table).displayChain(index);
        // Phase 2: Testing find()
        System.out.println("\nFinding Zan, Moisse, Saul,"
                + " Juan, Nemo, Herahd & Nirvana: ");
        System.out.print(table.find("Zan") + " ");
        System.out.print(table.find("Moisse") + " ");
        System.out.print(table.find("Saul") + " ");
        System.out.print(table.find("Juan") + " ");
        System.out.print(table.find("Herahd") + " ");
        System.out.print(table.find("Nemo") + " ");
        System.out.println(table.find("Nirvana"));
        // Phase 3: Testing remove()
        System.out.println("\nRemoving Moisse, Juan, and Samir.");
        table.remove("Moisse");
        table.remove("Juan");
        table.remove("Samir");
        ((ChainTest) table).displayChain(index);
        System.out.println("\nFinding Zan, Moisse, Saul,"
                + " Juan, Nemo, Herahd & Nirvana: ");
        System.out.print(table.find("Zan") + " ");
        System.out.print(table.find("Moisse") + " ");
        System.out.print(table.find("Saul") + " ");
        System.out.print(table.find("Juan") + " ");
        System.out.print(table.find("Herahd") + " ");
        System.out.print(table.find("Nemo") + " ");
        System.out.println(table.find("Nirvana"));
    }
    
    public static void readNames(String filename, HashTable table) {
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            BufferedReader names = new BufferedReader(reader);
            String name;
            while ((name = names.readLine()) != null)
                table.insert(name);
        } catch (IOException e) {
            System.out.println("Failed reading file: " + filename);
        }
    }

}
