package com.satisdrms.CCTI;

public class Topic_34_Bit_Manipulation_PowerSet_EX1 {

	public static void main(String[] args) {
		int k = 4;
		char[] c = { 'a', 'b', 'c', 'd' };
		powerSet(k, c);

	}

	private static void powerSet(int k, char[] c) {
		int len = c.length ;
		for (int i = 0; i < (1 << len); i++) {
			bin(i);
			System.out.print('{');
			for(int j=0;j<len;j++){
				if(((1<<j)&i)>0){
					System.out.print(j+"-"+c[j]+", ");
				}
			}
			System.out.println('}');
		}

	}

	private static void bin(int i) {
		System.out.println(Integer.toBinaryString(i));
		
	}
}
