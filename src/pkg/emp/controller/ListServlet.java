package pkg.emp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.emp.service.AdminService;
import pkg.model.OrgBean;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String value = request.getParameter("active");
		
		List<OrgBean> list = new ArrayList<OrgBean>();
		AdminService admin = new AdminService();
		
		if(value.equals("View Active Employees")){
			try {
				list = admin.ViewActiveEmployees();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(value.equals("View InActive Employees")){
			try {
				list = admin.ViewInActiveEmployees();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("list",list);
		response.sendRedirect("listView.jsp");
        System.out.println(list);
        
        /*RequestDispatcher rd= request.getRequestDispatcher("listView.jsp");
        rd.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
