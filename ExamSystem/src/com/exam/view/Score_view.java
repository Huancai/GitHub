/**
 * @author wuhuancai
 * @time 2012��4��25��17:00:24
 * ������ʾ�������Գɼ�����壬��������������ɫ��
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
	
	//ѧ����Ϣ���ĳ�ʼ��
	private JPanel jpNorth = null ;
	private JPanel jpSouth = null ;
	private JLabel jlb = null ;
	private static JTextField jtf = null ;
	private static JTable jtb = null;
	private JScrollPane jsp = null ;
	private JButton jb0,jb1,jb2,jb3,jb_query;
	//��ʦ���ĳ�ʼ��
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
		 * �������
		 * 
		 */
		
		/**
		 * ������JPanel ����һ����ʾ����������
		 */
		jpNorth = new JPanel();
		jpNorth.add(jlb = new JLabel("�������û���(��׼��֤��):"));
		jlb.setFont(MyFonts.f2);
		jpNorth.add(jtf = new JTextField(30));
		jtf.setFont(MyFonts.f2);
		jpNorth.add(jb_query = new JButton("��ѯ"));
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
		 * �м��JTabel,����û���Ϣ������
		 */
		Score_view_Model p1 = new Score_view_Model("������Ϣ","select * from �����ɼ���");
		
		jtb = new JTable(p1);
		jtb.setFont(MyFonts.f3);
		jsp = new JScrollPane(jtb);
		
		/**
		 * �����ϲ�
		 */
		jpSouth = new JPanel(new GridLayout(1,4,5,5));
		jpSouth.add(jb0 = new JButton("��ϸ��Ϣ"));
		jpSouth.add(jb1 = new JButton("���"));
		jpSouth.add(jb2 = new JButton("ɾ��"));
		jpSouth.add(jb3 = new JButton("����"));
		jb0.setFont(MyFonts.f2);
		jb1.setFont(MyFonts.f2);
		jb2.setFont(MyFonts.f2);
		jb3.setFont(MyFonts.f2);
		//�ֱ����ĸ���ť�¼�
		
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
		 * ��ʦ���
		 */
		/*Admin_P1_Model p2 = new Admin_P1_Model("��ʦ��Ϣ","select * from ��ʦ��Ϣ��");
		teacherPanel = new JPanel(new BorderLayout());
		
		jPanelNorth = new JPanel();
		jPanelNorth.add(jLabel = new JLabel("�������û���(���û����):"));
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
		jPanelSouth = new JPanel(new GridLayout(1,4,5,5));
		jPanelSouth.add(jbt0 = new JButton("��ϸ��Ϣ"));
		jPanelSouth.add(jbt1 = new JButton("���"));
		jPanelSouth.add(jbt2 = new JButton("ɾ��"));
		jPanelSouth.add(jbt3 = new JButton("����"));
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
		 * ����Ա���
		 */
		/*adminPanel = new JPanel();
		
		jtp = new JTabbedPane();
		jtp.setFont(MyFonts.f2);
		jtp.add(scorePanel,"������Ϣ");
		jtp.add(teacherPanel,"��ʦ��Ϣ");
		jtp.add(adminPanel,"����Ա��Ϣ");
		jtp.setEnabledAt(2, false)*/;
		
		this.add(jpNorth,"North");
		this.add(jsp,"Center");
		this.add(jpSouth,"South");
		
		this.setVisible(true);
	}
	
	/**
	 * ѧ������ѯ����
	 */
	public static void stuQuery()
	{
		String name = jtf.getText().toString().trim();
		String sql = "select * from �����ɼ��� where �û��� like '%" + name +"%' or ׼��֤�� like '"+name+"%'" ;
		Score_view_Model p = new Score_view_Model("", sql);
		jtb.setModel(p);
	}
	
	/**
	 * ��ʦ����ѯ����
	 */
	/*public static void teaQuery()
	{
		String name = jTextField.getText().toString().trim();
		//String sql = "select * from ��ʦ��Ϣ�� where �û��� like '%" + name +"%'" ;
		String sql = "select * from ��ʦ��Ϣ�� where �û��� like '%" + name +"%' or ��� like '"+name+"%'" ;
		Admin_P1_Model p = new Admin_P1_Model("", sql);
		jTable.setModel(p);
	}*/
}
