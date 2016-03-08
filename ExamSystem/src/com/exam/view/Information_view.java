/**
 * @author wuhuancai
 * @ time 2012-5-2 1:26:34
 * ���ܣ��û���Ϣ����
 * ����ѯ������ɫ�Ľ�����������࣬����ȡ����Ϣ���õ����������
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
	
	/**��һЩ��Ҫ��������ж���*/
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
		
		/**���ÿղ���*/
		this.setLayout(null);
		
		Image im2 = new ImageIcon("images/admin1.jpg").getImage();
		BackImage bim2 = new BackImage(im2);
		//bim2.setLayout(new BorderLayout());
		bim2.setBounds(0,0,620,110);
		
		/**
		 * ��ʼ�������ø������
		 */
		jlbName = new JLabel("�û���:");
		jlbName.setBounds(12, 120, 150, 50);
		jlbName.setFont(MyFonts.f2);
		jtfName = new JTextField(40);
		jtfName.setBounds(69,135,120,20);
		jtfName.setFont(MyFonts.f3);
		
		
		jlbAvailable = new JLabel();
		jlbAvailable.setBounds(240, 160, 100, 20);
		jlbAvailable.setFont(MyFonts.f2);
		
		
		jlbIdNumber = new JLabel("׼��֤(�û����):");
		jlbIdNumber.setBounds(12, 153, 150, 50);
		jlbIdNumber.setFont(MyFonts.f2);
		jtfIdNumber = new JTextField(40);
		jtfIdNumber.setBounds(135, 166, 120, 20);
		jtfIdNumber.setFont(MyFonts.f3);
		
		jlbRegisterTime = new JLabel("ע��ʱ��:");
		jlbRegisterTime.setBounds(12, 183, 150, 50);
		jlbRegisterTime.setFont(MyFonts.f2);
		jtfRegisterTime = new JTextField(40);
		jtfRegisterTime.setBounds(83, 200, 190, 20);
		jtfRegisterTime.setFont(MyFonts.f2);
		
		jlbUserName = new JLabel("��  ��:");
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
				/**����·ݵĳ���Ϊһλ������ǰ��0����ʽ��01*/
				str_day[i] = "0"+str_day[i];
			}
		}
		jcbBoxDay = new JComboBox<String>(str_day);
		jcbBoxDay.setBounds(205, 300, 45, 20);
		jcbBoxDay.setFont(MyFonts.f2);
		
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
		jrb_role1.setEnabled(false);
		jrb_role2 = new JRadioButton("ѧ  ��");
		jrb_role2.setBounds(50, 410, 90, 20);
		jrb_role2.setFont(MyFonts.f2);
		jrb_role2.setEnabled(false);
		jrb_role2.setSelected(true);
		jrb_role3 = new JRadioButton("��  ʦ");
		jrb_role3.setBounds(50, 430, 90, 20);
		jrb_role3.setFont(MyFonts.f2);
		jrb_role3.setEnabled(false);
		btGoupRole = new ButtonGroup();
		btGoupRole.add(jrb_role1);
		btGoupRole.add(jrb_role2);
		btGoupRole.add(jrb_role3);
		
		jlbCall = new JLabel("��ϵ�绰:");
		jlbCall.setBounds(180, 370, 150, 50);
		jlbCall.setFont(MyFonts.f2);
		jtfCall = new JTextField(50);
		jtfCall.setBounds(250, 385, 120, 20);
		
		/**���˵�ַ*/
		jlbAddress = new JLabel("��ͥסַ:");
		jlbAddress.setBounds(180, 400, 150, 50);
		jlbAddress.setFont(MyFonts.f2);
		jtfAddress = new JTextField(50);
		jtfAddress.setBounds(250, 415, 160, 20);
		jtfAddress.setFont(MyFonts.f2);
		
		/**��������*/
		jlbEmail = new JLabel("��������:");
		jlbEmail.setBounds(180, 431, 150, 50);
		jlbEmail.setFont(MyFonts.f2);
		jtfEmail = new JTextField(20);
		jtfEmail.setBounds(250, 447, 120, 20);
		jtfEmail.setFont(MyFonts.f2);
		
		jlbImage1 = new JLabel("����ͷ��:");
		jlbImage1.setBounds(320, 140, 80, 20);
		jlbImage1.setFont(MyFonts.f2);
		jbImage = new JButton("...");
		jbImage.setToolTipText("�ϴ�����ͼƬ...");
		jbImage.setBounds(400, 140, 20, 15);
		jbImage.setFont(MyFonts.f2);
		jbImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlbImage2 = new JLabel();
		jlbImage2.setOpaque(true);
		jlbImage2.setBackground(Color.white);
		jlbImage2.setBounds(320, 170, 142, 144);
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
				String imagePath = "" ;
				System.out.println(filename);
				try {
					File f1 = null ;
					fis = new FileInputStream(f1 = new File(filename));
					userImage = f1.getName();
					System.out.println(userImage);
					
					/**�����ϴ�ͼƬ�ı���·��*/
					
					if (ti.equals("������Ϣ")) {
						imagePath = "F:/image/student/" ;
					}else if(ti.equals("��ʦ��Ϣ")){
						imagePath = "F:/image/teacher/" ;
					}else if(ti.equals("����Ա��Ϣ"))
					{
						imagePath = "F:/image/admin/" ;
					}
					
					fos = new FileOutputStream(new File(imagePath + userImage));
					
					byte[] bytes = new byte[1024] ;
					int n = 0 ;
					while ((n=fis.read(bytes))!=-1) {
						
						fos.write(bytes, 0, n);
					}
					
					//MyMessage.showMessageDialog("ͼƬ�ϴ��ɹ���");
					
					 image = new ImageIcon(imagePath + userImage);
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
		
		
		jbSummitButton = new JButton("�ύ");
		jbSummitButton.setBounds(100, 500, 120, 24);
		jbSummitButton.setFont(MyFonts.f2);
		jbSummitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jbCancelButton = new JButton("�˳�");
		jbCancelButton.setFont(MyFonts.f2);
		jbCancelButton.setBounds(300, 500, 120, 24);
		jbCancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		/**ȡ������*/
		jbCancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int i = MyMessage.showConfirmDialog("ȷ��Ҫ�˳���ҳ����");
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
		 * �������������Էֱ���ȡ����,���ֱ���ص������������ʾ����
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
				if (set.getString(4).equals("��")) {
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
				if (ti.equals("������Ϣ")) {
					path = "F:/image/student/" ;
				}else if(ti.equals("��ʦ��Ϣ")){
					path = "F:/image/teacher/" ;
				}else if(ti.equals("����Ա��Ϣ"))
				{
					path = "F:/image/admin/" ;
				}
				
				/**���û�����Ƭ��ʾ��jlbImage2��*/
				 image = new ImageIcon(path + set.getString(8).trim());
				/**��ͼƬ�ı����ӦJLabel��С*/
				image.setImage(image.getImage().getScaledInstance(142,144,Image.SCALE_DEFAULT));
				jlbImage2.setIcon(image);
				
				jtfIdNumber.setText(set.getString(9).trim());
				
				jtfCall.setText(set.getString(10).trim());
				jtfAddress.setText(set.getString(11).trim());
				jtfEmail.setText(set.getString(12).trim());
				
				/**��ʾ����ѡ���м�¼�Ľ�ɫ*/
				if (title.trim().toString().equals("��ʦ��Ϣ")) {
					jrb_role3.setSelected(true);
				}else if(title.trim().toString().equals("������Ϣ")){
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
		 * �ύ��ť����(jbSummitButton)
		 */
		jbSummitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int n = canRegister() ;
				
				if (n==1&&fu.equals("����")) {
					
					String name = jtfName.getText().trim();  /**�û���*/
					String realName = jtfUserName.getText().trim(); /**��ʵ����*/
					String sex = jrb_male.isSelected()?jrb_male.getText():jrb_female.getText();  /**�Ա�*/
					String year = jcbBoxYear.getSelectedItem().toString();  /**�������*/
					String month = jcbBoxMonth.getSelectedItem().toString(); /**�����·�*/
					String day = jcbBoxDay.getSelectedItem().toString();   /**��������*/
					String UserId = jtfUserId.getText().trim().toString();  /**���֤��*/
					String imagePath = userImage ;
					//String idNumberString = jtfIdNumber.getText().trim();    /**׼��֤��*/
					
					String bir = year+"-"+month+"-"+day;
					String call = jtfCall.getText().trim().toString();
					String address = jtfAddress.getText().trim().toString();
					String email = jtfEmail.getText().trim().toString();
					
					String sql_update = "" ;
					
					if (ti.equals("������Ϣ")) {
						sql_update = "Update ������Ϣ�� set ���� = '"+realName+"',�Ա�='"+sex+"',��������='"+bir+"',���֤��='"+UserId+"',��Ƭ='"+imagePath+"',��ϵ�绰='"+call+"',��ͥסַ='"+address+"',��������='"+email+"' where �û��� = '"+name+"'" ;
					}else if(ti.equals("��ʦ��Ϣ")){
						sql_update = "Update ��ʦ��Ϣ�� set ���� = '"+realName+"',�Ա�='"+sex+"',��������='"+bir+"',���֤��='"+UserId+"',��Ƭ='"+imagePath+"',��ϵ�绰='"+call+"',��ͥסַ='"+address+"',��������='"+email+"' where �û��� = '"+name+"'" ;
					}else if (ti.equals("����Ա��Ϣ")) {
						sql_update = "Update ����Ա��Ϣ�� set ���� = '"+realName+"',�Ա�='"+sex+"',��������='"+bir+"',���֤��='"+UserId+"',��Ƭ='"+imagePath+"',��ϵ�绰='"+call+"',��ͥסַ='"+address+"',��������='"+email+"' where �û��� = '"+name+"'" ;
					}
					
					SQLHelper help = new SQLHelper();
					
					int x = help.update(sql_update);
					if (x==1) {
						MyMessage.showMessageDialog("���³ɹ���\n�����޸ĵ���Ϣ�Ѿ�д�����ݿ��У�");
						
						 /**���� ���JLabel����ˢ�£���ʾ���º������*/
						 Admin_P1_view.stuQuery();
						 Admin_P1_view.teaQuery();
						 
					}else {
						MyMessage.showMessageDialog("����ʧ�ܣ�\n�����޸ĵ���Ϣδ��д�����ݿ��У�");
					}
					
					}else if(n==0){
					MyMessage.showMessageDialog("���ڿ���Ϣ��");
				}else if (n==2) {
					MyMessage.showMessageDialog("��������֤�Ų�����");
				}
				
			}
		});
		
		/**����ǲ�ѯ��ϸ��Ϣ�����ڸý����е���ذ�ťΪ���ɲ���״̬-------------------------------------------------------*/
		if (fu.equals("��ϸ��Ϣ")) {
			
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
	 * �ж��û����������ע����Ϣ���Ƿ����: 1:���� ��   0�����ڿ���Ϣ �� 2�����֤�Ų�����
	 * @return 
	 */
	public static int canRegister()
	{
		int n = 1 ;
		//���֤��������ʽ�������ж���������֤���Ƿ����
		String key = "[1-9][0-7]\\d{4}(19|20)\\d{2}[0-1]\\d{1}(([0-2]\\d{1})|(3(0|1)))\\d{3}(\\d|x|X)"; 
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
			 * �������֤��
			 */
			if (!information[8].matches(key)) {
				return 2 ;
			}
			
		return n ;
	}
	
	
}
