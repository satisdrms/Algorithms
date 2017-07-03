package com.satisdrms.CCTI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

//Given a dictionary of millions of words, give an algorithm to find the largest possible rectangle of letters such that every row forms a word (reading left to right) 
//and every column forms a word (reading top to bottom).

class TrieNode {
	Character chr;
	HashSet<TrieNode> leaves/* hildren */;
	boolean isEnd;

	TrieNode(Character d) {
		this.chr = d;
		leaves = new HashSet<TrieNode>();
		isEnd = false;
	}

	public HashSet<TrieNode> getLeaves() {
		return leaves;
	}

	public void setLeaves(HashSet<TrieNode> c) {
		this.leaves = c;
	}

	public Character getChr() {
		return chr;
	}

	public void setChr(Character d) {
		this.chr = d;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public TrieNode getNode(Character next) {
		for (TrieNode check : leaves) {
			if (check.getChr().equals(next))
				return check;
		}
		return null;
	}

	public void addChild(TrieNode child) {
		leaves.add(child);
	}

	public boolean containsChar(char check) {
		for (TrieNode n : leaves) {
			if (n.getChr().equals(check)) {
				return true;
			}
		}
		return false;
	}
}

class Trie1 {
	TrieNode root = new TrieNode(' ');
	HashMap<Character, Character> alphabets = new HashMap<Character, Character>();

	Trie1() {
		// init alpabets
		for (int i = 'a'; i <= 'z'; i++) {
			alphabets.put((char) i, (char) i);
		}
	}

	public void addWordToTrie(String s) {
		TrieNode node = root;
		for (char c : s.toLowerCase().toCharArray()) {
			TrieNode child = node.getNode(c);
			if (child != null)
				node = child;
			else {
				// child = new TrieNode(alphabets.get(c));
				child = new TrieNode(c);
				node.addChild(child);
				node = child;
			}
		}
		node.setEnd(true);
	}

	public void printAll() {
		printAll(root, 1);
	}

	private void printAll(TrieNode node, int i) {
		for (TrieNode c : node.getLeaves()) {
			System.out.println(c.getChr() + " at level " + i + " and is end "
					+ c.isEnd);
			printAll(c, i + 1);
		}
	}

	public int existsinTrie(StringBuilder str) {
		return existsinTrie(root, str);

	}

	private int existsinTrie(TrieNode node, StringBuilder str) {
		if (str.length() == 0 && node.isEnd)
			return 1;
		else if (str.length() == 0)
			return 0;
		else {
			TrieNode hier = node.getNode(str.charAt(0));
			if (hier != null) {
				return existsinTrie(hier, new StringBuilder(str.substring(1)));
			}
		}
		return -1;
	}

	public boolean checkColumnsExistsinTrie(ArrayList<String> rect) {
		return checkColumnsExistsinTrie(root, rect);

	}

	private boolean checkColumnsExistsinTrie(TrieNode node,
			ArrayList<String> rect) {
		int end = 0;
		int len = rect.get(0).length();
		for (int j = 0; j < len; j++) {
			TrieNode hier = node;
			for (int i = 0; i < rect.size(); i++) {
				hier = hier.getNode(rect.get(i).charAt(j));
				if (hier != null) {
					if (i == rect.size() - 1 && hier.isEnd)
						end = end + 1;
				} else
					return false;
			}
		}
		if (len == end) {
			System.out.println(Calendar.getInstance().getTime());
			printCol(rect);
			// slp(5000);

		}
		return true;
	}

	private void printCol(ArrayList<String> c) {
		System.out.println("------------ A Rectangle is ");
		for (String s : c) {
			System.out.println(s);
		}

	}

