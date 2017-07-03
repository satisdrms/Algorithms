package com.github.satisdrms;

public class Topic_28_SelectionSort {
	public static int count = 0;

	public static void main(String[] args) {

		int[] a = { 3, 12, 82, 343, 124, 2354, 123, 412, 342, 53, 45, 7, 5, 67,
				8, 546, 4, 543, 4, 23, 6, 67 };
		int len = a.length;
		printarr(a);

		for (int i = 0; i < len; i++) {
			int minpos = i;
			for (int j = i + 1; j < len; j++) {
				if (a[minpos] > a[j])
					minpos = j;
			}
			if (minpos != i)
				swap(minpos, i, a);
		}
		printarr(a);
		System.out.println("Number of swaps/writes are " + count);
	}

	private static void printarr(int[] a) {
		// System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static void swap(int minpos, int i, int[] a) {
		int temp = a[minpos];
		a[minpos] = a[i];
		a[i] = temp;
		count++;

	}
}
