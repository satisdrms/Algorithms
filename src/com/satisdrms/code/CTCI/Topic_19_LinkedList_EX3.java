package com.satisdrms.code.CTCI;

public class Topic_19_LinkedList_EX3 {
	// Implement an algorithm to delete a node in the middle of a single linked
	// list, given only access to that node.
	// EXAMPLE
	// Input: the node ‘c’ from the linked list a->b->c->d->e
	// Result: nothing is returned, but the new linked list looks like
	// a->b->d->e

	public static void main(String[] args) {
		Node head = new Node(11);
		head.appendToTail(22);
		head.appendToTail(33);
		head.appendToTail(44);
		head.appendToTail(55);
		head.appendToTail(36);
		head.appendToTail(27);
		head.appendToTail(48);
		head.appendToTail(29);
		head.appendToTail(50);
		head.appendToTail(51);
		head.appendToTail(52);
		head.appendToTail(63);
		head.appendToTail(34);
		head.appendToTail(25);
		head.appendToTail(26);
		head.appendToTail(27);
		head.appendToTail(585);

		head.printFromHead();
		Node del = getNode(50, head);
		System.out.println("found node is " + del.data);
		deletenode(del);
		head.printFromHead();
		del = getNode(27, head);
		System.out.println("found node is " + del.data);
		deletenode(del);
		head.printFromHead();
		
	}

	private static void deletenode(Node del) {
		Node next = del.next;
		Node prev = del;
		while (del != null) {
			if (del.next != null) {
				del.data = next.data;
				prev = del;
				del = del.next;
				next = del.next;
			} else {
				prev.next = null;
				prev = del;
				del = del.next;
			}
		}

	}

	private static Node getNode(int d, Node node) {
		Node n = node;
		Node find = null;
		while (n != null) {
			if (n.data == d) {
				find = n;
			}
			n = n.next;
		}
		return find;
	}
}
