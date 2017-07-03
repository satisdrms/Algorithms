package com.github.satisdrms;

public class Topic_8_Binary_Search {
	public static void main(String[] args) {
		int search = 121;
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9,10 };
		int len = arr.length - 1;
		System.out.println(find(arr, search, 0, len));
	}

	public static Boolean find(int[] arr, int search, int start, int end) {
		System.out.println(1);
		if (arr[start] == search || arr[end] == search) {
			return true;
		} else if (arr[(end - start) / 2] >= search && end-start>1) {
			return find(arr, search, start, ((end - start) / 2) + start);
		} else if (arr[(end - start) / 2] < search && end-start>1) {
			return find(arr, search, ((end - start) / 2) + start, end);
		}
		return false;
	}
}
