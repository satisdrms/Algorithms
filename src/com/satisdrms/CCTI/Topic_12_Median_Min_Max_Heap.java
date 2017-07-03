package com.satisdrms.CCTI;

interface median_heap {
	public int extractroot();

	public void display_words();

}

class m_min_heap implements median_heap {
	int position;
	int[] arr;

	public m_min_heap(int i) {
		position = 0;
		arr = new int[11];
	}

	public void add(int i) {
		if (arr.length > position + 1)
			arr[++position] = i;
		bubbleup(position);

	}

	private void bubbleup(int pos) {
		while (pos > 1 && arr[pos / 2] > arr[pos]) {
			// System.out.println("swapping " + arr[pos] + " " + arr[pos / 2]);
			swap(pos / 2, pos);
			pos = pos / 2;
		}
	}

	public void display() {
		for (int i = 1; i <= position; i = i + 2) {
			System.out.println(arr[i] + " at " + i + " is Child of " + i / 2);
		}
		for (int i = 2; i <= position; i = i + 2) {
			System.out.println(arr[i] + " at " + i + " is Child of " + i / 2);
		}
	}

	public void display_words() {
		int root = 1;
		System.out.println(arr[root] + " " + " is the root");
		display_words(root, arr[root] + " " + " is the root");
	}

	public void display_words(int pos, String s) {
		if (pos * 2 <= position) {
			String tre = arr[pos * 2] + " " + " is Left of " + s;
			System.out.println(tre);
			display_words(pos * 2, tre);
		}
		if (pos * 2 + 1 <= position) {
			String tre = arr[pos * 2 + 1] + " " + " is Right of " + s;
			System.out.println(tre);
			display_words(pos * 2 + 1, tre);
		}
	}

	public int getmin() {
		if (position > 0) {
			return arr[1];
		}
		return -1;
	}

	public int extractroot() {// Extracting MIN as this is MIN-HEAP
		if (position > 0) {
			int root = arr[1];
			arr[1] = arr[position--];
			bubbledown(1);
			return root;
		} else
			return -1;
	}

	private void bubbledown(int pos) {
		int smallest = pos;
		if (2 * pos <= position && arr[2 * pos] < arr[smallest]) {
			smallest = pos * 2;
		}
		if (2 * pos + 1 <= position && arr[2 * pos + 1] < arr[smallest]) {
			smallest = pos * 2 + 1;
		}
		if (smallest != pos) {
			// System.out.println(smallest + " " + pos);
			swap(pos, smallest);
			bubbledown(smallest);
		}

	}

	private void swap(int pos, int child) {
		int temp;
		temp = arr[pos];
		arr[pos] = arr[child];
		arr[child] = temp;

	}

	public int count() {
		return position;
	}

}

class m_max_heap implements median_heap {
	int position;
	int[] arr;

	public m_max_heap(int size) {
		position = 0;
		arr = new int[size];
	}

	public void add(int i) {
		if (arr.length > position + 1)
			arr[++position] = i;
		bubbleup(position);

	}

	private void bubbleup(int pos) {
		while (pos > 1 && arr[pos / 2] < arr[pos]) {
			// System.out.println("swapping " + arr[pos] + " " + arr[pos / 2]);
			swap(pos / 2, pos);
			pos = pos / 2;
		}
	}

	public void display() {
		for (int i = 1; i <= position; i = i + 2) {
			System.out.println(arr[i] + " at " + i + " is Child of " + i / 2);
		}
		for (int i = 2; i <= position; i = i + 2) {
			System.out.println(arr[i] + " at " + i + " is Child of " + i / 2);
		}
	}

	public void display_words() {
		int root = 1;
		System.out.println(arr[root] + " " + " is the root");
		display_words(root, arr[root] + " " + " is the root");
	}

