package Homework.HW_11;

public class Assignment11 {
	public static void run(String[] args) {
		test(new DigraphAdjacencies(20), "test1");
		test(new UGraphMatrix(20), "test2");
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
}
