package com.github.satisdrms.CCTI;

//Imagine you have a square matrix, where each cell is filled with either black or white. 
//Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
enum c {
	black, white
}

public class Topic_19_HARD_EX11 {

	public static void main(String[] args) {
		mySolWorks();
		// MYSOL IS ALMOST SAME AS BOOKSOLE WITH MINOR CHANGES
	}

	/**
	 * 
	 */
	private static void mySolWorks() {
		int n = 5;
		c black = c.black, white = c.white;
		c[][] mat = { { c.white, c.white, c.white, c.white, c.white },
				{ c.black, c.black, c.black, c.black, c.white },
				{ c.black, c.black, c.black, c.black, c.white },
				{ c.black, c.black, c.black, c.black, c.white },
				{ c.black, c.black, c.black, c.black, c.white } };
		boolean left = false, right = false, up = false, down = false;
		right = true;
		int max = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				int maxSquare = Math.min(n - i, n - j);
				// System.out.println("Checking " + i + " " + j);
				int curSquare = 0;
				int x = i, y = j;
				if (mat[i][j] == black) {
					right = true;
					down = left = up = false;
					curSquare = 1;
					while (true) {
						// System.out.println("In while" + right + down + left+
						// up + " " + curSquare + " " + maxSquare + " "+ x + " "
						// + y);
						if (right) {

							while (mat[x][y + 1] == black
									&& curSquare + 1 <= maxSquare) {
								y++;
								curSquare++;
							}

							right = false;
							down = true;
						}
						// System.out.println(curSquare);
						if (down) {
							int c = curSquare;
							while (--c > 0 && mat[++x][y] == black)
								;
							if (c != 0) {
								curSquare--;
								down = true;
								x = i;
								y = j + curSquare - 1;

							} else {
								down = false;
								left = true;
							}
						}
						if (left) {
							int c = curSquare;
							while (--c > 0 && mat[x][--y] == black)
								;
							if (c != 0) {
								curSquare--;
								down = true;
								x = i;
								y = j + curSquare - 1;
							} else {
								left = false;
								up = true;
							}
						}
						if (up) {
							int c = curSquare;
							while (--c > 0 && mat[--x][y] == black)
								;
							up = false;
							if (c != 0) {
								curSquare--;
								down = true;
								x = i;
								y = j + curSquare - 1;
							} else {
								System.out.println("Max square is " + curSquare
										+ " at " + i + " " + j);
								break;
							}

						}
						slp(1000);
						// System.out.println("In while" + right + down + left
						// + up + " " + curSquare + " " + maxSquare + " "
						// + x + " " + y);
					}
				}
				// for (int square = n - j; square >= 2; square--) {}
			}
		}
	}

	/**
	 * 
	 */
	private static void slp(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
