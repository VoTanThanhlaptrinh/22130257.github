package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course courseMax = null;
		for (Course course : courses) {
			if (course.isType("Thuc hanh")) {
				if (courseMax == null) {
					courseMax = course;
				} else if (courseMax.getNumOfStudents() < course.getNumOfStudents()) {
					courseMax = course;
				}

			}
		}
		return courseMax;

	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> map = new HashMap<Integer, List<Student>>();
		for (Course course : courses) {
			Map<Integer, List<Student>> map1 = course.getGroupStudentByYear();
			for (Map.Entry<Integer, List<Student>> entry : map1.entrySet()) {
				List<Student> list = entry.getValue();
				if(map.containsKey(entry.getKey())) {
					for (Student student : map.get(entry.getKey())) {
						if(!list.contains(student)) {
							list.add(student);
						}
					}
				}
				map.put(entry.getKey(), list);
			}
		}
		return map;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> set = new TreeSet<Course>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				// TODO Auto-generated method stub
				int size1 = o1.getStudents().size(), size2 = o2.getStudents().size();
				if (size1 != size2) {
					return size1 - size2;
				} else {
					return o1.getId().compareToIgnoreCase(o2.getId());
				}

			}
		});
		for (Course course : courses) {
			if (course.isType(type)) {
				set.add(course);
			}
		}
		return set;
	}

}
