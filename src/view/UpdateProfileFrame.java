package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.Employeecontroller;
import model.Employee;
import view.UpdateProfileFrame;

public class UpdateProfileFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Employee emp;
	Employeecontroller empController=null;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new UpdateProfileFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public UpdateProfileFrame(Employee emp) throws ClassNotFoundException, SQLException {
		this.emp=emp;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 587, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("UPDATE FORM");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 20));
		lblNewLabel.setBounds(208, 42, 146, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(52, 138, 110, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LastName");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(52, 197, 84, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Change Password");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(52, 344, 146, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(52, 415, 146, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(317, 138, 157, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 197, 157, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
/*		textField_2 = new JTextField();
		textField_2.setBounds(317, 344, 157, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 415, 157, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);*/
		
		passwordField = new JPasswordField();
		passwordField.setBounds(317, 344, 157, 19);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(317, 417, 157, 19);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("SUBMIT");
		empController = new Employeecontroller();
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String UFN, ULN, UP, UCP, UID;
				UID=emp.getUserId();
				UFN=textField.getText();
				System.out.println(emp.getFirstName());
					ULN=textField_1.getText();
					UP=new String(passwordField.getPassword());
					UCP=new String(passwordField_1.getPassword());
				if(UP.equals(UCP)) {
					empController.updateEmployee(UFN,ULN,UP,UID);
				JOptionPane.showMessageDialog(frame, "Registered Successfully");
				frame.dispose();
				try {
					new LoginFrame();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "Check Your Password and Retry!!");
			}
		}
		});
	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setBounds(107, 485, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(338, 485, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new HomeScreenFrames(emp);
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
		});
	}
}
