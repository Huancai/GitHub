/**
 * @author 吴焕才
 * @time 2011-11-15 02:00:15
 * @functions 考生考试，信息中心，考试界面，考试在该界面上进行答题
 *  @Participator 考生
 */
package com.exam.view;


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.exam.model.News_Model;
import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.*;

public class Student_mianFrame extends JFrame implements ActionListener,MouseListener{

	/**
	 * 定义需要组件
	 */
	//获得从登陆框输入用户名相对应的名字
	private static String strUserName = GetUserName.getName().toString().trim();
	private static final long serialVersionUID = 1L;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static BufferedReader br = null ;
	/**
	 * 定义菜单组件
	 */
	private JMenuBar jmb ;
	private JMenu jm1,jm2,jm3,jm4,jm5;
	private JMenuItem jm1_jmt1,jm1_jmt2,jm1_jmt3,jm1_jmt4,jm1_jmt5;
	private ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
	private JToolBar jtb;
	private JButton jb1,jb2,jb3,jb4,jb5;
	
	private JLabel jlbTime = null ;
	private JPanel jpAll = null ;
	private JPanel jpWest,jpCenter = null ;
	private JPanel jp1,jp2,jp3,jp4,jp5 ;
	private JLabel jpWest_jlb0,jpWest_jlb1,jpWest_jlb2,jpWest_jlb3,jpWest_jlb4,jpWest_jlb5;
	JLabel jpCenter_2_jlbRight,jpCenter_2_jlbLeft ;
	private CardLayout cl = null ;
	
	/**消息公告*/
	private static JTable table = null ;
	private static News_Model model = null ;
	private static JTextField textField = null ;
	private static JTextArea textArea = null ;
	private static JLabel label1,label2 = null ;
	private static String news_title = "" ;
	
	public static void main(String[] args) {

		Student_mianFrame s = new Student_mianFrame();
		s.tray();
		System.out.println(strUserName);
	}
	
