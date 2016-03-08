package com.exam.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

public class InitMenu extends JFrame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 定义菜单组件
	 */
	private JMenuBar jmb ;
	private JMenu jm1,jm2,jm3,jm4,jm5;
	private JMenuItem jm1_jmt1,jm1_jmt2,jm1_jmt3,jm1_jmt4,jm1_jmt5;
	private ImageIcon jm1_icon1,jm1_icon2,jm1_icon3,jm1_icon4,jm1_icon5;
	private JToolBar jtb;
	private JButton jb1,jb2,jb3,jb4,jb5;


	/**
	 * 处理菜单
	 */
	public void initMenu()
	{

		/**
		 * 创建以及菜单
		 */
		jm1 = new JMenu("文件(F)");
		jm1.setFont(MyFonts.f12);
		jm2 = new JMenu("编辑(E)");
		jm2.setFont(MyFonts.f12);
		jm3 = new JMenu("格式(O)");
		jm3.setFont(MyFonts.f12);
		jm4 = new JMenu("查看(V)");
		jm4.setFont(MyFonts.f12);
		jm5 = new JMenu("帮助(H)");
		jm5.setFont(MyFonts.f12);
		
		/**
		 * jm1的二级菜单的图标
		 */
		jm1_icon1 = new ImageIcon("images//icon_0.png");
		jm1_icon2 = new ImageIcon("images//icon_1.png");
		jm1_icon3 = new ImageIcon("images//icon_10.png");
		jm1_icon4 = new ImageIcon("images//icon_11.png");
		jm1_icon5 = new ImageIcon("images//icon_12.png");
		
		/**
		 * jm1的二级菜单
		 */
		jm1_jmt1 = new JMenuItem("新建(N) Ctrl+N",jm1_icon1);
		jm1_jmt1.setFont(MyFonts.f11);
		jm1_jmt2 = new JMenuItem("打开(O) Ctrl+O",jm1_icon2);
		jm1_jmt2.setFont(MyFonts.f11);
		jm1_jmt3 = new JMenuItem("新建(S) Ctrl+S",jm1_icon3);
		jm1_jmt3.setFont(MyFonts.f11);
		jm1_jmt4 = new JMenuItem("另存为(A)...",jm1_icon4);
		jm1_jmt4.setFont(MyFonts.f11);
		jm1_jmt5 = new JMenuItem("退出(X)",jm1_icon5);
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
	 * 处理工具栏
	 */
	public void initToolBar()
	{
		/**
		 * 处理工具栏
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



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
