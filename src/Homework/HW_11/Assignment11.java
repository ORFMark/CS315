package Homework.HW_11;

public class Assignment11 {
	/*
	public static void main(String[] args) {
		runVanHilst(args);
		runFullTest(args);
	}
	*/
	public static void runVanHilst(String[] args) {
		test(new DigraphAdjacencies(20), "test1");
		test(new UGraphMatrix(20), "test2");
	}
	public static void runFullTest(String[] args) {
		System.out.println("****Marks Ugraph Tests***");
		System.out.println();
		emptyGraph(new UGraphMatrix(0), "Empty Graph");
		System.out.println();
		emptyGraph(new UGraphMatrix(5), "Overloaded Graph");
		System.out.println();
		sizeTest(new UGraphMatrix(3), "Exact Size");
		System.out.println();
		nullEdge(new UGraphMatrix(20), "Null Edge");
		System.out.println();
		weighed(new UGraphMatrix(20), "Weighted Edges");
		System.out.println();
		dublicates(new UGraphMatrix(20), "Duplicated Values");
		System.out.println();
		sizeTest(new UGraphMatrix(3), "Exact Size");
		System.out.println();
		System.out.println("****Marks Adjacent Tests***");
		System.out.println();
		emptyGraph(new DigraphAdjacencies(0), "Empty Graph");
		System.out.println();
		emptyGraph(new DigraphAdjacencies(5), "Overloaded Graph");
		System.out.println();
		sizeTest(new DigraphAdjacencies(3), "Exact Size");
		System.out.println();
		nullEdge(new DigraphAdjacencies(20), "Null Edge");
		System.out.println();
		weighed(new DigraphAdjacencies(20), "Weighted Edges");
		System.out.println();
		dublicates(new DigraphAdjacencies(20), "Duplicated Values");
		System.out.println();
		
	}

	public static void test(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("B", "D", 1);
		g.printGraphToFile(graphname);
	}
	
	public static void emptyGraph(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("B", "D", 1);
		g.displayGraph(graphname);
	}
	
	public static void overloadedGraph(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		g.addVertex("H");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("B", "D", 1);
		g.addEdge("G", "H", 1);
		g.displayGraph(graphname);
	}
	
	public static void nullEdge(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("F", "D", 1);
		g.addEdge("B", "F", 1);
		g.displayGraph(graphname);
	}
	
	public static void weighed(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 2);
		g.addEdge("C", "D", 3);
		g.addEdge("A", "D", 4);
		g.addEdge("E", "D", 5);
		g.addEdge("B", "C", 6);
		g.displayGraph(graphname);
	}
	
	public static void dublicates(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addEdge("E", "B", 1);
		g.addEdge("A", "B", 1);
		g.addEdge("C", "D", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("E", "D", 1);
		g.addEdge("B", "C", 1);
		g.addEdge("A", "D", 1);
		g.addEdge("E", "D", 2);
		g.addEdge("B", "C", 2);
		g.displayGraph(graphname);
	}
	
	public static void sizeTest(Graph g, String graphname) {
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addEdge("A", "B", 1);
		g.addEdge("B", "A", 1);
		g.addEdge("A", "C", 1);
		g.addEdge("C", "A", 1);
		g.addEdge("C", "B", 1);
		g.addEdge("B", "C", 1);
		g.displayGraph(graphname);
	}
}
