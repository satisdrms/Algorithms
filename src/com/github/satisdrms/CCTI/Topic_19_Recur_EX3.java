package com.github.satisdrms.CCTI;

import java.util.ArrayList;

//Write a method that returns all subsets of a set.

public class Topic_19_Recur_EX3 {

	public static void main(String[] args) {
		char[] set = { 'a', 'b', 'c','d' };
		ArrayList<String> subsets = new ArrayList<String>();
		findSubSet(set, subsets);
		subsets.add("-");
		for(String s:subsets){
			System.out.println(s);
		}
		

	}

	private static void findSubSet(char[] set, ArrayList<String> subsets) {
		//System.out.println(set.length);
		if(set.length==1){
			subsets.add(String.copyValueOf(set));
			return;
		}else {
			int slen=set.length-1;
			char[] recur=new char[slen];
			char[] lastChar={set[slen]};
			for(int i=0;i<slen;i++){
				recur[i]=set[i];
			}
			//System.out.println(String.copyValueOf(recur) +" lastchar "+lastChar);
			findSubSet(recur, subsets);
			//findSubSet(lastChar, subsets);
			ArrayList<String> temp = new ArrayList<String>();
			for(String s:subsets){
				temp.add(s+String.copyValueOf(lastChar));
			}
			subsets.add(String.copyValueOf(lastChar));
			subsets.addAll(temp);
		}
		
	}
}
