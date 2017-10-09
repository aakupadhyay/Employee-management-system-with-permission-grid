package pkg.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Connection;

import pkg.model.EmpBean;
import pkg.model.RequestBean;
import pkg.model.UserBean;

public class UserDAO {
	private ResultSet rs = null;

	public int registerUsers(UserBean emp) {
		int i = 0;
		Connection conn = DbDAO.connect();
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement("insert into "
					+ "userbean(empId,username,firstname,lastname,address,phone,email,pwd,usertype) "
					+ "values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, emp.getEmpID());
			ps.setString(2, emp.getUsername());
			ps.setString(3, emp.getFirstname());
			ps.setString(4, emp.getLastname());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getPhone());
			ps.setString(7, emp.getEmail());
			ps.setString(8, emp.getPassword());
			ps.setString(9, emp.getUsertype());

			i = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int registerEmp(EmpBean e) {
		int a = 0;
		Connection conn = DbDAO.connect();
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement("insert into employee(empId,leaveBalance) values(?,4)");
			ps.setInt(1, e.getEmpId());
			a = ps.executeUpdate();
			conn.close();
		} catch (SQLException s) {
			// TODO Auto-generated catch block
			s.printStackTrace();
		}

		return a;
	}

	public UserBean login(UserBean emp) {
		Connection con = DbDAO.connect();
		java.sql.Statement stmt = null;

		String username = emp.getUsername();
		String password = emp.getPassword();

		String searchQuery = "select * from userbean where username='" + username + "' AND pwd='" + password + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			if (!more) {
				emp.setValid(false);
			} else if (more) {
				emp.setEmpID(rs.getInt("empId"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emp.setAddress(rs.getString("address"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setPassword(rs.getString("pwd"));
				emp.setUsername(rs.getString("username"));

				emp.setValid(true);
				System.out.println("valid user");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emp;
	}

	public int executeModify(UserBean emp) {
		int a = 0;
		try {
			Connection connect = DbDAO.connect();
			java.sql.PreparedStatement ps = connect.prepareStatement(
					"update userbean set firstname=?,lastname=?, address=?, phone=?, email=? where empId=?");
			// ps.setString(1, emp.getUsername());username=?,
			ps.setString(1, emp.getFirstname());
			ps.setString(2, emp.getLastname());
			ps.setString(3, emp.getAddress());
			ps.setString(4, emp.getPhone());
			ps.setString(5, emp.getEmail());
			ps.setInt(6, emp.getEmpID());

			a = ps.executeUpdate();
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	public ResultSet executeFetch(String sql) {
		System.out.println("SQL: "+sql);
		
		try {
			Connection con = DbDAO.connect();
			rs = con.createStatement().executeQuery(sql);
			// con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public static int exeQuerUpd(String sql) {
		System.out.println("SQL: "+sql);
		
		int k = 0;
		try {
			Connection con = DbDAO.connect();
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			k = ps.executeUpdate();
			// rs = con.createStatement().executeQuery(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return k;
	}

	public int raiseleave(RequestBean req){
		int i=0;
		Connection conn = DbDAO.connect();
		
		try {
			java.sql.PreparedStatement ps = 
					conn.prepareStatement("insert into leavereq(empId,empfirstnm,emplastnm,mgrId,startdate,enddate,leavetype) "
							+ "values(?,?,?,?,?,?,?)");
			ps.setInt(1, req.getEmpId());
			ps.setString(2, req.getEmpfirtnm());
			ps.setString(3,req.getEmplastnm());
			ps.setInt(4,req.getMgrId());
			ps.setDate(5, new java.sql.Date(
					(
							new SimpleDateFormat("dd/mm/yyyy").parse(
									                                    req.getStartdate()
																	 )
					 ).getTime()
	          ));
			ps.setDate(6,new java.sql.Date(
					(
							new SimpleDateFormat("dd/mm/yyyy").parse(
									                                    req.getEnddate()
																	 )
					 ).getTime()
	          ));
//			ps.setDate(6, req.getEnddate());
			ps.setString(7, req.getLeave_type());
			
			i = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;	
	}

	public int executeUpdate(int empId, int lb) {
		int p = 0;
		Connection conn = DbDAO.connect();
		try {
			java.sql.PreparedStatement ps = conn.prepareStatement("update employee set leaveBalance=? where empId=?");
			ps.setInt(1, lb);
			ps.setInt(2, empId);

			p = ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;

	}
}
