package com.satisdrms.code.CTCI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

class Parent {
	void msg() throws IOException {
		System.out.println("parent");
	}
}

class TestExceptionChild extends Parent {
	void msg() {
		System.out.println("TestExceptionChild");
	}
}

class Bank {
	float a = 0f;

	float getRateOfInterest() {
		return a;
	}
}

class SBI extends Bank {
	float a = 8.4f;

	float getRateOfInterest() {
		return a;
	}
}

class ICICI extends Bank {
	float a = 7.3f;

	float getRateOfInterest() {
		return a;
	}
}

class AXIS extends Bank {
	float a = 9.7f;

	float getRateOfInterest() {
		return a;
	}
}

public class Dummy {
	public static void main(String[] args) {
		String[] op = { "2", "push -4", "pop" };
		// superStack(op);
		/*
		 * int a = Integer.MAX_VALUE; System.out.println(a); Object a1 = null;
		 * System.out.println(a1);
		 */
		Bank b;
		b = new SBI();
		System.out.println("SBI Rate of Interest: " + b.getRateOfInterest());
		b = new ICICI();
		System.out.println("ICICI Rate of Interest: " + b.getRateOfInterest());
		b = new AXIS();
		System.out.println("AXIS Rate of Interest: " + b.getRateOfInterest());
		System.out.println(b.a);
		
		TreeMap a;
	}

	static void superStack(String[] operations) {
		ArrayList<Integer> stack = new ArrayList<Integer>();
		int size = 0;
		int length = Integer.parseInt(operations[0].trim());
		for (int i = 1; i < length; i++) {
			String[] oneOp = operations[i].split(" ");
			switch (oneOp[0]) {
			case "push":
				int element = Integer.parseInt(oneOp[1].trim());
				stack.add(size++, element);
				printStack(stack, size);
				break;
			case "pop":
				stack.remove(size--);
				printStack(stack, size);
				break;
			case "inc":
				int pos = Integer.parseInt(oneOp[1].trim());
				int inc = Integer.parseInt(oneOp[2].trim());
				int val = stack.get(pos);
				stack.set(pos, val + inc);
				printStack(stack, size);
				break;
			}

		}

	}

	static void printStack(ArrayList<Integer> stack, int size) {
		if (size == 0)
			System.out.println("EMPTY");
		else
			for (int i = 0; i < size; i++)
				System.out.println(stack.get(i));
	}
}
