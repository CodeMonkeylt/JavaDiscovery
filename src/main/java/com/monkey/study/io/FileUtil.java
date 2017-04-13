package com.monkey.study.io;

import java.io.File;

public class FileUtil {
	public void renameDirectory(String fromDir, String toDir) {

	    File from = new File(fromDir);

	    if (!from.exists() || !from.isDirectory()) {
	      System.out.println("Directory does not exist: " + fromDir);
	      return;
	    }

	    File to = new File(toDir);

	    //Rename
	    if (from.renameTo(to))
	      System.out.println("Success!");
	    else
	      System.out.println("Error");

	  }

	  public static void main(String[] args) {
	    FileUtil fileutil = new FileUtil();
	    fileutil.renameDirectory("C:\\Users\\Administrator\\Desktop\\Demo\\JavaDiscovery", "C:\\Users\\Administrator\\Desktop\\Demo\\lt");
	  }
}
