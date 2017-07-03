package com.satisdrms.CCTI;

interface wild_generics<T> {
	public void printme(T a);
	// public void

}

class wild_gen_class<T> implements wild_generics<T> {
	public T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	wild_gen_class(T t){
		this.t=t;
	}
	@Override
	public void printme(T a) {
		System.out.println("Value Passed is "+a +" Value created with the object is "+t);

	}

}

public class Topic_24_Generics_Wildcards {

	public static void main(String[] args) {
		
		display("S", new wild_gen_class<String>("<--VALUE CREATED WITH THE OBJECT->"), "<--FROM CALLING MAIN METHODS-->");

	}

	private static <X, Y extends wild_generics<T>, T> void display(X x, Y y, T t) {
		y.printme(t);
	}

}
