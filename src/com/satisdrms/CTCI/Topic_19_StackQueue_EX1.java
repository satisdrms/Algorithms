package com.satisdrms.CTCI;

class stackarray {

	int head1;// starts with 1 add 3 on every increment
	int head2;// starts with 2 add 3 on every increment
	int head3;// starts with 3 add 3 on every increment
	int[] head = { 0, 0, 0, 0 };
	int[] stk;

	stackarray(int n) {
		head1 = head2 = head3 = 0;
		stk = new int[n];
	}

	public void push(int stacknum, int d) {
		int curhead = head[stacknum];
		// getStackHead(stacknum);
		if (curhead == 0) {
			curhead = stacknum;
		} else {
			curhead = curhead + 3;
		}
		stk[curhead] = d;
		// setStackHead(stacknum, curhead);
		head[stacknum] = curhead;
	}

	public void pop(int stacknum) {
		int curhead = head[stacknum];
		// getStackHead(stacknum);
		if (curhead - 1 >= 0) {
			System.out.println(stk[curhead]);
			curhead -= 3;
		} else {
			System.out.println("Stack " + stacknum + " is empty "
					+ (curhead - 3));
		}
		head[stacknum] = curhead;

		// setStackHead(stacknum, curhead);

	}

	private void setStackHead(int stacknum, int curhead) {
		switch (stacknum) {
		case 1:
			head1 = curhead;
			break;
		case 2:
			head2 = curhead;
			break;
		case 3:
			head3 = curhead;
			break;
		}

	}

	/**
	 * @param stacknum
	 * @return
	 */
	private int getStackHead(int stacknum) {
		int curhead = 0;
		switch (stacknum) {
		case 1:
			curhead = head1;
			break;
		case 2:
			curhead = head2;
			break;
		case 3:
			curhead = head3;
			break;
		}
		return curhead;
	}

}

class stackArrayBook {

	int stackSize = 4;
	int[] stk = new int[stackSize * 3];
	int head[] = { (stackSize * 0) - 1, (stackSize * 1) - 1,
			(stackSize * 2) - 1 };

	void push(int stackNum, int d) {
		int curhead = head[stackNum];

		if ((curhead + 1) < ((stackNum + 1) * stackSize)) {
			stk[++curhead] = d;
			// System.out.println(stackNum+" "+curhead);
		}
		head[stackNum] = curhead;

	}

	void pop(int stackNum) {
		int curhead = head[stackNum];
		if (curhead >= (stackNum * stackSize)) {
			System.out.println(stk[curhead--]);
			head[stackNum] = curhead;
		}

	}

	void peek(int stackNum) {

	}

	void debugPrint() {
		for (int i = 0; i < stk.length; i++)
			if (stk[i] != 0)
				System.out.println(stk[i] + " " + i);
	}

}
class stackNodeI{
	int previous,next;
	int d;
}

class stackArrayBookPointers {

	int stackSize = 4;
	int[] stk = new int[stackSize * 3];
	//int head[] = { (stackSize * 0) - 1, (stackSize * 1) - 1,(stackSize * 2) - 1 };

	void push(int stackNum, int d) {

	}

	void pop(int stackNum) {

	}

	void peek(int stackNum) {

	}

	void debugPrint() {
		for (int i = 0; i < stk.length; i++)
			if (stk[i] != 0)
				System.out.println(stk[i] + " " + i);
	}

}

public class Topic_19_StackQueue_EX1 {
	// Describe how you could use a single array to implement three stacks.

	public static void main(String[] args) {
		// callMyStackLogic();
		callBookStackLogic();
	}

	private static void callBookStackLogic() {
		stackArrayBook stkObj = new stackArrayBook();
		stkObj.push(0, 1);
		stkObj.push(0, 2);
		stkObj.push(0, 3);
		stkObj.push(0, 4);

		stkObj.push(1, 11);
		stkObj.push(1, 22);
		stkObj.push(1, 33);
		stkObj.push(1, 44);

		stkObj.push(2, 111);
		stkObj.push(2, 222);
		stkObj.push(2, 333);
		stkObj.push(2, 444);

		stkObj.debugPrint();

		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);

		stkObj.push(0, 1);
		stkObj.push(0, 2);
		stkObj.push(0, 3);
		stkObj.push(0, 4);

		stkObj.push(1, 11);
		stkObj.push(1, 22);
		stkObj.push(1, 33);
		stkObj.push(1, 44);

		stkObj.push(2, 111);
		stkObj.push(2, 222);
		stkObj.push(2, 333);
		stkObj.push(2, 444);

		stkObj.debugPrint();

		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);
		stkObj.pop(0);
	}

	/**
	 * 
	 */
	private static void callMyStackLogic() {
		stackarray stkObj = new stackarray(100);
		stkObj.push(1, 1);
		stkObj.push(1, 2);
		stkObj.push(1, 3);

		stkObj.push(2, 11);
		stkObj.push(2, 22);
		stkObj.push(2, 33);

		stkObj.push(3, 111);
		stkObj.push(3, 222);
		stkObj.push(3, 333);

		stkObj.pop(3);
		stkObj.pop(3);
		stkObj.pop(3);
		stkObj.pop(3);
		stkObj.pop(3);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(2);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
		stkObj.pop(1);
	}
}
