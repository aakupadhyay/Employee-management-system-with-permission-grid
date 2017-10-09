package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.model.UserBean;
import pkg.model.dao.AdminDAO;

/**
 * Servlet implementation class UserType
 */
public class UserType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
		String sql = "select * from userbean where NOT empId=1";
		
		AdminDAO adm = new AdminDAO();
		ResultSet set = adm.executeFetch(sql);
		List<UserBean> list = new ArrayList<UserBean>();
		try {
			while(set.next()){
				UserBean user = new UserBean(set.getInt(1), set.getString(3), set.getString(4),set.getString(5),set.getString(6),set.getString(7),set.getString(2), set.getString(8),set.getString(9));
				
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("usrlist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/user_list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
