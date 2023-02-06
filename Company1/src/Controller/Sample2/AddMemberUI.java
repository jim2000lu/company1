package Controller.Sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtAddress;
	private JTextField txtMobile;
	private JTextField txtPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 287, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(10, 10, 254, 391);
		contentPane.add(panel);
		
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
		txtName.setColumns(10);
		txtName.setBounds(101, 74, 139, 21);
		panel.add(txtName);
		
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
				 * 1.username-->getText
				 * 2.帳號判斷-->queryusername():boolean
				 * 3.true-->重複-->addError
				 * 4.false-->接收所有資料-->new member-->add()-->addSuccess
				 */
				
				String Username=txtUserName.getText();
				if(new implMember().queryUser(Username))
				{
					AddMemFailUI error=new AddMemFailUI();
					error.show();
					dispose();
				}
				else
				{
					String Name=txtName.getText();
					String Password=txtPassword.getText();
					String Address=txtAddress.getText();
					String Mobile=txtMobile.getText();
					String Phone=txtPhone.getText();
					
					member m=new member(Name,Username,Password,Address,Mobile,Phone);
					
					new implMember().add(m);
					
					AddMemSuccessUI success=new AddMemSuccessUI();
					success.show();
					dispose();
				}
				
				
				
				
			}
		});
		btnAddNew.setBounds(81, 340, 85, 23);
		panel.add(btnAddNew);
	}

}
