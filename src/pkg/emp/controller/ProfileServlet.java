package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.emp.service.UserService;
import pkg.model.UserBean;
import pkg.model.dao.UserDAO;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String email = request.getParameter("mail");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
		//String usernm = request.getParameter("user");
		int empId = Integer.parseInt(request.getParameter("emp"));
		
		UserBean emp = new UserBean();
		emp.setEmpID(empId);
		//emp.setUsername(usernm);
		emp.setFirstname(fn);
		emp.setLastname(ln);
		emp.setAddress(addr);
		emp.setPhone(phone);
		emp.setEmail(email);
		
		UserDAO usr = new UserDAO();
		int i = usr.executeModify(emp);
		UserService serv = new UserService();
		ResultSet rs = serv.ModifyProfile(empId);
		boolean navigate = false;

		if (i > 0) {
			try {
				if(rs.next()){
					session.setAttribute("Fn", rs.getString("firstname"));
					session.setAttribute("Ln", rs.getString("lastname"));
					session.setAttribute("ad", rs.getString("address"));
					session.setAttribute("ph", rs.getString("phone"));
					session.setAttribute("mail", rs.getString("email"));
					navigate = serv.ValidateMgr(rs.getString("username"), rs.getString("pwd"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(navigate){
				request.setAttribute("Message", "Successfully updated");
				RequestDispatcher rd = request.getRequestDispatcher("/mgr_main.jsp");
				rd.forward(request, response);
			}
			else{
			request.setAttribute("Message", "Successfully updated");
			RequestDispatcher rd = request.getRequestDispatcher("/emp_main.jsp");
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
