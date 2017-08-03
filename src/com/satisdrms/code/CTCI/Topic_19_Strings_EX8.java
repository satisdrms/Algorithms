package com.satisdrms.code.CTCI;

public class Topic_19_Strings_EX8 {
	// Assume you have a method isSubstring which checks if one word is a
	// substring of another. Given two strings, s1 and s2, write code to check
	// if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
	// “waterbottle” is a rotation of “erbottlewat”).

	public static void main(String[] args) {
		testSubString();
		String normalA = "waterbottle";
		String rotatedA = "erbottlewat";
		checkForRotation(normalA, rotatedA);
	}

	private static void checkForRotation(String normalA, String rotatedA) {
		boolean isSub = isSubString(normalA + normalA, rotatedA);
		if (isSub) {
			System.out.println(rotatedA+" is rotation of "+normalA);
		} else {
			System.out.println("Not a rotation");
		}
	}

	private static void testSubString() {
		String a = "waterbottle";
		String b = "waterbottle";
		boolean isSub = isSubString(a, b);
		if (isSub) {
			System.out.println(b + " is a substring");

		} else {
			System.out.println(b + " is not a substring");
		}
	}

	private static boolean isSubString(String main, String sub) {
		// Check if b is substring of a
		boolean isSub = false;
		for (int i = 0; i < main.length(); i++) {
			isSub = false;
			if (sub.length() > main.length() - i) {
				return isSub;
			}
			if (main.charAt(i) == sub.charAt(0)) {
				for (int j = 0, i1 = i; j < sub.length() && i1 < main.length(); j++, i1++) {
					if (main.charAt(i1) == sub.charAt(j)) {
						// System.out.println(a.charAt(i1));
						isSub = true;
					} else {
						isSub = false;
						break;
					}
				}
			}
			if (isSub) {
				return isSub;
			}
		}
		return isSub;
	}
}
