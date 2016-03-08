/**
 * @author 吴焕才
 * @time 2011-11-22 0:38:14
 * @description 对数据库操作的类  界面层<->Model层<->SQLHelper <-> 数据库 ，此类中封装了对数据库操作了所有
 * 			 方法，不管对数据库进行什么样的操作，都应该从界面层调用Model层，然后Model层再调用该层 ，简而言之，
 * 			 该类直接参与对数据库的任何操作
 */

package com.exam.sqlHelper;

import java.sql.*;

public class SQLHelper {

	private Connection ct = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private final String sqlUrl = "com.mysql.jdbc.Driver";

	final String url = "jdbc:mysql://localhost:3306/student_db?"
			+ "user=root&password=&useUnicode=true&characterEncoding=UTF8";

	/**
	 * 构造函数 在该构造函数中对数据库的一些参数进行初始化
	 */
	public SQLHelper() {
		try {

			// ① 加载驱动
			Class.forName(sqlUrl);
			System.out.println("jiazaichenggong....");
			
			//② 得到连接
			ct = DriverManager.getConnection(url);
			System.out.println("dedao lianjie chenggong....");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * 
	 * @param sql
	 *            传入对数据操作的SQL语句
	 * @param paras
	 *            传入的参数集
	 * @return 返回查询完成后的结果集
	 */
	public ResultSet query(String sql, String[] paras) {
		try {

			/**
			 * ③创建 prepareStatement
			 */
			ps = ct.prepareStatement(sql);
			/**
			 * ④执行
			 */
			rs = ps.executeQuery();

			/**
			 * 对SQL参数赋值
			 */
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return rs;
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * 
	 * @param sql
	 *            传入查询的SQL语句
	 * @return 返回该SQL语句所查询到的结果集
	 */
	public ResultSet query(String sql) {
		try {

			/**
			 * ③创建prepareStatement
			 */
			ps = ct.prepareStatement(sql);
			/**
			 * ④执行
			 */
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * 用于向数据库插入数据
	 * 
	 * @param sql
	 *            传入一个插入SQL语句 返回int值，若n==1，则表示插入数据 操作成功
	 */
	public int insert(String sql) {

		int n = 0;
		try {
			/**
			 * ③创建 prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ④执行
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * 用来修改数据库的信息
	 * 
	 * @param sql
	 *            传入的更新数据库|用户信息 的SQL语句
	 */
	public int update(String sql) {

		int n = 0;
		try {
			/**
			 * ③创建 prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ④执行
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * 用来修改数据库的信息
	 * 
	 * @param sql
	 *            传入的更新数据库|用户信息 的SQL语句
	 */
	public int delete(String sql) {
		int n = 0;
		try {
			/**
			 * ③创建 prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ④执行
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * 用于备份数据库
	 * 
	 * @param sql
	 *            传入的用来备份整个数据库的SQL语句
	 */
	public int backup(String sql) {

		int n = 0;
		try {
			/**
			 * ③创建 prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ④执行
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * 用于还原数据库
	 * 
	 * @param sql
	 *            传入用来还原数据库的SQL语句
	 */
	public void restore(String sql) {

	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * 一个关闭数据库流的方法
	 */
	public void close() {
		try {

			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (ct != null) {
				ct.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
