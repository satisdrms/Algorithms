package com.github.satisdrms;

//You are given two sorted arrays, A and B, and 
//A has a large enough buffer at the end to hold B. Write a method to merge B into A in sorted order.

public class Topic_19_Sort_EX1 {

	public static void main(String[] args) {
		int[] a = new int[200];
		int[] c = { 1,5, 5, 6, 7, 9, 11, 15, 17, 188, 355, 376, 565, 789 };
		for (int i = 0; i < c.length; i++)
			a[i] = c[i];
		int[] b = { 4, 8, 13, 99, 222, 999 };
		int aLen = c.length;
		int bLen = b.length;

		 sortUsingInsertionAndBinarySearch(a, b, aLen, bLen);

		sortBookSol(a, b, aLen, bLen);

	}

	private static void sortBookSol(int[] a, int[] b, int aLen, int bLen) {
		int newLen = aLen + bLen;
		int aPointer = aLen - 1, bPointer = bLen - 1, i = 0;
		;
		for (i = newLen - 1; i >= 0 && aPointer > -1 && bPointer > -1; i--) {
			if (a[aPointer] > b[bPointer]) {
				a[i] = a[aPointer];
				aPointer--;
			} else {
				a[i] = b[bPointer];
				bPointer--;
			}
		}
		while (aPointer > -1) {
			a[i] = a[aPointer];
			aPointer--;
		}
		while (bPointer > -1) {
			a[i] = b[bPointer];
			bPointer--;
		}
		for (int j = 0; j < newLen; j++)
			System.out.print(a[j] + " ");

	}

	private static void sortUsingInsertionAndBinarySearch(int[] a, int[] b,
			int aLen, int bLen) {
		int aPos = 0;
		for (int i = 0; i < bLen; i++) {
			aPos = binarySearchPosition(b[i], a, aPos, aLen);
			aLen++;
			int bTmp = b[i], j = 0;
			for (j = aPos; j < aLen - 1; j++) {
				int tmp = a[j];
				a[j] = bTmp;
				bTmp = tmp;
				// a[j + 1] = tmp;
			}
			a[j] = bTmp;
		}
		for (int i = 0; i < aLen; i++)
			System.out.print(a[i] + " ");

	}

	private static int binarySearchPosition(int d, int[] a, int start, int end) {
		if (start == end)
			return start;
		int mid = start + ((end - start) / 2);
		if (d < a[mid])
			return binarySearchPosition(d, a, start, mid);
		else
			return binarySearchPosition(d, a, mid + 1, end);
	}
}
