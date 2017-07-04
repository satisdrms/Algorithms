package com.satisdrms.treesAndGraphs;

import java.util.LinkedList;
import java.util.List;

public class GraphNodeMST {

	int d;
	List<Edge> edges;
	boolean isVisited;

	public GraphNodeMST(int d) {
		this.d = d;
		edges = new LinkedList<Edge>();
		isVisited = false;
	}

	public void addAdjacent(GraphNodeMST jth, int weight) {
		edges.add(new Edge(this, jth, weight));
	}

}
