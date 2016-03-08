package com.exam.tools;

import java.io.BufferedReader;
import java.io.FileReader;

public class GetInformationFromFile {

	private static BufferedReader br = null ;
	
	/**
	 * 从本机设备获得学生须知的内容
	 * @return
	 */
	public static String getInformation(String path)
	{
		String str1 = "" ;
		String str2 = "" ;
		try {
			br = new BufferedReader(new FileReader(path));
			while((str1=br.readLine())!=null)
			{
				str2 += str1+"\n";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(str2);
		return str2;
	}
}
