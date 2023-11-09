package lab8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

//	 load words in the text file given by fileName and store into map by using add
//	 method in Task 2.1.
//	 Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {
		int count, index = 0;
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		while (true) {
			line = reader.readLine();
			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");
			count = index + tokens.countTokens();
			while (tokens.hasMoreTokens()) {
				index++;
				if (index == count) {
					add(tokens.nextToken(), -index);
				} else {
					add(tokens.nextToken(), index);
				}
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (!map.containsKey(word)) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(position);
			map.put(word, arrayList);
		} else {
			map.get(word).add(position);
		}
	}

//	 This method should display the words of the text file along with the
//	 positions of each word, one word per line, in alphabetical order
	public void displayWords() throws IOException {
		Map<String, ArrayList<Integer>> map1 = new TreeMap<String, ArrayList<Integer>>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			map1.put(s, map.get(s));
		}
		System.out.println("Word \t   WordPosition(s)");
		System.out.println("=========================");
		Iterator<String> iterator1 = map1.keySet().iterator();
		while (iterator1.hasNext()) {
			String str = iterator1.next();
			String other = "";
			ArrayList<Integer> list = map1.get(str);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				if (i == size - 1) {
					other += String.valueOf(list.get(i));
				} else {
					other += String.valueOf(list.get(i)) + ", ";
				}
			}
			if (str.length() > 6) {
				System.out.println(str + "\t" + other);
			} else {
				System.out.println(str + "\t\t" + other);
			}
		}
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Map<Integer, String> otherMap = new TreeMap<Integer, String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int n1 = o1, n2 = o2;
				return n1 * n1 - n2 * n2;
			}
		});
		Iterator<String> iterator = map.keySet().iterator();
		ArrayList<Integer> list;
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			list = map.get(str);
			for (Integer integer : list) {
				otherMap.put(integer, str);
			}
		}
		String result = "";
		for (Map.Entry<Integer, String> entry : otherMap.entrySet()) {
			Integer key = entry.getKey();
			String val = entry.getValue();
			if (key < 0) {
				val += "\n";
			} else {
				val += " ";
			}
			result += val;
		}
		System.out.println(result);
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		int max = 0;
		String result = "";
		for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			String key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			if(max < val.size()) {
				max = val.size();
				result = key;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		TextAnalyzer analyzer = new TextAnalyzer();
		analyzer.load("data/fit.txt");
		System.out.println(analyzer.map);
		analyzer.displayWords();
		analyzer.displayText();
		System.out.println(analyzer.mostFrequentWord());
	}
}
