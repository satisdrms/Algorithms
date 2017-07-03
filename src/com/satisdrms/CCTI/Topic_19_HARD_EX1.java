package com.satisdrms.CCTI;

//Write a function that adds two numbers. You should not use + or any arithmetic operators.

public class Topic_19_HARD_EX1 {

	public static void main(String[] args) {
		int a = 9;
		int b = 118;

		// solMine(a, b);//TAKES TOOK MUCH TIME AS NEGATIVE NUMBERS HAVE TO LOOP
		// AROUND THE MAX INT VALUE
		solBook(a, b);

	}

	private static void solBook(int a, int b) {
		int carry = a & b;
		int sum = a ^ b;

		while (carry > 0) {
			sum = sum ^ (carry << 1);
			carry = carry & sum;

		}
		System.out.println(sum);

	}

	/**
	 * @param a
	 * @param b
	 */
	private static void solMine(int a, int b) {
		while (b != 0) {
			b = ~(-b);
			a = -(~a);
		}
		System.out.println(a);
	}

}
