package com.satisdrms.code.CTCI;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.AbstractMap.*;

public class Topic_1_Hashtables {
	@SuppressWarnings("unchecked")
	public static LinkedList<Entry<Integer, String>>[] ht = new LinkedList[12];

	public static void main(String[] args) {
		// List<Integer> ht1 = new ArrayList<Integer>();
		// List<Entry<Integer, String>> v = new LinkedList<Entry<Integer,
		// String>>();

		// IMPLEMENTING ALL
		add(1, "sa");
		showall();

		// USING PACKAGES FOR HASHTABLES
		Hashtable<Integer, String> htapi = new Hashtable<Integer, String>();
		htapi.put(2, "dsa");
		htapi.put(2, "dsaw");
		Set<Integer> hashtableKeys = htapi.keySet();
		for (Integer a : hashtableKeys) {
			System.out.println(a);
		}
		System.out.println(htapi.get(2));
	}

	private static void showall() {
		// System.out.println(ht.length);
		for (int i = 0; i < ht.length; i++) {
			if (ht[i] != null) {

				for (Entry<Integer, String> e : ht[i]) {
					System.out.println(e.getKey() + "----" + e.getValue());
				}
			}
		}
	}

	private static void add(int key, String val) {
		int hash = returnhash(key);
		if (ht[hash] == null) {
			ht[hash] = new LinkedList<Entry<Integer, String>>();
		}
		// System.out.println(ht[hash].getClass().getName());
		for (Entry<Integer, String> e : ht[hash]) {
			System.out.println(e.getKey() + "--" + e.getValue());
			if (e.getKey() == key) {
				e.setValue(val);
			}
			return;
		}
		Entry<Integer, String> entry = new SimpleEntry<Integer, String>(key,
				val);

		ht[hash].add(entry);
		ht[9].get(1);
	}

	private static int returnhash(int i) {
		return i % 12;

	}
}
