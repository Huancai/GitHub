/**
 * @author wuhuancai
 * @time 2012年4月15日4:50:45
 * 用于设置JOptionPane字体的公用类
 * 相当于复写了JOptionPane类
 */

/**
	   Font font = new Font("Courier", Font.PLAIN, 12);
	 	UIManager.put("Button.font", font);
	   UIManager.put("Table.font", font);
	   UIManager.put("Label.font", font);
	   UIManager.put("ComboBox.font", font);
	   UIManager.put("TextField.font", font);
	   UIManager.put("TableHeader.font", font);
	   UIManager.put("Label.foreground", Color.GREEN);
 */
package com.exam.tools;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MyMessage {
	
	/**
	 * 
	 * @param str 消息框显示的内容
	 * JOptionPane.showMessageDialog
	 */
	public static void showMessageDialog(String str)
	{
		UIManager.put("Label.font", MyFonts.f2);
		UIManager.put("Button.font", MyFonts.f2);
		JOptionPane.showMessageDialog(null, str);
	}
	
	/**
	 * 
	 * @param str 消息框显示的内容
	 * JOptionPane.showConfirmDialog()
	 */
	public static int showConfirmDialog(String str)
	{
		UIManager.put("Label.font", MyFonts.f2);
		UIManager.put("Button.font", MyFonts.f2);
		return JOptionPane.showConfirmDialog(null, str,"消息",JOptionPane.YES_NO_OPTION);
	}
	
	
	/**
	 * 
	 * @param str 消息框要显示的内容
	 * @param image 消息框的信息图标
	 * @return 
	 */
	public static int showConfirmDialog(String str,Icon image)
	{
		UIManager.put("Label.font", MyFonts.f2);
		UIManager.put("Button.font", MyFonts.f2);
		return JOptionPane.showConfirmDialog(null, str,"消息",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,image);
	}
}
