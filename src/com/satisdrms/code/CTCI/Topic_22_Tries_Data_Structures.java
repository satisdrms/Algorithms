package com.satisdrms.code.CTCI;

import java.util.HashMap;
import java.util.Set;

class trie {
	Character val;
	HashMap<Character, trie> children = new HashMap<Character, trie>();
	boolean isend = false;

	trie(Character chr) {
		this.val = chr;
	}

	public Character getVal() {
		return val;
	}

	public void setVal(Character val) {
		this.val = val;
	}

	public HashMap<Character, trie> getChildren() {
		return children;
	}

	public void addChildren(Character ch) {
		children.put(ch, new trie(ch));
	}

	public boolean isIsend() {
		return isend;
	}

	public void setIsend(boolean isend) {
		this.isend = isend;
	}
}

class processTrie {
	trie root = new trie('0');;

	public void insert(String s) {
		root = insert(s, root);
	}

	private trie insert(String s, trie node) {
		int len = s.length();
		trie crawl = root;
		trie temp = null;
		for (int i = 0; i < len; i++) {
			Character new_ch = s.charAt(i);
			HashMap<Character, trie> children = crawl.getChildren();
			if (children.containsKey(new_ch)) {
				crawl = children.get(new_ch);
			} else {
				trie nnode = new trie(new_ch);
				if (i == len - 1) {
					nnode.setIsend(true);
				}
				children.put(new_ch, nnode);
				// crawl.setIsend(false);
				crawl = nnode;
			}
		}

		return node;
	}

	public void display_trie_tree() {
		System.out.println(root.getVal() + " is Root");
		display_trie_tree(root, root.getVal() + " is Root");
	}

	private void display_trie_tree(trie node, String flag) {
		System.out.println("node(end is " + node.isIsend() + ") " + node.getVal() + " is child of " + flag);
		String new_flg = node.getVal() + " and " + flag;
		HashMap<Character, trie> children = node.getChildren();
		Set<Character> ch = children.keySet();
		for (Character c : ch) {
			display_trie_tree(children.get(c), new_flg);
		}

	}

	public String findLongestPrefix(String s) {
		return findLongestPrefix(s, root);
	}

	public String findLongestPrefix(String s, trie node) {
		String lon = "";
		int len = s.length();
		trie crawl = node;
		int prevmatch = 0;
		for (int i = 0; i < len; i++) {
			HashMap<Character, trie> children = crawl.getChildren();
			if (children.containsKey(s.charAt(i))) {
				lon = lon + s.charAt(i);
				crawl = children.get(s.charAt(i));
				if (crawl.isend){
					prevmatch = i;
					System.out.println(s.charAt(i)+" flag set and prev is "+prevmatch);

				}
				System.out.println(s.charAt(i));
			} else {
				break;
			}
			;
		}
		System.out.println("prev is "+prevmatch);

		return s.substring(0,prevmatch+1);
	}

}

public class Topic_22_Tries_Data_Structures {

	public static void main(String[] args) {
		processTrie p = new processTrie();

		p.insert("home");
		p.insert("hordy");
		p.insert("hometown");
		p.insert("cater");
		p.insert("caterer");
		p.insert("caterers");
		checkPrefix(p, "caterers");

		p.display_trie_tree();

	}

	private static void checkPrefix(processTrie p, String s) {
		System.out.println("Check for prefix for String " + s + " is " + p.findLongestPrefix(s));

	}

}
