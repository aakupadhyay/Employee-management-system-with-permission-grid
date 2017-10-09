package pkg.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.model.dao.UserDAO;

/**
 * Servlet implementation class RefreshServlet
 */
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usernm = request.getParameter("user");
		String usrgp = request.getParameter("usrtype");
		String sql = "update userbean set usertype='"+usrgp+"' where empId ="+usernm;
		int i = UserDAO.exeQuerUpd(sql);
		
		if(i>0){
			/*session.setAttribute("Fn", rs.getString("firstname"));
			session.setAttribute("Ln", rs.getString("lastname"));
			session.setAttribute("ad", rs.getString("address"));
			session.setAttribute("ph", rs.getString("phone"));
			session.setAttribute("mail", rs.getString("email"));
			response.sendRedirect("emp_main.jsp");*/
			session.setAttribute("send", "Successfully Updated");
			//response.sendRedirect("/user_list.jsp");
			response.sendRedirect("http://localhost:9090/ERP_model/UserType");
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
