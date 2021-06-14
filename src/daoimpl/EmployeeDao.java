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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import config.Jdbcconnection;
import dao.IEmployeeDao;
import model.Employee;

public class EmployeeDao implements IEmployeeDao {
	
	Connection conn=null;
	public EmployeeDao() throws ClassNotFoundException, SQLException {
		conn=Jdbcconnection.getDBConnection();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Employee");
			if(rst!=null) {
				Employee emp=null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmpId(rst.getInt(8));
					emp.setFirstName(rst.getString(1));
					emp.setLastName(rst.getString(2));
					emp.setUserId(rst.getString(3));
					emp.setPassword(rst.getString(4));
					emp.setRole(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setActive(rst.getString(7));
					
					allEmpList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		return allEmpList;
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			//creating prepared statements object by passing query string
			PreparedStatement pst=conn.prepareCall("insert into Employee(FirstName, LastName, UserId, Password, Role, Gender) values (?,?,?,?,?,?)");
			pst.setString(1, emp.getFirstName());
			pst.setString(2, emp.getLastName());
			pst.setString(3, emp.getUserId());
			pst.setString(4, emp.getPassword());
			pst.setString(5, emp.getRole());
			pst.setString(6, emp.getGender());
			//pst.setString(7, emp.getActive());
			int i=pst.executeUpdate();
			JFrame g=new JFrame();
			if(i==1){
				//System.out.println("1 Record inserted.....");
				JOptionPane.showConfirmDialog(g, "You have successfully Added an Employee...");
			}
			else {
				//System.out.println("Insertion Failed.....");
				JOptionPane.showConfirmDialog(g, "Never mind.... Retry... Insertion Failed");
			}
		}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
				
			}
		
	}

	public Employee getEmployeeById(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("Select * from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs= ps.executeQuery();
			JFrame frame = new JFrame();
			JTable table= new JTable();
			DefaultTableModel model = new DefaultTableModel(new String[] {"EmpId", "FirstName", "LastName", "UserID", "Password", "Role", "Gender", "Active", "EmpId"},0);
					while(rs.next())
					{
						String a = rs.getString("FirstName");
						String b = rs.getString("LastName");
						String c = rs.getString("UserId");
						String d = rs.getString("Password");
						String e = rs.getString("Role");
						String f = rs.getString("Gender");
						String g = rs.getString("Active");
						String h = rs.getString("EmpId");
						model.addRow(new Object[] {h,a,b,c,d,e,f,g});
						table.setModel(model);
						JScrollPane sp= new JScrollPane();
						frame.add(sp);
						frame.add(table);
						table.setBounds(10,10,500,500);
						frame.setVisible(true);
						frame.setBounds(10, 10, 500, 500);
						frame.setTitle("view EMP by ID");
						
						
						
					}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return emp;

		
	}

	@Override
	public void updateEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("update Employee set FirstName=?, LastName=?, Password=? where UserId=? ");
			ps.setString(1, emp.getFirstName());
			ps.setString(2, emp.getLastName());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getUserId());
			
			int rs=ps.executeUpdate();
			JFrame f= new JFrame();
			if(rs==1){
				JOptionPane.showMessageDialog(f, "Updated Successfully");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deactivateEmployee(Employee emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("select UserId from Employee where UserId=? ");
			pst.setString(1, emp.getUserId());
			ResultSet rs=pst.executeQuery();

			if(rs!=null){
				if(rs.next()){
					pst=conn.prepareStatement("update Employee set Active='no' where UserId=?");
					pst.setString(1, emp.getUserId());
					pst.executeUpdate();
				}
				
					

			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}
		
	

	@Override
	public void activateEmployee(Employee emp) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("select UserId from Employee where UserId=? ");
			pst.setString(1, emp.getUserId());
			ResultSet rs=pst.executeQuery();

			if(rs!=null){
				if(rs.next()){
					pst=conn.prepareStatement("update Employee set Active='yes' where UserId=?");
					pst.setString(1, emp.getUserId());
					pst.executeUpdate();
				}
				
					

			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	public void deleteEmployee(Employee emp) {
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement("Select EmpId from Employee where EmpId=?");
			ps.setInt(1, emp.getEmpId());
			ResultSet rs=ps.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					ps=conn.prepareStatement("delete from Employee where EmpId=?");
					ps.setInt(1, emp.getEmpId());
					ps.execute();
					
				}

			}
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	

	
	public Employee checkLogin(Employee emp) {
		//Employee emp=new Employee();
		try {
			PreparedStatement pst=conn.prepareStatement("select * from Employee where  UserId=? and Password=?");
			pst.setString(1, emp.getUserId());
			pst.setString(2, emp.getPassword());
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					emp.setEmpId(rst.getInt(8));
					emp.setFirstName(rst.getString(1));
					emp.setLastName(rst.getString(2));
					emp.setUserId(rst.getString(3));
					emp.setPassword(rst.getString(4));
					emp.setRole(rst.getString(5));
					emp.setGender(rst.getString(6));
					emp.setActive(rst.getString(7));
				}
			}
		}
			catch(SQLException ex) {
				System.out.println(ex.getMessage());
			}
			return emp;
		
	}




}


