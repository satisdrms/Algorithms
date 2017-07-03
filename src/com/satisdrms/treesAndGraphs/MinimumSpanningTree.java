package com.satisdrms.treesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;

class MST {
	HashMap<Integer, GraphNodeMST> nodes;
	LinkedList<Edge> edges;

	public MST() {
		nodes = new HashMap<Integer, GraphNodeMST>();
		edges = new LinkedList<Edge>();
	}

	public void insert(GraphNodeMST node) {

	}

	public void createGraph(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; i < graph[0].length; j++) {
				if (graph[i][j] != 0) {
					GraphNodeMST start, end;
					if (nodes.containsKey(i))
						start = nodes.get(i);
					else
						start = new GraphNodeMST(i);

					if (nodes.containsKey(j))
						end = nodes.get(j);
					else
						end = new GraphNodeMST(j);
				}
			}
		}
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
	}
}
