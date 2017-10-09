package pkg.model;

public class EmpBean extends UserBean {
	private String div_name;
	private String role;
	private int superId;
	private float bonus;
	private double income;
	private int leaveBal;
	private int empId;
	
	public EmpBean(){};

	public EmpBean(String div_name, String role, int superId, float bonus, double income, int leaveBal, int empId) {
		this.div_name = div_name;
		this.role = role;
		this.superId = superId;
		this.bonus = bonus;
		this.income = income;
		this.leaveBal = leaveBal;
		this.empId = empId;
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

	public int getSuperId() {
		return superId;
	}

	public void setSuperId(int superId) {
		this.superId = superId;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	

}
