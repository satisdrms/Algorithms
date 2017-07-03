package pack1;

//Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot?
//FOLLOW UP
//Imagine certain squares are “off limits”, such that the robot can not step on them. Design an algorithm to get all possible paths for the robot.

public class Topic_19_Recur_EX2 {

	public static void main(String[] args) {
		int n = 5;
		int[][] offLimits = { { 1, 2 } };
		String[] offLiStr = { "22" };
		int paths = findPath(1, 1, n, offLiStr);
		System.out.println(paths);

	}

	private static int findPath(int i, int j, int n, String[] offLiStrs) {
		int paths = 0;
		if (isoffLimits(offLiStrs, i, j))
			return 0;
		else if (i == n && j == n)
			return 1;
		if (i < n)
			paths = paths + findPath(i + 1, j, n, offLiStrs);
		if (j < n)
			paths = paths + findPath(i, j + 1, n, offLiStrs);
		return paths;

	}

	private static boolean isoffLimits(String[] offLiStrs, int i, int j) {

		for (int x = 0; x < offLiStrs.length; x++) {
			if (offLiStrs[x]
					.equals((Integer.toString(i) + Integer.toString(j))))
				return true;
		}
		//System.out.println("returning false");
		return false;

	}
}
