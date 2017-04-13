package com.monkey.study.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtils {
	/**
	 * @Description: traversal all folders and files under the specified path
	 * @param dir
	 * @date 2017年4月12日 下午5:26:43
	 * @author lt
	 */
	public static void getFiles(File dir,String regex, String replacement) {
		// if directory or file exists
		if (dir.exists()) {
			// if is directory
			if (dir.isDirectory()) {
				// print the Directory
				//change directory name
				if(dir.getName().contains(regex)){
					dir.renameTo(new File(replacement));
				}
				// get all files and arrays of directory
				File[] files = dir.listFiles();
				// Recursion traversal each child files
				for (File file : files) {
					getFiles(file,"","");
				}
			}
			// if is a file,print it's name and directory
			else {
				readFile(dir,regex,replacement);
			}
		}

	}
	
	 /**
	 * @Description: read the file
	 * @param file
	 * @return 
	 * @throws 
	 * @date 2017年4月13日 上午9:09:26
	 * @author lt
	  */
	public static void readFile(File file,String regex, String replacement){
		BufferedReader fileReader = null;
		StringBuffer stringBuffer = null;
		String str = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			stringBuffer = new StringBuffer();
			String tempStr ;
			while((tempStr = fileReader.readLine()) !=null){
				stringBuffer = stringBuffer.append(tempStr).append("\n");
			}
			str = stringBuffer.toString();
			if(str != null && str.length() > 0){
				str =  str.replaceAll(regex, replacement);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			writeFile(file.getName(),str);
			stringBuffer.delete(0, stringBuffer.length());
		}
	}
	
	/**
	* @Description: change word
	* @param path
	* @param regex
	* @param replacement
	* @return 
	* @throws 
	* @date 2017年4月13日 上午9:30:05
	* @author lt
	 */
	public static void changeWord(String path,String regex, String replacement){
		File file = new File(path);
		FileUtils.getFiles(file,regex,replacement);
	}
	
	public static void writeFile(String path,String str){
		PrintWriter out = null;
		try {
			 out=new PrintWriter(path);
			 out.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
	
}
