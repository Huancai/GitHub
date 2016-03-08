/**
 * @author wuhuancai 
 * @time 2012年4月13日 01:33:46
 * 处理用户信息的界面
 */
package com.exam.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.exam.model.*;
import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.MyFonts;
import com.exam.tools.MyMessage;
public class Admin_P1_view extends JPanel implements MouseListener{
	/**
	 * 
	 */
	/**p1_model:考生信息        p2_model:教师信息      p3_model:管理员信息   p4_model:消息公告的面板*/
	private static Admin_P1_Model p1_model,p2_model ,p3_model = null ;
	private static News_Model p4_model = null ;
	private static String userName = "" ;
	private static final long serialVersionUID = 1L;

	private JPanel	teacherPanel,studentPanel,adminPanel,otherPanel ;
	private static JTabbedPane jtp = null ;
	
	//学生信息面板的初始化
	private JPanel jpNorth = null ;
	private JPanel jpSouth = null ;
	private static JLabel jlb,jlbCount = null ;
	private static JTextField jtf = null ;
	private static JTable jtb = null;
	private JScrollPane jsp = null ;
	private JButton jb0,jb1,jb2,jb3,jb_query;
	//教师面板的初始化
	private JPanel jPanelNorth = null ;
	private JPanel jPanelSouth = null ;
	private static JLabel jLabel,jLbCount = null ;
	private static JTextField jTextField = null ;
	private static JTable jTable = null ;
	private JScrollPane jScrollPane = null ;
	private JButton jbt0,jbt1,jbt2,jbt3,jbt_query ;
	//管理员面板的初始化
	private JPanel panelNorth = null ;
	private JPanel panelSouth = null ;
	private static JLabel label,labelCount = null ;
	private static JTextField textField = null ;
	private static JTable table = null ;
	private JScrollPane scrollPane = null ;
	private JButton bt0,bt1,bt2,bt3,bt_query ;
	
	//其他面板
	private static JTextArea jta = null ;
	private static JTextField text_Field = null ;
	private static JTable table_new = null;
	private static String new_title = "" ;
	private static JLabel label_new = null ;
	private static JCheckBox checkBox = null ;
	private static JButton buttonOK = null ;
	/**将角色传到调用者，用于权限管理*/
	public Admin_P1_view(String role)
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
		jpNorth.add(jlb = new JLabel("请输入用户名(或考生准考证号):"));
		jlb.setFont(MyFonts.f2);
		jpNorth.add(jtf = new JTextField(30));
		jtf.setFont(MyFonts.f2);
		jpNorth.add(jb_query = new JButton("查询"));
		jb_query.setFont(MyFonts.f1);
		
		jb_query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				/**调用stuQuery()方法*/
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
		
		p1_model = new Admin_P1_Model("考生信息","select * from 考生信息表");
		
