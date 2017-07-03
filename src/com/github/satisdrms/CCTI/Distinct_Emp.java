package com.github.satisdrms.CCTI;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Distinct_Emp {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			addEmp(i, 12 - i);
		}
		addEmp(10, 44);
		printlist();
		System.out.println("--------------------");
		Collections.sort(EmpDB.emps);
		printlist();

		class emp_comparator implements Comparator<employee> {
			public int compare(employee e1, employee e2) {
				return e2.getAge() - e1.getAge();
			}
		}
		addEmp(11, 33);
		Collections.sort(EmpDB.emps, new emp_comparator());
		System.out.println("--------------------xx");
		printlist();

	}

	private static void printlist() {
		Iterator<employee> e = EmpDB.getiterator();
		while (e.hasNext()) {
			employee el = e.next();
			System.out.println(el.getAge() + "-" + el.getId());
		}
	}

	private static void addEmp(int i, int i2) {
		employee e1 = new employee();
		e1.setId(i);
		e1.setAge(i2);
		EmpDB.addEmp(e1);

	}

}
