package com.github.satisdrms;

public class Topic_28_Bubble_Sort {
	static int[] a = { 29,28,27,26,25,24,23,22,21,20,19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5,
			4, 3, 2, 1 };

	public static void main(String[] args) {
		print_arr(a);
		bubble_sort();
		print_arr(a);
	}

	private static void bubble_sort() {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i <= a.length - 2; i++) {
				if (a[i] > a[i + 1]) {
					swap(i, i + 1);
					flag = true;
				}
			}
			print_arr(a);

		}

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
