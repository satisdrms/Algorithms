package com.satisdrms.CTCI;

public class Topic_28_CycleSort {
	public static int writes = 0;

	public static void main(String[] args) {
		int[] a = { 3, 12, 82, 343, 124, 2354, 123, 412, 342, 53, 45, 7, 5, 67,
				8, 546, 4, 543, 4, 23, 6, 67 };
		// int[] a = { 7, 9, 10, 4, 20, 2, 6 };
		int len = a.length;
		System.out.println("len is " + len);
		printarr(a);

		for (int cyclestart = 0; cyclestart < len - 2; cyclestart++) {
			// System.out.println("------"+a[cyclestart]);
			// printarr(a);

			int item = a[cyclestart];
			int pos = cyclestart;

			for (int j = cyclestart + 1; j < len; j++) {
				if (item > a[j]) {
					pos++;
				}
			}

			if (pos == cyclestart)
				continue;

			// ignoring the duplicate elements
			while (item == a[pos])
				pos++;

			item = swap(item, pos, a);
			while (pos != cyclestart) {
				// printarr(a);

				// System.out.println(item);
				pos = cyclestart;
				for (int nextNode = cyclestart + 1; nextNode < len; nextNode++) {
					if (item > a[nextNode]) {
						pos++;
					}
				}

				while (item == a[pos])
					pos++;
				// System.out.println("=" + pos);
				if (pos != cyclestart)
					item = swap(item, pos, a);

			}
			item = swap(item, cyclestart, a);

		}
		printarr(a);
		System.out.println("Number of swaps/writes are " + writes);

	}

	private static void printarr(int[] a) {
		// System.out.println();
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	private static int swap(int item, int pos, int[] a) {
		int temp = a[pos];
		a[pos] = item;
		writes++;
		return temp;

	}
}
