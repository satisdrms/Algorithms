package com.satisdrms.code.CTCI;

public class Topic_28_QuickSort {
	// static int[] a = { 1, 4, 2, 6, 4, 3, 5, 67, 7, 4, 34, 999, 2, 34, 5, 4,
	// 4,4, 4, 4, 67, 4 };
	static int[] a = { 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5,
			4, 3, 2, 1 };

	static int count = 0;

	public static void main(String[] args) {

		quickSort(0, a.length - 1);
		 print_arr(a);

	}

	private static void quickSort(int start, int end) {
		int pivot = end;
		int wall = start - 1;

		if (end - start <= 1)
			return;
		for (int i = start; i <= end - 1; i++) {
			if (a[i] > a[pivot]) {
			} else {
				swap(Math.min(wall + 1, end), i);
				wall++;
			}
		}
		if (wall != start - 1 || wall == -1) {
			swap(Math.min(wall + 1, end), pivot);
		}
		quickSort(start, wall);
		quickSort(Math.min(wall + 1, end), end);

	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void print_arr(int[] p_arr) {
		for (int i = 0; i < p_arr.length; i++) {
			System.out.print(p_arr[i] + " ");
		}
		System.out.println();
	}
}
