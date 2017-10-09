package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.emp.service.UserService;
import pkg.model.EmpBean;
import pkg.model.UserBean;
import pkg.model.dao.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService serv = new UserService();
		int empID = serv.GenerateID();
		
		String usernm = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String fn = request.getParameter("fname");
		String ln = request.getParameter("lname");
		String email = request.getParameter("mail");
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");

		if (!(usernm.isEmpty()) || !(pwd.isEmpty()) || !(fn.isEmpty()) || !(ln.isEmpty()) || !(email.isEmpty()) || !(addr.isEmpty())) {
			if (usernm.matches("[0-9]+") && pwd.matches("[a-zA-Z]+")){
				UserBean emp = new UserBean();
				emp.setEmpID(empID);
				emp.setUsername(usernm);
				emp.setPassword(pwd);
				emp.setFirstname(fn);
				emp.setLastname(ln);
				emp.setAddress(addr);
				emp.setPhone(phone);
				emp.setEmail(email);
				emp.setUsertype("Emp");
				
				EmpBean empb = new EmpBean();
				empb.setEmpId(empID);
				
				System.out.println(empID);
                
				UserDAO usr = new UserDAO();
				int i = usr.registerUsers(emp);
				int a = usr.registerEmp(empb);

				if(i > 0 && a>0) {
					request.setAttribute("errorMessage", "Successfully registered");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);

				} else {
					request.setAttribute("errorMessage", "Failure in connection!");
					RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
					rd.forward(request, response);
				}
				} else {
				request.setAttribute("errorMessage", "Invalid login Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
			}
		}

		else {
			request.setAttribute("errorMessage", "Don't leave field empty!");
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
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
