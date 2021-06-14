package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.Jobcontroller;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

public class AddJobFrame {
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private static Jobcontroller jobcontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new AddJobFrame();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddJobFrame() {
		start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void start() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 655, 698);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("JobTitle");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel.setBounds(55, 128, 111, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Job Description");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(55, 191, 138, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Company Name");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(55, 256, 124, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("KeySkills");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(55, 316, 96, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Location");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(55, 375, 126, 34);
		frame.getContentPane().add(lblNewLabel_4);
		
		/*JLabel lblNewLabel_5 = new JLabel("Experience");
		lblNewLabel_5.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(55, 442, 92, 34);
		frame.getContentPane().add(lblNewLabel_5);*/
		
		JLabel lblNewLabel_6 = new JLabel("Salary");
		lblNewLabel_6.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(55, 505, 138, 30);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(324, 135, 245, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(324, 196, 245, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 256, 245, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(324, 319, 245, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(324, 390, 245, 19);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(324, 449, 245, 19);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
	/*	textField_6 = new JTextField();
		textField_6.setBounds(324, 510, 245, 19);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10); */
		
		JButton btnNewButton = new JButton("SUBMIT");
		try {
			jobcontroller = new Jobcontroller();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String j1,j2,j3,j4,j5,j6;
				j1=textField.getText();
				j2=textField_1.getText();
				j3=textField_2.getText();
				j4=textField_3.getText();
				j5=textField_4.getText();
				j6=textField_5.getText();
				jobcontroller.addJob(j1,j2,j3,j4,j5,j6);
				frame=new JFrame();
				JOptionPane.showMessageDialog(frame,"Job Added");
			}
			
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(268, 615, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Enter The Following Details To Add Job ");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBackground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(197, 42, 291, 13);
		frame.getContentPane().add(lblNewLabel_7);
	}


}
