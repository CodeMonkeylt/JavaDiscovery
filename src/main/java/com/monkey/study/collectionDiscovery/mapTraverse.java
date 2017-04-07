package com.monkey.study.collectionDiscovery;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class mapTraverse {
	public Logger logger = Logger.getLogger(mapTraverse.class);
		public static void main(String[] args) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("a", "lt");
			map.put("b", "liu_t");
			map.put("c", "liutao");
			map.put("d", "tao_liu");
			map.put("e", "tao_l");
			map.put("f", "st_liu");
			System.out.println("the size mof map is :"+map.size());
			
			//The First Traverse 
			System.out.println("The first traverse way-Traverse key and value by Map.KeySet:");
		}
}
