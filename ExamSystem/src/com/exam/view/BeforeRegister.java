/***
 * @author wuhuancai
 * @time 2012年5月16日0:17:26
 * 新用户注册须知
 */
package com.exam.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.exam.tools.GetInformationFromFile;
import com.exam.tools.MyFonts;

public class BeforeRegister extends JDialog{
	private static JLabel jlbInformation = null ;
	private JButton jbOK = null ;
	private JCheckBox jcb = null ;
	private static JPanel jp = null ;
	private static JScrollPane jsp = null ;
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		//new BeforeRegister();
	}
	public BeforeRegister(Frame owner,String title,boolean modal)
	{
		super(owner,title,modal);
		
		this.setLayout(new BorderLayout());
		
		jlbInformation = new JLabel();
		jlbInformation.setFont(MyFonts.f1);
		jlbInformation.setText("<html><pre>'"+GetInformationFromFile.getInformation("zhuce.txt")+"'</pre></html>");
		jsp = new JScrollPane(jlbInformation);
		
		jp = new JPanel();
		jp.add(jbOK = new JButton("提交"));
		jbOK.setFont(MyFonts.f2);
		jbOK.setEnabled(false);
		jp.add(jcb = new JCheckBox("我同意该条款"));
		jcb.setFont(MyFonts.f2);
		
		jcb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (jcb.isSelected()) {
					jbOK.setEnabled(true);
				}else {
					jbOK.setEnabled(false);
				}
			}
		});
		
		jbOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RegisterView();
				dispose();
			}
		});
		
		this.add(jsp,"Center");
		this.add(jp,"South");
		//this.setTitle("注册须知");
		this.setIconImage(new ImageIcon("images/icon_10.png").getImage());
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
