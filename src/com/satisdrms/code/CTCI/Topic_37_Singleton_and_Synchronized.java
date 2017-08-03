package com.satisdrms.code.CTCI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class singletonTest {
	private static singletonTest obj;
	int count = 0;

	private singletonTest() {
		System.out.println("Constructor one");

	}

	private singletonTest(int i) {
		System.out.println("Constructor two");
	}

	// OPTION ONE
	synchronized public static singletonTest getInstance() {
		if (obj == null) {
			obj = new singletonTest();
		}
		return obj;
	}

	// OPTION TWO
	public static singletonTest getInstance_block() {
		if (obj == null) {
			synchronized (singletonTest.class) {
				if (obj == null) {
					obj = new singletonTest();
				}
			}
		}
		return obj;
	}

	// OPTION THREE

	private static class BillPughSingletonHelper {
		private static singletonTest singletonInstance = new singletonTest();
	}

	private static singletonTest getInstance_BillPUGH() {
		return BillPughSingletonHelper.singletonInstance;
	}

	// OPTION FOUR

	public void countcalls() {
		System.out.println("Printing a single object for " + ++count + " time");
	}

}

public class Topic_37_Singleton_and_Synchronized {

	public static void main(String[] args) {
		// singletonTest a=new singletonTest();
		singletonTest a = singletonTest.getInstance();
		a.countcalls();
		singletonTest b = singletonTest.getInstance();
		b.countcalls();
		Constructor c;
		try {
			c = singletonTest.class.getDeclaredConstructor();
			c.setAccessible(true);
			try {
				c.newInstance();
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}