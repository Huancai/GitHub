package com.exam.model;
/**
**����ˢ�±�JTabel����Ϣ
*/
import javax.swing.table.* ;
import java.sql.* ;
import java.util.*;
import javax.swing.*;

import com.exam.sqlHelper.SQLHelper;

public class Admin_P1_Model extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�������
	Vector<Object> rowData,columnNames ;	
	JTable jtb = null ;
	JScrollPane jsp ;
	Connection ct = null ;
	Statement sm = null ;	
	ResultSet rs = null ;
	
	//private static String sql = null ;
	
	public Admin_P1_Model(String role,String sql)
	{
		columnNames = new Vector<Object>();
		columnNames.add("�û���");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("��������");
		columnNames.add("���֤��");
		columnNames.add("ע��ʱ��");
		columnNames.add("���(׼��֤��)");
		rowData = new Vector<Object>();

		/*Vector<String> hang = new Vector<String>();
		hang.add("09241009");
		hang.add("�����");
		hang.add("��");
		hang.add("22");
		hang.add("���ϲ���");
		hang.add("������Ϣ����");
		Vector<String> hang1 = new Vector<String>();
		hang1.add("09241045");
		hang1.add("���ĺ�");
		hang1.add("��");
		hang1.add("22");
		hang1.add("���հ���");
		hang1.add("������Ϣ����");*/
		
		/*if (title.equals("������Ϣ")) {
			sql = "select * from ������Ϣ��" ;
		}else if (title.equals("��ʦ��Ϣ")) {
			sql = "select * from ��ʦ��Ϣ��" ;
		}else {
			sql = "select * from ����Ա��Ϣ��" ;
		}*/
		
		
		/**
		 * ����һ��SQLHelper���󣬴�����check()�����л��ָ��
		 * SQL���Ľ����������ÿ�����������rowDate�У����
		 * ��ʾ��JTabel��
		 */
		SQLHelper sh = new SQLHelper();
		ResultSet rs = sh.query(sql);
		try {
			
			while (rs.next()) {
				
				Vector<String> row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				row.add(rs.getString(7));
				row.add(rs.getString(9));
				rowData.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if (sh!=null) {
				sh.close();
			}
		}
		
	}
	
	/***
	 * ����rowDate���� �����ã�ִ��ɾ�����ݿ�����ʱ��������ʱ�������ݿ�
	 * ��JTable�Ļ���������ݿ�������ݺ�JTable�������ݲ�һ��
	 * @return ���ص�ǰJTable��������
	 */
	public Vector<Object> getRowData()
	{
		return rowData;
	}
	
	//��дAbstractTabelModel�ķ���
	public int getColumnCount()
	{
		return this.columnNames.size() ;
	}
	public int getRowCount()
	{
		return this.rowData.size() ;
	}
	public Object getValueAt(int row,int column)
	{
		return ((Vector<?>)this.rowData.get(row)).get(column);
	}

	public String getColumnName(int column)
	{
		return (String)(this.columnNames.get(column));
	}
	
	
}