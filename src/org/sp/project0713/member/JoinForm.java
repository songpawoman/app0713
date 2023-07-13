package org.sp.project0713.member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JoinForm extends JFrame implements ActionListener{
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
		
		bt_connect.addActionListener(this);//버튼들과 리스너연결
		bt_regist.addActionListener(this);//버튼들과 리스너연결
	}
	
	//MySQL DB에 접속을 시도해본다
	public void connect(){
		//MySQL 드라이버를 로드한다 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버가 존재하지 않습니다");
		}
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();

		if(obj == bt_connect){ //접속버튼을 누르면
			connect();
		}else if(obj==bt_regist){//가입버튼을 누르면
			
		}
	}

	public static void main(String[] args) {
		new JoinForm();
	}
}
