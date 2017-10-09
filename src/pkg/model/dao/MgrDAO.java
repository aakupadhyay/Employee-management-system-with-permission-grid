package pkg.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MgrDAO {
	private ResultSet re = null;
	
	public ResultSet executeFetch(String sql){
		System.out.println("SQL: "+sql);
		
		try {
			Connection con = DbDAO.connect();
			re = con.createStatement().executeQuery(sql);
			//con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return re;
	}

	public int updateQuery(String sql){
		System.out.println("SQL: "+sql);
		
		int i =0;
		
		try {
			Connection connect = DbDAO.connect();
			java.sql.PreparedStatement ps = connect.prepareStatement(sql);
			i = ps.executeUpdate();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
}
