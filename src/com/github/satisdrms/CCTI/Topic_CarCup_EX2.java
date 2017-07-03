package com.github.satisdrms.CCTI;

//Implement int divide(int a, int b) without division or mod operation. 

public class Topic_CarCup_EX2 {
	// This is better than adding b times result because,
	// the number of loops significantly decrease at every doubling of N and
	// hence this performs better with bigger number
	
	// 
	
	public static void main(String[] args) {
		int dividend = 219, divisor = 3;

		int n = 1;

		while (dividend > (n << 1) * divisor) {
			n = n << 1;
		}
		//System.out.println(n);

		int result = 0;
		while (dividend > 0 && n>0) {
			if (dividend - (n * divisor) >= 0) {
				dividend = dividend - (n * divisor);
				result = result + n;
			}
			n = n >> 1;
			//System.out.println(result+" "+divident +" "+n);
		}

		System.out.println("result is " + result);

	}

}
