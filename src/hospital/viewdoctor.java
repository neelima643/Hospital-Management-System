package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;

import database.dbconnection;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;



public class viewdoctor extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewdoctor window = new viewdoctor();
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
	public viewdoctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter the date:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(115, 115, 180, 30);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(330, 115, 164, 30);
		getContentPane().add(dateChooser);
		dateChooser.setVisible(false);

		JButton btnNewButton_2 = new JButton("VIEW");
		Image img3 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img3));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SimpleDateFormat dft = new SimpleDateFormat("dd-MM-yyyy");
				String d = dft.format(dateChooser.getDate());
				
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from doctor inner join dview where doctor.doctorid = dview.doctorid and date = '"+d+"' ");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
					
				}
				
				catch(Exception e1) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
					
				}
			
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_2.setBounds(602, 116, 119, 29);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.setVisible(false);
		
		JButton btnNewButton = new JButton("LOAD");
		Image img1 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img1));
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from doctor inner join dview where doctor.doctorid = dview.doctorid");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
					
				}
				
				catch(Exception e1) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(49, 30, 185, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOAD BY DATE");
		Image img2 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_1.setVisible(true);
				dateChooser.setVisible(true);
				btnNewButton_2.setVisible(true);
				
				

			}	
			
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBounds(511, 27, 233, 49);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("OK");
		Image img4 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img4));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new viewdoctor().setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_3.setBounds(356, 592, 119, 36);
		getContentPane().add(btnNewButton_3);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 208, 543, 350);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/doctorsteth.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img));
		lblNewLabel.setBounds(-32, 0, 828, 672);
		getContentPane().add(lblNewLabel);
		

		
		
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
