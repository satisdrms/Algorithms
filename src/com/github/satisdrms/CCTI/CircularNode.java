package com.github.satisdrms.CCTI;

public class CircularNode {

	CircularNode next = null;
	int data;
	boolean visited=false;

	CircularNode(int d) {
		data = d;
	}

	CircularNode appendToTail(int d) {
		CircularNode end = new CircularNode(d);
		CircularNode n = this;
		while (n.next != null)
			n = n.next;
		n.next = end;
		return end;
	}

	void deleteNode(int d) {
		CircularNode cur = this;
		CircularNode prev = this;
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
		CircularNode n = this;
		System.out.println("Head is " + n.data);
		while (n.next != null) {
			n = n.next;
			System.out.println(n.data);
		}
	}

	int countLength() {
		CircularNode n = this;
		int count = 1;
		while (n.next != null) {
			n = n.next;
			count++;
		}
		return count;

	}

}
