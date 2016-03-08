/**
 * @author �����
 * @time 2011-11-22 0:33:51
 * Model��     	�����<->Model��<->SQLHelper <-> ���ݿ�
 * 
 */

package com.exam.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.sqlHelper.SQLHelper;

public class UserModel {

	//����һ��SQLHelper�࣬��������ɱ����û�����֤�Ĺ���
	SQLHelper spHelper = null ;
	
	
	/**
	 * ����ʱû���ϣ�
	 * @param user ������û���
	 * @param psw  �����û�����Ӧ������
	 * @return  ���ظ��û���ְλ
	 */
	public boolean checkUser(String user,String psw)
	{
		//���ڱ��洫���û�����Ӧ��ְλ(��ɫ)
		boolean role = false ;
		//String sqlStr = "select * from ������Ϣ�� where �û���=? and ����=?";
		String sqlStr = "select �û���,���� from ������Ϣ��";
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
	 * �����û��Ƿ�Ϸ�
	 * @return 
	 */
	public boolean checking(String u,String p,String role)
	{
		boolean b = false ;
		String sql = null ;
		
		/**
		 * ��Ϊ�����Ǿ���MD5���ܺ��������ݿ��еģ���������������Ƚ��ӵ�½���õ�����
		 * ����MD5ת���������ݿ��д���������ƥ��
		 */
		p = MD5.getMD5(p.getBytes());
		
		/** �жϵ�¼����ʲô�û�{��ʦ��ѧ��������Ա}*/
		if (role.equals("����Ա")) {
			sql = "select �û���,���� from ����Ա��Ϣ��" ;
		}else if (role.equals("��ʦ")) {
			sql = "select �û���,���� from ��ʦ��Ϣ��" ;
		}else {
			sql = "select �û���,���� from ������Ϣ��" ;
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
