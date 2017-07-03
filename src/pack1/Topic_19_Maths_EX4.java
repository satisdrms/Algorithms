package pack1;

//Write a method to implement *, - , / operations. You should use only the + operator.

public class Topic_19_Maths_EX4 {

	public static void main(String[] args) {
		int a = 10, b = 5;
		implementMultiply(a, b);
		implementSubtract(a, b);
		implementDivide(a, b);
	}

	private static void implementDivide(int a, int b) {
		int div = 0;
		while (b <= a) {
			div++;
			b = b + b;
		}
		System.out.println(div);
	}

	private static void implementSubtract(int a, int b) {
		int sub = 0;
		while (a != b) {
			sub++;
			a++;
		}
		System.out.println(sub);
	}

	private static void implementMultiply(int a, int b) {
		int sum = 0;
		for (int i = 0; i < a; i++) {
			sum = sum + b;
		}
		System.out.println(sum);

	}

}
