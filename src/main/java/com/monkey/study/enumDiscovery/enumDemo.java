package com.monkey.study.enumDiscovery;

/**
* @ClassName: enumDemo 
* @Description: demo for enum
* @author lt
* @date 2017��4��7�� ����4:04:23
 */
public enum enumDemo {
	MON("��һ"),
	TUE("�ܶ�"),
	WED("����"),
	THU("����"),
	FRI("����"),
	SAT("����"),
	SUN("����");
	
	private String value;

	private enumDemo(String value) {
		this.value = value;
	}
	
	public String toString(){
		return this.value.toString();
	}

}
