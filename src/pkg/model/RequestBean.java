package pkg.model;

public class RequestBean {
	int empId;
	String empfirtnm;
	String emplastnm;
	int mgrId;
	String startdate;
	String enddate;
	String leave_type;
	String status;
	
	public RequestBean(int empId, String empfirtnm, String emplastnm, int mgrId, String startdate, String enddate,
			String leave_type) {
		super();
		this.empId = empId;
		this.empfirtnm = empfirtnm;
		this.emplastnm = emplastnm;
		this.mgrId = mgrId;
		this.startdate = startdate;
		this.enddate = enddate;
		this.leave_type = leave_type;
		
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpfirtnm() {
		return empfirtnm;
	}
	public void setEmpfirtnm(String empfirtnm) {
		this.empfirtnm = empfirtnm;
	}
	public String getEmplastnm() {
		return emplastnm;
	}
	public void setEmplastnm(String emplastnm) {
		this.emplastnm = emplastnm;
	}
	public int getMgrId() {
		return mgrId;
	}
	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
