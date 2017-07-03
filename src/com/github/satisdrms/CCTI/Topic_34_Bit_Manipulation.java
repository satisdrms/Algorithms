package com.github.satisdrms.CCTI;

import java.math.BigInteger;

import javax.naming.BinaryRefAddr;

public class Topic_34_Bit_Manipulation {
	static public void main(String[] args) {
		int a = 118;
		int b = 117;
		int c = 116;
		int d = 115;
		System.out.println("a is " + a + " " + Integer.toBinaryString(a));
		System.out.println("b is " + b + " " + Integer.toBinaryString(b));
		System.out.println("c is " + c + " " + Integer.toBinaryString(c));
		System.out.println("d is " + d + " " + Integer.toBinaryString(d));
		// System.out.println(Integer.toBinaryString(1));
		// workset2(a, b);
		// workset3(a);
		// workSet4(a, b, c, d);
		// reverseBits();
		// countingBitsInWord();

		// iterateSubSet();
		tccProblem1();
		// System.out.println("0xaaaaaaaa " +
		// Integer.toBinaryString(0xaaaaaaaa));
		// System.out.println("0x55555555 " +
		// Integer.toBinaryString(0x55555555));
		// System.out.println("0xcccccccc " +
		// Integer.toBinaryString(0xcccccccc));
		// System.out.println("0x33333333 " +
		// Integer.toBinaryString(0x33333333));
		// System.out.println("0xf0f0f0f0 " +
		// Integer.toBinaryString(0xf0f0f0f0));
		// System.out.println("0x0f0f0f0f " +
		// Integer.toBinaryString(0x0f0f0f0f));
		// System.out.println("0xff00ff00 " +
		// Integer.toBinaryString(0xff00ff00));
		// System.out.println("0x00ff00ff " +
		// Integer.toBinaryString(0x00ff00ff));
		// System.out.println("0xffff0000 " +
		// Integer.toBinaryString(0xffff0000));
		// System.out.println("0x0000ffff " +
		// Integer.toBinaryString(0x0000ffff));
		// countbits(99);
	}

	private static void tccProblem1() {
		// https://community.topcoder.com/stat?c=problem_statement&pm=6725&rd=10100
		// Problem Statement for FactoryCounting
		// Problem Statement
		// The ACME company is building a factory complex in your county which
		// has k cities. The factory complex is split into n part-building
		// factories and m part-assembling factories. Each factory must be built
		// in a different city of your county because of polution regulations,
		// and there must be a direct road between each building factory and
		// each assembling factory.
		// You will be given a String[] county. Character j of element i of
		// county will be 'Y' if there is a direct road between city i and city
		// j, and 'N' if there isn't. All roads are bidirectional. Return the
		// number of ways the factory complex can be built in this county. Two
		// factory complexes are different if the set of cities containing
		// part-building factories is different in one than the other, or the
		// set of cities containing part-assembling factories is different in
		// one than the other

		String[] county = { "NYYYYN", "YNYYNY", "YYNYYY", "YYYNYN", "YNYYNY",
				"NYYNYN" };

		int n = 2;// part building factories
		int m = 2;// part assembly factories
		int[] countyBit = convertBitset(county, m);
		// double d=1;
		// BigInteger b = new BigInteger();
		// System.out.println(b.toString(2));
		int count = 0;// possible options for building factories
		//System.out.println(Integer.toBinaryString(1 << 31));
		// for (int i = 0; i < countyBit.length; i++) {
		// if (countbits(countyBit[i]) >= n)
		// for (int j = 0; j < countyBit.length; j++) {
		// if (countbits(countyBit[j]) >= n && i != j) {
		// if (countbits(countyBit[j] & countyBit[i]) > m) {
		// System.out.println("possible combinations are ");
		// count++;
		// }
		// }
		// }
		// }
		
		findKElementSubsets();
		
		
		

	}

	private static void findKElementSubsets() {
		System.out.println("In K Element Subsets");
		int k=3;
		int N=5;
		int s = (1 << k) - 1;
		bin(s);
		bin((s & 1 << N));
		while ((s & 1 << N)==0)
		{
			System.out.println("Looping");
			bin(s,"Initial s is ");
		    int lo = s & ~(s - 1);       // lowest one bit
		    bin(lo,"lo is ");
		    int lz = (s + lo) & ~s;      // lowest zero bit above lo
		    bin(lz,"lz is ");
		    //bin(((lo+~lo)|s)+1,"MY lz is ");
		    s |= lz;                     // add lz to the set
		    bin(s,"s is ");
		    s &= ~(lz - 1);              // reset bits below lz
		    bin(s,"s is ");
		    bin((lz / lo / 2) - 1,"(lz / lo / 2) - 1 is ");
		    s |= (lz / lo / 2) - 1;      // put back right number of bits at end
		    							// division precedence is left to right
		    bin(s,"final s is ");
		    System.out.println("==================");
		}
		
	}

