package hospital;

import java.awt.EventQueue;
import java.awt.Image;
import database.dbconnection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

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
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class prescription extends JFrame {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prescription window = new prescription();
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
	public prescription() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Contactno:");
		lblNewLabel_17.setForeground(SystemColor.text);
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_17.setBounds(54, 288, 181, 21);
		getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_13 = new JLabel("ICU/Ward(Type):");
		lblNewLabel_13.setForeground(SystemColor.text);
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_13.setBounds(54, 638, 218, 25);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_16 = new JLabel("Need to admitted or not: ");
		lblNewLabel_16.setForeground(SystemColor.text);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_16.setBounds(54, 599, 218, 29);
		getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_15 = new JLabel("Other tests(if any):");
		lblNewLabel_15.setForeground(SystemColor.text);
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_15.setBounds(57, 564, 166, 25);
		getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_14 = new JLabel("Medicines:");
		lblNewLabel_14.setForeground(SystemColor.text);
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_14.setBounds(57, 527, 102, 27);
		getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_12 = new JLabel("Disease:");
		lblNewLabel_12.setForeground(SystemColor.text);
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_12.setBounds(57, 481, 132, 25);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(57, 485, 14, 5);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_7 = new JLabel("Doctor:");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_7.setBounds(57, 440, 132, 25);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Specialization:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(57, 395, 145, 25);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Blood Group:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setBounds(57, 354, 102, 21);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Address:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(57, 319, 105, 25);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Age:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(498, 250, 105, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Gender:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(57, 247, 105, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(57, 203, 102, 21);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(318, 159, 265, 25);
		getContentPane().add(comboBox_1);
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date = comboBox.getSelectedItem().toString();
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rst = stmnt.executeQuery("select time from addconsultationinfo where date = '"+date+"'");	
					comboBox_1.removeAllItems();
					
					
					while(rst.next()) {
						
						
						String s = rst.getString("time");
						comboBox_1.addItem(s);
						
					}
					
					
					
					
				}
				
				catch(Exception e7) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured. Retry again!");
				}
			}
		});
		
		comboBox.setBounds(318, 117, 265, 25);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Go");
		Image img2 = new ImageIcon(this.getClass().getResource("/go.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientid = Integer.parseInt(textField_16.getText());
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select distinct date from addconsultationinfo where patientid = '"+patientid+"'");
				
				while(rs.next()) {
					
					
					String str = rs.getString("date");
					comboBox.addItem(str);
					
					
				}
				
				
				
				
				}
				
				catch(Exception e6) {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patientID!");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(593, 63, 140, 34);
		getContentPane().add(btnNewButton);
		

		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_16.setBounds(318, 66, 265, 25);
		getContentPane().add(textField_16);
		textField_16.setColumns(10);
		

		
		JLabel lblNewLabel_3 = new JLabel("Patient ID:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(57, 63, 114, 34);
		getContentPane().add(lblNewLabel_3);
		

		JButton btnNewButton_2 = new JButton("SEARCH");
		Image img3 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img3));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientid = Integer.parseInt(textField_16.getText());
				String date = comboBox.getSelectedItem().toString();
				String time = comboBox_1.getSelectedItem().toString();
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rsst = stmnt.executeQuery("select addpatient.patientid, addpatient.name, addpatient.gender, addpatient.age, addpatient.contactno, addpatient.address, addpatient.bloodgroup,"
						+ "addconsultationinfo.doctor, addconsultationinfo.specialization,  addconsultationinfo.disease, addconsultationinfo.medicines, "
						+ "addconsultationinfo.test, addconsultationinfo.admit, addconsultationinfo.icuward from addpatient inner join addconsultationinfo where addpatient.patientid = addconsultationinfo.patientID && addpatient.patientid = '"+patientid+"' && addconsultationinfo.date = '"+date+"' && addconsultationinfo.time = '"+time+"'");
				
				
				while(rsst.next()) {
					
					
					textField_17.setText(rsst.getString("name"));
					textField_18.setText(rsst.getString("gender"));
					textField_22.setText(rsst.getString("age"));
					textField_19.setText(rsst.getString("contactno"));
					textField_20.setText(rsst.getString("address"));
					textField_21.setText(rsst.getString("bloodgroup"));
					textField_23.setText(rsst.getString("specialization"));
					textField_24.setText(rsst.getString("doctor"));
					textField_25.setText(rsst.getString("disease"));
					textField_26.setText(rsst.getString("medicines"));
					textField_27.setText(rsst.getString("test"));
					textField_28.setText(rsst.getString("admit"));
					textField_29.setText(rsst.getString("icuward"));
					
					}
					
				}
				
				
				
				
				catch(Exception exc) {
					
					JOptionPane.showMessageDialog(rootPane, "Error! Retry again.");
				}
				
			}
			
			});
		
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.setBounds(593, 126, 140, 41);
		getContentPane().add(btnNewButton_2);
		

		initialize();
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		Image img4 = new ImageIcon(this.getClass().getResource("/clear.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img4));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new prescription().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(588, 676, 145, 41);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Date:");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(54, 115, 102, 25);
		getContentPane().add(lblNewLabel_9);
	
		
		JLabel lblNewLabel_10 = new JLabel("Time:");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10.setBounds(54, 157, 65, 21);
		getContentPane().add(lblNewLabel_10);

		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_17.setBounds(318, 205, 415, 25);
		getContentPane().add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_18.setBounds(318, 249, 159, 22);
		getContentPane().add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_19.setBounds(318, 290, 415, 22);
		getContentPane().add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_20.setBounds(318, 323, 415, 25);
		getContentPane().add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_21.setBounds(318, 365, 415, 25);
		getContentPane().add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_22.setBounds(568, 250, 165, 19);
		getContentPane().add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_23.setBounds(318, 407, 415, 25);
		getContentPane().add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_24.setBounds(318, 454, 415, 25);
		getContentPane().add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_25.setBounds(318, 491, 415, 29);
		getContentPane().add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_26.setBounds(318, 530, 415, 25);
		getContentPane().add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_27.setBounds(318, 569, 415, 24);
		getContentPane().add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_28.setBounds(318, 607, 415, 26);
		getContentPane().add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_29.setBounds(318, 643, 415, 23);
		getContentPane().add(textField_29);
		textField_29.setColumns(10);
		

		
		JLabel lblNewLabel_18 = new JLabel("PRESCRIPTION");
		lblNewLabel_18.setForeground(new Color(0, 153, 255));
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_18.setBounds(262, 10, 265, 34);
		getContentPane().add(lblNewLabel_18);
		
		JButton btnNewButton_3 = new JButton("PRINT");
		Image img5 = new ImageIcon(this.getClass().getResource("/print.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img5));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(57, 676, 132, 41);
		getContentPane().add(btnNewButton_3);
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img1 = new ImageIcon(this.getClass().getResource("/pwi.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img1));
		lblNewLabel_8.setBounds(0, 0, 796, 727);
		getContentPane().add(lblNewLabel_8);
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(800,755);
		setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisibile(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
