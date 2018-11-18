package Homework.HW10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class fullTest {

	public static void runFullTest(String[] args) {
		HashTable table;
		System.out.println("\n*** Will's OA Tests ***");
		System.out.println("\nEmpty Table Test:");
		table = new HashTableTestOA(5);
		WillsOATests(table);
		System.out.println("\n");
		System.out.println("\nRollover Test:");
		table = new HashTableTestOA(5);
		WillsOATests2(table);
		System.out.println("\n");
		System.out.println("\nNever-Ending Loop Test:");
		table = new HashTableTestOA(5);
		WillsOATests3(table);
		System.out.println("\n");
		System.out.println("\nCounter Test:");
		table = new HashTableTestOA(5);
		WillsOATests4(table);
		System.out.println("\nRollover Remove Test");
		table = new HashTableTestOA(5);
		WillsOATests5(table);
		System.out.println("\n*** Will's SC Tests ***");
		System.out.println("\nEmpty Table Test:");
		table = new HashTableTestSC(5);
		WillsSCTests(table);
		System.out.println("\n");
		System.out.println("\nCounter Test:");
		table = new HashTableTestSC(5);
		WillsSCTests2(table);
		System.out.println("\n");

		System.out.println("\n\n\n*** Separate Chain Hash Table ***");
		table = new HashTableTestSC(10000);
		testTable(table);
		System.out.println("\n*** Open Address Hash Table ***");
		table = new HashTableTestOA(10000);
		testTable(table);
	}

	public static void runVanHilstTest(String[] args) {
		HashTable table;
		System.out.println("\n*** Separate Chain Hash Table ***");
		table = new HashTableTestSC(10000);
		testTable(table);
		System.out.println("\n*** Open Address Hash Table ***");
		table = new HashTableTestOA(10000);
		testTable(table);
	}

	public static void WillsOATests(HashTable table) {
		System.out.print("G: " + table.find("G") + "\n");
		System.out.print("B: " + table.find("B") + "\n");
		System.out.print("C: " + table.find("C") + "\n");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
	}

	public static void WillsOATests2(HashTable table) {
		table.insert("B");
		table.insert("B");
		table.insert("C");
		table.insert("G");
		System.out.print("G: " + table.find("G") + "\n");
		System.out.print("B: " + table.find("B") + "\n");
		System.out.print("C: " + table.find("C") + "\n");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
	}

	public static void WillsOATests3(HashTable table) {
		table.insert("A");
		table.insert("B");
		table.insert("G");
		table.insert("Z");
		System.out.print("A: " + table.find("A") + "\n");
		System.out.print("G: " + table.find("G") + "\n");
		System.out.print("B: " + table.find("B") + "\n");
		System.out.print("Z: " + table.find("Z") + "\n");
		System.out.print("C: " + table.find("C") + "\n");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
	}

	public static void WillsOATests4(HashTable table) {
		table.insert("A");
		table.insert("B");
		table.insert("G");
		table.insert("Z");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		table.remove("Z");
		table.remove("G");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
	}

	public static void WillsOATests5(HashTable table) {
		table.insert("D");
		table.insert("D");
		table.insert("E");
		table.insert("G");
		table.insert("C");
		System.out.print("G: " + table.find("G") + "\n");
		System.out.print("D: " + table.find("D") + "\n");
		System.out.print("E: " + table.find("E") + "\n");
		System.out.print("C: " + table.find("C") + "\n");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
		table.remove("A");
		table.remove("D");
		index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
	}

	public static void WillsSCTests(HashTable table) {
		System.out.print("G: " + table.find("G") + "\n");
		System.out.print("B: " + table.find("B") + "\n");
		System.out.print("C: " + table.find("C") + "\n");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
	}

	public static void WillsSCTests2(HashTable table) {
		table.insert("A");
		table.insert("F");
		table.insert("K");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(0);

		table.remove("F");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(0);

		table.insert("F");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(0);

		table.remove("A");
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(0);
	}

	public static void WillsSCTests3(HashTable table) {

	}

	public static void testTable(HashTable table) {
		// Phase 1: Testing insert()
		// readNames("test.txt", table);
		readNames("bigListOfNames.txt", table);
		System.out.println("HashTable holds " + table.getNumberOfThingies() + " names.");
		int index = ((ChainTest) table).reportMaxChain();
		((ChainTest) table).displayChain(index);
		// Phase 2: Testing find()
		System.out.println("\nFinding Zan, Moisse, Saul," + " Juan, Nemo, Herahd & Nirvana: ");
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
		System.out.println("\nFinding Zan, Moisse, Saul," + " Juan, Nemo, Herahd & Nirvana: ");
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
