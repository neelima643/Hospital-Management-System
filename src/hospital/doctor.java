package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import database.dbconnection;
import java.sql.*;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class doctor extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctor window = new doctor();
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
	public doctor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		setSize(950,950);
		setResizable(false);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GENERAL MEDICINE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.control);
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 248, 23);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dr. Divya K, MBBS, MD");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.highlight"));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(65, 40, 193, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dr.Joseph K, MBBS, MS");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(67, 77, 208, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dr. Amina S, MBBS, MS");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(67, 107, 180, 21);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PAEDIATRICS");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(27, 157, 208, 27);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dr.Sam K, MBBS,MD");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5.setBounds(67, 194, 180, 18);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Dr.Devi R, MBBS ,MS");
		lblNewLabel_6.setForeground(SystemColor.text);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6.setBounds(65, 222, 168, 21);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("NEUROLOGY");
		lblNewLabel_7.setForeground(SystemColor.text);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setBounds(27, 255, 208, 21);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Dr.Reena M, MBBS, MS");
		lblNewLabel_8.setForeground(SystemColor.text);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_8.setBounds(67, 286, 208, 21);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Dr. Chandran K, MBBS,MS");
		lblNewLabel_9.setForeground(SystemColor.text);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(67, 312, 220, 18);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("CARDIOLOGY");
		lblNewLabel_10.setForeground(SystemColor.text);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_10.setBounds(27, 340, 208, 21);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Dr.Lakshmi S, MBBS,MD");
		lblNewLabel_11.setForeground(SystemColor.text);
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_11.setBounds(67, 371, 233, 21);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Dr.Ganesh R, MBBS,MS");
		lblNewLabel_12.setForeground(SystemColor.text);
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_12.setBounds(67, 402, 193, 21);
		getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("ORTHOPAEDICS");
		lblNewLabel_13.setForeground(SystemColor.text);
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_13.setBounds(27, 433, 220, 17);
		getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Dr.Soumya N, MBBS, MS");
		lblNewLabel_14.setForeground(SystemColor.text);
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_14.setBounds(67, 464, 208, 21);
		getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Dr. Paul G, MBBS,MD");
		lblNewLabel_15.setForeground(SystemColor.text);
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_15.setBounds(67, 494, 193, 21);
		getContentPane().add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("GYNAECOLOGY");
		lblNewLabel_16.setForeground(SystemColor.text);
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_16.setBounds(27, 525, 233, 24);
		getContentPane().add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Dr. Leena V, MBBS,MS");
		lblNewLabel_17.setForeground(SystemColor.text);
		lblNewLabel_17.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_17.setBounds(67, 559, 193, 21);
		getContentPane().add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Dr.Meena P, MBBS, MS");
		lblNewLabel_18.setForeground(SystemColor.text);
		lblNewLabel_18.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_18.setBounds(67, 583, 185, 21);
		getContentPane().add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("NEPHROLOGY");
		lblNewLabel_19.setForeground(SystemColor.text);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_19.setBounds(27, 630, 208, 21);
		getContentPane().add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Dr.Thomas A, MBBS, MD");
		lblNewLabel_20.setForeground(SystemColor.text);
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_20.setBounds(67, 661, 193, 21);
		getContentPane().add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Dr. Fathima P, MBBS, MS");
		lblNewLabel_21.setForeground(SystemColor.text);
		lblNewLabel_21.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_21.setBounds(67, 684, 193, 21);
		getContentPane().add(lblNewLabel_21);
		
		
		JLabel lblNewLabel_25 = new JLabel("Date:");
		lblNewLabel_25.setForeground(SystemColor.text);
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_25.setBounds(618, 740, 73, 27);
		getContentPane().add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_26.setForeground(SystemColor.text);
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_26.setBounds(327, 47, 220, 21);
		getContentPane().add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_27.setForeground(SystemColor.text);
		lblNewLabel_27.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_27.setBounds(327, 77, 220, 20);
		getContentPane().add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Mon-Fri  9pm -5pm");
		lblNewLabel_28.setForeground(SystemColor.text);
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_28.setBounds(327, 107, 220, 21);
		getContentPane().add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_29.setForeground(SystemColor.text);
		lblNewLabel_29.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_29.setBounds(327, 194, 208, 18);
		getContentPane().add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_30.setForeground(SystemColor.text);
		lblNewLabel_30.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_30.setBounds(327, 220, 220, 21);
		getContentPane().add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_31.setForeground(SystemColor.text);
		lblNewLabel_31.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_31.setBounds(327, 286, 233, 19);
		getContentPane().add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("Mon-Fri -  2pm - 5pm");
		lblNewLabel_32.setForeground(SystemColor.text);
		lblNewLabel_32.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_32.setBounds(327, 309, 233, 21);
		getContentPane().add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_33.setForeground(SystemColor.text);
		lblNewLabel_33.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_33.setBounds(327, 371, 220, 19);
		getContentPane().add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_34.setForeground(SystemColor.text);
		lblNewLabel_34.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_34.setBounds(327, 402, 220, 19);
		getContentPane().add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_35.setForeground(SystemColor.text);
		lblNewLabel_35.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_35.setBounds(327, 464, 220, 19);
		getContentPane().add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_36.setForeground(SystemColor.text);
		lblNewLabel_36.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_36.setBounds(327, 494, 220, 21);
		getContentPane().add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_37.setForeground(SystemColor.text);
		lblNewLabel_37.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_37.setBounds(327, 559, 233, 19);
		getContentPane().add(lblNewLabel_37);
		
		JLabel lblNewLabel_38 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_38.setForeground(SystemColor.text);
		lblNewLabel_38.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_38.setBounds(327, 583, 233, 19);
		getContentPane().add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("Mon-Fri  9am - 12 pm");
		lblNewLabel_39.setForeground(SystemColor.text);
		lblNewLabel_39.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_39.setBounds(327, 661, 220, 19);
		getContentPane().add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("Mon-Fri  2pm - 5pm");
		lblNewLabel_40.setForeground(SystemColor.text);
		lblNewLabel_40.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_40.setBounds(327, 684, 220, 21);
		getContentPane().add(lblNewLabel_40);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("On duty");
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(618, 47, 103, 21);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("On leave");
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_1.setBounds(795, 47, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("On duty");
		rdbtnNewRadioButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_2.setBounds(618, 78, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("On leave");
		rdbtnNewRadioButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_3.setBounds(795, 78, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("On duty");
		rdbtnNewRadioButton_4.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_4.setBounds(618, 109, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("On leave");
		rdbtnNewRadioButton_5.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_5.setBounds(795, 109, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("On duty");
		rdbtnNewRadioButton_6.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_6.setBounds(618, 195, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_6);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("On duty");
		rdbtnNewRadioButton_7.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_7.setBounds(618, 222, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_7);
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("On leave");
		rdbtnNewRadioButton_8.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_8.setBounds(795, 195, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_8);
		
		JRadioButton rdbtnNewRadioButton_9 = new JRadioButton("On leave");
		rdbtnNewRadioButton_9.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_9.setBounds(795, 222, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_9);
		
		JRadioButton rdbtnNewRadioButton_10 = new JRadioButton("On duty");
		rdbtnNewRadioButton_10.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_10.setBounds(618, 288, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_10);
		
		JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("On duty");
		rdbtnNewRadioButton_11.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_11.setBounds(618, 313, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_11);
		
		JRadioButton rdbtnNewRadioButton_12 = new JRadioButton("On leave");
		rdbtnNewRadioButton_12.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_12.setBounds(795, 288, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_12);
		
		JRadioButton rdbtnNewRadioButton_13 = new JRadioButton("On leave");
		rdbtnNewRadioButton_13.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_13.setBounds(795, 313, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_13);
		
		JRadioButton rdbtnNewRadioButton_14 = new JRadioButton("On duty");
		rdbtnNewRadioButton_14.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_14.setBounds(618, 373, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_14);
		
		JRadioButton rdbtnNewRadioButton_15 = new JRadioButton("On leave");
		rdbtnNewRadioButton_15.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_15.setBounds(618, 404, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_15);
		
		JRadioButton rdbtnNewRadioButton_16 = new JRadioButton("On leave");
		rdbtnNewRadioButton_16.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_16.setBounds(795, 373, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_16);
		
		JRadioButton rdbtnNewRadioButton_17 = new JRadioButton("On leave");
		rdbtnNewRadioButton_17.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_17.setBounds(795, 404, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_17);
		
		JRadioButton rdbtnNewRadioButton_18 = new JRadioButton("On duty");
		rdbtnNewRadioButton_18.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_18.setBounds(618, 466, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_18);
		
		JRadioButton rdbtnNewRadioButton_19 = new JRadioButton("On duty");
		rdbtnNewRadioButton_19.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_19.setBounds(618, 496, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_19);
		
		JRadioButton rdbtnNewRadioButton_20 = new JRadioButton("On leave");
		rdbtnNewRadioButton_20.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_20.setBounds(795, 466, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_20);
		
		JRadioButton rdbtnNewRadioButton_21 = new JRadioButton("On leave");
		rdbtnNewRadioButton_21.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_21.setBounds(795, 496, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_21);
		
		JRadioButton rdbtnNewRadioButton_22 = new JRadioButton("On duty");
		rdbtnNewRadioButton_22.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_22.setBounds(618, 557, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_22);
		
		JRadioButton rdbtnNewRadioButton_23 = new JRadioButton("On duty");
		rdbtnNewRadioButton_23.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_23.setBounds(618, 585, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_23);
		
		JRadioButton rdbtnNewRadioButton_24 = new JRadioButton("On leave");
		rdbtnNewRadioButton_24.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_24.setBounds(795, 557, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_24);
		
		JRadioButton rdbtnNewRadioButton_25 = new JRadioButton("On leave");
		rdbtnNewRadioButton_25.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_25.setBounds(795, 585, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_25);
		
		JRadioButton rdbtnNewRadioButton_26 = new JRadioButton("On duty");
		rdbtnNewRadioButton_26.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_26.setBounds(618, 663, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_26);
		
		JRadioButton rdbtnNewRadioButton_27 = new JRadioButton("On duty");
		rdbtnNewRadioButton_27.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_27.setBounds(618, 686, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_27);
		
		JRadioButton rdbtnNewRadioButton_28 = new JRadioButton("On leave");
		rdbtnNewRadioButton_28.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_28.setBounds(795, 661, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_28);
		
		JRadioButton rdbtnNewRadioButton_29 = new JRadioButton("On leave");
		rdbtnNewRadioButton_29.setFont(new Font("Arial", Font.BOLD, 16));
		rdbtnNewRadioButton_29.setBounds(795, 686, 103, 21);
		getContentPane().add(rdbtnNewRadioButton_29);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(711, 740, 174, 27);
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(dateChooser);

		
		JButton btnNewButton = new JButton("UPDATE");
		Image img2 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					SimpleDateFormat dtf = new SimpleDateFormat("dd-MM-yyyy");
					String date = dtf.format(dateChooser.getDate());
					
				
					String status;
					String status1;
					String status2;
					String status3;
					String status4;
					String status5;
					String status6;
					String status7;
					String status8;
					String status9;
					String status10;
					String status11;
					String status12;
					String status13;
					String status14;
					String status15;
					String status16;
					String status17;
					String status18;
					String status19;
					String status20;
					String status21;
					String status22;
					String status23;
					String status24;
					String status25;
					String status26;
					String status27;
					String status28;
					String status29;
					
					if(rdbtnNewRadioButton.isSelected()) {
						
						status = "on duty";
						
					}
					else {
						
						status = "on leave";
					}
					if(rdbtnNewRadioButton_1.isSelected()) {
						
						status1 = "on duty";
						
					}
					else {
						
						status1 = "on leave";
					}
					
					if(rdbtnNewRadioButton_2.isSelected()) {
						
						status2 = "on duty";
						
					}
					else {
						
						status2 = "on leave";
					}
					
					if(rdbtnNewRadioButton_3.isSelected()) {
						
						status3 = "on duty";
						
					}
					else {
						
						status3 = "on leave";
					}
					
					if(rdbtnNewRadioButton_4.isSelected()) {
						
						status4 = "on duty";
						
					}
					else {
						
						status4 = "on leave";
					}
					
					if(rdbtnNewRadioButton_5.isSelected()) {
						
						status5 = "on duty";
						
					}
					else {
						
						status5 = "on leave";
					}
					
					if(rdbtnNewRadioButton_6.isSelected()) {
						
						status6 = "on duty";
						
					}
					else {
						
						status6 = "on leave";
					}
					
					if(rdbtnNewRadioButton_7.isSelected()) {
						
						status7 = "on duty";
						
					}
					else {
						
						status7 = "on leave";
					}
					
					if(rdbtnNewRadioButton_8.isSelected()) {
						
						status8 = "on duty";
						
					}
					else {
						
						status8 = "on leave";
					}
					
					if(rdbtnNewRadioButton_9.isSelected()) {
						
						status9 = "on duty";
						
					}
					else {
						
						status9 = "on leave";
					}
					
					if(rdbtnNewRadioButton_10.isSelected()) {
						
						status10 = "on duty";
						
					}
					else {
						
						status10 = "on leave";
					}
					
					if(rdbtnNewRadioButton_11.isSelected()) {
						
						status11 = "on duty";
						
					}
					else {
						
						status11 = "on leave";
					}
					
					if(rdbtnNewRadioButton_12.isSelected()) {
						
						status12 = "on duty";
						
					}
					else {
						
						status12 = "on leave";
					}
					
					if(rdbtnNewRadioButton_13.isSelected()) {
						
						status13 = "on duty";
						
					}
					else {
						
						status13 = "on leave";
					}
					
					if(rdbtnNewRadioButton_14.isSelected()) {
						
						status14 = "on duty";
						
					}
					else {
						
						status14 = "on leave";
					}
					
					if(rdbtnNewRadioButton_15.isSelected()) {
						
						status15 = "on duty";
						
					}
					else {
						
						status15 = "on leave";
					}
					
					if(rdbtnNewRadioButton_16.isSelected()) {
						
						status16 = "on duty";
						
					}
					else {
						
						status16 = "on leave";
					}
					
					if(rdbtnNewRadioButton_17.isSelected()) {
						
						status17 = "on duty";
						
					}
					else {
						
						status17 = "on leave";
					}
					
					if(rdbtnNewRadioButton_18.isSelected()) {
						
						status18 = "on duty";
						
					}
					else {
						
						status18 = "on leave";
					}
					
					if(rdbtnNewRadioButton_19.isSelected()) {
						
						status19 = "on duty";
						
					}
					else {
						
						status19 = "on leave";
					}
					
					if(rdbtnNewRadioButton_20.isSelected()) {
						
						status20 = "on duty";
						
					}
					else {
						
						status20 = "on leave";
					}
					
					if(rdbtnNewRadioButton_21.isSelected()) {
						
						status21 = "on duty";
						
					}
					else {
						
						status21 = "on leave";
					}
					
					if(rdbtnNewRadioButton_22.isSelected()) {
						
						status22 = "on duty";
						
					}
					else {
						
						status22 = "on leave";
					}
					
					if(rdbtnNewRadioButton_23.isSelected()) {
						
						status23 = "on duty";
						
					}
					else {
						
						status23 = "on leave";
					}
					
					if(rdbtnNewRadioButton_24.isSelected()) {
						
						status24 = "on duty";
						
					}
					else {
						
						status24 = "on leave";
					}
					
					if(rdbtnNewRadioButton_25.isSelected()) {
						
						status25 = "on duty";
						
					}
					else {
						
						status25 = "on leave";
					}
					
					if(rdbtnNewRadioButton_26.isSelected()) {
						
						status26 = "on duty";
						
					}
					else {
						
						status26 = "on leave";
					}
					
					if(rdbtnNewRadioButton_27.isSelected()) {
						
						status27 = "on duty";
						
					}
					else {
						
						status27 = "on leave";
					}
					
					if(rdbtnNewRadioButton_28.isSelected()) {
						
						status28 = "on duty";
						
					}
					else {
						
						status28 = "on leave";
					}
					
					if(rdbtnNewRadioButton_29.isSelected()) {
						
						status29 = "on duty";
						
					}
					else {
						
						status29 = "on leave";
					}
					
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					stmnt.executeUpdate("insert into dview values(1, '"+date+"','"+status+"')");
					stmnt.executeUpdate("insert into dview values(2, '"+date+"','"+status1+"')");
					stmnt.executeUpdate("insert into dview values(3, '"+date+"','"+status2+"')");
					stmnt.executeUpdate("insert into dview values(4, '"+date+"','"+status3+"')");
					stmnt.executeUpdate("insert into dview values(5, '"+date+"','"+status4+"')");
					stmnt.executeUpdate("insert into dview values(6, '"+date+"','"+status5+"')");
					stmnt.executeUpdate("insert into dview values(7, '"+date+"','"+status6+"')");
					stmnt.executeUpdate("insert into dview values(8, '"+date+"','"+status7+"')");
					stmnt.executeUpdate("insert into dview values(9, '"+date+"','"+status8+"')");
					stmnt.executeUpdate("insert into dview values(10, '"+date+"','"+status9+"')");
					stmnt.executeUpdate("insert into dview values(11, '"+date+"','"+status10+"')");
					stmnt.executeUpdate("insert into dview values(12, '"+date+"','"+status11+"')");
					stmnt.executeUpdate("insert into dview values(13, '"+date+"','"+status12+"')");
					stmnt.executeUpdate("insert into dview values(14, '"+date+"','"+status13+"')");
					stmnt.executeUpdate("insert into dview values(15, '"+date+"','"+status14+"')");
					stmnt.executeUpdate("insert into dview values(16, '"+date+"','"+status15+"')");
					stmnt.executeUpdate("insert into dview values(17, '"+date+"','"+status16+"')");
					stmnt.executeUpdate("insert into dview values(18, '"+date+"','"+status17+"')");
					stmnt.executeUpdate("insert into dview values(19, '"+date+"','"+status18+"')");
					stmnt.executeUpdate("insert into dview values(20, '"+date+"','"+status19+"')");
					stmnt.executeUpdate("insert into dview values(21, '"+date+"','"+status20+"')");
					stmnt.executeUpdate("insert into dview values(22, '"+date+"','"+status21+"')");
					stmnt.executeUpdate("insert into dview values(23, '"+date+"','"+status22+"')");
					stmnt.executeUpdate("insert into dview values(24, '"+date+"','"+status23+"')");
					stmnt.executeUpdate("insert into dview values(25, '"+date+"','"+status24+"')");
					stmnt.executeUpdate("insert into dview values(26, '"+date+"','"+status25+"')");
					stmnt.executeUpdate("insert into dview values(27, '"+date+"','"+status26+"')");
					stmnt.executeUpdate("insert into dview values(28, '"+date+"','"+status27+"')");
					stmnt.executeUpdate("insert into dview values(29, '"+date+"','"+status28+"')");
					stmnt.executeUpdate("insert into dview values(30, '"+date+"','"+status29+"')");
				
					JOptionPane.showMessageDialog(rootPane, "Successfully updated");
					setVisible(false);
					new doctor().setVisible(true);
					
				}
				catch(Exception exception) {
					
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(10, 728, 162, 31);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setBounds(0, 0, 936, 864);
		Image img = new ImageIcon(this.getClass().getResource("/doctorsteth.jpg")).getImage();
		lblNewLabel_22.setIcon(new ImageIcon (img));
		getContentPane().add(lblNewLabel_22);

		
		
		
	}
}
