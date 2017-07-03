package com.satisdrms.CTCI;

import java.util.Random;

//Write a method to randomly generate a set of m integers from an array of size n. 
//Each element must have equal probability of being chosen.

public class Topic_19_HARD_EX3 {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n = a.length;
		int m = 4;
		int[] set = new int[n];
		int count = 0;
		Random r = new Random();
		for (int i = 0; i < m; i++) {
			int pos = (int) ((Math.random() * (a.length - i)) + i);
			swap(a, i, pos);
		}
		for (int i : a) {
			System.out.println(i);
		}
	}

	private static void swap(int[] a, int i, int pos) {
		int from = a[i];
		a[i] = a[pos];
		a[pos] = from;

	}
}
