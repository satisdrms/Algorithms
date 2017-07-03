package com.github.satisdrms;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class foo {
	static Semaphore semaphore_a = new Semaphore(0);
	static Semaphore semaphore_b = new Semaphore(0);
	static Semaphore semaphore_c = new Semaphore(1);

	void a() {

		Thread a = new Thread(new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
					semaphore_c.acquire();

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("test a");
				semaphore_a.release();
			}
		});
		a.start();

	}

	void b() {

		Thread b = new Thread(new Thread() {
			public void run() {

				try {
					semaphore_a.acquire();
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("test b");
				semaphore_b.release();

			}
		});
		b.start();
	}

	void c() {

		Thread c = new Thread(new Thread() {
			public void run() {

				try {
					semaphore_b.acquire();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("test c");
				semaphore_c.release();

			}
		});
		c.start();

	}
}

class producer extends Thread {
	Semaphore semaphore, mutex;

	public producer(Semaphore semaphore, Semaphore mutex) {
		this.semaphore = semaphore;
		this.mutex = mutex;
	}

	public void run() {
		try {
			// while (true) {

			mutex.acquire();
			mutex.release();

			semaphore.release();
			// Thread.sleep(5000);

			// }
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class consumer extends Thread {
	Semaphore semaphore, mutex;
	static LinkedList<String> ll = new LinkedList<String>();

	public consumer(Semaphore semaphore, Semaphore mutex) {
		this.semaphore = semaphore;
		this.mutex = mutex;
	}

	public void run() {

		try {
			semaphore.acquire();
			mutex.acquire();
			ll.add(Thread.currentThread().getName());
			for (String s : ll) {
				System.out.println(s);
			}
			mutex.release();
			semaphore.release();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class waitNotify extends Thread {
	String s;
	static Integer counter = 500;
	static Object obj = new Object();
	static Semaphore semaphore = new Semaphore(1);
	static Lock lock = new ReentrantLock();

	public waitNotify(String s) {
		this.s = s;
	}

	public void run_withSynchronized() {
		synchronized (obj) {
			while (true) {
				System.out.println("printing the counter by " + s + " for "
						+ counter++ + "th time--" + (counter % 5) + "   ");
				try {
					Thread.sleep(1000);
					if (counter % 5 == 0) {
						// Thread.currentThread().wait();
						obj.notifyAll();

						obj.wait();
					}
					// Thread.currentThread().notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public void run() {
		try {
			while (lock.tryLock(11, TimeUnit.SECONDS)) {
				while (true) {
					System.out.println("printing the counter by " + s + " for "
							+ counter++ + "th time--" + (counter % 5) + "   ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (counter % 5 == 0) {
						lock.unlock();
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					}
				}
				//------------------ALSO WORKING SOLUTION
				// while (counter++ % 5 != 0) {
				// System.out.println("printing the counter by " + s + " for "
				// + counter + "th time--" + (counter % 5) + "   ");
				// try {
				// Thread.sleep(1000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				// // if (counter % 5 == 0) {
				// // lock.unlock();
				// // break;
				// // }
				// }
				// lock.unlock();
				// try {
				// Thread.sleep(10000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
			}
			System.out.println(s + " looping out since lock not available");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class Topic_19_ThreadsLocks_EX5 {

	public static void main(String[] args) {
		// Semaphore a = new Semaphore(1);
		Semaphore semaphore = new Semaphore(0);
		Semaphore mutex = new Semaphore(1);
		producer p = new producer(semaphore, mutex);
		p.start();
		consumer c1 = new consumer(semaphore, mutex);
		c1.start();
		consumer c2 = new consumer(semaphore, mutex);
		c2.start();
		consumer c3 = new consumer(semaphore, mutex);
		c3.start();

		foo f = new foo();
		f.a();
		f.b();
		f.c();
		f.a();
		f.b();
		f.c();

		waitNotify dog = new waitNotify("dog");
		dog.start();
		waitNotify lion = new waitNotify("lion");
		lion.start();
		waitNotify platypus = new waitNotify("platypus");
		platypus.start();
	}

}
