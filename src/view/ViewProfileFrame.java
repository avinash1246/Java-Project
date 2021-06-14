package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;

import model.Employee;

import java.awt.Color;

public class ViewProfileFrame {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Employee emp;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					 new ViewProfileFrame(emp);
				
			
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewProfileFrame(Employee emp) {
		this.emp = emp;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 656, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel.setBounds(73, 148, 100, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(73, 206, 100, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(73, 266, 86, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(73, 321, 100, 21);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Role");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(73, 379, 71, 21);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Active");
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(73, 433, 86, 21);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField(Integer.toString(emp.getEmpId()));
		textField.setBounds(396, 148, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(emp.getFirstName());
		textField_1.setBounds(396, 206, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField(emp.getLastName());
		textField_2.setBounds(396, 266, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField(emp.getGender());
		textField_3.setBounds(396, 321, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField(emp.getRole());
		textField_4.setBounds(396, 379, 96, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(emp.getActive());
		textField_5.setBounds(396, 433, 96, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter The Following Details");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(224, 49, 253, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(253, 513, 85, 21);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new HomeScreenFrames(emp);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		
		});
	}
	

}
