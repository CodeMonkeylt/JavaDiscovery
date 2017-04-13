package com.monkey.study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
* @ClassName: changeWord 
* @Description: 修改study中的包名和java类的相关word
* @author lt
* @date 2017年4月11日 上午9:40:40
 */
public class changeWord {
//	public final static String url = "F:\\git\\JavaDemo\\src\\com\\monkey\\study\\enumDiscovery\\enumDemoTest.java";
	public final static String url = "E:\\study";
	
	public static void main(String[] args) {
		 System.out.println("开始替换，" + System.currentTimeMillis());
		 FileUtils.changeWord(url, "thinkgem", "monkey");
		 System.out.println("替换结束，" + System.currentTimeMillis());
	}
}
