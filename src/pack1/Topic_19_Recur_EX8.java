package pack1;

import java.util.ArrayList;

//Write an algorithm to print all ways of arranging
//eight queens on a chess board so that none of them share the same row, column
//or diagonal.

class myset {
	int x, y;

	myset(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Topic_19_Recur_EX8 {

	public static void main(String[] args) {
		int x = 1, y = 1, n = 8;
		// int ways = findPositionsQueen(x, y, n);System.out.println(ways);
		int[] columnForRow = new int[8];
		// for (int i = 0; i < 8; i++)
		// columnForRow[i] = -2;
		int ways = placeQueen(columnForRow, 0);
		// for (int i = 0; i < 8; i++)
		// System.out.println(placeQueen(new int[8]/*columnForRow*/, i));

	}

	private static int placeQueen(int[] columnForRow, int row) {
		if (row == 8) {
			printBoard(columnForRow);
			return 1;
		}
		//System.out.println("row is " + row);
		for (int i = 0; i < 8; i++) {
			// System.out.println("row looper is " + i);
			columnForRow[row] = i;
			//p(columnForRow);
			if (check(columnForRow, row)) {
				placeQueen(columnForRow, row + 1);
			}
		}
		return 0;
	}

	private static boolean check(int[] columnForRow, int row) {
		for (int i = 0; i < row; i++) {

			if (i != row) {
				// System.out.println("col is " + columnForRow[i] + " col is " +
				// i);
				if (columnForRow[i] == columnForRow[row] || (i + columnForRow[i]) == (row + columnForRow[row])
						|| (i - columnForRow[i]) == (row - columnForRow[row])) {
					// if (columnForRow[i] == columnForRow[row] ||
					// (Math.abs(columnForRow[i] - columnForRow[row]) == row -
					// i)) {
					//System.out.println("Returning false");
					return false;
				}
			}
		}
		return true;
	}

	private static void p(int[] columnForRow) {
		System.out.println("");
		for (int i = 0; i < 8; i++)
			System.out.print(columnForRow[i] + " ");

	}

	private static void printBoard(int[] columnForRow) {
		System.out.println();
		System.out.println("A Pattern");
		for (int i = 0; i < 8; i++) {
			System.out.println();
			for (int j = 0; j < 8; j++) {
				if (columnForRow[i] == j) {
					System.out.print("q");
				} else {
					System.out.print("o");
				}

			}
		}

	}

	// MY SOLUTION NOT WORKING
	private static int findPositionsQueen(int x, int y, int n) {
		int ways = 0;
		if (x <= n && y <= n) {
			System.out.println("checking pos" + x + " " + y);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (positionQueens(x, y, 8, new ArrayList<myset>())) {
				ways = 1;
			}
			ways = ways + findPositionsQueen(x + 1, y, n);
			System.out.println("Ways are " + ways);
			ways = ways + findPositionsQueen(x, y + 1, n);
			System.out.println("Ways are " + ways);
			return ways;
		} else
			return 0;
	}

	@SuppressWarnings("unchecked")
	private static boolean positionQueens(int x, int y, int qRemain, ArrayList<myset> pos) {
		if (qRemain == 0) {
			return true;
		}
		pos.add(new myset(x, y));
		ArrayList<myset> opens = getAllOpen(pos);
		for (myset s : opens) {
			if (positionQueens(s.x, s.y, qRemain - 1, (ArrayList<myset>) pos.clone()))
				return true;
		}
		return false;
	}

	private static ArrayList<myset> getAllOpen(ArrayList<myset> pos) {
		ArrayList<myset> opens = new ArrayList<myset>();
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				boolean cut = false;
				for (myset m : pos) {
					if (m.x == x || m.y == y || (m.x + m.y) == (x + y) || ((m.x - x) - (m.y - y) == 0)) {
						cut = true;
					}
				}
				if (!cut) {
					opens.add(new myset(x, y));
				}
			}
		}
		return opens;
	}
}
