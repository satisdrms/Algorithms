package com.github.satisdrms;

//Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
//http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
//Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

//Examples:
//1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to find that the subarray lies between the indexes 3 and 8.

//2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that the subarray lies between the indexes 2 and 5.

public class Topic_GFG_EX1 {
	//TODOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
	//DIDNT SOLVED IT YET // BORING TO SOLVE EASY
	
	public static void main(String[] args) {
		int[] a = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 11, 60 };
		// int[] a = { 0, 1, 15, 25, 6, 7, 30, 40, 50 };
		int len = a.length;
		int start = 0, end = 0, max = 0, maxele = 0;
		boolean notstarted = true;
		for (int i = 1; i < len; i++) {
			if (a[i - 1] > a[i] || (!notstarted && a[i] < maxele)) {
				if (notstarted) {
					System.out.println("Started");
					int j = 0;
					for (j = i - 1; j >= 0; j--) {
						if (a[i] < a[j])
							continue;
						else {
							start = j + 1;
							notstarted = false;
							break;
						}
					}
				}
				max++;
				maxele = Math.max(maxele, a[i]);
				System.out.println("Start is " + start + " end is " + (i - 1));
			} else if (!notstarted) {
				System.out.println("Start is " + start + " end is " + (i - 1));
				notstarted = true;
			}
		}
	}
}
