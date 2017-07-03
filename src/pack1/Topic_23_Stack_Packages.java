package pack1;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Topic_23_Stack_Packages {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.add(new Integer(1));

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(99);
		ll.add(999);
		ll.add(9999);
		ll.add(99999);
		s.add(new Integer(3));
		s.add(new Integer(9));
		s.add(new Integer(34));
		s.add(new Integer(11));
		s.add(new Integer(1));
		s.add(new Integer(5));
		System.out.println("-------START OF STACK TEST");
		System.out.println("Peek is " + s.peek());
		print(s);
		System.out.println("Pop is " + s.pop());
		s.clear();
		print(s);
		s.addAll(ll);
		print(s);
		s.add(45);
		print(s);
		s.push(3);
		print(s);
		System.out.println(s.elementAt(2));
		System.out.println("-------END OF STACK TEST");
		System.out.println("-------START OF LINKED LIST");
		ll.clear();
		ll.add(1);
		ll.add(23);
		ll.add(3);
		ll.add(12);
		ll.add(9931);
		System.out.println("GETTING FIRST from LINKEDLIST " + ll.getFirst());
		System.out.println("GETTING LAST from LINKEDLIST " + ll.getLast());
		print(ll);
		System.out.println("-------END OF LINKEDLIST TEST");

	}

	private static <T> void print(List<T> s) {
		for (T i : s) {
			System.out.println(i);
		}
	}
}
