package hospital;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import java.sql.*;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class patienthistory extends JFrame{

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patienthistory window = new patienthistory();
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
	public patienthistory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(800,700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_1 = new JButton("Load the patient history");
		Image img2 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select *from addpatient inner join addconsultationinfo where addpatient.patientid=addconsultationinfo.patientID ");
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				}
				
				catch(Exception excep) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("VIEW");
		Image img3 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img3));
		btnNewButton_3.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				int patientID = Integer.parseInt(textField.getText());
				
				try {
					
				
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery("select addpatient.patientID, addpatient.name, addpatient.gender, addpatient.age, addpatient.contactno, addpatient.address, "
							+   " addpatient.bloodgroup, addconsultationinfo.doctor, addconsultationinfo.specialization, addconsultationinfo.disease, addconsultationinfo.medicines, "
							+ "addconsultationinfo.test, addconsultationinfo.admit, addconsultationinfo.icuward, addconsultationinfo.time, addconsultationinfo.date from addpatient "
							+ "inner join addconsultationinfo where addpatient.patientID=addconsultationinfo.patientID && addpatient.patientID = '"+patientID+"'" );
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					
				}
				
				catch(Exception e5) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured. Retry again!");
					
				}
			
			}
			
		}); 
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(539, 118, 110, 28);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(297, 119, 152, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		
		JLabel lblNewLabel_1 = new JLabel("PatientID:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(113, 118, 162, 28);
		getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		JButton btnNewButton_2 = new JButton("Patient history of an individual");
		Image img4 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_1.setVisible(true);
				textField.setVisible(true);
				btnNewButton_3.setVisible(true);
				
				}
		});
		
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(433, 27, 335, 47);
		getContentPane().add(btnNewButton_2);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton_1.setBounds(26, 27, 298, 47);
		getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("EXIT");
		Image img5 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img5));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnNewButton.setBounds(318, 598, 131, 44);
		getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 197, 743, 366);
		getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.setBackground(new Color(255, 255, 255));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { 
			}
		));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(0, 0, 796, 672);
		Image img1 = new ImageIcon(this.getClass().getResource("/pwi.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		getContentPane().add(lblNewLabel);
		
		
		
		
		
	}
}
