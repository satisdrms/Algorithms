package com.satisdrms.code.CTCI;

import java.util.LinkedList;

//Given an infinite number of quarters (25 cents), dimes (10 cents), 
//nickels (5 cents) and pennies (1 cent), write code to calculate the number of ways of representing n cents.

public class Topic_19_Recur_EX7 {

	public static void main(String[] args) {
		int nCents = 11;
		findCombiMySol1(nCents, 0, new LinkedList<Integer>());
		System.out.println(findCombiBookSol(nCents, 25));
		findCombiMySol2(nCents, 0, new LinkedList<Integer>());

	}

	private static void findCombiMySol2(int nCents, int i,
			LinkedList<Integer> curCents) {
		
	}

	private static int findCombiBookSol(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += findCombiBookSol(n - i * denom, next_denom);
		}
		return ways;
	}

	@SuppressWarnings("unchecked")
	// Still has Duplicates
	private static void findCombiMySol1(int nCents, int curCents,
			LinkedList<Integer> colls) {

		if (curCents < nCents) {
			if ((nCents - curCents) / 25 > 0) {
				LinkedList<Integer> curColls = (LinkedList<Integer>) colls
						.clone();
				curColls.add(25);
				findCombiMySol1(nCents, curCents + 25, curColls);
			}
			if ((nCents - curCents) / 10 > 0) {
				LinkedList<Integer> curColls = (LinkedList<Integer>) colls
						.clone();
				curColls.add(10);
				findCombiMySol1(nCents, curCents + 10, curColls);
			}
			if ((nCents - curCents) / 5 > 0) {
				LinkedList<Integer> curColls = (LinkedList<Integer>) colls
						.clone();
				curColls.add(5);
				findCombiMySol1(nCents, curCents + 5, curColls);
			}


			if ((nCents - curCents) / 1 > 0) {
				LinkedList<Integer> curColls = (LinkedList<Integer>) colls
						.clone();
				curColls.add(1);
				findCombiMySol1(nCents, curCents + 1, curColls);
			}

		} else {
			System.out.println("A Combination is");
			for (Integer i : colls) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
