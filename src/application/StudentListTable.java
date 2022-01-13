package application;

public class StudentListTable {
	public String name;
	public String department;
	public String cycle;
	public int status;
	public String qualification;
	public int student_id;
	public StudentListTable(int student_id, String name, int status, String department, String cycle, String qualification) {
		this.name = name;
		this.department = department;
		this.cycle = cycle;
		this.status = status;
		this.student_id = student_id;
		this.qualification = qualification;
	}

	
	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getStatus() {
		return status == 0 ? "Not Admitted" : "Admitted";
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
