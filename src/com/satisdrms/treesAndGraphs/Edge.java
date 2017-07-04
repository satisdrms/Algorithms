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
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

}