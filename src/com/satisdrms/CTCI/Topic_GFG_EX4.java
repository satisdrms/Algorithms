package com.satisdrms.CTCI;

import java.util.Arrays;

//Given an sorted array of alphabets find the count of each element
public class Topic_GFG_EX4 {

	public static void main(String[] args) {
		String s = "thisisasamplestring";
		char f = 't';
		char[] cr = s.toCharArray();
		Arrays.sort(cr);
		System.out.println(cr);
		int len = cr.length;

		binsearch(cr, 0, len, f);

	}

	private static void binsearch(char[] cr, int start, int end, char f) {
		int mid = start + ((end - start) / 2);
		if (cr[mid] == f) {
			System.out.println(f+" fount at "+ mid);
			int count = 1;
			int i = 1;
			while (true) {
				int temp = count;
				if (mid - i >= 0) {
					if (cr[mid - i] == f)
						count++;
				}
				if (mid + i < cr.length) {
					if (cr[mid + i] == f)
						count++;
				}
				i++;
				if (temp == count)
					break;
			}
			System.out.println("no of occurcences of " + f + " is " + count);
			return;
		}
		if (cr[mid] < f) {
			binsearch(cr, mid + 1, end, f);
		} else {
			binsearch(cr, start, mid, f);
		}
	}
}
