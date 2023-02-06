package Controller.Sample1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import Model.member;
import Dao.implMember;


public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtAddress;
	private JTextField txtMobile;
	private JTextField txtPhone;
	private JTextField txtUpdateID;
	private JTextField txtDelID;
	private JTextField txtUpName;
	private JTextField txtUpAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(10, 10, 254, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 69, 73, 23);
		panel.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("userName");
		lblUsername.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblUsername.setBounds(10, 113, 83, 23);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblPassword.setBounds(10, 155, 88, 23);
		panel.add(lblPassword);
		
		JLabel lblAddress = new JLabel("address");
		lblAddress.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblAddress.setBounds(10, 201, 73, 23);
		panel.add(lblAddress);
		
		JLabel lblMobile = new JLabel("mobile");
		lblMobile.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblMobile.setBounds(10, 247, 73, 23);
		panel.add(lblMobile);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblPhone.setBounds(10, 291, 73, 23);
		panel.add(lblPhone);
		
		txtName = new JTextField();
		txtName.setBounds(101, 74, 139, 21);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(101, 118, 139, 21);
		panel.add(txtUserName);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(101, 160, 139, 21);
		panel.add(txtPassword);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(101, 206, 139, 21);
		panel.add(txtAddress);
		
		txtMobile = new JTextField();
		txtMobile.setColumns(10);
		txtMobile.setBounds(101, 252, 139, 21);
		panel.add(txtMobile);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(101, 296, 139, 21);
		panel.add(txtPhone);
		
		JButton btnAddNew = new JButton("新增");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * 1.UI接收 getText
				 * 2.new member()
				 * 3.add(m)
				 */
				String Name=txtName.getText();
				String Username=txtUserName.getText();
				String Password=txtPassword.getText();
				String Address=txtAddress.getText();
				String Mobile=txtMobile.getText();
				String Phone=txtPhone.getText();
				
		         member m=new member(Name,Username,Password,Address,Mobile,Phone);	       
		         new implMember().add(m);
				
			}			

		});
		btnAddNew.setBounds(81, 340, 85, 23);
		panel.add(btnAddNew);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(274, 10, 608, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea txtAreaOutput = new JTextArea();
		txtAreaOutput.setBounds(10, 146, 588, 200);
		panel_1.add(txtAreaOutput);
		

		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(253, 80, 52, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblAddress_1 = new JLabel("address");
		lblAddress_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblAddress_1.setBounds(415, 80, 73, 23);
		panel_1.add(lblAddress_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblId.setBounds(140, 113, 29, 23);
		panel_1.add(lblId);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblId_1.setBounds(140, 80, 29, 23);
		panel_1.add(lblId_1);
		
		JLabel lbCnt = new JLabel("Cnt");
		lbCnt.setBounds(20, 366, 65, 15);
		panel_1.add(lbCnt);
		
		
		txtUpdateID = new JTextField();
		txtUpdateID.setBounds(164, 81, 65, 21);
		panel_1.add(txtUpdateID);
		txtUpdateID.setColumns(10);
		
		txtDelID = new JTextField();
		txtDelID.setBounds(164, 114, 65, 21);
		panel_1.add(txtDelID);
		txtDelID.setColumns(10);
		
		txtUpName = new JTextField();
		txtUpName.setBounds(309, 81, 96, 21);
		panel_1.add(txtUpName);
		txtUpName.setColumns(10);
		
		txtUpAddress = new JTextField();
		txtUpAddress.setBounds(481, 85, 117, 21);
		panel_1.add(txtUpAddress);
		txtUpAddress.setColumns(10);
		
		
		JButton btnNewButton = new JButton("查詢(全部)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * 1.show.setText-->queryAll1():String
				 */
				
				txtAreaOutput.setText(new implMember().queryAll1());
				
				List<member> l=new implMember().queryAll2();
				lbCnt.setText("共:"+l.size()+"筆");
				
				
			}
		});
		btnNewButton.setBounds(33, 47, 97, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * 1.nameUpdate,addressUpdate ,updateId-->getText
				 * 2.updateId-->轉成int--->queryId(id)-->member m
				 * 3.m.setName(),m.setAddress()
				 * 4.update(m)
				 */
				
				String Name=txtUpName.getText();
				String Address=txtUpAddress.getText();
				
				int ID=Integer.parseInt(txtUpdateID.getText());				
				member m=new implMember().queryId(ID);
				m.setName(Name);
				m.setAddress(Address);
				
				new implMember().update(m);				
						
				
				
			}
		});
		btnNewButton_1.setBounds(33, 80, 97, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * 1.deleteId-->getText-->轉型-->int
				 * 2.執行 delete(id)
				 */
				
				int Id=Integer.parseInt(txtDelID.getText());				
				new implMember().delete(Id);				
				
			}
		});
		btnNewButton_2.setBounds(33, 113, 97, 23);
		panel_1.add(btnNewButton_2);
		
		
	}
}
