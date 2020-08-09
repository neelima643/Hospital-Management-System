package hospital;

import java.awt.BorderLayout;
import database.dbconnection;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.image.*;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
public class testentry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnexit;
	private JComboBox comboBoxName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testentry frame = new testentry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillComboBox() {
		try
		{
	    Connection con = dbconnection.getCon();
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery("select * from tests");
		while(rs.next()) {
			comboBoxName.addItem(rs.getString("testtype"));
			
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}

	/**
	 * Create the frame.
	 */
	public testentry() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(0, 0, 800, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 800);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(113, 184, 149, 30);
		panel.add(lblNewLabel);
		
		JLabel lblPatientName = new JLabel("PATIENT NAME");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPatientName.setBounds(113, 253, 190, 30);
		panel.add(lblPatientName);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDepartment.setBounds(113, 321, 177, 30);
		panel.add(lblDepartment);
		
		JLabel lblTestDate = new JLabel("TEST DATE");
		lblTestDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTestDate.setBounds(113, 539, 149, 30);
		panel.add(lblTestDate);
		
		JLabel lblTestType = new JLabel("TEST TYPE");
		lblTestType.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTestType.setBounds(113, 390, 149, 30);
		panel.add(lblTestType);
		
		JLabel lblTestAmount = new JLabel("TEST AMOUNT");
		lblTestAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTestAmount.setBounds(113, 466, 190, 30);
		panel.add(lblTestAmount);
		
		textField = new JTextField();
		textField.setBounds(336, 174, 315, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(336, 242, 315, 40);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(336, 311, 315, 40);
		panel.add(textField_2);
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(336, 456, 315, 40);
		panel.add(textField_4);
		 
		
		
		
		 comboBoxName = new JComboBox();
		 comboBoxName.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		String s=comboBoxName.getSelectedItem().toString();
		 		try
				{
		 		Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select * from tests where testtype='"+s+"' ");
				while(rs.next()) {
					
					textField_4.setText(rs.getString("testamount"));
				}
				}catch(Exception e1){
					e1.printStackTrace();
					
				}
		 	}
		 });
        comboBoxName.setBackground(Color.WHITE);
		comboBoxName.setBounds(336, 392, 315, 40);
		panel.add(comboBoxName);
		
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(336, 529, 315, 40);
		panel.add(textField_5);
		
		JButton btnexit;
		btnexit = new JButton("EXIT");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnexit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnexit.setBounds(474, 653, 177, 52);
		panel.add(btnexit);
		
		JButton btnadd = new JButton("ADD");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientID = textField.getText();
				String name = textField_1.getText();
				String department = textField_2.getText();
				String testtype =( String)comboBoxName.getSelectedItem();
				String testamount = textField_4.getText();
				String testdate = textField_5.getText();
				
				
			
			try {
		
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				stmnt.executeUpdate("insert into testentry values('"+patientID+"', '"+name+"', '"+department+"','"+testtype+"', '"+testamount+"', '"+testdate+"')");
				JOptionPane.showMessageDialog(rootPane, "Successfully added.");
				setVisible(false);
				
			}
			catch(Exception ex) {
				
				JOptionPane.showMessageDialog(rootPane, "Invalid format of data. Please enter it in the correct format.");
				
			}
			}
		});
		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnadd.setBounds(159, 653, 177, 52);
		panel.add(btnadd);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(0, -56, 841, 800);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel_1);
		fillComboBox();	
	
	}
}