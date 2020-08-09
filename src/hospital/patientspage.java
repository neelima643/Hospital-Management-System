package hospital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class patientspage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientspage frame = new patientspage();
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
	public patientspage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add new patient");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new addpatient().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton.setBounds(96, 113, 372, 82);
		Image img1 = new ImageIcon(this.getClass().getResource("/addpatienticon.png")).getImage();
		
		JButton btnNewButton_4 = new JButton("Prescription");
		btnNewButton_4.setForeground(SystemColor.text);
		btnNewButton_4.setBackground(SystemColor.textHighlight);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new prescription().setVisible(true);
				
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_4.setBounds(96, 330, 372, 82);
		Image img6 = new ImageIcon(this.getClass().getResource("/p3.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon (img6));
		contentPane.add(btnNewButton_4);
		
		btnNewButton.setIcon(new ImageIcon (img1));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Patient History");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new patienthistory().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_1.setBounds(96, 433, 372, 82);
		Image img2 = new ImageIcon(this.getClass().getResource("/historyicon.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update/Delete Patient");
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new updateordelete().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_2.setBounds(96, 538, 372, 82);
		Image img3 = new ImageIcon(this.getClass().getResource("/updelicon.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img3));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Go to Home Page");
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(rootPane, "Do you want to return to home page", "Select", JOptionPane.YES_NO_OPTION);
				if(close == 0) {
					setVisible(false);
					new homepage().setVisible(true);
				}
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_3.setBounds(96, 642, 372, 87);
		Image img4 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img4));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("PATIENT");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 60));
		lblNewLabel.setBounds(471, 32, 552, 82);
		contentPane.add(lblNewLabel);

		
		JButton btnNewButton_5 = new JButton("Add consultation info");
		btnNewButton_5.setForeground(SystemColor.text);
		btnNewButton_5.setBackground(SystemColor.textHighlight);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new addconsultation().setVisible(true);
				
			}
		});
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_5.setBounds(96, 218, 372, 82);
		Image img5 = new ImageIcon(this.getClass().getResource("/p2.jpg")).getImage();
		btnNewButton_5.setIcon(new ImageIcon (img5));
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/p1.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 1596, 853);
		contentPane.add(lblNewLabel_1);
	}

}
