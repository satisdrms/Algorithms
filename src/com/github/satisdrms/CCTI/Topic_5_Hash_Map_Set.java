package com.github.satisdrms.CCTI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class Topic_5_Hash_Map_Set {

	public static void main(String[] args) {
		HashSet<Topic_5_Sample_emp_Class> a=new HashSet<Topic_5_Sample_emp_Class>();
		HashMap<String,Topic_5_Sample_emp_Class> b=new HashMap<String, Topic_5_Sample_emp_Class>();
		LinkedHashMap<String,Topic_5_Sample_emp_Class> c=new LinkedHashMap<String, Topic_5_Sample_emp_Class>();
		
		HashSet<String> set_wrk=new HashSet<String>();
		set_wrk.add("sa");
		set_wrk.add("asa");
		
		ArrayList<String> list_wrk=new ArrayList<String>();
		list_wrk.add("sa");
		list_wrk.add("sa");

		//for(String s:set_wrk){System.out.println(s);}
		//for(String s:list_wrk){System.out.println(s);}
		
		TreeSet<String> treset_wrk=new TreeSet<String>();
		treset_wrk.add("sa");
		treset_wrk.add("asa");treset_wrk.add("1aasa");
		//for(String s:treset_wrk){System.out.println(s);}
		
		LinkedList<String> linlist_wrk=new LinkedList<String>();
		linlist_wrk.add("sa");
		linlist_wrk.add("1sa");
		linlist_wrk.add("2sa");
		linlist_wrk.add("3sa");
		linlist_wrk.add("4sa");
		linlist_wrk.add("zsa");
		
		//for(String s:linlist_wrk){System.out.println(s);}
		
		HashMap<String,String> hshmap_wrk=new HashMap<String, String>();
		hshmap_wrk.put("1","one");
		hshmap_wrk.put("1","two");
		hshmap_wrk.put("2","two");
		
		System.out.println(hshmap_wrk.get("1"));
		
		System.out.println(hshmap_wrk.containsKey("1"));
		
		System.out.println(hshmap_wrk.containsValue("two"));
		
		
	}

}
