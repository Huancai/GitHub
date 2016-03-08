package com.exam.tools;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyTray extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * ����
	 */
   public void tray() {
        TrayIcon trayIcon = null;
        SystemTray systemTray = null; //ϵͳ����
        systemTray = SystemTray.getSystemTray(); //���ϵͳ���̵�ʵ��
        
        PopupMenu pop = new PopupMenu(); // ����һ���Ҽ�����ʽ�˵�
        final MenuItem show = new MenuItem("�򿪳���");
        final MenuItem exit = new MenuItem("�˳�����");
        
        pop.add(show);
        pop.add(exit);
        
        /**
         * ����show�ļ����¼�
         */
        show.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setExtendedState(JFrame.NORMAL);
				setVisible(true);
			}
		});
        /**
         * ����exit�ļ����¼�
         */
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
        
        try {
            Image icon = new ImageIcon("images/icon_1.png").getImage();
            trayIcon = new TrayIcon(icon, "���߿���ϵͳ",pop);
            systemTray.add(trayIcon); //�������̵�ͼ�꣬
        } catch (AWTException e2) {
            e2.printStackTrace();
        }
        this.addWindowListener(
                new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                dispose(); //������С��ʱdispose�ô���
            }
        });
        trayIcon.addMouseListener(
                new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) //˫�����̴�������
                    setExtendedState(Frame.NORMAL); //״̬
                setVisible(true);
            }
        });
    }
}