	public Student_mianFrame()
	{
		/**
		 * 将整个面板定义为空布局
		 */
		this.setLayout(null); 
		
		
		/**
		 * 创建标题图片
		 */
		Image im = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim = new BackImage(im);
		bim.setBounds(0,0,width-100,100);
		
		
		/**
		 * 调用initMenu，initToolBar 方法创建菜单和工具栏
		 */
		this.initMenu();
		this.initToolBar();
		
		
		/**
		 * 放置考试时间
		 */
		Image im2 = new ImageIcon("images/hengtiaobeijing.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		jlbTime = new JLabel("    "+strUserName.concat("同学，欢迎您！  今天是: "+GetTime.getTime()));
		bim2.setLayout(new BorderLayout());
		jlbTime.setFont(MyFonts.f2);
		bim2.add(jlbTime,"West");
		bim2.setBounds(0,100,width-100,30);
		javax.swing.Timer time = new Timer(1000, this);
		time.start();
		
		
		/**
		 * 处理中部：
		 * jpAll为除了标题图和放置时间的面板外的面板，它包含了jpWest，jpCenter。
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
	 * 响应ActionListener事件
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		jlbTime.setText("    "+strUserName.concat("同学，欢迎您！  今天是: "+GetTime.getTime()));
		
	}

	
	
	
	/**
	 * 处理菜单
	 */
	public void initMenu()
	{

		/**
		 * 创建以及菜单
		 */
		jm1 = new JMenu("文件(F)");
		jm1.setFont(MyFonts.f12);
		jm2 = new JMenu("编辑(E)");
		jm2.setFont(MyFonts.f12);
		jm3 = new JMenu("格式(O)");
		jm3.setFont(MyFonts.f12);
		jm4 = new JMenu("查看(V)");
		jm4.setFont(MyFonts.f12);
		jm5 = new JMenu("帮助(H)");
		jm5.setFont(MyFonts.f12);
		
		/**
		 * jm1的二级菜单的图标
		 */
		jm1_icon1 = new ImageIcon("images//icon_0.png");
		jm1_icon2 = new ImageIcon("images//icon_1.png");
		jm1_icon3 = new ImageIcon("images//icon_10.png");
		jm1_icon4 = new ImageIcon("images//icon_11.png");
		jm1_icon5 = new ImageIcon("images//icon_12.png");
		
		/**
		 * jm1的二级菜单
		 */
		jm1_jmt1 = new JMenuItem("新建(N) Ctrl+N",jm1_icon1);
		jm1_jmt1.setFont(MyFonts.f11);
		jm1_jmt2 = new JMenuItem("打开(O) Ctrl+O",jm1_icon2);
		jm1_jmt2.setFont(MyFonts.f11);
		jm1_jmt3 = new JMenuItem("新建(S) Ctrl+S",jm1_icon3);
		jm1_jmt3.setFont(MyFonts.f11);
		jm1_jmt4 = new JMenuItem("另存为(A)...",jm1_icon4);
		jm1_jmt4.setFont(MyFonts.f11);
		jm1_jmt5 = new JMenuItem("退出(X)",jm1_icon5);
		jm1_jmt5.addActionListener(this);
		jm1_jmt5.setFont(MyFonts.f11);
		
		jm1.add(jm1_jmt1);
		jm1.add(jm1_jmt2);
		jm1.add(jm1_jmt3);
		jm1.add(jm1_jmt4);
		jm1.add(jm1_jmt5);
		
		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
	}
	
	
	
	/**
	 * 处理工具栏
	 */
	public void initToolBar()
	{
		/**
		 * 处理工具栏
		 */
		jb1 = new JButton(new ImageIcon("images//icon_0.png"));
		jb2 = new JButton(new ImageIcon("images//icon_1.png"));
		jb3 = new JButton(new ImageIcon("images//icon_10.png"));
		jb4 = new JButton(new ImageIcon("images//icon_11.png"));
		jb5 = new JButton(new ImageIcon("images//icon_12.png"));
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5); 
		this.setJMenuBar(jmb);
	}
	
	
	
	/**
	 * 处理中部的面板，该面板

	 */
	
	public void initCenter()
	{
		jpAll = new JPanel(new BorderLayout());
		jpAll.setBounds(0,130,width-115, height-285);
		Image im1 = new ImageIcon("images/beijing1.jpg").getImage();
		BackImage bim1 = new BackImage(im1);
		bim1.setLayout(new GridLayout(6,1));
		
		bim1.add(jpWest_jlb0 = new JLabel("首页",new ImageIcon("images/icon_10.png"),0));
		bim1.add(jpWest_jlb1 = new JLabel("信息中心",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb2 = new JLabel("考试中心",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb3 = new JLabel("成绩查询",new ImageIcon("images/icon_12.png"), 0));
		bim1.add(jpWest_jlb4 = new JLabel("帮助",new ImageIcon("images/icon_11.png"), 0));
		bim1.add(jpWest_jlb5 = new JLabel("退出",new ImageIcon("images/icon_1.png"), 0));
		jpWest = new JPanel(new BorderLayout());
		jpWest.add(bim1);
		
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
		 * 将jpCenter面板设为卡片布局，里面包含了五个功能模块
		 */
		cl = new CardLayout();
		jpCenter = new JPanel(cl);
		
		/**考生须知面板*/
		Image im3 = new ImageIcon("images/beijing3.jpg").getImage();
		BackImage bim3 = new BackImage(im3);
		JLabel jlb = new JLabel("<html><pre>'"+xuzhi("F:\\image\\xuzhi.txt")+"'</pre></html>");
		jlb.setFont(MyFonts.f2);
		bim3.add(jlb);
		JScrollPane jspXuzhi = new JScrollPane(bim3);
		
		jpCenter.add(jspXuzhi,"0");
		
		/**
		 * 五个功能模块的主板，每一个面板都包含了对应功能模块下的全部内容。
		 */
		jp1 = new JPanel(new GridLayout(1,2,3,3));
		jp2 = new JPanel(new BorderLayout());
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		
		/**个人信息面板*/
		SQLHelper helper = new SQLHelper();
		ResultSet set = helper.query("select * from 考生信息表 where 用户名='"+User_Login.get_user_name()+"'");
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new Oneself_view("考生信息", set, "考生信息"));
		/**系统公告信息面板*/
		JPanel p2 = new JPanel(new GridLayout(2, 1, 2, 2));
		p2.setBorder(BorderFactory.createTitledBorder(null,"系统公告",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		p1.setBorder(BorderFactory.createTitledBorder(null,"个人信息",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		JPanel p2_1 = new JPanel(new BorderLayout());
		JPanel p2_2 = new JPanel(new BorderLayout());
		p2_1.setBorder(BorderFactory.createTitledBorder(null,"公告列表",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		p2_2.setBorder(BorderFactory.createTitledBorder(null,"公告详情",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		
		/**公告列表*/
		model = new News_Model("select * from 公告消息表");
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		p2_1.add(scrollPane);
		
		/**公告详情界面*/
		String[] news = getNews();
		JPanel p2_2_north = new JPanel();
		label1 = new JLabel("标题");
		label1.setFont(MyFonts.f2);
		textField = new JTextField(45);
		textField.setFont(MyFonts.f2);
		textField.setText(news[0]);
		p2_2_north.add(label1);
		p2_2_north.add(textField);
		textArea = new JTextArea();
		textArea.setFont(MyFonts.f3);
		textArea.append(news[1]);
		label2 = new JLabel();
		label2.setFont(MyFonts.f2);
		textField.setEditable(false);
		textArea.setEditable(false);
		label2.setText("作者：" + news[3] +"      时间:"+news[2]);
		
		p2_2.add(p2_2_north,"North");
		p2_2.add(textArea,"Center");
		p2_2.add(label2,"South");
		
		p2.add(p2_1);
		p2.add(p2_2);
		
		jp1.add(p1);
		jp1.add(p2);
		
		
		/*JLabel jlb2 = new JLabel("<html><pre>'"+xuzhi("F:\\image\\exam.txt")+"'</pre></html>");
		jlb2.setFont(MyFonts.f2);
		jp2.add(jlb2);
		JScrollPane jsp2 = new JScrollPane(jp2);*/
		jp2.add(new Student_p2_view());
		
		jp3.add(new JLabel("成绩查询"));
		jp4.add(new JLabel("帮助"));
		jp5.add(new JLabel("退出"));
		
		jpCenter.add(jp1,"1");
		jpCenter.add(jp2,"2");
		jpCenter.add(jp3,"3");
		jpCenter.add(jp4,"4");
		jpCenter.add(jp5,"5");
		
		
		JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpWest,jpCenter);
		jsp.setOneTouchExpandable(true);
		jsp.setDividerLocation(130);
		
		jpAll.add(jsp);
		
		
	}
	
	
	/**
	 * 响应鼠标（MouseListener）事件############################
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
		}else if (e.getSource()==table&&e.getClickCount()==1) { //当单击公告列表时做出的响应**********
			
			//调用news() 方法
			news();
		}
		else{		
			int i = MyMessage.showConfirmDialog("确定要离开 该系统吗？");
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
	 *  托盘方法
	 */
	public void tray() {
        TrayIcon trayIcon = null;
        SystemTray systemTray = null; //系统托盘
        systemTray = SystemTray.getSystemTray(); //获得系统托盘的实例
        
        PopupMenu pop = new PopupMenu(); // 构造一个右键弹出式菜单
        final MenuItem show = new MenuItem("打开程序");
        final MenuItem exit = new MenuItem("退出程序");
        
        pop.add(show);
        pop.add(exit);
        
        /**
         * 处理show的监听事件
         */
        show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.NORMAL);
				setVisible(true);
			}
		});
        /**
         * 处理exit的监听事件
         */
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
        
        try {
            Image icon = new ImageIcon("images/icon_10.png").getImage();
            trayIcon = new TrayIcon(icon, "在线考试系统",pop);
            systemTray.add(trayIcon); //设置托盘的图标，
        } catch (AWTException e2) {
            e2.printStackTrace();
        }
        this.addWindowListener(
                new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                dispose(); //窗口最小化时dispose该窗口
            }
        });
        trayIcon.addMouseListener(
                new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) //双击托盘窗口再现
                    setExtendedState(Frame.NORMAL); //状态
                setVisible(true);
            }
        });
    }
	
	/**
	 * 从本机设备获得学生须知的内容
	 * @return
	 */
	public static String xuzhi(String path)
	{
		String str1 = "" ;
		String str2 = "" ;
		try {
			br = new BufferedReader(new FileReader(path));
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
		int rowNum = table.getSelectedRow();
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
		System.out.println("table_new.getRowCount():"+table.getRowCount());
		
		news_title = table.getValueAt(rowNum, 0).toString();
		System.out.println("new_title="+news_title);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from 公告消息表 where 标题='"+news_title+"'");
		
		/**清空消息面板里的旧信息，重新加载新信息*/
		textField.setText("");
		textArea.setText("");
		label2.setText("");
		
		try {
			while(set.next())
			{
					
					textField.setText(set.getString(1));
					textArea.append(set.getString(2));
					String date = set.getString(3);
					String author = set.getString(4);
					label2.setText("作者："+author+"    时间：" +date);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
