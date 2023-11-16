package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecture;

	public Course(String id, String title, String type, List<Student> students, String lecture) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecture = lecture;
	}

	public int getNumOfStudents() {
		return students.size();
	}

	public String getId() {
		return id;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, lecture, students, title, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(id, other.id) && Objects.equals(lecture, other.lecture)
				&& Objects.equals(students, other.students) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type);
	}

	public Map<Integer, List<Student>> getGroupStudentByYear() {
		Map<Integer, List<Student>> map = new HashMap<Integer, List<Student>>();
		for (Student st : students) {
			int key = st.getYear();
			List<Student> list = new ArrayList<Student>();
			if (map.containsKey(key)) {
				list = map.get(key);
			}
			if (!list.contains(st)) {
				list.add(st);
			}
			map.put(key, list);
		}
		return map;

	}

	public boolean isType(String otherType) {
		return type.equalsIgnoreCase(otherType);
	}

	public void string() {
		System.out.printf("id:%-7s title:%-20s Type:%-12s Lecture:%-10s%n", id, title, type, lecture);
		System.out.println("List students:");
		System.out.printf("%-6s %-6s %-6s%n", "ID", "Name", "Year");
		for (Student student : students) {
			student.string();
		}
	}
}
