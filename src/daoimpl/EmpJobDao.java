package daoimpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import config.Jdbcconnection;
import dao.IEmpJobDao;
import model.Empjob;

public class EmpJobDao implements IEmpJobDao {
	
	Connection conn=null;
	public EmpJobDao() throws ClassNotFoundException, SQLException{
		conn=Jdbcconnection.getDBConnection();
		
	}
	@Override
	public List<Empjob> getAllEmpJobs() {
		List<Empjob> allEmpJobList = new ArrayList<Empjob>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpJob");
			if(rst!=null) {
				Empjob empj=null;
				while(rst.next()) {
					empj=new Empjob();
					empj.setEJId(rst.getInt(1));
					empj.setEmpId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
					allEmpJobList.add(empj);														
					
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;
	}
	@Override
	public void addEmpJob(Empjob empj) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)");
			pst.setInt(3,empj.getEmpId());
			pst.setInt(3,empj.getJobId());
			pst.setString(3,empj.getRecruited());
		
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			
			if(i==1)
			{
				//System.out.println("1 record inserted");
				JOptionPane.showMessageDialog(j,"We Have Received Your Application...");
			}
			else
			{
				//System.out.println("Insertion failed...");
				JOptionPane.showMessageDialog(j,"Something went Wrong...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
	@Override
	public Empjob getEmpJobById(int id) {
		// TODO Auto-generated method stub
		Empjob empj=new Empjob();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from EmployeeJob where EJId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					empj.setEJId(rst.getInt(1));
					empj.setEmpId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return empj;
		
	}
	@Override
	public void updateEmpJob(Empjob empj) {
		try {
			
		
		PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=? ");
		pst.setString(1, empj.getRecruited());
		pst.setInt(2, empj.getEJId());
		int i=pst.executeUpdate();
		JFrame j=new JFrame();
		if(i==1){
			JOptionPane.showConfirmDialog(j, "The List has been Updated....");
		}
		else {
			
			JOptionPane.showConfirmDialog(j, "updation Failed...");
		}
		
	}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
		
	
	@Override
	public void deleteEmpJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			JFrame j=new JFrame();
			if(i==1){
				//System.out.println("1 record deleted...");
				JOptionPane.showConfirmDialog(j, "The Record has been Deleted...");
			}
			else {
				//System.out.println("deletion failed...");
				JOptionPane.showConfirmDialog(j, "Record deletion Failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	

}
