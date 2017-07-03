package com.satisdrms.CCTI;

public class Topic_19_Strings_EX3 {
	// Design an algorithm and write code to remove the duplicate characters in
	// a string without using any additional buffer. NOTE: One or two additional
	// variables are fine. An extra copy of the array is not.
	// FOLLOW UP
	// Write the test cases for this method.
	public static void main(String[] args) {
		// using_String();
		using_chararry();
	}

	private static void using_chararry() {
		char[] car = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 't', 'h','e',' ', 's', 'a', 'm', 'p', 'l', 'e', ' ', 'S', 't', 'r', 'i','n','g', ' ', 't', 'o', ' ', 't', 'e', 's', 't' };
		System.out.println(car);
		//char[] car = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'i' };
		int tail = 0, j;
		for (int i = 0; i < car.length; i++) {
	//		System.out.println("Start " + car[i]);
			for (j = 0; j < tail; j++) {
//				System.out.println(car[i] + " " + car[j]);
				if (car[i] == car[j]) {
					break;
				}
			}
		//	System.out.println(j);
			if (j == tail) {
				car[tail] = car[i];
				tail++;
			}

		//	System.out.println("end");
		}
		System.out.println(car);
		System.out.println(new String(car).substring(0, tail));

	}

	private static void using_String() {
		String str = "This is the sample String to test";
		String strnodup = "";
		for (int i = 0; i < str.length(); i++) {
			if (!strnodup.contains(Character.toString(str.charAt(i)))) {
				strnodup = strnodup + Character.toString(str.charAt(i));
			}
		}
		System.out.println(strnodup);
	}
}
