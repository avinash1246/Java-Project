package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.sql.SQLException;

import javax.swing.JTextField;

import controller.Employeecontroller;

import javax.swing.JButton;
import java.awt.Color;

public class ActivateEmployeeFrame {
	

	private JFrame frame;
	private JTextField textField;
	Employeecontroller empController=null;
	private Employeecontroller Employeecontroller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new ActivateEmployeeFrame();
				
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
	public ActivateEmployeeFrame() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException  {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 465, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Enter Your UserID");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel.setBounds(24, 149, 181, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(237, 154, 164, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ACTIVATE");
        Employeecontroller  = new Employeecontroller();
		
        btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String UID;
				UID = textField.getText();
				
				//s=Integer.parseInt(tEmployeeId.getText());
				Employeecontroller.activateEmployee(UID);
				JOptionPane.showMessageDialog(frame, "Activated Successfully");
				
			}
		
		
			
			
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 10));
		btnNewButton.setBounds(167, 264, 106, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
