package com.satisdrms.CCTI;

import java.util.Random;

//Write a method to generate a random number between 1 and 7, 
//given a method that generates a random number between 1 and 5 
//(i.e., implement rand7() using rand5()).

public class Topic_19_MOD_EX10 {

	public static void main(String[] args) {
		System.out.println((r5() + r5()) % 8);
		System.out.println(r5BookSol());
	}

	public static int r5() {
		return new Random().nextInt(5) + 1;
	}

	public static int r5BookSol() {

		while (true) {
			int num = 5 * (r5() - 1) + (r5() - 1);
			if (num < 21)
				return (num % 7 + 1);
		}
	}
}
