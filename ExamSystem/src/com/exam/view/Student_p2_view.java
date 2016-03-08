/***
 * @author wuhuancai
 * @time 2012年5月30日 10:37:17
 * 考生考试试题面板
 */
package com.exam.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import com.exam.sqlHelper.SQLHelper;
import com.exam.tools.GetInformationFromFile;
import com.exam.tools.MyFonts;
import com.exam.tools.MyMessage;

public class Student_p2_view extends JPanel {

	private JPanel jPanelCenter = null ;
	private JPanel jPanelSouth = null ;
	
	private static final long serialVersionUID = 1L;
	private JLabel jlb1 = null;
	private JScrollPane jsp1 = null ;
	
	private final int NUM_OF_ANSWER = 40 ;
	private JPanel jPanelAnswer = null ;
	private JPanel[] jPanels = new JPanel[NUM_OF_ANSWER];
	JRadioButton radioButtonA[] = new JRadioButton[NUM_OF_ANSWER];
	JRadioButton radioButtonB[] = new JRadioButton[NUM_OF_ANSWER];
	JRadioButton radioButtonC[] = new JRadioButton[NUM_OF_ANSWER];
	JRadioButton radioButtonD[] = new JRadioButton[NUM_OF_ANSWER];
	ButtonGroup buttonGroup[] = new ButtonGroup[NUM_OF_ANSWER];
	private JLabel jlbs[] = new JLabel[NUM_OF_ANSWER];
	private JScrollPane jsp2 = null ;
	
	private JCheckBox jcb = null ;
	private JButton button = null ;
	
	/**考生答案*/
	private static String answer = "" ;
	/**参考答案*/
	private static String trueAnswer = "" ;
	/**单选题分数*/
	private  int score = 0 ;
	public Student_p2_view()
	{
		this.setLayout(new BorderLayout());
		
		jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(1,2,3,3));
		
		jlb1 = new JLabel("<html><pre>"+GetInformationFromFile.getInformation(("F:\\image\\exam.txt"))+"</pre></html>");
		jlb1.setFont(MyFonts.f2);
		jsp1 = new JScrollPane(jlb1);
		jsp1.setBorder(BorderFactory.createTitledBorder(null,"试题区",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		
		
		jPanelAnswer = new JPanel(new BorderLayout());
		jPanelAnswer.setBorder(BorderFactory.createTitledBorder(null,"答题区",TitledBorder.LEFT,TitledBorder.TOP,MyFonts.f13));
		JPanel jPanel = new JPanel(new GridLayout(NUM_OF_ANSWER, 1, 2, 2));
		for (int i = 0; i < NUM_OF_ANSWER; i++) {
			jPanels[i] = new JPanel();
			radioButtonA[i] = new JRadioButton("A");
			radioButtonB[i] = new JRadioButton("B");
			radioButtonC[i] = new JRadioButton("C");
			radioButtonD[i] = new JRadioButton("D");
			buttonGroup[i] = new ButtonGroup();
			buttonGroup[i].add(radioButtonA[i]);
			buttonGroup[i].add(radioButtonB[i]);
			buttonGroup[i].add(radioButtonC[i]);
			buttonGroup[i].add(radioButtonD[i]);
			jlbs[i] = new JLabel(String.valueOf(i+1)+",",JLabel.CENTER);
			jlbs[i].setFont(MyFonts.f2);
			jPanels[i].add(radioButtonA[i]);
			jPanels[i].add(radioButtonB[i]);
			jPanels[i].add(radioButtonC[i]);
			jPanels[i].add(radioButtonD[i]);
			if (radioButtonA[i].isSelected()) {
				radioButtonA[i].setBackground(Color.red);
			}else if (radioButtonB[i].isSelected()) {
				radioButtonB[i].setBackground(Color.red);
			}else if(radioButtonC[i].isSelected()){
				radioButtonC[i].setForeground(Color.red);
			}else if (radioButtonD[i].isSelected()) {
				radioButtonD[i].setBackground(Color.red);
			}
			jPanel.add(jlbs[i]);
			jPanel.add(jPanels[i]);
		}
		jsp2 = new JScrollPane(jPanel);
		jPanelAnswer.add(jsp2);
		
		
		jPanelSouth = new JPanel();
		jcb = new JCheckBox("我想交卷");
		jcb.setFont(MyFonts.f2);
		button = new JButton("确定交卷");
		button.setFont(MyFonts.f2);
		button.setEnabled(false);
		jPanelSouth.add(button);
		jPanelSouth.add(jcb);
		
		jcb.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (jcb.isSelected()) {
					button.setEnabled(true);
				}else {
					button.setEnabled(false);
				}
			}
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				answer = getAnswer();
				if (answer.length()!=NUM_OF_ANSWER) {
					MyMessage.showMessageDialog("同学你好，你未完成答题。\n请做完后再交卷，谢谢！");
					return;
				}else {
					/**交卷成功后 使复选框和交卷按钮变为不可用，防止再次修改试卷后造成信息不正确*/
					jcb.setEnabled(false);
					button.setEnabled(false);
					
					/**获得考生的用户名*/
					String userName = User_Login.get_user_name();
					
					
					/**从数据库中获得单选题的参考答案，并和考生的答案进行对比，自动算分*/
					SQLHelper sqlHelper = new SQLHelper();
					String sql_qury = "select 单选题参考答案 from 试卷参考答案表 where 试卷编号='"+1+"'";
					ResultSet set = sqlHelper.query(sql_qury);
					try {
						
					while(set.next())
					{
						/**获得参考答案*/
						trueAnswer = set.getString(1);
						
						for (int i = 0; i < answer.length(); i++) {
						
							if (answer.charAt(i)==trueAnswer.charAt(i)) {
								
								score += 2 ;
							}
						}
					}
					
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					MyMessage.showMessageDialog(answer+"\n"+"SCORE:" + score);
					
					/**将考生的答案放到数据库中*/
					String sql_insert = "insert into 考生答题表 (用户名,试卷编号,单选题答案) values('"+userName+"','"+1+"','"+answer+"')";
					SQLHelper helper = new SQLHelper();
					helper.insert(sql_insert);
				}
			}
		});
		
		jPanelCenter.add(jsp1);
		jPanelCenter.add(jPanelAnswer);
		
		this.add(jPanelCenter,"Center");
		this.add(jPanelSouth,"South");
	}
	
	/**
	 *获得用户的答题卡答案
	 */
	public String getAnswer()
	{
		String str = "" ;
		
		for (int i = 0; i < NUM_OF_ANSWER; i++) {
			if (radioButtonA[i].isSelected()) {
				str += "A" ;
			}else if (radioButtonB[i].isSelected()) {
				str += "B" ;
			}else if (radioButtonC[i].isSelected()) {
				str += "C" ;
			}else if (radioButtonD[i].isSelected()) {
				str += "D" ;
			}
		}
		return str ;
	}
}
