package com.satisdrms.code.javapuzzles;

class Animal {
	//private void method() { THIS CAUSES ERROR AS FROM ANIMALS PERSPECTIVE THE METHODS IS NOT ACCESSIBLE
	public void method() {
		System.out.println("Animal Method");
	}
	
	public static void statmethod(){
		System.out.println("Static Animal Method");
	}
}

class Dog extends Animal {
	public void method() {
		System.out.println("Dog Method");
	}
	
	public static void statmethod(){
		System.out.println("Static Dog Method");
	}
}

public class Int1 {
	public static void main(String[] args) {
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		System.out.println(Double.MIN_VALUE);

		Dog d = new Dog();
		d.method();
		d.statmethod();
		
		Animal a_d = new Dog();
		a_d.method();
		
		a_d.statmethod();
		
		System.out.println(1.0/0.0);
		System.out.println(1/00);
		
	}
}
