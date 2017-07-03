package com.github.satisdrms;

class pass_by_val {
	int d;

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public void dispD() {
		System.out.println(d);
	}

}

public class Workspace_1 {

	public static void main(String[] args) throws Exception {
		int i = 1, j = 0;
		try {
			if (false && (i / j) > 1) {
				System.out.println("IF IS OK");
			} else
				System.out.println("IF IS NOT OK");
		} catch (Exception E) {
			System.out.println(E);
		}
		int pos = 1;
		System.out.println(2 * pos + 1 + " " + (pos * 2 + 1));
		System.out.println(pos++ + " " + pos);
		System.out.println(++pos + " " + pos);
		pass_by_val a = new pass_by_val();
		a.setD(1);
		a.dispD();
		test_call_by_ref(a);
		a.dispD();

	}

	private static void test_call_by_ref(pass_by_val a) {
		System.out.println("in method");
		a.dispD();
		a.setD(99);
		a.dispD();
	}

}
