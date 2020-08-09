package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import database.dbconnection;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.toedter.calendar.JDateChooser;
import java.awt.SystemColor;

public class appoinment extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appoinment window = new appoinment();
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
	public appoinment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(800,700);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PatientID:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 30, 194, 26);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(256, 30, 310, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		Image img2 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientID = textField.getText();
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement() ;
					ResultSet rs = stmnt.executeQuery("select *from addpatient where patientID='"+patientID+"'");
					while(rs.next()) {
						
						textField_1.setText(rs.getString("name"));
						textField_2.setText(rs.getString("gender"));
						textField_7.setText(rs.getString("age"));
						textField_3.setText(rs.getString("address"));
						textField_6.setText(rs.getString("contactno"));
						textField_4.setText(rs.getString("bloodgroup"));
						
					}
					
					
				}
				catch (Exception ea) {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patientid!");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(601, 26, 140, 34);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(51, 92, 94, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(256, 89, 485, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Gender:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(51, 147, 94, 20);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setBounds(256, 144, 165, 26);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(472, 147, 94, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(52, 378, 118, 20);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(51, 208, 94, 20);
		getContentPane().add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(256, 205, 485, 26);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contact no.:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(52, 273, 139, 20);
		getContentPane().add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setBounds(256, 320, 477, 26);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Blood Group:");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_7.setBounds(52, 323, 139, 20);
		getContentPane().add(lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_6.setBounds(256, 270, 477, 26);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_7.setBounds(576, 144, 165, 26);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Department:");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_9.setBounds(52, 440, 139, 26);
		getContentPane().add(lblNewLabel_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 18));
		
		comboBox_2.setBounds(255, 553, 478, 26);
		getContentPane().add(comboBox_2);
		
		DefaultComboBoxModel first = new DefaultComboBoxModel(new String[] {"9-9.30", "9.30-10", "10-10.30", "10.30-11", "11-11.30", "11.30-12"});
		DefaultComboBoxModel second = new DefaultComboBoxModel(new String[] {"2-2.30", "2.30-3", "3-3.30", "3.30-4.", "4-4.30", "4.30-5"});
		DefaultComboBoxModel third = new DefaultComboBoxModel(new String[] {"9-9.30", "9.30-10", "10-10.30", "10.30-11", "11-11.30", "11.30-12", "2-2.30", "2.30-3", "3-3.30", "3.30-4.", "4-4.30", "4.30-5" });
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("Dr. Divya K, MBBS, MD".equals(comboBox_1.getSelectedItem()) || "Dr.Sam K, MBBS,MD".equals(comboBox_1.getSelectedItem()) || "Dr.Reena M, MBBS, MS".equals(comboBox_1.getSelectedItem()) || "Dr.Lakshmi S, MBBS,MD".equals(comboBox_1.getSelectedItem())
						|| "Dr.Soumya N, MBBS, MS".equals(comboBox_1.getSelectedItem()) || "Dr.Meena P, MBBS, MS".equals(comboBox_1.getSelectedItem()) || "Dr.Thomas A, MBBS, MD".equals(comboBox_1.getSelectedItem())) {
					
					comboBox_2.setModel(first);
					
				}
				
				else if("Dr.Joseph K, MBBS, MS".equals(comboBox_1.getSelectedItem()) || "Dr.Devi R, MBBS ,MS".equals(comboBox_1.getSelectedItem()) || "Dr. Chandran K, MBBS,MS".equals(comboBox_1.getSelectedItem()) || "Dr.Ganesh R, MBBS,MS".equals(comboBox_1.getSelectedItem())
						|| "Dr. Fathima P, MBBS, MS".equals(comboBox_1.getSelectedItem()) || "Dr. Leena V, MBBS,MS".equals(comboBox_1.getSelectedItem()) || "Dr.Thomas A, MBBS, MD".equals(comboBox_1.getSelectedItem())) {
					
					comboBox_2.setModel(second);
					
				}
				
				else {
					
					comboBox_2.setModel(third);
				}
				
			}
		});
		
	    DefaultComboBoxModel gen = new DefaultComboBoxModel(new String[] {"Dr. Divya K, MBBS, MD", "Dr.Joseph K, MBBS, MS", "Dr. Amina S, MBBS, MS"});
		DefaultComboBoxModel pea = new DefaultComboBoxModel(new String[] {"Dr.Sam K, MBBS,MD", "Dr.Devi R, MBBS ,MS"});
		DefaultComboBoxModel neu = new DefaultComboBoxModel(new String[] {"Dr.Reena M, MBBS, MS", "Dr. Chandran K, MBBS,MS"});
		DefaultComboBoxModel car = new DefaultComboBoxModel(new String[] {"Dr.Lakshmi S, MBBS,MD", "Dr.Ganesh R, MBBS,MS"});
		DefaultComboBoxModel ort = new DefaultComboBoxModel(new String[] {"Dr.Soumya N, MBBS, MS", "Dr. Fathima P, MBBS, MS"});
		DefaultComboBoxModel gyn = new DefaultComboBoxModel(new String[] {"Dr.Meena P, MBBS, MS", "Dr. Leena V, MBBS,MS"});
		DefaultComboBoxModel nep = new DefaultComboBoxModel(new String[] {"Dr.Thomas A, MBBS, MD", "Dr. Paul G, MBBS,MD"})	;
		
		
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		
		comboBox_1.setBounds(256, 501, 477, 26);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_11 = new JLabel("Time Slot");
		lblNewLabel_11.setForeground(SystemColor.text);
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_11.setBounds(52, 556, 94, 20);
		getContentPane().add(lblNewLabel_11);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("General Medicine".equals(comboBox.getSelectedItem())) {
					
					comboBox_1.setModel(gen);
					
				}
				
				else if("Paediatrics".equals(comboBox.getSelectedItem())) {
					
					comboBox_1.setModel(pea);
					
				}
				
				else if("Neurology".equals(comboBox.getSelectedItem())) {
				
					comboBox_1.setModel(neu);
					
				}
				
				else if("Cardiology".equals(comboBox.getSelectedItem())) {
					
					comboBox_1.setModel(car);
					
				}
				
				else if("Orthopaedics".equals(comboBox.getSelectedItem())) {
					
					comboBox_1.setModel(ort);
					
				}
				
				else if("Gynaecology".equals(comboBox.getSelectedItem())) {
					
					comboBox_1.setModel(gyn);
					
				}
				
				else {
					
					comboBox_1.setModel(nep);
					
				}
		
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"General Medicine", "Paediatrics", "Neurology", "Cardiology", "Orthopaedics", "Gynaecology", "Nephrology"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(256, 440, 477, 26);
		getContentPane().add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(256, 378, 477, 26);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_10 = new JLabel("Doctor:");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_10.setBounds(52, 504, 94, 20);
		getContentPane().add(lblNewLabel_10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		
		JButton btnNewButton_1 = new JButton("BOOK");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientID = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String gender = textField_2.getText();
				int age = Integer.parseInt( textField_7.getText());
				String address = textField_3.getText();
				String contactno = textField_6.getText();
				String bloodgroup = textField_4.getText();
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				String department = (String)comboBox.getSelectedItem();
				String doctor = (String)comboBox_1.getSelectedItem();
				String time = (String)comboBox_2.getSelectedItem();
				int c = 1;
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet r = stmnt.executeQuery("select count(*) from appoinment where date = '"+date+"' && time = '"+time+"' && department = '"+department+"' && doctor = '"+doctor+"'");
					while(r.next()) {
						
						c = r.getInt("count(*)");
						
					}
					int a = 3-c;
					JOptionPane.showMessageDialog(rootPane, "Only " + a + " slots more!");
					if(c <=3) {
					stmnt.executeUpdate("insert into appoinment values('"+patientID+"', '"+date+"', '"+time+"', '"+name+"', '"+gender+"', '"+age+"', '"+address+"', '"+contactno+"','"+bloodgroup+"', '"+department+"', '"+doctor+"')");
					
					JOptionPane.showMessageDialog(rootPane, "Booking is successfull");
					}
					else {
						
						JOptionPane.showMessageDialog(rootPane, "This slot is not available");
					}
					setVisible(false);
					new appoinment().setVisible(true);
					
				}

				catch(Exception exce) {
					
					JOptionPane.showMessageDialog(rootPane, "Information is not entered in the correct format");
					
				}
				
				}
				


			
		});
		Image img3 = new ImageIcon(this.getClass().getResource("/up.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(291, 603, 140, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		Image img4 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(483, 603, 118, 40);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/ecg1.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img1));
		lblNewLabel_8.setBounds(0, 0, 796, 672);
		getContentPane().add(lblNewLabel_8);
		

		
		
	}
}
