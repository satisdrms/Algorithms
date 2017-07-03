package pack1;

// Implement a MyQueue class which implements a queue using two stacks.
class MyQueue {
	Stackex stk1;
	Stackex stk2;

	MyQueue() {
		stk1 = new Stackex();
		stk2 = new Stackex();
	}

	void enQueue(int d) {
		while (stk1.peek() != null) {
			stk2.push(stk1.pop().data);
		}
		stk1.push(d);
	}

	void deQueue() {
		while (stk2.peek() != null) {
			stk1.push(stk2.pop().data);
		}
		if (stk1.peek() != null)
			System.out.println(stk1.pop().data);
	}
}

public class Topic_19_StackQueue_EX5 {

	public static void main(String[] args) {
		MyQueue q = new MyQueue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(3333);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.deQueue();
	}
}
