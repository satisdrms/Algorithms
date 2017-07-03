package com.github.satisdrms;

import java.util.Arrays;

public class Topic_26_ExamplesGGL_Sum_pair_from_collections {

	public static void main(String[] args) {
		//int a[] = { 1, 8, 4, 4, 0, 5, 3, 1, 2, 3, 1 ,8};
		int a[] = { 1, 2, 4, 4, 5,6, 13, 18, 19, 123, 1231 ,123123};
		int sum = 8;
		my_simple_sol_one(a, sum);
		solution_two_binary_search(a, sum);

	}

	private static void solution_two_binary_search(int[] a, int sum) {
		Arrays.sort(a);
		for (int i = 0; i < a.length-1 && a[i]<=sum; i++) {
			System.out.println("searching "+a[i]);
			int remain = sum - a[i];
			if (binary_search_exists(a, remain, i + 1, a.length)) {
				System.out.println("The numbers " + a[i] + " and " + remain
						+ " form a pair");
			}

		}

	}

	private static boolean binary_search_exists(int[] a, int remain, int start,
			int end) {
		System.out.println(start+" "+end);
		int mid = start + ((end - start) / 2);
		if (remain == a[mid]) {
			return true;
		} else if (remain < a[mid] && end-start>1 ) {
			return binary_search_exists(a, remain, start, mid);
		} else if (remain > a[mid] && end-start>1) {
			return binary_search_exists(a, remain, mid, end);
		}
		return false;

	}

	private static void my_simple_sol_one(int[] a, int sum) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++)
				if (a[i] + a[j] == sum) {
					System.out.println("The numbers " + a[i] + " and " + a[j]
							+ " form a pair");
				}
		}
	}

}