		jtb = new JTable(p1_model);
		jtb.addMouseListener(this);
		jtb.setFont(MyFonts.f2);
		jsp = new JScrollPane(jtb);
		jsp.setBorder(BorderFactory.createTitledBorder(null,"考生信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		
		/**
		 * 处理南部
		 */
		jpSouth = new JPanel(new GridLayout(1,5,5,5));
		jpSouth.add(jlbCount = new JLabel(" 数据库记录:"+p1_model.getRowCount()+"   -当前共有 "+jtb.getRowCount()+" 条记录"));
		jpSouth.add(jb0 = new JButton("详细信息"));
		jpSouth.add(jb1 = new JButton("添加"));
		jpSouth.add(jb2 = new JButton("删除"));
		jpSouth.add(jb3 = new JButton("更新"));
		jlbCount.setFont(MyFonts.f1);
		jb0.setFont(MyFonts.f2);
		jb1.setFont(MyFonts.f2);
		jb2.setFont(MyFonts.f2);
		jb3.setFont(MyFonts.f2);
		//分别处理四个按钮事件
		
		/**查看考生详细信息*/
		jb0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stuInformation();
			}
		});
		
		/**添加学生信息*/
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**删除考生信息*/
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delStuInformation();
			}
		});
		
		/**更新考生信息**/
		jb3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateStuInformation();
			}
		});
		
		
		studentPanel = new JPanel(new BorderLayout());
		studentPanel.add(jsp,"Center");
		studentPanel.add(jpNorth,"North");
		studentPanel.add(jpSouth,"South");
		
		/**
		 * ----------------------------------------------------------------------------------------------------------/
		 */
		/**
		 * 教师面板
		 */
		p2_model = new Admin_P1_Model("教师信息","select * from 教师信息表");
		teacherPanel = new JPanel(new BorderLayout());
		
		jPanelNorth = new JPanel();
		jPanelNorth.add(jLabel = new JLabel("请输入用户名(或教师编号):"));
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
		
		jTable = new JTable(p2_model);
		jScrollPane = new JScrollPane(jTable);
		jScrollPane.setBorder(BorderFactory.createTitledBorder(null,"教师信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		jTable.addMouseListener(this);
		jTable.setFont(MyFonts.f2);
		
		jPanelSouth = new JPanel(new GridLayout(1,5,5,5));
		jPanelSouth.add(jLbCount = new JLabel(" 数据库记录:"+p2_model.getRowCount()+"   -当前共有 "+jTable.getRowCount()+" 条记录"));
		jPanelSouth.add(jbt0 = new JButton("详细信息"));
		jPanelSouth.add(jbt1 = new JButton("添加"));
		jPanelSouth.add(jbt2 = new JButton("删除"));
		jPanelSouth.add(jbt3 = new JButton("更新"));
		jLbCount.setFont(MyFonts.f1);
		jbt0.setFont(MyFonts.f2);
		jbt1.setFont(MyFonts.f2);
		jbt2.setFont(MyFonts.f2);
		jbt3.setFont(MyFonts.f2);
		
		/**将教师面板的三个子面板添加到主面板中*/
		teacherPanel.add(jPanelNorth,"North");
		teacherPanel.add(jScrollPane,"Center");
		teacherPanel.add(jPanelSouth,"South");
		
		/**教师详细信息查询*/
		jbt0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherInformation();
			}
		});
		
		/**添加教师信息*/
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**教师删除*/
		jbt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delTeacherInformation();
			}
		});
		
		
		/**更新教师信息 */
		jbt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTeacherInformation();
			}
		});
		
		
		/**
		 * -------------------------------------------------------------------------------------------------------------------------
		 * 管理员面板
		 */
		
		p3_model = new Admin_P1_Model("管理员信息","select * from 管理员信息表");
		adminPanel = new JPanel(new BorderLayout());
		
		panelNorth = new JPanel();
		panelNorth.add(label = new JLabel("请输入用户名(或管理员编号):"));
		label.setFont(MyFonts.f2);
		panelNorth.add(textField = new JTextField(30));
		textField.setFont(MyFonts.f2);
		panelNorth.add(bt_query = new JButton("查询"));
		bt_query.setFont(MyFonts.f1);
		bt_query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminQuery();
			}
		});
		
		textField.addKeyListener(new KeyListener() {
			
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
					adminQuery();
				}
			}
		});
		
		
		table = new JTable(p3_model);
		scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder(null,"管理员信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		table.addMouseListener(this);
		table.setFont(MyFonts.f2);
		
		panelSouth = new JPanel(new GridLayout(1,5,5,5));
		panelSouth.add(labelCount = new JLabel(" 数据库记录:"+p3_model.getRowCount()+"   -当前共有 "+table.getRowCount()+" 条记录"));
		panelSouth.add(bt0 = new JButton("详细信息"));
		panelSouth.add(bt1 = new JButton("添加"));
		panelSouth.add(bt2 = new JButton("删除"));
		panelSouth.add(bt3 = new JButton("更新"));
		labelCount.setFont(MyFonts.f1);
		bt0.setFont(MyFonts.f2);
		bt1.setFont(MyFonts.f2);
		bt2.setFont(MyFonts.f2);
		bt3.setFont(MyFonts.f2);
		
		adminPanel.add(panelNorth,"North");
		adminPanel.add(scrollPane,"Center");
		adminPanel.add(panelSouth,"South");
		
		/**管理员详细信息查询*/
		bt0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminInformation();
			}
		});
		
		/**添加管理员信息*/
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**管理员删除*/
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delAdminInformation();
			}
		});
		
		
		/**更新管理员信息 */
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAdminInformation();
			}
		});
	
		/**
		 * -------------------------------------------------------------------------------------------------------------------------
		 * 其他 面板
		 */
		p4_model = new News_Model("select * from 公告消息表");
		
		otherPanel = new JPanel(new GridLayout(1,2,3,3));
		
		String SQL = "" ;
		String ROLE = User_Login.get_user_role().toString();
		String TITLE = "" ;
		if (ROLE.equals("教师")) {
			SQL = "select * from 教师信息表 where 用户名='"+User_Login.get_user_name()+"'" ;
			TITLE = "教师信息" ;
		}else if (ROLE.equals("管理员")) {
			SQL = "select * from 管理员信息表 where 用户名='"+User_Login.get_user_name()+"'" ;
			TITLE = "管理员信息" ;
		}
		SQLHelper helper = new SQLHelper();
		ResultSet set = helper.query(SQL);
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new Oneself_view(TITLE, set, "管理员信息"));
		
		JPanel p2 = new JPanel(new GridLayout(2, 1, 2, 2));
		p2.setBorder(BorderFactory.createTitledBorder(null,"公告信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		p1.setBorder(BorderFactory.createTitledBorder(null,"个人信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		
		JPanel p2_1 = new JPanel(new BorderLayout());
		JPanel p2_2 = new JPanel(new BorderLayout());
		JPanel p2_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		text_Field = new JTextField(50);
		text_Field.setFont(MyFonts.f2);
		text_Field.setEditable(false);
		checkBox = new JCheckBox("发布公告");
		checkBox.setFont(MyFonts.f2);
		
		JLabel label1 = new JLabel("标题");
		label1.setFont(MyFonts.f2);
		p2_3.add(label1);
		p2_3.add(text_Field);
		p2_3.add(checkBox);
		
		p2_1.setBorder(BorderFactory.createTitledBorder(null,"公告列表",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		p2_2.setBorder(BorderFactory.createTitledBorder(null,"发布公告",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		/**公告列表*/
		table_new = new JTable(p4_model);
		JScrollPane crollPane = new JScrollPane(table_new);
		table_new.addMouseListener(this);
		p2_1.add(crollPane); 
		
		jta = new JTextArea();
		jta.setFont(MyFonts.f2);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		buttonOK = new JButton("发送");
		buttonOK.setEnabled(false);
		buttonOK.setFont(MyFonts.f2);
		/**用户显示公告发布作者和发布时间*/
		label_new = new JLabel();
		label_new.setFont(MyFonts.f2);
		
		p2_2.add(jsp,"Center");
		p2_2.add(buttonOK,"East");
		p2_2.add(p2_3,"North");
		p2_2.add(label_new,"South");
		
		p2.add(p2_1,"Center");
		p2.add(p2_2,"South");
		otherPanel.add(p1);
		otherPanel.add(p2);
		
		/****给各个组件赋初始值*****/
		String news[] = getNews();
		text_Field.setText(news[0]);
		jta.append(news[1]);
		label_new.setText("作者："+news[3]+"    时间：" +news[2]);
		
		if (role.equals("教师")) {
			checkBox.setEnabled(false);
			buttonOK.setEnabled(false);
			text_Field.setEditable(false);
		}
		
		/**监听复选框事件，选中则提交按钮为可用状态*/
		checkBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(checkBox.isSelected())
				{
					text_Field.setEditable(true);
					jta.setEditable(true);
					buttonOK.setEnabled(true);
					text_Field.setText("");
					jta.setText("");
					label_new.setText("");
				}else {
					String news[] = getNews();
					text_Field.setEditable(false);
					buttonOK.setEnabled(false);
					jta.setEditable(false);
					text_Field.setText(news[0]);
					jta.append(news[1]);
					label_new.setText("作者："+news[3]+"    时间：" +news[2]);
				}
			}
		});
		/**处理发送按钮，将文本域中的内容保存到数据库中*/
		buttonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**发布公告后更新消息公告列表面板*/
				String sql = "select * from 公告消息表 where 标题 like '%"+""+"%'" ;
				News_Model model = new News_Model(sql);
				table_new.setModel(model);
				
				/**
				 * titleStr:公告标题
				 * txt:公告正文
				 * author：公告作者
				 */
				String titleStr = text_Field.getText();
				String txt = jta.getText();
				String author = User_Login.get_user_name();
				String sql_insert = "insert into 公告消息表(标题,正文,作者) values ('"+titleStr+"','"+txt+"','"+author+"')" ;
				SQLHelper helpe = new SQLHelper();
				int n = helpe.insert(sql_insert);
				if (n==1) {
					MyMessage.showMessageDialog("您好，你的消息已经成功发布！！");
				}else 
				{
					MyMessage.showMessageDialog("您好，你的消息发布失败！！");
				}
				
			}
		});
		
		//#######################################################################################
		/**将teacherPanel,adminPanel,studentPanel 加入到jtp*/
		jtp = new JTabbedPane();
		jtp.setFont(MyFonts.f2);
		jtp.add(studentPanel,"考生信息");
		jtp.add(teacherPanel,"教师信息");
		jtp.add(adminPanel,"管理员信息");
		jtp.add(otherPanel,"其他");
		this.add(jtp,"Center");
		
		this.setVisible(true);
		
		
		/**权限设置,其中用户名为"admin"的管理员是超级管理员，拥有最高(全部)权限*/
		if (role.equals("管理员")) {
			if(!User_Login.get_user_name().equals("admin"))
			{
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				bt3.setEnabled(false);
			}
		}else if (role.equals("教师")) {
			jbt1.setEnabled(false);
			jbt2.setEnabled(false);
			jbt3.setEnabled(false);
			jtp.setEnabledAt(2, false);
		}
		
	}
	
	/**---------------------------------------------------考生面板信息处理(四个按钮)---------------------------------------------------------------*/
	/**
	 * 学生面板查询处理
	 */
	public static void stuQuery()
	{
		String name = jtf.getText().toString().trim();
		String sql = "select * from 考生信息表 where 用户名 like '%" + name +"%' or 准考证号 like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("考生信息","select * from 考生信息表");
		
		jtb.setModel(new Admin_P1_Model("", sql));
		/**查询时更新当前JTabel的行数*/
		jlbCount.setText(" 数据库记录:"+p.getRowCount()+"  当前共有 "+jtb.getRowCount()+" 条记录");
	}
	
	/**
	 * 查看学生详细信息
	 * 
	 */
	public static void stuInformation()
	{
		int rowNum = jtb.getSelectedRow();
		/**获得当前选中行对应数据库中的行号*/
	/*	for (int i = 0; i < p1_model.getRowCount(); i++) {
			if (p1_model.getValueAt(rowNum, 0).toString().equals(p1_model.getValueAt(i, 0).toString())) {
				rowNum = i ;
				break ;
			}
		}*/
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要查看的一行记录！");
			return ;
		}
		System.out.println("p1_model.getRowCount():"+p1_model.getRowCount());
		
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 考生信息表 where 用户名='"+userName+"'");
		
		 new Information_view("考生信息",set,"详细信息");
	}
	
	/**
	 * 删除学生信息，响应jb2
	 */
	public static void delStuInformation()
	{
		int rowNum = jtb.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要删除的一行记录！");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("成功删除该学生信息后将不能重新恢复！\n确定要删除该学生信息吗？");
		
		if (flag==1) {
			return;
		}
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from 考生信息表 where 用户名 = '"+userName+"'");
		
		if (n==1) {
			/**删除成功后更新JTable数据，用remove方法删除JTable当前行号为rowNum的数据*/
			p1_model.getRowData().remove(rowNum);
			
			MyMessage.showMessageDialog("你已成功删除用户名为 " + userName + " 的考生信息！");
			/**更新jtb面板，显示删除后的数据*/
			
			/**更新jtb面板，显示删除后的数据*/
			stuQuery();
		}else {
			MyMessage.showMessageDialog("删除失败！");
			return ;
		}
	}
	
	/**
	 * 更新学生信息，也就是修改学生信息，响应jb3
	 */
	public static void updateStuInformation()
	{
		/**获得选中的行号*/
		int rowNum = jtb.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要更新的一行记录！");
			return ;
		}
		
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 考生信息表 where 用户名='"+userName+"'");
		
		 new Information_view("考生信息",set,"更新");
		 
		 /**更新 后对JLabel进行刷新，显示更新后的数据*/
		 stuQuery();
	}
	
	/**----------------------------------------教师信息处理面板(四个面板)-----------------------------------------------------------------*/
	
	/**
	 * 教师面板查询处理
	 */
	
	public static void teaQuery()
	{
		String name = jTextField.getText().toString().trim();
		//String sql = "select * from 教师信息表 where 用户名 like '%" + name +"%'" ;
		String sql = "select * from 教师信息表 where 用户名 like '%" + name +"%' or 编号 like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("教师信息","select * from 教师信息表");
		jTable.setModel(new Admin_P1_Model("", sql));
		
		/**查询时更新当前JTabel的行数*/
		jLbCount.setText(" 数据库记录:"+p.getRowCount()+"   -当前共有 "+jTable.getRowCount()+" 条记录");
	}
	
	/**
	 * 查看教师详细信息
	 */
	public static void teacherInformation()
	{
		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要查看的一行记录！");
			return ;
		}
		
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 教师信息表 where 用户名='"+userName+"'");
		
		 new Information_view("教师信息",set,"详细信息");
	}
	
	/**
	 * 删除教师信息
	 */
	public static void delTeacherInformation()
	{

		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要删除的一行记录！");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("成功删除该教师信息后将不能重新恢复！\n确定要删除该教师信息吗？");
		
		if (flag==1) {
			return;
		}
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from 教师信息表 where 用户名 = '"+userName+"'");
		
		if (n==1) {
			p2_model.getRowData().remove(rowNum);
			MyMessage.showMessageDialog("你已成功删除用户名为 " + userName + " 的教师信息！");
			/**更新jTabel面板，显示删除后的数据*/
			//jTable.setModel(new Admin_P1_Model("教师信息","select * from 教师信息表"));
			
			/**更新jTabel面板，显示删除后的数据*/
			teaQuery();
		}else {
			MyMessage.showMessageDialog("删除失败！");
			return ;
		}
	}
	
	/**
	 * 更新教师信息
	 */
	public static void updateTeacherInformation()
	{
		/**获得选中的行号*/
		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要更新的一行记录！");
			return ;
		}
		
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 教师信息表 where 用户名='"+userName+"'");
		
		 new Information_view("教师信息",set,"更新");
		 
		 /**更新 后对JLabel进行刷新，显示更新后的数据*/
		 teaQuery();
	}
	/**----------------------------------------管理员信息处理面板(四个面板)-----------------------------------------------------------------*/
	/**
	 * 管理员面板查询处理
	 */
	
	public static void adminQuery()
	{
		String name = textField.getText().toString().trim();
		//String sql = "select * from 教师信息表 where 用户名 like '%" + name +"%'" ;
		String sql = "select * from 管理员信息表 where 用户名 like '%" + name +"%' or 编号 like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("管理员信息","select * from 管理员信息表");
		table.setModel(new Admin_P1_Model("", sql));
		
		/**查询时更新当前JTabel的行数*/
		labelCount.setText(" 数据库记录:"+p.getRowCount()+"   -当前共有 "+table.getRowCount()+" 条记录");
	}
	
	/**
	 * 查看管理员详细信息
	 */
	public static void adminInformation()
	{
		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要查看的一行记录！");
			return ;
		}
		
		userName = table.getValueAt(rowNum, 0).toString();
		//System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 管理员信息表 where 用户名='"+userName+"'");
		
		 new Information_view("管理员信息",set,"详细信息");
	}
	
	/**
	 * 删除教师信息
	 */
	public static void delAdminInformation()
	{

		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要删除的一行记录！");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("成功删除该管理员信息后将不能重新恢复！\n确定要删除该管理员信息吗？");
		
		if (flag==1) {
			return;
		}
		userName = table.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from 管理员信息表 where 用户名 = '"+userName+"'");
		
		if (n==1) {
			
			/**删除成功后更新JTable数据，用remove方法删除JTable当前行号为rowNum的数据*/
			p3_model.getRowData().remove(rowNum);
			
			MyMessage.showMessageDialog("你已成功删除用户名为 " + userName + " 的管理员信息！");
			/**更新tabel面板，显示删除后的数据*/
			//table.setModel(new Admin_P1_Model("管理员信息","select * from 管理员信息表"));
			
			/**更新tabel面板，显示删除后的数据*/
			adminQuery();
		}else {
			MyMessage.showMessageDialog("删除失败！");
			return ;
		}
	}
	
	/***
	 *更新管理员信息，一般只有超级管理员才能执行该操作 
	 */
	public static void updateAdminInformation()
	{
		/**获得选中的行号*/
		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要更新的一行记录！");
			return ;
		}
		
		userName = table.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 管理员信息表 where 用户名='"+userName+"'");
		
		 new Information_view("管理员信息",set,"更新");
		 
		 /**更新 后对JLabel进行刷新，显示更新后的数据*/
		 adminQuery();
	}

	
	/**响应鼠标事件 主要是处理在考生，教师，管理员面板，公告信息面板双击或单击某行数据时自动显示其详细信息*/
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource()==jtb&&e.getClickCount()==2) {
			stuInformation();
		}
		else if (e.getSource()==jTable&&e.getClickCount()==2) {
			teacherInformation();
		}
		else if (e.getSource()==table&&e.getClickCount()==2) {
			adminInformation();
		}else if (e.getSource()==table_new&&e.getClickCount()==1) {
			news();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 *从数据库中获得系统公告的内容 
	 **/
	
	public static String[] getNews()
	{
		String[] str = new String[4];
		
		SQLHelper helper = new SQLHelper();
		String sql = "select * from 公告消息表" ;
		
		try {
			ResultSet set = helper.query(sql);
			while(set.next())
			{
				str[0] = set.getString(1);
				str[1] = set.getString(2);
				str[2] = set.getString(3);
				str[3] = set.getString(4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str ;
	}
	
	/**
	 * 点击公告列表上的内容，显示公告详情
	 * 
	 */
	public static void news()
	{
		int rowNum = table_new.getSelectedRow();
		/**获得当前选中行对应数据库中的行号*/
	/*	for (int i = 0; i < p1_model.getRowCount(); i++) {
			if (p1_model.getValueAt(rowNum, 0).toString().equals(p1_model.getValueAt(i, 0).toString())) {
				rowNum = i ;
				break ;
			}
		}*/
		if (rowNum==-1) {
			MyMessage.showMessageDialog("请选中要查看的一行记录！");
			return ;
		}
		System.out.println("table_new.getRowCount():"+table_new.getRowCount());
		
		new_title = table_new.getValueAt(rowNum, 0).toString();
		System.out.println("new_title="+new_title);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 公告消息表 where 标题='"+new_title+"'");
		
		/**清空消息面板里的旧信息，重新加载新信息*/
		text_Field.setText("");
		jta.setText("");
		label_new.setText("");
		
		try {
			while(set.next())
			{
					text_Field.setEditable(false);
					jta.setEditable(false);
					text_Field.setText(set.getString(1));
					jta.append(set.getString(2));
					String date = set.getString(3);
					String author = set.getString(4);
					label_new.setText("作者："+author+"    时间：" +date);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
