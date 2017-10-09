package pkg.emp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkg.emp.service.DirService;
import pkg.model.FileBean;

/**
 * Servlet implementation class FileListServlet
 */
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int dirId = Integer.parseInt(request.getParameter("dir"));
		List<FileBean> files = new ArrayList<FileBean>();
		
		DirService dirs = new DirService();
		files = dirs.fileLists(dirId);
		
		request.setAttribute("filelist", files);
		session.setAttribute("dirId", dirId);
		RequestDispatcher rd = request.getRequestDispatcher("DirPage.jsp");
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
