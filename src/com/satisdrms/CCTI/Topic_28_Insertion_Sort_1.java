package com.satisdrms.CCTI;

public class Topic_28_Insertion_Sort_1 {
	static Character[] a = { 'a', 'd', 'w', 'e', 'd', 'f', 'e', 'r', 'y', 'g',
			'f', 'h', 'u', 't', 'w', 'i', 'j', 'c', 'w', 'a', 'd', 't', 'r',
			'b', 'a', 'h' };
	static int[] a_int = { 1, 4, 2, 6, 4, 3, 5, 67, 7, 4, 34, 999, 2, 34, 5,4,4,4,4,4,
			67, 4 };

	public static void main(String[] args) {
		print_arr(a_int);
		insertion_sort();
		System.out.println("Sorted List");
		print_arr(a_int);

	}

	private static void insertion_sort() {
		for (int i = 1; i < a_int.length; i++) {
			int pos = positionToInsertBinarySearch(0, i - 1, i);
			// System.out.println("pos is " + pos);
			if (pos != -1)
				insert(i, pos);
			// System.out.println("Printing after iteration " + i);
			// print_arr(a_int);
		}
	}

	private static void insert(int i, int pos) {

		int r = i;
		for (int j = pos; j <= i - 1; j++) {
			swap_int(j, r);

		}

	}

	private static int positionToInsertBinarySearch(int start, int end,
			int search) {

		int mid = (end - start) / 2 + start;
		// System.out.println(start + " " + mid + " " + end);
		if (end - start <= 1) {
			// System.out.println("Comparing the " + a_int[end] + " "+
			// a_int[search]);
			if (a_int[end] >= a_int[search])
				return end;
			else
				return -1;
		} else if (a_int[search] >= a_int[mid]) {
			return positionToInsertBinarySearch(mid, end, search);
		} else if (a_int[search] < a_int[mid])
			return positionToInsertBinarySearch(start, mid, search);

		return mid;

	}

	private static void swap_int(int i, int j) {
		int temp = a_int[i];
		a_int[i] = a_int[j];
		a_int[j] = temp;
	}

	private static void print_arr(int[] p_arr) {
		for (int i = 0; i < p_arr.length; i++) {
			System.out.println(i + " " + p_arr[i]);
		}
	}

	private static <E> void print_arr(E[] p_arr) {
		for (int i = 0; i < p_arr.length; i++) {
			System.out.println(i + " " + p_arr[i]);
		}
	}

	private static void swap(int i, int j) {
		Character temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
