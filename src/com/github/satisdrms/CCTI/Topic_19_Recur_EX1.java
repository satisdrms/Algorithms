package com.github.satisdrms.CCTI;

//Write a method to generate the nth Fibonacci number.

public class Topic_19_Recur_EX1 {
	public static void main(String[] args) {
		int n = 9;
		if (n < 3)
			System.out.println(1);
		else
			System.out.println(findNthFiba(n-3, 1, 1));
	}

	private static int findNthFiba(int n, int a, int b) {
		if (n == 0) {
			return a+b;
		} else
			return findNthFiba(n - 1, b, a+b);
	}
}
