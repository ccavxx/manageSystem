package com.tmh.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     FileUtils.java
 * 【类文件描述】
 *    		文件操作工具包 
 *
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年6月18日     TianMengHua        最初版本
 */
public class FileUtils {
	
	/**
	 * 方法名：getFiles
	 * 描述  ：
	 *		获取文件路径下的所有文件名称
	 * @param filePath
	 * @return
	 */
    public static List<String> getFiles(String filePath){
    	List<String> filelist = new ArrayList<String>();
        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files ){
        	filelist.add(file.getName());
        }
        return filelist;
    }
    
    /**
     * 方法名：writeFile
     * 描述  ：
     *		写入文件	
     * @param filePath  文件路径
     * @param content   需要写入的内容
     */
    public static void writeFile(String filePath,String content){
    	   File file = new File(filePath);
    	   try (FileOutputStream fop = new FileOutputStream(file)) {
	    	   if (!file.exists()) {
	    		   file.createNewFile();
	    	   }
	    	   byte[] contentInBytes = content.getBytes();
	    	   fop.write(contentInBytes);
	    	   fop.flush();
	    	   fop.close();
    	  } catch (IOException e) {
    		  e.printStackTrace();
    	  }
    }
    
    /**
     * 方法名：copyFile
     * 描述  ：
     *		复制文件
     * @param filePath     原始路径
     * @param newFilePath  新路径
     * @param newFileName  新文件名称
     */
    public static void copyFile(String filePath,String newFilePath){
    	FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        File file = new File(filePath);
        File newFile = new File(newFilePath);
        try {
        	if (!newFile.exists()) {
        		newFile.createNewFile();
	    	}
            fi = new FileInputStream(file);
            fo = new FileOutputStream(newFile);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }
    
    /**
     * 方法名：readFile
     * 描述  ：
     *		读取文件
     * @param fileName
     * @return 
     */
    public static String readFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String tempString = "";
        String content = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
            	content += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return content;
    }
    
}
