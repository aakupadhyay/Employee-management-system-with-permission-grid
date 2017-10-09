package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.DirService;

/**
 * Servlet implementation class ChangeServlet
 */
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("emp"));
		int dirId = Integer.parseInt(request.getParameter("dir"));
		String perm = request.getParameter("permission");
		
		DirService dir = new DirService(); 
		boolean done = dir.updatePermissionLevel(empId, dirId, perm);
		
		if(done){
			request.setAttribute("dirMsg", "Changed Permission");
			RequestDispatcher rd= request.getRequestDispatcher("ChangePerm.jsp");
	        rd.forward(request, response);
	        
		}else{
			request.setAttribute("dirMsg", "Permission Change restricted to Private");
			RequestDispatcher rd= request.getRequestDispatcher("ChangePerm.jsp");
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
