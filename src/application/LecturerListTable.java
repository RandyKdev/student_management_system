package application;

public class LecturerListTable {
	public String name;
	public String field;
	public String level;
	public int lecturer_id;
	public LecturerListTable(String name, String field, String level, int lecturer_id) {
		super();
		this.name = name;
		this.field = field;
		this.level = level;
		this.lecturer_id = lecturer_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getLecturer_id() {
		return lecturer_id;
	}
	public void setLecturer_id(int lecturer_id) {
		this.lecturer_id = lecturer_id;
	}
}