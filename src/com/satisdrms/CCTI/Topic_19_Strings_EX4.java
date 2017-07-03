package com.satisdrms.CCTI;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class Pair<V1, V2> {
	private V1 val1;
	private V2 val2;

	public Pair(V1 val1, V2 val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	public V1 getVal1() {
		return val1;
	}

	public V2 getVal2() {
		return val2;
	}

	public void setVal1(V1 val1) {
		this.val1 = val1;
	}

	public void setVal2(V2 val2) {
		this.val2 = val2;
	}

	@Override
	public int hashCode() {
		return val1.hashCode() ^ val1.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair<?, ?> pairo = (Pair<?, ?>) o;
		return this.val1.equals(pairo.getVal1())
				&& this.val2.equals(pairo.getVal2());
	}

}

public class Topic_19_Strings_EX4 {
	// Write a method to decide if two strings are anagrams or not.
	// a word, phrase, or name formed by rearranging the letters of another,
	// such as cinema, formed from iceman.

	public static void main(String[] args) {
//		String a = "cinemas", b = "icemans";
		String a = "abc", b = "cab";
		// mine_solution(a, b);
		book_solution_array(a, b);
		//book_solution_sort(a, b);
	}

	private static void book_solution_sort(String a, String b) {
		if (sort(a) == sort(b)) {
			System.out.println("These Strings are Anagrams");
		} else
			System.out.println("These Strings are not Anagrams");
	}

	private static String sort(String b) {
		//SORTING LOGIC NEEDS TO BE ADDED
		char[] c=b.toCharArray();
		return b;
		
	}

	private static void book_solution_array(String a, String b) {
		int[] letters = new int[256];
		int num_unique=0,num_completed=0;
		for(int i=0;i<a.length();i++){
			letters[a.charAt(i)]++;
			num_unique++;			
		}
		for(int i=0;i<b.length();i++){
			letters[b.charAt(i)]--;
			if(letters[b.charAt(i)]==0){
				num_completed++;
				if(num_completed==num_unique){
					//return i==b.length();
					if(i+1==b.length())
						System.out.println("This string is anagram");
					return;
				}
			}
		}
		//return false;
		System.out.println("This String is not anagram");
		
		/*for(int i=0;i<a.length();i++){
			System.out.println("Total count char of "+a.charAt(i)+" is "+letters[a.charAt(i)]);
		}*/
		
		
	}

	private static void mine_solution(String a, String b) {
		HashMap<String, Pair<Integer, Integer>> hm = new HashMap<String, Pair<Integer, Integer>>();
		if (a.length() != b.length()) {
			System.out.println("these strings are not anagrams");
		} else {
			for (int i = 0; i < a.length(); i++) {
				if (!hm.containsKey(Character.toString(a.charAt(i)))) {
					Pair<Integer, Integer> temp = new Pair<Integer, Integer>(1,
							0);
					hm.put(Character.toString(a.charAt(i)), temp);
				} else {
					Pair<Integer, Integer> temp = hm.get(Character.toString(a
							.charAt(i)));
					temp.setVal1(temp.getVal1() + 1);
					hm.put(Character.toString(a.charAt(i)), temp);
				}
				if (!hm.containsKey(Character.toString(b.charAt(i)))) {
					Pair<Integer, Integer> temp = new Pair<Integer, Integer>(0,
							1);
					hm.put(Character.toString(b.charAt(i)), temp);
				} else {
					Pair<Integer, Integer> temp = hm.get(Character.toString(b
							.charAt(i)));
					temp.setVal2(temp.getVal2() + 1);
					hm.put(Character.toString(b.charAt(i)), temp);
				}
			}
		}
		boolean anag_flag = true;
		Set<Entry<String, Pair<Integer, Integer>>> shm = hm.entrySet();
		for (Entry<String, Pair<Integer, Integer>> e : shm) {
			Pair<Integer, Integer> temp = e.getValue();
			System.out.println(e.getKey() + " " + temp.getVal1() + " "
					+ temp.getVal2());
			if (temp.getVal1() != temp.getVal2()) {
				anag_flag = false;
			}
		}
		if (anag_flag)
			System.out.println("This String is an Anagram");
		else
			System.out.println("This String is not an Anagram");
	}
}
