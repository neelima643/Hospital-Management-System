package hospital;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;


import javax.swing.ImageIcon;
import javax.swing.JFrame ;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.ListSelectionModel;

public class availability {

	private JFrame frame;
	private JTextField search;
	private JTable table;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					availability window = new availability();
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
	public availability() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 416);
		
		Image img1 = new ImageIcon(this.getClass().getResource("/img5.jpg")).getImage();
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.setBounds(31, 39, 157, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from medicine");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				}
				
				catch(Exception excep) {
					
					JOptionPane.showMessageDialog(null, "Some error occured.");
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setBounds(218, 39, 134, 35);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String med=search.getText();
				
				//String user=username.getText();
				  if (search.getText().equals("")) {

					JOptionPane.showMessageDialog(null,"Fill name of medicine to be searched");}
				else{
					search.setText(null);
					try{
						Connection con = dbconnection.getCon();
						Statement stmnt = con.createStatement();
						ResultSet rs = stmnt.executeQuery("select *from medicine where name='"+med+"'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						int count=table.getRowCount();	
						System.out.println(count);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
						
						if(count==0){
							JOptionPane.showMessageDialog(null, "medicine not available");}
								
					}
						
					
						
						catch(Exception e) {
							
							System.out.println(e);}
						
					
				}
			}
			});
				 
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton_1);
		
		search = new JTextField();
		search.setFont(new Font("Arial", Font.BOLD, 18));
		search.setBounds(377, 41, 176, 35);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 114, 421, 179);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { 
			}
		));
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 597, 377);
		frame.getContentPane().add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/img5.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img2));
		
		
		//getContentPane().add(lblNewLabel);
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
	
		
		
	
		//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		}	
}
