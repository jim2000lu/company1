package Controller.Sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(26, 10, 383, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel.setBounds(61, 68, 90, 30);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblPassword.setBounds(61, 124, 90, 30);
		panel.add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		txtUserName.setBounds(161, 68, 148, 30);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(161, 129, 148, 30);
		panel.add(txtPassword);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * 1.帳號密碼 getText()
				 * 2.queryUser(帳號,密碼):member
				 * 3.!=null--->loginSuccess
				 * 4.null-->loginError
				 */
				
				String Username=txtUserName.getText();
				String Password=txtPassword.getText();
				
				member m=new implMember().queryMember(Username, Password);
				
				if(m!=null)
				{
					LoginSuccessUI l=new LoginSuccessUI();
					l.show();
					dispose();
				}
				else
				{
					LoginFailUI l=new LoginFailUI();
					l.show();
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(140, 186, 85, 23);
		panel.add(btnNewButton);
	}
}
