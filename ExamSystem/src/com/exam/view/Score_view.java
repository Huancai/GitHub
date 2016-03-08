/**
 * @author wuhuancai
 * @time 2012年4月25日17:00:24
 * 用于显示考生考试成绩的面板，可以用于三个角色中
 */
package com.exam.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.exam.model.*;
import com.exam.tools.MyFonts;

public class Score_view extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel	scorePanel ;
	
	//学生信息面板的初始化
	private JPanel jpNorth = null ;
	private JPanel jpSouth = null ;
	private JLabel jlb = null ;
	private static JTextField jtf = null ;
	private static JTable jtb = null;
	private JScrollPane jsp = null ;
	private JButton jb0,jb1,jb2,jb3,jb_query;
	//教师面板的初始化
	/*private JPanel jPanelNorth = null ;
	private JPanel jPanelSouth = null ;
	private JLabel jLabel = null ;
	private static JTextField jTextField = null ;
	private static JTable jTable = null ;
	private JScrollPane jScrollPane = null ;
	private JButton jbt0,jbt1,jbt2,jbt3,jbt_query ;*/
	
	
	public Score_view()
	{
		this.setLayout(new BorderLayout());
		
		/**--------------------------------------------------------------------------------------------------------------------
		 * 考生面板
		 * 
		 */
		
		/**
		 * 北部的JPanel 放置一个提示标题和输入框
		 */
		jpNorth = new JPanel();
		jpNorth.add(jlb = new JLabel("请输入用户名(或准考证号):"));
		jlb.setFont(MyFonts.f2);
		jpNorth.add(jtf = new JTextField(30));
		jtf.setFont(MyFonts.f2);
		jpNorth.add(jb_query = new JButton("查询"));
		jb_query.setFont(MyFonts.f1);
		
		jb_query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				stuQuery();
			}
		});
		
		jtf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					stuQuery();
				}
				
			}
		});
		
		/**
		 * 中间的JTabel,存放用户信息的正文
		 */
		Score_view_Model p1 = new Score_view_Model("考生信息","select * from 考生成绩表");
		
		jtb = new JTable(p1);
		jtb.setFont(MyFonts.f3);
		jsp = new JScrollPane(jtb);
		
		/**
		 * 处理南部
		 */
		jpSouth = new JPanel(new GridLayout(1,4,5,5));
		jpSouth.add(jb0 = new JButton("详细信息"));
		jpSouth.add(jb1 = new JButton("添加"));
		jpSouth.add(jb2 = new JButton("删除"));
		jpSouth.add(jb3 = new JButton("更新"));
		jb0.setFont(MyFonts.f2);
		jb1.setFont(MyFonts.f2);
		jb2.setFont(MyFonts.f2);
		jb3.setFont(MyFonts.f2);
		//分别处理四个按钮事件
		
		jb0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		scorePanel = new JPanel(new BorderLayout());
		scorePanel.add(jsp,"Center");
		scorePanel.add(jpNorth,"North");
		scorePanel.add(jpSouth,"South");
		
		/**
		 * ----------------------------------------------------------------------------------------------------------
		 */
		/**
		 * 教师面板
		 */
		/*Admin_P1_Model p2 = new Admin_P1_Model("教师信息","select * from 教师信息表");
		teacherPanel = new JPanel(new BorderLayout());
		
		jPanelNorth = new JPanel();
		jPanelNorth.add(jLabel = new JLabel("请输入用户名(或用户编号):"));
		jLabel.setFont(MyFonts.f2);
		jPanelNorth.add(jTextField = new JTextField(30));
		jTextField.setFont(MyFonts.f2);
		jPanelNorth.add(jbt_query = new JButton("查询"));
		jbt_query.setFont(MyFonts.f1);
		jbt_query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teaQuery();
			}
		});
		
		jTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar()==KeyEvent.VK_ENTER) {
					teaQuery();
				}
			}
		})
		;
		jPanelSouth = new JPanel(new GridLayout(1,4,5,5));
		jPanelSouth.add(jbt0 = new JButton("详细信息"));
		jPanelSouth.add(jbt1 = new JButton("添加"));
		jPanelSouth.add(jbt2 = new JButton("删除"));
		jPanelSouth.add(jbt3 = new JButton("更新"));
		jbt0.setFont(MyFonts.f2);
		jbt1.setFont(MyFonts.f2);
		jbt2.setFont(MyFonts.f2);
		jbt3.setFont(MyFonts.f2);
		
		jTable = new JTable(p2);
		jScrollPane = new JScrollPane(jTable);
		jTable.setFont(MyFonts.f3);
		teacherPanel.add(jPanelNorth,"North");
		teacherPanel.add(jScrollPane,"Center");
		teacherPanel.add(jPanelSouth,"South");*/
		
		/**
		 * -------------------------------------------------------------------------------------------------------------------------
		 * 管理员面板
		 */
		/*adminPanel = new JPanel();
		
		jtp = new JTabbedPane();
		jtp.setFont(MyFonts.f2);
		jtp.add(scorePanel,"考生信息");
		jtp.add(teacherPanel,"教师信息");
		jtp.add(adminPanel,"管理员信息");
		jtp.setEnabledAt(2, false)*/;
		
		this.add(jpNorth,"North");
		this.add(jsp,"Center");
		this.add(jpSouth,"South");
		
		this.setVisible(true);
	}
	
	/**
	 * 学生面板查询处理
	 */
	public static void stuQuery()
	{
		String name = jtf.getText().toString().trim();
		String sql = "select * from 考生成绩表 where 用户名 like '%" + name +"%' or 准考证号 like '"+name+"%'" ;
		Score_view_Model p = new Score_view_Model("", sql);
		jtb.setModel(p);
	}
	
	/**
	 * 教师面板查询处理
	 */
	/*public static void teaQuery()
	{
		String name = jTextField.getText().toString().trim();
		//String sql = "select * from 教师信息表 where 用户名 like '%" + name +"%'" ;
		String sql = "select * from 教师信息表 where 用户名 like '%" + name +"%' or 编号 like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("", sql);
		jTable.setModel(p);
	}*/
}
