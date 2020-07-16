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
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class addconsultation extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addconsultation window = new addconsultation();
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
	public addconsultation() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(37, 234, 114, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialization:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(37, 278, 144, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patient ID:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(30, 45, 114, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Disease:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(37, 325, 114, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Medicines:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(37, 391, 114, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Other tests(if any):");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(37, 465, 171, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Need to be admited or not:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(37, 538, 251, 34);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ICU/Ward(Type)");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_7.setBounds(37, 582, 144, 34);
		getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(237, 241, 319, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 287, 319, 34);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 52, 190, 25);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(237, 344, 319, 47);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(237, 401, 319, 58);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(237, 481, 319, 47);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ICU", "General Ward", "Pay Ward"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(237, 586, 319, 27);
		getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton.isSelected()) {
					
					lblNewLabel_7.setVisible(true);
					comboBox.setVisible(true);
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(305, 545, 82, 21);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton_1.isSelected()) {
					lblNewLabel_7.setVisible(false);
					comboBox.setVisible(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(470, 545, 82, 21);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"pattientid", "name", "age", "gender", "contactno", "address", "bloodgroup", "date"},
			},
			new String[] {
				"", "", "New column", "New column", "New column", "", "New column", "New column"
			}
		));
		table.setBounds(10, 108, 576, 34);
		getContentPane().add(table);
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField_3.getText();
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select *from addpatient where patientID='"+patientID+"'");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				if(!rs.first()) {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patient ID");
					
				}
				}
				catch(Exception exc) {
					
					JOptionPane.showMessageDialog(rootPane, "Error! Retry again.");
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(455, 50, 101, 25);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField_3.getText();
				String date = textField_2.getText();
				String time = textField_4.getText();
				String doctor = textField.getText();
				String specialization = textField_1.getText();
				String disease = textField_5.getText();
				String medicines = textField_6.getText();
				String test = textField_7.getText();
				String admit = "NO";
				String icuward = "";
				
				if(rdbtnNewRadioButton.isSelected()) {
					
					admit = "YES";
					icuward = (String)comboBox.getSelectedItem();
					
				}
				
				if(rdbtnNewRadioButton_1.isSelected()) {
					
					admit = "NO";
					icuward = "";
					
				}
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					stmnt.executeUpdate("insert into addconsultationinfo values('"+patientID+"', '"+doctor+"', '"+specialization+"', '"+disease+"', '"+medicines+"', '"+test+"', '"+admit+"', '"+icuward+"','"+time+"', '"+date+"')");
					JOptionPane.showMessageDialog(rootPane, "Consultation information is added successfully.");
					setVisible(false);
					new addconsultation().setVisible(true);
					
				}

				catch(Exception exce) {
					
					JOptionPane.showMessageDialog(rootPane, "Information is not entered in the correct format");
					
				}
				
				
				
			
			
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(37, 656, 107, 38);
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
		btnNewButton_1.setBounds(455, 655, 101, 41);
		getContentPane().add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 167, 319, 29);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Date:");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(37, 164, 102, 21);
		getContentPane().add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 206, 315, 25);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Time:");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10.setBounds(37, 203, 107, 21);
		getContentPane().add(lblNewLabel_10);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img1 = new ImageIcon(this.getClass().getResource("/newadd1.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img1));
		lblNewLabel_8.setBounds(0, 0, 596, 704);
		getContentPane().add(lblNewLabel_8);
		
		
		
	
		
		
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(600,732);
		setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisibile(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
