package com.satisdrms.CTCI;

//Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
//The result is going to be very large, hence return the result in the form of a string.
//Input:
//The first line of input consists number of the test cases. The description of T test cases is as follows:
//The first line of each test case contains the size of the array, and the second line has the elements of the array.
//Output:
//In each separate line print the largest number formed by arranging the elements of the array in the form of a string.
//Constraints:
//1 ≤ T ≤ 70
//1 ≤ N ≤ 100
//0 ≤ A[i] ≤ 1000

//Example:
//Input:
//3 30 34 5 9 --> 9 5 34 3 30
//54 546 548 60 --> 60 548 546 54
//Output:

public class Topic_GFG_EX2 {

	public static void main(String[] args) {
		// int[] a = { 3, 30, 34, 5, 9 };
		// int[] a = { 9, 941, 94 };
		int[] a = { 54, 546, 548, 60 };
		// System.out.println(98%10);
		mySol(a);
	}

	/**
	 * @param a
	 */
	private static void mySol(int[] a) {
		int len = a.length;
		int[] b = new int[len];
		for (int i = 0; i < len; i++) {
			int insertpos = 0;
			boolean found = false;
			for (int j = 0; j < b.length && !found; j++) {
				int pos = 0;
				char[] x = Integer.toString(a[i]).toCharArray();
				char[] y = Integer.toString(b[j]).toCharArray();
				int match = 0;
				while (x.length - 1 >= pos || y.length - 1 >= pos) {
					if (x.length - 1 >= pos && y.length - 1 >= pos) {
						if ((int) x[pos] > (int) y[pos]) {
							insertpos = j;
							found = true;
							break;
						} else if ((int) x[pos] < (int) y[pos]) {
							pos++;
						} else {
							match++;
							pos++;
						}
					} else {
						if ((pos == y.length && match == pos && (int) x[pos] > (int) y[0]) || pos == x.length) {
							insertpos = j;
							found = true;
						}
						break;
					}
				}
			}
			insert(a[i], b, insertpos);
			print(b);
		}
		print(b);
	}

	private static void print(int[] b) {

		for (int i : b)
			System.out.print(i + " ");
		System.out.println();
		System.out.println();

	}

	private static void insert(int d, int[] b, int insertpos) {
		int temp = 0;
		for (int x = insertpos; x < b.length; x++) {
			temp = b[x];
			b[x] = d;
			d = temp;
		}
	}
}
