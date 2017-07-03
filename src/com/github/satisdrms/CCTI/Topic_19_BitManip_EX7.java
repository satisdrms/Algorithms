package com.github.satisdrms.CCTI;

import java.util.ArrayList;

//An array A[1... n] contains all the integers from 0 to n except for one number which is missing. 
//In this problem, we cannot access an entire integer in A with a single operation. 
//The elements of A are represented in binary, and the only operation we can use to access them is “fetch the jth bit of A[i]”, which takes constant time. 
//Write code to find the missing integer. Can you do it in O(n) time?

public class Topic_19_BitManip_EX7 {

	public static void main(String[] args) {
		String[] A = { "000", "001", "010", "100", "101", "110", "111" };
		// "011"
		int missing = findMissing(A);
		// System.out.println(Integer.toBinaryString(missing));
		ArrayList<String> bin = new ArrayList<String>();
		// System.out.println(A[4].charAt(0));
		for (int i = 0; i < A.length; i++)
			bin.add(A[i]);
		int missingBook = findMissingBookSol(bin, bin.get(0).length() - 1);
		System.out.println(Integer.toBinaryString(missingBook));
	}

	private static int findMissingBookSol(ArrayList<String> bin, int pos) {
		if (pos < 0)
			return 0;
		ArrayList<String> odd = new ArrayList<String>();
		ArrayList<String> even = new ArrayList<String>();
		for (String str : bin) {
			if (str.charAt(pos) == '1')
				odd.add(str);
			else
				even.add(str);
			System.out.println("pos is "+pos+" digit is "+str.charAt(pos) );
		}
		if (odd.size() > even.size()){
			System.out.println("Odd greater for position "+((3-(pos+1))));
			return findMissingBookSol(even, pos - 1) |0;
		}
		else{
			System.out.println("Even greater for position "+((3-(pos+1))));
			return findMissingBookSol(odd, pos - 1) |  1 << ((3-(pos+1))) ;
		}
	}

	private static int findMissing(String[] a) {
		int missing = 0;
		for (int k = 0; k < a[0].length(); k++) {
			int countZero = 0, countOne = 0;
			for (int i = 0; i < a.length; i++) {
				// System.out.println("i and k are "+i+" "+k);
				// System.out.println(a[i].charAt(k));
				if (a[i].charAt(k) == '1')
					countOne++;
				else
					countZero++;
			}
			// System.out.println(countZero+" "+countOne);
			if (countZero > countOne) {
				missing = missing | (1 << ((a[0].length() - 1) - k));
				// System.out.println("missing one");
			} else if (countZero < countOne) {
				missing = missing | (0 << ((a[0].length() - 1) - k));
				// System.out.println("missing zero");
			}
			// System.out.println(Integer.toBinaryString(missing));

		}

		return missing;

	}

}
