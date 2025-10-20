package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	private MemberServiceImpl msi=new MemberServiceImpl();//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
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
	public AddMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 24, 368, 191);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名:");
		lblNewLabel.setBounds(27, 19, 47, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(27, 51, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼:");
		lblNewLabel_2.setBounds(27, 82, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址:");
		lblNewLabel_3.setBounds(25, 111, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("電話:");
		lblNewLabel_4.setBounds(23, 143, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("註冊");
		lblNewLabel_5.setBounds(128, 2, 46, 14);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(109, 21, 96, 20);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(109, 48, 96, 20);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(109, 79, 96, 20);
		panel.add(password);
		password.setColumns(10);
		
		address = new JTextField();
		address.setBounds(109, 109, 96, 20);
		panel.add(address);
		address.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(110, 136, 96, 20);
		panel.add(phone);
		phone.setColumns(10);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				Member member=new Member(Name,Username,Password,Address,Phone);
				if(msi.addMember(member)==1) {
					AddMemberError addMemberError=new AddMemberError();
					addMemberError.setVisible(true);
					dispose();
				}else {
					AddMemberSuccess addMemberSuccess=new AddMemberSuccess();
					addMemberSuccess.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBounds(90, 164, 84, 22);
		panel.add(btnNewButton);

	}

}
