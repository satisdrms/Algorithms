package pack1;

import java.security.cert.X509Certificate;

//Design an algorithm to figure out if someone has won in a game of tic-tac-toe.

// ********* SOLUTION IS BASED ON THE BELOW
//BASED ON THE FACT THAT THE X AND Y DIFF ALONG THE LINE IS SAME and IF THAT DIFF CONTINUES N TIMES THEN N x OR o IS IN LINE
// BOOK SOLUTION IS DIFFERENT

class bSet {
	public int prevX = 0, prevY = 0, xDiff = 0, yDiff = 0;
}

public class Topic_19_MOD_EX2 {
	// _ x _
	// _ x _
	// _ x _
	// o _ _
	// _ o _
	// _ _ o
	public static void main(String[] args) {
		int n = 3;
		char[][] b/* oard */= new char[n][n];
		// char[][] b={{,'x','o'},{,'x','o'},{,'x','o'}};
		boolean isX = true, isO = true;
		int xCount = 0, yCount = 0;
		bSet o = new bSet(), x = new bSet();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (b[i][j] == 'x') {
					xCount++;
					if (xCount <= 2) {
						x.prevX = i;
						x.prevY = j;
						x.xDiff = i - x.prevX;
						x.yDiff = j - x.prevY;
					} else {
						if (i - x.prevX == x.xDiff && j - x.prevY == x.yDiff) {
							x.xDiff = i - x.prevX;
							x.yDiff = j - x.prevY;
							xCount++;
						}
					}

					// IMPLEMENT SIMILAR LOGIC FOR Y AS WELL
				}
			}
		if (xCount == n) {
			System.out.println(" x wins ");
		}
		if (yCount == n) {
			System.out.println(" y wins ");
		}

	}
}
