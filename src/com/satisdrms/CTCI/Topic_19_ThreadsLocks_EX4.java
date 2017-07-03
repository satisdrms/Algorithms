package com.satisdrms.CTCI;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import javax.annotation.Resource;

//Design a class which provides a lock only if there are no possible deadlocks.

class waitDie extends Thread {
	String s;
	int p;
	private static int counter = 0;
	private static String aString = "ScapeGoatForTesting";
	static final Lock lock = new ReentrantLock();

	waitDie(String s) {
		this.s = s;
		p = counter++;

	}

	public void run_UsingSynChronized() {
		synchronized (aString) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Printing common String " + aString + " by "
						+ s + " with priority " + p);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// this.stop();

			}
		}
	}

	public void run() {

		// if (lock.tryLock()) {
		try {
			if (lock.tryLock(6, TimeUnit.SECONDS)) {
				for (int i = 0; i < 5; i++) {
					System.out.println("Printing common String " + aString
							+ " by " + s + " with priority " + p);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// this.stop();
				}
				lock.unlock();
			} else {
				System.out.println("Already locked and skipping for "+s);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Topic_19_ThreadsLocks_EX4 {

	public static void main(String[] args) {
		// Resource a=new Resource();

		waitDie a = new waitDie("a");
		a.start();

		waitDie b = new waitDie("b");
		b.start();

		waitDie c = new waitDie("c");
		c.start();

	}

}
