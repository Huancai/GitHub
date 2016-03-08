/**
 * @author 吴焕才
 * @time 2011年11月12日12:50:34
 * 
 */
package com.exam.tools;

import java.awt.*;
import javax.swing.*;

public class BackImage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image im = null ;
	
	//构造函数，用于设置背景大小
	public BackImage(Image im)
	{
		this.im = im ;
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
	}
	
	//paintComponent方法强调的是对单个组件的操作
	//paint方法强调的是对整个界面的操作
	public void paintComponent(Graphics g)
	{
		//调用父类清屏
		super.paintChildren(g);
		//开始将图片画作背景
		g.drawImage(im, 0,0,this.getWidth(),this.getHeight(),this);
	}
}
