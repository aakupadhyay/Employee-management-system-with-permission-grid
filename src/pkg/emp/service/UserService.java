package pkg.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import pkg.model.RequestBean;
import pkg.model.UserBean;
import pkg.model.dao.UserDAO;

public class UserService {
	private ResultSet res = null;
	UserDAO usr = new UserDAO();
	
	public boolean ValidateUser(String usernm, String pwd){
		
		UserBean user = new UserBean(usernm,pwd);
		user = usr.login(user);
		
		if (user.isValid()){
			return true;
		}
		else{
		return false;
		}		
	}
	
	public boolean ValidateMgr(String usernm, String pwd) throws SQLException{
		String quer = "select * from manager where username='"
                + usernm
                + "' AND pwd='"
                + pwd
                + "'";
	  
		res = usr.executeFetch(quer);
		
		if(res.next()){
		    return true;
		}
		else{
			return false;
		}
	}
   
	public boolean ValidateAdmin(String usernm, String pwd) throws SQLException{
		String quer = "select * from admin where username='"
                + usernm
                + "' AND pwd='"
                + pwd
                + "'";
	  
		res = usr.executeFetch(quer);
		
		if(res.next()){
		    return true;
		}
		else{
			return false;
		}
	}
	
	public ResultSet ModifyProfile(int empId){
		String sql = "select * from userbean where empId="+empId;
		
		ResultSet rs = usr.executeFetch(sql);
		return rs;
	}
	
	public int ManagerID(int empId){
		String sql = "select superId from employee where empId="+empId;
		
		if(res != null){
			res = null;
			res = usr.executeFetch(sql);
		}
		
		int superId=0;
		
		try {
			if(res.next()){
			superId = res.getInt("superId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return superId;
		
	}
	
	public boolean InsertRequest(RequestBean req){
		int i =0;
		int days = Caldate(req);
        String sql = "select leaveBalance from employee where empId="+req.getEmpId();
		
		if(res != null){
			res =null;
		}
		
		res = usr.executeFetch(sql);
		
		try {
			if(res.next()){
			int l = res.getInt("leaveBalance");
			extraleave(l,days,req.getEmpId());
			}
			else{
				System.out.println("No result");
			}
     		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i = usr.raiseleave(req);
		if(i>0){
			return true;
		}	
		return false;
	}
	
	private int Caldate(RequestBean req){
		int days = 0;
		try {
			Date date1=new SimpleDateFormat("dd/mm/yyyy").parse(req.getStartdate());
			Date date2=new SimpleDateFormat("dd/mm/yyyy").parse(req.getEnddate());
			
			long milliseconds = Math.abs(date1.getTime() - date2.getTime());
			days = (int)(milliseconds / (1000 * 60 * 60 * 24))+1;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
        System.out.println(days);
		return days;	
	}
	
	public void extraleave(int leave, int d, int empId){
		int l = leave - d;
		System.out.println(leave+","+d);
		
		int i = usr.executeUpdate(empId, l);
		
		if(i>0){
			System.out.println("Leave Balance successfully updated");
		}		
	}
	
	public int GenerateID(){
		Random r = new Random( System.currentTimeMillis() );
		int p = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
		
		return p;
	}
	
	public ResultSet CheckStatus(int empId){
		String sql = "select * from leavereq where empId="+empId;
		
		if(res != null){
			res =null;
		}
		
		res = usr.executeFetch(sql);
		
		return res;
		
	}
}