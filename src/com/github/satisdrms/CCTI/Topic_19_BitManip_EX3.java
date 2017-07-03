package com.github.satisdrms.CCTI;

//Given an integer, print the next smallest and next largest number 
//that have the same number of 1 bits in their binary representation.

public class Topic_19_BitManip_EX3 {

	public static void main(String[] args) {
		int i = 94;// printBin(i);
		// getNextLargest(i);
		getNextSmallest(i);
	}

	private static void getNextSmallest(int i) {
		// 1011100
		// 1100011-51
		// 1101011-107
		// 1100110-102
		// 1101001001-841
		i = 841;
		p(i);
		int a=(i-1)&~i;p(a);
		int c=a|i;p(c);
		int d=c+1;p(d);
		int e=d&~c;p(e);
		int f=c&~(e-1);p(f);
		int g=f&~(f-1);p(g);
		int h=g>>1;p(h);
		int j=i&(e-1);p(j);
		System.out.println(h+" "+e);
		int k=j<<(h/e/2);p(k);
		int l=(g^f)|h|k;p(l);
		
		
		
		// ONE WAY STARTS
		//Find highest one bit
		//Find highest zero bit after highest one bit
		//Find Lowest one after highest zero
		//Make lowest one to zero
		//Make highest zero to one
		//Make.. 
		// int a=(i-1)&~i;p(a);
		// int c=a|i;p(c);
		// int d=c+1;p(d);
		// int e=d&~c;p(e);
		// int f=c&~(e-1);p(f);
		// int g=f&~(f-1);p(g);
		// ONE WAY ENDS
		
		

	}

	private static void getNextLargest(int i) {
		int lo = i & ~(i - 1);
		int lz = ~i & (i + lo);
		i = i | lz;
		i = i & ~(lz - 1);

		i = i | (lz / lo / 2 - 1);
		p(i);
		System.out.println(i);
	}

	private static void p(int n) {
		System.out.println(Integer.toBinaryString(n));
	}

}
