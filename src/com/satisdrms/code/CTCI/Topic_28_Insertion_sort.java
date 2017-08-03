package com.satisdrms.code.CTCI;

public class Topic_28_Insertion_sort {
	// static int[] a = { 22, 3, 5, 45, 23, 34, 2, 3, 5, 672, 3, 1, 34, 235,
	// 21,3423, 141234 };
	static int[] a = { 13, 23, 15, 56, 32, 54, 87, 1, 23, 2, 4, 56, 98, 18 };
	static int count = 0;

	public static void main(String[] args) {
		print_arr();

		insertion_sort_1();
		print_arr();
		System.out.println();
		System.out.println(count + " swaps and len " + a.length);

	}

	private static void print_arr() {
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			//System.out.println(i + " " + a[i]);
			System.out.print( a[i]+" ");
		}
		System.out.println();
	}

	private static void insertion_sort_1() {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					swap(i, j);
				}
			}
		}
	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		count++;

	}

}