	@SuppressWarnings("unused")
	private void slp(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class wordThread extends Thread {
	static AtomicInteger count = new AtomicInteger(0);
	ArrayList<String> temp;
	Trie1 dictTrie;
	ArrayList<String> rect;
	HashMap<Integer, ArrayList<String>> wordsbySize;
	int maxlength;

	wordThread(ArrayList<String> temp, Trie1 dictTrie, ArrayList<String> rect,
			HashMap<Integer, ArrayList<String>> wordsbySize, int maxlength) {
		this.temp = temp;
		this.dictTrie = dictTrie;
		this.rect = rect;
		this.wordsbySize = wordsbySize;
		this.maxlength = maxlength;
	}

	public void run() {
		checkWords(temp, dictTrie, rect, wordsbySize, maxlength);
		count.incrementAndGet();
	}

	@SuppressWarnings("unchecked")
	private void checkWords(ArrayList<String> temp, Trie1 dictTrie,
			ArrayList<String> rect,
			HashMap<Integer, ArrayList<String>> wordsbySize, int maxlength) {
		if (rect.size() + 1 <= maxlength) {
			for (int i = 0; i < temp.size(); i++) {
				ArrayList<String> newrect = (ArrayList<String>) rect.clone();
				newrect.add(temp.get(i));
				// printCol(newrect);
				if (dictTrie.checkColumnsExistsinTrie(newrect))
					checkWords(temp, dictTrie, newrect, wordsbySize, maxlength);
			}
		}
		// System.out.println("END");
	}

	@SuppressWarnings("unused")
	private void printCol(ArrayList<String> c) {
		System.out.println("------------ A Rectangle is ");
		for (String s : c) {
			System.out.println(s);
		}

	}

}

public class Topic_19_HARD_EX13 {
	static Date starttime = Calendar.getInstance().getTime();

	public static void main(String[] args) throws FileNotFoundException {
		// mySol1_SolCorrect_UnderstoodRequirementWrong();

		System.out.println(starttime);
		// wordThread a = new wordThread(1);
		// a.start();
		mySol2();
	}

	/**
	 * @throws FileNotFoundException
	 */
	private static void mySol2() throws FileNotFoundException {
		// ArrayList<String> dict = loadDictMan();
		ArrayList<String> dict = loadDict();
		Trie1 dictTrie = new Trie1();
		HashMap<Integer, ArrayList<String>> wordsbySize = new HashMap<Integer, ArrayList<String>>();
		int maxlength = 0;
		for (String s : dict) {
			dictTrie.addWordToTrie(s);
			int len = s.length();
			if (wordsbySize.containsKey(len)) {
				wordsbySize.get(len).add(s);
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(s);
				wordsbySize.put(len, temp);
			}
		}
		for (Integer i : wordsbySize.keySet()) {
			maxlength = Math.max(i, maxlength);
			System.out.println(i);
		}
		int wordsC = 0;
		for (int i = maxlength-15; i > 0; i--) {
			if (wordsbySize.containsKey(i)) {
				ArrayList<String> temp = wordsbySize.get(i);

				for (String s : temp) {
					wordsC++;
					sleepThreadsGreaterThan1000(wordsC, 10000);

					ArrayList<String> rect = new ArrayList<String>();
					rect.add(s);
					wordThread a = new wordThread(temp, dictTrie, rect,wordsbySize, maxlength);
					a.start();
					// System.out.println("Checking for start word " + s);
					// ArrayList<String> rect = new ArrayList<String>();
					// rect.add(s);
					// checkWords(temp, dictTrie, rect, wordsbySize, maxlength);
				}
			}
		}

		// dictTrie.printAll();

	}

	/**
	 * @param wordsC
	 */
	private static void sleepThreadsGreaterThan1000(int wordsC, int threadCount) {
		while (wordsC - wordThread.count.get() > threadCount) {
			System.out.println(wordThread.count.get() + " threads out of "
					+ wordsC + " threads pending");
			slp(5000);
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static void checkWords(ArrayList<String> temp, Trie1 dictTrie,
			ArrayList<String> rect,
			HashMap<Integer, ArrayList<String>> wordsbySize, int maxlength) {
		if (rect.size() + 1 <= maxlength) {
			for (int i = 0; i < temp.size(); i++) {
				ArrayList<String> newrect = (ArrayList<String>) rect.clone();
				newrect.add(temp.get(i));

				// printCol(newrect);
				// slp(5000);
				if (dictTrie.checkColumnsExistsinTrie(newrect))
					checkWords(temp, dictTrie, newrect, wordsbySize, maxlength);
			}
		}
	}

	@SuppressWarnings("unused")
	private static boolean checkColumnsExistsinTrie(Trie1 dictTrie,
			ArrayList<String> rect) {
		int end = 0;
		int len = rect.get(0).length();
		for (int j = 0; j < len; j++) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < rect.size(); i++) {
				str.append(rect.get(i).charAt(j));
			}
			int wend = dictTrie.existsinTrie(str);

			if (wend == -1) {
				return false;
			} else {
				end = end + wend;
			}
		}
		if (len == end) {
			System.out.println(Calendar.getInstance().getTime());
			printCol(rect);
			slp(5000);

		}
		return true;
	}

	/**
	 * @param n
	 */
	private static void slp(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static boolean checkColumnsExistsasWord(ArrayList<String> rect,
			HashMap<Integer, ArrayList<String>> wordsbySize) {
		if (wordsbySize.containsKey(rect.size())) {
			// System.out.println("col is " + rect.size());

			ArrayList<String> wSize = wordsbySize.get(rect.size());

			// System.out.println(wSize.size());

			for (int j = 0; j < rect.get(0).length(); j++) {
				StringBuilder str = new StringBuilder();
				for (int i = 0; i < rect.size(); i++) {
					str.append(rect.get(i).charAt(j));
				}
				// System.out.println(str + "-");
				// printCol(wSize);
				// System.out.println(wSize.size());
				if (!wSize.contains(str.toString())) {
					// printCol(wSize);
					// System.out.println("false");
					return false;
				}
			}
		} else
			return false;
		return true;
	}

	private static void printCol(ArrayList<String> c) {
		System.out.println("------------ A Rectangle is ");
		for (String s : c) {
			System.out.println(s);
		}

	}

	@SuppressWarnings("unused")
	private static ArrayList<String> loadDictMan() {
		ArrayList<String> sample = new ArrayList<String>();
		sample.add("sathi");
		sample.add("subra");
		sample.add("subrd");
		sample.add("Datar");
		sample.add("zooto");
		sample.add("tea");
		sample.add("ate");

		sample.add("eat");
		sample.add("zorio");
		return sample;
	}

	private static ArrayList<String> loadDict() throws FileNotFoundException {
		Scanner s = new Scanner(new File(
				"src/pack1/Topic_19_HARD_EX13_dictionaryWords"));
		// FIRST MATCH OF THE ABOVE DICTIONARY
		// onomatopoetically
		// nonuniformitarian
		// Scanner s = new Scanner(new
		// File("src/pack1/Topic_19_HARD_EX13_dictionaryWords1.TXT"));
		ArrayList<String> str = new ArrayList<String>();
		while (s.hasNext()) {
			str.add(s.next().toLowerCase());
		}
		s.close();
		return str;
	}

	/**
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unused")
	private static void mySol1_SolCorrect_UnderstoodRequirementWrong()
			throws FileNotFoundException {

		ArrayList<String> dict = loadDict();

		HashMap<String, ArrayList<String>> wordRotations = new HashMap<String, ArrayList<String>>();
		for (String s : dict) {
			char[] key = s.toCharArray();
			Arrays.sort(key);
			String str = new String(key);
			if (!wordRotations.containsKey(str)) {
				ArrayList<String> words = new ArrayList<String>();
				if (!words.contains(s))
					words.add(s);
				wordRotations.put(str, words);
			} else {
				ArrayList<String> wordList = wordRotations.get(str);
				if (!wordList.contains(s))
					wordList.add(s);

			}
		}
		int i = 0;
		for (String s : wordRotations.keySet()) {
			ArrayList<String> wordList = wordRotations.get(s);
			if (s.length() <= wordList.size()) {

				for (String s1 : wordList) {
					// FIND WORDS WHERE THERE ARE WORDS MORE THAN THE LENGHT OF
					// KEY IN ROTATIONS
					// DISCONTINUING THIS AS THE REQUIREMENT wAS TO FIND
					// RECTANGLE NOT SQUARE
					// ALSO THE RECTANGLE DOESNT NEED TO CONTAIN THE WORD
					// ROTATIONS
					// IT CAN BE ANY WORDS
				}
			}
		}
	}

}
