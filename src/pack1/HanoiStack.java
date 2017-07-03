package pack1;

public class HanoiStack {
	int capacity = 0;
	HanoiStackNode top, bottom;

	HanoiStack() {
		top = null;
		bottom = null;
	}

	public void push(int diskWeight) {
		if (diskWeight < peek()) {
			if (top == null) {
				top = new HanoiStackNode(diskWeight);
				bottom = top;
			} else {
				HanoiStackNode n = new HanoiStackNode(diskWeight);
				moveTopUp(n);
			}
			capacity++;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("<<ERROR>> Trying to insert a larger disk on top of smaller disk");
				e.printStackTrace();
			}

		}

	}

	private void moveTopUp(HanoiStackNode n) {
		top.above = n;
		n.below = top;
		top = n;
	}

	public void printall() {
		HanoiStackNode t = top;
		// System.out.println("------------Printing Node Start");
		while (t != null) {
			System.out.println(t.weight);
			t = t.below;
		}
		// System.out.println("------------Printing Node End");

	}

	public int pop() {
		// System.out.println("Popped "+top.weight);
		int pop = top.weight;
		if (top != bottom) {
			top = top.below;
			top.above = null;
		} else {
			top = bottom = null;
		}
		capacity--;
		// System.out.println(capacity);

		return pop;

	}

	public int peek() {
		if (top != null) {
			int pop = top.weight;
			return pop;
		} else
			return 999999;
	}

	public HanoiStackNode getBottom() {
		HanoiStackNode hsk = bottom;
		bottom = bottom.above;
		bottom.below = null;
		capacity--;

		return hsk;
	}

}
