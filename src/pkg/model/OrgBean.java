package pkg.model;

public class OrgBean{
	private int empID;
	private String firstname;
	private String lastname;
	private String div_name;
	private String role;
	private float bonus;
	private double income;
	private int leaveBal;
	private int superId;
    private String supervisor_fname;
    private String supervisor_lname;
    
    
	public OrgBean(int empID, String firstname, String lastname, String div_name, String role, float bonus,
			double income, int leaveBal, int superId, String supervisor_fname, String supervisor_lname) {
		this.empID = empID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.div_name = div_name;
		this.role = role;
		this.bonus = bonus;
		this.income = income;
		this.leaveBal = leaveBal;
		this.superId = superId;
		this.supervisor_fname = supervisor_fname;
		this.supervisor_lname = supervisor_lname;
	}


	public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDiv_name() {
		return div_name;
	}


	public void setDiv_name(String div_name) {
		this.div_name = div_name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public float getBonus() {
		return bonus;
	}


	public void setBonus(float bonus) {
		this.bonus = bonus;
	}


	public double getIncome() {
		return income;
	}


	public void setIncome(double income) {
		this.income = income;
	}


	public int getLeaveBal() {
		return leaveBal;
	}


	public void setLeaveBal(int leaveBal) {
		this.leaveBal = leaveBal;
	}


	public int getSuperId() {
		return superId;
	}


	public void setSuperId(int superId) {
		this.superId = superId;
	}


	public String getSupervisor_fname() {
		return supervisor_fname;
	}


	public void setSupervisor_fname(String supervisor_fname) {
		this.supervisor_fname = supervisor_fname;
	}


	public String getSupervisor_lname() {
		return supervisor_lname;
	}


	public void setSupervisor_lname(String supervisor_lname) {
		this.supervisor_lname = supervisor_lname;
	}

 
}