	private static void bin(int i, String s) {
		System.out.println(s+Integer.toBinaryString(i));
		
	}

	private static int countbits(int i) {
		System.out.println("In CountBits");
		// bin(i);
		i = (i & 0x55555555) + ((i & 0xaaaaaaaa) >> 1);
		// bin(i);
		i = (i & 0x33333333) + ((i & 0xcccccccc) >> 2);
		// bin(i);
		i = (i & 0x0f0f0f0f) + ((i & 0xf0f0f0f0) >> 4);
		i = (i & 0x00ff00ff) + ((i & 0xff00ff00) >> 8);
		i = (i & 0x0000ffff) + ((i & 0xffff0000) >> 16);
		bin(i);
		return i;
	}

	private static void bin(int i) {
		System.out.println(Integer.toBinaryString(i));

	}

	private static int[] convertBitset(String[] county, int m) {
		// System.out.println("Converting To Bit Sets");
		int[] countyBit = new int[county.length];
		// System.out.println(countyBit.length);
		int j = 0;
		for (String s : county) {
			int bit = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'Y') {
					bit = bit | (1 << i);

				}
			}
			// System.out.println(Integer.toBinaryString(bit));
			if (countbits(bit) >= m) {
				countyBit[j] = bit;
				j++;
			}
		}
		// System.out.println("Valid Cities are");
		// for (int i = 0; i < countyBit.length; i++) {
		// System.out.println(Integer.toBinaryString(countyBit[i]) + " "
		// + countyBit[i]);
		// }
		return countyBit;
	}

	private static void iterateSubSet() {
		int k = 3;
		int N = 4;
		int s = (1 << k) - 1;
		while (true) // ((s & 1 << N))
		{
			// do stuff with s
			int lo = s & ~(s - 1); // lowest one bit
			int lz = (s + lo) & ~s; // lowest zero bit above lo
			s |= lz; // add lz to the set
			s &= ~(lz - 1); // reset bits below lz
			s |= (lz / lo / 2) - 1; // put back right number of bits at end
		}

	}

	private static void workSet4(int a, int b, int c, int d) {
		System.out.println("----------In workset4");
		System.out.println(Integer.toBinaryString(a));
		// System.out.println(Integer.toBinaryString(126));
		// System.out.println(Integer.toBinaryString(~a));
		// System.out.println(Integer.toBinaryString(a>>=1));
		// System.out.println(Integer.toBinaryString(a>>=1));
		// System.out.println(Integer.toBinaryString(a>>=1));

		// System.out.println(Integer.toBinaryString(((a >> 1) & 0x55555555)));
		System.out.println(Integer.toBinaryString((a & 0xaaaaaaaa) >> 1));
		System.out.println(Integer.toBinaryString(a & 0x55555555));
		System.out.println((a & 0x55555555) + ((a >> 1) & 0x55555555));
		System.out.println((a & 0x55555555) + (a & 0xaaaaaaaa));
		System.out.println(a - ((a >> 1) & 0x55555555));

		int x = 101;
		System.out.println("x is " + Integer.toBinaryString(x));
		x = x + 64;
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(b));
		b = b + 8;
		System.out.println(Integer.toBinaryString(b));
		b = b + 8;
		System.out.println(Integer.toBinaryString(b));

	}

	private static void countingBitsInWord() {
		String a = "sathish";
		for (char c : a.toCharArray()) {
			System.out.println(Integer.toBinaryString(c));
			System.out.println(Integer.toBinaryString(c & 1));

		}

	}

	/**
	 * 
	 */
	private static void reverseBits() {

		// 1. switch adjacent bits
		// 2. switch positions of two bits adjacent 2 other bits
		// continue this until the size of the data type.
		// here number of bits in an integer is 32

		int x = 6;
		System.out.println("0xaaaaaaaa " + Integer.toBinaryString(0xaaaaaaaa));
		System.out.println("0x55555555 " + Integer.toBinaryString(0x55555555));
		System.out.println("0xcccccccc " + Integer.toBinaryString(0xcccccccc));
		System.out.println("0x33333333 " + Integer.toBinaryString(0xcccccccc));
		System.out.println("0xf0f0f0f0 " + Integer.toBinaryString(0xf0f0f0f0));
		System.out.println("0x0f0f0f0f " + Integer.toBinaryString(0x0f0f0f0f));
		System.out.println("0xff00ff00 " + Integer.toBinaryString(0xff00ff00));
		System.out.println("0x00ff00ff " + Integer.toBinaryString(0x00ff00ff));
		System.out.println("0xffff0000 " + Integer.toBinaryString(0xffff0000));
		System.out.println("0x0000ffff " + Integer.toBinaryString(0x0000ffff));

		System.out.println("x is " + x + " " + Integer.toBinaryString(x));

		x = ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
		System.out.println("x is " + x + " " + Integer.toBinaryString(x));
		x = ((x & 0xcccccccc) >> 2) | ((x & 0x33333333) << 2);
		System.out.println("x is " + x + " " + Integer.toBinaryString(x));
		x = ((x & 0xf0f0f0f0) >> 4) | ((x & 0x0f0f0f0f) << 4);
		System.out.println("x is " + x + " " + Integer.toBinaryString(x));
		x = ((x & 0xff00ff00) >> 8) | ((x & 0x00ff00ff) << 8);
		System.out.println("x is " + x + " " + Integer.toBinaryString(x));
		x = ((x & 0xffff0000) >> 16) | ((x & 0x0000ffff) << 16);
		System.out.println("x is " + x + " " + Integer.toBinaryString(x));
	}

	/**
	 * @param a
	 */
	private static void workset3(int a) {
		// adding 0x infront or h in the end makes it an hexa decimal number
		int x = 0xaaaaaaaa;
		System.out.println("x is " + x);
		System.out.println(Integer.toBinaryString(0xaaaaaaaa));
		System.out.println(Integer.toBinaryString(0x55555555));
		System.out.println(Integer.toBinaryString(0xcccccccc));
		System.out.println(Integer.toBinaryString(0xcccccccc));
		System.out.println(Integer.toBinaryString(0xf0f0f0f0));
		System.out.println(Integer.toBinaryString(0x0f0f0f0f));
		System.out.println(Integer.toBinaryString(0xff00ff00));
		System.out.println(Integer.toBinaryString(0x00ff00ff));
		System.out.println(Integer.toBinaryString(0xffff0000));
		System.out.println(Integer.toBinaryString(0x0000ffff));
		// System.out.println(a & 0xaaaaaaaa);
		System.out.println(Integer.toBinaryString(((a & 0xaaaaaaaa) >> 1)
				| ((a & 0x55555555) << 1)));
	}

	/**
	 * @param a
	 * @param b
	 */
	private static void workset2(int a, int b) {
		// -+-+-+-generalOperations(a, b, c, d);
		// Checking whether a bit at a particular position is 1 or 0
		System.out.println(Integer.toBinaryString(b & (~b | (1 << 1))) + " "
				+ ((b & (~b | (1 << 1))) == 0));

		// Find the lowest bit set to 1
		// Subtracting 1 makes the lowest 1 to turn to 0
		System.out.println(Integer.toBinaryString(a & ~(a - 1)));
		System.out.println(Integer.toBinaryString(a).length());
		System.out.println(Integer.toBinaryString((int) Math.pow(2, Integer
				.toBinaryString(a).length())));
		// System.out.println(Math.pow(2, 3));
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @return
	 */
	private static void generalOperations(int a, int b, int c, int d) {
		System.out.println("a is " + a + " " + Integer.toBinaryString(a));
		System.out.println("b is " + b + " " + Integer.toBinaryString(b));
		System.out.println("c is " + c + " " + Integer.toBinaryString(c));
		System.out.println("d is " + d + " " + Integer.toBinaryString(d));
		System.out.println(Integer.toBinaryString(d));// 101
		System.out.println(Integer.toBinaryString(a) + " "
				+ Integer.toBinaryString(a << 4));// 1 10000
		System.out.println(Integer.toBinaryString(a) + " "
				+ Integer.toBinaryString(b) + " "
				+ Integer.toBinaryString(a | b));// 1 10 11
		System.out.println(Integer.toBinaryString(a) + " "
				+ Integer.toBinaryString(b) + " "
				+ Integer.toBinaryString(a & b)); // 01 10 00
		System.out.println(Integer.toBinaryString(~a));// 11111111111111111111111111111110
		System.out.println(Integer.toBinaryString(4) + " "
				+ Integer.toBinaryString(4 << a));// 100 1000
		System.out.println("Set Subtraction " + Integer.toBinaryString(a) + " "
				+ Integer.toBinaryString(~b) + " "
				+ Integer.toBinaryString(a & ~b) + " " + (a & ~b));
		System.out.println(Integer.toBinaryString(a ^ b));
		System.out.println(Integer.toBinaryString(a = a | a << 6));// 1000001
		System.out.println(Integer.toBinaryString(a = a & ~(1 << 6)));
		System.out.println(Integer.toBinaryString(b = b | (1 << 6)));

	}
}
