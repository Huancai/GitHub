/**
 * @author wuhuancai
 * @time 2012年4月27日0:32:02
 * 管理员的系统设置界面
 */
package com.exam.view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.MyFonts;
import com.exam.tools.MyMessage;

public class Admin_P4_view extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;

	private JLabel jlb_logout,jlb_backups,jlb_restore;
	
	public Admin_P4_view()
	{
		this.setLayout(null);
		
		jlb_logout = new JLabel(new ImageIcon("images/01.gif"));
		jlb_logout.setBounds(15, 15, 170, 130);
		jlb_logout.setFont(MyFonts.f4);
		jlb_logout.setEnabled(false);
		jlb_logout.setToolTipText("点击注销系统！");
		jlb_logout.setBorder(BorderFactory.createTitledBorder(null,"注销登录",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		jlb_logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlb_logout.addMouseListener(this);
		
		jlb_backups = new JLabel(new ImageIcon("images/备份.png"));
		jlb_backups.setBounds(250, 250, 130, 96);
		jlb_backups.setEnabled(false);
		jlb_backups.setToolTipText("点击备份数据库！");
		jlb_backups.setBorder(BorderFactory.createTitledBorder(null,"备份数据库",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		jlb_backups.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlb_backups.addMouseListener(this);
		
		jlb_restore = new JLabel(new ImageIcon("images/管理监控.gif"));
		jlb_restore.setBounds(430, 430, 133, 74);
		jlb_restore.setEnabled(false);
		jlb_restore.setToolTipText("点击还原数据库！");
		jlb_restore.setBorder(BorderFactory.createTitledBorder(null,"还原数据库",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f2));
		jlb_restore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jlb_restore.addMouseListener(this);
		
		this.add(jlb_logout);
		this.add(jlb_backups);
		this.add(jlb_restore);
		this.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource()==jlb_logout&&e.getClickCount()==2) {
			int x = MyMessage.showConfirmDialog("您确定要注销系统吗？\n注销成功后将退出该系统！");
			if (x==0) {
				
				new User_Login();
				
			}else {
				return ;
			}
		}
		else if (e.getSource()==jlb_backups) {
			
			String name = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date())+".bak";
			File file = new File("F:/backup/");
			if (!file.exists()) {
				file.mkdirs();
				System.out.println("路径创建成功。。。");
			}
			String db_name = "在线考试系统数据库";
			String  sql = "backup database "+db_name+" to disk='"+"F:/backup/"+name+"' with format,name='full backup of "+db_name+"'";
			SQLHelper help = new SQLHelper();
			int n = help.backup(sql);
			System.out.println(n);
			if (n==0) {
				MyMessage.showMessageDialog("备份成功...");
			}else {
				MyMessage.showMessageDialog("备份失败...");
			}
			
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		if (e.getSource()==jlb_logout) {
			jlb_logout.setEnabled(true);
		}else if(e.getSource()==jlb_backups){
			jlb_backups.setEnabled(true);
		}else if (e.getSource()==jlb_restore) {
			jlb_restore.setEnabled(true);
		}
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource()==jlb_logout) {
			jlb_logout.setEnabled(false);
		}else if(e.getSource()==jlb_backups){
			jlb_backups.setEnabled(false);
		}else if (e.getSource()==jlb_restore) {
			jlb_restore.setEnabled(false);
		}
	}

}
