/**
 * @author 吴焕才
 * @Participator 管理员
 * @time 2011年11月12日13:47:49
 * @function 管理员的管理后台
 */

package com.exam.view;

 
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.*;

public class Admin_mainFrame extends JFrame implements ActionListener,MouseListener{

	
	//获得从登陆框输入用户名相对应的名字
		private static String strUserName = null ;
	/**
	 * 定义需要组件
	 */
	private static final long serialVersionUID = 1L;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;


	
	private JLabel jlbTime,jlb0 = null ;
	private JPanel jpAll = null ;
	private JPanel jpWest,jpCenter = null ;
	private JPanel jp0,jp1,jp2,jp3,jp4,jp5 ;
	private JLabel jpWest_jlb0,jpWest_jlb1,jpWest_jlb2,jpWest_jlb3,jpWest_jlb4,jpWest_jlb5;
	JLabel jpCenter_2_jlbRight,jpCenter_2_jlbLeft ;
	private CardLayout cl = null ;
	private static BufferedReader br = null ;
	private static JScrollPane jsp0 = null ;
	public static void main(String[] args) {

		new Admin_mainFrame();
		
	}
	
	public Admin_mainFrame()
	{
//		strUserName = GetUserName.getName().toString().trim();
		strUserName = "Vincent.wu";
		//System.out.println("********"+strUserName);
		this.setLayout(null); 
		/**
		 * 设置标题图片 
		 * 从BackImage类创建
		 */
		Image im = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim = new BackImage(im);
		bim.setBounds(0,0,width-100,100);
		
	
		/**
		 * 显示当前用户，放置当前时间
		 */
		Image im2 = new ImageIcon("images/hengtiaobeijing.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		
		/** 放置时间和显示用户名的状态栏 */
		jlbTime = new JLabel("   "+strUserName+"管理员，欢迎您！  今天是: "+GetTime.getTime());
		bim2.setLayout(new BorderLayout());
		jlbTime.setFont(MyFonts.f2);
		bim2.add(jlbTime,"West");
		bim2.setBounds(0,100,width-100,30);
		javax.swing.Timer time = new Timer(1000, this);
		time.start();
		
		/**
		 * 处理中部
		 */
	
		jpAll = new JPanel(new BorderLayout());
		jpAll.setBounds(0,130,width-117, height-230);
		
		Image im1 = new ImageIcon("images/beijing1.jpg").getImage();
		BackImage bim1 = new BackImage(im1);
		bim1.setLayout(new GridLayout(6,1));
		
		bim1.add(jpWest_jlb0 = new JLabel("首页",new ImageIcon("images/icon_10.png"),0));
		bim1.add(jpWest_jlb1 = new JLabel("信息管理",new ImageIcon("images/icon_1.png"), 0));
		bim1.add(jpWest_jlb2 = new JLabel("成绩查询",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb3 = new JLabel("考试中心",new ImageIcon("images/icon_12.png"), 0));
		bim1.add(jpWest_jlb4 = new JLabel("系统设置",new ImageIcon("images/icon_11.png"), 0));
		bim1.add(jpWest_jlb5 = new JLabel("退出",new ImageIcon("images/icon_1.png"), 0));
		jpWest = new JPanel(new BorderLayout());
		jpWest.add(bim1);
		jpWest.setBorder(BorderFactory.createTitledBorder(null,"管理员信息",TitledBorder.CENTER,TitledBorder.TOP,MyFonts.f3));
		
		cl = new CardLayout();
		jpCenter = new JPanel(cl);
		Image im3 = new ImageIcon("images/beijing.jpg").getImage();
		BackImage bim3 = new BackImage(im3);
		jpCenter.add(bim3,"0");
		
		/**
		 * 五个功能模块的主板，用于显示对应功能的主面板，
		 * 还没开始写
		 */
		jp0 = new JPanel(new BorderLayout());
		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new BorderLayout());
		jp3 = new JPanel(new BorderLayout());
		jp4 = new JPanel(new BorderLayout());
		jp5 = new JPanel(new BorderLayout());
		/**按txt文件的原格式将考试须知打印到jlb0中*/
		jp0.add(jlb0 = new JLabel("<html><pre>'"+ xuzhi()+"'</pre></html>")); //-------
		jlb0.setFont(MyFonts.f2);
		
		jsp0 = new JScrollPane(jp0);
//		jp1.add(new Admin_P1_view("管理员"));
//		jp2.add(new Score_view());
//		jp3.add(new Admin_p3_view());
//		jp4.add(new Admin_P4_view());
		jp5.add(new JLabel("退出"));
		
		jpCenter.add(jsp0,"0");
		jpCenter.add(jp1,"1");
		jpCenter.add(jp2,"2");
		jpCenter.add(jp3,"3");
		jpCenter.add(jp4,"4");
		jpCenter.add(jp5,"5");
		
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpWest,jpCenter);
		jsp.setOneTouchExpandable(true);
		jsp.setDividerLocation(130);
		
		jpAll.add(jsp);
		
		/**
		 * 分别对jpWest_jlb0-jpWest_jlb5设置属性
		 */
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
		this.setSize(width-100, height-60);
		this.setIconImage(new ImageIcon("images/icon_1.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		jlbTime.setText("   "+strUserName+"管理员，欢迎您！  今天是: "+GetTime.getTime());
		
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
			int i = MyMessage.showConfirmDialog("确定要退出系统吗？");
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
	 * 处理状态栏
	 */
	/**
	public void initZhuangtailan()
	{
		jpZhuangtailan = new JPanel(new BorderLayout());
		Image image = new ImageIcon("images/zhuangtailan1.jpg").getImage();
		BackImage ibg = new BackImage(image);
		ibg.setLayout(new BorderLayout());
		javax.swing.Timer timer = new Timer(1000, this);
		jlbTime = new JLabel(GetTime.getTime());
		jlbTime.setFont(MyFonts.f2);
		ibg.add(jlbTime,"East");
		jpZhuangtailan.add(ibg);
		timer.start();
	}
	*/
	
	public static String xuzhi()
	{
		String str1 = "" ;
		String str2 = "" ;
		try {
			br = new BufferedReader(new FileReader("zhuce.txt"));
			while((str1=br.readLine())!=null)
			{
				str2 += str1+"\n";
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(str2);
		return str2;
	}
	
}
