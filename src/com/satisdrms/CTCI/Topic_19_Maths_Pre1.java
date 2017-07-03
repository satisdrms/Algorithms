package com.satisdrms.CTCI;

//Find the least common multiplier
public class Topic_19_Maths_Pre1 {

	public static void main(String[] args) {

		int a = 4, b = 6;
		System.out.println(6 % 2);
		// 1%2=1
		// 1/2=0
		int d = 1;
		int n = 2;
		while ((a != 1 || b != 1)) {
			//System.out.println("n is "+n);
			int x = 1, y = 1;
			while (a != 0 && a % n == 0) {
				x = x * n;
				a = a / n;
				//System.out.println("a is " + a);
				//slp(1000);
			}
			while (b != 0 && b % n == 0) {
				y = y * n;
				b = b / n;
				//System.out.println("b is " + b);
				//slp(1000);
			}
			int max = Math.max(x, y);
			d = d * max;
			
			n = getNextPrime(n);
		}
		System.out.println(d);

	}

	/**
	 * @param i 
	 * 
	 */
	private static void slp(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int getNextPrime(int n) {
		boolean flag = true;
		for (int i = n + 1; i <= 100; i++) {
			flag = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				return i;
		}
		return -1;
	}
}
