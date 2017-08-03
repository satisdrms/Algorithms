package com.satisdrms.code.CTCI;

class min_heap {
	int position;
	int[] arr;

	public min_heap() {
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
			System.out.println("swapping " + arr[pos] + " " + arr[pos / 2]);
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

	public int extractroot() {// Extracting MIN as this is MIN-HEAP
		if (position > 0) {
			int root = arr[1];
			arr[1] = arr[position];
			position = position - 1;
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
			System.out.println(smallest + " " + pos);
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

}

public class Topic_11_Binary_Min_Heap {

	public static void main(String[] args) {
		min_heap a = new min_heap();
		a.add(10);
		a.add(12);
		a.add(13);
		a.add(14);
		a.add(15);
		// a.add(16);
		a.add(17);
		a.add(18);
		a.display_words();
		a.add(8);
		// a.add(19);
		a.add(20);
		a.add(1);

		// a.display();
		a.display_words();
		/*
		 * extractroot_display(a); extractroot_display(a);
		 * extractroot_display(a); extractroot_display(a);
		 * extractroot_display(a); extractroot_display(a);
		 * extractroot_display(a); extractroot_display(a);
		 * extractroot_display(a); extractroot_display(a);
		 * extractroot_display(a);
		 */
	}

	private static void extractroot_display(min_heap a) {
		System.out.println("Extracted Minimum is " + a.extractroot());
		a.display_words();
	}

}
