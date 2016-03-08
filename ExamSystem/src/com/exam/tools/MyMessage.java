/**
 * @author wuhuancai
 * @time 2012��4��15��4:50:45
 * ��������JOptionPane����Ĺ�����
 * �൱�ڸ�д��JOptionPane��
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
	 * @param str ��Ϣ����ʾ������
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
	 * @param str ��Ϣ����ʾ������
	 * JOptionPane.showConfirmDialog()
	 */
	public static int showConfirmDialog(String str)
	{
		UIManager.put("Label.font", MyFonts.f2);
		UIManager.put("Button.font", MyFonts.f2);
		return JOptionPane.showConfirmDialog(null, str,"��Ϣ",JOptionPane.YES_NO_OPTION);
	}
	
	
	/**
	 * 
	 * @param str ��Ϣ��Ҫ��ʾ������
	 * @param image ��Ϣ�����Ϣͼ��
	 * @return 
	 */
	public static int showConfirmDialog(String str,Icon image)
	{
		UIManager.put("Label.font", MyFonts.f2);
		UIManager.put("Button.font", MyFonts.f2);
		return JOptionPane.showConfirmDialog(null, str,"��Ϣ",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,image);
	}
}
