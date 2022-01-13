package application;

public class Course {
	public String code;
	public String title;
	public String department;
	public int credit_value;
	public int lecturer;
	public Course(String code, String title, String department, int credit_value, int lecturer) {
		super();
		this.code = code;
		this.title = title;
		this.department = department;
		this.credit_value = credit_value;
		this.lecturer = lecturer;
	}
	
}
