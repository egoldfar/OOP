package termproject;



public class Employee extends Person {
	
	private String employeeID;
	private String role;
	private String department;

	public Employee(String firstName, String lastName, Gender gender, Address address, String birthdate,
					String employeeID, String role, String department) {
		super(firstName,lastName,gender,address, birthdate);
		this.employeeID = employeeID;
		this.role = role;
		this.department = department;
	}
	
	public Employee(Employee e) {
		this(e.getFirstName(), e.getLastName(),e.getGender(),e.getAddress(),e.getBirthdate().toString(),
				 e.employeeID, e.role, e.department);
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if (o == null) return false;
		if (o instanceof Employee) {
			Employee compare = (Employee) o;
			if(this.employeeID.equals(compare.employeeID)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("Employee:\n");
		string.append(super.toString() + "\n");
		string.append("Employee ID: " + employeeID + "\n");
		string.append("Role:" + role + "\n");
		string.append("Department:" + department);
		return string.toString();
	}
	
} //Close Class
