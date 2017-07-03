package com.github.satisdrms.CCTI;

import java.util.Enumeration;

enum season {
	summer(1000), winter(299999,32), autumn(3);

	int value;
	int value1;

	season(int value) {
		this.value = value;

	}
	season(int value,int value1){
		this.value=value;
		this.value1=value1;
	}

}

public class Topic_9_Enumeration {
	public enum days {
		sunday, monday, wednesday
	};

	public static void main(String[] args) {
		for (days d : days.values())
			System.out.println(d);
		System.out.println(days.monday);
		

		season a=season.winter;
		System.out.println(a+" "+a.value+" "+a.value1);
	}

}
