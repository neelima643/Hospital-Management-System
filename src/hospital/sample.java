package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import database.dbconnection;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sample extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample window = new sample();
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
	public sample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(33, 102, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = comboBox.getSelectedItem().toString();
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select two from sample where one='"+s+"'");
					
					
						
						while (rs.next()){
							
							textField.setText(rs.getString("two")); 
							
					       }
					
				
			}
				catch(Exception e2) {
					
				}
			}
		});
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"a","b"}));
		comboBox.setBounds(33, 37, 201, 21);
		frame.getContentPane().add(comboBox);

	}
}
