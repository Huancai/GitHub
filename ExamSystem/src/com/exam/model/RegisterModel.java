/**
 * @author wuhuancai
 * @time 2012年4月15日0:58:39
 * 用于用户注册信息时将信息写入数据库
 */
package com.exam.model;
import java.sql.ResultSet;
import com.exam.sqlHelper.SQLHelper;
import com.exam.view.RegisterView;

public class RegisterModel {

	
	//定义一个SQLHelper类，用它来完成本次用户名验证的功能
	private static SQLHelper sqHelper = new SQLHelper(); ;
	private static ResultSet rs,set = null ;
/**---------------------------------------------------------------------------------------*/
	/**
	 * 该方法用来将用户的注册信息保存到数据库中，即完成注册功能
	 */
	public int register()
	{
		//从RegisterView类中的getUserMessage方法来获得用户的注册信息
		String[] message = RegisterView.getUserMessage();
		String birthday = message[5]+"-"+message[6]+"-"+message[7];
		//将从注册界面获得的用户密码经过MD5加密后再存入数据库中
		String md5password = MD5.getMD5(message[1].getBytes()) ;
		String sql = null ;
		
		/** 判断注册的是什么用户{教师，学生，管理员}*/
		String role = message[9] ;
		/**给用户分配的准考证或用户编号*/
		String ID = getId();
		
		if (role.trim().toString().equals("管理员")) {
			sql = "insert into 管理员信息表 (用户名,密码,姓名,性别,出生年月,身份证号,相片,编号,联系电话,家庭住址,电子邮箱) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID.trim()+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
		}else if(role.toString().trim().equals("教  师")){
			sql = "insert into 教师信息表 (用户名,密码,姓名,性别,出生年月,身份证号,相片,编号,联系电话,家庭住址,电子邮箱) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
		}else {
			sql = "insert into 考生信息表 (用户名,密码,姓名,性别,出生年月,身份证号,相片,准考证号,联系电话,家庭住址,电子邮箱) values('"+message[0]+"','"+md5password+"','"+message[3]+"','"+message[4]+"','"+birthday+"','"+message[8]+"','"+message[10]+"','"+ID.trim()+"','"+message[11]+"','"+message[12]+"','"+message[13]+"')" ;
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
	 * 对判断用户名是否可用按钮做出响应
	 * @return 返回注册名是否可用
	 */
	public static boolean isUserName(String userName)
	{
		boolean b = false ;
		String sql = null ;
		String role = RegisterView.getJRadioButtonValue();
		if (role.equals("学  生")) {
			sql = "select 用户名 from 考生信息表" ;
		}else if(role.equals("教  师")){
			sql = "select 用户名 from 教师信息表" ;
		}else
		{
			sql = "select 用户名 from 管理员信息表" ;
		}
		
		rs = sqHelper.query(sql);
		try {
			
			while (rs.next()) {
				
				//System.out.println(rs.getString("用户名"));
				//如果从新注册的用户名已经在数据库中存在，则返回false
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
	 *获得当前注册角色的上一个准考证或用户编号，方便分配给新用户准考证号或用户编号
	 * @return 返回注册名是否可用
	 */
	public static String getId()
	{
		String sql = null ;
		
		String role = RegisterView.getJRadioButtonValue();
		System.out.println("role="+role);
		String id = "" ;
		if (role.equals("学  生")) {
			sql = "select MAX(准考证号) from 考生信息表" ;
			System.out.println("daozheerle");
		}else if(role.equals("教  师")){
			sql = "select MAX(编号) from 教师信息表" ;
		}else
		{
			sql = "select MAX(编号) from 管理员信息表" ;
		}
		
		set = sqHelper.query(sql);
		
		try {
			while (set.next()) {
				/**获得上一个注册用户的用户编号或准考证号*/
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
