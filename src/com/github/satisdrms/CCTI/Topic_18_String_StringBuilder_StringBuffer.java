package com.github.satisdrms.CCTI;

public class Topic_18_String_StringBuilder_StringBuffer {

	public static void main(String[] args) {
		String ex1 = "Sathish";
		System.out.println(ex1);

		StringBuilder ex2 = new StringBuilder("Abdul Kalam");
		StringBuilder ex3 = new StringBuilder("Sathish");
		p(ex2);
		p(ex2.append(" is " + true));
		p(ex2.insert(5, " INSERTED"));
		// p(ex2);
		p(ex2.replace(5, 6, " RE-"));
		// p(ex2);
		p(ex2.delete(6, 9));
		// p(ex2);
		p(ex2.reverse());
		p(ex2.reverse());
		
		p(ex3.reverse());
		
		System.out.println();
		System.out.println();
		System.out.println("Testing String Buffer from here onwards ");
		System.out.println();
		System.out.println();
		System.out.println();

		StringBuffer ex4 = new StringBuffer("Abdul Kalam");
		StringBuffer ex5 = new StringBuffer("Sathish");
		p(ex4);
		p(ex4.append(" is " + true));
		p(ex4.insert(5, " INSERTED"));
		// p(ex2);
		p(ex4.replace(5, 6, " RE-"));
		// p(ex2);
		p(ex4.delete(6, 9));
		// p(ex2);
		p(ex4.reverse());
		p(ex4.reverse());
		
		p(ex5.reverse());

	}

	private static void p(StringBuffer ex4) {
		System.out.println(ex4);
		System.out.println("Capacity is "+ex4.capacity());
		
	}

	private static void p(StringBuilder ex2) {
		System.out.println(ex2);
		System.out.println("Capacity is "+ex2.capacity());
	}

}
