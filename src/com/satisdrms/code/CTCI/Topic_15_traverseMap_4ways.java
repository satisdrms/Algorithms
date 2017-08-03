package com.satisdrms.code.CTCI;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Topic_15_traverseMap_4ways {

	public static void main(String[] args) {
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		h.put(1, "techno");
		h.put(2, "alizat");
		h.put(3, "boomeric");
		h.put(4, "trickloax");
		h.put(5, "posumered");

		// ONE
		System.out.println("----------------1");
		Set<Integer> hm = h.keySet();
		for (Integer i : hm) {
			System.out.println(h.get(i));
		}

		// TWO
		System.out.println("----------------2");
		Set<Entry<Integer, String>> shm = h.entrySet();
		for (Entry<Integer, String> ehm : shm) {
			System.out.println(ehm.getValue() + " " + ehm.getKey());
		}

		// THREE
		System.out.println("----------------3");
		Set<Integer> hm1 = h.keySet();
		Iterator<Integer> ihm = hm1.iterator();
		while (ihm.hasNext()) {
			System.out.println(h.get(ihm.next()));
		}

		// FOUR
		System.out.println("----------------4");
		Set<Entry<Integer, String>> shm1 = h.entrySet();
		Iterator<Entry<Integer, String>> ihm1 = shm1.iterator();
		while (ihm1.hasNext()) {
			System.out.println(ihm1.next().getValue());
		}

	}

}
