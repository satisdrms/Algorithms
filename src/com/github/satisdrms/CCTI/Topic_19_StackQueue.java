package com.github.satisdrms.CCTI;

public class Topic_19_StackQueue {

	public static void main(String[] args) {
		Stackex stk = new Stackex();
		stk.push(1);
		stk.push(2);
		System.out.println(stk.pop().data);
		System.out.println(stk.pop().data);
		Queueex q = new Queueex();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("Queue is ");
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
		System.out.println(q.dequeue().data);
	}
}
