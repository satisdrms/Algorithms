package com.github.satisdrms;

import java.util.LinkedList;

//Describe an algorithm to find the largest 1 million numbers in 1 billion numbers. 
//Assume that the computer memory can hold all one billion numbers.

public class Topic_19_HARD_EX6 {

	public static void main(String[] args) {
		// int[] arr = { 231, 2, 4, 4, 342, 234, 21, 123, 1, 3, 12, 31, 23, 12,
		// 3, 21, 42, 353, 46, 45, 647, 545, 8,457663, 45, 32, 45, 32, 5, 556,
		// 3, 56, 74586, 745, 6, 435, 43, 523, 4, 234, 532, 45, 43, 634 };
		int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// LinkedList<Integer> oneMil = new LinkedList<Integer>();

		// *********I GUESSED TWO SOLUTIONS CORRECT
		// *********SORT AND TAKE LARGEST ONE MILLION & USE MIN HEAP

		// IMPLEMENTING THE BOOK SOL BELOW
		// NOT IMPLEMENTED FULLY BUT NEEDS FEW TWEAKS

		int pivot = 0, end = arr.length;
		int count = 5;
		while (true) {
			pivot = swap(pivot, arr, end);
			if (end - pivot > count) {
				pivot = pivot + 1;
			} else if (end - pivot < count) {
				end = pivot;
				pivot = 0;
			} else
				break;
			for (int i : arr) {
				System.out.println(i);
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static int swap(int pivot, int[] arr, int end) {
		for (int i = pivot + 1; i < end; i++) {
			if (arr[pivot] > arr[i]) {
				for (int j = i; j > pivot; j--) {
					swap(j, j - 1, arr);
					// System.out.println("swapping " + arr[j] + " " + arr[j -
					// 1]);
				}
				pivot = pivot + 1;
			}
		}
		return pivot;
	}

	private static void swap(int j, int i, int[] arr) {
		int t = arr[j];
		arr[j] = arr[i];
		arr[i] = t;

	}

}
