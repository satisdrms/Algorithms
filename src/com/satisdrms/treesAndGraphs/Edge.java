package com.satisdrms.treesAndGraphs;

public class Edge implements Comparable<Edge> {
	GraphNodeMST start, end;
	int weight;

	public Edge(GraphNodeMST start, GraphNodeMST end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	@Override
	public boolean equals(Object obj) {
		Edge another = (Edge) obj;
		return another.weight == this.weight
		// this will ensure the directed graph is compared as a undirected graph
				&& ((another.start.d == this.start.d && another.end.d == this.end.d) || (another.start.d == this.end.d && another.end.d == this.start.d));
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

	public GraphNodeMST getOtherVertex(GraphNodeMST vertex) {
		if (vertex.equals(start))
			return end;
		else
			return start;
	}

	@Override
	public int hashCode() {
		Integer hash = weight + start.d + end.d;
		return hash.hashCode();
	}

}