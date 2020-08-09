package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class labrecords extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labrecords frame = new labrecords();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public labrecords() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 786, 763);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select testentry.patientID,testentry.name,testentry.testtype,testentry.testdate,resultentry.resultdate from resultentry inner join testentry on resultentry.patientID=testentry.patientID ");
					table.setModel(DbUtils.resultSetToTableModel(rs));
}
				catch(Exception excep) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(72, 22, 183, 37);
		panel.add(btnNewButton);
		
		JButton btnadd = new JButton("EDIT");
		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnadd.setBounds(525, 20, 177, 37);
		panel.add(btnadd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 91, 736, 650);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 786, 781);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel);
	
	}
}