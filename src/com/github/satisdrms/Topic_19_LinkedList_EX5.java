package com.github.satisdrms;

public class Topic_19_LinkedList_EX5 {
	// Given a circular linked list, implement an algorithm which returns node
	// at the beginning of the loop.
	// DEFINITION
	// Circular linked list: A (corrupt) linked list in which a node’s next
	// pointer points to an earlier node, so as to make a loop in the linked
	// list.
	// EXAMPLE
	// input: A -> B -> C -> D -> E -> C [the same C as earlier]
	// output: C
	public static void main(String[] args) {

		// nodeBeginningOfLoop();
		nodeBeginningOfLoopNoFlag();
	}

	private static void nodeBeginningOfLoopNoFlag() {
		// Using a flag in the node itself
		CircularNode num1 = new CircularNode(1);
		num1.appendToTail(2);
		num1.appendToTail(22);
		num1.appendToTail(44);
		CircularNode three = num1.appendToTail(3);
		num1.appendToTail(4);
		CircularNode five = num1.appendToTail(5);
		five.next = three;
		CircularNode p1 = num1.next;
		CircularNode p2 = num1.next.next;

		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		while (p1.hashCode() != p2.hashCode()) {
			// System.out.println(p1.data + " " + p2.data);
			p1 = p1.next;
			p2 = p2.next.next;
		}
		System.out.println("Meeting node is " + p1.data);

		p1 = num1;

		while (p1.hashCode() != p2.hashCode()) {
			p1 = p1.next;
			p2 = p2.next;
		}

		System.out.println("Beginning node in loop is " + p1.data);

	}

	private static void nodeBeginningOfLoop() {
		// Using a flag in the node itself
		CircularNode num1 = new CircularNode(1);
		num1.appendToTail(2);
		CircularNode three = num1.appendToTail(3);
		num1.appendToTail(4);
		CircularNode five = num1.appendToTail(5);
		five.next = three;
		CircularNode p1 = num1;
		CircularNode p2 = num1;

		while (!p1.visited) {
			System.out.println(p1.data);
			p1.visited = true;
			p1 = p1.next;

		}
		System.out.println("Beginning node is " + p1.data);

	}

}
