package com.satisdrms.code.CTCI;

//You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.
//EXAMPLE
//Input: {2, -8, 3, -2, 4, -10}
//Output: 5 (i.e., {3, -2, 4} )

public class Topic_19_MOD_EX7 {

	public static void main(String[] args) {
		int[] in = { 20, -19, 13, -20, -2, -3, -2, 4, 10 };
		int sum = 0, maxsum = 0;

		for (int i = 0; i < in.length; i++) {
			sum = sum + in[i];
			if (sum > maxsum) {
				maxsum = sum;
			}
			if (sum < 0)
				sum = 0;
		}
		System.out.println(maxsum);
	}

}
