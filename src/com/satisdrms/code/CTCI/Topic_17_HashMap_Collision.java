package com.satisdrms.code.CTCI;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Topic_17_HashMap_Collision {

	public static void main(String[] args) {
		HashMap<Integer,String> hm=new HashMap<Integer, String>();
		hm.put(1, "ass");
		hm.put(2, "as");
		hm.put(100016, "as");
		//System.out.println(hm.hashCode());
		System.out.println(hm.get(1));
		Set<Entry<Integer, String>> s=hm.entrySet();
		for(Entry<Integer,String> e:s){
			System.out.println(e.getKey()+" "+e.getValue());
		}
		Map m = Collections.synchronizedMap(hm);

		
	}

}
