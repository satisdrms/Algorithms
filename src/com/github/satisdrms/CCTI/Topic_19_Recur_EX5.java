package com.github.satisdrms.CCTI;

//Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
//EXAMPLE:
//input: 3 (e.g., 3 pairs of parentheses)
//output: ()()(), ()(()), (())(), ((()))

public class Topic_19_Recur_EX5 {

	public static void main(String[] args) {
		int n = 4;// parensPair
		String s = new String();
		formParenCombi(n, n, s, 0);

	}

	private static void formParenCombi(int l, int r, String s, int count) {
		if (r < l) {
			return;
		} else if (l == 0 && r == 0) {
			System.out.println(s);
			return;
		} else {
			if (l > 0) {
				formParenCombi(l - 1, r, s + "(", count + 1);
			}
			if (r > 0) {
				formParenCombi(l, r - 1, s + ")", count + 1);
			}
		}

	}
}
