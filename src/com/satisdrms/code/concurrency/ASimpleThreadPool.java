package com.satisdrms.code.concurrency;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

class WorkerThread extends Thread {
	LinkedBlockingQueue<Runnable> queue;

	public WorkerThread(LinkedBlockingQueue<Runnable> newQueue) {
		queue = newQueue;
	}

	public void run() {
		System.out.println(getName() + " -- thread is started");
		Runnable task;
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Thread " + getName() + " is going to wait mode");
						queue.wait();
						System.out.println("Thread " + getName() + " is woken up and executing task");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				task = queue.poll();
			}
			task.run();
		}
	}
}

class ThreadPool  {
	LinkedBlockingQueue<Runnable> queue;
	WorkerThread[] workers;

	public ThreadPool(int workersCount) {
		queue = new LinkedBlockingQueue<Runnable>();
		workers = new WorkerThread[workersCount];
		for (int i = 0; i < workersCount; i++) {
			workers[i] = new WorkerThread(queue);
			workers[i].start();
		}
	}

	public void addTask(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			//queue.notifyAll();
			queue.notify();
		}
	}
}

public class ASimpleThreadPool {

	public static void main(String[] args) {
		ThreadPool tpool = new ThreadPool(10);

		for (int i = 0; i < 5; i++) {
			Runnable r = createRunnable(i);
			tpool.addTask(r);
		}
		
		
		
		Object o=new Object();
		System.out.println(o.toString()+" "+o+" "+o.getClass());

	}

	private static Runnable createRunnable(final int i) {
		return new Runnable() {

			@Override
			public void run() {
				System.out.println("Task " + i + " is getting executed");

			}
		};
	}
	
	

}
