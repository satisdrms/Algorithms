package com.satisdrms.code.CTCI;

import java.util.ArrayList;

public class HanoiSetOfStacks {
	ArrayList<HanoiStack> stacksSet = new ArrayList<HanoiStack>();
	int towers = 3;
	int hDisks;

	public HanoiSetOfStacks(int disks) {
		hDisks = disks;
	}

	public void initialSetUp() {
		for (int j = 0; j < towers; j++) {
			// CAPACITY == DISK WEIGHT FOR HANOI TOWERS
			for (int i = hDisks; i > 0; i--) {
				push(hDisks);

			}
		}
	}

	void push(int diskWeight) {
		HanoiStack stk = getLastStack(), newstk;
		if (stk == null) {
			stk = new HanoiStack();
			stk.push(diskWeight);
			stacksSet.add(stk);
		} else {
			if (stk.capacity == hDisks) {// stack is full create new stack
				newstk = new HanoiStack();
				newstk.push(diskWeight);
				stacksSet.add(newstk);
			} else {
				stk.push(diskWeight);
			}
		}
		// stk.push(diskWeight);

	}

	private HanoiStack getLastStack() {
		if (stacksSet.size() == 0)
			return null;
		else
			return stacksSet.get(stacksSet.size() - 1);

	}

	private HanoiStack getStack(int stackNum) {
		if (stackNum <= stacksSet.size())
			return stacksSet.get(stackNum);
		else
			return null;

	}

	void printAll() {

		System.out.println("------------Printing Start and Size is " + stacksSet.size());
		for (int i = 0; i < stacksSet.size(); i++) {
			System.out.println("stack is " + i);
			stacksSet.get(i).printall();
		}
		System.out.println("------------Printing End");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void pop() {
		HanoiStack stk = getLastStack();
		int weight;
		if (stk != null) {
			// System.out.println(stacksSet.size());
			weight = stk.pop();
			if (stk.capacity == 0) {
				// System.out.println(stacksSet.size());
				stacksSet.remove(stacksSet.size() - 1);

			}
		}
	}

	public void popAt(int stackNum) {
		if (stackNum <= stacksSet.size())
			popAndShiftLeft(stackNum - 1, true);

	}

	private HanoiStackNode popAndShiftLeft(int stackNum, boolean popOrShift) {
		HanoiStackNode shift = null;
		if (popOrShift) {
			HanoiStack stk = stacksSet.get(stackNum);
			stk.pop();
			if (stackNum <= stacksSet.size()) {
				shift = popAndShiftLeft(stackNum + 1, false);
				if (shift != null) {
					stk.push(shift.weight);
					// System.out.println(shift.weight);
				}
			}
		} else {
			if (stackNum < stacksSet.size()) {
				HanoiStack stk = stacksSet.get(stackNum);
				shift = popAndShiftLeft(stackNum + 1, false);
				// System.out.println(shift.weight);
				if (shift != null) {
					stk.push(shift.weight);
					System.out.println(shift.weight);
				}
				HanoiStackNode hsk = stk.getBottom();
				return hsk;
			}
		}
		return null;
	}

	class setOfDisks {
		int start;
		int end;
		int tower;

		public setOfDisks(int start, int end, int tower) {
			this.start = start;
			this.end = end;
			this.tower = tower;
		}
	}

	private void initTowers(int disks) {
		stacksSet = new ArrayList<HanoiStack>(3);
		// Initializing Three towers for HANOI
		stacksSet.add(new HanoiStack());
		stacksSet.add(new HanoiStack());
		stacksSet.add(new HanoiStack());
		// PUSHING THE DISKS
		for (int i = disks; i >= 1; i--) {
			stacksSet.get(0).push(i);
			// System.out.println(stacksSet.size());
			// System.out.println(stacksSet.get(0).capacity);
		}
	}

	public void hanoiTowers(int disks) {
		initTowers(disks);
		int set = disks - 2;
		int fromTower = 0;
		int toTower = 2;
		moveThreeSets(set, fromTower, toTower);
		// printAll();

	}

	private void moveThreeSets(int set, int fromTower, int toTower) {

		int otherTower = 3 - (fromTower + toTower);
		HanoiStack fromStack = stacksSet.get(fromTower);
		HanoiStack toStack = stacksSet.get(toTower);
		HanoiStack otherStack = stacksSet.get(otherTower);
		int a = 0;
		if (set > 1) {
			moveThreeSets(set - 2, fromTower, toTower); // printAll();
		} else {
			a = fromStack.pop();
			toStack.push(a);// printAll();
		}
		a = fromStack.pop();
		otherStack.push(a);// printAll();
		if (set > 1) {
			moveThreeSets(set - 2, toTower, otherTower); // printAll();
		} else {
			a = toStack.pop();
			otherStack.push(a);// printAll();
		}
		a = fromStack.pop();
		toStack.push(a);// printAll();
		if (set > 1) {
			moveThreeSets(set - 2, otherTower, fromTower); // printAll();
		} else {
			a = otherStack.pop();
			fromStack.push(a);// printAll();
		}
		a = otherStack.pop();
		toStack.push(a);// printAll();
		if (set > 1) {
			moveThreeSets(set - 2, fromTower, toTower); // printAll();
		} else {
			a = fromStack.pop();
			toStack.push(a);// printAll();
		}
		printAll();
	}

	public void hanoiBookSol(int disks) {
		initTowers(disks);
		hanoiSolveBook(disks, 0, 1, 2);
	}

	private void hanoiSolveBook(int d, int from, int to, int buffer) {
		if (d > 0) {
			hanoiSolveBook(d - 1, from, buffer, to);
			moveTopTo(from, to);printAll();
			hanoiSolveBook(d - 1, buffer, to, from);
			//printAll();
		}

	}

	private void moveTopTo(int from, int to) {
		HanoiStack fromStack = stacksSet.get(from);
		HanoiStack toStack = stacksSet.get(to);
		int a = fromStack.pop();
		toStack.push(a);
	}

}
