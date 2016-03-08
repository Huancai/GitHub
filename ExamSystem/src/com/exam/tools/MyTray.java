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
	 * 托盘
	 */
   public void tray() {
        TrayIcon trayIcon = null;
        SystemTray systemTray = null; //系统托盘
        systemTray = SystemTray.getSystemTray(); //获得系统托盘的实例
        
        PopupMenu pop = new PopupMenu(); // 构造一个右键弹出式菜单
        final MenuItem show = new MenuItem("打开程序");
        final MenuItem exit = new MenuItem("退出程序");
        
        pop.add(show);
        pop.add(exit);
        
        /**
         * 处理show的监听事件
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
         * 处理exit的监听事件
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
            trayIcon = new TrayIcon(icon, "在线考试系统",pop);
            systemTray.add(trayIcon); //设置托盘的图标，
        } catch (AWTException e2) {
            e2.printStackTrace();
        }
        this.addWindowListener(
                new WindowAdapter() {
            public void windowIconified(WindowEvent e) {
                dispose(); //窗口最小化时dispose该窗口
            }
        });
        trayIcon.addMouseListener(
                new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) //双击托盘窗口再现
                    setExtendedState(Frame.NORMAL); //状态
                setVisible(true);
            }
        });
    }
}
