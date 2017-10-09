package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.MgrService;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float bonus = Float.parseFloat(request.getParameter("bonus"));
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		MgrService srv = new MgrService();
		boolean add = srv.UpdateBonus(empId, bonus);
		
		if(add){
			request.setAttribute("Bonus", "Successfully Added");
			RequestDispatcher rd= request.getRequestDispatcher("TeamMember.jsp");
	        rd.forward(request, response);
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
