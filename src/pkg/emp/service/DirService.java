package pkg.emp.service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import pkg.model.AccessBean;
import pkg.model.FileBean;
import pkg.model.dao.DbDAO;
import pkg.model.dao.MgrDAO;

public class DirService {
	private ResultSet dirs = null;
    MgrDAO mgr = new MgrDAO();
    List<AccessBean> list = new ArrayList<AccessBean>();
    
    public List <AccessBean> changePermissionList(int empId){
   	 ResultSet res = null;
   	 
   	 
   	 String query = "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
   	 		+ "from folder f, userbean u where f.empId="+empId+" and u.empId = f.empId "
   	 				+ "and f.permission in ('default','protected','public')";
   	 
   	 res = mgr.executeFetch(query);
   	 
   	 try {
			while(res.next()){
			 System.out.println(res.getString("dname"));
			 
			 AccessBean ab = new AccessBean();
			 ab.setDirId(res.getInt("dirId"));
			 ab.setDirName(res.getString("dname"));
			 ab.setPermission(res.getString("permission"));
			 ab.setEmpId(res.getInt("empId"));
			 ab.setEmpfname(res.getString("firstname"));
			 ab.setEmplname(res.getString("lastname"));
			 
			 list.add(ab);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
   	changePermission(empId);
   	  return list;
    }
    
    public void changePermission(int empId){
      	 ResultSet res = null;
      	 
      	 
      	 String query = "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
      	 		+ "from folder f, userbean u, employee e where e.empId="+empId+" and f.empId = e.superId and u.empId = f.empId "
      	 				+ "and f.permission in ('default','protected') and f.modlevel >= e.level";
      	 
      	 res = mgr.executeFetch(query);
      	 
      	 try {
   			while(res.next()){
   			 System.out.println(res.getString("dname"));
   			 
   			 AccessBean ab = new AccessBean();
   			 ab.setDirId(res.getInt("dirId"));
   			 ab.setDirName(res.getString("dname"));
   			 ab.setPermission(res.getString("permission"));
   			 ab.setEmpId(res.getInt("empId"));
   			 ab.setEmpfname(res.getString("firstname"));
   			 ab.setEmplname(res.getString("lastname"));
   			 
   			 list.add(ab);
   			 }
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}
    	 
      	 String sql = "select e.empId, e.superId "
     	 		+ "from employee e where e.empId="+empId;
     	 
     	 res = mgr.executeFetch(sql);
     	 
     	 try {
 			while(res.next()){
 			 System.out.println(res.getInt("empId"));			 
 			changePermission(res.getInt("superId"));
 			 }
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 
       }
    
    public boolean updatePermissionLevel(int empId, int dirId, String perm){
    	String sql = "select level from employee where empId="+empId;
    	int lev = 0;
    	dirs = mgr.executeFetch(sql);
    	
    	try {
			if(dirs.next()){
				lev = dirs.getInt("level");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	int c = checkPermission(dirId,perm);
    	int y = 0;
    	
    	if(c == 1 || c == 2){
    	String query = "update folder set modlevel="+lev+", chld_perm = permission, permission ='"+perm+"' where dirId="+dirId;
    	 y = mgr.updateQuery(query);
    	}
    	
    	if(y>0){
    		return true;
    	}
    	return false;
    	
    }
    
    public int checkPermission(int dirId, String perm){
    	String sql ="Select permission from folder where dirId="+dirId;
    	
    	dirs = mgr.executeFetch(sql);
    	try {
			if(dirs.next()){
				if((dirs.getString("permission").equals("default") || dirs.getString("permission").equals("protected")) && perm.equals("private")){
					return 1;
				}else if(dirs.getString("permission").equals("public")){
					return 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    	
    }
    
    public List <AccessBean> displayATE(int empId){
    	String query = "select f.dirId, f.dname, f.permission "
       	 		+ "from folder f where f.empId="+empId+" and f.permission = 'protected'";
       	 
       	 dirs = mgr.executeFetch(query);
       	 
       	 try {
    			while(dirs.next()){
    			 System.out.println(dirs.getString("dname"));
    			 
    			 AccessBean ab = new AccessBean();
    			 ab.setDirId(dirs.getInt("dirId"));
    			 ab.setDirName(dirs.getString("dname"));
    			 ab.setPermission(dirs.getString("permission"));
    			 
    			 list.add(ab);
    			 }
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
       	  return list;
    	
    }

    public boolean allowATE(int ateId, int dirId){
    	String sql = "insert into permission(dirId,ateId) value("+dirId+","+ateId+")";
    	int a = mgr.updateQuery(sql);
    	
    	if(a>0){
    		return true;
    	}
		return false;
    	
    }
    
    public List <FileBean> fileLists(int dirId){
    	String sql = "Select * from filestore where dirId="+dirId;
    	List<FileBean> files = new ArrayList<FileBean>();
    	
    	dirs = mgr.executeFetch(sql);
    	
    	try {
			if(dirs.next()){
				FileBean fb = new FileBean(dirs.getInt(1), dirs.getInt(2), dirs.getString(3), dirs.getBlob(4), dirs.getString(5), dirs.getString(6));
				files.add(fb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return files;
    	
    }
    
    public int uploadFile(FileBean fb, InputStream in){
    	int fi = 0;
    	/*String sql = "insert into filestore(dirId,filename,files,desp,typeformat) "
    			+ "values("+fb.getDirId()+",'"+fb.getFilenm()+"',"+in+",'"+fb.getDescription()+"','"+fb.getFormatype()+"')";
    	*/
    	try {
			Connection connect = DbDAO.connect();
			java.sql.PreparedStatement ps = connect.prepareStatement("insert into filestore(dirId,filename,files,desp,typeformat)"
					+ "values(?,?,?,?,?)");
			ps.setInt(1, fb.getDirId());
			ps.setString(2, fb.getFilenm());
			ps.setBlob(3, in);
			ps.setString(4, fb.getDescription());
			ps.setString(5, fb.getFormatype());
			
			fi = ps.executeUpdate();
			connect.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    	return fi;
    }
}
