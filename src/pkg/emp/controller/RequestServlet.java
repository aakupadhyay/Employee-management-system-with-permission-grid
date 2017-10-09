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

import pkg.emp.service.MgrService;
import pkg.model.RequestBean;

/**
 * Servlet implementation class RequestServlet
 */
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int empId = Integer.parseInt(request.getParameter("emp"));
		
		MgrService srv = new MgrService();
		ResultSet rs = srv.RequestIndox(empId);
		List<RequestBean> list = new ArrayList<RequestBean>();
		
		try {
			 while(rs.next()){
				RequestBean rb = new RequestBean(rs.getInt(1),rs.getString(2),rs.getString(3),empId,rs.getString(4),rs.getString(5),rs.getString(6));
				
				list.add(rb);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("reqlist", list);
		RequestDispatcher rd= request.getRequestDispatcher("reqInbox.jsp");
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
