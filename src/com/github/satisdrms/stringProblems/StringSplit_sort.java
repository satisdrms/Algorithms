package com.github.satisdrms.stringProblems;

import java.util.Arrays;
import java.util.Random;

public class StringSplit_sort {

	public static void main(String[] args) {
		String str = "I xam a software developer";
		Random rand = new Random();
		String[] strarr = str.split(" ", 2);
		for (String s : strarr) {
			System.out.println(s);
		}
		Arrays.sort(strarr);
		System.out.println(Arrays.toString(strarr));

		str_sort[] sort = new str_sort[10];
		for (int i = 0; i < 10; i++) {
			if (sort[i] == null) {
				sort[i] = new str_sort();
			}
			sort[i].setS(rand.nextInt(50)+"");
		}
		Arrays.sort(sort);
		for (int i = 0; i < 10; i++) {
			System.out.println(sort[i].getS());
		}
	}
}
