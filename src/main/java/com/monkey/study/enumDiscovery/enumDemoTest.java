package com.monkey.study.enumDiscovery;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;
import org.junit.Test;
public class enumDemoTest {

	/**
	* @Description: test for enum
	* @return 
	* @throws 
	* @date 2017年4月7日 下午4:17:38
	 */
 	@Test
	public void test() {
		 for(Enum e : enumDemo.values()){
			 System.out.println(e.toString());
		 }
		 
		 System.out.println("===============");
		 
		 enumDemo eDemo = enumDemo.SUN;
		 switch (eDemo) {
				case MON:
					System.out.println("哈哈,今天是周一");
					break;
				case SUN:
					System.out.println("哈哈,今天是周日");
					break;
				default:
					System.out.println("only for lt");
					break;
		}
		 
	}

	/**
	* @Description: example for common methods
	* @return 
	* @throws 
	* @date 2017年4月7日 下午4:18:22
	 */
	@Test
	public void testCommonMethods(){
		enumDemo eDemo = enumDemo.FRI;
		
		//compareTo(E e)
		switch (eDemo.compareTo(enumDemo.SAT)) {
		case -1:
			System.out.println("FRI 在 SAT之前");
			break;
		case 1:
			System.out.println("FRI 在 SAT之后");
			break;
		default:
			System.out.println("FRI 与 SAT处于相同地位");
			break;
		}
		
		//getDeclaringClass()
		System.out.println("getDeclaringClass():"+eDemo.getDeclaringClass().getName());
		
		//name()
		System.out.println("name():"+eDemo.name());
		
		//toString()
		System.out.println("toString():"+eDemo.toString());
		
		//ordinal()
		System.out.println("ordinal():"+eDemo.ordinal());
	}
	
	/**
	* @Description: EnumSet and EnumMap 
	* @return 
	* @throws 
	* @date 2017年4月7日 下午4:18:56
	 */
	@Test
	public void setAndMap(){
		//EnumSet
		EnumSet<enumDemo> weekSet = EnumSet.allOf(enumDemo.class);
		for(enumDemo e : weekSet){
			System.out.println(e);
		}
		
		//EnumMap
		EnumMap<enumDemo, String> weekMap = new EnumMap(enumDemo.class);
		weekMap.put(enumDemo.MON, "星期一");
		weekMap.put(enumDemo.TUE, "星期二");
		weekMap.put(enumDemo.WED, "星期三");
		weekMap.put(enumDemo.THU, "星期四");
		weekMap.put(enumDemo.FRI, "星期五");
		weekMap.put(enumDemo.SAT, "星期六");
		weekMap.put(enumDemo.SUN, "星期天");
		
		for (Iterator<Entry<enumDemo, String>> it = weekMap.entrySet().iterator();it.hasNext();) {
			  Entry<enumDemo, String> entry = it.next();
			  System.out.println(entry.getKey()+"=="+entry.getValue());
		}
		
	}
	
}
