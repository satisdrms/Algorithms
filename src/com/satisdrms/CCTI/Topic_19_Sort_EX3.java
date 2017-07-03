package com.satisdrms.CCTI;

//Given a sorted array of n integers that has been rotated an unknown number of times, 
//give an O(log n) algorithm that finds an element in the array. You may assume that the array was originally sorted in increasing order.
//EXAMPLE:
//Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
//Output: 8 (the index of 5 in the array)

public class Topic_19_Sort_EX3 {

	public static void main(String[] args) {
		int[] a = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		int e = 14;

		int pos = binarySearch(a, e, 0, a.length - 1);
		System.out.println("pos is " + pos);

	}

	private static int binarySearch(int[] a, int d, int start, int end) {
		int mid = start + ((end - start) / 2);
		if (a[start] == d)
			return start;
		else if (a[end] == d)
			return end;
		else if (start == end)
			return start;
		if ((a[start] > a[mid] && d >= a[start]) || d <= a[mid])
			return binarySearch(a, d, start, mid);
		else
			return binarySearch(a, d, mid + 1, end);
	}
}
