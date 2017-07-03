package com.github.satisdrms.CCTI;

//Write a function to determine the number of bits required to convert integer A to integer B.
//Input: 31, 14
//Output: 2

public class Topic_19_BitManip_EX5 {

	public static void main(String[] args) {
		int a = 31;
		p(a);
		int b = 14;
		p(b);
		p(0xaaaaaaaa);
		p(0x55555555);
		p(0xcccccccc);
		p(0x33333333);
		p(0xf0f0f0f0);
		p(0x0f0f0f0f);
		p(0xff00ff00);
		p(0x00ff00ff);
		p(0xffff0000);
		p(0x0000ffff);
		
		int aCount=countBits(a);
		int bCount=countBits(b);
		System.out.println(aCount+" "+bCount);
		
		int Count=countBitsBookSol(a,b);
		System.out.println(Count);

	}

	private static int countBitsBookSol(int a, int b) {
		int sum=0;
		for(int c=a^b;c!=0;c=c>>1){
			sum=sum+(c&1);
		}
		return sum;
	}

	/**
	 * @param a
	 * @return 
	 */
	private static int countBits(int a) {
		a=((0xaaaaaaaa&a)>>1)+(0x55555555&a);p(a);
		a=((0xcccccccc&a)>>2)+(0x33333333&a);p(a);
		a=((0xf0f0f0f0&a)>>4)+(0x0f0f0f0f&a);p(a);
		a=((0xf0f0f0f0&a)>>8)+(0x0f0f0f0f&a);p(a);
		a=((0xffff0000&a)>>16)+(0x0000ffff&a);p(a);
		return a;
	}

	private static void p(int n) {
		System.out.println(Integer.toBinaryString(n));
	}

}
