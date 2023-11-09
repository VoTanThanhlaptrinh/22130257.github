package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>(); 

//	 Load data from fileName into the above map (containing <word, its occurences>)
//	 using the guide given in TestReadFile.java
	
	public void loadData() throws FileNotFoundException {
		// TODO
		Scanner scanner = new Scanner(new File(fileName));
		while (scanner.hasNext()) {
			String str = scanner.next();
			if (!map.containsKey(str)) {
				map.put(str, 1);
			} else {
				map.put(str, map.get(str) + 1);
			}
		}
	}
	public MyWordCountApp() throws FileNotFoundException {
		super();
		loadData();
	}
	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countDistinct() {
		int count =0;
		Iterator<String> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			if(iterator.next().compareTo("")!=0) {
				count++;
			}
		}
		return count;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		int count = 0;
		for (Integer integer : map.values()) {
			if(integer == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() throws FileNotFoundException {
		map = new TreeMap<String, Integer>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		loadData();
		// TODO
	}
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp a = new MyWordCountApp();
		System.out.println(a.map);
		System.out.println(a.countDistinct());
		a.printWordCounts();
		a.printWordCountsAlphabet();
		System.out.println(a.map);
	}
}
