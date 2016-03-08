/**
 * @author wuhuancai
 * @time 2012��4��15��0:58:39
 * �����û�ע����Ϣʱ����Ϣд�����ݿ�
 */
package com.exam.model;
import java.sql.ResultSet;
import com.exam.sqlHelper.SQLHelper;
import com.exam.view.RegisterView;

public class RegisterModel {

	
	//����һ��SQLHelper�࣬��������ɱ����û�����֤�Ĺ���
	private static SQLHelper sqHelper = new SQLHelper(); ;
	private static ResultSet rs,set = null ;
/**---------------------------------------------------------------------------------------*/
	/**
	 * �÷����������û���ע����Ϣ���浽���ݿ��У������ע�Ṧ��
	 */
	public int register()
	{
		//��RegisterView���е�getUserMessage����������û���ע����Ϣ
		String[] message = RegisterView.getUserMessage();
		String birthday = message[5]+"-"+message[6]+"-"+message[7];
		//����ע������õ��û����뾭��MD5���ܺ��ٴ������ݿ���
		String md5password = MD5.getMD5(message[1].getBytes()) ;
		String sql = null ;
		
		/** �ж�ע�����ʲô�û�{��ʦ��ѧ��������Ա}*/
		String role = message[9] ;
		/**���û������׼��֤���û����*/
		String ID = getId();
		
		if (role.trim().toString().equals("����Ա")) {
			sql = "insert into ����Ա��Ϣ�� (�û���,����,����,�Ա�,��������,���֤��,��Ƭ,���,��ϵ�绰,��ͥסַ,��������) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID.trim()+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
		}else if(role.toString().trim().equals("��  ʦ")){
			sql = "insert into ��ʦ��Ϣ�� (�û���,����,����,�Ա�,��������,���֤��,��Ƭ,���,��ϵ�绰,��ͥסַ,��������) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
		}else {
			sql = "insert into ������Ϣ�� (�û���,����,����,�Ա�,��������,���֤��,��Ƭ,׼��֤��,��ϵ�绰,��ͥסַ,��������) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID.trim()+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
		}
		
		System.out.println("register sql :" + sql);
		for (int i = 0; i < message.length; i++) {
			System.out.println(message[i]);
		}
		
		int n = sqHelper.insert(sql);
		
		return n ;
	}
/**----------------------------------------------------------------------------------*/	
	/**
	 * ���ж��û����Ƿ���ð�ť������Ӧ
	 * @return ����ע�����Ƿ����
	 */
	public static boolean isUserName(String userName)
	{
		boolean b = false ;
		String sql = null ;
		String role = RegisterView.getJRadioButtonValue();
		if (role.equals("ѧ  ��")) {
			sql = "select �û��� from ������Ϣ��" ;
		}else if(role.equals("��  ʦ")){
			sql = "select �û��� from ��ʦ��Ϣ��" ;
		}else
		{
			sql = "select �û��� from ����Ա��Ϣ��" ;
		}
		
		rs = sqHelper.query(sql);
		try {
			
			while (rs.next()) {
				
				//System.out.println(rs.getString("�û���"));
				//�������ע����û����Ѿ������ݿ��д��ڣ��򷵻�false
				if (userName.equals(rs.getString(1))) {
					b = true ;
				}
			}
			
		} catch (Exception e) {
		}/*finally
		{
			if (sqHelper!=null) {
				sqHelper.close();
			}
		}*/
		
		return b ;
	}
	
	/**----------------------------------------------------------------------------------*/	
	/**
	 *��õ�ǰע���ɫ����һ��׼��֤���û���ţ������������û�׼��֤�Ż��û����
	 * @return ����ע�����Ƿ����
	 */
	public static String getId()
	{
		String sql = null ;
		
		String role = RegisterView.getJRadioButtonValue();
		System.out.println("role="+role);
		String id = "" ;
		if (role.equals("ѧ  ��")) {
			sql = "select MAX(׼��֤��) from ������Ϣ��" ;
			System.out.println("daozheerle");
		}else if(role.equals("��  ʦ")){
			sql = "select MAX(���) from ��ʦ��Ϣ��" ;
		}else
		{
			sql = "select MAX(���) from ����Ա��Ϣ��" ;
		}
		
		set = sqHelper.query(sql);
		
		try {
			while (set.next()) {
				/**�����һ��ע���û����û���Ż�׼��֤��*/
				id = set.getString(1);
			}
			
		} catch (Exception e) {
		}
		
		int n = Integer.parseInt(id.trim());
	//	System.out.println("id=" + id);
		n = n + 1 ;
		return String.valueOf("0"+n).trim() ;
	}
}
