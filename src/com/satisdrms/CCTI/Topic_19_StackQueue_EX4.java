package com.satisdrms.CCTI;

//In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different 
//sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order 
//of size from top to bottom (e.g., each disk sits on top of an even larger one). 
//You have the following constraints:
//(A) Only one disk can be moved at a time.
//(B) A disk is slid off the top of one rod onto the next rod.
//(C) A disk can only be placed on top of a larger disk.
//Write a program to move the disks from the first rod to the last using Stacks.

public class Topic_19_StackQueue_EX4 {

	public static void main(String[] args) {
		System.out.println();
		int disks = 10;
		HanoiSetOfStacks hss = new HanoiSetOfStacks(disks);
		//testingGeneralStacks(hss);
		hanoiShuffle(disks, hss);
	}

	/**
	 * @param disks
	 * @param hss
	 */
	private static void hanoiShuffle(int disks, HanoiSetOfStacks hss) {
		//hss.hanoiTowers(disks);
		hss.hanoiBookSol(disks);
		hss.printAll();
	}

	/**
	 * @param hss
	 */
	private static void testingGeneralStacks(HanoiSetOfStacks hss) {
		// hss.initialSetUp();
		hss.push(1);
		hss.push(2);
		hss.push(3);
		hss.push(4);
		hss.push(5);
		hss.push(6);
		hss.push(7);
		hss.push(8);

		// hss.pop();
		// hss.pop();
		// hss.pop();
		hss.popAt(2);
		hss.pop();
		hss.pop();
		//hss.printAll();
	}

}
