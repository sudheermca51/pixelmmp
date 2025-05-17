package org.iitwf.healthcare.mmppixel;

import java.util.HashMap;

public class HashMapEx {

	
	public static void main(String[] args) {
		
		   HashMap<String,String> expectedHMap = new HashMap<String,String>();
		   expectedHMap.put("date", "23/10/2025");
		   expectedHMap.put("doctor", "James");
		   expectedHMap.put("time", "11AM");
		   expectedHMap.put("sym", "fever");
		   
		   System.out.println("Size:::" + expectedHMap.size());
		   
		   System.out.println("Time:::"+expectedHMap.get("time"));
		   
		   System.out.println("Doctor:::"+expectedHMap.get("doctor"));
	}
}
