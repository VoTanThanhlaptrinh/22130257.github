package lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";

	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a set of WordCount objects that represents the number of times each
	// unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.

	public List<WordCount> getWordCounts() {
		ArrayList<WordCount> arrayList = new ArrayList<WordCount>();
		for (String str : words) {
			WordCount wordCount = new WordCount(str, count(str));
			if (!arrayList.contains(wordCount)) {
				arrayList.add(wordCount);
			}
		}
		return arrayList;
	}

	public int count(String str) {
		int a = 0;
		for (String string : words) {
			if (str.equals(string)) {
				a++;
			}
		}
		return a;
	}

//	 Returns the words that their appearance are 1, do not consider duplidated
//	 words
	public Set<String> getUniqueWords() {
		Set<String> set = new HashSet<String>();
		for (WordCount wordCount : getWordCounts()) {
			if (wordCount.getUniqueWords()) {
				set.add(wordCount.getWord());
			}
		}
		return set;
	}

//	 Returns the words in the text file, duplicated words appear once in the
//	 result
	public Set<String> getDistinctWords() {
		Set<String> set = new HashSet<String>(words);
		return set;
	}

//	 Prints out the number of times each unique token appears in the file
//	 data/hamlet.txt (or fit.txt) according ascending order of tokens
//	 Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> set = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		set.addAll(getWordCounts());
		return set;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> set = new TreeSet<WordCount>(new Comparator<WordCount>() {

			@Override
			public int compare(WordCount o1, WordCount o2) {
				// TODO Auto-generated method stub
				return (o1.getCount() != o2.getCount()) ? -(o1.getCount() - o2.getCount())
						: (o1.getWord().compareTo(o2.getWord()));

			}
		});
		set.addAll(getWordCounts());
		return set;
	}

//	 delete words begining with the given pattern (i.e., delete words begin with
//	 'A' letter
	public Set<String> filterWords(String pattern) {

		Set<String> set = new HashSet<String>();
		for (String string : words) {
			if (string.indexOf(pattern, 0) != 0) {
				set.add(string);
			}

		}
		return set;
	}

	public static void main(String[] args) {
		MyWordCount myWordCount = new MyWordCount();
		System.out.println(myWordCount.getWordCounts());
		System.out.println(myWordCount.getUniqueWords());
		System.out.println(myWordCount.getDistinctWords());
		System.out.println(myWordCount.printWordCounts());
		System.out.println(myWordCount.exportWordCountsByOccurence());
		System.out.println(myWordCount.filterWords("No"));
	}
}
