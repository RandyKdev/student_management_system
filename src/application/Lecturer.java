package application;

public class Lecturer {
	public int uid;
	public String name;
	public String level;
	public String field;
	public Lecturer(int uid, String name, String level, String field) {
		super();
		this.uid = uid;
		this.name = name;
		this.level = level;
		this.field = field;
	}
	public Lecturer(int uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}
}
