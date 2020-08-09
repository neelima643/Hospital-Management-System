package hospital;
import java.awt.image.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.labrecords;
import hospital.labreport;
import hospital.resultentry;
import hospital.test;
import hospital.testentry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class lab extends JFrame {

	private JPanel contentPane;
	private JButton btnupdate;
	private JButton btnedit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab frame = new lab();
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
	public lab() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0,1600, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LAB RECORDS");
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new labrecords().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(1047, 166, 289, 52);
		panel.add(btnNewButton);
		
		JButton btnTestEntry = new JButton("TEST ENTRY");
		btnTestEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new testentry().setVisible(true);
			}
		});
		btnTestEntry.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTestEntry.setBounds(1047, 278, 289, 52);
		panel.add(btnTestEntry);
		
		JButton btnResultEntry = new JButton("RESULT ENTRY");
		btnResultEntry.setBackground(UIManager.getColor("Button.background"));
		btnResultEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new resultentry().setVisible(true);
			}
		});
		btnResultEntry.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnResultEntry.setBounds(1047, 381, 289, 52);
		panel.add(btnResultEntry);
		
		JButton btnLabReports = new JButton("LAB REPORTS");
		btnLabReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new labreport().setVisible(true);
			}
		});
		btnLabReports.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLabReports.setBounds(1047, 485, 289, 52);
		panel.add(btnLabReports);
		
		JButton btnupdate;
		btnupdate = new JButton(" TESTS");
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new test().setVisible(true);
			}
		});
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnupdate.setBounds(1047, 608, 289, 52);
		panel.add(btnupdate);
		
     	JLabel lblNewLabel = new JLabel("");
     	lblNewLabel.setBackground(new Color(255, 255, 224));
		lblNewLabel.setBounds(0, 0, 1600, 900);
		Image img1 = new ImageIcon(this.getClass().getResource("/l6.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel);


		
	
	}

}