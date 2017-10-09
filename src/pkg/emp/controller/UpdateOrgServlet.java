package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.model.dao.AdminDAO;
import pkg.model.dao.MgrDAO;

/**
 * Servlet implementation class UpdateOrgServlet
 */
public class UpdateOrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Map<Integer,String> m1 = new HashMap<Integer,String>();
	        String sql ="select empId,firstname,lastname from userbean";
	        MgrDAO mgr = new MgrDAO();
	        ResultSet rs = mgr.executeFetch(sql);
	        
	        try {
				while(rs.next()){
					m1.put(rs.getInt("empId"), rs.getString("firstname")+" "+rs.getString("lastname"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.print(m1);
		
		String empId = request.getParameter("empId");
		String query = "select * from org where empId="+empId;
		
		AdminDAO adm = new AdminDAO();
		ResultSet result = adm.executeFetch(query);
		
		try {
			if(result.next()){
				request.setAttribute("ID", result.getInt(1));
				request.setAttribute("fn", result.getString(2));
				request.setAttribute("ln", result.getString(3));
				request.setAttribute("divi", result.getString(4));
				request.setAttribute("role", result.getString(5));
				//request.setAttribute("bonus", result.getString(6));
				request.setAttribute("income", result.getString(7));
				request.setAttribute("leave", result.getString(8));
				request.setAttribute("mgr", result.getString(9));
//				request.setAttribute("mgr_fn", result.getString(10));
//				request.setAttribute("mgr_ln", result.getString(11));
                request.setAttribute("Map", m1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("UpdateOrg.jsp");
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
