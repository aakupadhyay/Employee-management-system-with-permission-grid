package pkg.emp.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.model.dao.UserDAO;

/**
 * Servlet implementation class DownLoadServlet
 */
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int fileId = Integer.parseInt(request.getParameter("file"));
	    
	    String sql = "select * from filestore where fileId="+fileId;
	    UserDAO usr = new UserDAO();
	    
	    ResultSet rs = usr.executeFetch(sql);
		OutputStream o;
		
	    try {
		if(rs.next()){
			byte barray[] = rs.getBytes("files");
			response.setContentType(rs.getString("typeformat"));
			
//			response.setContentType("application/octet-stream");
			
			response.setHeader("Content-Disposition", "attachment; filename = "+rs.getString("filename"));	
			o = response.getOutputStream();
			o.write(barray);
			o.flush();
			o.close();
		}
		
    } catch (Exception e) {
        e.printStackTrace();
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
