package lab9;

import java.util.Objects;

public class Student {
	private String id;
	private String name;
	private int year;

	public Student(String id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && year == other.year;
	}

	public int getYear() {
		return year;
	}

	public void string() {
		 System.out.printf("%-6s %-6s %-6d%n",id ,name, year); 
	}
	public boolean hasSameYear(Integer otherYear) {
		return otherYear.equals(year);
	}
	
}
