/**
 * @author wuhuancai 
 * @time 2012��4��13�� 01:33:46
 * �����û���Ϣ�Ľ���
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
	/**p1_model:������Ϣ        p2_model:��ʦ��Ϣ      p3_model:����Ա��Ϣ   p4_model:��Ϣ��������*/
	private static Admin_P1_Model p1_model,p2_model ,p3_model = null ;
	private static News_Model p4_model = null ;
	private static String userName = "" ;
	private static final long serialVersionUID = 1L;

	private JPanel	teacherPanel,studentPanel,adminPanel,otherPanel ;
	private static JTabbedPane jtp = null ;
	
	//ѧ����Ϣ���ĳ�ʼ��
	private JPanel jpNorth = null ;
	private JPanel jpSouth = null ;
	private static JLabel jlb,jlbCount = null ;
	private static JTextField jtf = null ;
	private static JTable jtb = null;
	private JScrollPane jsp = null ;
	private JButton jb0,jb1,jb2,jb3,jb_query;
	//��ʦ���ĳ�ʼ��
	private JPanel jPanelNorth = null ;
	private JPanel jPanelSouth = null ;
	private static JLabel jLabel,jLbCount = null ;
	private static JTextField jTextField = null ;
	private static JTable jTable = null ;
	private JScrollPane jScrollPane = null ;
	private JButton jbt0,jbt1,jbt2,jbt3,jbt_query ;
	//����Ա���ĳ�ʼ��
	private JPanel panelNorth = null ;
	private JPanel panelSouth = null ;
	private static JLabel label,labelCount = null ;
	private static JTextField textField = null ;
	private static JTable table = null ;
	private JScrollPane scrollPane = null ;
	private JButton bt0,bt1,bt2,bt3,bt_query ;
	
	//�������
	private static JTextArea jta = null ;
	private static JTextField text_Field = null ;
	private static JTable table_new = null;
	private static String new_title = "" ;
	private static JLabel label_new = null ;
	private static JCheckBox checkBox = null ;
	private static JButton buttonOK = null ;
	/**����ɫ���������ߣ�����Ȩ�޹���*/
	public Admin_P1_view(String role)
	{
		this.setLayout(new BorderLayout());
		
		/**--------------------------------------------------------------------------------------------------------------------
		 * �������
		 * 
		 */
		
		/**
		 * ������JPanel ����һ����ʾ����������
		 */
		jpNorth = new JPanel();
		jpNorth.add(jlb = new JLabel("�������û���(����׼��֤��):"));
		jlb.setFont(MyFonts.f2);
		jpNorth.add(jtf = new JTextField(30));
		jtf.setFont(MyFonts.f2);
		jpNorth.add(jb_query = new JButton("��ѯ"));
		jb_query.setFont(MyFonts.f1);
		
		jb_query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				/**����stuQuery()����*/
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
		 * �м��JTabel,����û���Ϣ������
		 */
		
		p1_model = new Admin_P1_Model("������Ϣ","select * from ������Ϣ��");
		
		jtb = new JTable(p1_model);
		jtb.addMouseListener(this);
		jtb.setFont(MyFonts.f2);
		jsp = new JScrollPane(jtb);
		jsp.setBorder(BorderFactory.createTitledBorder(null,"������Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		
		/**
		 * �����ϲ�
		 */
		jpSouth = new JPanel(new GridLayout(1,5,5,5));
		jpSouth.add(jlbCount = new JLabel(" ���ݿ��¼:"+p1_model.getRowCount()+"   -��ǰ���� "+jtb.getRowCount()+" ����¼"));
		jpSouth.add(jb0 = new JButton("��ϸ��Ϣ"));
		jpSouth.add(jb1 = new JButton("���"));
		jpSouth.add(jb2 = new JButton("ɾ��"));
		jpSouth.add(jb3 = new JButton("����"));
		jlbCount.setFont(MyFonts.f1);
		jb0.setFont(MyFonts.f2);
		jb1.setFont(MyFonts.f2);
		jb2.setFont(MyFonts.f2);
		jb3.setFont(MyFonts.f2);
		//�ֱ����ĸ���ť�¼�
		
		/**�鿴������ϸ��Ϣ*/
		jb0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				stuInformation();
			}
		});
		
		/**���ѧ����Ϣ*/
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**ɾ��������Ϣ*/
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delStuInformation();
			}
		});
		
		/**���¿�����Ϣ**/
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
		 * ��ʦ���
		 */
		p2_model = new Admin_P1_Model("��ʦ��Ϣ","select * from ��ʦ��Ϣ��");
		teacherPanel = new JPanel(new BorderLayout());
		
		jPanelNorth = new JPanel();
		jPanelNorth.add(jLabel = new JLabel("�������û���(���ʦ���):"));
		jLabel.setFont(MyFonts.f2);
		jPanelNorth.add(jTextField = new JTextField(30));
		jTextField.setFont(MyFonts.f2);
		jPanelNorth.add(jbt_query = new JButton("��ѯ"));
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
		jScrollPane.setBorder(BorderFactory.createTitledBorder(null,"��ʦ��Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		jTable.addMouseListener(this);
		jTable.setFont(MyFonts.f2);
		
		jPanelSouth = new JPanel(new GridLayout(1,5,5,5));
		jPanelSouth.add(jLbCount = new JLabel(" ���ݿ��¼:"+p2_model.getRowCount()+"   -��ǰ���� "+jTable.getRowCount()+" ����¼"));
		jPanelSouth.add(jbt0 = new JButton("��ϸ��Ϣ"));
		jPanelSouth.add(jbt1 = new JButton("���"));
		jPanelSouth.add(jbt2 = new JButton("ɾ��"));
		jPanelSouth.add(jbt3 = new JButton("����"));
		jLbCount.setFont(MyFonts.f1);
		jbt0.setFont(MyFonts.f2);
		jbt1.setFont(MyFonts.f2);
		jbt2.setFont(MyFonts.f2);
		jbt3.setFont(MyFonts.f2);
		
		/**����ʦ���������������ӵ��������*/
		teacherPanel.add(jPanelNorth,"North");
		teacherPanel.add(jScrollPane,"Center");
		teacherPanel.add(jPanelSouth,"South");
		
		/**��ʦ��ϸ��Ϣ��ѯ*/
		jbt0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				teacherInformation();
			}
		});
		
		/**��ӽ�ʦ��Ϣ*/
		jbt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**��ʦɾ��*/
		jbt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delTeacherInformation();
			}
		});
		
		
		/**���½�ʦ��Ϣ */
		jbt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTeacherInformation();
			}
		});
		
		
		/**
		 * -------------------------------------------------------------------------------------------------------------------------
		 * ����Ա���
		 */
		
		p3_model = new Admin_P1_Model("����Ա��Ϣ","select * from ����Ա��Ϣ��");
		adminPanel = new JPanel(new BorderLayout());
		
		panelNorth = new JPanel();
		panelNorth.add(label = new JLabel("�������û���(�����Ա���):"));
		label.setFont(MyFonts.f2);
		panelNorth.add(textField = new JTextField(30));
		textField.setFont(MyFonts.f2);
		panelNorth.add(bt_query = new JButton("��ѯ"));
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
		scrollPane.setBorder(BorderFactory.createTitledBorder(null,"����Ա��Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f3));
		table.addMouseListener(this);
		table.setFont(MyFonts.f2);
		
		panelSouth = new JPanel(new GridLayout(1,5,5,5));
		panelSouth.add(labelCount = new JLabel(" ���ݿ��¼:"+p3_model.getRowCount()+"   -��ǰ���� "+table.getRowCount()+" ����¼"));
		panelSouth.add(bt0 = new JButton("��ϸ��Ϣ"));
		panelSouth.add(bt1 = new JButton("���"));
		panelSouth.add(bt2 = new JButton("ɾ��"));
		panelSouth.add(bt3 = new JButton("����"));
		labelCount.setFont(MyFonts.f1);
		bt0.setFont(MyFonts.f2);
		bt1.setFont(MyFonts.f2);
		bt2.setFont(MyFonts.f2);
		bt3.setFont(MyFonts.f2);
		
		adminPanel.add(panelNorth,"North");
		adminPanel.add(scrollPane,"Center");
		adminPanel.add(panelSouth,"South");
		
		/**����Ա��ϸ��Ϣ��ѯ*/
		bt0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminInformation();
			}
		});
		
		/**��ӹ���Ա��Ϣ*/
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
			}
		});
		
		/**����Աɾ��*/
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				delAdminInformation();
			}
		});
		
		
		/**���¹���Ա��Ϣ */
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateAdminInformation();
			}
		});
	
		/**
		 * -------------------------------------------------------------------------------------------------------------------------
		 * ���� ���
		 */
		p4_model = new News_Model("select * from ������Ϣ��");
		
		otherPanel = new JPanel(new GridLayout(1,2,3,3));
		
		String SQL = "" ;
		String ROLE = User_Login.get_user_role().toString();
		String TITLE = "" ;
		if (ROLE.equals("��ʦ")) {
			SQL = "select * from ��ʦ��Ϣ�� where �û���='"+User_Login.get_user_name()+"'" ;
			TITLE = "��ʦ��Ϣ" ;
		}else if (ROLE.equals("����Ա")) {
			SQL = "select * from ����Ա��Ϣ�� where �û���='"+User_Login.get_user_name()+"'" ;
			TITLE = "����Ա��Ϣ" ;
		}
		SQLHelper helper = new SQLHelper();
		ResultSet set = helper.query(SQL);
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new Oneself_view(TITLE, set, "����Ա��Ϣ"));
		
		JPanel p2 = new JPanel(new GridLayout(2, 1, 2, 2));
		p2.setBorder(BorderFactory.createTitledBorder(null,"������Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		p1.setBorder(BorderFactory.createTitledBorder(null,"������Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		
		JPanel p2_1 = new JPanel(new BorderLayout());
		JPanel p2_2 = new JPanel(new BorderLayout());
		JPanel p2_3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		text_Field = new JTextField(50);
		text_Field.setFont(MyFonts.f2);
		text_Field.setEditable(false);
		checkBox = new JCheckBox("��������");
		checkBox.setFont(MyFonts.f2);
		
		JLabel label1 = new JLabel("����");
		label1.setFont(MyFonts.f2);
		p2_3.add(label1);
		p2_3.add(text_Field);
		p2_3.add(checkBox);
		
		p2_1.setBorder(BorderFactory.createTitledBorder(null,"�����б�",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		p2_2.setBorder(BorderFactory.createTitledBorder(null,"��������",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		/**�����б�*/
		table_new = new JTable(p4_model);
		JScrollPane crollPane = new JScrollPane(table_new);
		table_new.addMouseListener(this);
		p2_1.add(crollPane); 
		
		jta = new JTextArea();
		jta.setFont(MyFonts.f2);
		jta.setEditable(false);
		JScrollPane jsp = new JScrollPane(jta);
		buttonOK = new JButton("����");
		buttonOK.setEnabled(false);
		buttonOK.setFont(MyFonts.f2);
		/**�û���ʾ���淢�����ߺͷ���ʱ��*/
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
		
		/****�������������ʼֵ*****/
		String news[] = getNews();
		text_Field.setText(news[0]);
		jta.append(news[1]);
		label_new.setText("���ߣ�"+news[3]+"    ʱ�䣺" +news[2]);
		
		if (role.equals("��ʦ")) {
			checkBox.setEnabled(false);
			buttonOK.setEnabled(false);
			text_Field.setEditable(false);
		}
		
		/**������ѡ���¼���ѡ�����ύ��ťΪ����״̬*/
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
					label_new.setText("���ߣ�"+news[3]+"    ʱ�䣺" +news[2]);
				}
			}
		});
		/**�����Ͱ�ť�����ı����е����ݱ��浽���ݿ���*/
		buttonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/**��������������Ϣ�����б����*/
				String sql = "select * from ������Ϣ�� where ���� like '%"+""+"%'" ;
				News_Model model = new News_Model(sql);
				table_new.setModel(model);
				
				/**
				 * titleStr:�������
				 * txt:��������
				 * author����������
				 */
				String titleStr = text_Field.getText();
				String txt = jta.getText();
				String author = User_Login.get_user_name();
				String sql_insert = "insert into ������Ϣ��(����,����,����) values ('"+titleStr+"','"+txt+"','"+author+"')" ;
				SQLHelper helpe = new SQLHelper();
				int n = helpe.insert(sql_insert);
				if (n==1) {
					MyMessage.showMessageDialog("���ã������Ϣ�Ѿ��ɹ���������");
				}else 
				{
					MyMessage.showMessageDialog("���ã������Ϣ����ʧ�ܣ���");
				}
				
			}
		});
		
		//#######################################################################################
		/**��teacherPanel,adminPanel,studentPanel ���뵽jtp*/
		jtp = new JTabbedPane();
		jtp.setFont(MyFonts.f2);
		jtp.add(studentPanel,"������Ϣ");
		jtp.add(teacherPanel,"��ʦ��Ϣ");
		jtp.add(adminPanel,"����Ա��Ϣ");
		jtp.add(otherPanel,"����");
		this.add(jtp,"Center");
		
		this.setVisible(true);
		
		
		/**Ȩ������,�����û���Ϊ"admin"�Ĺ���Ա�ǳ�������Ա��ӵ�����(ȫ��)Ȩ��*/
		if (role.equals("����Ա")) {
			if(!User_Login.get_user_name().equals("admin"))
			{
				bt1.setEnabled(false);
				bt2.setEnabled(false);
				bt3.setEnabled(false);
			}
		}else if (role.equals("��ʦ")) {
			jbt1.setEnabled(false);
			jbt2.setEnabled(false);
			jbt3.setEnabled(false);
			jtp.setEnabledAt(2, false);
		}
		
	}
	
	/**---------------------------------------------------���������Ϣ����(�ĸ���ť)---------------------------------------------------------------*/
	/**
	 * ѧ������ѯ����
	 */
	public static void stuQuery()
	{
		String name = jtf.getText().toString().trim();
		String sql = "select * from ������Ϣ�� where �û��� like '%" + name +"%' or ׼��֤�� like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("������Ϣ","select * from ������Ϣ��");
		
		jtb.setModel(new Admin_P1_Model("", sql));
		/**��ѯʱ���µ�ǰJTabel������*/
		jlbCount.setText(" ���ݿ��¼:"+p.getRowCount()+"  ��ǰ���� "+jtb.getRowCount()+" ����¼");
	}
	
	/**
	 * �鿴ѧ����ϸ��Ϣ
	 * 
	 */
	public static void stuInformation()
	{
		int rowNum = jtb.getSelectedRow();
		/**��õ�ǰѡ���ж�Ӧ���ݿ��е��к�*/
	/*	for (int i = 0; i < p1_model.getRowCount(); i++) {
			if (p1_model.getValueAt(rowNum, 0).toString().equals(p1_model.getValueAt(i, 0).toString())) {
				rowNum = i ;
				break ;
			}
		}*/
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ�鿴��һ�м�¼��");
			return ;
		}
		System.out.println("p1_model.getRowCount():"+p1_model.getRowCount());
		
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ������Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("������Ϣ",set,"��ϸ��Ϣ");
	}
	
	/**
	 * ɾ��ѧ����Ϣ����Ӧjb2
	 */
	public static void delStuInformation()
	{
		int rowNum = jtb.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫɾ����һ�м�¼��");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("�ɹ�ɾ����ѧ����Ϣ�󽫲������»ָ���\nȷ��Ҫɾ����ѧ����Ϣ��");
		
		if (flag==1) {
			return;
		}
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from ������Ϣ�� where �û��� = '"+userName+"'");
		
		if (n==1) {
			/**ɾ���ɹ������JTable���ݣ���remove����ɾ��JTable��ǰ�к�ΪrowNum������*/
			p1_model.getRowData().remove(rowNum);
			
			MyMessage.showMessageDialog("���ѳɹ�ɾ���û���Ϊ " + userName + " �Ŀ�����Ϣ��");
			/**����jtb��壬��ʾɾ���������*/
			
			/**����jtb��壬��ʾɾ���������*/
			stuQuery();
		}else {
			MyMessage.showMessageDialog("ɾ��ʧ�ܣ�");
			return ;
		}
	}
	
	/**
	 * ����ѧ����Ϣ��Ҳ�����޸�ѧ����Ϣ����Ӧjb3
	 */
	public static void updateStuInformation()
	{
		/**���ѡ�е��к�*/
		int rowNum = jtb.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ���µ�һ�м�¼��");
			return ;
		}
		
		userName = jtb.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ������Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("������Ϣ",set,"����");
		 
		 /**���� ���JLabel����ˢ�£���ʾ���º������*/
		 stuQuery();
	}
	
	/**----------------------------------------��ʦ��Ϣ�������(�ĸ����)-----------------------------------------------------------------*/
	
	/**
	 * ��ʦ����ѯ����
	 */
	
	public static void teaQuery()
	{
		String name = jTextField.getText().toString().trim();
		//String sql = "select * from ��ʦ��Ϣ�� where �û��� like '%" + name +"%'" ;
		String sql = "select * from ��ʦ��Ϣ�� where �û��� like '%" + name +"%' or ��� like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("��ʦ��Ϣ","select * from ��ʦ��Ϣ��");
		jTable.setModel(new Admin_P1_Model("", sql));
		
		/**��ѯʱ���µ�ǰJTabel������*/
		jLbCount.setText(" ���ݿ��¼:"+p.getRowCount()+"   -��ǰ���� "+jTable.getRowCount()+" ����¼");
	}
	
	/**
	 * �鿴��ʦ��ϸ��Ϣ
	 */
	public static void teacherInformation()
	{
		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ�鿴��һ�м�¼��");
			return ;
		}
		
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ��ʦ��Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("��ʦ��Ϣ",set,"��ϸ��Ϣ");
	}
	
	/**
	 * ɾ����ʦ��Ϣ
	 */
	public static void delTeacherInformation()
	{

		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫɾ����һ�м�¼��");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("�ɹ�ɾ���ý�ʦ��Ϣ�󽫲������»ָ���\nȷ��Ҫɾ���ý�ʦ��Ϣ��");
		
		if (flag==1) {
			return;
		}
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from ��ʦ��Ϣ�� where �û��� = '"+userName+"'");
		
		if (n==1) {
			p2_model.getRowData().remove(rowNum);
			MyMessage.showMessageDialog("���ѳɹ�ɾ���û���Ϊ " + userName + " �Ľ�ʦ��Ϣ��");
			/**����jTabel��壬��ʾɾ���������*/
			//jTable.setModel(new Admin_P1_Model("��ʦ��Ϣ","select * from ��ʦ��Ϣ��"));
			
			/**����jTabel��壬��ʾɾ���������*/
			teaQuery();
		}else {
			MyMessage.showMessageDialog("ɾ��ʧ�ܣ�");
			return ;
		}
	}
	
	/**
	 * ���½�ʦ��Ϣ
	 */
	public static void updateTeacherInformation()
	{
		/**���ѡ�е��к�*/
		int rowNum = jTable.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ���µ�һ�м�¼��");
			return ;
		}
		
		userName = jTable.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ��ʦ��Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("��ʦ��Ϣ",set,"����");
		 
		 /**���� ���JLabel����ˢ�£���ʾ���º������*/
		 teaQuery();
	}
	/**----------------------------------------����Ա��Ϣ�������(�ĸ����)-----------------------------------------------------------------*/
	/**
	 * ����Ա����ѯ����
	 */
	
	public static void adminQuery()
	{
		String name = textField.getText().toString().trim();
		//String sql = "select * from ��ʦ��Ϣ�� where �û��� like '%" + name +"%'" ;
		String sql = "select * from ����Ա��Ϣ�� where �û��� like '%" + name +"%' or ��� like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("����Ա��Ϣ","select * from ����Ա��Ϣ��");
		table.setModel(new Admin_P1_Model("", sql));
		
		/**��ѯʱ���µ�ǰJTabel������*/
		labelCount.setText(" ���ݿ��¼:"+p.getRowCount()+"   -��ǰ���� "+table.getRowCount()+" ����¼");
	}
	
	/**
	 * �鿴����Ա��ϸ��Ϣ
	 */
	public static void adminInformation()
	{
		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ�鿴��һ�м�¼��");
			return ;
		}
		
		userName = table.getValueAt(rowNum, 0).toString();
		//System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ����Ա��Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("����Ա��Ϣ",set,"��ϸ��Ϣ");
	}
	
	/**
	 * ɾ����ʦ��Ϣ
	 */
	public static void delAdminInformation()
	{

		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫɾ����һ�м�¼��");
			return ;
		}
		int flag = MyMessage.showConfirmDialog("�ɹ�ɾ���ù���Ա��Ϣ�󽫲������»ָ���\nȷ��Ҫɾ���ù���Ա��Ϣ��");
		
		if (flag==1) {
			return;
		}
		userName = table.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		SQLHelper help = new SQLHelper();
		int n = help.delete("delete from ����Ա��Ϣ�� where �û��� = '"+userName+"'");
		
		if (n==1) {
			
			/**ɾ���ɹ������JTable���ݣ���remove����ɾ��JTable��ǰ�к�ΪrowNum������*/
			p3_model.getRowData().remove(rowNum);
			
			MyMessage.showMessageDialog("���ѳɹ�ɾ���û���Ϊ " + userName + " �Ĺ���Ա��Ϣ��");
			/**����tabel��壬��ʾɾ���������*/
			//table.setModel(new Admin_P1_Model("����Ա��Ϣ","select * from ����Ա��Ϣ��"));
			
			/**����tabel��壬��ʾɾ���������*/
			adminQuery();
		}else {
			MyMessage.showMessageDialog("ɾ��ʧ�ܣ�");
			return ;
		}
	}
	
	/***
	 *���¹���Ա��Ϣ��һ��ֻ�г�������Ա����ִ�иò��� 
	 */
	public static void updateAdminInformation()
	{
		/**���ѡ�е��к�*/
		int rowNum = table.getSelectedRow();
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ���µ�һ�м�¼��");
			return ;
		}
		
		userName = table.getValueAt(rowNum, 0).toString();
		System.out.println("userName="+userName);
		
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ����Ա��Ϣ�� where �û���='"+userName+"'");
		
		 new Information_view("����Ա��Ϣ",set,"����");
		 
		 /**���� ���JLabel����ˢ�£���ʾ���º������*/
		 adminQuery();
	}

	
	/**��Ӧ����¼� ��Ҫ�Ǵ����ڿ�������ʦ������Ա��壬������Ϣ���˫���򵥻�ĳ������ʱ�Զ���ʾ����ϸ��Ϣ*/
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
	 *�����ݿ��л��ϵͳ��������� 
	 **/
	
	public static String[] getNews()
	{
		String[] str = new String[4];
		
		SQLHelper helper = new SQLHelper();
		String sql = "select * from ������Ϣ��" ;
		
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
	 * ��������б��ϵ����ݣ���ʾ��������
	 * 
	 */
	public static void news()
	{
		int rowNum = table_new.getSelectedRow();
		/**��õ�ǰѡ���ж�Ӧ���ݿ��е��к�*/
	/*	for (int i = 0; i < p1_model.getRowCount(); i++) {
			if (p1_model.getValueAt(rowNum, 0).toString().equals(p1_model.getValueAt(i, 0).toString())) {
				rowNum = i ;
				break ;
			}
		}*/
		if (rowNum==-1) {
			MyMessage.showMessageDialog("��ѡ��Ҫ�鿴��һ�м�¼��");
			return ;
		}
		System.out.println("table_new.getRowCount():"+table_new.getRowCount());
		
		new_title = table_new.getValueAt(rowNum, 0).toString();
		System.out.println("new_title="+new_title);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ������Ϣ�� where ����='"+new_title+"'");
		
		/**�����Ϣ�����ľ���Ϣ�����¼�������Ϣ*/
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
					label_new.setText("���ߣ�"+author+"    ʱ�䣺" +date);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
