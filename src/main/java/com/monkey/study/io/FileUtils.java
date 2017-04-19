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
				if(dir.getName().matches(regex)){
					dir.renameTo(new File(dir.getParent()+"\\"+replacement));
				}
				// get all files and arrays of directory
				File[] files = dir.listFiles();
				// Recursion traversal each child files
				if(files != null){
					for (File file : files) {
						getFiles(file,regex,replacement);
					}
				}
			}
			// if is a file,print it's name and directory
			else {
				if(dir.getName().toString().contains(regex)){
					renameFile(dir.getAbsolutePath(),dir.getName(),replacement+dir.getName(). substring(dir.getName().indexOf("."), dir.getName().length()));
				}
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
		boolean bool = false;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			stringBuffer = new StringBuffer();
			String tempStr ;
			while((tempStr = fileReader.readLine()) !=null){
				stringBuffer = stringBuffer.append(tempStr).append("\n");
			}
			str = stringBuffer.toString();
			str =  str.replaceAll(regex, replacement);
			writeFile(file.getAbsolutePath(),str);
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	
	 /**
	  * @param path
	  * @param oldname
	  * @param newname
	  */
	 public static void renameFile(String path,String oldname,String newname){ 
	        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名 
		            File oldfile=new File(path+"/"+oldname); 
		            File newfile=new File(path+"/"+newname); 
		            if(!oldfile.exists()){
		                return;//重命名文件不存在
		            }
		            if(newfile.exists()){//若在该目录下已经有一个文件和新文件名相同，则不允许重命名 
		                System.out.println(newname+"已经存在！"); 
		            }else{ 
		                oldfile.renameTo(newfile); 
		            } 
	        }else{
	            System.out.println("新文件名和旧文件名相同...");
	        }
	    }
}
