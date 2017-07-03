package com.satisdrms.CCTI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Topic_16_Duplicates_in_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		// a.add(2);
		// a.add(2);
		// a.add(2);
		a.add(4);
		a.add(5);
		a.add(4);
		a.add(1);
		// -----------------------------------
		Hashtable<Integer, Integer> dht = new Hashtable<Integer, Integer>();
		for (Integer i : a) {
			if (dht.containsKey(i)) {
				dht.put(i, dht.get(i) + 1);
				// CONTAINS IS SAME AS CONTAINS VALUE
				System.out.println("in if " + dht.contains(i) + "");
			} else {
				dht.put(i, 1);
				System.out.println("in else");
			}
		}
		Set<Integer> sht = dht.keySet();
		for (Integer i : sht) {
			if (dht.get(i) > 1) {
				System.out.println(i + " has " + dht.get(i) + " duplicates");
			}
		}
		// -----------------------------------
		Iterator<Integer> itr = a.iterator();
		Set<Integer> sht2 = new HashSet<Integer>();

		while (itr.hasNext()) {
			int i = itr.next();
			System.out.println(i);
			if (sht2.contains(i)) {
				System.out.println("The List contains duplicates such as " + i);
				break;
			} else
				sht2.add(i);
		}
		// -----------------------------------
		int size = 4321;
		a.ensureCapacity(size);
		System.out.println(a.size());

		for (int i = 1; i < 12; i++)
			a.add(i);

		System.out.println(a.size());

		a.ensureCapacity(size);
		while (a.size() < size) {
			a.add(null);
		}
		System.out.println(a.size());
		// -----------------------------------
		System.out.println("Starting 4");
		HashSet<Integer> shs = new HashSet<Integer>(a);
		if (a.size() > shs.size()) {
			System.out.println("ArrayList has duplicates");
		} else
			System.out.println("ArrayList has no duplicates");

		for (Integer i : shs)
			System.out.println(i);
		// -----------------------------------
		/*
		 * int j = 0; while(j<size){ System.out.println(size); j++; }
		 */

	}
}
