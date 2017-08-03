package com.satisdrms.code.CTCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Imagine you have a call center with three levels of employees: fresher, technical lead (TL), product manager (PM). 
//There can be multiple employees, but only one TL or PM. An incoming telephone call must be allocated to a fresher who is free. 
//If a fresher can’t handle the call, he or she must escalate the call to technical lead. 
//If the TL is not free or not able to handle it, then the call should be escalated to PM. Design the classes and data structures for this problem. Implement a method getCallHandler().

class Call {
	int rank = 0;
}

class EmployeeOOD {
	boolean free;
	int level;

	EmployeeOOD(int level) {
		this.level = level;
	}

	public void receiveCall(Call call) {
		// TODO Auto-generated method stub

	}

	public void cannotHandleCall(Call call) {
		call.rank = level + 1;
		CallHandler callHandler = null;
		callHandler.dispatchCall(call);
		free = true;
		callHandler.getNextCall(this);
	}

}

class Freshers extends EmployeeOOD {

	Freshers(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}

}

class TechnicalLead extends EmployeeOOD {

	TechnicalLead(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}

}

class ProductManaget extends EmployeeOOD {

	ProductManaget(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}

}

class CallHandler {
	static final int LEVELS = 3;
	static final int NUM_FRESHERS = 10;
	ArrayList<EmployeeOOD>[] employessLevels = new ArrayList[NUM_FRESHERS];
	Queue<Call>[] callQueues = new LinkedList[LEVELS];

	EmployeeOOD getCallHanler(Call call) {
		for (int level = call.rank; level < LEVELS - 1; level++) {
			ArrayList<EmployeeOOD> e = employessLevels[level];
			for (EmployeeOOD emp : e)
				if (emp.free)
					return emp;
		}
		return null;
	}

	public void getNextCall(EmployeeOOD employee) {
		// TODO Auto-generated method stub

	}

	void dispatchCall(Call call) {
		EmployeeOOD e = getCallHanler(call);
		if (e != null)
			e.receiveCall(call);
		else
			callQueues[call.rank].add(call);

	}

	void getNextCall() {

	}

}

public class Topic_19_OOD_EX2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
