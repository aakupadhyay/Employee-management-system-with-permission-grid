package pkg.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pkg.model.AccessBean;
import pkg.model.DirBean;
import pkg.model.dao.MgrDAO;
import pkg.model.dao.UserDAO;

public class MgrService {
     private ResultSet reset = null;
     MgrDAO mgr = new MgrDAO();
     List<AccessBean> list = new ArrayList<AccessBean>();
     
     public ResultSet RequestIndox(int empId){
    	 String sql = "select l.empId as EmpId,u.firstname as fn, u.lastname as ln, "
    	 		+ "l.startdate as StartDate, l.enddate as EndDate, l.leavetype as Leave_Type "
    	 		+ "from leavereq l, userbean u where l.mgrId="+empId+" and l.empId = u.empId and l.lstatus IS NULL";
    	 
    	if(reset !=null){
    		reset = null;
    	}
    	
    	reset = mgr.executeFetch(sql);
		return reset;
    	 
     }
	
     public boolean approveReq(int empId, String approval){
    	 String sql = "update leavereq set lstatus='"+approval+"' where empId="+empId;
    	 
    	 int s = mgr.updateQuery(sql);
    	 if(s>0){
    		 return true;
    	 }
		return false;
    	 
     }
     
     public ResultSet GetMembers(int mgrId){
    	 String sql = "Select * from bonus where mgrId="+mgrId;
    	 
    	 if(reset !=null){
     		reset = null;
     	}
     	
     	reset = mgr.executeFetch(sql);
		return reset;
    	 
     }
     
     public boolean UpdateBonus(int empId, float bonus){
    	 String sql = "Update employee set bonus="+bonus+"where empId="+empId;
    	 
    	 int b = mgr.updateQuery(sql);
    	 
    	 if(b>0){
    		 return true;
    	 }
		return false;
    	 
     }
     
     public void UpdateEmpLeave(int empId){
    	 String sql = "select l.startdate, l.enddate, e.leaveBalance from leavereq l, employee e where empId="+empId+"and l.empId=e.empId";
    	 int days = 0;
    	 int l =0;
    	 
    	 if(reset !=null){
      		reset = null;
      	}
      	
      	reset = mgr.executeFetch(sql);
      	
      	try {
			if(reset.next()){
				Date date1=new SimpleDateFormat("mm/dd/yyyy").parse(reset.getString(1));
				Date date2=new SimpleDateFormat("mm/dd/yyyy").parse(reset.getString(2));
				
				long milliseconds = Math.abs(date1.getTime() - date2.getTime());
				days = (int)(milliseconds / (1000 * 60 * 60 * 24));
			    l = reset.getInt(3);
				l = l+days;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
      	
      	UserDAO usr = new UserDAO();
      	int p = usr.executeUpdate(empId, l);
      	
      	if(p>0){
      		System.out.println("Updated declined leave");
      	}
     }
     
     public boolean CreateDir(DirBean dir){
    	 String sql = "insert into folder(dname,empId,permission) "
    	 		+ "values('"+dir.getDirName()+"',"+dir.getEmpId()+",'"+dir.getPermission()+"')";
    	 
    	 int i = mgr.updateQuery(sql);
    	 if(i>0){
    		 return true;
    	 }
    	 return false;
     }
     
     public void viewDirectories(int empId){
    	 ResultSet res = null;
    	 
    	 
    	 String query = "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
    	 		+ "from folder f, userbean u where f.empId="+empId+" and u.empId = f.empId";
    	 
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
//			 AccessStore(ab);
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	 
    	 String sql = "select e.empId, e.superId "
    	 		+ "from employee e where e.superId="+empId;
    	 
    	 res = mgr.executeFetch(sql);
    	 
    	 try {
			while(res.next()){
			 System.out.println(res.getInt("empId"));			 
			 viewDirectories(res.getInt("empId"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}	
    	 
     }
     
     public void viewATE(int empId){
    	 ResultSet r = null;
    	 
    	 String sql = "select f.empId, a.dirId, a.dname, a.creater_fn, a.creater_ln, f.permission "
    	 		+ "from erp.folder f, erp.access a where a.ateId ="+empId
    	 		+ " and f.dirId = a.dirId";
    	 
    	 r = mgr.executeFetch(sql);
    	 
    	 try {
			while(r.next()){
			 AccessBean ab = new AccessBean();
			 ab.setDirId(r.getInt("dirId"));
			 ab.setDirName(r.getString("dname"));
			 ab.setPermission(r.getString("permission"));
			 ab.setEmpId(r.getInt("empId"));
			 ab.setEmpfname(r.getString("creater_fn"));
			 ab.setEmplname(r.getString("creater_ln"));
			 
			 list.add(ab);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
     public void viewDir(int empId){
    	 // directories available for view to employees
    	 ResultSet r = null;
    	 
    	 String sql = "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
    	 		+ "from folder f, userbean u, employee e where e.empId ="+empId+" and f.empId=e.superId "
    	 		+ "and u.empId = f.empId and f.permission in ('default','protected','public') and f.modlevel >= e.level"
    	 		+ " union "
    	 		+ "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
    	 		+ "from folder f, userbean u, employee e where e.empId ="+empId+" and f.empId=e.superId "
    	 		+ "and u.empId = f.empId and f.permission in ('default','protected','public') and f.modlevel is null";
    	 
    	 r = mgr.executeFetch(sql);
    	 
    	 try {
			while(r.next()){
			 AccessBean ab = new AccessBean();
			 ab.setDirId(r.getInt("dirId"));
			 ab.setDirName(r.getString("dname"));
			 ab.setPermission(r.getString("permission"));
			 ab.setEmpId(r.getInt("empId"));
			 ab.setEmpfname(r.getString("firstname"));
			 ab.setEmplname(r.getString("lastname"));
			 
			 list.add(ab);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 String query = "select e.empId, e.superId "
     	 		+ "from employee e where e.empId="+empId;
     	 
     	 r = mgr.executeFetch(query);
     	 
     	 try {
 			while(r.next()){
 			 System.out.println(r.getInt("superId"));			 
 			  viewDir(r.getInt("superId"));
 			 }
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}	
     }
     
     public void publicDir(int empId){
    	 // directories available for view to employees
    	 ResultSet r = null;
    	 
    	 String sql = "select f.dirId, f.dname, f.permission, u.empId, u.firstname, u.lastname "
    	 		+ "from folder f, userbean u where f.permission ='public' and u.empId = f.empId";
    	 
    	 r = mgr.executeFetch(sql);
    	 
    	 try {
			while(r.next()){
			 AccessBean ab = new AccessBean();
			 ab.setDirId(r.getInt("dirId"));
			 ab.setDirName(r.getString("dname"));
			 ab.setPermission(r.getString("permission"));
			 ab.setEmpId(r.getInt("empId"));
			 ab.setEmpfname(r.getString("firstname"));
			 ab.setEmplname(r.getString("lastname"));
			 
			 list.add(ab);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
     }
     
     public List <AccessBean> showList() throws SQLException{
    	 List<AccessBean> dirlist = list; 	 
    	 return dirlist;    	 
     }
     
}
