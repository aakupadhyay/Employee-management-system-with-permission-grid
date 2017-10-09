package pkg.model;

public class DirBean {
	int dirId;
	String dirName;
	int empId;
	String permission;
	
	public DirBean(int dirId, String dir_name, int empId, String permission) {
		super();
		this.dirId = dirId;
		this.dirName = dir_name;
		this.empId = empId;
		this.permission = permission;
	}

	public DirBean() {}
		

	public int getDirId() {
		return dirId;
	}

	public void setDirId(int dirId) {
		this.dirId = dirId;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	

}
