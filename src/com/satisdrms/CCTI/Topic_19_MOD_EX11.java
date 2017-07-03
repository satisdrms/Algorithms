package com.satisdrms.CCTI;

import java.util.HashSet;

//Design an algorithm to find all pairs of integers within an array which sum to a specified value.

public class Topic_19_MOD_EX11 {

	public static void main(String[] args) {
		int[] a = { 1, 54, 3, 2, 5, 6, 78, 43, 2, 3, 4, 1, 34, 6, 4, 2, 34 };
		int sum = 7;
		HashSet<Integer> past = new HashSet<Integer>();
		past.add(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (past.contains(sum - a[i])) {
				System.out.println("Pairs are " + a[i] + " " + (sum - a[i]));
			}
			past.add(a[i]);
		}

	}
}
