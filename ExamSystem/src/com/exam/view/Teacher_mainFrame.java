/**
 * @author 吴焕才
 * @function 老师管理模块，老师可以在该模块下改题
 * @time 2011-11-12 17:11:38
 */
package com.exam.view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.*;

public class Teacher_mainFrame extends JFrame implements ActionListener,MouseListener{

	//获得从登陆框输入用户名相对应的名字
			private static String strUserName = null ;
	/**
	 * 定义需要组件
	 */
	private static final long serialVersionUID = 1L;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	private JLabel jlbTime = null ;
	private JPanel jpAll = null ;
	private JPanel jpWest,jpCenter ;
	private JPanel jp1,jp2,jp3,jp4,jp5 ;
	private JLabel jpWest_jlb0,jpWest_jlb1,jpWest_jlb2,jpWest_jlb3,jpWest_jlb4,jpWest_jlb5;
	JLabel jpCenter_2_jlbRight,jpCenter_2_jlbLeft ;
	private CardLayout cl = null ;
	
	public static void main(String[] args) {

		new Teacher_mainFrame();
	}
	
	public Teacher_mainFrame()
	{
		strUserName = GetUserName.getName().toString().trim();
		System.out.println("********"+strUserName);
		this.setLayout(null); 
		
		/**
		 * 创建标题图片
		 */
		Image im = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim = new BackImage(im);
		bim.setBounds(0,0,width-100,100);
		

	
		/**
		 * 放置考试时间
		 */
		Image im2 = new ImageIcon("images/hengtiaobeijing.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		
		jlbTime = new JLabel("   "+strUserName+"老师，欢迎您！  今天是: "+GetTime.getTime());
		bim2.setLayout(new BorderLayout());
		jlbTime.setFont(MyFonts.f2);
		bim2.add(jlbTime,"West");
		bim2.setBounds(0,100,width-100,30);
		javax.swing.Timer time = new Timer(1000, this);
		time.start();
		
		
		/**
		 * 处理中部
		 */
		this.initCenter();
		
		
		/**
		 * 将各个组件加入容器中
		 */
		Container ct = this.getContentPane();
		ct.add(bim);
		ct.add(jpAll);
		ct.add(bim2);
		
		
		/**
		 * 设置窗体的属性
		 */
		this.setTitle("在线考试系统");
		this.setSize(width-100, height-80);
		this.setIconImage(new ImageIcon("images/icon_1.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

/**-----------------------------------------------------------------------------------------**/	
	
	/**
	 * 响应ActionListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		jlbTime.setText("   "+strUserName+"老师，欢迎您！  今天是: "+GetTime.getTime());
		
	}

	
	/**
	 * 响应鼠标事件
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource()==jpWest_jlb0) {
			
			cl.show(jpCenter,"0");
		}else if (e.getSource()==jpWest_jlb1) {
			cl.show(jpCenter,"1");
		}else if (e.getSource()==jpWest_jlb2) {
			cl.show(jpCenter,"2");
		}else if (e.getSource()==jpWest_jlb3) {
			cl.show(jpCenter, "3");
		}else if (e.getSource()==jpWest_jlb4) {
			cl.show(jpCenter, "4");
		}
		else{		
			int i = MyMessage.showConfirmDialog("确定要退出系统吗？", new ImageIcon("images/icon_10.png"));
			if (i==0) {
				SQLHelper helper =  new SQLHelper();
				helper.close();
				System.exit(0);
			}
			else
			{
				return ;
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource()==jpWest_jlb0) {
			jpWest_jlb0.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb1) {
			jpWest_jlb1.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb2) {
			jpWest_jlb2.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb3) {
			jpWest_jlb3.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb4) {
			jpWest_jlb4.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb4) {
			jpWest_jlb4.setEnabled(true);
		}else if (e.getSource()==jpWest_jlb5) {
			jpWest_jlb5.setEnabled(true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource()==jpWest_jlb0) {
			jpWest_jlb0.setEnabled(false);
		}else if (e.getSource()==jpWest_jlb1) {
			jpWest_jlb1.setEnabled(false);
		}else if (e.getSource()==jpWest_jlb2) {
			jpWest_jlb2.setEnabled(false);
		}else if (e.getSource()==jpWest_jlb3) {
			jpWest_jlb3.setEnabled(false);
		}else if (e.getSource()==jpWest_jlb4) {
			jpWest_jlb4.setEnabled(false);
		}else if (e.getSource()==jpWest_jlb5) {
			jpWest_jlb5.setEnabled(false);
		}
	}
	
	
	
	
	/**
	 * 处理中部
	 */
	public void initCenter()
	{
		/**
		 * 处理中部
		 */
	
		jpAll = new JPanel(new BorderLayout());
		jpAll.setBounds(0,130,width-120, height-245);
		Image im1 = new ImageIcon("images/beijing1.jpg").getImage();
		BackImage bim1 = new BackImage(im1);
		bim1.setLayout(new GridLayout(6,1));
		
		bim1.add(jpWest_jlb0 = new JLabel("首页",new ImageIcon("images/icon_10.png"),0));
		bim1.add(jpWest_jlb1 = new JLabel("信息中心",new ImageIcon("images/icon_1.png"), 0));
		bim1.add(jpWest_jlb2 = new JLabel("成绩查询",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb3 = new JLabel("评卷中心",new ImageIcon("images/icon_12.png"), 0));
		bim1.add(jpWest_jlb4 = new JLabel("帮助",new ImageIcon("images/icon_11.png"), 0));
		bim1.add(jpWest_jlb5 = new JLabel("退出",new ImageIcon("images/icon_1.png"), 0));
		jpWest = new JPanel(new BorderLayout());
		jpWest.add(bim1);
		
		cl = new CardLayout();
		jpCenter = new JPanel(cl);
		Image im3 = new ImageIcon("images/beijing.jpg").getImage();
		BackImage bim3 = new BackImage(im3);
		jpCenter.add(bim3,"0");
		
		/**
		 * 五个功能模块的主板
		 */
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp1.add(new JLabel("信息中心"));
		jp2.add(new JLabel("成绩查询"));
		jp3.add(new JLabel("考试中心"));
		jp4.add(new JLabel("帮助"));
		jp5.add(new JLabel("退出"));
		
		jpCenter.add(new Admin_P1_view("教师"),"1");
		jpCenter.add(new Score_view(),"2");
		jpCenter.add(jp3,"3");
		jpCenter.add(jp4,"4");
		jpCenter.add(jp5,"5");
		

		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpWest,jpCenter);
		jsp.setOneTouchExpandable(true);
		jsp.setDividerLocation(130);
		
		jpAll.add(jsp);
		
		jpWest_jlb0.setFont(MyFonts.f6);
		jpWest_jlb1.setFont(MyFonts.f6);
		jpWest_jlb2.setFont(MyFonts.f6);
		jpWest_jlb3.setFont(MyFonts.f6);
		jpWest_jlb4.setFont(MyFonts.f6);
		jpWest_jlb5.setFont(MyFonts.f6);
		
		jpWest_jlb0.setEnabled(false);
		jpWest_jlb1.setEnabled(false);
		jpWest_jlb2.setEnabled(false);
		jpWest_jlb3.setEnabled(false);
		jpWest_jlb4.setEnabled(false);
		jpWest_jlb5.setEnabled(false);
		
		jpWest_jlb0.addMouseListener(this);
		jpWest_jlb1.addMouseListener(this);
		jpWest_jlb2.addMouseListener(this);
		jpWest_jlb3.addMouseListener(this);
		jpWest_jlb4.addMouseListener(this);
		jpWest_jlb5.addMouseListener(this);
		
		jpWest_jlb0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpWest_jlb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpWest_jlb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpWest_jlb3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpWest_jlb4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jpWest_jlb5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	}
	
}
