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

public class AllSkillFrame extends JFrame {
	
	JFrame frame;
	Container container;
	public AllSkillFrame() throws ClassNotFoundException, SQLException {
		Connection conn=Jdbcconnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"SkillId","SkillName", "SkillDescription"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Skill");
		while(rst.next())
		{
		    
			int a = rst.getInt("SkillId");
		    String b = rst.getString("SkillName");
		    String c = rst.getString("SkillDescription");
		    //String h = rst.getString("Activate");
		    model.addRow(new Object[]{a,b,c});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Skill Data");
		}
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	


}
