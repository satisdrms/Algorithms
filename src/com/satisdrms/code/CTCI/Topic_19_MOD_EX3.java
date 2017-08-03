package com.satisdrms.code.CTCI;

//Write an algorithm which computes the number of trailing zeros in n factorial.

public class Topic_19_MOD_EX3 {

	public static void main(String[] args) {
		int n = 400;
		int zeros = 0, fact = 1;

		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0 || i % 10 == 0)
				zeros++;
		}

		// for (int i = 1; i <= n; i++)
		// fact = fact * i;

		System.out.println(zeros);

		zeros = 0;

		for (int i = 5; n / i > 0; i = i * 5)
			zeros = zeros + n / i;
		System.out.println(zeros);

	}
}
