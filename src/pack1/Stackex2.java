package pack1;

public class Stackex2 {
	StackNode top;
	int min ;

	// SortedSet<Integer> min;

	Stackex2() {
		min=9999;
		top = null;
		// min = new TreeSet<Integer>();
	}

	StackNode push(int d) {
		if (d < min)
			min = d;
		if (top == null) {
			top = new StackNode(d, min);
		} else {
			StackNode newTop = new StackNode(d, min);
			newTop.next = top;
			top = newTop;
		}
		// min.add(d);
		return top;
	}

	StackNode pop() {
		StackNode ret;
		if (top == null)
			return null;// Stack Empty
		else {
			ret = top;
			top = top.next;
			// min.remove(top.data);
		}
		return ret;

	}

	StackNode peek() {
		StackNode ret;
		if (top == null)
			return null;
		else {
			ret = top;
		}
		return ret;

	}

}
