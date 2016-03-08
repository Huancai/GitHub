package com.exam.model;
/**
**用于刷新表JTabel的信息
*/
import javax.swing.table.* ;
import java.sql.* ;
import java.util.*;
import javax.swing.*;

import com.exam.sqlHelper.SQLHelper;

public class News_Model extends AbstractTableModel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//定义组件
	Vector<Object> rowData,columnNames ;	
	JTable jtb = null ;
	Connection ct = null ;
	Statement sm = null ;	
	ResultSet rs = null ;
	
	//private static String sql = null ;
	
	public News_Model(String sql)
	{
		columnNames = new Vector<Object>();
		columnNames.add("公告标题");
		columnNames.add("发布时间");
		columnNames.add("作者");
		
		rowData = new Vector<Object>();

		/*Vector<String> hang = new Vector<String>();
		hang.add("09241009");
		hang.add("吴焕才");
		hang.add("男");
		hang.add("22");
		hang.add("海南昌江");
		hang.add("电子信息工程");
		Vector<String> hang1 = new Vector<String>();
		hang1.add("09241045");
		hang1.add("吴文海");
		hang1.add("男");
		hang1.add("22");
		hang1.add("安徽安庆");
		hang1.add("电子信息工程");*/
		
		/*if (title.equals("考生信息")) {
			sql = "select * from 考生信息表" ;
		}else if (title.equals("教师信息")) {
			sql = "select * from 教师信息表" ;
		}else {
			sql = "select * from 管理员信息表" ;
		}*/
		
		
		/**
		 * 创建一个SQLHelper对象，从它的check()方法中获得指定
		 * SQL语句的结果集，并将每个结果集放入rowDate中，最后
		 * 显示在JTabel中
		 */
		SQLHelper sh = new SQLHelper();
		ResultSet rs = sh.query(sql);
		try {
			
			while (rs.next()) {
				
				Vector<String> row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				
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
	 * 返回rowDate对象 ，作用：执行删除数据库数据时，若不及时更新数据库
	 * 或JTable的话会出现数据库的行数据和JTable的行数据不一致
	 * @return 返回当前JTable的行数据
	 */
	public Vector<Object> getRowData()
	{
		return rowData;
	}
	
	//覆写AbstractTabelModel的方法
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