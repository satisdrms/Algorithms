package com.github.satisdrms;

public class Node {

	Node next = null;
	int data;

	Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
	}

	void deleteNode(int d) {
		Node cur = this;
		Node prev = this;
		// Node next = this;
		while (cur.next != null) {
			if (cur.data == d) {
				prev.next = cur.next;
				return;
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
	}

	void printFromHead() {
		Node n = this;
		System.out.println("Head is " + n.data);
		while (n.next != null) {
			n = n.next;
			System.out.println(n.data);
		}
	}

	int countLength() {
		Node n = this;
		int count = 1;
		while (n.next != null) {
			n = n.next;
			count++;
		}
		return count;

	}

}
