package com.monkey.study.io;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.monkey.study.io.FileUtils;

/**
* @ClassName: changeWord 
* @Description: 修改study中的包名和java类的相关word
* @author lt
* @date 2017年4月11日 上午9:40:40
 */
public class changeWord {
//	public final static String url = "F:\\\\git\\\\JavaDemo\\\\src\\\\com\\\\monkey\\\\study\\\\enumDiscovery\\\\enumDemoTest.java";
//	public final static String url = "C:\\Users\\Administrator\\Desktop\\Test";
	public final static String url = "E:\\st_liu\\study";
	
	public static void main(String[] args) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 long startTime = System.currentTimeMillis();
		 System.out.println("开始替换，" + sdf.format(new Date()));
		 FileUtils.changeWord(url, "Jeesite", "Study");
		 long endTime = System.currentTimeMillis();
		 System.out.println("替换结束，" + sdf.format(new Date()));
		 System.out.println("用时："+(endTime-startTime));
	}
}
