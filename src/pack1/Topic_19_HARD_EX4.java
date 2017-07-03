package pack1;

//Write a method to count the number of 2s between 0 and n.

public class Topic_19_HARD_EX4 {

	public static void main(String[] args) {
		int n = 1234;
		// System.out.println(Math.log10(1));
		bookSolModifiedWithMyIdea(n);
		// bruteForce(n);
		bokSolForValidating(n);
	}

	/**
	 * @param n
	 */
	private static void bookSolModifiedWithMyIdea(int n) {
		int count = 0;
		int lar = 1;
		while (n / (lar * 10) > 0)
			lar = lar * 10;
		// System.out.println(lar);
		while (n > 0) {
			int first = n / lar;
			int remain = n % lar;
			System.out.println(first + " " + remain + " " + n + " " + lar + " "
					+ count);
			if (first > 2) {
				count = (int) (count + lar + (first * (Math.log10(lar) * (lar / 10))));
			} else if (first == 2) {
				count = (int) (1 + count + remain + (first * (Math.log10(lar) * (lar / 10))));
			} else {
				count = (int) (count + (first * (Math.log10(lar) * (lar / 10))));
			}
			n = remain;
			lar = lar / 10;
		}
		System.out.println(count);
	}

	/**
	 * @param n
	 */
	private static void bruteForce(int n) {
		int count = 0;

		// System.out.println(getTwos(223142));--3
		for (int i = 1; i <= n; i++) {
			count = count + getTwos(i);
		}
		System.out.println(count);
	}

	private static int getTwos(int i) {
		int twos = 0;
		int m = 10;
		while (i > 0) {
			if (i % m == 2) {
				twos++;
			}
			i = i / m;
		}
		return twos;
	}

	public static void bokSolForValidating(int num) {
		int countof2s = 0, digit = 0;
		int j = num, seendigits = 0, position = 0, pow10_pos = 1;
		/*
		 * maintaining this value instead of calling pow() is an 6x perf gain
		 * (48s -> 8s) pow10_posMinus1. maintaining this value instead of
		 * calling Numof2s is an 2x perf gain (8s -> 4s). overall > 10x speedup
		 */
		while (j > 0) {
			digit = j % 10;
			int pow10_posMinus1 = pow10_pos / 10;
			countof2s = countof2s + digit * position * pow10_posMinus1;
			/*
			 * we do this if digit <, >, or = 2 Digit < 2 implies there are no
			 * 2s contributed by this digit. Digit == 2 implies there are 2 *
			 * numof2s contributed by the previous position + num of 2s
			 * contributed by the presence of this 2
			 */
			if (digit == 2) {
				countof2s += seendigits + 1;
			}
			/*
			 * Digit > 2 implies there are digit * num of 2s by the prev.
			 * position + 10^position
			 */
			else if (digit > 2) {
				countof2s += pow10_pos;
			}
			seendigits = seendigits + pow10_pos * digit;
			pow10_pos *= 10;
			position++;
			j = j / 10;
		}
		System.out.println(countof2s);
	}
}
