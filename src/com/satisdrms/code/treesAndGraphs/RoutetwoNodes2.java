package com.satisdrms.code.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

//Given a directed graph, design an algorithm to find out 
//whether there is a route between two nodes.

class Graph {

	ArrayList<GraphNode> allNodes;
	GraphNode start;

	public Graph(int[][] adjList) {
		allNodes = new ArrayList<GraphNode>();
		start = null;
		buildGraph(adjList);
	}

	private void buildGraph(int[][] adjList) {
		for (int i = 0; i < adjList.length; i++) {
			// System.out.println("Coordinates are " + adjList[i][0] + " and " +
			// adjList[i][1]);
			GraphNode ith = existsNode(adjList[i][0]);
			GraphNode jth = existsNode(adjList[i][1]);
			if (jth == null) {
				jth = new GraphNode(adjList[i][1]);
				allNodes.add(jth);
			}
			if (ith == null) {
				ith = new GraphNode(adjList[i][0]);
				allNodes.add(ith);
			}
			ith.addAdjacent(jth);

		}
		start = existsNode(adjList[0][0]);
		// System.out.println("start node is " + start.d);
	}

	public GraphNode existsNode(int i) {
		for (GraphNode g : allNodes) {
			if (g.d == i) {
				// System.out.println(i + " exists");
				return g;
			}
		}
		return null;
	}

	public GraphNode getAdjacentNodes(int n) {
		GraphNode node = existsNode(n);
		if (node != null) {
			return node;
		}
		return null;
	}

	public void resetAllNodesState() {
		for (GraphNode g : allNodes) {
			g.s = State.UnVisited;
		}
	}

	public void printGraph() {
		for (GraphNode g : allNodes) {
			System.out.println("Node is " + g.d + "(hash code is " + g.hashCode() + ") adjacent Nodes are ");
			for (GraphNode g1 : g.getAdjacentNodes()) {
				System.out.println(g1.d + "(hash code is " + g1.hashCode() + ")");
			}
		}
	}

	public void BFS() {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(start);
		start.s = State.Visited;
		while (!queue.isEmpty()) {
			// System.out.println("Starting While loop");

			// System.out.println("Size of queue is " + queue.size());

			GraphNode breadthNode = queue.remove();
			// System.out.println("processing BFS " + breadthNode.d + " size of
			// adjacent nodes is "+ breadthNode.getAdjacentNodes().size());
			System.out.println("childs of " + breadthNode.d + " are  ");
			for (GraphNode adj : breadthNode.getAdjacentNodes()) {
				if (adj.s == State.UnVisited) {
					System.out.println(adj.d);
					adj.s = State.Visiting;
					queue.addLast(adj);
				}
			}
			// System.out.println("Ending While loop");
		}
	}

	public boolean checDir(GraphNode startDir, GraphNode endDir) {
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(startDir);
		startDir.s = State.Visited;
		while (!queue.isEmpty()) {
			// System.out.println("Starting While loop");

			// System.out.println("Size of queue is " + queue.size());

			GraphNode breadthNode = queue.remove();
			System.out.println("processing BFS " + breadthNode.d + " size of adjacent nodes is "+ breadthNode.getAdjacentNodes().size());
			System.out.println("childs of " + breadthNode.d + " are  ");
			for (GraphNode adj : breadthNode.getAdjacentNodes()) {
				//if (endDir.hashCode() == adj.hashCode()) {
				if (endDir== adj) {
					//System.out.println(endDir==adj);
					return true;
				} else if (adj.s == State.UnVisited) {
					System.out.println(adj.d);
					adj.s = State.Visiting;
					queue.addLast(adj);
				}
			}
			// System.out.println("Ending While loop");
		}
		return false;
	}
}

enum State {
	Visited, UnVisited, Visiting
}

public class RoutetwoNodes2 {

	public static void main(String[] args) {
		int[][] adjList = { { 1, 3 }, { 3, 5 }, { 1, 2 }, { 2, 4 }, { 4, 5 }, { 4, 7 }, { 7, 6 } };
		System.out.println("rows are " + adjList.length);
		Graph g = new Graph(adjList);
		g.printGraph();
		//g.BFS();
		GraphNode start = g.existsNode(1);
		GraphNode end = g.existsNode(6);
		boolean directionExists = g.checDir(start, end);
		System.out.println("Route "+directionExists+" from "+ start.d+" to "+end.d);
		// printAdjacencyMat(adjList);

	}

	private static void printAdjacencyMat(int[][] adjList) {
		for (int i = 0; i < adjList.length; i++) {
			System.out.println("rows are " + adjList[i].length);
			for (int j = 0; j < adjList[i].length; j++)
				System.out.println(adjList[i][j]);
		}
	}

}
