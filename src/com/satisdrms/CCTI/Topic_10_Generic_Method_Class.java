package com.satisdrms.CCTI;

public class Topic_10_Generic_Method_Class {
	
	public static<E> void genericprint(E p){
		System.out.println(p.getClass());
	}
	public static <E> void main(String[] args) {
		System.out.println("TETST");
		
		test<?> i=null;
		i=new test<Integer>(1);
		i.print();
		genericprint('c');
		genericprint(1);
		

	}

}

class test<E>{
	E a;
	test(E i){
		this.a=i;
	}
	void print(){
		System.out.println(a);
	}
}