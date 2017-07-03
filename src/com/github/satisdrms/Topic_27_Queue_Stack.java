package com.github.satisdrms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topic_27_Queue_Stack {

	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<Integer>();

		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);

		LinkedList<Integer> stack = new LinkedList<Integer>(queue);

		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.removeLast());
		}

		stack.add(1);
		stack.add(2);
		System.out.println(stack.removeLast());
		stack.add(3);
		stack.add(4);
		System.out.println(stack.removeLast());
		stack.add(5);
		System.out.println(stack.removeLast());
		System.out.println(stack.removeLast());
		System.out.println(stack.removeLast());
		// System.out.println(stack.removeLast());

		Stack<Integer> stk = new Stack<Integer>();
		stk.add(11);
		stk.add(12);
		stk.add(13);
		stk.add(14);

		stk.add(312);

		stk.add(15);
		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
		// Queue<Integer> que = new Queue<Integer>();
		// stk.add(11);
		// stk.add(12);
		// stk.add(13);
		// stk.add(14);
		//
		// stk.add(312);
		//
		// stk.add(15);
		// while (!stk.isEmpty()) {
		// System.out.println(stk.pop());
		// }

	}

}
