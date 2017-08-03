package com.satisdrms.code.CTCI;

import java.util.ArrayList;

public class Stackex3 {
	ArrayList<SetStackNode> stackSet = new ArrayList<SetStackNode>();;
	int threshold = 10;
	int count = -1;
	int stacksize = -1;

	SetStackNode push(int d) {
		SetStackNode newTop = null, top = null;
		if (count < threshold && stacksize >=0) {
			newTop = new SetStackNode(d);
			top = stackSet.get(stacksize);
			newTop.next = top;
			top = newTop;
			stackSet.remove(stacksize);
			stackSet.add(stacksize, top);
			//System.out.println("in if "+stacksize+" count is "+(count+1)+" array size is "+stackSet.size());
		} else {
			count = -1;
			stacksize++;
			stackSet.add(stacksize, new SetStackNode(d));
			//System.out.println("in else "+stacksize+" count is "+(count+1)+" array size is "+stackSet.size());
		}
		count++;
		return top;
	}

	SetStackNode pop() {
		SetStackNode ret = null, newTop;

		if (stacksize >= 0) {
			if (count < 0) {
				System.out.println("removing "+stacksize);
				stackSet.remove(stacksize);
				stacksize--;
				count = threshold-1;
				ret = stackSet.get(stacksize);
				newTop = ret.next;
				stackSet.remove(stacksize);
				stackSet.add(stacksize, newTop);
				System.out.println("count in if is "+count+" stack is "+stacksize);
			} else {
				count--;
				ret = stackSet.get(stacksize);
				newTop = ret.next;
				stackSet.remove(stacksize);
				stackSet.add(stacksize, newTop);
				System.out.println("count in else is "+count+" stack is "+stacksize);
			}
			
			System.out.println("------ "+ret.data+" stack is "+stacksize);
		}
		return ret;
	}

	public int getCount() {
		return count;
	}
	void printArray(){
		System.out.println("------------Printing Start");
		for(SetStackNode s:stackSet){
			while(s!=null){
				System.out.println(s.data);
				s=s.next;
			}
		}
		System.out.println("------------Printing End");
	}

	public void popAt(int stackNum) {
		SetStackNode ret = null, newTop;
		if(stackNum<=stacksize){
			ret=stackSet.get(stackNum);
			newTop = ret.next;
			stackSet.remove(stacksize);
			stackSet.add(stacksize, newTop);
			System.out.println("POP AT IS------ "+ret.data+" stack is "+stacksize);
			if(stackNum+1<=stacksize){
				leftShift(stackNum,stackNum+1);
			}

		}
		
	}

	private void leftShift(int cur, int next) {
		SetStackNode n1,n2;
		n1=stackSet.get(cur);
		n1=stackSet.get(next);
		

		
	}



}
