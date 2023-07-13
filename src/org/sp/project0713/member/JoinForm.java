package org.sp.project0713.member;

import javax.swing.*;
import java.awt.*;

class JoinForm extends JFrame{
	JTextField t_id;
	JTextField t_name;
	JTextField t_phone;
	JButton bt_connect; //데이터베이스 접속 버튼
	JButton bt_regist; //등록버튼 

	public JoinForm(){
		t_id				= new JTextField();
		t_name			= new JTextField();
		t_phone			= new JTextField();
		bt_connect		= new JButton("접속");
		bt_regist		= new JButton("가입");
		
		Dimension d = new Dimension(280, 40);
		t_id.setPreferredSize(d);
		t_name.setPreferredSize(d);
		t_phone.setPreferredSize(d);
	
		setLayout(new FlowLayout());				

		add(t_id);
		add(t_name);
		add(t_phone);
		add(bt_connect);
		add(bt_regist);

		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JoinForm();
	}
}
