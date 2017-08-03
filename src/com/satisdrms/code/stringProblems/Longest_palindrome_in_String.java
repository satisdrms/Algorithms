package com.satisdrms.code.stringProblems;

public class Longest_palindrome_in_String {
	public static String lpalin="";

	public static void main(String[] args) throws InterruptedException {
		String str = "111111113111111331111111311111111111rgr1111111111satsishffhssathissihtas";
		for (int wc = 2; wc <= str.length(); wc++) {
			findwords(wc, str);
		}
		System.out.println(lpalin);
	}

	private static void findwords(int c, String str) throws InterruptedException {
		for (int i = 0; i+c <= str.length(); i++) {
			//System.out.println(ispalindrome(str.substring(i, i + c)));
			ispalindrome(str.substring(i, i + c));
            //Thread.sleep(1000);

		}

	}

	private static String ispalindrome(String string) {
		int length = string.length();
		int i = 0, len = length - 1;
		char[] str = string.toCharArray();
		for (; i < length; i++, len--) {
			if (str[i] != str[len]) {
				return "String " + string + " is not palindrome";
			}
		}
		if (lpalin.length()<string.length()){
			lpalin=string;
		}
		return "String " + string + " is  palindrome";

		
	}

}
