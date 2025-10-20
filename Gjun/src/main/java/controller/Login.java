package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private MemberServiceImpl msi=new MemberServiceImpl();//
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(42, 43, 347, 170);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(81, 26, 67, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(78, 62, 67, 34);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("新細明體", Font.BOLD, 18));
		username.setBounds(162, 28, 96, 20);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("新細明體", Font.BOLD, 18));
		password.setBounds(164, 73, 96, 20);
		panel_1.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				Member member=msi.Login(Username, Password);//
				
				if(member!=null) {
					Tool.saveMember(member);//
//					LoginSuccess success=new LoginSuccess();
					GorderUI success=new GorderUI();//登入成功後導入GorderUI頁面
					success.setVisible(true);
					dispose();
				}else {
					LoginError error=new LoginError();
					error.setVisible(true);
					dispose();
				}
				
			}
			
		});
		btnNewButton.setBounds(79, 125, 176, 22);
		panel_1.add(btnNewButton);

	}
}
