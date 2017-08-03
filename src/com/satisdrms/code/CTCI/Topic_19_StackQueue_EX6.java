package com.satisdrms.code.CTCI;

//Write a program to sort a stack in ascending order. 
//You should not make any assumptions about how the stack is implemented. 
//The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.

class sortStack {
	Stackex stk = new Stackex();
	Stackex buffer = new Stackex();
	Stackex fin = new Stackex();

	sortStack(int[] a) {
		for (int i = 0; i < a.length; i++)
			stk.push(a[i]);
	}

	public void sort() {
		sort(stk);
		while (buffer.peek() != null) {
			fin.push(buffer.pop().data);
		}

	}

	public void sort(Stackex stk) {
		while (stk.peek() != null) {
			while (fin.peek() != null && fin.peek().data <= stk.peek().data) {
				buffer.push(fin.pop().data);
				//printStk();
			}
			while (buffer.peek() != null && buffer.peek().data > stk.peek().data) {
				fin.push(buffer.pop().data);
				//printStk();
			}
			fin.push(stk.pop().data);
			//printStk();
		}
	}

	public void printStk() {
		System.out.println("Initial stack is ");
		stk.printAll();
		System.out.println("Buffer stack is ");
		buffer.printAll();
		System.out.println("Final stack is ");
		fin.printAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class Topic_19_StackQueue_EX6 {
	public static void main(String[] args) {
		int[] a = { 6, 3, 9, 1, 2 };
		sortStack sstk = new sortStack(a);
		sstk.sort();
		sstk.printStk();

	}
}
