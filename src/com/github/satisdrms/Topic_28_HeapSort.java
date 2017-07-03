package com.github.satisdrms;

import java.util.ArrayList;

public class Topic_28_HeapSort {

	public static void main(String[] args) {
		int[] a = { 5, 3, 2, 4, 7, 67, 79, 5, 34, 5, 54, 568, 0, 54, 23, 3, 54,
				8, 789, 264, 78, 0, 76, 56, 78, 54, 34, 54, 67 };
		// int[] b = java.util.Arrays.copyOf(a, a.length);
		// int[] a = { 1, 2, 3, 4, 5, 7 };
		// System.out.println(java.util.Calendar.getInstance().getTime());
		// printarr(b);
		// System.out.println(java.util.Calendar.getInstance().getTime());

		heapSort(a);
		// System.out.println(java.util.Calendar.getInstance().getTime());

	}

	private static void heapSort(int[] a) {
		maxHeapify(a);
		int end = a.length - 1;
		while (end >= 0) {
			int last = a[end];
			a[end] = a[0];
			end--;
			a[0] = last;
			int low = 1;
			// cascading the last element down the heap tree
			while (low * 2 <= end) {
				int r, l;
				if (low * 2 + 1 <= end) {
					r = low * 2;
					l = low * 2 + 1;
				} else {
					r = low * 2;
					l = low * 2;
				}
				int max = 0;
				// Decrementing all by one to match the actual places in
				// array
				r--;
				l--;
				low--;
				if (a[r] > a[l])
					max = r;
				else
					max = l;
				if (a[low] < a[max]) {
					swap(a, low, max);
					low = max + 1;
				} else
					break;
			}
			// printarr(a);

		}
		printarr(a);
	}

	private static void maxHeapify(int[] a) {
		int i = a.length;
		// printarr(a);
		// printarrtree(a);//work on printing in tree format later
		while (i > 1) {
			int parent = i / 2, left = 0, right = 0;
			if (i % 2 == 1) {
				right = i;
				left = i - 1;
				i = i - 2;
			} else {
				left = i;
				right = i;
				i = i - 1;
			}
			// Decrementing all by one to match the actual places in array
			parent--;
			left--;
			right--;
			// System.out.println("left right parent " + left + " " + right +
			// " "
			// + parent);
			int greatest = 0;
			if (a[left] < a[right])
				greatest = right;
			else
				greatest = left;
			if (a[parent] < a[greatest]) {
				swap(a, greatest, parent);
				// incrementing low by 1 to match with the indicies of the heap
				// tree position
				int low = greatest + 1;
				// printarr(a);

				while (low * 2 <= a.length) {
					int r, l;
					if (low * 2 + 1 <= a.length) {
						r = low * 2;
						l = low * 2 + 1;
					} else {
						r = low * 2;
						l = low * 2;
					}
					int max = 0;
					// Decrementing all by one to match the actual places in
					// array
					r--;
					l--;
					low--;
					if (a[r] > a[l])
						max = r;
					else
						max = l;
					if (a[low] < a[max]) {
						swap(a, low, max);
						// incrementing low by 1 to match with the indicies of
						// the heap tree position
						low = max + 1;
					} else
						break;

				}
			}

		}
		// printarr(a);
	}

	/**
	 * @param a
	 */
	private static void printarr(int[] a) {
		for (int x : a) {
			System.out.println(x);
		}
	}

	private static void printarrtree(int[] a) {
		ArrayList<Integer> breadthFirst = new ArrayList<Integer>();
		breadthFirst.add(1);
		// to get the log 2 factor
		int level = (int) Math.floor((Math.log(a.length) / Math.log(2)));
		System.out.println(a.length + " " + level);
		while (!breadthFirst.isEmpty()) {

		}
	}

	private static void swap(int[] a, int from, int to) {
		// incrementing from and to by ONE as heap in array always starts with 1
		// not 0
		// from++;
		// to++;
		// System.out.println("Swapping " + from + " " + to);
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}
}
