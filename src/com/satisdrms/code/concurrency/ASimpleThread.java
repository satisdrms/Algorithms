package com.satisdrms.code.concurrency;

class thread extends Thread {
	public void run() {
		System.out.println("Thread is running");
	}
}

class thread2 implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread t2 is also running");

	}

}

public class ASimpleThread {

	public static void main(String[] args) {
		thread t = new thread();
		t.start();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread t1 is also running");

			}

		});
		t1.start();

		Thread t2 = new Thread(new thread2());
		t2.start();

		Runnable r3 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread t3 is also running");

			}

		};

		Thread t3 = new Thread(r3);
		t3.start();

		Thread t4 = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread t4 is also running");
			}
		};
		t4.start();
	}
}
