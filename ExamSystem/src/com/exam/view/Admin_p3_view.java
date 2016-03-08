package com.exam.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.exam.tools.MyFonts;

public class Admin_p3_view extends JPanel{

	private static final long serialVersionUID = 1L;

	private static JPanel panel1,panel2 ;
	
	public Admin_p3_view()
	{
		this.setLayout(new GridLayout(1,2,3,3));
		
		panel1 = new JPanel(new BorderLayout());
		panel1.setBorder(BorderFactory.createTitledBorder(null,"试卷生成区",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		
		panel2 = new JPanel(new BorderLayout());
		panel2.setBorder(BorderFactory.createTitledBorder(null,"试卷预览区",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		
		this.add(panel1);
		this.add(panel2);
	}
}
