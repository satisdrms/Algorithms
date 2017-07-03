package com.github.satisdrms.CCTI;

public class Topic_19_LinkedList_EX2 {
	// Implement an algorithm to find the nth to last element of a singly linked
	// list.
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

		int n = 5;
		//findNthToLastElementUsingNodeCount(head, n);
		findNthToLastElementWithOutNodeCount(head, n);

	}

	private static void findNthToLastElementWithOutNodeCount(Node head, int n) {
		System.out.println("Printing Nth to Last Element Without HEAD COUNT");
		Node cur = head;
		if (head == null) {
			return;
		}
		for (int i = 0; i < n ; i++) {
			if(cur!=null){
			cur=cur.next;
			}else{
				return;//reached end of list
			}
		}
		Node nodetofind=head;
		while(cur!=null){
		//	System.out.println(cur.data);
			cur=cur.next;
			nodetofind=nodetofind.next;
		}
		System.out.println("Node is ");
		System.out.println(nodetofind.data);
	}

	private static void findNthToLastElementUsingNodeCount(Node head, int n) {
		//Not FULLY implemented using the cound nodes logic
		//But can be implemented easily
		System.out.println("Printing Nth to Last Element Using Count from Head Node");
		Node cur = head;
		int len = cur.countLength();
		for (int i = 0; i < len; i++) {
			if (i >= n) {
				System.out.println(cur.data);
			}
			cur = cur.next;
		}
	}

}
