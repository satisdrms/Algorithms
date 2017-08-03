package com.satisdrms.code.CTCI;

public class Topic_3_Sample_main implements Topic_3_Sample_interface{
	@SuppressWarnings("unused")
	public static void main() {
		System.out.println("main without args");
	}

	static public void main(String[] args) {
		Topic_3_Sample_class sam = new Topic_3_Sample_class();
		System.out.println("main with String[]");
		System.out.println(val);

	}

}
