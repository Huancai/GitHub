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
	 *������Ҫ�Ĳ���
	 */
	private Connection ct = null ;
	private PreparedStatement ps = null ;
	private ResultSet rs = null ;
	String sqlUrl = "sun.jdbc.odbc.JdbcOdbcDriver" ;
	String url = "jdbc:odbc:yanpengfei" ;
	String user = "sa" ;
	String psw = "123456" ;
	String sql = "select * from ������Ϣ��" ;
	
	/**
	 * ���캯��
	 * �ڸù��캯���ж����ݿ��һЩ�������г�ʼ��
	 */
	public T()
	{
		
		try {
			
			/**
			 * �� ��������
			 */
			Class.forName(sqlUrl);
			/**
			 * �� �õ�����
			 */
			ct = DriverManager.getConnection(url,user,psw);
			
			/**
			 *�۴��� prepareStatement
			 */
			ps =ct.prepareStatement(sql);
			/**
			 * ��ִ��
			 */
			
			/*int i= ps.executeUpdate("update �༶��Ϣ��  set ������='�����' where ���='21'");
			if (i==1)
			{
				System.out.print("����OK");
			}else
			{
				System.out.print("������OK");
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
	 * @param sql ��������ݲ�����SQL���
	 * @param paras ����Ĳ����� һ������û��� ������
	 * @return ���ز�ѯ��ɺ�Ľ����
	 */
/*	public ResultSet query(String sql,String[] paras)
	{
		try {
			
			*//**
			 *�۴��� prepareStatement
			 *//*
			ps =ct.prepareStatement(sql);
			*//**
			 * ��ִ��
			 *//*
			rs = ps.executeQuery();
			
			*//**
			 * ��SQL������ֵ
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
