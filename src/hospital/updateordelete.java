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
		lblNewLabel_1.setBounds(89, 27, 114, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(89, 132, 114, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(89, 197, 114, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(89, 257, 114, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact no.:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(89, 310, 114, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Address:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(89, 389, 114, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(89, 493, 128, 34);
		getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(295, 33, 386, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(295, 141, 386, 25);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(295, 261, 386, 28);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setBounds(295, 316, 386, 28);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setBounds(295, 399, 386, 71);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_6.setBounds(296, 499, 385, 28);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		Image img4 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img4));
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
		btnNewButton.setBounds(89, 590, 152, 38);
		getContentPane().add(btnNewButton);
		initialize();
		
		JButton btnNewButton_1 = new JButton("EXIT");
		Image img5 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img5));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(566, 589, 122, 41);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		Image img2 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img2));
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
		btnNewButton_2.setBounds(539, 81, 142, 38);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		Image img3 = new ImageIcon(this.getClass().getResource("/delete.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img3));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientID = Integer.parseInt(textField.getText());
				
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
		btnNewButton_3.setBounds(328, 590, 142, 38);
		getContentPane().add(btnNewButton_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setBounds(295, 201, 386, 28);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img1 = new ImageIcon(this.getClass().getResource("/pwi.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img1));
		lblNewLabel_8.setBounds(0, 0, 796, 672);
		getContentPane().add(lblNewLabel_8);
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(800,700);
		setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisibile(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
