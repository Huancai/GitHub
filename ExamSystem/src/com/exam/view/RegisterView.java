/**
 * @author wuhuancai
 * @ time 2012年4月13日14:28:32 
 * 功能：用户注册界面
 */
package com.exam.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.exam.model.RegisterModel;
import com.exam.tools.BackImage;
import com.exam.tools.MyFonts;
import com.exam.tools.MyMessage;

public class RegisterView extends JFrame {
	
	/**对一些需要的组件进行定义*/
	private static final long serialVersionUID = 1L;
	
	/**联系电话初始化*/
	private static JLabel jlbCall ;
	private static JTextField jtfCall ;
	
	private static JLabel jlbName,jlbPassword,jlbPassword1,jlbUserName,jlbSex,jlbBirthday,jlbUserId,jlbImage1,jlbImage2,jlbRole,jlbAvailable,jlbAddress,jlbEmail;
	private static JTextField jtfName,jtfUserId,jtfUserName,jtfAddress,jtfEmail ;
	private static JPasswordField jpfPassword1,jpfPassword2 ;
	private static JButton  jbCheckButton,jbSummitButton,jbCancelButton,jbImage ;
	private static JRadioButton jrb_male,jrb_female,jrb_role1,jrb_role2,jrb_role3;
	private static ButtonGroup buttonGroup ,btGoupRole = null ;
	private static JComboBox<String> jcbBoxYear,jcbBoxMonth,jcbBoxDay = null ;
	private static FileInputStream fis = null;
	private static FileOutputStream fos = null ;
	
	private static String userImage = "" ;
	public static void main(String[] args) {

		new RegisterView();
	}
	
