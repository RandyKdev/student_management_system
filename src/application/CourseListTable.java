package application;

import database.lecturerDB;

public class CourseListTable {
	public String code;
	public String title;
	public String department;
	public int credit_value;
	public int lecturer;
	public int marks;
	
	public CourseListTable(String code, String title, int marks) {
		super();
		this.code = code;
		this.title = title;
		this.marks = marks;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public CourseListTable setMarks1(int marks) {
		this.marks = marks;
		return this;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getCredit_value() {
		return credit_value;
	}
	public void setCredit_value(int credit_value) {
		this.credit_value = credit_value;
	}
	public String getLecturer() {
		lecturerDB lecturerDb = new lecturerDB();
		return lecturerDb.getName(lecturer);
	}
	static public String getLecturer1(int lect) {
		lecturerDB lecturerDb = new lecturerDB();
		return lecturerDb.getName(lect);
	}
	public void setLecturer(int lecturer) {
		this.lecturer = lecturer;
	}
	public CourseListTable(String code, String title, String department, int credit_value, int lecturer) {
		super();
		this.code = code;
		this.title = title;
		this.department = department;
		this.credit_value = credit_value;
		this.lecturer = lecturer;
	}
	
	
}
