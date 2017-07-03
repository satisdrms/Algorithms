package com.satisdrms.CCTI;

public class Topic_19_Strings_EX1 {

	// Implement an algorithm to determine if a string has all unique
	// characters. What if you can not use additional data structures?
	public static void main(String[] args) {
		// String ex1 = "This is a sample sentence to test this problem", ex3 =
		// "";
		String ex1 = "abcdefghiin", ex3 = "";
		boolean dup_flag = false;
		// mine_dup_check(ex1, ex3, dup_flag);
		dup_flag=book_dup_check(ex1, dup_flag);
		System.out.println(dup_flag);
		// other_dup_check(ex1, dup_flag);
	}

	private static void other_dup_check(String ex1, boolean dup_flag) {
		char[] carr = ex1.toCharArray();
		for (int i = 0; i < carr.length; i++) {
			if (ex1.indexOf(carr[i]) != ex1.lastIndexOf(carr[i])) {
				dup_flag = true;
			} else {
				dup_flag = false;
			}
		}
		if (dup_flag) {
			System.out.println("Contains duplicates");
		} else {
			System.out.println("Contains no duplicates");

		}
	}

	private static boolean book_dup_check(String ex1, boolean dup_flag) {
		int checker = 0;
		for (int i = 0; i < ex1.length(); i++) {
			int val = ex1.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				System.out.println("Has duplicates");
				return false;
			}
			checker = checker | (1 << val);
		}
		return true;

	}

	private static void mine_dup_check(String ex1, String ex3, boolean dup_flag) {
		for (int i = 0; i < ex1.length(); i++) {

			if (ex3.contains("" + ex1.charAt(i))) {
				// System.out.println("This String has duplicates such as "+ex1.charAt(i));
				dup_flag = true;
				break;
			} else {
				ex3 = ex3 + ex1.charAt(i);
			}
		}
		if (dup_flag) {
			System.out.println("Contains duplicates");
		} else {
			System.out.println("Contains no duplicates");

		}
	}
}
