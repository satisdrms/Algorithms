package com.satisdrms.CTCI;

import java.lang.reflect.Array;

public class Topic_2_DynaResizeArray {

	public static void main(String[] args) throws NegativeArraySizeException, ClassNotFoundException {
		int[] intarr = new int[10];
		for (int i = 0, j = 9; i < intarr.length; i++) {
			intarr[i] = j;
			j++;
		}
		for (int i = 0; i < intarr.length; i++) {
			System.out.println(intarr[i]);
		}
		int newlength = 23;
		intarr = resizearray(intarr, newlength);
		Array.newInstance(Class.forName("String"),11);
	}

	private static int[] resizearray(int[] intarr, int newlength) {

		return intarr;
	}
}
