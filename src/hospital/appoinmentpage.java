package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class appoinmentpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					appoinmentpage frame = new appoinmentpage();
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
	public appoinmentpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View Appoinment(By Date)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new viewappoinment().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton.setBackground(new Color(0, 120, 215));
		btnNewButton.setBounds(480, 282, 450, 71);
		Image img2 = new ImageIcon(this.getClass().getResource("/appoin3.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Take Appoinment");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new appoinment().setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(480, 147, 450, 71);
		Image img1 = new ImageIcon(this.getClass().getResource("/appoin2.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img1));
		contentPane.add(btnNewButton_1);

		
		JButton btnNewButton_2 = new JButton("Go to Home Page");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(rootPane, "Do you want to return to home page", "Select", JOptionPane.YES_NO_OPTION);
				if(close == 0) {
					setVisible(false);
					new homepage().setVisible(true);
				}				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(480, 518, 450, 71);
		Image img4 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View Appoinment(By Doctor)");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new appoinmentdoctor().setVisible(true);
				
			}
		});
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(480, 408, 450, 65);
		Image img3 = new ImageIcon(this.getClass().getResource("/appoin4.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img3));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-419, 0, 2111, 918);
		contentPane.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/appoin1.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
	}
}
