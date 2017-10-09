package pkg.emp.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.emp.service.DirService;
import pkg.model.AccessBean;
import pkg.model.dao.MgrDAO;

/**
 * Servlet implementation class AccessServlet
 */
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Map<Integer,String> m1 = new HashMap<Integer,String>();
        String sql ="select empId,firstname,lastname from userbean";
        MgrDAO mgr = new MgrDAO();
        ResultSet rs = mgr.executeFetch(sql);
        
        try {
			while(rs.next()){
				m1.put(rs.getInt("empId"), rs.getString("firstname")+" "+rs.getString("lastname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.print(m1);
        
		int empId = Integer.parseInt(request.getParameter("emp"));
		
        DirService dirs = new DirService();
		List<AccessBean> list = new ArrayList<AccessBean>();
		
		list = dirs.displayATE(empId);
		
		session.setAttribute("atelist", list);
		session.setAttribute("map", m1);
		RequestDispatcher rd= request.getRequestDispatcher("accessATE.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
