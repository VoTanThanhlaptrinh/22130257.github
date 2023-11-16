package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfPublications {
	private List<Publications> list = new ArrayList<Publications>();

	public ListOfPublications(List<Publications> list) {
		super();
		this.list = list;
	}

	public double getCostAllPublications() {
		double cost = 0;
		for (Publications publications : list) {
			cost += publications.getCost();
		}
		return cost;
	}

	public boolean isContainMagazineGivenName(String otherName) {
		for (Publications publications : list) {
			if (publications.containName(otherName))
				return true;
		}
		return false;
	}

	public Publications findReferenceHaveMaxPages() {
		Publications max = null;
		for (Publications publications : list) {
			if (!publications.isPubliccations()) {
				if (max == null) {
					max = publications;
				}
				if(max.maxPagesChapter()<publications.maxPagesChapter()) {
					max = publications;
				}
			}
		}
		return max;
	}

	public ArrayList<Publications> listMagazine(int yearGiven) {
		ArrayList<Publications> arrayList = new ArrayList<Publications>();
		for (Publications publications : list) {
			if (publications.sameMagazineGivenYear(yearGiven)) {
				arrayList.add(publications);
			}
		}
		return arrayList;
	}

	public List<Publications> sort() {
		Collections.sort(list, new Comparator<Publications>() {

			@Override
			public int compare(Publications o1, Publications o2) {
				int a = o1.compareTitle(o2), b = o1.comparePublishYear(o2);
				if (a != 0) {
					return a;
				} else {
					return b;
				}
			}
		});
		return list;
	}

	public Map<Integer, Integer> thongKe() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Publications publications : list) {
			if (!map.containsKey(publications.publishingYear)) {
				map.put(publications.publishingYear, 1);
			} else {
				map.put(publications.publishingYear, map.get(publications.publishingYear) + 1);
			}
		}
		return map;
	}
}
