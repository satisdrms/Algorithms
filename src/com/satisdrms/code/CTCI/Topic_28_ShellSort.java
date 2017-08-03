package com.satisdrms.code.CTCI;

public class Topic_28_ShellSort {
	static int count = 0;

	public static void main(String[] args) {

		int[] a = { 13, 23, 15, 56, 32, 54, 87, 1, 23, 2, 4, 56, 98, 18 };
		int len = a.length;
		// int gap = len / 2;
		printArr(a);

		for (int gap = len / 2; gap > 0; gap /= 2) {
			// System.out.println(gap);
			for (int end = gap; end < len; end++) {
				for (int j = end; j >= gap; j = j - gap) {
					if (a[j] < a[j - gap]) {
						swap(a, j, j - gap);
					} else
						break;
				}
			}
		}
		printArr(a);

		System.out.println();
		System.out.println(count + " swaps and len " + len);
	}

	private static void printArr(int[] a) {
		System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	private static void swap(int[] a, int j, int i) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
		count++;

	}
}
