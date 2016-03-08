/**
 * 获得从登陆框输入的用户名相对应的姓名
 * 即获得用户名的姓名
 */
package com.exam.tools;

import java.sql.ResultSet;
import com.exam.sqlHelper.SQLHelper;
import com.exam.view.User_Login;

public class GetUserName {

	private static SQLHelper sqHelper = new SQLHelper();
	private static ResultSet rs = null ;
	
	public static String getName()
	{
		String user = "" ;
		String u = User_Login.get_user_name();
		
		/** 获得用户选择的角色 */
		String role = User_Login.get_user_role();
		String sql = "select 姓名 from 考生信息表 where 用户名= '"+u+"'";
		
		if (role.trim().toString().equals("管理员")) {
			sql = "select 姓名 from 管理员信息表 where 用户名= '"+u+"'";
		}else if(role.toString().trim().equals("教师")){
			sql = "select 姓名 from 教师信息表 where 用户名= '"+u+"'";
		}else {
			sql = "select 姓名 from 考生信息表 where 用户名= '"+u+"'";
		}
		
	//	System.out.println(sql);
		rs = sqHelper.query(sql);
		
		try {
			
			if(rs.next())
			{
				user = rs.getString("姓名");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}
}
