package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Gorder;
import model.Member;
import service.impl.GorderServiceImpl;
import util.Tool;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class GorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private GorderServiceImpl gsi = new GorderServiceImpl();
	private Member member = Tool.readMember();//
	private JPanel contentPane;
	private JTextField insertLcd;
	private JTextField insertRam;
	private JTextField updateId;
	private JTextField updateLcd;
	private JTextField updateRam;
	private JTextField deleteId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GorderUI frame = new GorderUI();
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
	public GorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 39, 390, 75);
		contentPane.add(scrollPane);

		JTextArea findAllOutput = new JTextArea();
		scrollPane.setViewportView(findAllOutput);

		JLabel lblNewLabel = new JLabel("Lcd");
		lblNewLabel.setBounds(24, 153, 45, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Ram");
		lblNewLabel_1.setBounds(171, 155, 45, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setBounds(19, 211, 45, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Lcd");
		lblNewLabel_3.setBounds(137, 209, 45, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Ram");
		lblNewLabel_4.setBounds(269, 210, 45, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Id");
		lblNewLabel_5.setBounds(130, 241, 45, 14);
		contentPane.add(lblNewLabel_5);

		insertLcd = new JTextField();
		insertLcd.setBounds(48, 150, 96, 20);
		contentPane.add(insertLcd);
		insertLcd.setColumns(10);

		insertRam = new JTextField();
		insertRam.setBounds(210, 152, 96, 20);
		contentPane.add(insertRam);
		insertRam.setColumns(10);

		updateId = new JTextField();
		updateId.setBounds(32, 206, 96, 20);
		contentPane.add(updateId);
		updateId.setColumns(10);

		updateLcd = new JTextField();
		updateLcd.setBounds(159, 205, 96, 20);
		contentPane.add(updateLcd);
		updateLcd.setColumns(10);

		updateRam = new JTextField();
		updateRam.setBounds(302, 206, 96, 20);
		contentPane.add(updateRam);
		updateRam.setColumns(10);

		// *****************Button********************************************8//
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Gorder> allGorder = gsi.findAllGorder();
				String show = "";
				for (Gorder o : allGorder) {
					show+= "id:" + o.getId() + "\tname:" + o.getName() + "\tlcd:" + o.getLcd() + "\tram:"
							+ o.getRam() + "\n";
				}
				findAllOutput.setText(show);
			}
		});
		btnNewButton.setBounds(22, 10, 85, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("新增");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int lcd = Integer.parseInt(insertLcd.getText());
				int ram = Integer.parseInt(insertRam.getText());

				Gorder gorder = new Gorder(member.getName(), lcd, ram);
				gsi.addGorder(gorder);
			}
		});
		btnNewButton_1.setBounds(22, 121, 84, 22);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.findById-->來自資料庫修改內容
				 * 2.updateGorder-->修改覆蓋
				 */
				int id=Integer.parseInt(updateId.getText());
				int lcd=Integer.parseInt(updateLcd.getText());
				int ram=Integer.parseInt(updateRam.getText());
				
				List<Gorder> list=gsi.findById(id);
				Gorder gorder=list.get(0);
				gorder.setLcd(lcd);
				gorder.setRam(ram);
				
				gsi.updateGorder(gorder);
			}
		});
		btnNewButton_2.setBounds(23, 178, 84, 22);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("刪除");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id=Integer.parseInt(deleteId.getText());
				gsi.deleteById(id);
			}
		});
		btnNewButton_3.setBounds(23, 233, 84, 22);
		contentPane.add(btnNewButton_3);
		
		deleteId = new JTextField();
		deleteId.setBounds(145, 236, 96, 20);
		contentPane.add(deleteId);
		deleteId.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(395, 40, 16, 48);
		contentPane.add(scrollBar);
		
		JLabel memberName = new JLabel("");
		memberName.setForeground(new Color(128, 0, 64));
		memberName.setFont(new Font("新細明體", Font.BOLD, 15));
		memberName.setBounds(129, 7, 278, 26);
		contentPane.add(memberName);
		
		memberName.setText("登入成功!!  \'"+member.getName()+"\'  ,歡迎光臨!");//
	}
}
