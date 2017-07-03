package com.satisdrms.CTCI;

public class Topic_28_Merge_Sort {
	static int[] a = { 22, 3, 5, 45, 23, 34, 2, 3, 5, 672,3,1,34,235,21,3423,141234 };
	static int[] temp_a = new int[a.length];

	public static void main(String[] args) {

		// 1*2=2
		// 2*2=4
		// 4*2=8

		// for (int i = 2; i < a.length; i = i * 2) {
		// int sort_loop = 1;
		// while (sort_loop <= a.length) {
		// int start = sort_loop - 1;
		// int end = (sort_loop + i - 1);
		// end=end>a.length?a.length:end;
		// sort_loop = sort_loop + i;
		// System.out.println(start + " " + end);
		//
		// a=sort(a,start,end);
		//
		// }
		// }
		// System.out.println(1 / 2);
		print_arr();

		mergesort(0, a.length - 1);

	}

	private static void print_arr() {
		for (int i = 0; i < a.length; i++) {
			System.out.println(i + " " + a[i]);
		}

	}

	private static void mergesort(int start, int end) {
		int mid = (end - start) / 2 + start, mid_start = 0;
		if (mid == end) {
			mid_start = mid;
		} else {
			mid_start = mid + 1;
		}
		// System.out.println("Mid is " + mid + " Start is " + start +
		// " End is "+ end);
		// System.out.println( start + " "+ end);

		if (start != end) {
			mergesort(start, mid);
			mergesort(mid_start, end);
			// System.out.println(start + " " + end);
			merge(start, mid, mid_start, end);
		}
		// System.out.println(start + " " + end);

	}

	private static void merge(int start, int end, int start1, int end1) {
		//System.out.println("Merging " + start + " to " + end + " with "+ start1 + " to " + end1);
		temp_a = a.clone();
		int k = start;
		int i = start, j = start1;
		while (i <= end && j <= end1) {
			if (temp_a[i] <= temp_a[j]) {
				a[k] = temp_a[i];
				i++;
			} else {
				a[k] = temp_a[j];
				j++;
			}
			k++;
		}
		if (i <= end) {
			while (i <= end) {
				a[k] = temp_a[i];
				i++;
				k++;
			}
		} else if (j <= end1) {
			while (j <= end1) {
				a[k] = temp_a[j];
				j++;
				k++;
			}
		}
		print_arr();

	}

	private static void merge_FAILURE(int start, int end, int start1, int end1) {
		System.out.println("Merging " + start + " to " + end + " with "
				+ start1 + " to " + end1);
		for (int i = start, j = start1, k = Math.min(start, start1); k < Math
				.min(start, start1)
				+ ((end - start) + 1)
				+ ((end1 - start1) + 1); k++) {
			if (a[i] > a[j]) {
				System.out.println("swapping" + i + " " + j);
				swap(i, j);
				if (j != end1)
					j++;
			} else if (a[i] <= a[j]) {
				if (i != end)
					i++;
				System.out.println("i is " + i);
			}
		}
		print_arr();

		//
		// System.out.println("swapping" + i + " " + j);
		// swap(i, j);
		// if (j != end1)future_j++;
		// if (i != end)future_i++;
		//
		// if(a[future_j]>=a[i]){j=future_j;}
		// else {j=future_j;}
		//
		// System.out.println("in J -- i is " + i+" j is "+j);
		//
		// } else if (a[i] <= a[j]) {
		// if (j != end1)future_j++;
		// if (i != end)future_i++;
		//
		// if(a[future_i]>=a[j]){i=future_i;}
		// //else {j=future_j;}
		// else {i=future_i;}

	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
