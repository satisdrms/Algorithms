package com.satisdrms.code.interPrct;

//Find the maximum product of three numbers in an integer array .

public class Example1 {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 2, 3, 6, 6, 4, 199 };

		if (arr.length <= 3)
			return;
		int one = 0;
		int two = 0;
		int three = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > one) {
				three = two;
				two = one;
				one = arr[i];
			} else if (arr[i] > two) {
				three = two;
				two = arr[i];
			} else if (arr[i] > three) {
				three = arr[i];
			}
		}
		System.out.println(one + " " + two + " " + three);
		System.out.println(one * two * three);

	}
}
