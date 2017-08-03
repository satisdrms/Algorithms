package com.satisdrms.code.CTCI;

import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

//Given an NxN matrix of positive and negative integers, 
//write code to find the sub-matrix with the largest possible sum.
class coord implements Comparable<coord> {
	int x, y;

	coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean exists(coord n) {
		return (n.x == this.x && n.y == this.y) ? true : false;
	}

	@Override
	public int compareTo(coord n) {
		return (n.x == this.x && n.y == this.y) ? 0 : (n.x + n.y)
				- (this.x + this.y);
	}

}

public class Topic_19_HARD_EX12 {

	public static void main(String[] args) {
		int n = 5;
		int[][] mat = { { 2, 12, -23, 1, -3 }, { 7, 356, -634, 32, 45 },
				{ -342, 2, 4, -4, 32 }, { 34, 3, -8, -2, 234 },
				{ 321, -34, -5, 64, 1 } };
		// int[][] mat = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },{ 1, 1, 1, 1, 1
		// }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
		int max = 0;
		max = mySol(n, mat, max);
		max = bookSol(n, mat, max);// The only diff is precompute matrix sum at
									// each level and the loop is changed a
									// little
	}

	private static int bookSol(int n, int[][] mat, int max) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param n
	 * @param mat
	 * @param max
	 * @return
	 */
	private static int mySol(int n, int[][] mat, int max) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Checking " + i + " " + j);
				LinkedList<coord> previous = new LinkedList<coord>();

				previous.add(new coord(i, j));
				coord next;
				boolean nextPossiblities = true;
				while (nextPossiblities) {
					Set<coord> nextsub = new TreeSet<coord>();
					for (coord c : previous) {
						if (c.x + 1 < n || c.y + 1 < n) {
							// adding column to existing matrix
							next = new coord(c.x, c.y + 1);
							if (!existsAndInLimit(previous, next, n)) {
								nextsub.add(next);
							}
							// adding row to existing matrix
							next = new coord(c.x + 1, c.y);
							if (!existsAndInLimit(previous, next, n)) {
								nextsub.add(next);
							}
							// adding row&column to existing matrix
							next = new coord(c.x + 1, c.y + 1);
							if (!existsAndInLimit(previous, next, n)) {
								nextsub.add(next);
							}
						} else
							nextPossiblities = false;
					}
					previous.addAll(nextsub);
				}
				for (coord c : previous) {
					// System.out.println(c.x+" "+c.y);
					int sum = 0;
					for (int i1 = i; i1 <= c.x; i1++)
						for (int j1 = j; j1 <= c.y; j1++) {
							sum = sum + mat[i1][j1];
						}
					if (max < sum) {
						System.out.println("Max for (" + i + "," + j + ") to ("
								+ c.x + "," + c.y + ") is " + max);
						max = sum;
					}
				}
			}

		}
		return max;
	}

	private static void slp(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean existsAndInLimit(LinkedList<coord> previous,
			coord c, int n) {
		if (c.x < n && c.y < n)
			for (coord next : previous) {
				if (next.x == c.x && next.y == c.y)
					return true;
			}
		else
			return true;
		return false;
	}
}
