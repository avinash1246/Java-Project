package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;

public class AllEmployeesFrame extends JFrame {
	
	JFrame frame;
	Container container;
	public AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"FirstName", "LastName", "UserID", "Password","Role","Gender", "Active", "EmpId" }, 0);
		ResultSet rst=stmt.executeQuery("select * from EMPLOYEE");
		while(rst.next())
		{
		    String a = rst.getString("FirstName");
		    String b = rst.getString("LastName");
		    String c = rst.getString("UserID");
		    String d = rst.getString("Password");
		    String e = rst.getString("Role");
		    String f = rst.getString("Gender");
		    String g = rst.getString("Active");
		    int h = rst.getInt("EmpId");
		    
		    model.addRow(new Object[]{a,b,c,d,e,f,g,h});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Employee Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	


}
