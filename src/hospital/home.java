package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class home extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
	
		
		JButton btnNewButton = new JButton("Add new patient");
		Image img3 = new ImageIcon(this.getClass().getResource("/addpatient_35x35.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new addpatient().setVisible(true);
			}
		});
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(24, 227, 329, 50);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add consultaton information");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new addconsultation().setVisible(true);
		
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/cons_35x35.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img4));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(24, 319, 329, 50);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Doctors");
		Image img7 = new ImageIcon(this.getClass().getResource("/doctor_35x35.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img7));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(24, 650, 329, 50);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Patient History");
		Image img5 = new ImageIcon(this.getClass().getResource("/history_35x35.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img5));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				patienthistory ph = new patienthistory();
				ph.setVisible(true);
				ph.toFront();
				ph.repaint();
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_3.setBounds(24, 426, 329, 50);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update patient Information");
		Image img6 = new ImageIcon(this.getClass().getResource("/update_35x35.jpg")).getImage();
		btnNewButton_4.setIcon(new ImageIcon (img6));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new updateordelete().setVisible(true);
			}
		});
		btnNewButton_4.setBounds(24, 534, 329, 50);
		getContentPane().add(btnNewButton_4);
		
		
		
		JButton btnNewButton_6 = new JButton("LOGOUT");
		Image img8 = new ImageIcon(this.getClass().getResource("/logout_35x35.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon (img8));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int logout = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
				if(logout == 0) {
					setVisible(false);
					login l = new login();
					l.setVisible(true);
				}
			}

			private Object isAlwaysOnTopSupported() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_6.setBounds(83, 736, 173, 40);
		getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/logo_5_150x150.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		lblNewLabel.setBounds(97, 10, 185, 173);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/aaa_1900x1000.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon (img2));
		lblNewLabel_1.setBounds(0, 0, 2021, 853);
		getContentPane().add(lblNewLabel_1);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setLocationRelativeTo(null);
	}

}
