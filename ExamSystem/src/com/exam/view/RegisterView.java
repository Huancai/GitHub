/**
 * @author wuhuancai
 * @ time 2012��4��13��14:28:32 
 * ���ܣ��û�ע�����
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
	
	/**��һЩ��Ҫ��������ж���*/
	private static final long serialVersionUID = 1L;
	
	/**��ϵ�绰��ʼ��*/
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
		/**���ÿղ���*/
		this.setLayout(null);
		
		Image im2 = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		//bim2.setLayout(new BorderLayout());
		bim2.setBounds(0,0,560,110);
		
		/**
		 * ��ʼ�������ø������
		 */
		jlbName = new JLabel("*�û���:");
		jlbName.setBounds(12, 120, 150, 50);
		jlbName.setFont(MyFonts.f2);
		jtfName = new JTextField(40);
		jtfName.setBounds(69,135,120,20);
		jtfName.setFont(MyFonts.f2);
		jbCheckButton = new JButton("��֤�û���");
		jbCheckButton.setBounds(240, 135, 100, 20);
		jbCheckButton.setFont(MyFonts.f1);
		jbCheckButton.setToolTipText("�����ť��֤���û����Ƿ���ã�");
		jbCheckButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		jlbAvailable = new JLabel();
		jlbAvailable.setBounds(240, 160, 100, 20);
		jlbAvailable.setFont(MyFonts.f2);
		
		/**
		 * ����[��֤�û���]��ť�����Ҫע����û����Ѿ�
		 * �����ݿ��д��ڣ��򲻿�ע��
		 */
		jbCheckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (jtfName.getText().trim().toString().equals("")) {
					jlbAvailable.setBackground(Color.red);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("����Ϊ��! ");
				}
				else if (RegisterModel.isUserName(jtfName.getText())) {
					jlbAvailable.setBackground(Color.red);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("�û����Ѵ���! ");
				}else {
					jlbAvailable.setBackground(Color.green);
					jlbAvailable.setOpaque(true);
					jlbAvailable.setText("��ϲ�㣬����!");
				}
			}
		});
		
		
		jlbPassword = new JLabel("*��  ��:");
		jlbPassword.setBounds(12, 150, 150, 50);
		jlbPassword.setFont(MyFonts.f2);
		jpfPassword1 = new JPasswordField(40);
		jpfPassword1.setBounds(69, 165, 120, 20);
		jpfPassword1.setFont(MyFonts.f3);
		jpfPassword1.setEchoChar('*');
		
		jlbPassword1 = new JLabel("*�ٴ���������:");
		jlbPassword1.setBounds(12, 180, 150, 50);
		jlbPassword1.setFont(MyFonts.f2);
		jpfPassword2 = new JPasswordField(40);
		jpfPassword2.setBounds(120, 195, 120, 20);
		jpfPassword2.setFont(MyFonts.f2);
		jpfPassword2.setEchoChar('*');
		
		jlbUserName = new JLabel("*��  ��:");
		jlbUserName.setBounds(12, 220, 150, 50);
		jlbUserName.setFont(MyFonts.f2);
		jtfUserName = new JTextField(40);
		jtfUserName.setBounds(69,235,120,20);
		jtfUserName.setFont(MyFonts.f2);
		
		jlbSex = new JLabel("�Ա�:");
		jlbSex.setBounds(12, 250, 150, 50);
		jlbSex.setFont(MyFonts.f2);
		jrb_male = new JRadioButton("��");
		jrb_male.setBounds(50, 265, 50, 20);
		jrb_male.setSelected(true);
		jrb_female = new JRadioButton("Ů");
		jrb_female.setBounds(100, 265, 50, 20);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(jrb_male);
		buttonGroup.add(jrb_female);

		jlbCall = new JLabel("*��ϵ�绰:");
		jlbCall.setBounds(290, 250, 150, 50);
		jlbCall.setFont(MyFonts.f2);
		jtfCall = new JTextField(50);
		jtfCall.setBounds(360, 265, 120, 20);
		
		jtfCall.setFont(MyFonts.f2);
		jlbBirthday = new JLabel("����������:");
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
		
		/**���˵�ַ*/
		jlbAddress = new JLabel("*��ͥסַ:");
		jlbAddress.setBounds(290, 283, 150, 50);
		jlbAddress.setFont(MyFonts.f2);
		jtfAddress = new JTextField(50);
		jtfAddress.setBounds(360, 300, 160, 20);
		jtfAddress.setFont(MyFonts.f2);
		
		/**��������*/
		jlbEmail = new JLabel("*��������:");
		jlbEmail.setBounds(290, 325, 150, 50);
		jlbEmail.setFont(MyFonts.f2);
		jtfEmail = new JTextField(20);
		jtfEmail.setBounds(360, 342, 120, 20);
		jtfEmail.setFont(MyFonts.f2);
		
		jlbUserId = new JLabel("���֤��:");
		jlbUserId.setBounds(12, 340, 80, 20);
		jlbUserId.setFont(MyFonts.f2);
		jtfUserId = new JTextField(40);
		jtfUserId.setBounds(80, 340, 180, 20);
		jtfUserId.setFont(MyFonts.f2);
		
		jlbRole = new JLabel("��ɫ:");
		jlbRole.setBounds(12, 380, 40, 20);
		jlbRole.setFont(MyFonts.f2);
		
		jrb_role1 = new JRadioButton("����Ա");
		jrb_role1.setBounds(50, 390, 90, 20);
		jrb_role1.setFont(MyFonts.f2);
		jrb_role2 = new JRadioButton("ѧ  ��");
		jrb_role2.setBounds(50, 410, 90, 20);
		jrb_role2.setFont(MyFonts.f2);
		jrb_role2.setSelected(true);
		jrb_role3 = new JRadioButton("��  ʦ");
		jrb_role3.setBounds(50, 430, 90, 20);
		jrb_role3.setFont(MyFonts.f2);
		btGoupRole = new ButtonGroup();
		btGoupRole.add(jrb_role1);
		btGoupRole.add(jrb_role2);
		btGoupRole.add(jrb_role3);
		
		
		jlbImage1 = new JLabel("�ϴ�ͷ��:");
		jlbImage1.setBounds(200, 372, 80, 20);
		jlbImage1.setFont(MyFonts.f2);
		jbImage = new JButton("...");
		jbImage.setToolTipText("�ϴ�����ͼƬ...");
		jbImage.setBounds(270, 374, 20, 15);
		jbImage.setFont(MyFonts.f2);
		jbImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbImage2 = new JLabel();
		jlbImage2.setOpaque(true);
		jlbImage2.setBackground(Color.white);
		jlbImage2.setBounds(200, 395, 142, 144);
		jlbImage2.setToolTipText("��ý�ͼƬ������Ӣ������������");
		
		jbImage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("��ѡ���ļ�");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY); //�����ļ�ѡ��ģʽ,�˴�Ϊ�ļ�����
			  //jfc.setCurrentDirectory(new File(".")); // �����ļ�ѡ������ǰĿ¼

				 jfc
			       .setFileFilter(new javax.swing.filechooser.FileFilter() {
			        public boolean accept(File file) { // �ɽ��ܵ��ļ�����
			         String name = file.getName().toLowerCase();
			         return name.endsWith(".jpg")
			           || name.endsWith(".png")
			           || file.isDirectory();
			        }

			        public String getDescription() { // �ļ�����
			         return "ͼƬ�ļ�(*.jpg,*.png)";
			        }
			       });
				 
				jfc.showOpenDialog(null);
				jfc.setVisible(true);
				//���ѡ���ļ��ľ���·��
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
					
					//MyMessage.showMessageDialog("ͼƬ�ϴ��ɹ���");
					
					ImageIcon image = new ImageIcon("F:/image/" + userImage);
					/**��ͼƬ�ı����ӦJLabel��С*/
					image.setImage(image.getImage().getScaledInstance(142,144,Image.SCALE_DEFAULT));
					jlbImage2.setIcon(image);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}finally
				{
					//�ر���Դ
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
		
		/**�ύ��ȡ����ť�ĳ�ʼ��*/
		jbSummitButton = new JButton("�ύ");
		jbSummitButton.setBounds(70, 550, 120, 24);
		jbSummitButton.setFont(MyFonts.f2);
		jbSummitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbCancelButton = new JButton("ȡ��");
		jbCancelButton.setFont(MyFonts.f2);
		jbCancelButton.setBounds(340, 550, 120, 24);
		jbCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		/**
		 * �ύ��ť����(jbSummitButton)
		 */
		jbSummitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//System.out.println("�û���:"+userName+"\n����:"+String.valueOf(password)+"\n�Ա�:"+sex+"\n����:" + year+month+day+"\n���֤:"+userID+"\n��ɫ:"+role);
				
				//String strMsg = "<html><font face=Monotype Corsiva size=4 color=red>��ϲ�㣬ע��ɹ���\n���׼��֤��Ϊ��122532318\n�����׼��֤�ţ�</font></html>";
				 
				//JOptionPane.showMessageDialog(null, strMsg);
				//UIManager.put("OptionPane.font", MyFonts.f2);
				int n = canRegister() ;
				if (n==1) {
					
					RegisterModel rmModel = new RegisterModel();
					/**��RegisterModel���е�register()������֪�Ƿ�ע��ɹ�����Ϣ������ע��ɹ�����ʹ�ύ��ťΪ������״̬*/
					int x = rmModel.register();
					if (x==1) {
						MyMessage.showMessageDialog("��ϲ�㣬ע��ɹ���\n���׼��֤��Ϊ��"+RegisterModel.getId()+"\n�����׼��֤�ţ�");
						/**���ύ��ť��Ϊ������״̬*/
						jbSummitButton.setEnabled(false);
					}else {
						MyMessage.showMessageDialog("ע��ʧ�ܣ�");
					}
					
				}else if(n==0){
					MyMessage.showMessageDialog("ע����Ϣ����Ϊ����Ϣ��");
				}else if (n==2) {
					MyMessage.showMessageDialog("��������֤�Ų�����");
				}else if(n==-1){
					MyMessage.showMessageDialog("������������벻һ�£�");
				}else {
					MyMessage.showMessageDialog("��������䲻����");
				}
				
			}
		});
		
		
		jbCancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = MyMessage.showConfirmDialog("ȷ��Ҫ�˳�ע����");
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
		 * �����������ӵ��������
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
		
		this.setTitle("�û�ע��");
		this.setSize(560, 620);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	
	/**
	 * ��ý�ɫ��ѡ���ֵ
	 * @return ����ѡ�н�ɫ��ѡ���ֵ
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
	 * ����û�ע��ʱ��д����Ϣ
	 * @return �����û���ע����Ϣ
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
	 * �ж��û����������ע����Ϣ���Ƿ����: 1:���� 
	 * 								  -1���������벻һ�� 
	 * 								   0�����ڿ���Ϣ 
	 * 								   2�����֤�Ų�����
	 * 								   3:Email������
	 * @return  ������������
	 */
	public static int canRegister()
	{
		int n = 1 ;
		//���֤��������ʽ�������ж���������֤���Ƿ����
		String key = "[1-9][0-7]\\d{4}(19|20)\\d{2}[0-1]\\d{1}(([0-2]\\d{1})|(3(0|1)))\\d{3}(\\d|x|X)"; 
		/**�ж������Email�Ƿ����*/
		String emailKey =  "\\w+@\\w+\\.(com\\.cn)|\\w+@\\w+\\.(com|cn)"; 
		
		String[] information = getUserMessage();
			
			/**
			 * ���û������ȫ����Ϣ����һ��Ϊ�գ��򷵻�0
			 */
			for (int i = 0; i < information.length-1; i++) {
				
				 if (information[i].equals("")) {
					return 0 ;
				}
				 
			}
			/**
			 * ��������������벻һ��ʱ���� -1
			 */
			if (!information[1].equals(information[2])) {
				return -1 ;
			}
		
			/**
			 * �������֤��
			 */
			if (!information[8].matches(key)) {
				return 2 ;
			}
			
			/**
			 * ���������Ƿ����
			 */
			if(!information[13].matches(emailKey))
			{
				return 3 ;
			}
		return n ;
	}
	
	
}
