package pkg.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import pkg.model.EmpBean;

public class AdminDAO {
	private ResultSet rs = null;

	public int executeModify(EmpBean emp){
		int a=0;
		try {
			Connection connect = DbDAO.connect();
			java.sql.PreparedStatement ps = connect.prepareStatement("update employee set div_name=?,role=?, superId=?, bonus=?, annual_income=?, leaveBalance=? where empId=?");
			ps.setString(1, emp.getDiv_name());
			ps.setString(2, emp.getRole());
			ps.setInt(3, emp.getSuperId());
			ps.setFloat(4, emp.getBonus());
			ps.setDouble(5, emp.getIncome());
			ps.setInt(6, emp.getLeaveBal());
			ps.setInt(7, emp.getEmpId());
			
			a = ps.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		SetLevel(emp.getEmpId());
		return a;
	} 
	
	public ResultSet executeFetch(String sql){
		System.out.println("SQL: "+sql);
		
		try {
			Connection con = DbDAO.connect();
			rs = con.createStatement().executeQuery(sql);
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}
	
	public int updateQuery(String sql){
		System.out.println("SQL: "+sql);
		
		int b=0;
		try {
			Connection connect = DbDAO.connect();
			java.sql.PreparedStatement ps = connect.prepareStatement(sql);
			b = ps.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return b;
		
	}
	
	public void SetLevel(int empId){
		String sql = "select level from employee "
				+ "where empId in (select superId from erp.employee where empId ="+empId+")";
		
		ResultSet rs = executeFetch(sql);
		int level = 0;
		try {
			if(rs.next()){
			level = rs.getInt("level")+1;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = "update employee set level = "+level+" where empId ="+empId;
		int result = updateQuery(query);
		
		if(result>0){
			System.out.println("Level assigned");
		}
	}
}
