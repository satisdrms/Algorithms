package com.satisdrms.CTCI;

class Topic_19_LinkedList_EX4 {
	// You have two numbers represented by a linked list, where each node
	// contains a single digit. The digits are stored in reverse order, such
	// that the 1’s digit is at the head of the list. Write a function that adds
	// the two numbers and returns the sum as a linked list.
	// EXAMPLE
	// Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
	// Output: 8 -> 0 -> 8

	public static void main(String[] args) {
		System.out.println();
		Node num1 = new Node(1);
		num1.appendToTail(3);
		num1.appendToTail(9);
		num1.appendToTail(8);
		num1.appendToTail(8);
		num1.printFromHead();

		Node num2 = new Node(3);
		num2.appendToTail(5);
		num2.appendToTail(6);
		num2.appendToTail(4);
		num2.appendToTail(3);
		num2.printFromHead();

		Node num3 = null;

		num3 = add(num1, num2);
		 num3.printFromHead();
	}

	private static Node add(Node num1, Node num2) {
		System.out.println("Sum is ");
		Node sum = new Node(0);
		int n1 = 0, n2 = 0, ones = 0, tens = 0;
		while (num1 != null || num2 != null) {
			//ones = 0;
			//tens = 0;

			if (num1 != null) {
				n1 = num1.data;
				num1 = num1.next;
				// System.out.println("num1 is " + num1.data);
			} else
				n1 = 0;
			if (num2 != null) {
				n2 = num2.data;
				num2 = num2.next;
				// System.out.println("num2 is " + num2.data);
			} else
				n2 = 0;
			int ad = n1 + n2 + tens;
			tens = 0;
			ones = 0;
			if (ad > 10) {
				ones = ad % 10;
				tens = (ad - ones) / 10;
			} else {
				ones = ad;
				tens = 0;
			}

			System.out.println("ad is " + ad + " ones is " + ones + " tens is "
					+ tens);

			sum.appendToTail(ones);
		}	sum.appendToTail(tens);

		return sum;

	}
}
