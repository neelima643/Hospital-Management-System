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

public class doctorspage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doctorspage frame = new doctorspage();
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
	public doctorspage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Update Status");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new doctor().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton.setBounds(42, 261, 331, 82);
		Image img1 = new ImageIcon(this.getClass().getResource("/d3.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img1));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Doctor Record");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new viewdoctor().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_1.setBounds(42, 374, 331, 82);
		Image img2 = new ImageIcon(this.getClass().getResource("/d5.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img2));
		contentPane.add(btnNewButton_1);

		
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
		btnNewButton_3.setBounds(42, 487, 331, 89);
		Image img4 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img4));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("DOCTOR");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 60));
		lblNewLabel.setBounds(514, 10, 552, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/d2.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 1540, 853);
		contentPane.add(lblNewLabel_1);

	}

}
