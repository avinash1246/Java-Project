package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PMEFrames {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PMEFrames();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PMEFrames() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("PME Home Screen");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 627, 706);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("WELCOME To PME Portal");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(159, 37, 291, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View SkillWise Employye");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton.setBounds(145, 96, 345, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View All Skills");
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(145, 163, 345, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add an job");
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new AddJobFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		btnNewButton_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(145, 230, 345, 34);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View All Jobs");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AllJobFrame();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_3.setBounds(145, 296, 345, 31);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View SkillWise Jobs");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_4.setBounds(145, 358, 346, 31);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View Employees Who Applied For Jobs");
		btnNewButton_5.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_5.setBounds(145, 416, 345, 34);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View SkillWise Employee");
		btnNewButton_6.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_6.setBounds(145, 546, 345, 31);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Deactivate Job");
		btnNewButton_7.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_7.setBounds(145, 481, 345, 34);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("LOGOUT");
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.setForeground(Color.DARK_GRAY);
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_8.setBounds(270, 621, 85, 21);
		frame.getContentPane().add(btnNewButton_8);
	}

}
