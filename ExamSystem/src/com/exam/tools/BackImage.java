/**
 * @author �����
 * @time 2011��11��12��12:50:34
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
	
	//���캯�����������ñ�����С
	public BackImage(Image im)
	{
		this.im = im ;
		int w = Toolkit.getDefaultToolkit().getScreenSize().width;
		int h = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
	}
	
	//paintComponent����ǿ�����ǶԵ�������Ĳ���
	//paint����ǿ�����Ƕ���������Ĳ���
	public void paintComponent(Graphics g)
	{
		//���ø�������
		super.paintChildren(g);
		//��ʼ��ͼƬ��������
		g.drawImage(im, 0,0,this.getWidth(),this.getHeight(),this);
	}
}
