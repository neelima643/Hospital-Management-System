package hospital;

import java.awt.EventQueue;
import java.awt.Image;
import database.dbconnection;
import java.sql.*;

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

public class addpatient extends JFrame {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addpatient window = new addpatient();
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
	public addpatient() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(119, 63, 114, 34);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_3.setBounds(119, 129, 114, 34);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(119, 219, 114, 34);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact no.:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_5.setBounds(119, 276, 114, 34);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Address:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(119, 350, 114, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_6.setBounds(119, 464, 128, 34);
		getContentPane().add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(371, 72, 290, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(371, 216, 290, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setBounds(371, 285, 290, 25);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setBounds(371, 350, 290, 71);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_6.setBounds(371, 473, 290, 25);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(371, 136, 290, 27);
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		Image img2 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = textField_1.getText();
				String gender = (String)comboBox.getSelectedItem();
				int age = Integer.parseInt(textField_3.getText());
				String contactno = textField_4.getText();
				String address = textField_5.getText();
				String bloodgroup = textField_6.getText();
				int p = 0;
				
			
			try {
				
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				stmnt.executeUpdate("insert into addpatient(name, gender, age, contactno, address, bloodgroup)  values('"+name+"', '"+gender+"','"+age+"', '"+contactno+"', '"+address+"', '"+bloodgroup+"')");
				JOptionPane.showMessageDialog(rootPane, "Successfully registered.");
				ResultSet rs = stmnt.executeQuery("select patientID from addpatient where name='"+name+"'");
				while(rs.next()) {
				p = rs.getInt("patientID");
				}
				JOptionPane.showMessageDialog(rootPane, "Your patientID is " + p);
				setVisible(false);
				new addpatient().setVisible(true);
				
			}
			catch(Exception ex) {
				
				JOptionPane.showMessageDialog(rootPane, "Invalid format of data. Please enter it in the correct format.");
				
			}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(229, 554, 128, 40);
		getContentPane().add(btnNewButton);
		initialize();
		
		JButton btnNewButton_1 = new JButton("EXIT");
		Image img3 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(429, 554, 128, 41);
		getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setForeground(SystemColor.window);
		Image img1 = new ImageIcon(this.getClass().getResource("/pwi.jpg")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon (img1));
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
