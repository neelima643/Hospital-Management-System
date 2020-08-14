package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class appoinmentdoctor extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appoinmentdoctor window = new appoinmentdoctor();
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
	public appoinmentdoctor() {
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
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(259, 95, 308, 24);
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(dateChooser);
		dateChooser.setVisible(false);
		

		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(259, 206, 308, 28);
		getContentPane().add(comboBox_1);
		comboBox_1.setVisible(false);





		


		
		JLabel lblNewLabel_3 = new JLabel("Doctor:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(101, 208, 128, 24);
		getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		

		

		


		

		

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 287, 750, 293);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		Image img7 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img7));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		
	    DefaultComboBoxModel gen = new DefaultComboBoxModel(new String[] {"Dr. Divya K, MBBS, MD", "Dr.Joseph K, MBBS, MS", "Dr. Amina S, MBBS, MS"});
		DefaultComboBoxModel pea = new DefaultComboBoxModel(new String[] {"Dr.Sam K, MBBS,MD", "Dr.Devi R, MBBS ,MS"});
		DefaultComboBoxModel neu = new DefaultComboBoxModel(new String[] {"Dr.Reena M, MBBS, MS", "Dr. Chandran K, MBBS,MS"});
		DefaultComboBoxModel car = new DefaultComboBoxModel(new String[] {"Dr.Lakshmi S, MBBS,MD", "Dr.Ganesh R, MBBS,MS"});
		DefaultComboBoxModel ort = new DefaultComboBoxModel(new String[] {"Dr.Soumya N, MBBS, MS", "Dr. Fathima P, MBBS, MS"});
		DefaultComboBoxModel gyn = new DefaultComboBoxModel(new String[] {"Dr.Meena P, MBBS, MS", "Dr. Leena V, MBBS,MS"});
		DefaultComboBoxModel nep = new DefaultComboBoxModel(new String[] {"Dr.Thomas A, MBBS, MD", "Dr. Paul G, MBBS,MD"})	;
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
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
		comboBox.setBounds(259, 153, 308, 24);
		getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"General Medicine", "Paediatrics", "Neurology", "Cardiology", "Orthopaedics", "Gynaecology", "Nephrology"}));
		comboBox.setVisible(false);
		
		JButton btnNewButton_5 = new JButton("LOAD");
		Image img4 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton_5.setIcon(new ImageIcon (img4));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
				String date = d.format(dateChooser.getDate());
				String specialization = comboBox.getSelectedItem().toString();
				String doctor = comboBox_1.getSelectedItem().toString();
				
				
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select *from appoinment where date = '"+date+"' && department = '"+specialization+"' && doctor = '"+doctor+"'");
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				}
				
				catch(Exception e8) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured. Retry again!");
				
				}
			}
		});
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_5.setBounds(615, 95, 128, 34);
		getContentPane().add(btnNewButton_5);
		btnNewButton_5.setVisible(false);
		
		
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(478, 591, 136, 50);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_6 = new JButton("LOAD");
		Image img5 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon (img5));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
				String date = d.format(dateChooser.getDate());
				String specialization = comboBox.getSelectedItem().toString();
				String doctor = comboBox_1.getSelectedItem().toString();
				
				
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select *from appoinment where date >= '"+date+"' && department = '"+specialization+"' && doctor = '"+doctor+"'");
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				}
				
				catch(Exception e8) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured. Retry again!");
				
				}
			}				
				
			
		});
		

		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_6.setBounds(615, 170, 128, 34);
		getContentPane().add(btnNewButton_6);
		btnNewButton_6.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(101, 95, 105, 24);
		getContentPane().add(lblNewLabel);
	    lblNewLabel.setVisible(false);
	    
		JLabel lblNewLabel_2 = new JLabel("Specialization:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(101, 151, 141, 28);
		getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton_4 = new JButton("OK");
		Image img6 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon (img6));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new appoinmentdoctor().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_4.setBounds(236, 591, 141, 50);
		getContentPane().add(btnNewButton_4);
		
		
		JButton btnNewButton_3 = new JButton("Future appoinments");
		Image img3 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img3));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setVisible(true);
				dateChooser.setVisible(true);
				lblNewLabel_2.setVisible(true);
				comboBox.setVisible(true);
				lblNewLabel_3.setVisible(true);
				comboBox_1.setVisible(true);
				btnNewButton_6.setVisible(true);
				
			}
		});
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(496, 12, 250, 39);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setVisible(false);

		
		JButton btnNewButton_1 = new JButton("View by date");
		Image img2 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setVisible(true);
				dateChooser.setVisible(true);
				lblNewLabel_2.setVisible(true);
				comboBox.setVisible(true);
				lblNewLabel_3.setVisible(true);
				comboBox_1.setVisible(true);
				btnNewButton_5.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(283, 10, 173, 42);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		JButton btnNewButton = new JButton("View appoinments");
		Image img1 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img1));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				
				btnNewButton_1.setVisible(true);
				btnNewButton_3.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(18, 10, 242, 42);
		getContentPane().add(btnNewButton);
		


	    
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/ecg1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 796, 672);
		getContentPane().add(lblNewLabel_1);
		


		
		

		

	}
}
