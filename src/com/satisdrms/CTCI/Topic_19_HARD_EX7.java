package com.satisdrms.CTCI;
//Write a program to find the longest word made of other words in a list of words.

import java.util.Arrays;
import java.util.Comparator;

//EXAMPLE
//Input: test, tester, testertest, testing, testingtester
//Output: testingtester

public class Topic_19_HARD_EX7 {

	public static void main(String[] args) {
		String[] words = { "test", "bottom", "bottomtestingtester", "tester", "testertest", "testing",
				"testingtester" };
		// mySol1(words);
		mySol2(words);
	}

	private static void mySol2(String[] words) {
		// Guessed the solution half correct
		// Sort the array by size from largest to smallest
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return s2.length() - s1.length();
			}

		});
		String largest = "";
		for (int i = 0; i < words.length; i++) {
			int c = 0;
			// String w = words[i];
			int start = 0, end = 0;
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].contains(words[j])) {
					// w.replace(words[j], "");
					start = Math.min(start, words[i].indexOf(words[j]));
					end = Math.max(end, words[j].length() + words[i].indexOf(words[j]));

				}
			}
			if (start == 0 && end == words[i].length()) {
				System.out.println("word start end = " + words[i] + " " + start + " " + end);
				if (largest.length() < words[i].length())
					largest = words[i];
			}
		}
		System.out.println(largest);

	}

	private static void mySol1(String[] words) {
		// This is not correct because "atestingtester" will not work with the
		// below code
		int max = 0;
		String l = null;
		for (int i = 0; i < words.length; i++) {
			int c = 0;
			for (int j = 0; j < words.length; j++) {
				if (j != i && words[i].contains(words[j])) {
					c++;
				}
			}
			if (c > 1) {
				l = words[i];
			}
		}
		System.out.println(l);
	}

}
