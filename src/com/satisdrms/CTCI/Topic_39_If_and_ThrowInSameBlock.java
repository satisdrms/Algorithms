package com.satisdrms.CTCI;

public class Topic_39_If_and_ThrowInSameBlock {

	public static void main(String[] args) {

		System.out.println(try_if_throw());

	}

	/**
	 * 
	 */
	private static String try_if_throw() {
		String Country = "India1";
		if (Country.equals("India")) {
			return "INR";
		} else if (Country.equals("USA")) {
			return "USD";
		}
		// System.out.println("Default");
		throw new IllegalArgumentException("No Such Country");

		// throws IllegalArgumentException
	}
}
