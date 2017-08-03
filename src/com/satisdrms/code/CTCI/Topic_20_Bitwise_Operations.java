package com.satisdrms.code.CTCI;

import java.math.BigInteger;

public class Topic_20_Bitwise_Operations {

	public static void main(String[] args) {
		String ex1 = "This is a sample sentence to test this problem", ex3 = "";
		// int val = 0;
		// System.out.println(1 << val);
		// System.out.println(ex1.charAt(0) - 'a');
		// System.out.println('T' - 'a');
		// System.out.println(Integer.toBinaryString('h' - 'a'));
		String str = "abcdefghijklmnopqrstuvwxyz";
		// uniquechar_working_with_binary(str);
		int val =-1, s = 1;
		System.out.println("Binary of val is "+ Integer.toBinaryString(val) );
		System.out.println("VAL IS " + val);
		System.out.println("Binary of S after shifting left is "+ Integer.toBinaryString((s << val)) );
		System.out.println( "S after shifting is "+ (s << val));
		BigInteger checker = BigInteger.valueOf(99999999);
		System.out.println("Binary of BigInteger "+checker.toString());


	}

	private static void uniquechar_working_with_binary(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

			//System.out.println();
			//System.out.println("-------------");
			//System.out.println("Char is " + str.charAt(i));
			//System.out.println("VAL IS " + val + " - binary of val is "+ Integer.toBinaryString(val));
			//System.out.println("Bool Checker is "+ Integer.toBinaryString(checker) + " - binary VAL is "+ Integer.toBinaryString(val) + " - VAL after moving is "+ Integer.toBinaryString(1 << val));

			if ((checker & (1 << val)) > 0)
				break;
			//System.out.println("binary of CHECKER IS berfore OR "+ Integer.toBinaryString(checker) + " and checker int "+ checker + " ");
			checker |= (1 << val);

			//System.out.println("binary of CHECKER IS "+ Integer.toBinaryString(checker) + " and checker int "+ checker + " ");
		}
	}
}
