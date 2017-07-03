package com.github.satisdrms.string_work;

public class String_palinderome {
	public static void main(String[] args) {
		System.out.println(check_palindrome("sathisfhsihtas"));
	}

	private static String check_palindrome(String string) {
		int length = string.length();
		int i = 0, len = length - 1;
		char[] str = string.toCharArray();
		for (; i < length; i++, len--) {
			if (str[i] != str[len]) {
				return "String " + string + " is not palindrome";
			}
		}
		return "String " + string + " is  palindrome";
	}
	
	// if (str == null)
    // return false;
	// StringBuilder strBuilder = new StringBuilder(str);
	// strBuilder.reverse();
	// return strBuilder.toString().equals(str);
}
