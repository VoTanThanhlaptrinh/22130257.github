package lab9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestTask2 {
	public static void main(String[] args) {
		Chapter ch11 = new Chapter("Introduction", 4);
		Chapter ch12 = new Chapter("Python and required packages", 10);
		Chapter ch13 = new Chapter("Smoothing and blurring", 30);
		Chapter ch14 = new Chapter("Gradients and edge detection", 50);
		Chapter ch15 = new Chapter("Histograms", 26);
		Chapter ch16 = new Chapter("where to now?", 34);
		Chapter ch21 = new Chapter("Network Security Architecture", 30);
		Chapter ch22 = new Chapter("Perimeter Security", 50);
		Chapter ch23 = new Chapter("Augmenting Depth of Defense", 76);
		Chapter ch24 = new Chapter("Security Inside the Perimeter", 84);

		List<Chapter> referenceChapters1 = new ArrayList<Chapter>();
		referenceChapters1.add(ch11);
		referenceChapters1.add(ch12);
		referenceChapters1.add(ch13);
		referenceChapters1.add(ch14);
		referenceChapters1.add(ch15);
		referenceChapters1.add(ch16);

		List<Chapter> referenceChapters2 = new ArrayList<Chapter>();
		referenceChapters2.add(ch21);
		referenceChapters2.add(ch22);
		referenceChapters2.add(ch23);
		referenceChapters2.add(ch24);

		Publications ref1 = new Reference("Practical Python and OpenCV", 154, 2016, "Dr. Adrian Rosebrock", 30.0,
				"Education", referenceChapters1);
		Publications ref2 = new Reference("CCNA Security", 240, 2022, "Author 2", 35.5, "Education",
				referenceChapters2);

		Publications mag1 = new Magazine("Magazine 1", 50, 2021, "Editor 1", 15.0, "Magazine A");
		Publications mag2 = new Magazine("Magazine 2", 60, 2010, "Editor 2", 18.5, "Magazine B");
		Publications mag3 = new Magazine("Magazine 3", 70, 2022, "Editor 3", 20.0, "Magazine C");
		Publications mag4 = new Magazine("Magazine 4", 40, 2022, "Editor 4", 12.5, "Magazine D");
		Publications mag5 = new Magazine("Magazine 5", 55, 2000, "Editor 5", 16.0, "Magazine E");

		List<Publications> publications = new ArrayList<Publications>();
		publications.add(mag1);
		publications.add(mag2);
		publications.add(ref1);
		publications.add(mag3);
		publications.add(mag4);
		publications.add(ref2);
		publications.add(mag5);
		ListOfPublications listOfPublications = new ListOfPublications(publications);

		for (Publications publications2 : publications) {
			if (publications2.isPubliccations()) {
				System.out.println(publications2.title + ": is Magazine");
			} else {
				System.out.println(publications2.title + ": is Reference");
			}
		}
		System.out.println();
		for (Publications publications2 : publications) {
			if (publications2.isMagazine10Year()) {
				System.out.println(publications2.title + ": is Magazine 10 year");
			} else {
				System.out.println(publications2.title + ": is not Magazine 10 year");
			}
		}
		System.out.println(ref1.isSameTypeAndAuthor(ref2));
		System.out.println(mag1.isSameTypeAndAuthor(ref2));
		System.out.println(mag1.isSameTypeAndAuthor(mag1));
		System.out.println(ref1.isSameTypeAndAuthor(mag3) + "\n");
		System.out.println(listOfPublications.getCostAllPublications());
		System.out.println(listOfPublications.isContainMagazineGivenName("Magazine A"));
		System.out.println(listOfPublications.listMagazine(2022).size());
		System.out.println(listOfPublications.findReferenceHaveMaxPages().title);
		listOfPublications.sort();
		for (Publications publications2 : publications) {
			System.out.println(publications2.author);
		}

		for (Map.Entry<Integer, Integer> entry : listOfPublications.thongKe().entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("" + key + ": " + val);
		}
	}
}
