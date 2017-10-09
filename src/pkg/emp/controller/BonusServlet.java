package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.emp.service.MgrService;
import pkg.model.BonusBean;

/**
 * Servlet implementation class BonusServlet
 */
public class BonusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BonusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int empId = Integer.parseInt(request.getParameter("emp"));
		MgrService srv = new MgrService();
//		srv.ViewDirectories(empId);
		ResultSet resu = srv.GetMembers(empId);
		List<BonusBean> list = new ArrayList<BonusBean>();
		
		try {
			while(resu.next()){
				BonusBean bb = new BonusBean(resu.getInt(1),resu.getInt(2),resu.getString(3),resu.getString(4),resu.getFloat(5));
				list.add(bb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("teamlist", list);
		response.sendRedirect("TeamMember.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
