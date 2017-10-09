package pkg.emp.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import pkg.emp.service.DirService;
import pkg.model.FileBean;

@MultipartConfig(maxFileSize = 1699999999)
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("dir"));
		
		    int dirId = Integer.parseInt(request.getParameter("dir"));
			String filename = request.getParameter("filename");
			Part filepart = request.getPart("media");
			String desp = request.getParameter("comment");
			
			System.out.println("Contains:"+filepart+" "+desp);
			
			FileBean files = new FileBean();
			InputStream in = null;
			
			 if(filepart!=null){
				 in = filepart.getInputStream();				 
				 files.setDirId(dirId);
				 files.setFilenm(filename);
//				 files.setFiles(in);
				 files.setDescription(desp);
				 files.setFormatype(filepart.getContentType());
			 }
			 
			 DirService dirs = new DirService();
			 int returnStmt = dirs.uploadFile(files, in);
			 
				if(returnStmt == 0){
					request.setAttribute("fileMsg", "Unable to upload file, please try again");
					RequestDispatcher rd = request.getRequestDispatcher("Addfile.jsp");
					rd.forward(request, response);
					
				}else{
					/*request.setAttribute("fileMsg", "Successfully uploaded file");
					RequestDispatcher rd = request.getRequestDispatcher("DirPage.jsp");
					rd.forward(request, response);*/
					response.sendRedirect("http://localhost:9090/ERP_model/FileList?dir="+dirId);
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
