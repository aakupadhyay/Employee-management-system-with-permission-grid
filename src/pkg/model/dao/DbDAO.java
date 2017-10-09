package pkg.model.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbDAO {
// private static 
	
	public static Connection connect() {
		Connection conn = null;
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/erp", "root", "aakriti");
				System.out.println("connection successful");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
