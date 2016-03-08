/**
 * @author 吴焕才
 * @function  所有用户登录窗体
 * @Participator 考生，老师，系统管理员
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
	 * 定义需要的组件	
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField jtfUserName ;
	private JPasswordField jpassword ;
	private JButton jbLogin ;
	private Image im = null ;
	private JLabel jlbRole,jlbRegister ;
	private static JComboBox<Object> jcb = null ;
	private String[] str = {"考生","管理员","教师"};
	static User_Login test = null ;
	
	public static void main(String[] args)
	{
		
		test = new User_Login();	
	}
	
	public User_Login()
	{
		this.setLayout(null);
		
		/**
		 * 对输入用户名的文本框进行处理
		 */
		jtfUserName = new JTextField(20);
		jtfUserName.setFont(MyFonts.f9);
		jtfUserName.setBounds(220, 240, 115, 25);
		jtfUserName.setBackground(Color.white);
		jtfUserName.setBorder(BorderFactory.createLoweredBevelBorder());
		
		/**
		 * 对输入密码的文本密码框进行处理
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
		
		
		jlbRole = new JLabel("你的角色");
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
		
		
		//注册选项
		jlbRegister = new JLabel("<html><U>注册信息</u></html>");
		jlbRegister.setToolTipText("点击这里开始注册！");
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
				new BeforeRegister(User_Login.this,"注册须知",true);
				//dispose();
			}
		});
		
		
		/**
		 * Login 按钮
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
		 * 加载主面板的背景图
		 */
		im = new ImageIcon("images/mainFrame.jpg").getImage();
		BackImage bimge = new BackImage(im);
		bimge.setBounds(0, 0, 750, 550);

		
		/**
		 * 将各个组件添加到容器中
		 */
		this.add(jtfUserName);
		this.add(jpassword);
		this.add(jlbRole);
		this.add(jcb);
		this.add(jbLogin);
		this.add(jlbRegister);
		this.add(bimge);
		
		
		/**设置自定义鼠标样式*/
		/*Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = tk.createImage("images/cursor.png");
		Cursor cursor = tk.createCustomCursor(image, new Point(10,10), "My cursor");
		this.setCursor(cursor);*/
		
		/**
		 * 设置窗体的属性
		 */
		this.setTitle("在线考试系统");
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
	 * 响应登录事件，对用户输入的登录做出判断，判断是否合理
	 */
	public void login()
	{
		/** 从登录框的JComboBox得到要登录的角色 */
		String role = jcb.getSelectedItem().toString();
		
		UserModel model = new UserModel();
		if (jtfUserName.getText().trim().equals("")||String.valueOf(jpassword.getPassword()).equals("")) {
			
			MyMessage.showMessageDialog("用户名或密码不能为空!");
		}
		else if (model.checking(jtfUserName.getText().trim().toString(), String.valueOf(jpassword.getPassword()),role)) {
			
			if (role.equals("管理员")) {
				new Admin_mainFrame();
			}else if (role.equals("教师")) {  
				new Teacher_mainFrame();
			}else {
				new Student_mianFrame();
			}
			
			this.dispose();
			
		}else {
			MyMessage.showMessageDialog("用户名或密码错误！\n登录失败，请重新登录！");
			//将密码框清空
			jpassword.setText("");
			return ;
		}
	}
	
	/**-------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * 获得用户登录时输入的用户名
	 * @return 返回用户输入的用户名
	 */
	public static String get_user_name()
	{
		return jtfUserName.getText().trim().toString();
	}
	
	/**-------------------------------------------------------------------------------------------------------------------*/	
	/**
	 * 获得用户登录时选择的角色
	 * @return 返回用户选择的角色
	 */
	public static String get_user_role()
	{
		return jcb.getSelectedItem().toString();
	}
}
