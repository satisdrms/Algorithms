package pack1;

public class Topic_3_Sample_class {
	int a;
	static int b;

	Topic_3_Sample_class() {
		this(1);
		a = 1;
		this.b=9;
	}

	Topic_3_Sample_class(String string) {
		System.out.println("I called another String - constructor");
	}

	Topic_3_Sample_class(int i) {
		this("a");
		System.out.println("I called another INT constructor");
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;

	}

}
