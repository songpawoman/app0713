package org.sp.project0713.member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class JoinForm extends JFrame implements ActionListener{
	JTextField t_id;
	JTextField t_name;
	JTextField t_phone;
	JButton bt_connect; //�����ͺ��̽� ���� ��ư
	JButton bt_regist; //��Ϲ�ư 

	public JoinForm(){
		t_id				= new JTextField();
		t_name			= new JTextField();
		t_phone			= new JTextField();
		bt_connect		= new JButton("����");
		bt_regist		= new JButton("����");
		
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
		
		bt_connect.addActionListener(this);//��ư��� �����ʿ���
		bt_regist.addActionListener(this);//��ư��� �����ʿ���
	}
	
	//MySQL DB�� ������ �õ��غ���
	public void connect(){
		//MySQL ����̹��� �ε��Ѵ� 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� �ε� ����");
		}catch(ClassNotFoundException e){
			System.out.println("����̹��� �������� �ʽ��ϴ�");
		}
	}

	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();

		if(obj == bt_connect){ //���ӹ�ư�� ������
			connect();
		}else if(obj==bt_regist){//���Թ�ư�� ������
			
		}
	}

	public static void main(String[] args) {
		new JoinForm();
	}
}
