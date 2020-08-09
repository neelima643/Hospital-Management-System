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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class loginpage extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(967, 215, 128, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(967, 277, 128, 32);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(1127, 207, 354, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField.setBounds(1127, 276, 354, 43);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		Image img2 = new ImageIcon(this.getClass().getResource("/loginnew.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if((textField.getText().equals("admin") && passwordField.getText().contentEquals("123"))) {
					
					JOptionPane.showMessageDialog(rootPane, "You are successfully logined");
					homepage h = new homepage();
					h.setVisible(true);
				}
				else {
					
					JOptionPane.showMessageDialog(rootPane, "Invalid Username or Password");
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(967, 367, 147, 59);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		Image img3 = new ImageIcon(this.getClass().getResource("/reset.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_1.setBounds(1168, 367, 156, 59);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXIT");
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		Image img4 = new ImageIcon(this.getClass().getResource("/exitskyblue.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int exit = JOptionPane.showConfirmDialog(rootPane, "Do you want to exit?", "Select", JOptionPane.YES_NO_OPTION);
				if(exit == 0) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton_2.setBounds(1353, 367, 128, 59);
		contentPane.add(btnNewButton_2);
		Image img5 = new ImageIcon(this.getClass().getResource("/symbol.png")).getImage();
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/login.jpg")).getImage();
		

		lblNewLabel_2.setIcon(new ImageIcon (img1));
		lblNewLabel_2.setBounds(0, -18, 2031, 853);
		contentPane.add(lblNewLabel_2);
	}
}
