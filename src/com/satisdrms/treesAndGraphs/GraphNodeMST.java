package com.satisdrms.treesAndGraphs;

public class GraphNodeMST implements Comparable<GraphNodeMST> {

	int d;
	boolean isVisited;

	public GraphNodeMST(int d) {
		this.d = d;
		isVisited = false;
	}

	@Override
	public int compareTo(GraphNodeMST o) {
		return this.d - o.d;
	}

	@Override
	public boolean equals(Object obj) {
		GraphNodeMST src = (GraphNodeMST) obj;
		return src.d == this.d;
	}

	@Override
	public int hashCode() {
		Integer i = d;
		return i.hashCode();
	}

}
