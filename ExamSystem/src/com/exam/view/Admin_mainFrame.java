/**
 * @author �����
 * @Participator ����Ա
 * @time 2011��11��12��13:47:49
 * @function ����Ա�Ĺ����̨
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

	
	//��ôӵ�½�������û������Ӧ������
		private static String strUserName = null ;
	/**
	 * ������Ҫ���
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
		 * ���ñ���ͼƬ 
		 * ��BackImage�ഴ��
		 */
		Image im = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim = new BackImage(im);
		bim.setBounds(0,0,width-100,100);
		
	
		/**
		 * ��ʾ��ǰ�û������õ�ǰʱ��
		 */
		Image im2 = new ImageIcon("images/hengtiaobeijing.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		
		/** ����ʱ�����ʾ�û�����״̬�� */
		jlbTime = new JLabel("   "+strUserName+"����Ա����ӭ����  ������: "+GetTime.getTime());
		bim2.setLayout(new BorderLayout());
		jlbTime.setFont(MyFonts.f2);
		bim2.add(jlbTime,"West");
		bim2.setBounds(0,100,width-100,30);
		javax.swing.Timer time = new Timer(1000, this);
		time.start();
		
		/**
		 * �����в�
		 */
	
		jpAll = new JPanel(new BorderLayout());
		jpAll.setBounds(0,130,width-117, height-230);
		
		Image im1 = new ImageIcon("images/beijing1.jpg").getImage();
		BackImage bim1 = new BackImage(im1);
		bim1.setLayout(new GridLayout(6,1));
		
		bim1.add(jpWest_jlb0 = new JLabel("��ҳ",new ImageIcon("images/icon_10.png"),0));
		bim1.add(jpWest_jlb1 = new JLabel("��Ϣ����",new ImageIcon("images/icon_1.png"), 0));
		bim1.add(jpWest_jlb2 = new JLabel("�ɼ���ѯ",new ImageIcon("images/icon_0.png"), 0));
		bim1.add(jpWest_jlb3 = new JLabel("��������",new ImageIcon("images/icon_12.png"), 0));
		bim1.add(jpWest_jlb4 = new JLabel("ϵͳ����",new ImageIcon("images/icon_11.png"), 0));
		bim1.add(jpWest_jlb5 = new JLabel("�˳�",new ImageIcon("images/icon_1.png"), 0));
		jpWest = new JPanel(new BorderLayout());
		jpWest.add(bim1);
		jpWest.setBorder(BorderFactory.createTitledBorder(null,"����Ա��Ϣ",TitledBorder.CENTER,TitledBorder.TOP,MyFonts.f3));
		
		cl = new CardLayout();
		jpCenter = new JPanel(cl);
		Image im3 = new ImageIcon("images/beijing.jpg").getImage();
		BackImage bim3 = new BackImage(im3);
		jpCenter.add(bim3,"0");
		
		/**
		 * �������ģ������壬������ʾ��Ӧ���ܵ�����壬
		 * ��û��ʼд
		 */
		jp0 = new JPanel(new BorderLayout());
		jp1 = new JPanel(new BorderLayout());
		jp2 = new JPanel(new BorderLayout());
		jp3 = new JPanel(new BorderLayout());
		jp4 = new JPanel(new BorderLayout());
		jp5 = new JPanel(new BorderLayout());
		/**��txt�ļ���ԭ��ʽ��������֪��ӡ��jlb0��*/
		jp0.add(jlb0 = new JLabel("<html><pre>'"+ xuzhi()+"'</pre></html>")); //-------
		jlb0.setFont(MyFonts.f2);
		
		jsp0 = new JScrollPane(jp0);
//		jp1.add(new Admin_P1_view("����Ա"));
//		jp2.add(new Score_view());
//		jp3.add(new Admin_p3_view());
//		jp4.add(new Admin_P4_view());
		jp5.add(new JLabel("�˳�"));
		
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
		 * �ֱ��jpWest_jlb0-jpWest_jlb5��������
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
		this.setSize(width-100, height-60);
		this.setIconImage(new ImageIcon("images/icon_1.png").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		jlbTime.setText("   "+strUserName+"����Ա����ӭ����  ������: "+GetTime.getTime());
		
	}

	/**
	 * ��Ӧ����¼�
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
			int i = MyMessage.showConfirmDialog("ȷ��Ҫ�˳�ϵͳ��");
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
	 * ����״̬��
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
