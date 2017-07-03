package com.satisdrms.CCTI;

import java.util.LinkedList;

//Given two words of equal length that are in a dictionary, 

//write a method to transform one word into another word by changing only one letter at a time. 
//The new word you get in each step must be in the dictionary.

//EXAMPLE
//Input: DAMP, LIKE
//Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE


// BOOK SOLUTION IS ALMOST SAME AS MY SECOND LOGIC >> AND THE BACKTRACKING IS ONLY APPLIED FOR THE CASE TO FIND THE PATH OF THE MATCHING STRING

class wordNode {
	private String s;
	private LinkedList<wordNode> adj;
	private boolean visited;

	public String getWord() {
		return s;
	}

	public void setWord(String s) {
		this.s = s;
	}

	public LinkedList<wordNode> getAdj() {
		return adj;
	}

	public void setAdj(LinkedList<wordNode> adj) {
		this.adj = adj;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	wordNode(String s) {
		this.s = s;
		adj = new LinkedList<wordNode>();
		visited = false;
	}

	public void addAdj(wordNode n) {
		boolean exists = false;
		for (wordNode a : adj) {
			if (n.getWord().equals(a.getWord())) {
				exists = true;
				break;
			}
		}
		if (!exists)
			adj.add(n);

	}
}

class dict {
	LinkedList<wordNode> allWords;
	wordNode root;

	dict() {
		allWords = new LinkedList<wordNode>();
		root = null;
	}

	void addWord(String s, String n) {
		wordNode w = getNode(s);
		if (w == null) {
			w = new wordNode(s);
			allWords.add(w);
		}
		wordNode adj = getNode(n);
		if (adj == null) {
			adj = new wordNode(n);
			allWords.add(adj);
		}
		w.addAdj(adj);
	}

	private wordNode getNode(String s) {
		for (wordNode w : allWords) {
			if (w.getWord().equals(s)) {
				return w;
			}
		}
		return null;
	}

	void printAll() {
		for (wordNode w : allWords) {
			System.out.println("Word is " + w.getWord()
					+ " and below are the adjacents");
			for (wordNode n : w.getAdj()) {
				System.out.println(n.getWord());
			}
		}
	}

	public void findPath(String in, String out) {
		System.out.println("Finding the path");
		wordNode first = getNode(in);
		wordNode last = getNode(out);
		if (first == null || last == null) {
			return;
		}
		LinkedList<wordNode> queue = new LinkedList<wordNode>();
		queue.add(first);
		System.out.println(first.getWord());

		while (queue.size() > 0) {
			wordNode process = queue.removeLast();
			// wordNode process = queue.removeFirst();
			process.setVisited(true);
			for (wordNode w1 : process.getAdj()) {
				if (!w1.isVisited()) {
					System.out.println(w1.getWord());
					queue.addFirst(w1);
					if (w1.getWord().equals(out)) {
						System.out.println("FOUND!!!!");
						return;
					}
				}
			}
		}
	}

	public void addWordAndFindPath(String[] dictArray, String in, String out) {
		LinkedList<wordNode> queue = new LinkedList<wordNode>();

		wordNode first = new wordNode(in);
		allWords.add(first);
		queue.add(first);
		while (queue.size() > 0) {
			wordNode process = queue.removeLast();
			process.setVisited(true);
			System.out.println(process.getWord());
			for (int i = 0; i < dictArray.length; i++) {
				if (!process.getWord().equals(dictArray[i])
						&& oneCharDiff(process.getWord(), dictArray[i])) {
					addWord(process.getWord(), dictArray[i]);
					wordNode search = getNode(dictArray[i]);
					if (!search.isVisited()) {
						queue.addFirst(search);
						if (search.getWord().equals(out)) {
							System.out.println(search.getWord());
							System.out.println("FOUND!!!");
							return;
						}
					}
				}
			}
		}
	}

	private boolean oneCharDiff(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else {
			int mismatch = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					mismatch++;
			}
			if (mismatch == 1) {
				return true;
			}
		}
		return false;
	}

}

public class Topic_19_HARD_EX10 {

	public static void main(String[] args) {
		String[] dictArray = { "DAMP", "LAMP", "LIMP", "LIME", "LIKE", "DARK",
				"LIME", "DIME", "MARK", "YIKE", "BIME", "PARK", "RAMP", "DATAA"/*
																				 * DATAA
																				 * WILL
																				 * BE
																				 * IGNORED
																				 * AS
																				 * IT
																				 * IS
																				 * MORE
																				 * THAN
																				 * 4
																				 * CHARACTERS
																				 */};
		String in = "DAMP";
		String out = "LIKE";
		buildGraphAndSearch(dictArray, in, out);
		buildGraphSearchAndBuildNextWords(dictArray, in, out);

	}

	private static void buildGraphSearchAndBuildNextWords(String[] dictArray,
			String in, String out) {
		dict d = new dict();
		d.addWordAndFindPath(dictArray, in, out);

	}

	/**
	 * @param dictArray
	 * @param in
	 * @param out
	 */
	private static void buildGraphAndSearch(String[] dictArray, String in,
			String out) {
		dict d = new dict();
		for (int i = 0; i < dictArray.length; i++)
			for (int j = 0; j < dictArray.length; j++) {
				if (i != j && oneCharDiff(dictArray[i], dictArray[j])) {
					d.addWord(dictArray[i], dictArray[j]);
				}
			}
		d.printAll();
		d.findPath(in, out);
	}

	private static boolean oneCharDiff(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		else {
			int mismatch = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (s1.charAt(i) != s2.charAt(i))
					mismatch++;
			}
			if (mismatch == 1) {
				return true;
			}
		}
		return false;
	}
}
