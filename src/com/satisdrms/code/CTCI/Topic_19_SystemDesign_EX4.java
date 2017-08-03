package com.satisdrms.code.CTCI;
//You have an array with all the numbers from 1 to N, where N is at most 32,000. 

//The array may have duplicate entries and you do not know what N is. 
//With only 4KB of memory available, how would you print all duplicate elements in the array?
class BitSet {
	int[] a;

	public BitSet(int size) {
		a = new int[size / 32];
	}

	public void setBit(int n) {
		int b = n % 32;
		a[n / 32] |= ((1 << b));
	}

	public boolean isBitSet(int n) {
		int pos = a[n / 32];
		int b = n % 32;
		if (((pos & (1 << b)) != 0))
			return true;
		else
			return false;
	}

}

public class Topic_19_SystemDesign_EX4 {

	public static void main(String[] args) {
		
		System.out.println(32000>>5);//is dividing by 32
		System.out.println(34&31);//is mod 32 -- 31 is 11111 and anding by it will give the last digits corresponding to mod 32
		//also written as in hexadecimal as below
		System.out.println(34&0x1F);
		mySol();
		bookSol();
	}

	private static void bookSol() {
		int[] ar = { 1, 3, 5, 9, 64, 234, 234, 62, 234, 2143, 3223, 3223, 23333, 45, 536, 5, 798, 65, 745, 643, 523,
				432, 5, 743, 7564, 5 };
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < ar.length; i++) {
			if (bs.isBitSet(ar[i])) {
				System.out.println(ar[i]);
			} else {
				bs.setBit(ar[i]);
			}
		}

	}

	private static void mySol() {
		byte[] a = new byte[4000];
		int[] ar = { 1, 3, 5, 9, 64, 234, 234, 62, 234, 2143, 3223, 3223, 23333, 45, 536, 5, 798, 65, 745, 643, 523,
				432, 5, 743, 7564, 5 };
		for (int i = 0; i < ar.length; i++) {
			int pos = a[ar[i] / 8];
			int b = ar[i] % 8;
			// System.out.println(ar[i]+" "+Integer.toBinaryString(pos));
			if (((pos & (1 << b)) != 0)) {
				System.out.println(ar[i]);
			} else {
				a[ar[i] / 8] |= ((1 << b));
			}
		}
	}

}
