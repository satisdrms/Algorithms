package com.satisdrms.code.CTCI;

public class Stackex {
	StackNode top = null;

	StackNode push(int d) {

		if (top == null) {
			top = new StackNode(d, 0);
		} else {
			StackNode newTop = new StackNode(d, 0);
			newTop.next = top;
			top = newTop;
		}
		return top;
	}

	StackNode pop() {
		StackNode ret;
		if (top == null)
			return null;// Stack Empty
		else {
			ret = top;
			top = top.next;
		}
		return ret;

	}

	StackNode peek() {
		StackNode ret;
		if (top == null)
			return null;// Stack Empty
		else {
			ret = top;
			return ret;
		}

	}

	public void printAll() {
		if(top!=null){
			StackNode n=top;
			while(n!=null){
				System.out.println(n.data);
				n=n.next;
			}
		}
		
	}

}
