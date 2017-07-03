package com.github.satisdrms.CCTI;

public class Topic_19_Strings_EX6 {
	// Given an image represented by an NxN matrix, where each pixel in the
	// image is 4 bytes, write a method to rotate the image by 90 degrees. Can
	// you do this in place?

	public static void main(String[] args) {
		int n = 4;
		String img[][] = new String[n][n];
		img = populatematrix(img, n);
		printmat(img, n);
		System.out.println();
		img = rotateMatrix(img, n);
		System.out.println();
		printmat(img, n);
	}

	private static String[][] populatematrix(String[][] img, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				img[i][j] = Integer.toString(i) + Integer.toString(j);
			}
		}
		return img;
	}

	private static void printmat(String[][] img, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(img[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static String[][] rotateMatrix(String[][] img, int n) {
		// int offset = n - 1;
		for (int layer = 0; layer < n / 2; layer++) {
			int last = n - layer - 1;
			System.out.println("last " + last + " and i is " + layer);
			for (int j = layer; j < last; j++) {

				String temp = img[j][layer];
				img[j][layer] = img[layer][(last + layer) - j];
				img[layer][(last + layer) - j] = img[(last + layer) - j][last];
				img[(last + layer) - j][last] = img[last][j];
				img[last][j] = temp;

			}

		}
		return img;
	}

}
