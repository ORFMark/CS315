package Homework.HW_11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class UGraphMatrix extends Graph {
	Vertex vertices[];
	int edgeMatrix[][];
	private int numberOfVertices;
	class Vertex {
		String label;
		boolean visited;
		Vertex(String label) {
			this.label = label;
			visited = false;
		}
	}
	public UGraphMatrix(int size) {
		vertices = new Vertex[size];
		edgeMatrix = new int[size][size];
		numberOfVertices = 0;
		// initially there are no edges
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				edgeMatrix[i][j] = 0;
		}
	}
	@Override
	public boolean addVertex(String label) {
		// TODO add your code here
		// create new Vertex with argument label and add it to the vertices

		if(numberOfVertices < vertices.length) {
			vertices[numberOfVertices] = new Vertex(label);
			numberOfVertices++;
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void addEdge(String sourceLabel, String destinationLabel, int weight) {
		int sourceIndex = findVertexIndex(sourceLabel);
		int destIndex = findVertexIndex(destinationLabel);
		if (sourceIndex != -1 && destIndex != -1) {
			edgeMatrix[sourceIndex][destIndex] = weight;
			edgeMatrix[destIndex][sourceIndex] = weight;
		}

	}

	private int findVertexIndex(String label) {
		// TODO add your code here (and use it in the addEdge method)
		// find the vertex index in vertices array by comparing labels
		for(int i = 0; i < vertices.length && vertices[i] != null; i++) {
			if(vertices[i].label.equals(label)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public boolean printGraphToFile(String graphname) {
		try {
			PrintWriter pWriter = new PrintWriter(graphname + ".txt");
			pWriter.println("graph " + graphname + " {");
			for (int i = 0; i < numberOfVertices; i++) {
				for (int j = 0; j < i; j++) {
					int weight = edgeMatrix[i][j];
					if (weight > 0) {
						pWriter.println(vertices[i].label
								+ " -- " + vertices[j].label
								+ " [label=" + weight + "];");
					}
				}
			}
			pWriter.println("}");
			pWriter.close();
			System.out.println("Use this line to draw the undirected graph");
			System.out.println("dot -Tpdf " + graphname + ".txt -o "
					+ graphname + ".pdf");
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}
