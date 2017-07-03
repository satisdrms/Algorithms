package com.github.satisdrms.treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

//This is an exmaple of visiting all the cities
class Graph1 {
	private int V;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph1(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {

		visited[v] = true;
		Integer i;
		Iterator<Integer> it = adj[v].iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		stack.push(new Integer(v));
	}

	void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);

		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}
}

public class TopologicalSort {

	public static void main(String[] args) {
		// WEIRD SYNTAX BUT WORKS :- ARRAY OF COLLECTION OF COLLECTIONS
		// LinkedList<LinkedList<Integer>>[][][][] adj[][][][]; // Adjacency
		// List

		// Create a graph given in the above diagram
		Graph1 g = new Graph1(7);
		g.addEdge(1, 2);
		g.addEdge(1, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(5, 6);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological "
				+ "sort of the given graph");
		g.topologicalSort();

	}

}
