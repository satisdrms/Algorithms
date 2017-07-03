package com.github.satisdrms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class EmpDB {
	public static ArrayList<employee> emps=new ArrayList<employee>();
	public static void addEmp(employee e1){
		Iterator<employee> ei=emps.iterator();
		char flagexist='N';
		while(ei.hasNext()){
			employee exist=ei.next();
			if(e1.getId()==exist.getId()){
				flagexist='Y';
			}
		}
		if(flagexist=='N'){
			emps.add(e1);
		}
	}
	public void removeEmp(employee e1){
		
	}
	public ArrayList<employee> sortEmp(){
		ArrayList<employee> emps=new ArrayList<employee>();
		return emps;
		
	}
	public static Iterator<employee> getiterator() {
		return emps.iterator();
	}
	public static void sortbyageascandprint() {
		 //Collections.sort(emps);
		
	}
}
