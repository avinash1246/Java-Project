package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.Employeecontroller;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class RegistrationFrame extends JFrame {
	

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static Employeecontroller employeecontroller=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationFrame window = new RegistrationFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public RegistrationFrame() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame("Employee Home Screen");
		frame.getContentPane().setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 720, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Registration Form");
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD, 23));
		lblNewLabel.setBounds(246, 39, 218, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(45, 130, 104, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(392, 132, 111, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(45, 223, 104, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Create Password");
		lblNewLabel_4.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(45, 313, 162, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password");
		lblNewLabel_5.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(390, 313, 193, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(45, 431, 92, 13);
		frame.getContentPane().add(lblNewLabel_6);
		

		
		JLabel lblNewLabel_8 = new JLabel("Role");
		lblNewLabel_8.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(45, 531, 104, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(45, 153, 193, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(392, 153, 181, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(45, 246, 193, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(45, 348, 193, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(392, 348, 181, 19);
		frame.getContentPane().add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(41, 454, 197, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
	/*	textField_4 = new JTextField();
		textField_4.setBounds(392, 454, 181, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);  */
		
		textField_5 = new JTextField();
		textField_5.setBounds(41, 561, 197, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10); 
		
		
		JButton btnNewButton = new JButton("SUBMIT");
		employeecontroller=new Employeecontroller();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UFN, ULN, UID, UP, UCP, UG, UR;
				UFN = textField.getText();
				ULN =textField_1.getText();
				UID = textField_2.getText();
				UP = new String(passwordField.getPassword());
				UG = textField_3.getText();
				UR = textField_5.getText();
				UCP = new String(passwordField_1.getPassword());
				
				if(UP.equals(UCP)) {
					employeecontroller.addEmployee(UFN,ULN,UID,UP,UG,UR);		//Values Added to Controller
					JOptionPane.showMessageDialog(frame,"Registered Succesfully");
					frame.dispose();
					try {
						new LoginFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					else {
					JOptionPane.showMessageDialog(frame, "Check your Password and Retry ..!");
				}
			}
		});
				
		
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(281, 591, 111, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
