package Homework.HW_11;

import java.io.PrintWriter;

import javax.xml.transform.Source;

import java.io.FileNotFoundException;

public class DigraphAdjacencies extends Graph {
	private Vertex vertices[];
	private int numberOfVertices;
	class Vertex {
		String label;
		Edge adjacencies;
		boolean visited;
		Vertex(String label) {
			this.label = label;
			adjacencies = null;
			visited = false;
		}
		public void addEdge(Edge newNeighbor) {
			// TODO add your code here
			// insert newNeighbor at head of adjacencies linked list
			newNeighbor.next = adjacencies;
			adjacencies = newNeighbor;
		}
	}
	class Edge {
		Vertex sourceVertex;
		Vertex destinationVertex;
		int weight;
		Edge next;
		Edge(Vertex sourceVertex, Vertex destinationVertex, int weight) {
			this.sourceVertex = sourceVertex;
			this.destinationVertex = destinationVertex;
			this.weight = weight;
			next = null;
		}
	}
	// constructor
	//
	public DigraphAdjacencies(int size) {
		vertices = new Vertex[size];
		numberOfVertices = 0;
	}
	@Override
	public boolean addVertex(String label) {
		if (numberOfVertices < vertices.length) {
			vertices[numberOfVertices++] = new Vertex(label);
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public void addEdge(String sourceLabel, String destinationLabel,
			int weight) {
		// TODO add your code here
		// find both vertexes, create new edge, and add edge to source vertex'
		Vertex source = findVertex(sourceLabel);
		Vertex dest = findVertex(destinationLabel);
		source.addEdge(new Edge(source, dest, 1));
	}

	private Vertex findVertex(String label) {
		for(int i = 0; i < numberOfVertices; i++) {
			if(vertices[i].label.equals(label)) {
				return vertices[i];
			}
		}
		return null;
	}
	@Override
	public boolean printGraphToFile(String graphname) {
		try {
			PrintWriter pWriter = new PrintWriter(graphname + ".txt");
			pWriter.println("digraph " + graphname + " {");
			for (int i = 0; i < numberOfVertices; i++) {
				Edge e = vertices[i].adjacencies;
				while (e != null) {
					pWriter.println(e.sourceVertex.label + " -> "
							+ e.destinationVertex.label
							+ " [label=" + e.weight + "];");
					e = e.next;
				}
			}
			pWriter.println("}");
			pWriter.close();
			System.out.println("Use this line to draw the directed graph:");
			System.out.println("dot -Tpdf " + graphname + ".txt -o "
					+ graphname + ".pdf");
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}