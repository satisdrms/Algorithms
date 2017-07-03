package com.satisdrms.CCTI;

// Imagine a (literal) stack of plates. If the stack gets too high, it might
// topple. Therefore, in real life, we would likely start a new stack when
// the previous stack exceeds some threshold. Implement a data structure
// SetOfStacks that mimics this. SetOfStacks should be composed of several
// stacks, and should create a new stack once the previous one exceeds
// capacity. SetOfStacks.push() and SetOfStacks.pop() should behave
// identically to a single stack (that is, pop() should return the same
// values as it would if there were just a single stack).
// FOLLOW UP
// Implement a function popAt(int index) which performs a pop operation on a
// specific sub-stack.



//CONCLUSION
//TRACKING THRESHOLD WONT WORK AS WE
import java.util.ArrayList;


public class Topic_19_StackQueue_EX3_BookSolutionYetToBeWorked {
	public static void main(String[] args) {
		Stackex3 sstk = new Stackex3();
		sstk.push(1);
		sstk.push(2);
		sstk.push(3);
		sstk.push(4);
		sstk.push(5);
		sstk.push(6);
		sstk.push(7);
		sstk.push(8);
		sstk.push(9);
		sstk.push(10);
		sstk.push(11);
		sstk.push(12);
		
		sstk.printArray();
		
		sstk.popAt(0);
		
		sstk.pop();sstk.pop();sstk.pop();sstk.pop();sstk.pop();
		sstk.pop();sstk.pop();sstk.pop();sstk.pop();sstk.pop();
		sstk.pop();sstk.pop();sstk.pop();sstk.pop();sstk.pop();


	}
}
