package pkg.emp.controller;

import java.io.IOException;

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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usernm = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		
		 UserBean user = new UserBean();

		if (usernm.matches("[0-9]+") && pwd.matches("[a-zA-Z]+")) {
			user.setUsername(usernm);
			user.setPassword(pwd);
			
			UserDAO usr = new UserDAO();
			user = usr.login(user);
			UserService serv = new UserService();
			
			try {
				boolean valid = serv.ValidateUser(usernm, pwd);
				boolean valid_mgr = serv.ValidateMgr(usernm, pwd);
				boolean valid_adm = serv.ValidateAdmin(usernm, pwd);
				System.out.print("connected db");

				if(valid) {
					session.setAttribute("UserID", user.getEmpID());
					session.setAttribute("usrnm", user.getUsername());
					session.setAttribute("pwd", user.getPassword());
					session.setAttribute("Fn", user.getFirstname());
					session.setAttribute("Ln", user.getLastname());
					session.setAttribute("ad", user.getAddress());
					session.setAttribute("ph", user.getPhone());
					session.setAttribute("mail", user.getEmail());
					session.setAttribute("mgr", serv.ManagerID(user.getEmpID()));
					
					if(valid_mgr){
						response.sendRedirect("mgr_main.jsp");
					}else if(valid_adm){
						response.sendRedirect("admin_main.jsp");
					}else{
						response.sendRedirect("emp_main.jsp");
					}
					
				} else{
					session.invalidate();
					request.setAttribute("errorMessage", "Log In failed: User doesn't exists!");
					RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}

			} catch (Throwable theException) {
				System.out.println(theException);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid login Credentials");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
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
