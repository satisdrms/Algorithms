package com.satisdrms.code.CTCI;

//Write a program to swap odd and even bits in an integer with as few instructions as possible 
//(e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).

public class Topic_19_BitManip_EX6 {

	public static void main(String[] args) {

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
		
		int a=101;p(a);
		a=((a&0xaaaaaaaa)>>1)|((a&0x55555555)<<1);
		p(a);
	}

	private static void p(int n) {
		System.out.println(Integer.toBinaryString(n));
	}

}
