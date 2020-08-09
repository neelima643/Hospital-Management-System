package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import com.toedter.calendar.JDateChooser;

import database.dbconnection;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class update {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_9;
	//private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update window = new update();
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
	public update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEDICINE UPDATE DETAILS");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(40, 22, 363, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("      M_ID:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_1.setBounds(10, 113, 90, 23);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("      NAME:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(10, 168, 90, 23);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("     PRICE:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setBounds(10, 222, 90, 23);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("     STOCK:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBounds(10, 281, 106, 23);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("   P_DATE:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setBounds(10, 338, 106, 23);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(126, 106, 179, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 169, 179, 30);
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 223, 179, 30);
		textField_2.setColumns(10);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(126, 282, 179, 30);
		textField_3.setColumns(10);
		frame.getContentPane().add(textField_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(126, 341, 179, 30);
		frame.getContentPane().add(dateChooser);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				String name=textField_1.getText();
				String price=textField_2.getText();
				String stock=textField_3.getText();
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
					try{
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					
					ResultSet rs=stmnt.executeQuery("SELECT* from medicine WHERE m_id='"+id+"' ");
					
					if(rs.next()!=false){

						do{
						int s=rs.getInt("stock");
						System.out.println(s);
						int a=0;
						a=Integer.valueOf(stock);
						s=a+s;
						String b;
						b=String.valueOf(s);
						stmnt.executeUpdate("update medicine set price='"+price+"', stock='"+b+"', p_date='"+date+"' WHERE m_id='"+id+"'");
						}while(rs.next());
						
						
					}
					else{
						stmnt.executeUpdate("insert into medicine values('"+id+"', '"+name+"', '"+price+"', '"+stock+"', '"+date+"')");
						JOptionPane.showMessageDialog(null, "medicine information is added successfully.");
					}
			}
				catch(Exception e) {
					
					System.out.println(e);}
			}
		});
		btnNewButton.setBounds(126, 395, 131, 30);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(btnNewButton);
		
		
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
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 469, 448);
		frame.getContentPane().add(lblNewLabel_6);Image img2 = new ImageIcon(this.getClass().getResource("/img6.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon (img2));
	}
}