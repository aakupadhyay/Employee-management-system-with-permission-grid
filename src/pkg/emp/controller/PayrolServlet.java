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

import pkg.model.EmpBean;
import pkg.model.dao.AdminDAO;

/**
 * Servlet implementation class PayrolServlet
 */
public class PayrolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String sql = "select * from employee";
		
		AdminDAO adm = new AdminDAO();
		ResultSet r = adm.executeFetch(sql);
		List<EmpBean> list = new ArrayList<EmpBean>();
		
		try {
			while(r.next()){
				EmpBean emprole = new EmpBean(r.getString(2), r.getString(3), r.getInt(4), r.getLong(5),r.getDouble(6),r.getInt(7),r.getInt(1));
				list.add(emprole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("emplist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/payroll.jsp");
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
