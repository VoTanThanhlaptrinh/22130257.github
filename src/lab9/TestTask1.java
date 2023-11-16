package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTask1 {
	public static void main(String[] args) {
		Student st1 = new Student("001", "Thanh", 2020);
		Student st2 = new Student("002", "Huong", 2020);
		Student st3 = new Student("003", "Minh", 2021);
		Student st4 = new Student("004", "Tuan", 2022);
		Student st5 = new Student("005", "Linh", 2020);
		Student st6 = new Student("006", "Phong", 2021);
		Student st7 = new Student("007", "Mai", 2019);
		Student st8 = new Student("008", "Khanh", 2019);
		Student st9 = new Student("009", "Long", 2022);
		Student st10 = new Student("010", "Nhat", 2019);

		List<Student> ls1 = new ArrayList<Student>();
		ls1.add(st1);
		ls1.add(st2);
		ls1.add(st4);
		ls1.add(st5);

		List<Student> ls2 = new ArrayList<Student>();
		ls2.add(st3);
		ls2.add(st6);
		ls2.add(st7);
		ls2.add(st9);

		List<Student> ls3 = new ArrayList<Student>();
		ls3.add(st1);
		ls3.add(st4);
		ls3.add(st7);
		ls3.add(st10);
		ls3.add(st9);

		List<Student> ls4 = new ArrayList<Student>();
		ls4.add(st6);
		ls4.add(st8);
		ls4.add(st5);
		ls4.add(st7);

		Course cs1 = new Course("7710", "Cau truc du lieu", "Thuc hanh", ls1, "Thay Du");
		Course cs2 = new Course("7781", "Toan roi rac", "Ly thuyet", ls2, "Thay Viet");
		Course cs3 = new Course("5671", "Toan cao cap", "Ly thuyet", ls3, "Thay Quy");
		Course cs4 = new Course("8792", "Nhap mon tin hoc", "Thuc hanh", ls4, "Thay Linh");

		List<Course> list = new ArrayList<Course>();
		list.add(cs1);
		list.add(cs2);
		list.add(cs3);
		list.add(cs4);

		Faculty ft1 = new Faculty("CNTT", "Giang duong A", list);
		System.out.println("\tget Max Practical Course");
		ft1.getMaxPracticalCourse().string();
		System.out.println("\tgroup Students By Year");
		Map<Integer, List<Student>> map = ft1.groupStudentsByYear();
		for (Map.Entry<Integer, List<Student>> entry : map.entrySet()) {
			Integer year = entry.getKey();
			List<Student> val = entry.getValue();
			System.out.println(year);
			System.out.printf("%-6s %-6s %-6s%n", "ID", "Name", "Year");
			for (Student st : val) {
				st.string();
			}
			System.out.println();
		}
		System.out.println("\tFilter Courses");
		Iterator<Course> iterator = ft1.filterCourses("Thuc hanh").iterator();
		while (iterator.hasNext()) {
			Course course = (Course) iterator.next();
			course.string();
			System.out.println();
		}
	}
}
