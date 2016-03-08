/**
 * @author 吴焕才
 * @time 2011-11-22 0:33:51
 * Model层     	界面层<->Model层<->SQLHelper <-> 数据库
 * 
 */

package com.exam.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.sqlHelper.SQLHelper;

public class UserModel {

	//定义一个SQLHelper类，用它来完成本次用户名验证的功能
	SQLHelper spHelper = null ;
	
	
	/**
	 * （暂时没用上）
	 * @param user 传入的用户名
	 * @param psw  传入用户名对应的密码
	 * @return  返回该用户的职位
	 */
	public boolean checkUser(String user,String psw)
	{
		//用于保存传入用户名对应的职位(角色)
		boolean role = false ;
		//String sqlStr = "select * from 考生信息表 where 用户名=? and 密码=?";
		String sqlStr = "select 用户名,密码 from 考生信息表";
	//	String[] paras = {user,psw};
		
		spHelper = new SQLHelper();
		
		try {
			
			ResultSet rs = spHelper.query(sqlStr);
			while (rs.next()) {
				
			//	role = rs.getString(1);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally
		{
			spHelper.close();
		}
		
		return role ;
	}
	
	/*--------------------------------------------------------------------------------------------*/
	/**
	 * 检验用户是否合法
	 * @return 
	 */
	public boolean checking(String u,String p,String role)
	{
		boolean b = false ;
		String sql = null ;
		
		/**
		 * 因为密码是经过MD5加密后存放在数据库中的，所以在这里必须先将从登陆框获得的密码
		 * 进行MD5转换再与数据库中存的密码进行匹配
		 */
		p = MD5.getMD5(p.getBytes());
		
		/** 判断登录的是什么用户{教师，学生，管理员}*/
		if (role.equals("管理员")) {
			sql = "select 用户名,密码 from 管理员信息表" ;
		}else if (role.equals("教师")) {
			sql = "select 用户名,密码 from 教师信息表" ;
		}else {
			sql = "select 用户名,密码 from 考生信息表" ;
		}
		
		SQLHelper shHelper = new SQLHelper();
		ResultSet set = shHelper.query(sql);
		
		try {
			while (set.next()) {
				if (u.equals(set.getString(1))&&p.equals(set.getString(2))) {
					b = true ;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if (shHelper!=null) {
				shHelper.close();
			}
		}
		return b ;
	}
}
