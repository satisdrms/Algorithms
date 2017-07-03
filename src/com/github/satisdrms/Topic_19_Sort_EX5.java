package com.github.satisdrms;

//Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
//Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] will return 4
//Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] will return -1

public class Topic_19_Sort_EX5 {

	public static void main(String[] args) {
		String[] ar = { "at", "", "", "", "ball", "", "", "car", "", "", "dad",
				"", "", "far" };
		String find = "far";

		int pos = binarySearch(ar, find, 0, ar.length - 1);
		System.out.println("pos is " + pos);
		
		//BOOK SOLUTION EXISTS USING WHILE LOOP in Binary search AND FINDING NEXT NON EMPTY STRING TO COMPARE AND GO FROM THERE 
	}

	private static int binarySearch(String[] ar, String find, int start, int end) {
		int mid = start + ((end - start) / 2);
		//System.out.println(start + " " + end + " " + mid);

		if (ar[start].equals(find))
			return start;
		else if (ar[end].equals(find))
			return end;
		else if (start >= end || end - start == 1)
			return -1;
		if (ar[mid].equals("")) {
			int ret = binarySearch(ar, find, start, mid - 1);
			if (ret != -1)
				return ret;
			else
				return binarySearch(ar, find, mid + 1, end);
		} else {
			if (find.compareTo(ar[mid]) <= 0) {
				return binarySearch(ar, find, start, mid);
			} else
				return binarySearch(ar, find, mid + 1, end);
		}

	}

}
