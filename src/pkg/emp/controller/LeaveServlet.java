package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.UserService;
import pkg.model.RequestBean;

/**
 * Servlet implementation class LeaveServlet
 */
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameterNames().hasMoreElements();
		/*while(request.getParameterNames().hasMoreElements()){
		 String key = request.getParameterNames().nextElement();
		 String value = request.getParameter(key);
		System.out.println("SAVIO JOE="+key+","+value);
		}*/
		
		int empId = Integer.parseInt(request.getParameter("empId"));
		int mgrId = Integer.parseInt(request.getParameter("mgrId"));
		String startdate = request.getParameter("from");
		String enddate = request.getParameter("to");
		String type = request.getParameter("type");
		String firstnm = request.getParameter("first");
		String lastnm = request.getParameter("last");
		
		RequestBean req = new RequestBean(empId,firstnm,lastnm,mgrId,startdate,enddate,type);
		
		UserService serv = new UserService();
		boolean raised = serv.InsertRequest(req);
		
		if(raised){
			request.setAttribute("reqMes", "Successfully raised leave");
			RequestDispatcher rd = request.getRequestDispatcher("/Raise_leave.jsp");
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
