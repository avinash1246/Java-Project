package controller;

import java.sql.SQLException;
import java.util.List;

import dao.IJobDao;
import daoimpl.JobDao;
import model.Employee;
import model.Job;

public class Jobcontroller {
	
		JobDao jobDao=null;
		public Jobcontroller() throws ClassNotFoundException, SQLException {
			jobDao= new JobDao();
		}
		
		public void addJob(String JBT, String JD, String CN,String LC, String KS, String JS ) {
			Job j=new Job();
				
				j.setJobTitle(JBT);
				j.setJobDescription(JD);
				j.setCompanyName(CN);
				j.setLocation(LC);
				j.setKeySkill(KS);
				j.setSalary(JS);
				if(JBT.equals("HR")) {
					j.setActive("Activated");
				}
				else {
					j.setActive("Deactivated");
				}
				//Calling dao method for insert record
				jobDao.addJob(j);
			}
		public void getAllJobs() {
			
			List<Job> allJobList=jobDao.getAllJobs();
			for(Job j:allJobList) {
				System.out.println(j);
			}
		}
		public Job activateJob(int s) {
			   Job j = new Job();
			   j.setJobId(s);
			   jobDao.activateJob(j);
			   return j;
		   
				
			}
		public Job deactivateJob(int s) {
			   Job j = new Job();
			   j.setJobId(s);
			   jobDao.deactivateJob(j);
			   return j;   
			}
		public Job DeleteJob(int s) {
			   Job j= new Job();
			   j.setJobId(s);
			   jobDao.deleteJob(j);
			   return j;
		   }
		
		public Job getJobById(int s) {
			Job j=new Job();
			j.setJobId(s);
			jobDao.getJobById(j);
			return j;
		}
}