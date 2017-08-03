package com.satisdrms.code.stringProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		String per = "Sathish";
		Set<String> perm=findperm(per);
		Hashtable<String,String> unistr=new Hashtable<String, String>();
		for(String s:perm){
			unistr.put(s.toLowerCase(), s);
		}
		System.out.println(unistr.get("sathish"));
		int count=0;
		for(String s:unistr.keySet()){
			count++;
			System.out.println(s+" "+count);
		}
	}

	private static Set<String> findperm(String per) {
		Set<String> allperms = new HashSet<String>();
		if (per == null) {
			return null;
		} else if (per.length() == 0) {
			allperms.add("");
			return allperms;
		}
		char init = per.charAt(0);
		String per1 = per.substring(1);

		System.out.println(per1);// /FLAG

		Set<String> subperm = findperm(per1);

		for (String s : subperm) {
			for (int i = 0; i <= s.length(); i++) {
				allperms.add(insertchar(init, s, i));
			}
		}
		return allperms;
	}

	private static String insertchar(char init, String s, int i) {
		String begin = s.substring(0, i);
		String end = s.substring(i);
		return begin + init + end;
	}

}
