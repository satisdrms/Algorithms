package com.satisdrms.CTCI;

//Write a function to swap a number in place without temporary variables.

public class Topic_19_MOD_EX1 {

	public static void main(String[] args) {
		int a = 4, b = 9;
		a = a * 1000 + b;
		b = a / 1000;
		a = a % 1000;
		System.out.println(a + " " + b);

		int c = 4, d = 9;
		c = d - c;
		d = d - c;
		c = c + d;
		System.out.println(c + " " + d);

		int e = 77, f = 800;
		f=f^e;
		e=e^f;
		f=f^e;
		System.out.println(e + " " + f);

	}
}
