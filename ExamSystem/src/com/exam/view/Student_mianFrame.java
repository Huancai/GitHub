/**
 * @author �����
 * @time 2011-11-15 02:00:15
 * @functions �������ԣ���Ϣ���ģ����Խ��棬�����ڸý����Ͻ��д���
 *  @Participator ����
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
	 * ������Ҫ���
	 */
	//��ôӵ�½�������û������Ӧ������
	private static String strUserName = GetUserName.getName().toString().trim();
	private static final long serialVersionUID = 1L;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static BufferedReader br = null ;
	/**
	 * ����˵����
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
	
	/**��Ϣ����*/
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
		 * ��������嶨��Ϊ�ղ���
		 */
		this.setLayout(null); 
		
		
		/**
		 * ��������ͼƬ
		 */
		Image im = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim = new BackImage(im);
		bim.setBounds(0,0,width-100,100);
		
		
		/**
		 * ����initMenu��initToolBar ���������˵��͹�����
		 */
		this.initMenu();
		this.initToolBar();
		
		
		/**
		 * ���ÿ���ʱ��
		 */
		Image im2 = new ImageIcon("images/hengtiaobeijing.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		jlbTime = new JLabel("    "+strUserName.concat("ͬѧ����ӭ����  ������: "+GetTime.getTime()));
		bim2.setLayout(new BorderLayout());
		jlbTime.setFont(MyFonts.f2);
		bim2.add(jlbTime,"West");
		bim2.setBounds(0,100,width-100,30);
		javax.swing.Timer time = new Timer(1000, this);
		time.start();
		
		
		/**
		 * �����в���
		 * jpAllΪ���˱���ͼ�ͷ���ʱ�����������壬��������jpWest��jpCenter��
		 */
			this.initCenter();
		
		
		
		/**
		 * �������������������
		 */
		Container ct = this.getContentPane();
		ct.add(bim);
		ct.add(jpAll);
		ct.add(bim2);
		
		
		
		/**
		 * ���ô��������
		 */
		this.setTitle("���߿���ϵͳ");
		this.setSize(width-100, height-80);
		this.setIconImage(new ImageIcon("images/icon_1.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

/**-----------------------------------------------------------------------------------------**/	
	
	/**
	 * ��ӦActionListener�¼�
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		jlbTime.setText("    "+strUserName.concat("ͬѧ����ӭ����  ������: "+GetTime.getTime()));
		
	}

	
	
	
	/**
	 * ����˵�
	 */
	public void initMenu()
	{

		/**
		 * �����Լ��˵�
		 */
		jm1 = new JMenu("�ļ�(F)");
		jm1.setFont(MyFonts.f12);
		jm2 = new JMenu("�༭(E)");
		jm2.setFont(MyFonts.f12);
		jm3 = new JMenu("��ʽ(O)");
		jm3.setFont(MyFonts.f12);
		jm4 = new JMenu("�鿴(V)");
		jm4.setFont(MyFonts.f12);
		jm5 = new JMenu("����(H)");
		jm5.setFont(MyFonts.f12);
		
		/**
		 * jm1�Ķ����˵���ͼ��
		 */
		jm1_icon1 = new ImageIcon("images//icon_0.png");
		jm1_icon2 = new ImageIcon("images//icon_1.png");
		jm1_icon3 = new ImageIcon("images//icon_10.png");
		jm1_icon4 = new ImageIcon("images//icon_11.png");
		jm1_icon5 = new ImageIcon("images//icon_12.png");
		
		/**
		 * jm1�Ķ����˵�
		 */
		jm1_jmt1 = new JMenuItem("�½�(N) Ctrl+N",jm1_icon1);
		jm1_jmt1.setFont(MyFonts.f11);
		jm1_jmt2 = new JMenuItem("��(O) Ctrl+O",jm1_icon2);
		jm1_jmt2.setFont(MyFonts.f11);
		jm1_jmt3 = new JMenuItem("�½�(S) Ctrl+S",jm1_icon3);
		jm1_jmt3.setFont(MyFonts.f11);
		jm1_jmt4 = new JMenuItem("���Ϊ(A)...",jm1_icon4);
		jm1_jmt4.setFont(MyFonts.f11);
		jm1_jmt5 = new JMenuItem("�˳�(X)",jm1_icon5);
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
	 * ��������
	 */
	public void initToolBar()
	{
		/**
		 * ��������
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
	 * �����в�����壬�����

	 */
	
	public void initCenter()
	{
		jpAll = new JPanel(new BorderLayout());
		jpAll.setBounds(0,130,width-115, height-285);
		Image im1 = new ImageIcon("images/beijing1.jpg").getImage();
		BackImage bim1 = new BackImage(im1);
		bim1.setLayout(new GridLayout(6,1));
		
		bim1.add(jpWest_jlb0 = new JLabel("��ҳ",new ImageIcon("images/icon_10.png"),0));
		bim1.add(jpWest_jlb1 = new JLabel("��Ϣ����",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb2 = new JLabel("��������",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb3 = new JLabel("�ɼ���ѯ",new ImageIcon("images/icon_12.png"), 0));
		bim1.add(jpWest_jlb4 = new JLabel("����",new ImageIcon("images/icon_11.png"), 0));
		bim1.add(jpWest_jlb5 = new JLabel("�˳�",new ImageIcon("images/icon_1.png"), 0));
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
		 * ��jpCenter�����Ϊ��Ƭ���֣�����������������ģ��
		 */
		cl = new CardLayout();
		jpCenter = new JPanel(cl);
		
		/**������֪���*/
		Image im3 = new ImageIcon("images/beijing3.jpg").getImage();
		BackImage bim3 = new BackImage(im3);
		JLabel jlb = new JLabel("<html><pre>'"+xuzhi("F:\\image\\xuzhi.txt")+"'</pre></html>");
		jlb.setFont(MyFonts.f2);
		bim3.add(jlb);
		JScrollPane jspXuzhi = new JScrollPane(bim3);
		
		jpCenter.add(jspXuzhi,"0");
		
		/**
		 * �������ģ������壬ÿһ����嶼�����˶�Ӧ����ģ���µ�ȫ�����ݡ�
		 */
		jp1 = new JPanel(new GridLayout(1,2,3,3));
		jp2 = new JPanel(new BorderLayout());
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		
		/**������Ϣ���*/
		SQLHelper helper = new SQLHelper();
		ResultSet set = helper.query("select * from ������Ϣ�� where �û���='"+User_Login.get_user_name()+"'");
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(new Oneself_view("������Ϣ", set, "������Ϣ"));
		/**ϵͳ������Ϣ���*/
		JPanel p2 = new JPanel(new GridLayout(2, 1, 2, 2));
		p2.setBorder(BorderFactory.createTitledBorder(null,"ϵͳ����",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		p1.setBorder(BorderFactory.createTitledBorder(null,"������Ϣ",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		JPanel p2_1 = new JPanel(new BorderLayout());
		JPanel p2_2 = new JPanel(new BorderLayout());
		p2_1.setBorder(BorderFactory.createTitledBorder(null,"�����б�",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		p2_2.setBorder(BorderFactory.createTitledBorder(null,"��������",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		
		/**�����б�*/
		model = new News_Model("select * from ������Ϣ��");
		table = new JTable(model);
		table.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(table);
		p2_1.add(scrollPane);
		
		/**�����������*/
		String[] news = getNews();
		JPanel p2_2_north = new JPanel();
		label1 = new JLabel("����");
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
		label2.setText("���ߣ�" + news[3] +"      ʱ��:"+news[2]);
		
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
		
		jp3.add(new JLabel("�ɼ���ѯ"));
		jp4.add(new JLabel("����"));
		jp5.add(new JLabel("�˳�"));
		
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
	 * ��Ӧ��꣨MouseListener���¼�############################
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
		}else if (e.getSource()==table&&e.getClickCount()==1) { //�����������б�ʱ��������Ӧ**********
			
			//����news() ����
			news();
		}
		else{		
			int i = MyMessage.showConfirmDialog("ȷ��Ҫ�뿪 ��ϵͳ��");
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
	 *  ���̷���
	 */
	public void tray() {
        TrayIcon trayIcon = null;
        SystemTray systemTray = null; //ϵͳ����
        systemTray = SystemTray.getSystemTray(); //���ϵͳ���̵�ʵ��
        
        PopupMenu pop = new PopupMenu(); // ����һ���Ҽ�����ʽ�˵�
        final MenuItem show = new MenuItem("�򿪳���");
        final MenuItem exit = new MenuItem("�˳�����");
        
        pop.add(show);
        pop.add(exit);
        
        /**
         * ����show�ļ����¼�
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
         * ����exit�ļ����¼�
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
            trayIcon = new TrayIcon(icon, "���߿���ϵͳ",pop);
            systemTray.add(trayIcon); //�������̵�ͼ�꣬
        } catch (AWTException e2) {
            e2.printStackTrace();
        }
        this.addWindowListener(
                new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                dispose(); //������С��ʱdispose�ô���
            }
        });
        trayIcon.addMouseListener(
                new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) //˫�����̴�������
                    setExtendedState(Frame.NORMAL); //״̬
                setVisible(true);
            }
        });
    }
	
	/**
	 * �ӱ����豸���ѧ����֪������
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
		int rowNum = table.getSelectedRow();
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
		System.out.println("table_new.getRowCount():"+table.getRowCount());
		
		news_title = table.getValueAt(rowNum, 0).toString();
		System.out.println("new_title="+news_title);
		System.out.println("rowNum=" + rowNum);
		SQLHelper help = new SQLHelper();
		ResultSet set = help.query("select * from ������Ϣ�� where ����='"+news_title+"'");
		
		/**�����Ϣ�����ľ���Ϣ�����¼�������Ϣ*/
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
					label2.setText("���ߣ�"+author+"    ʱ�䣺" +date);
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
