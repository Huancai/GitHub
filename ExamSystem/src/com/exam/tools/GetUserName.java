/**
 * ��ôӵ�½��������û������Ӧ������
 * ������û���������
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
		
		/** ����û�ѡ��Ľ�ɫ */
		String role = User_Login.get_user_role();
		String sql = "select ���� from ������Ϣ�� where �û���= '"+u+"'";
		
		if (role.trim().toString().equals("����Ա")) {
			sql = "select ���� from ����Ա��Ϣ�� where �û���= '"+u+"'";
		}else if(role.toString().trim().equals("��ʦ")){
			sql = "select ���� from ��ʦ��Ϣ�� where �û���= '"+u+"'";
		}else {
			sql = "select ���� from ������Ϣ�� where �û���= '"+u+"'";
		}
		
	//	System.out.println(sql);
		rs = sqHelper.query(sql);
		
		try {
			
			if(rs.next())
			{
				user = rs.getString("����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user ;
	}
}
