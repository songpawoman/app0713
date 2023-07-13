/*
JDBC -�ڹ� ���� �����ͺ��̽��� �����ϴ� ����� ����Ŵ 
Java Database Connectivity
java.sql ��Ű������ ������ 
*/
package org.sp.project0713.member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

class JoinForm extends JFrame implements ActionListener{
	JTextField t_id;
	JTextField t_name;
	JTextField t_phone;
	JButton bt_connect; //�����ͺ��̽� ���� ��ư
	JButton bt_regist; //��Ϲ�ư 
	String url="jdbc:mysql://localhost:3306/javase?characterEncoding=utf8";

	//Connection ��ü��? ���� ������ �ϸ�, �� ���������� ������ ��ü
	Connection con=null;

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

		bt_regist.setEnabled(false);//��Ȱ��ȭ
	}
	
	//MySQL DB�� ������ �õ��غ���
	public void connect(){
		//MySQL ����̹��� �ε��Ѵ� 
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� �ε� ����");

			//������ �õ��Ѵ� 

			//������ ������ ����ϴ� jdbc ��ü
			PreparedStatement pstmt=null;


			con=DriverManager.getConnection(url , "root", "1234");
			if(con==null){
				System.out.println("���ӽ��Ф̤�");
			}else{
				System.out.println("���Ӽ���");
				//���ӹ�ư ��Ȱ��ȭ + ���Թ�ư Ȱ��ȭ 
				bt_connect.setEnabled(false);
				bt_regist.setEnabled(true);
			}
		}catch(ClassNotFoundException e){
			System.out.println("����̹��� �������� �ʽ��ϴ�");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//����ϱ�
	public void regist(){
		//�������� �����غ��� 
		String id				= t_id.getText();
		String name		= t_name.getText();
		String phone		= t_phone.getText();

		String sql="insert into member(id,name,phone) values('xman','������','018')";
		PreparedStatement pstmt=null;
		try{
			pstmt=con.prepareStatement(sql);

			//�غ�� �������� �����ϱ� 
			//executeUpdate() �޼����, DML�� ������ �� �ִµ�, �̶� ��������
			//�� �������࿡ ���� ������ ���� ���ڵ� �� �� ��ȯ�Ѵ�. ���� �����ڴ�
			//�� ����� 0�̸�, DML ������ �ȵǾ��ٴ� ���� �� �� �ִ�..
			int result=pstmt.executeUpdate();

			if(result>0){
				JOptionPane.showMessageDialog(this, "���Լ���");
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
	}


	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();

		if(obj == bt_connect){ //���ӹ�yư�� ������
			connect();
		}else if(obj==bt_regist){//���Թ�ư�� ������
			regist();
		}
	}

	public static void main(String[] args) {
		new JoinForm();
	}
}
