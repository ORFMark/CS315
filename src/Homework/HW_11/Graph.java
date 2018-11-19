package Homework.HW_11;

public abstract class Graph {
	public abstract boolean addVertex(String label);
	public abstract void addEdge(String sourceLabel, String destinationLabel, int weight);
	public abstract boolean printGraphToFile(String graphname);
}

