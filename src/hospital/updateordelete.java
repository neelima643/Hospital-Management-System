package hospital;

import java.awt.EventQueue;
import java.awt.Image;
import database.dbconnection;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateordelete extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateordelete window = new updateordelete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateordelete() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient ID:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(46, 27, 114, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(53, 131, 114, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(53, 175, 114, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(53, 219, 114, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact no.:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(53, 276, 114, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Address:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 338, 114, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(53, 446, 128, 34);
		getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 16));
		textField.setBounds(261, 36, 289, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(261, 141, 289, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 16));
		textField_3.setBounds(261, 229, 289, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 16));
		textField_4.setBounds(261, 286, 289, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 16));
		textField_5.setBounds(261, 348, 289, 71);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 16));
		textField_6.setBounds(261, 456, 289, 22);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				String name = textField_1.getText();
				String gender = textField_2.getText();
				String age = textField_3.getText();
				String contactno = textField_4.getText();
				String address = textField_5.getText();
				String bloodgroup = textField_6.getText();
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					stmnt.executeUpdate("update addpatient set name='"+name+"', gender='"+gender+"', age='"+age+"', contactno='"+contactno+"', address='"+address+"', bloodgroup='"+bloodgroup+"' where patientID='"+patientID+"'");
					JOptionPane.showMessageDialog(rootPane, "Patient details updated successfully");
					setVisible(false);
					new updateordelete().setVisible(true);
				}
				
				catch(Exception excepti) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured");
				}
			}
		});
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(53, 556, 114, 38);
		getContentPane().add(btnNewButton);
		initialize();
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(424, 555, 101, 41);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from addpatient where patientID='"+patientID+"'");
				
				if(rs.next()) {
					
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
					textField_4.setText(rs.getString(5));
					textField_5.setText(rs.getString(6));
					textField_6.setText(rs.getString(7));
					
				}
				else {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patientID");
				}
				
				
				}
				
				catch(Exception except) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(261, 84, 114, 38);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					stmnt.executeUpdate("delete from addpatient where patientID='"+patientID+"'");
					JOptionPane.showMessageDialog(rootPane, "Patient deleted successfully");
					setVisible(false);
					new updateordelete().setVisible(true);
					
				}
				
				catch(Exception exceptio) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(224, 556, 128, 38);
		getContentPane().add(btnNewButton_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 16));
		textField_2.setBounds(261, 185, 289, 24);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img1 = new ImageIcon(this.getClass().getResource("/newadd1.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img1));
		lblNewLabel_8.setBounds(0, 0, 596, 604);
		getContentPane().add(lblNewLabel_8);
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(600,632);
		setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisibile(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
