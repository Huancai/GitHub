/**
 * @author �����
 * @function  �����û���¼����
 * @Participator ��������ʦ��ϵͳ����Ա
 * @time 2011-11-12 15:59:40
 */
package com.exam.view;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

import com.exam.model.UserModel;
import com.exam.tools.*;

public class User_Login extends JFrame{

	/**
	 * ������Ҫ�����	
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField jtfUserName ;
	private JPasswordField jpassword ;
	private JButton jbLogin ;
	private Image im = null ;
	private JLabel jlbRole,jlbRegister ;
	private static JComboBox<Object> jcb = null ;
	private String[] str = {"����","����Ա","��ʦ"};
	static User_Login test = null ;
	
	public static void main(String[] args)
	{
		
		test = new User_Login();	
	}
	
	public User_Login()
	{
		this.setLayout(null);
		
		/**
		 * �������û������ı�����д���
		 */
		jtfUserName = new JTextField(20);
		jtfUserName.setFont(MyFonts.f9);
		jtfUserName.setBounds(220, 240, 115, 25);
		jtfUserName.setBackground(Color.white);
		jtfUserName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		/**
		 * ������������ı��������д���
		 */
		jpassword = new JPasswordField(20);
		jpassword.setBounds(220, 273, 115, 25);
		jpassword.setFont(MyFonts.f10);
		jpassword.setBorder(BorderFactory.createLoweredBevelBorder());
		jpassword.addKeyListener(new KeyListener() {
			
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
					login();
				}
			}
		});
		
		
		jlbRole = new JLabel("��Ľ�ɫ");
		jlbRole.setForeground(Color.white);
		jlbRole.setBounds(130,310,200,70);
		jlbRole.setFont(MyFonts.f6);
		jcb = new JComboBox<Object>(str) ;
		jcb.setBounds(220, 330, 80, 30);
		jcb.setFont(MyFonts.f5);
		
		jcb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(jcb.getSelectedItem().toString());
				
				
			}
		});
		
		
		//ע��ѡ��
		jlbRegister = new JLabel("<html><U>ע����Ϣ</u></html>");
		jlbRegister.setToolTipText("������￪ʼע�ᣡ");
		jlbRegister.setForeground(Color.white);
		jlbRegister.setBounds(345,310,100,70);
		jlbRegister.setFont(MyFonts.f6);
		jlbRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbRegister.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				jlbRegister.setBounds(345,310,100,70);
				jlbRegister.setFont(MyFonts.f6);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				jlbRegister.setBounds(342,308,100,70);
				jlbRegister.setFont(MyFonts.f4);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//new RegisterView();
				new BeforeRegister(User_Login.this,"ע����֪",true);
				//dispose();
			}
		});
		
		
		/**
		 * Login ��ť
		 */
		jbLogin = new JButton(new ImageIcon("images/loginButton.jpg"));
		jbLogin.setBounds(345, 240, 65, 60);
		jbLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbLogin.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					login();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		/**
		 * ���������ı���ͼ
		 */
		im = new ImageIcon("images/mainFrame.jpg").getImage();
		BackImage bimge = new BackImage(im);
		bimge.setBounds(0, 0, 750, 550);

		
		/**
		 * �����������ӵ�������
		 */
		this.add(jtfUserName);
		this.add(jpassword);
		this.add(jlbRole);
		this.add(jcb);
		this.add(jbLogin);
		this.add(jlbRegister);
		this.add(bimge);
		
		
		/**�����Զ��������ʽ*/
		/*Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("images/cursor.png");
		Cursor cursor = tk.createCustomCursor(image, new Point(10,10), "My cursor");
		this.setCursor(cursor);*/
		
		/**
		 * ���ô��������
		 */
		this.setTitle("���߿���ϵͳ");
		this.setIconImage(new ImageIcon("images/icon_0.png").getImage());
		this.setSize(750,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		jbLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				login();
			}
		});
	}
	
	
/**-------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * ��Ӧ��¼�¼������û�����ĵ�¼�����жϣ��ж��Ƿ����
	 */
	public void login()
	{
		/** �ӵ�¼���JComboBox�õ�Ҫ��¼�Ľ�ɫ */
		String role = jcb.getSelectedItem().toString();
		
		UserModel model = new UserModel();
		if (jtfUserName.getText().trim().equals("")||String.valueOf(jpassword.getPassword()).equals("")) {
			
			MyMessage.showMessageDialog("�û��������벻��Ϊ��!");
		}
		else if (model.checking(jtfUserName.getText().trim().toString(), String.valueOf(jpassword.getPassword()),role)) {
			
			if (role.equals("����Ա")) {
				new Admin_mainFrame();
			}else if (role.equals("��ʦ")) {  
				new Teacher_mainFrame();
			}else {
				new Student_mianFrame();
			}
			
			this.dispose();
			
		}else {
			MyMessage.showMessageDialog("�û������������\n��¼ʧ�ܣ������µ�¼��");
			//����������
			jpassword.setText("");
			return ;
		}
	}
	
	/**-------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * ����û���¼ʱ������û���
	 * @return �����û�������û���
	 */
	public static String get_user_name()
	{
		return jtfUserName.getText().trim().toString();
	}
	
	/**-------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * ����û���¼ʱѡ��Ľ�ɫ
	 * @return �����û�ѡ��Ľ�ɫ
	 */
	public static String get_user_role()
	{
		return jcb.getSelectedItem().toString();
	}
}
