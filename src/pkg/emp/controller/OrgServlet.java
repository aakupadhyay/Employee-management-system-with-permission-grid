package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.model.EmpBean;
import pkg.model.dao.AdminDAO;

/**
 * Servlet implementation class OrgServlet
 */
public class OrgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
		
		int empId = Integer.parseInt(request.getParameter("user"));
		String division = request.getParameter("divs");
		String role = request.getParameter("role");
		float bonus = Float.parseFloat(request.getParameter("bon"));
		double income = Double.parseDouble(request.getParameter("income"));
		int leav = Integer.parseInt(request.getParameter("leave"));
		int mgrId = Integer.parseInt(request.getParameter("mgrId"));
		
		EmpBean empl = new EmpBean(division,role,mgrId,bonus,income,leav,empId);
		
		AdminDAO adm = new AdminDAO();
		int p = adm.executeModify(empl);
		
		if(p>0){
			request.setAttribute("Message", "Succesfully updated");	
			//response.sendRedirect("http://localhost:9090/ERP_model/ListServlet?active=View+InActive+Employees");
//			response.sendRedirect("listView.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("Message", "Unable to update");
			RequestDispatcher rd = request.getRequestDispatcher("admin_main.jsp");
			rd.forward(request, response);
//			response.sendRedirect("admin_main.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
