package com.exam.sqlHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new T();
	}
	
	/**
	 *定义需要的参数
	 */
	private Connection ct = null ;
	private PreparedStatement ps = null ;
	private ResultSet rs = null ;
	String sqlUrl = "sun.jdbc.odbc.JdbcOdbcDriver" ;
	String url = "jdbc:odbc:yanpengfei" ;
	String user = "sa" ;
	String psw = "123456" ;
	String sql = "select * from 考生信息表" ;
	
	/**
	 * 构造函数
	 * 在该构造函数中对数据库的一些参数进行初始化
	 */
	public T()
	{
		
		try {
			
			/**
			 * ① 加载驱动
			 */
			Class.forName(sqlUrl);
			/**
			 * ② 得到连接
			 */
			ct = DriverManager.getConnection(url,user,psw);
			
			/**
			 *③创建 prepareStatement
			 */
			ps =ct.prepareStatement(sql);
			/**
			 * ④执行
			 */
			
			/*int i= ps.executeUpdate("update 班级信息表  set 班主任='吴焕才' where 编号='21'");
			if (i==1)
			{
				System.out.print("操作OK");
			}else
			{
				System.out.print("操作不OK");
			}
			*/
			rs = ps.executeQuery();
			while (rs.next()) {
				
					String Sno=rs.getString(1);
					String Sname=rs.getString(2);
					String Ssex=rs.getString(3);
					System.out.println(Sno+"  "+Sname+"  "+Ssex+"  " );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param sql 传入对数据操作的SQL语句
	 * @param paras 传入的参数集 一般包括用户名 和密码
	 * @return 返回查询完成后的结果集
	 */
/*	public ResultSet query(String sql,String[] paras)
	{
		try {
			
			*//**
			 *③创建 prepareStatement
			 *//*
			ps =ct.prepareStatement(sql);
			*//**
			 * ④执行
			 *//*
			rs = ps.executeQuery();
			
			*//**
			 * 对SQL参数赋值
			 *//*
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i++, paras[i]);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return rs ;
	}*/

}
