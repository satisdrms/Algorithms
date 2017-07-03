package com.github.satisdrms;

//You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
//Write a method to set all bits between i and j in N equal to M 
//(e.g., M becomes a substring of N located at i and starting at j).
//EXAMPLE:
//Input: N = 10000000000, M = 10101, i = 2, j = 6
//Output: N = 10001010100

public class Topic_19_BitManip_EX1 {

	public static void main(String[] args) {
		String sN = "10001100000";
		//10000110000
		//10001010100
		String sM = "00101";
		int i = 2, j = 6;
		int N = converBinaryToInt(sN);
		int M = converBinaryToInt(sM);

		//embed(N, M, i, j);
		embedBookSol(N, M, i, j);


	}

	private static void embedBookSol(int n, int m, int i, int j) {
		int max = ~0;printBin(max);
		int left = max - ((1 << (j+1)) - 1);printBin(left);
		int right = ((1 << i) - 1);printBin(right);
		int mask = left | right;printBin(mask);
		int fin=(n & mask) | (m << i);printBin((n & mask) );;printBin((m << i));printBin(fin);
		
		
	}

	private static void embed(int n, int m, int i, int j) {
		m = m << i;
		int tmp = 1 << i; 
		for (int i1 = i + 1; i1 <= j; i1++) { 
			tmp = tmp | (1 << i1);
		}  
		int tmp1=((1<<(j+1))-1)-((1<<i)-1);
		
		// tmp1 and tmp are same but two different approaches		
		
		tmp=tmp&n; 
		n=n&~tmp; 
		n = n | m;
		printBin(n);
	}

	/**
	 * @param n
	 * @return
	 */
	private static void printBin(int n) {
		System.out.println(Integer.toBinaryString(n));
	}

	private static int converBinaryToInt(String sN) {
		int ret = 0;
		// System.out.println(sN.length());
		int pow = sN.length() - 1;
		for (int i = 0; i < sN.length(); i++, pow--) {
			// System.out.println(sN.charAt(i));
			if (sN.charAt(i) == '1') {
				ret = (int) (ret + Math.pow(2, pow));
			}
		}
		// System.out.println(ret);
		return ret;
	}

}
