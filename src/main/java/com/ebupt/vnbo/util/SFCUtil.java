package com.ebupt.vnbo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
public class SFCUtil {
	private static Map<String, AtomicInteger> map=new HashMap<>();
	private static AtomicInteger initvalue=new AtomicInteger(1);
	
	public static String nextIndex(String name){
		if(map.containsKey(name)){
			return String.valueOf(map.get(name).get());
		}
		else {
			map.put(name, initvalue);
			int index=initvalue.get();
			initvalue.incrementAndGet();
			return String.valueOf(index);
		}
		
	}

}
