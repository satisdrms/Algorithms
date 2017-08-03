package com.satisdrms.code.CTCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.satisdrms.code.CTCI.Topic_25_BreadthDepth_First_Algorithmn_Adjacency_ListMatrix.node;

public class Topic_25_BreadthDepth_First_Algorithmn_Adjacency_ListMatrix {
	static private Queue<node> queue = new LinkedList<node>();
	static ArrayList<node> nodes = new ArrayList<node>();

	static class node {
		int data = 30;
		boolean visited;

		node(int data) {
			this.data = data;
			this.visited = false;

		}
	}

	public static void main(String[] args) {

		node node40 = new node(40);
		node node10 = new node(10);
		node node20 = new node(20);
		node node30 = new node(30);
		node node60 = new node(60);
		node node50 = new node(50);
		node node70 = new node(70);
		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		System.out.println("The below is adjacency Matrix");
		adjacencyMatrix(node40);
		System.out.println("The below is adjacency List");
		adjacencyList(node40);

	}

	private static void adjacencyList(node node40) {
		int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};
		Map<Integer, LinkedList<node>> adjacency_list = new HashMap<Integer, LinkedList<node>>();
		convertMatrixToList(adjacency_matrix, adjacency_list);
		printList(adjacency_list);
		queue.clear();
		System.out.println("The below is BFS Adjacency List");
		bfsAdjList(adjacency_list, node40);
		resetnodes();
		System.out.println("The below is DFS Adjacency List");
		dfsAdjList(adjacency_list, node40);
		resetnodes();

	}

	private static void dfsAdjList(
			Map<Integer, LinkedList<node>> adjacency_list, node n) {
		if (!n.visited) {
			n.visited = true;
			System.out.println(n.data);
			LinkedList<node> adjacent = adjacency_list.get(n.data);
			if (adjacent != null) {
				for (node i : adjacent) {
					dfsAdjList(adjacency_list, i);
				}
			}
		}
	}

	private static void bfsAdjList(
			Map<Integer, LinkedList<node>> adjacency_list, node n) {
		n.visited = true;
		System.out.println(n.data);
		LinkedList<node> adjacent = adjacency_list.get(n.data);

		queue.addAll(adjacent);
		while (!queue.isEmpty()) {
			node temp = queue.remove();
			if (!temp.visited) {
				temp.visited = true;
				System.out.println(temp.data);
				if (adjacency_list.containsKey(temp.data))
					queue.addAll(adjacency_list.get(temp.data));
			}
		}

	}

	/**
	 * @param adjacency_list
	 */
	private static void printList(Map<Integer, LinkedList<node>> adjacency_list) {
		System.out.println("-----------------");
		System.out.println("Printing the List");
		System.out.println("-----------------");
		Set<Integer> k = adjacency_list.keySet();
		for (Integer i : k) {
			List<node> lst = adjacency_list.get(i);
			System.out.println("The adjacent vertex of " + i);
			for (node n : lst) {
				System.out.println(n.data);
			}
		}
		System.out.println("-----------------");
	}

	private static void convertMatrixToList(int[][] adjacency_matrix,
			Map<Integer, LinkedList<node>> adjacency_list) {
		for (int i = 0; i < nodes.size(); i++) {
			node temp = nodes.get(i);
			for (int j = 0; j < nodes.size(); j++) {
				if (adjacency_matrix[i][j] == 1) {
					if (!adjacency_list.containsKey(temp.data)) {
						List<node> lst = new LinkedList<node>();
						lst.add(nodes.get(j));
						adjacency_list.put(temp.data, (LinkedList<node>) lst);
					} else {
						List<node> lst = adjacency_list.get(temp.data);
						lst.add(nodes.get(j));
					}
				}
			}
		}

	}

	/**
	 * @param node40
	 */
	private static void adjacencyMatrix(node node40) {
		int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};
		System.out.println("The below is breadth first search");
		bfs(adjacency_matrix, node40);
		resetnodes();// setting visited to false for trying depth first search
		System.out.println("The below is depth first search");
		dfs(adjacency_matrix, node40);
		resetnodes();
	}

	private static void resetnodes() {
		for (int i = 0; i < nodes.size(); i++) {
			nodes.get(i).visited = false;
		}

	}

	private static void dfs(int[][] adjacency_matrix, node n) {
		int nodeindex = -1;
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(n)) {
				nodeindex = i;
				break;
			}
		}
		System.out.println(n.data);
		n.visited = true;
		for (int j = 0; j < nodes.size(); j++) {
			node temp = nodes.get(j);
			if (adjacency_matrix[nodeindex][j] == 1 && !temp.visited) {
				temp.visited = true;
				System.out.println(temp.data);
				dfs(adjacency_matrix, j);
			}
		}
	}

	private static void dfs(int[][] adjacency_matrix, int nodeindex) {
		for (int j = 0; j < nodes.size(); j++) {
			node temp = nodes.get(j);
			if (adjacency_matrix[nodeindex][j] == 1 && !temp.visited) {
				temp.visited = true;
				System.out.println(temp.data);
				dfs(adjacency_matrix, j);
			}
		}

	}

	private static void bfs(int[][] adjacency_matrix, node n) {
		n.visited = true;
		queue.add(n);

		while (!queue.isEmpty()) {
			node temp = queue.remove();
			System.out.println(temp.data);
			int nodeindex = -1;
			for (int i = 0; i < nodes.size(); i++) {
				if (nodes.get(i).equals(temp)) {
					nodeindex = i;
					break;
				}
			}
			for (int j = 0; j < nodes.size(); j++) {
				// System.out.println(nodes.get(j).data+ " " +j);
				if (adjacency_matrix[nodeindex][j] == 1
						&& !nodes.get(j).visited) {
					queue.add(nodes.get(j));
					nodes.get(j).visited = true;
				}
			}
		}
	}
}
