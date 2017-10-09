package pkg.model;

public class UserBean {
	private int empID;
	private String firstname;
	private String lastname;
	private String address;
	private String phone;
	private String email;
	private String username;
	private String password;
	private String usertype;
	
	public boolean valid;
	
	   public UserBean() {}
	
	   public UserBean(int empId, String firstname, String lastname, String address, String phone, String email, String username,
				String password, String usrtype) {
		    this.empID = empId;
			this.firstname = firstname;
			this.lastname = lastname;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.username = username;
			this.password = password;
			this.usertype = usrtype;
		}

	public UserBean(String uname, String pwd) {
	      this.username = uname;
	      this.password = pwd;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}	
      
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

}
