package com.satisdrms.CCTI;

import java.util.Comparator;

//class printdata { 
//   synchronized void print(int n) { 
//       for (int i = 0; i <= 5; i++) { 
//           System.out.println(i * n); 
//           try { 
//               Thread.sleep(1000); 
//           } catch (InterruptedException e) { 
//               // TODO Auto-generated catch block 
//               e.printStackTrace(); 
//           } 
//       } 
//   } 
//} 
class printdata {
	int i;

	void print(int n) {
		synchronized (this) {
			for (int i = 0; i <= 5; i++) {
				System.out.println(i * n);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class myThread1 extends Thread {
	printdata p;

	myThread1(Object o) {
		p = (printdata) o;
	}

	public void run() {
		p.print(5);
	}
}

class myThread2 extends Thread {
	printdata p;

	myThread2(Object o) {
		p = (printdata) o;
	}

	public void run() {
		p.print(100);
	}
}

public class Topic_36_Singleton_Class {

	public static void main(String[] args) {
		printdata p = new printdata();
		myThread1 my1 = new myThread1(p);
		myThread2 my2 = new myThread2(p);
		my1.start();
		my2.start();
		class testcomparator implements Comparator<printdata> {
			public int compare(printdata a, printdata b) {
				return a.i - b.i;
			}

		}
		// my1.start(); --this is also error as the thread id alread started and
		// this will throw illegal state exception
		// The below are error as run doesnt create new thread
		my1.run();
		my2.run();

		Thread t1 = new Thread(new myThread1(p));
		t1.start();
		Thread t2 = new Thread(new Thread() {
			public void run() {
				System.out.println("In anonymous thread class");
			}
		});
		t2.start();
		Thread t3 = new Thread() {
			public void run() {
				System.out.println("In anonymous thread class");
			}
		};

		Runnable t4 = new Runnable() {
			public void run() {
				System.out.println("In the runnable thread");
			}
		};
		Thread t5 = new Thread(t4);
		t5.start();

		
	}
}