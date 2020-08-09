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
import java.util.Date;

public class addconsultation extends JFrame {

	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
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
		
		JButton btnNewButton_3 = new JButton("Get Time");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			       DateFormat df = new SimpleDateFormat("HH:mm:ss");
			       Date dateobj = new Date();
			       textField_4.setText(df.format(dateobj));
			       
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(595, 208, 114, 21);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(59, 278, 114, 34);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Specialization:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(59, 234, 144, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Patient ID:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(72, 25, 114, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Disease:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(59, 322, 114, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Medicines:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(59, 366, 114, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Other tests(if any):");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(59, 435, 171, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Need to be admited or not:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(62, 501, 251, 34);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ICU/Ward(Type)");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_7.setBounds(59, 545, 144, 34);
		getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(235, 29, 309, 25);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setBounds(309, 322, 400, 34);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_6.setBounds(309, 378, 400, 47);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_7.setBounds(309, 438, 400, 34);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ICU", "General Ward", "Pay Ward"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(309, 549, 400, 27);
		getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(309, 156, 400, 25);
		getContentPane().add(dateChooser);
		
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
		rdbtnNewRadioButton.setBounds(309, 508, 160, 21);
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
		rdbtnNewRadioButton_1.setBounds(557, 508, 152, 21);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 79, 645, 47);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setRowHeight(table.getRowHeight() + 20);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		
		JButton btnNewButton_2 = new JButton("SEARCH");
		Image img3 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img3));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientID = Integer.parseInt(textField_3.getText());
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select *from addpatient where patientID='"+patientID+"'");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
		btnNewButton_2.setBounds(573, 25, 136, 30);
		getContentPane().add(btnNewButton_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(309, 283, 400, 25);
		getContentPane().add(comboBox_1);
		
		
		JComboBox comboBox_2 = new JComboBox();
		
	    DefaultComboBoxModel gen = new DefaultComboBoxModel(new String[] {"Dr. Divya K, MBBS, MD", "Dr.Joseph K, MBBS, MS", "Dr. Amina S, MBBS, MS"});
		DefaultComboBoxModel pea = new DefaultComboBoxModel(new String[] {"Dr.Sam K, MBBS,MD", "Dr.Devi R, MBBS ,MS"});
		DefaultComboBoxModel neu = new DefaultComboBoxModel(new String[] {"Dr.Reena M, MBBS, MS", "Dr. Chandran K, MBBS,MS"});
		DefaultComboBoxModel car = new DefaultComboBoxModel(new String[] {"Dr.Lakshmi S, MBBS,MD", "Dr.Ganesh R, MBBS,MS"});
		DefaultComboBoxModel ort = new DefaultComboBoxModel(new String[] {"Dr.Soumya N, MBBS, MS", "Dr. Fathima P, MBBS, MS"});
		DefaultComboBoxModel gyn = new DefaultComboBoxModel(new String[] {"Dr.Meena P, MBBS, MS", "Dr. Leena V, MBBS,MS"});
		DefaultComboBoxModel nep = new DefaultComboBoxModel(new String[] {"Dr.Thomas A, MBBS, MD", "Dr. Paul G, MBBS,MD"})	;
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if("General Medicine".equals(comboBox_2.getSelectedItem())) {
					
					comboBox_1.setModel(gen);
					
				}
				
				else if("Paediatrics".equals(comboBox_2.getSelectedItem())) {
					
					comboBox_1.setModel(pea);
					
				}
				
				else if("Neurology".equals(comboBox_2.getSelectedItem())) {
				
					comboBox_1.setModel(neu);
					
				}
				
				else if("Cardiology".equals(comboBox_2.getSelectedItem())) {
					
					comboBox_1.setModel(car);
					
				}
				
				else if("Orthopaedics".equals(comboBox_2.getSelectedItem())) {
					
					comboBox_1.setModel(ort);
					
				}
				
				else if("Gynaecology".equals(comboBox_2.getSelectedItem())) {
					
					comboBox_1.setModel(gyn);
					
				}
				
				else {
					
					comboBox_1.setModel(nep);
					
				}
		
			}
				
			
		});
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"General Medicine", "Paediatrics", "Neurology", "Cardiology", "Orthopaedics", "Gynaecology", "Nephrology"}));
		comboBox_2.setBounds(309, 239, 400, 25);
		getContentPane().add(comboBox_2);
		
		
		JButton btnNewButton = new JButton("ADD");
		Image img1 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientID = Integer.parseInt(textField_3.getText());
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				String time = textField_4.getText();
				String doctor = (String)comboBox_1.getSelectedItem();
				String specialization = (String)comboBox_2.getSelectedItem();
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
		btnNewButton.setBounds(203, 608, 136, 38);
		getContentPane().add(btnNewButton);
		initialize();
		
		JButton btnNewButton_1 = new JButton("EXIT");
		Image img = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(408, 607, 136, 41);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Date:");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(59, 156, 102, 21);
		getContentPane().add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setBounds(309, 204, 215, 25);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
	
		
		JLabel lblNewLabel_10 = new JLabel("Time:");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10.setBounds(59, 195, 107, 21);
		getContentPane().add(lblNewLabel_10);
		
		
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img2 = new ImageIcon(this.getClass().getResource("/pwi.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img2));
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
