package com.github.satisdrms.CCTI;

import java.util.Random;

//Numbers are randomly generated and passed to a method. 

//Write a program to find and maintain the median value as new values are generated.

//1 3 4 2 5 6 7

public class Topic_19_HARD_EX9 {

	public static void main(String[] args) {
		Random r = new Random();
		int median=0;
		for (int i = 0; i < 100; i++) {
			System.out.println(r.nextInt(9));
		}
		
		//ALREADY SOLVED
		//USE MIN AND MAX HEAP TO KEEP TRACK OF LEFT AND RIGHT HALF
	}

}
