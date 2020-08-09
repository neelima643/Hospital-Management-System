package hospital;

import java.awt.EventQueue;
import hospital.availability;

import javax.swing.JFrame;
import javax.swing.JPanel;
import hospital.update;


import hospital.billing;
import database.dbconnection;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class medicine {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					
					medicine window = new medicine();
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
	public medicine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1368, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 650);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("AVALABILITY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				availability available=new availability();
				availability.main(null);
			}
		});
		btnNewButton.setBounds(75, 208, 211, 57);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update bil=new update();
				update.main(null);
				
			}
		});
		btnNewButton_1.setBounds(75, 306, 211, 50);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BILLING");
		btnNewButton_2.setBounds(75, 395, 211, 45);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				billing bil=new billing();
				billing.main(null);
				
			}
		});
		panel.add(btnNewButton_2);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        				        		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);}
		        				        		else
		        				        		{frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);}

		            //System.exit(0);
		        
		    }
		});
	
		
		
		JLabel lblNewLabel = new JLabel(" MEDICAL STORE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setBounds(322, 28, 583, 92);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 0, 2021, 853);
		Image img1 = new ImageIcon(this.getClass().getResource("/aaa_1900x1000.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel_2);
		
		
	}
}