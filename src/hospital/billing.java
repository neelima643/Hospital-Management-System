package hospital;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.*;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class billing {

	private JFrame frame;
	private JTextField medname;
	private JTextField amount;
	private JTable table;
	private JButton BILL;
	private JLabel tot;
	private JTextField tamt;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	//private float a[];
	//private int i=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing window = new billing();
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
	public billing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 464);
				frame.getContentPane().setLayout(null);
		
		JLabel Med_Name = new JLabel("Med_Name:");
		Med_Name.setForeground(SystemColor.text);
		Med_Name.setBackground(Color.BLACK);
		Med_Name.setBounds(10, 129, 111, 27);
		Med_Name.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(Med_Name);
		
		JLabel amt = new JLabel("Quantity:");
		amt.setForeground(SystemColor.text);
		amt.setBounds(10, 189, 94, 27);
		amt.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(amt);
		
		medname = new JTextField();
		medname.setFont(new Font("Arial", Font.BOLD, 18));
		medname.setBounds(131, 131, 148, 27);
		frame.getContentPane().add(medname);
		medname.setColumns(10);
		
		amount = new JTextField();
		amount.setFont(new Font("Arial", Font.BOLD, 18));
		amount.setBounds(131, 191, 148, 27);
		frame.getContentPane().add(amount);
		amount.setColumns(10);
		 
		 
		JButton ADD = new JButton("ADD");
		ADD.setBounds(39, 318, 100, 38);
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String med=medname.getText();
				int num=Integer.parseInt(amount.getText());
				float sum=0;
				String q;
				int p;
				
				//String med=search.getText();
				
				//String user=username.getText();
				  if (medname.getText().equals("")) {

					JOptionPane.showMessageDialog(null,"Fill name of medicine to be searched");}
				else{
					medname.setText(null);
					amount.setText(null);
					try{
						Connection con = dbconnection.getCon();
						Statement stmnt = con.createStatement();
						Statement billUpStmnt = con.createStatement();
						ResultSet rs = stmnt.executeQuery("select *from medicine where name='"+med+"'");
						//int count=rs.();
						if (!rs.isBeforeFirst() ) {    
							JOptionPane.showMessageDialog(null, "medicine not available"); 
						} 
						while (rs.next()){
							p=Integer.parseInt(rs.getString("stock"));
							q=rs.getString("price");
							System.out.println(q);
							sum=num*Float.parseFloat(q);
							if(p==0){
								JOptionPane.showMessageDialog(null, "medicine not available");}
							else if(p<num){
								JOptionPane.showMessageDialog(null, "less stock");}
							else{
								 billUpStmnt.executeUpdate("insert into bill(name,qty,price,total) VALUES('"+med+"', '"+num+"', '"+q+"', '"+sum+"')");}
						}
						
						
						//System.out.println(count);
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
						
						//if(count==0){
						//	JOptionPane.showMessageDialog(null, "medicine not available or entered wrong medicine");}
								

						//table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
						
					
						
						catch(Exception e) {
							
							System.out.println(e);}
						
					
				}
				
				
				//String user=username.getText();
				 
			}
		});
		ADD.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(ADD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(297, 84, 298, 164);
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
		
		BILL = new JButton("BILL");
		BILL.setBounds(167, 318, 100, 38);
		BILL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
		
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					Statement medUpStmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from bill");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					ResultSet r= stmnt.executeQuery("select SUM(total) from bill");
					if( r.next()){
					String total=r.getString("SUM(total)");
					tamt.setText(total);
					ResultSet s = stmnt.executeQuery("select b.name as name,m.stock as stock,b.qty as qty from bill b JOIN medicine m  where b.name = m.name");
					while (s.next()){
						String e=s.getString("name");
						int d=Integer.parseInt(s.getString("stock"));
						int o=Integer.parseInt(s.getString("qty"));
						int k=d-o;
						System.out.println(e);
						medUpStmnt .executeUpdate("update medicine set stock='"+k+"' where name='"+e+"'");
						//s.next();
					}				
					//ResultSet s = stmnt.executeQuery("delete from bill");
					}
						
					
					
					
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				}
				
				catch(Exception excep) {
					
					System.out.println(excep);;
				}

			}	
		});
		BILL.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(BILL);
		
		tot = new JLabel("TOTAL:");
		tot.setForeground(SystemColor.text);
		tot.setBounds(333, 324, 79, 27);
		tot.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(tot);
		
		tamt = new JTextField();
		tamt.setFont(new Font("Arial", Font.BOLD, 18));
		tamt.setBounds(445, 326, 136, 27);
		frame.getContentPane().add(tamt);
		tamt.setColumns(10);
		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(frame, 
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        		try {
						
						
						Connection con = dbconnection.getCon();
						Statement stmnt = con.createStatement();
						 stmnt.executeUpdate("delete from bill");}
					catch(Exception excep) {
						
						System.out.println(excep);;
					}
		        		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		            //System.exit(0);
		        }
		        else
        		{frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);}

		    }
		});
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 619, 434);
		frame.getContentPane().add(lblNewLabel);
		Image img2 = new ImageIcon(this.getClass().getResource("/img5.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img2));
	}
}