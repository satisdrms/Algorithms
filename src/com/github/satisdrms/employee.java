package com.github.satisdrms;

import java.util.Comparator;

public class employee implements Comparable<employee> {
	int id;
	int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(employee o) {
		employee e = ((employee) o);
		return o.getAge() - this.age;
	}


}
