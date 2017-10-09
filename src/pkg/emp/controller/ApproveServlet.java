package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.MgrService;

/**
 * Servlet implementation class ApproveServlet
 */
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId = Integer.parseInt(request.getParameter("empId"));
		String approval = request.getParameter("approve");
		boolean approved;
		MgrService srv = new MgrService();
		
		if(approval.equals("Approve")){
			approved = srv.approveReq(empId,approval);
			
			if(approved){
				request.setAttribute("appMessage", "Leave successfully approved");
				RequestDispatcher rd= request.getRequestDispatcher("reqInbox.jsp");
		        rd.forward(request, response);
			}
		}else if(approval.equals("Decline")){
			approved = srv.approveReq(empId, approval);
			srv.UpdateEmpLeave(empId);
			
			if(approved){
				request.setAttribute("appMessage", "Leave Declined");
				RequestDispatcher rd= request.getRequestDispatcher("reqInbox.jsp");
		        rd.forward(request, response);
			}
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
