package com.satisdrms.treesAndGraphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

//Minimum Spanning tree for an undirected graph

class MST {
	HashMap<GraphNodeMST, Edge> tree;
	HashMap<Integer, GraphNodeMST> vertices;
	LinkedList<Edge> edges;
	HashMap<GraphNodeMST, LinkedList<Edge>> minspttree;

	public MST() {
		tree = new HashMap<GraphNodeMST, Edge>();
		vertices = new HashMap<Integer, GraphNodeMST>();
		edges = new LinkedList<Edge>();

		minspttree = new HashMap<GraphNodeMST, LinkedList<Edge>>();
	}

	public void insert(GraphNodeMST node) {

	}

	public void createGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (graph[i][j] != 0) {
					GraphNodeMST start, end;
					if (vertices.containsKey(i))
						start = vertices.get(i);
					else {
						start = new GraphNodeMST(i);
						vertices.put(i, start);
					}
					if (vertices.containsKey(j))
						end = vertices.get(j);
					else {
						end = new GraphNodeMST(j);
						vertices.put(j, end);
					}
					Edge e = new Edge(start, end, graph[i][j]);
					if (!edges.contains(e)) {
						edges.add(e);
					} else
						System.out.println("edge between " + e.start.d
								+ " and " + e.end.d + " exists");
					// tree.put(start, e);
				}
			}
		}
	}

	public void printVertex(int v) {
		System.out.println(vertices.values().contains(new GraphNodeMST(v))
				+ " " + v);
		// for(vertices.values().
	}

	public void createMST() {
		@SuppressWarnings("unchecked")
		LinkedList<Edge> sortEdges = (LinkedList<Edge>) edges.clone();
		Collections.sort(sortEdges);
		for (Edge e : sortEdges) {
			resetNodesVisitStatus();

			if (!cycleExistsInMST(e))
				addEdgeToGraph(minspttree, e);
		}
		printMST();
	}

	private void printMST() {
		resetNodesVisitStatus();
		System.out.println(minspttree.size());
		for (GraphNodeMST g : minspttree.keySet()) {
			System.out.println("the node is " + g.d + " and the edges are ");
			for (Edge e : minspttree.get(g)) {
				System.out.println("connected to " + e.weight);
			}
		}
	}

	/* Check whether a cycle will be formed by adding this node */
	private boolean cycleExistsInMST(Edge e) {
		@SuppressWarnings("unchecked")
		HashMap<GraphNodeMST, LinkedList<Edge>> cyclemst = (HashMap<GraphNodeMST, LinkedList<Edge>>) minspttree
				.clone();
		addEdgeToGraph(cyclemst, e);

		if (cyclemst.size() == 0)
			return true;
		else {
			for (GraphNodeMST g : cyclemst.keySet()) {
				if (!g.isVisited) {
					g.isVisited = true;
					LinkedList<GraphNodeMST> connectedVertices = new LinkedList<GraphNodeMST>();
					connectedVertices.add(g);
					while (!connectedVertices.isEmpty()) {
						GraphNodeMST vertex = connectedVertices.remove();
						for (Edge ed : cyclemst.get(vertex)) {
							GraphNodeMST otherEdge = ed.getOtherVertex(vertex);
							if (otherEdge.isVisited)
								return false;
							connectedVertices.add(otherEdge);
						}
					}
				}
			}
		}
		return true;
	}

	private void addEdgeToGraph(HashMap<GraphNodeMST, LinkedList<Edge>> graph,
			Edge e) {

		if (graph.containsKey(e.start)) {
			LinkedList<Edge> edgeList = graph.get(e.start);
			edgeList.add(e);
		} else {
			LinkedList<Edge> edgeList = new LinkedList<Edge>();
			graph.put(e.start, edgeList);
		}

		if (graph.containsKey(e.end)) {
			LinkedList<Edge> edgeList = graph.get(e.end);
			edgeList.add(e);
		} else {
			LinkedList<Edge> edgeList = new LinkedList<Edge>();
			graph.put(e.end, edgeList);
		}

	}

	private void addEdgetoMST(Edge e) {
		// minspttree

	}

	private void resetNodesVisitStatus() {
		for (GraphNodeMST g : vertices.values())
			g.isVisited = false;

	}
}

public class MinimumSpanningTree {
	static int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

	public static void main(String[] args) {
		MST minspt = new MST();
		minspt.createGraph(graph);
		minspt.createMST();

		// LinkedList<Edge> test = new LinkedList<Edge>();
		// test.add(new Edge(null, null, 1));
		// test.add(new Edge(null, null, 13));
		// test.remove(new Edge(null, null, 13));
		// for (Edge e : test) {
		// System.out.println(e.weight);
		// }
		// minspt.printVertex(3);

	}
}
