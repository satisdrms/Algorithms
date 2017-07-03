package com.satisdrms.CCTI;

import java.util.Arrays;

public class Topic_19_Strings_EX5 {
	// Write a method to replace all spaces in a string with ‘%20’.
	public static void main(String[] args) {
		String a = "This is a sample String to work on ";

		// replaceSpaceWithPerc20_sol1(a);
		replaceSpaceWithPerc20_sol2(a);
		System.out.println(a.replace(" ","%20"));

	}

	private static void replaceSpaceWithPerc20_sol2(String a) {
		char[] cstr = a.toCharArray();
		int num_spaces = 0;
		for (int i = 0; i < cstr.length; i++) {
			if (cstr[i] == ' ') {
				num_spaces++;
			}
		}
		char[] new_cstr = new char[cstr.length + num_spaces * 2];
		for (int i = 0, new_i = 0; i < cstr.length; i++) {
			if (cstr[i] == ' ') {
				new_cstr[new_i++] = '%';
				new_cstr[new_i++] = '2';
				new_cstr[new_i++] = '0';
			} else
				new_cstr[new_i++] = cstr[i];
		}
		System.out.println(Arrays.toString(cstr) + " " + Arrays.toString(new_cstr));

	}

	private static void replaceSpaceWithPerc20_sol1(String a) {
		System.out.println("Replaced String is " + a.replaceAll(" ", "%20"));

	}

}
