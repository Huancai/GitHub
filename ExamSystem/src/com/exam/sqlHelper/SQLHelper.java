/**
 * @author �����
 * @time 2011-11-22 0:38:14
 * @description �����ݿ��������  �����<->Model��<->SQLHelper <-> ���ݿ� �������з�װ�˶����ݿ����������
 * 			 ���������ܶ����ݿ����ʲô���Ĳ�������Ӧ�ôӽ�������Model�㣬Ȼ��Model���ٵ��øò� �������֮��
 * 			 ����ֱ�Ӳ�������ݿ���κβ���
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
	 * ���캯�� �ڸù��캯���ж����ݿ��һЩ�������г�ʼ��
	 */
	public SQLHelper() {
		try {

			// �� ��������
			Class.forName(sqlUrl);
			System.out.println("jiazaichenggong....");
			
			//�� �õ�����
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
	 *            ��������ݲ�����SQL���
	 * @param paras
	 *            ����Ĳ�����
	 * @return ���ز�ѯ��ɺ�Ľ����
	 */
	public ResultSet query(String sql, String[] paras) {
		try {

			/**
			 * �۴��� prepareStatement
			 */
			ps = ct.prepareStatement(sql);
			/**
			 * ��ִ��
			 */
			rs = ps.executeQuery();

			/**
			 * ��SQL������ֵ
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
	 *            �����ѯ��SQL���
	 * @return ���ظ�SQL�������ѯ���Ľ����
	 */
	public ResultSet query(String sql) {
		try {

			/**
			 * �۴���prepareStatement
			 */
			ps = ct.prepareStatement(sql);
			/**
			 * ��ִ��
			 */
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * ���������ݿ��������
	 * 
	 * @param sql
	 *            ����һ������SQL��� ����intֵ����n==1�����ʾ�������� �����ɹ�
	 */
	public int insert(String sql) {

		int n = 0;
		try {
			/**
			 * �۴��� prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ��ִ��
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * �����޸����ݿ����Ϣ
	 * 
	 * @param sql
	 *            ����ĸ������ݿ�|�û���Ϣ ��SQL���
	 */
	public int update(String sql) {

		int n = 0;
		try {
			/**
			 * �۴��� prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ��ִ��
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/
	/**
	 * �����޸����ݿ����Ϣ
	 * 
	 * @param sql
	 *            ����ĸ������ݿ�|�û���Ϣ ��SQL���
	 */
	public int delete(String sql) {
		int n = 0;
		try {
			/**
			 * �۴��� prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ��ִ��
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * ���ڱ������ݿ�
	 * 
	 * @param sql
	 *            ��������������������ݿ��SQL���
	 */
	public int backup(String sql) {

		int n = 0;
		try {
			/**
			 * �۴��� prepareStatement
			 */
			ps = ct.prepareStatement(sql);

			/**
			 * ��ִ��
			 */
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * ���ڻ�ԭ���ݿ�
	 * 
	 * @param sql
	 *            ����������ԭ���ݿ��SQL���
	 */
	public void restore(String sql) {

	}

	/*---------------------------------------------------------------------------------------------*/

	/**
	 * һ���ر����ݿ����ķ���
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
