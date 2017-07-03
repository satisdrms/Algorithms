package pack1;

//Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
//EXAMPLE
//Input: 5, 10
//Output: 10

public class Topic_19_MOD_EX4 {

	public static void main(String[] args) {
		int a = 10, b = -35;

		// --- NOT WORKING for b<2a
		// int c = ((a / b) * b) + ((b / a) * a);
		// System.out.println(c);
		// int d = c + ((a / c) * (a % b)) + ((b / c) * (b % a));
		// System.out.println(d);

		// --- NOT WORKING
		// int c = ((a / b) * b) + ((a / b) * (a % b))
		// + ((b / a) * a) + ((b / a) * (b % a));
		//
		// System.out.println(c);
		// System.out.println();

		// WAS UNABLE TO SOLVE ON MY OWN

		int c = a - b;
		int k = (c >> 31) & 0x1;
		int max = a - k * c;
		System.out.println(max);

		// MY OWN Smallest of three integers without comparison operators
		//
		// System.out.println(1 & 2);

		// Write a program to add one to a given number.
		// You are not allowed to use operators like ‘+’, ‘-‘, ‘*’, ‘/’, ‘++’,
		// ‘–‘ …etc.

		int x = 5;
		System.out.println(Integer.toBinaryString(~5 * -1));
		System.out.println(Integer.toBinaryString(-(~x)));
		System.out.println(-(~x));
		System.out.println((2 >> 1) + " " + (1 << 2));

	}
}
