package pack1;

//class printdata {
//	synchronized void print(int n) {
//		for (int i = 0; i <= 5; i++) {
//			System.out.println(i * n);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//}
class printdata1 {
	void print(int n) {
		System.out.println("Non Synchronized Block");
		// synchronized (Integer.class) {
		// synchronized (MyThread1.class) {
		synchronized (printdata.class) {
			System.out.println("Synchronized Block");

			for (int i = 0; i <= 5; i++) {
				System.out.println(i * n);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class MyThread_a_1 extends Thread {
	printdata1 obj;

	public MyThread_a_1(printdata1 a) {
		this.obj = a;
	}

	public void run() {
		obj.print(5);
	}
}

class MyThread_a_2 extends Thread {
	printdata1 obj;

	public MyThread_a_2(printdata1 a) {
		this.obj = a;
	}

	public void run() {
		obj.print(500);
	}
}

public class Topic_35_Synchronization {

	public static void main(String[] args) {
		printdata1 a = new printdata1();
		MyThread_a_1 my1 = new MyThread_a_1(a);
		my1.start();
		MyThread_a_2 my2 = new MyThread_a_2(a);
		my2.start();

	}

}