	public void display_words(int pos, String s) {
		if (pos * 2 <= position) {
			String tre = arr[pos * 2] + " " + " is Left of " + s;
			System.out.println(tre);
			display_words(pos * 2, tre);
		}
		if (pos * 2 + 1 <= position) {
			String tre = arr[pos * 2 + 1] + " " + " is Right of " + s;
			System.out.println(tre);
			display_words(pos * 2 + 1, tre);
		}
	}

	public int getmax() {
		if (position > 0) {
			return arr[1];
		}
		return -1;
	}

	public int extractroot() {// Extracting MAX as this is MAX-HEAP
		if (position > 0) {
			int root = arr[1];
			arr[1] = arr[position--];
			bubbledown(1);
			return root;
		} else
			return -1;
	}

	private void bubbledown(int pos) {
		int greatest = pos;
		if (2 * pos <= position && arr[2 * pos] > arr[greatest]) {
			greatest = pos * 2;
		}
		if (2 * pos + 1 <= position && arr[2 * pos + 1] > arr[greatest]) {
			greatest = pos * 2 + 1;
		}
		if (greatest != pos) {
			// System.out.println(greatest + " " + pos);
			swap(pos, greatest);
			bubbledown(greatest);
		}

	}

	private void swap(int pos, int child) {
		int temp;
		temp = arr[pos];
		arr[pos] = arr[child];
		arr[child] = temp;

	}

	public int count() {
		return position;
	}

}

public class Topic_12_Median_Min_Max_Heap {
	static m_max_heap max_test = new m_max_heap(12);
	static m_min_heap min_test = new m_min_heap(12);

	public static void main(String[] args) {
		// add(1);display();print_median(max_test, min_test);
		add_disp_med(2);
		add_disp_med(3);
		add_disp_med(4);
		add_disp_med(10);
		add_disp_med(123);
		add_disp_med(5);
		add_disp_med(45);
		add_disp_med(8);
		add_disp_med(58);
		add_disp_med(6);
		add_disp_med(79);
		add_disp_med(9);
		add_disp_med(7);
		add_disp_med(37);
		add_disp_med(11);
		add_disp_med(1);

		// display(max_test);
		// display(min_test);
		print_median(max_test, min_test);
		display();
	}

	private static void add_disp_med(int i) {
		System.out.println();
		add(i);
		System.out.println();
		display();
		System.out.println();
		print_median(max_test, min_test);
		System.out.println();
		System.out.println("*****************************");
	}

	private static void add(int i) {
		System.out.println("Adding " + i);
		// INPUT
		// 1 2 3 4 5 6 7 8 9 10
		if (i > min_test.getmin()) {// Add the second half in min heap
									// (6,7,8,9,10)
			min_test.add(i);
		}
		if (i <= min_test.getmin()) {// Add the first half in max heap
										// (1,2,3,4,5)
			// CHECKING THE NEW VALUE AGAINST MIN SO THAT AN INCOMING NUMBER IS
			// ALWAYS ADDED IN
			// EITHER MIN HEAP OR MAX HEAP

			max_test.add(i);
		}
		while (Math.abs(max_test.count() - min_test.count()) > 1) {
			if (max_test.count() > min_test.count()) {
				min_test.add(max_test.extractroot());
			}
			if (min_test.count() > max_test.count()) {
				max_test.add(min_test.extractroot());
			}
		}
	}

	private static void print_median(m_max_heap max_test, m_min_heap min_test) {

		if (max_test.count() > min_test.count()) {
			System.out.print("median(MAX HEAP) is " + max_test.getmax());
		} else if (max_test.count() < min_test.count()) {
			System.out.print("median(MIN HEAP) is " + min_test.getmin());
		} else {
			System.out
					.print("median(AVG OF ROOT) is "
							+ (((float) min_test.getmin() + (float) max_test
									.getmax()) / (float) 2));
		}

	}

	private static <E extends median_heap> void display(/* E a */) {
		// System.out.println("Displaying Min Heap(i.e. second half");
		min_test.display_words();
		System.out.println("----");
		// System.out.println("Displaying Max Heap(i.e. first half");
		max_test.display_words();
	}

}
