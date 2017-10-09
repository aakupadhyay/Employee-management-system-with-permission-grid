package pkg.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pkg.model.EmpBean;
import pkg.model.OrgBean;
import pkg.model.dao.AdminDAO;

public class AdminService{
 List<OrgBean> list = new ArrayList<OrgBean>();
 AdminDAO adm = new AdminDAO();
	
	public List <OrgBean> ViewActiveEmployees() throws SQLException{
		String sql = "select * from org where superId IS NOT NULL";
		
		ResultSet rs = adm.executeFetch(sql);
		
		while(rs.next()){
			OrgBean emp = new OrgBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getDouble(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11));
			
			list.add(emp);
			
		}	
		return list;
	}
		
	public List <OrgBean> ViewInActiveEmployees() throws SQLException{
		String sql = "select * from org where superId IS NULL";
		
		ResultSet rs = adm.executeFetch(sql);
		
		while(rs.next()){
			OrgBean emp = new OrgBean(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getDouble(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11));
			
			list.add(emp);
			
		}	
		return list;
	}

	public boolean UpdateOrgProfile(EmpBean emp){
		int i = adm.executeModify(emp);
		
		if(i>0){
		    return true;
		}
		else{
			return false;
		}
		
	}
	
	public double PayrolCal(int empId){
		float b = 0;
		double a = 0;
		int lv = 0;
		double pay =0;
		
		String sql = "Select bonus,annual_income, leaveBalance from employee where empId="+empId;
		
		ResultSet result = adm.executeFetch(sql);
		
		try {
			if(result.next()){
				b = result.getFloat(1);
				a = result.getDouble(2);
				lv = result.getInt(3);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(lv < 0){
			pay = (a/12)+ b+ lv*(a/365);
			initLeave(empId);
		}else{
		pay = (a/12)+ b;
		}
		
		noBonus(empId);
		
		return pay;
		
	}
	
	public void noBonus(int empId){
		//initialises bonus
		String sql = "Update employee set bonus = 0.0 where empId="+empId;
		
		int i = adm.updateQuery(sql);
		
		if(i>0){
			System.out.println("Initialised bonus");
		}	
	}
	
	public void initLeave(int empId){
		//initialises leave
		String sql = "Update employee set leaveBalance = 0 where empId="+empId;
		
		int i = adm.updateQuery(sql);
		
		if(i>0){
			System.out.println("Initialised leave");
		}
	}
}
