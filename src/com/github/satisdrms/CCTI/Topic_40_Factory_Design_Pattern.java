package com.github.satisdrms.CCTI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface figures {
	public void print();
}

class Rectangle implements figures {
	public void print() {
		System.out.println("Printing Rectangle");
	}
}

class Circle implements figures {
	public void print() {
		System.out.println("Printing Circle");
	}
}

class Triangle implements figures {
	public void print() {
		System.out.println("Printing Triangle");
	}
}

class figuresFactory{
	public static figures createObject(String s){
		if(s.equalsIgnoreCase("RECTABLGE")){
			return new Rectangle();
		}else if(s.equalsIgnoreCase("CIRCLE")){
			return new Circle();
		}else if(s.equalsIgnoreCase("TRIANGLE")){
			return new Triangle();
		}
		throw new IllegalArgumentException("Figure not implemented in Factory");
	}
}

public class Topic_40_Factory_Design_Pattern {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fig=br.readLine();
		//System.out.println(fig);
		figures f=figuresFactory.createObject(fig);
		f.print();
		
		
	}
}
