package com.github.satisdrms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Topic_28_BucketSort {

	public static void main(String[] args) {
		int[] a = { 4, 12, 5, 67, 43, 4, 32, 6, 6, 76, 5, 34, 32, 98, 25, 43, 65, 15, 37 };
		int max = getMax(a);
		int noBuck = (int) Math.sqrt(a.length);
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[noBuck];
		for (int i = 0; i < noBuck; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		for(int i:a){
			buckets[(int) (((double)i/max)*(noBuck-1))].add(i);
		}
		for(int i=0;i<noBuck;i++){
			Collections.sort(buckets[i]);
			//System.out.println(buckets[i]);
		}
		
	}

	private static int getMax(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}

}
