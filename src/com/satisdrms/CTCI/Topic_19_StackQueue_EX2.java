package com.satisdrms.CTCI;

public class Topic_19_StackQueue_EX2 {
	// How would you design a stack which, in addition to push and pop, also has
	// a function min which returns the minimum element? Push, pop and min
	// should all operate in O(1) time.
	public static void main(String[] args) {

		Stackex2 stk = new Stackex2();
		Stackex2 minstk = new Stackex2();

		stkpush(stk, minstk, 11);
		stkpush(stk, minstk, 12);
		stkpush(stk, minstk, 3);
		stkpush(stk, minstk, 2);
		stkpush(stk, minstk, 9);
		//stkpush(stk, minstk, 1);
		stkpop(stk, minstk);
		stkpop(stk, minstk);
		stkpop(stk, minstk);
		stkpop(stk, minstk);
		stkpop(stk, minstk);
		stkpop(stk, minstk);//CALLS TO CHECK EMPTY STACK
		stkpop(stk, minstk);//CALLS TO CHECK EMPTY STACK
//		System.out.println(stk.pop().min);
//		System.out.println(stk.pop().min);
//		System.out.println(stk.pop().min);
//		System.out.println(stk.pop().min);

		// System.out.println(stk.pop().data);
		// System.out.println(stk.pop().data);
		// System.out.println(stk.pop().data);

		// HashSet<Integer> hs=new HashSet<Integer>();
		// hs.add(11);hs.add(2);hs.add(32);
		// SortedSet<Integer> ss=new TreeSet<Integer>();
		// ss.add(11);ss.add(2);ss.add(32);ss.add(32);
		// System.out.println(ss.first());ss.remove(ss.first());
		// System.out.println(ss.first());ss.remove(ss.first());
		// System.out.println(ss.first());ss.remove(ss.first());
		// System.out.println(ss.size());

	}

	private static void stkpop(Stackex2 stk, Stackex2 minstk) {
		if (stk.peek() != null) {
			if (stk.peek().data == minstk.peek().data) {
				System.out.println("min is "+minstk.pop().data);
				stk.pop();
			}else{
				System.out.println("min is "+minstk.peek().data);
				stk.pop();
			}
		}
	}

	private static void stkpush(Stackex2 stk, Stackex2 minstk, int d) {
		System.out.println("Pushing " + d);
		stk.push(d);
		if (minstk.peek() == null) {
			minstk.push(d);
		} else {
			if (minstk.peek().data > d)
				minstk.push(d);
		}

	}

}
