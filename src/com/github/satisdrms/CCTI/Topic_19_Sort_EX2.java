package com.github.satisdrms.CCTI;

import java.util.Arrays;
import java.util.Comparator;

//Write a method to sort an array of strings so that all the anagrams are next to each other.

public class Topic_19_Sort_EX2 {

	public static void main(String[] args) {

		String[] s = { "abcd", "acbd", "bcda", "calm", "data", "daat", "dogs",
				"dgos", "swat", "wast", "firs" };
		class sComparator implements Comparator<String>{
			public String sortString(String s1){
				char[] ar=s1.toCharArray();
				Arrays.sort(ar);
				return new String(ar);
			}
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				return sortString(s1).compareTo(sortString(s2));
			}			
		}
		Arrays.sort(s,new sComparator());
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
	}

}
