package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.DirService;

/**
 * Servlet implementation class AllowServlet
 */
public class AllowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ateId = Integer.parseInt(request.getParameter("ate"));
		int dirId = Integer.parseInt(request.getParameter("dir"));
		
		DirService dirs = new DirService();
		boolean al = dirs.allowATE(ateId, dirId);
		
		if(al){
			request.setAttribute("ateMsg", "Allowed user");
			RequestDispatcher rd= request.getRequestDispatcher("accessATE.jsp");
	        rd.forward(request, response);
		}else{
			request.setAttribute("ateMsg", "Unable to allow user");
			RequestDispatcher rd= request.getRequestDispatcher("accessATE.jsp");
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
