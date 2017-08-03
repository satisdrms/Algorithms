package com.satisdrms.code.treesAndGraphs;

import java.util.LinkedList;

public class GraphNode {

	int d;
	LinkedList<GraphNode> adjacentNodes;
	State s = State.UnVisited;

	GraphNode(int d) {
		this.d = d;
		adjacentNodes = new LinkedList<GraphNode>();
	}

	public void addAdjacent(GraphNode jth) {
		adjacentNodes.add(jth);
	}

	@SuppressWarnings("unused")
	private GraphNode existsNode(int i) {
		for (GraphNode g : adjacentNodes) {
			if (g.d == i)
				return g;
		}
		return null;
	}

	public LinkedList<GraphNode> getAdjacentNodes() {
		return adjacentNodes;
	}

}
