package com.satisdrms.code.stringProblems;

public class StringINmemory {
	public static void main(String[] args){
		String str="sa";
		System.out.println(System.identityHashCode(str));
		str="sa";//same object ref value  // same address of previous object is reused
		System.out.println(System.identityHashCode(str));
		str="sa1";//new object ref value 
		System.out.println(System.identityHashCode(str));
		str=new String("sa");// new string creates new memory location
		System.out.println(System.identityHashCode(str));
	}

}