	public RegisterView()
	{
		/**设置空布局*/
		this.setLayout(null);
		
		Image im2 = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		//bim2.setLayout(new BorderLayout());
		bim2.setBounds(0,0,560,110);
		
		/**
		 * 初始化和设置各个组件
		 */
		jlbName = new JLabel("*用户名:");
		jlbName.setBounds(12, 120, 150, 50);
		jlbName.setFont(MyFonts.f2);
		jtfName = new JTextField(40);
		jtfName.setBounds(69,135,120,20);
		jtfName.setFont(MyFonts.f2);
		jbCheckButton = new JButton("验证用户名");
		jbCheckButton.setBounds(240, 135, 100, 20);
		jbCheckButton.setFont(MyFonts.f1);
		jbCheckButton.setToolTipText("点击按钮验证该用户名是否可用！");
		jbCheckButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jlbAvailable = new JLabel();
		jlbAvailable.setBounds(240, 160, 100, 20);
		jlbAvailable.setFont(MyFonts.f2);
		
		/**
		 * 处理[验证用户名]按钮，如果要注册的用户名已经
		 * 在数据库中存在，则不可注册
		 */
		jbCheckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jtfName.getText().trim().toString().equals("")) {
					jlbAvailable.setBackground(Color.red);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("不可为空! ");
				}
				else if (RegisterModel.isUserName(jtfName.getText())) {
					jlbAvailable.setBackground(Color.red);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("用户名已存在! ");
				}else {
					jlbAvailable.setBackground(Color.green);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("恭喜你，可用!");
				}
			}
		});
		
		
		jlbPassword = new JLabel("*密  码:");
		jlbPassword.setBounds(12, 150, 150, 50);
		jlbPassword.setFont(MyFonts.f2);
		jpfPassword1 = new JPasswordField(40);
		jpfPassword1.setBounds(69, 165, 120, 20);
		jpfPassword1.setFont(MyFonts.f3);
		jpfPassword1.setEchoChar('*');
		
		jlbPassword1 = new JLabel("*再次输入密码:");
		jlbPassword1.setBounds(12, 180, 150, 50);
		jlbPassword1.setFont(MyFonts.f2);
		jpfPassword2 = new JPasswordField(40);
		jpfPassword2.setBounds(120, 195, 120, 20);
		jpfPassword2.setFont(MyFonts.f2);
		jpfPassword2.setEchoChar('*');
		
		jlbUserName = new JLabel("*姓  名:");
		jlbUserName.setBounds(12, 220, 150, 50);
		jlbUserName.setFont(MyFonts.f2);
		jtfUserName = new JTextField(40);
		jtfUserName.setBounds(69,235,120,20);
		jtfUserName.setFont(MyFonts.f2);
		
		jlbSex = new JLabel("性别:");
		jlbSex.setBounds(12, 250, 150, 50);
		jlbSex.setFont(MyFonts.f2);
		jrb_male = new JRadioButton("男");
		jrb_male.setBounds(50, 265, 50, 20);
		jrb_male.setSelected(true);
		jrb_female = new JRadioButton("女");
		jrb_female.setBounds(100, 265, 50, 20);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(jrb_male);
		buttonGroup.add(jrb_female);

		jlbCall = new JLabel("*联系电话:");
		jlbCall.setBounds(290, 250, 150, 50);
		jlbCall.setFont(MyFonts.f2);
		jtfCall = new JTextField(50);
		jtfCall.setBounds(360, 265, 120, 20);
		
		jtfCall.setFont(MyFonts.f2);
		jlbBirthday = new JLabel("出生年月日:");
		jlbBirthday.setBounds(12, 287, 100, 50);
		jlbBirthday.setFont(MyFonts.f2);
		
		String[] str_year = new String[50];
		for (int i = 0; i < str_year.length; i++) {
			str_year[i] = String.valueOf(i+1980);
		}
		jcbBoxYear = new JComboBox<String>(str_year);
		jcbBoxYear.setBounds(95, 300, 60, 20);
		jcbBoxYear.setFont(MyFonts.f2);
		jcbBoxYear.setSelectedItem(4);
		jcbBoxYear.setMaximumRowCount(4);
		
		String[] str_month = new String[]
				{"01","02","03","04",
				 "05","06","07","08",
				 "09","10","11","12"
				} ;
		
		jcbBoxMonth = new JComboBox<String>(str_month);
		jcbBoxMonth.setBounds(160, 300, 40, 20);
		jcbBoxMonth.setFont(MyFonts.f2);
		jcbBoxMonth.setMaximumRowCount(4);
		
		String[] str_day = new String[31] ;
		for (int i = 0; i < str_day.length; i++) {
			str_day[i] = String.valueOf(i+1);
			if (str_day[i].length()==1) {
				str_day[i] = "0"+str_day[i];
			}
		}
		jcbBoxDay = new JComboBox<String>(str_day);
		jcbBoxDay.setBounds(205, 300, 45, 20);
		jcbBoxDay.setFont(MyFonts.f2);
		jcbBoxDay.setMaximumRowCount(4);
		
		/**个人地址*/
		jlbAddress = new JLabel("*家庭住址:");
		jlbAddress.setBounds(290, 283, 150, 50);
		jlbAddress.setFont(MyFonts.f2);
		jtfAddress = new JTextField(50);
		jtfAddress.setBounds(360, 300, 160, 20);
		jtfAddress.setFont(MyFonts.f2);
		
		/**个人邮箱*/
		jlbEmail = new JLabel("*个人邮箱:");
		jlbEmail.setBounds(290, 325, 150, 50);
		jlbEmail.setFont(MyFonts.f2);
		jtfEmail = new JTextField(20);
		jtfEmail.setBounds(360, 342, 120, 20);
		jtfEmail.setFont(MyFonts.f2);
		
		jlbUserId = new JLabel("身份证号:");
		jlbUserId.setBounds(12, 340, 80, 20);
		jlbUserId.setFont(MyFonts.f2);
		jtfUserId = new JTextField(40);
		jtfUserId.setBounds(80, 340, 180, 20);
		jtfUserId.setFont(MyFonts.f2);
		
		jlbRole = new JLabel("角色:");
		jlbRole.setBounds(12, 380, 40, 20);
		jlbRole.setFont(MyFonts.f2);
		
		jrb_role1 = new JRadioButton("管理员");
		jrb_role1.setBounds(50, 390, 90, 20);
		jrb_role1.setFont(MyFonts.f2);
		jrb_role2 = new JRadioButton("学  生");
		jrb_role2.setBounds(50, 410, 90, 20);
		jrb_role2.setFont(MyFonts.f2);
		jrb_role2.setSelected(true);
		jrb_role3 = new JRadioButton("教  师");
		jrb_role3.setBounds(50, 430, 90, 20);
		jrb_role3.setFont(MyFonts.f2);
		btGoupRole = new ButtonGroup();
		btGoupRole.add(jrb_role1);
		btGoupRole.add(jrb_role2);
		btGoupRole.add(jrb_role3);
		
		
		jlbImage1 = new JLabel("上传头像:");
		jlbImage1.setBounds(200, 372, 80, 20);
		jlbImage1.setFont(MyFonts.f2);
		jbImage = new JButton("...");
		jbImage.setToolTipText("上传本地图片...");
		jbImage.setBounds(270, 374, 20, 15);
		jbImage.setFont(MyFonts.f2);
		jbImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbImage2 = new JLabel();
		jlbImage2.setOpaque(true);
		jlbImage2.setBackground(Color.white);
		jlbImage2.setBounds(200, 395, 142, 144);
		jlbImage2.setToolTipText("最好将图片以您的英文名字来命名");
		
		jbImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("请选择文件");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY); //设置文件选择模式,此处为文件仅可
			  //jfc.setCurrentDirectory(new File(".")); // 设置文件选择器当前目录

				 jfc
			       .setFileFilter(new javax.swing.filechooser.FileFilter() {
			        public boolean accept(File file) { // 可接受的文件类型
			         String name = file.getName().toLowerCase();
			         return name.endsWith(".jpg")
			           || name.endsWith(".png")
			           || file.isDirectory();
			        }

			        public String getDescription() { // 文件描述
			         return "图片文件(*.jpg,*.png)";
			        }
			       });
				 
				jfc.showOpenDialog(null);
				jfc.setVisible(true);
				//获得选中文件的绝对路径
				String filename=jfc.getSelectedFile().getAbsolutePath();
				
				System.out.println(filename);
				try {
					File f1 = null ;
					fis = new FileInputStream(f1 = new File(filename));
					 userImage = f1.getName();
					System.out.println(userImage);
					
					fos = new FileOutputStream(new File("F:/image/" + userImage));
					
					byte[] bytes = new byte[1024] ;
					int n = 0 ;
					while ((n=fis.read(bytes))!=-1) {
						
						fos.write(bytes, 0, n);
					}
					
					//MyMessage.showMessageDialog("图片上传成功！");
					
					ImageIcon image = new ImageIcon("F:/image/" + userImage);
					/**将图片改变成适应JLabel大小*/
					image.setImage(image.getImage().getScaledInstance(142,144,Image.SCALE_DEFAULT));
					jlbImage2.setIcon(image);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally
				{
					//关闭资源
					try {
						if (fis!=null) {
							fis.close();
						}if (fos!=null) {
							fos.close();
						}
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		/**提交和取消按钮的初始化*/
		jbSummitButton = new JButton("提交");
		jbSummitButton.setBounds(70, 550, 120, 24);
		jbSummitButton.setFont(MyFonts.f2);
		jbSummitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbCancelButton = new JButton("取消");
		jbCancelButton.setFont(MyFonts.f2);
		jbCancelButton.setBounds(340, 550, 120, 24);
		jbCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		/**
		 * 提交按钮处理(jbSummitButton)
		 */
		jbSummitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//System.out.println("用户名:"+userName+"\n密码:"+String.valueOf(password)+"\n性别:"+sex+"\n生日:" + year+month+day+"\n身份证:"+userID+"\n角色:"+role);
				
				//String strMsg = "<html><font face=Monotype Corsiva size=4 color=red>恭喜你，注册成功！\n你的准考证号为：122532318\n请记下准考证号！</font></html>";
				 
				//JOptionPane.showMessageDialog(null, strMsg);
				//UIManager.put("OptionPane.font", MyFonts.f2);
				int n = canRegister() ;
				if (n==1) {
					
					RegisterModel rmModel = new RegisterModel();
					/**从RegisterModel类中的register()方法获知是否注册成功的信息，若以注册成功，则使提交按钮为不可用状态*/
					int x = rmModel.register();
					if (x==1) {
						MyMessage.showMessageDialog("恭喜你，注册成功！\n你的准考证号为："+RegisterModel.getId()+"\n请记下准考证号！");
						/**将提交按钮设为不可用状态*/
						jbSummitButton.setEnabled(false);
					}else {
						MyMessage.showMessageDialog("注册失败！");
					}
					
				}else if(n==0){
					MyMessage.showMessageDialog("注册信息不能为空信息！");
				}else if (n==2) {
					MyMessage.showMessageDialog("输入的身份证号不合理！");
				}else if(n==-1){
					MyMessage.showMessageDialog("输入的两次密码不一致！");
				}else {
					MyMessage.showMessageDialog("输入的邮箱不合理！");
				}
				
			}
		});
		
		
		jbCancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = MyMessage.showConfirmDialog("确定要退出注册吗？");
				if (i==0) {
					dispose();
				}
				else
				{
					return ;
				}
			}
		});
		/**
		 * 将各个组件添加到主面板上
		 */
		this.add(bim2);
		this.add(jlbName);
		this.add(jtfName);
		this.add(jbCheckButton);
		this.add(jlbAvailable);
		this.add(jlbPassword);
		this.add(jpfPassword1);
		this.add(jlbPassword1);
		this.add(jpfPassword2);
		this.add(jlbUserName);
		this.add(jtfUserName);
		this.add(jlbCall);//
		this.add(jtfCall);
		this.add(jlbSex);
		this.add(jrb_male);
		this.add(jrb_female);
		this.add(jlbBirthday);
		this.add(jcbBoxYear);
		this.add(jcbBoxMonth);
		this.add(jcbBoxDay);
		this.add(jlbAddress);
		this.add(jtfAddress);
		this.add(jlbUserId);
		this.add(jtfUserId);
		this.add(jlbEmail);
		this.add(jtfEmail);
		this.add(jlbRole);
		this.add(jrb_role1);
		this.add(jrb_role2);
		this.add(jrb_role3);
		this.add(jlbImage1);
		this.add(jbImage);
		this.add(jlbImage2);
		
		this.add(jbSummitButton);
		this.add(jbCancelButton);
		
		this.setTitle("用户注册");
		this.setSize(560, 620);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	/**
	 * 获得角色单选框的值
	 * @return 返回选中角色单选框的值
	 */
	public static String getJRadioButtonValue()
	{
		String str = "" ;
		
		if (jrb_role1.isSelected()) {
			str = jrb_role1.getText().trim().toString();
		}if (jrb_role2.isSelected()) {
			str = jrb_role2.getText().trim().toString();
		}if (jrb_role3.isSelected()) {
			str = jrb_role3.getText().trim().toString();
		}
		return str ;
	}
	
	
	/**
	 * 获得用户注册时填写的信息
	 * @return 返回用户的注册信息
	 */
	public static String[] getUserMessage()
	{
		String[] userMessage = new String[14];
		
		userMessage[0] = jtfName.getText().trim().toString();
		userMessage[1] = String.valueOf(jpfPassword1.getPassword());
		userMessage[2] = String.valueOf(jpfPassword2.getPassword());
		userMessage[3] = jtfUserName.getText().trim().toString();
		userMessage[4] = jrb_male.isSelected()?jrb_male.getText():jrb_female.getText();
		userMessage[5] = jcbBoxYear.getSelectedItem().toString();
		userMessage[6] = jcbBoxMonth.getSelectedItem().toString();
		userMessage[7] = jcbBoxDay.getSelectedItem().toString();
		userMessage[8] = jtfUserId.getText().trim().toString();
		userMessage[9] = getJRadioButtonValue();
		userMessage[10] = userImage ;
		userMessage[11] = jtfCall.getText().toString().trim();
		userMessage[12] = jtfAddress.getText().toString().trim();
		userMessage[13] = jtfEmail.getText().toString().trim();
		
		return userMessage ;
	}
	
	
	/**----------------------------------------------------------------------------------------*/
	/**
	 * 判断用户输入的所有注册信息都是否合理: 1:合理 
	 * 								  -1：两次密码不一致 
	 * 								   0：存在空信息 
	 * 								   2：身份证号不合理
	 * 								   3:Email不合理
	 * @return  返回上述参数
	 */
	public static int canRegister()
	{
		int n = 1 ;
		//身份证的正则表达式，用于判断输入的身份证号是否合理
		String key = "[1-9][0-7]\\d{4}(19|20)\\d{2}[0-1]\\d{1}(([0-2]\\d{1})|(3(0|1)))\\d{3}(\\d|x|X)"; 
		/**判断输入的Email是否合理*/
		String emailKey =  "\\w+@\\w+\\.(com\\.cn)|\\w+@\\w+\\.(com|cn)"; 
		
		String[] information = getUserMessage();
			
			/**
			 * 当用户输入的全部信息中有一个为空，则返回0
			 */
			for (int i = 0; i < information.length-1; i++) {
				
				 if (information[i].equals("")) {
					return 0 ;
				}
				 
			}
			/**
			 * 当两次输入的密码不一致时返回 -1
			 */
			if (!information[1].equals(information[2])) {
				return -1 ;
			}
		
			/**
			 * 控制身份证号
			 */
			if (!information[8].matches(key)) {
				return 2 ;
			}
			
			/**
			 * 控制邮箱是否合理
			 */
			if(!information[13].matches(emailKey))
			{
				return 3 ;
			}
		return n ;
	}
	
	
}
