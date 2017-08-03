package com.satisdrms.code.CTCI;

import java.util.LinkedList;
import java.util.TreeSet;

//Design an algorithm to find the 
//kth number such that the only prime factors are 3, 5, and 7.
//3 5 7 9 15 21 25 27 35 45 49 63 75 81 105

public class Topic_19_Maths_EX7 {

	public static void main(String[] args) {
		// bookSol1();
		bookSol2();
	}

	private static void bookSol2() {
		int a = 3, b = 5, c = 7;
		int k = 15;
		int min = 1, next = 1;
		int i = 0;
		TreeSet<Integer> srt = new TreeSet<Integer>();
		TreeSet<Integer> n = new TreeSet<Integer>();
		srt.add(min);
		while (i < k) {
			n = new TreeSet<Integer>();
			for (Integer in : srt) {

				int q3 = in * 3;
				int q5 = in * 5;
				int q7 = in * 7;
				// n = new TreeSet<Integer>();
				if (q3 > next)
					n.add(q3);
				if (q5 > next)
					n.add(q5);
				if (q7 > next)
					n.add(q7);
			}
			System.out.println(n.first());
			next = n.first();
			srt.add(n.first());

			i++;
		}
	}

	private static void bookSol1() {
		int a = 3, b = 5, c = 7;
		int k = 15;
		LinkedList<Integer> q3 = new LinkedList<Integer>();
		LinkedList<Integer> q5 = new LinkedList<Integer>();
		LinkedList<Integer> q7 = new LinkedList<Integer>();
		int i = 0, min = 0, channel = 0;
		q3.add(3);
		q5.add(5);
		q7.add(7);
		while (i < k) {
			// System.out.println(q3.peek()+" "+q5.peek()+" "+q7.peek());
			if (q3.peek() < q5.peek())
				if (q3.peek() < q7.peek()) {
					{
						min = q3.pop();
						channel = 3;
					}
				} else {
					min = q7.pop();
					channel = 7;
				}
			else if (q5.peek() < q7.peek()) {
				min = q5.pop();
				channel = 5;
			} else {
				min = q7.pop();
				channel = 7;
			}
			switch (channel) {
			case 3:
				q3.add(min * 3);
			case 5:
				q5.add(min * 5);
			case 7:
				q7.add(min * 7);
			}
			System.out.println(min);
			i++;
		}
	}

}
