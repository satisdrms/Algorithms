package com.satisdrms.CCTI;

public class Queueex {
	QueueNode first, last;

	Queueex() {
		first = null;
		last = null;
	}

	void enqueue(int d) {
		if (first == null && last == null) {
			QueueNode q1 = new QueueNode(d);
			first = q1;
			last = q1;
		} else {
			QueueNode q1 = new QueueNode(d);
			last.next = q1;
			last = q1;
		}
	}

	QueueNode dequeue() {
		if (first != null) {
			QueueNode q = null;
			q = first;
			first = first.next;
			if (first == null) {
				last = null;
			}
			return q;
		} else {
			return null;
		}
	}
}
