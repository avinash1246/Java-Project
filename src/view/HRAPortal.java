package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.Employeecontroller;
import controller.Jobcontroller;
import controller.Skillcontroller;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HRAPortal extends JFrame {
	
	private JFrame frame;
	
	// Employeecontroller empController=null;
	// Jobcontroller jobcontroller=null;
	// Skillcontroller skillcontroller=null;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new HRAPortal();
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HRAPortal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HRA Frame");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.GRAY);
		frame.setBounds(100, 100, 561, 875);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Welcome To HRA Portal");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 23));
		lblNewLabel.setBounds(143, 25, 330, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View All Employee");
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllEmployeesFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton.setBounds(179, 109, 217, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deactivate Employee");
		 btnNewButton_1.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmployeeFrame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_1.setBounds(179, 162, 217, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Active User");
		 btnNewButton_2.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmployeeFrame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		btnNewButton_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_2.setBounds(179, 219, 217, 30);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View All Skills");
		btnNewButton_3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllSkillFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		/*btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
		btnNewButton_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_3.setBounds(179, 330, 217, 30);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Deactivate Skills");
		 btnNewButton_2.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 
				 try {
					new ActivateEmployeeFrame();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		btnNewButton_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(179, 384, 217, 30);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Activate Skills");
		btnNewButton_5.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_5.setBounds(179, 440, 217, 30);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("View All Jobs");
		 btnNewButton_6.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
					try {
						new AllJobFrame();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_6.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(179, 495, 217, 30);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Deactivate Jobs");
		btnNewButton_7.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_7.setBounds(179, 550, 217, 30);
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("View Employee By ID");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EmpIDFrame();
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_8.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_8.setBounds(179, 272, 217, 30);
		frame.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Activate Jobs");
		btnNewButton_8.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						new ActivateJobFrame();
					} catch (Exception e1) {
						e1.printStackTrace();
					}	
			}	
		});
		btnNewButton_9.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_9.setBounds(179, 604, 217, 30);
		frame.getContentPane().add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("Delete Employee");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteEmployeeFrame();
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_10.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_10.setBounds(179, 655, 217, 30);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Delete Job");
		 btnNewButton_11.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
						new DeleteJob();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	   });
		btnNewButton_11.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_11.setBounds(179, 712, 217, 30);
		frame.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("Delete Skill");
		btnNewButton_12.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)  {
				try {
						new DeleteSkill();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	   });
		btnNewButton_12.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		btnNewButton_12.setBounds(179, 764, 217, 30);
		frame.getContentPane().add(btnNewButton_12);
	}

}
