package com.github.satisdrms.CCTI;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//You have a large text file containing words. 
//Given any two words, find the shortest distance (in terms of number of words) between them in the file. 
//Can you make the searching operation in O(1) time? What about the space complexity for your solution?

class allWordsBook {
	HashMap<String, LinkedList<Integer>> words = new HashMap<String, LinkedList<Integer>>();

	public void addWord(String s, int pos) {
		if (words.containsKey(s)) {
			words.get(s).add(pos);
		} else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(pos);
			words.put(s, list);
		}
	}

	public void findDistance(String from, String to) {
		LinkedList<Integer> fromCol = words.get(from);
		LinkedList<Integer> toCol = words.get(to);
		int min = Math.abs(fromCol.get(0) - toCol.get(0)), start = 0, end = 0;
		for (Integer i : fromCol) {
			for (int j = 0; j < toCol.size(); j++) {
				min = Math.min(min, Math.abs(i - toCol.get(j)));
			}
		}
		System.out.println(min);
	}
}

class allWords {
	HashMap<String, wordDistance> all = new HashMap<String, wordDistance>();
	HashSet<String> allstr = new HashSet<String>();

	public void addWordDistance(String from, String to, int distance) {
		if (all.containsKey(from)) {
			all.get(from).addWord(to, distance);
		} else {
			wordDistance w = new wordDistance(from);
			w.addWord(to, distance);
			all.put(from, w);
		}
	}

	public int getDistance(String from, String to) {
		return all.get(from).getDistance(to);
	}
}

class wordDistance {
	String s;
	HashMap<String, Integer> words = new HashMap<String, Integer>();

	wordDistance(String s) {
		this.s = s;
	}

	public void addWord(String to, int distance) {
		if (words.containsKey(to)) {
			if (words.get(to) > distance)
				words.put(to, distance);
		} else
			words.put(to, distance);
	}

	public int getDistance(String to) {
		if (words.get(to) == null) {
			return -1;
		} else {
			return words.get(to);
		}
	}
}

class MyString {
	String s;

	MyString(String s) {
		this.s = s;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}

public class Topic_19_HARD_EX5 {

	public static void main(String[] args) {
		allWords w = new allWords();
		String[] file = { "a", "b", "c", "k", "l", "a", "s", "d", "k", "l",
				"v", "j", "r", "q", "v", "i", "w", "u", "f", "u", "q", "w",
				"h", "e", "c", "a", "s", "d", "j", "f", "q", "w", "i", "e",
				"f", "w", "	", "e", "j", "f", ";", "a", "s", "d", "l", "q",
				"w", "e", "j", "k", "d", "f", "s", "a", "d", "l", "k", "f",
				"h", "a", "l", "d", "f", "h", "q", "w", "l", ";", "e", "h",
				"c", "l", "z" };
		String from = "a", to = "k";

		Oof1Time(w, file, from, to);
		Oof1Time_bookSol(file, from, to);
		bookSolNormalTimeLinearSearch(file, from, to);
	}

	private static void Oof1Time_bookSol(String[] file, String from, String to) {
		allWordsBook w = new allWordsBook();
		for (int i = 0; i < file.length; i++) {
			w.addWord(file[i], i);
		}
		w.findDistance(from, to);
	}

	private static void bookSolNormalTimeLinearSearch(String[] file,
			String from, String to) {
		int distance = 0, min = file.length;
		boolean fromW = false, toW = false;
		for (int i = 0; i < file.length; i++) {
			if (file[i].equals(from) || fromW) {
				// System.out.println("fromW");
				fromW = true;
				if (toW) {
					min = Math.min(min, distance);
					distance = 0;
					toW = false;
				} else if (file[i].equals(from))
					distance = 0;
				else
					distance++;

			}
			if (file[i].equals(to) || toW) {
				// System.out.println("toW");
				toW = true;
				if (fromW) {
					min = Math.min(min, distance);
					distance = 0;
					fromW = false;
				} else if (file[i].equals(to))
					distance = 0;
				else
					distance++;
			}
		}
		System.out.println(min);

	}

	/**
	 * @param w
	 * @param file
	 * @param from
	 * @param to
	 */
	private static void Oof1Time(allWords w, String[] file, String from,
			String to) {
		for (int i = 0; i < file.length; i++) {
			for (int j = i + 1; j < file.length; j++) {
				// System.out.println(file[i] + " " + file[j]);
				w.addWordDistance(file[i], file[j], j - i);
			}
		}
		System.out.println(w.getDistance(from, to));
	}
}
