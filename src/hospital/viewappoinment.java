package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
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

public class viewappoinment extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewappoinment window = new viewappoinment();
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
	public viewappoinment() {
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
		
		JButton btnNewButton_4 = new JButton("OK");
		Image img4 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon (img4));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new viewappoinment().setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_4.setBounds(236, 591, 141, 50);
		getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(216, 94, 105, 24);
		getContentPane().add(lblNewLabel);
	    lblNewLabel.setVisible(false);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(365, 94, 168, 24);
		getContentPane().add(dateChooser);
		dateChooser.setVisible(false);
		
		JButton btnNewButton_3 = new JButton("VIEW");
		Image img3 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img3));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dft = new SimpleDateFormat("dd-MM-yyyy");
				String d = dft.format(dateChooser.getDate());
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from appoinment where date = '"+d+"' order by patientID");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
				}
				
				catch(Exception e4) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.Retry again!");
					
				}
			}
		});
		btnNewButton_3.setBackground(SystemColor.control);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(303, 148, 136, 36);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setVisible(false);

		
		JButton btnNewButton = new JButton("View By Date ");
		Image img1 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img1));
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setVisible(true);
				dateChooser.setVisible(true);
				btnNewButton_3.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(18, 10, 206, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View ");
		Image img2 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from appoinment order by date");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
				}
				
				catch(Exception e3) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured. Retry again!");
					
				}
				
			}
		});
		btnNewButton_1.setBounds(594, 10, 173, 42);
		getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 194, 750, 362);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		Image img5 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img5));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				
			}
		});
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(478, 591, 136, 50);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/ecg1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 796, 672);
		getContentPane().add(lblNewLabel_1);
		
		

		

	}
}
