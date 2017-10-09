package pkg.model;

public class BonusBean {
	int empId;
	int mgrId;
    String empfirst;
    String emplast;
    float bonus;
    
	public BonusBean(int empId, int mgrId, String empfirst, String emplast, float bonus) {
		super();
		this.empId = empId;
		this.mgrId = mgrId;
		this.empfirst = empfirst;
		this.emplast = emplast;
		this.bonus = bonus;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getEmpfirst() {
		return empfirst;
	}

	public void setEmpfirst(String empfirst) {
		this.empfirst = empfirst;
	}

	public String getEmplast() {
		return emplast;
	}

	public void setEmplast(String emplast) {
		this.emplast = emplast;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
    
    

}
