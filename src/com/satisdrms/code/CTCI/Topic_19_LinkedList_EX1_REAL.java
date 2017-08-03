package com.satisdrms.code.CTCI;

import java.util.HashSet;

public class Topic_19_LinkedList_EX1_REAL {
	// Write code to remove duplicates from an unsorted linked list.
	// FOLLOW UP
	// How would you solve this problem if a temporary buffer is not allowed?
	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(4);
		head.appendToTail(2);
		head.appendToTail(5);
		head.appendToTail(5);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(3);
		head.appendToTail(2);
		head.appendToTail(2);
		head.appendToTail(2);
		head.appendToTail(55);
		head.printFromHead();

		// removeDuplicates(head);
		removeDuplicatesWithOutTempBuffer(head);
		head.printFromHead();

	}

	private static void removeDuplicatesWithOutTempBuffer(Node head) {
		int[] arr = new int[head.countLength()];
		HashSet<Integer> dups = new HashSet<Integer>();
		Node cur = head;
		Node prev = head;
		Node subLoopNode = head;
		while (cur != null) {
			subLoopNode = cur.next;
			// System.out.println("Cur is "+cur.data);
			prev = cur;
			while (subLoopNode != null) {
				if (cur.data == subLoopNode.data) {
					prev.next = subLoopNode.next;
					subLoopNode = prev.next;
				} else {
					prev = subLoopNode;
					subLoopNode = subLoopNode.next;
				}

				// subLoopNode=subLoopNode.next;
			}
			cur = cur.next;
		}
	}

	private static void removeDuplicates(Node head) {
		int[] arr = new int[head.countLength()];
		HashSet<Integer> dups = new HashSet<Integer>();
		Node cur = head;
		Node prev = head;
		while (cur != null) {

			if (dups.contains(cur.data)) {
				// System.out.println(cur.data +
				// " is duplicate and removing it");
				prev.next = cur.next;
				cur = prev.next;

			} else {
				dups.add(cur.data);
				prev = cur;
				cur = cur.next;
				// System.out.println(cur.data + " is not duplicate");
			}
			// head.printFromHead();
		}
	}
}
