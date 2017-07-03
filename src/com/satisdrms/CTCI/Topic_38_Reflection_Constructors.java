package com.satisdrms.CTCI;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class constructorTest {
	String a;
	public constructorTest() {
		System.out.println("This is an Empty constructor");
		a="Instance created from private constructor";
	}

	public constructorTest(int i) {
		System.out.println("This receives the value " + i);
		a="Instance created from public constructor";
	}

	public void sampleMethod() {
		//Method reflection works only with public methods not with private methods
		System.out.println("This is a sample method with visiblity public");
	}
	public void printStr(){
		System.out.println(a);
	}
}

public class Topic_38_Reflection_Constructors {
	public static void main(String[] args) {
		constructorTest a=new constructorTest(1);
		a.printStr();
		try {
			//Getting the public constructor
			Constructor<constructorTest> c=constructorTest.class.getConstructor(int.class);
			c.setAccessible(true);
			constructorTest a1=c.newInstance(1);
			a1.printStr();
			
			//Getting the private constructor
			Constructor<constructorTest> c1=constructorTest.class.getDeclaredConstructor();
			c1.setAccessible(true);
			constructorTest b=(constructorTest) c1.newInstance();
			b.printStr();
			
			//Getting the method and calling it 
			Method m=constructorTest.class.getMethod("sampleMethod");
			a.getClass().getMethods();
			m.setAccessible(true);
			m.invoke(a);
			//a.getClass().asSubclass(constructorTest.class).;
			
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRROORR");
		}
	}
}
