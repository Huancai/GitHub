package com.exam.sqlHelper;

import java.sql.ResultSet;


public class T2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 SQLHelper helper = new SQLHelper();
	 
	 String sql = null ;
		
		
			sql = "select max(׼��֤��) from ������Ϣ��" ;
			
		
		ResultSet set = helper.query(sql);
		
		try {
			while (set.next()) {
				System.out.println(set.getString(1));
			}
			
		} catch (Exception e) {
		}
		
	}

}
