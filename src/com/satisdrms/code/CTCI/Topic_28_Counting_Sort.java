package com.satisdrms.code.CTCI;

public class Topic_28_Counting_Sort {
	static Character[] a = { 'a', 'd', 'w', 'e', 'd', 'f', 'e', 'r', 'y', 'g',
			'f', 'h', 'u', 't', 'w', 'i', 'j', 'c', 'w', 'a', 'd', 't', 'r',
			'b', 'a', 'h' };
	static int[] a_int = { 1, 4, 2, 6, 4, 3, 5, 67, 7, 4, 34, 2, 34, 5, 67, 4 };

	public static void main(String[] args) {
		print_arr(a);
		counting_sort();
		counting_sort_int();
		// print_arr(a);

	}

	private static void counting_sort_int() {
		int[] a_count = new int[1000];
		int a_int_new[] = new int[a_int.length];
		for (int i = 0; i < a_int.length; i++) {
			a_count[a_int[i]]++;
		}
		int new_arr_count = 0;
		for (int i = 0; i < a_count.length; i++) {
			if (a_count[i] > 0) {
				for (int j = 0; j < a_count[i]; j++) {
					a_int_new[new_arr_count] = i;
					new_arr_count++;

				}
			}
		}
		print_arr(a_int_new);

	}

	private static void counting_sort() {
		int[] chr_count = new int[256];
		Character[] new_a = new Character[a.length];
		for (int i = 0; i < a.length; i++) {
			chr_count[a[i]]++;
		}
		for (int i = 1; i < chr_count.length; i++) {
			chr_count[i] = chr_count[i] + chr_count[i - 1];
		}
		// print_arr(chr_count);
		for (int i = 0; i < a.length; i++) {
			// System.out.println(i+" "+chr_count[a[i]]);
			new_a[chr_count[a[i]] - 1] = a[i];
			chr_count[a[i]]--;
		}
		print_arr(new_a);
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
