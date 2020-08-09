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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;

public class test extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
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
	public test() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setResizable(false);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 796, 772);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select * FROM tests ");
					table.setModel(DbUtils.resultSetToTableModel(rs));
}
				catch(Exception excep) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
		});
		btnNewButton.setBounds(283, 33, 193, 39);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 109, 513, 573);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(257, 707, 146, 39);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("REMOVE");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(445, 707, 146, 39);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 796, 762);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel);
	}

}