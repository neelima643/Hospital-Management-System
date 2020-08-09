package hospital;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage frame = new homepage();
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
	public homepage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Patient");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		Image img3 = new ImageIcon(this.getClass().getResource("/patienticon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			new patientspage().setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 35));
		btnNewButton.setBounds(355, 206, 329, 70);
		contentPane.add(btnNewButton);
		

		
		
		JButton btnNewButton_2 = new JButton("Doctors");
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		Image img7 = new ImageIcon(this.getClass().getResource("/d1.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img7));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new doctorspage().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Calibri Light", Font.BOLD, 35));
		btnNewButton_2.setBounds(355, 325, 329, 70);
		contentPane.add(btnNewButton_2);

		
		
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setBackground(SystemColor.textHighlight);
		btnNewButton_6.setForeground(SystemColor.text);
		Image img8 = new ImageIcon(this.getClass().getResource("/logout1.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon (img8));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int logout = JOptionPane.showConfirmDialog(rootPane, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
				if(logout == 0) {
					setVisible(false);
					loginpage l = new loginpage();
					l.setVisible(true);
				}
			}

			private Object isAlwaysOnTopSupported() {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 35));
		btnNewButton_6.setBounds(355, 555, 329, 70);
		contentPane.add(btnNewButton_6);
		

		
		
		
		
		JButton btnNewButton_8 = new JButton("Appoinment");
		Image img5 = new ImageIcon(this.getClass().getResource("/appoin5.png"
				+ "")).getImage();
		btnNewButton_8.setIcon(new ImageIcon (img5));
		btnNewButton_8.setForeground(SystemColor.text);
		btnNewButton_8.setBackground(SystemColor.textHighlight);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new appoinmentpage().setVisible(true);
			}
		});
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 35));
		btnNewButton_8.setBounds(355, 436, 326, 68);
		contentPane.add(btnNewButton_8);
		

		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/homepage.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon (img2));
		lblNewLabel_1.setBounds(-230, 0, 2021, 853);
		contentPane.add(lblNewLabel_1);
		
	}

}
