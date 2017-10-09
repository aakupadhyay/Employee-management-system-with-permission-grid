package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.model.dao.UserDAO;

/**
 * Servlet implementation class NameServlet
 */
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int mgrId = Integer.parseInt(request.getParameter("mgr"));
		String sql = "select u.firstname, u.lastname from userbean u where u.empId ="+mgrId;
		
		UserDAO usr = new UserDAO();
		ResultSet rt = usr.executeFetch(sql);
		String name = "";
		
		try {
			if(rt.next()){
				name = rt.getString("firstname")+" "+rt.getString("lastname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("MgrNm", name);
		response.sendRedirect("Raise_leave.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
