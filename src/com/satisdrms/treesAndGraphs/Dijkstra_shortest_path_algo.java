package com.satisdrms.treesAndGraphs;

//Dijkstra’s shortest path algorithm

class ShortestPath {

	public void dijkstra(int[][] graph, int start) {
		int fromnode = start;

		int[] SPT = new int[graph.length];
		boolean[] SPTVisited = new boolean[graph.length];

		for (int i = 0; i < graph.length; i++) {
			SPT[i] = Integer.MAX_VALUE;
			SPTVisited[i] = false;
		}

		SPT[fromnode] = 0;
		// SPTVisited[fromnode] = true;
		boolean exists = true;
		while (true) {

			int min = Integer.MAX_VALUE, pos = 0;
			for (int j = 0; j < SPT.length; j++) {
				if (SPT[j] < min && SPTVisited[j] == false) {
					min = SPT[j];
					pos = j;
				}
			}
			// break if all are visited
			if (min == Integer.MAX_VALUE)
				break;

			SPTVisited[pos] = true;
			for (int j = 0; j < graph[pos].length; j++) {
				if (graph[pos][j] > 0 && SPTVisited[j] == false) {
					if (SPT[j] > SPT[pos] + graph[pos][j])
						SPT[j] = SPT[pos] + graph[pos][j];
				}
			}
		}
		for (int i = 0; i < SPT.length; i++) {
			System.out.println(i + " " + SPT[i]);
		}
	}
}

public class Dijkstra_shortest_path_algo {

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		ShortestPath t = new ShortestPath();
		t.dijkstra(graph, 0);

	}

}
