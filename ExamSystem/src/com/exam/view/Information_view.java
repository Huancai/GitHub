/**
 * @author wuhuancai
 * @ time 2012-5-2 1:26:34
 * 功能：用户信息界面
 * 将查询到个角色的结果集传到该类，再提取出信息设置到各个组件中
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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.BackImage;
import com.exam.tools.MyFonts;
import com.exam.tools.MyMessage;

public class Information_view extends JDialog {
	
	/**对一些需要的组件进行定义*/
	private static final long serialVersionUID = 1L;

	private static JLabel jlbName,jlbIdNumber,jlbRegisterTime,jlbUserName,jlbSex,jlbBirthday,jlbUserId,jlbImage1,jlbImage2,jlbRole,jlbAvailable,jlbCall,jlbAddress,jlbEmail;
	private static JTextField jtfName,jtfUserId,jtfUserName ,jtfIdNumber,jtfRegisterTime,jtfCall,jtfAddress,jtfEmail;
	private static JButton  jbSummitButton,jbCancelButton,jbImage ;
	private static JRadioButton jrb_male,jrb_female,jrb_role1,jrb_role2,jrb_role3;
	private static ButtonGroup buttonGroup ,btGoupRole = null ;
	private static JComboBox<String> jcbBoxYear,jcbBoxMonth,jcbBoxDay = null ;
	private static FileInputStream fis = null;
	private static FileOutputStream fos = null ;
	
	private static String fu = null ;
	private static String ti = null ;
	
	private static ImageIcon image = null ;
	private static String userImage = null ;
	
	
	public Information_view(String title,ResultSet set,String fuction)
	{
		fu = fuction;
		ti = title ;
		
		/**设置空布局*/
		this.setLayout(null);
		
		Image im2 = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		//bim2.setLayout(new BorderLayout());
		bim2.setBounds(0,0,620,110);
		
		/**
		 * 初始化和设置各个组件
		 */
		jlbName = new JLabel("用户名:");
		jlbName.setBounds(12, 120, 150, 50);
		jlbName.setFont(MyFonts.f2);
		jtfName = new JTextField(40);
		jtfName.setBounds(69,135,120,20);
		jtfName.setFont(MyFonts.f3);
		
		
		jlbAvailable = new JLabel();
		jlbAvailable.setBounds(240, 160, 100, 20);
		jlbAvailable.setFont(MyFonts.f2);
		
		
		jlbIdNumber = new JLabel("准考证(用户编号):");
		jlbIdNumber.setBounds(12, 153, 150, 50);
		jlbIdNumber.setFont(MyFonts.f2);
		jtfIdNumber = new JTextField(40);
		jtfIdNumber.setBounds(135, 166, 120, 20);
		jtfIdNumber.setFont(MyFonts.f3);
		
		jlbRegisterTime = new JLabel("注册时间:");
		jlbRegisterTime.setBounds(12, 183, 150, 50);
		jlbRegisterTime.setFont(MyFonts.f2);
		jtfRegisterTime = new JTextField(40);
		jtfRegisterTime.setBounds(83, 200, 190, 20);
		jtfRegisterTime.setFont(MyFonts.f2);
		
		jlbUserName = new JLabel("姓  名:");
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
		
		String[] str_month = new String[]
				{"01","02","03","04",
				 "05","06","07","08",
				 "09","10","11","12"
				} ;
		
		
		jcbBoxMonth = new JComboBox<String>(str_month);
		jcbBoxMonth.setBounds(160, 300, 40, 20);
		jcbBoxMonth.setFont(MyFonts.f2);
		
		/***/
		String[] str_day = new String[31] ;
		for (int i = 0; i < str_day.length; i++) {
			str_day[i] = String.valueOf(i+1);
			if (str_day[i].length()==1) {
				/**如果月份的长度为一位，则在前加0，格式：01*/
				str_day[i] = "0"+str_day[i];
			}
		}
		jcbBoxDay = new JComboBox<String>(str_day);
		jcbBoxDay.setBounds(205, 300, 45, 20);
		jcbBoxDay.setFont(MyFonts.f2);
		
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
		jrb_role1.setEnabled(false);
		jrb_role2 = new JRadioButton("学  生");
		jrb_role2.setBounds(50, 410, 90, 20);
		jrb_role2.setFont(MyFonts.f2);
		jrb_role2.setEnabled(false);
		jrb_role2.setSelected(true);
		jrb_role3 = new JRadioButton("教  师");
		jrb_role3.setBounds(50, 430, 90, 20);
		jrb_role3.setFont(MyFonts.f2);
		jrb_role3.setEnabled(false);
		btGoupRole = new ButtonGroup();
		btGoupRole.add(jrb_role1);
		btGoupRole.add(jrb_role2);
		btGoupRole.add(jrb_role3);
		
		jlbCall = new JLabel("联系电话:");
		jlbCall.setBounds(180, 370, 150, 50);
		jlbCall.setFont(MyFonts.f2);
		jtfCall = new JTextField(50);
		jtfCall.setBounds(250, 385, 120, 20);
		
		/**个人地址*/
		jlbAddress = new JLabel("家庭住址:");
		jlbAddress.setBounds(180, 400, 150, 50);
		jlbAddress.setFont(MyFonts.f2);
		jtfAddress = new JTextField(50);
		jtfAddress.setBounds(250, 415, 160, 20);
		jtfAddress.setFont(MyFonts.f2);
		
		/**个人邮箱*/
		jlbEmail = new JLabel("个人邮箱:");
		jlbEmail.setBounds(180, 431, 150, 50);
		jlbEmail.setFont(MyFonts.f2);
		jtfEmail = new JTextField(20);
		jtfEmail.setBounds(250, 447, 120, 20);
		jtfEmail.setFont(MyFonts.f2);
		
		jlbImage1 = new JLabel("更换头像:");
		jlbImage1.setBounds(320, 140, 80, 20);
		jlbImage1.setFont(MyFonts.f2);
		jbImage = new JButton("...");
		jbImage.setToolTipText("上传本地图片...");
		jbImage.setBounds(400, 140, 20, 15);
		jbImage.setFont(MyFonts.f2);
		jbImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbImage2 = new JLabel();
		jlbImage2.setOpaque(true);
		jlbImage2.setBackground(Color.white);
		jlbImage2.setBounds(320, 170, 142, 144);
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
				String imagePath = "" ;
				System.out.println(filename);
				try {
					File f1 = null ;
					fis = new FileInputStream(f1 = new File(filename));
					userImage = f1.getName();
					System.out.println(userImage);
					
					/**设置上传图片的保存路径*/
					
					if (ti.equals("考生信息")) {
						imagePath = "F:/image/student/" ;
					}else if(ti.equals("教师信息")){
						imagePath = "F:/image/teacher/" ;
					}else if(ti.equals("管理员信息"))
					{
						imagePath = "F:/image/admin/" ;
					}
					
					fos = new FileOutputStream(new File(imagePath + userImage));
					
					byte[] bytes = new byte[1024] ;
					int n = 0 ;
					while ((n=fis.read(bytes))!=-1) {
						
						fos.write(bytes, 0, n);
					}
					
					//MyMessage.showMessageDialog("图片上传成功！");
					
					 image = new ImageIcon(imagePath + userImage);
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
		
		
		jbSummitButton = new JButton("提交");
		jbSummitButton.setBounds(100, 500, 120, 24);
		jbSummitButton.setFont(MyFonts.f2);
		jbSummitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbCancelButton = new JButton("退出");
		jbCancelButton.setFont(MyFonts.f2);
		jbCancelButton.setBounds(300, 500, 120, 24);
		jbCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		/**取消处理*/
		jbCancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = MyMessage.showConfirmDialog("确定要退出该页面吗？");
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
		this.add(jlbAvailable);
		this.add(jlbIdNumber);
		this.add(jtfIdNumber);
		this.add(jlbRegisterTime);
		this.add(jtfRegisterTime);
		this.add(jlbUserName);
		this.add(jtfUserName);
		this.add(jlbSex);
		this.add(jrb_male);
		this.add(jrb_female);
		this.add(jlbBirthday);
		this.add(jcbBoxYear);
		this.add(jcbBoxMonth);
		this.add(jcbBoxDay);
		this.add(jlbUserId);
		this.add(jtfUserId);
		this.add(jlbRole);
		this.add(jrb_role1);
		this.add(jrb_role2);
		this.add(jrb_role3);
		this.add(jlbCall);
		this.add(jtfCall);
		this.add(jlbAddress);
		this.add(jtfAddress);
		this.add(jlbEmail);
		this.add(jtfEmail);
		this.add(jlbImage1);
		this.add(jbImage);
		this.add(jlbImage2);
		
		this.add(jbSummitButton);
		this.add(jbCancelButton);
		
		/**
		 * 将考生各个属性分别提取出来,并分别加载到各个组件中显示出来
		 */
		try {
			while (set.next()) {
				/*System.out.println(set.getString(1));
				System.out.println(set.getString(3));
				System.out.println(set.getString(4));
				System.out.println(set.getString(5));
				System.out.println(set.getString(6));
				System.out.println(set.getString(7));
				System.out.println(set.getString(9));*/
				
				jtfName.setText(set.getString(1).trim());
				jtfUserName.setText(set.getString(3).trim());
				if (set.getString(4).equals("男")) {
					jrb_male.setSelected(true);
				}else {
					jrb_female.setSelected(true);
				}
				String birthday = set.getString(5);
				jcbBoxYear.setSelectedItem(birthday.substring(0, 4));
				jcbBoxMonth.setSelectedItem(birthday.substring(5, 7));
				//System.out.println(birthday.substring(5, 7));
				jcbBoxDay.setSelectedItem(birthday.substring(8, 10));
				jtfUserId.setText(set.getString(6).trim());
				jtfRegisterTime.setText(set.getString(7).trim());
				
				String path = "" ;
				if (ti.equals("考生信息")) {
					path = "F:/image/student/" ;
				}else if(ti.equals("教师信息")){
					path = "F:/image/teacher/" ;
				}else if(ti.equals("管理员信息"))
				{
					path = "F:/image/admin/" ;
				}
				
				/**将用户的相片显示在jlbImage2中*/
				 image = new ImageIcon(path + set.getString(8).trim());
				/**将图片改变成适应JLabel大小*/
				image.setImage(image.getImage().getScaledInstance(142,144,Image.SCALE_DEFAULT));
				jlbImage2.setIcon(image);
				
				jtfIdNumber.setText(set.getString(9).trim());
				
				jtfCall.setText(set.getString(10).trim());
				jtfAddress.setText(set.getString(11).trim());
				jtfEmail.setText(set.getString(12).trim());
				
				/**显示出所选择行记录的角色*/
				if (title.trim().toString().equals("教师信息")) {
					jrb_role3.setSelected(true);
				}else if(title.trim().toString().equals("考生信息")){
					jrb_role2.setSelected(true);
				}else {
					jrb_role1.setSelected(true);
				}
				
				jtfName.setEnabled(false);
				jtfIdNumber.setEnabled(false);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/**
		 * 提交按钮处理(jbSummitButton)
		 */
		jbSummitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int n = canRegister() ;
				
				if (n==1&&fu.equals("更新")) {
					
					String name = jtfName.getText().trim();  /**用户名*/
					String realName = jtfUserName.getText().trim(); /**真实姓名*/
					String sex = jrb_male.isSelected()?jrb_male.getText():jrb_female.getText();  /**性别*/
					String year = jcbBoxYear.getSelectedItem().toString();  /**生日年份*/
					String month = jcbBoxMonth.getSelectedItem().toString(); /**生日月份*/
					String day = jcbBoxDay.getSelectedItem().toString();   /**生日日期*/
					String UserId = jtfUserId.getText().trim().toString();  /**身份证号*/
					String imagePath = userImage ;
					//String idNumberString = jtfIdNumber.getText().trim();    /**准考证号*/
					
					String bir = year+"-"+month+"-"+day;
					String call = jtfCall.getText().trim().toString();
					String address = jtfAddress.getText().trim().toString();
					String email = jtfEmail.getText().trim().toString();
					
					String sql_update = "" ;
					
					if (ti.equals("考生信息")) {
						sql_update = "Update 考生信息表 set 姓名 = '"+realName+"',性别='"+sex+"',出生年月='"+bir+"',身份证号='"+UserId+"',相片='"+imagePath+"',联系电话='"+call+"',家庭住址='"+address+"',电子邮箱='"+email+"' where 用户名 = '"+name+"'" ;
					}else if(ti.equals("教师信息")){
						sql_update = "Update 教师信息表 set 姓名 = '"+realName+"',性别='"+sex+"',出生年月='"+bir+"',身份证号='"+UserId+"',相片='"+imagePath+"',联系电话='"+call+"',家庭住址='"+address+"',电子邮箱='"+email+"' where 用户名 = '"+name+"'" ;
					}else if (ti.equals("管理员信息")) {
						sql_update = "Update 管理员信息表 set 姓名 = '"+realName+"',性别='"+sex+"',出生年月='"+bir+"',身份证号='"+UserId+"',相片='"+imagePath+"',联系电话='"+call+"',家庭住址='"+address+"',电子邮箱='"+email+"' where 用户名 = '"+name+"'" ;
					}
					
					SQLHelper help = new SQLHelper();
					
					int x = help.update(sql_update);
					if (x==1) {
						MyMessage.showMessageDialog("更新成功！\n您所修改的信息已经写入数据库中！");
						
						 /**更新 后对JLabel进行刷新，显示更新后的数据*/
						 Admin_P1_view.stuQuery();
						 Admin_P1_view.teaQuery();
						 
					}else {
						MyMessage.showMessageDialog("更新失败！\n您所修改的信息未能写入数据库中！");
					}
					
					}else if(n==0){
					MyMessage.showMessageDialog("存在空信息！");
				}else if (n==2) {
					MyMessage.showMessageDialog("输入的身份证号不合理！");
				}
				
			}
		});
		
		/**如果是查询详细信息，则在该界面中的相关按钮为不可操作状态-------------------------------------------------------*/
		if (fu.equals("详细信息")) {
			
			jtfRegisterTime.setEditable(false);
			jrb_role1.setEnabled(false);
			jrb_role2.setEnabled(false);
			jrb_role3.setEnabled(false);
			jtfUserName.setEditable(false);
			jrb_male.setEnabled(false);
			jrb_female.setEnabled(false);
			jcbBoxYear.setEditable(false);
			jcbBoxMonth.setEditable(false);
			jcbBoxDay.setEditable(false);
			jtfName.setEditable(false);
			jtfIdNumber.setEditable(false);
			jtfEmail.setEditable(false);
			jtfCall.setEditable(false);
			jtfUserId.setEditable(false);
			jtfAddress.setEditable(false);
			jbSummitButton.setEnabled(false);
			jbImage.setEnabled(false);
		}
		
		
		this.setTitle(title);
		this.setSize(560, 590);
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
		String[] userMessage = new String[10];
		
		userMessage[0] = jtfName.getText().trim().toString();
		userMessage[1] = String.valueOf(jtfIdNumber.getText());
		userMessage[2] = String.valueOf(jtfRegisterTime.getText());
		userMessage[3] = jtfUserName.getText().trim().toString();
		userMessage[4] = jrb_male.isSelected()?jrb_male.getText():jrb_female.getText();
		userMessage[5] = jcbBoxYear.getSelectedItem().toString();
		userMessage[6] = jcbBoxMonth.getSelectedItem().toString();
		userMessage[7] = jcbBoxDay.getSelectedItem().toString();
		userMessage[8] = jtfUserId.getText().trim().toString();
		userMessage[9] = getJRadioButtonValue();

		return userMessage ;
	}
	
	
	/**----------------------------------------------------------------------------------------*/
	/**
	 * 判断用户输入的所有注册信息都是否合理: 1:合理 ；   0：存在空信息 ； 2：身份证号不合理
	 * @return 
	 */
	public static int canRegister()
	{
		int n = 1 ;
		//身份证的正则表达式，用于判断输入的身份证号是否合理
		String key = "[1-9][0-7]\\d{4}(19|20)\\d{2}[0-1]\\d{1}(([0-2]\\d{1})|(3(0|1)))\\d{3}(\\d|x|X)"; 
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
			 * 控制身份证号
			 */
			if (!information[8].matches(key)) {
				return 2 ;
			}
			
		return n ;
	}
	
	
}
