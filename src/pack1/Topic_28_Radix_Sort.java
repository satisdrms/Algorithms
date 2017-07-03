package pack1;

public class Topic_28_Radix_Sort {

	public static void main(String[] args) {
		int a[] = { 323, 541, 554, 231, 123, 677, 999 };
		radixSort(a);

	}

	private static void radixSort(int[] a) {

		int expn = 1;
		int[] fin = new int[a.length];
		// I set the i<3 because all the digits are of 3 fields if there are
		// fields of varying size then the length of the below for loop will
		// change upto the max length of the digits
		for (int i = 0; i < 3; i++) {
			int[] buckets = new int[10];
			for (int j = 0; j < a.length; j++) {
				// System.out.println(a[j] / expn % 10);
				buckets[a[j] / expn % 10]++;
			}
			// for (int o = 0; o < 10; o++) System.out.println(buckets[o]);

			for (int j = 1; j < 10; j++) {
				// System.out.println(buckets[j]);
				buckets[j] += buckets[j - 1];
			}
			// for(int o=0;o<10;o++)System.out.println(buckets[o]);
			for (int j = a.length - 1; j >= 0; j--) {
				// System.out.println(j);
				fin[--buckets[a[j] / expn % 10]] = a[j];
			}
			for (int j = 0; j < a.length; j++)
				a[j] = fin[j];
			expn = expn * 10;
		}
		for (int x = 0; x < a.length; x++)
			System.out.println(a[x]);
		//
	}

}
