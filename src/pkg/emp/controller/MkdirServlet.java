package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.MgrService;
import pkg.model.DirBean;

/**
 * Servlet implementation class MkdirServlet
 */
public class MkdirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dirnm = request.getParameter("Dname");
		String perm = request.getParameter("permission");
		int empId = Integer.parseInt(request.getParameter("empId"));
		
		DirBean dir = new DirBean();
		dir.setDirName(dirnm);
		dir.setEmpId(empId);
		dir.setPermission(perm);
		
		MgrService srv = new MgrService();
		
		boolean created = srv.CreateDir(dir);
		
		if(created){
			request.setAttribute("DirMessage", "Directory created succesfully");
			RequestDispatcher rd= request.getRequestDispatcher("CreateDir.jsp");
	        rd.forward(request, response);
		}else{
			request.setAttribute("DirMessage", "Couldn't create directory");
			RequestDispatcher rd= request.getRequestDispatcher("CreateDir.jsp");
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
