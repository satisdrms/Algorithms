package com.satisdrms.CTCI;

public class Topic_19_Strings_EX7 {
	// Write an algorithm such that if an element in an MxN matrix is 0, its
	// entire row and column is set to 0.
	public static void main(String[] args) {
		int n = 4;
		int mat[][] = new int[n][n];
		mat = populatematrix(mat, n);
		printmat(mat, n);
		setZeroMatrix(mat, n);
		
		System.out.println("The matrix with zero set are ");
		printmat(mat, n);

	}

	private static void setZeroMatrix(int[][] mat, int n) {
		int[] rows = new int[n];
		int[] cols = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] == 1) {
					mat[i][j] = 0;
				}
				if (cols[j] == 1) {
					mat[i][j] = 0;

				}
			}
		}

	}

	private static int[][] populatematrix(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = i + j;
				if (i == 2 && j == 2) {
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}

	private static void printmat(int[][] mat, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

	}
}
