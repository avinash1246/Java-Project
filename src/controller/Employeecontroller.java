package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import dao.IEmpJobDao;
import dao.IEmpSkillDao;
import dao.IEmployeeDao;
import daoimpl.EmployeeDao;
import model.Employee;


public class Employeecontroller {
	
	IEmployeeDao empDao=null;
	IEmpSkillDao empskillDao=null;
	IEmpJobDao empjobDao=null;
	
	public Employeecontroller() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDao();
	}
	
	public Employee checkLogin(String userId, String password) {
		Employee emp = new Employee();
		
		emp.setUserId(userId);
		emp.setPassword(password);
		empDao.checkLogin(emp); 
		return emp;
	}
	public void addEmployee(String UFN, String ULN, String UID, String UP, String UG, String UR){
		Employee emp=new Employee();
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		emp.setFirstName(UFN);
		
		emp.setLastName(ULN);
		
		emp.setUserId(UID);
		
		emp.setPassword(UP);
		
		emp.setRole(UR);
		
		emp.setGender(UG);

		//calling  dao method for insert record
		empDao.addEmployee(emp);
	}
	
public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
}
		
		public Employee activateEmployee (String UserID) {
			Employee emp = new Employee();
			emp.setUserId(UserID);
			empDao.activateEmployee(emp);
			return emp;
		}
		
		public Employee deactivateEmployee (String UserID) {
			Employee emp = new Employee();
			emp.setUserId(UserID);
			empDao.deactivateEmployee(emp);
			return emp;
		}
		
		public Employee getEmployeeById(int id) {
			Employee emp=new Employee();
			emp.setEmpId(id);
			empDao.getEmployeeById(emp);
			return emp;
		}
		
		public Employee updateEmployee(String UFN, String ULN, String UP, String UID) {
			Employee emp= new Employee();
			emp.setFirstName(UFN);
			emp.setLastName(ULN);
			emp.setPassword(UP);
			emp.setUserId(UID);
			empDao.updateEmployee(emp);
			return emp;
			
		}
		
		public Employee deleteEmployee(int EID) {
			Employee emp=new Employee();
			emp.setEmpId(EID);
			empDao.deleteEmployee(emp);
			return emp;
			
		}
			
	}
			
		
	
	
	


