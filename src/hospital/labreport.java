package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import database.dbconnection;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class labreport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labreport frame = new labreport();
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
	public labreport() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(0, 0, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 796, 762);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(273, 41, 210, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(57, 41, 170, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAB REPORT");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(300, 124, 164, 35);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(31, 172, 731, 549);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT NAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(55, 52, 138, 34);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(241, 52, 216, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p=textField.getText().toString();
				try
				{
				Connection con=dbconnection.getCon();
				Statement stmnt=con.createStatement();
			     ResultSet rs = stmnt.executeQuery("Select name from testentry where patientID ='"+p+"'  ");
				
				while(rs.next())
				{
					textField_1.setText(rs.getString("name"));
				}
				ResultSet set = stmnt.executeQuery("select testentry.testtype,testentry.testdate, testentry.department,resultentry.resultdate,resultentry.component,resultentry.unit from resultentry,testentry where resultentry.patientID=testentry.patientID and testentry.patientID='"+p+"' ");
					table.setModel(DbUtils.resultSetToTableModel(set));

				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(523, 37, 184, 41);
		panel.add(btnNewButton);
		
		
		table = new JTable();
		table.setBounds(0, 114, 731, 435);
		panel_1.add(table);
		
		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBounds(540, 727, 192, 35);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 796, 762);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel_3);
	}
}