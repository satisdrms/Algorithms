package com.satisdrms.CCTI;

public class Topic_19_Strings_EX2 {
	// Write code to reverse a C-Style String. (C-String means that “abcd” is
	// represented as five characters, including the null character.)
	public static void main(String[] args) {
		char[] a={'a','b','c','d','e'};
		System.out.println(a);
		int len=a.length;
		//System.out.println(len);
		for(int i=len-1;i>=0;i--){
			System.out.println(a[i]);
		}

	}

}
