package lab9;

import java.util.List;

public class Reference extends Publications {
	private String field;
	private List<Chapter> chapters;

	public Reference(String title, int numOfPages, int publishingYear, String author, double cost, String field,
			List<Chapter> chapters) {
		super(title, numOfPages, publishingYear, author, cost);
		this.field = field;
		this.chapters = chapters;
	}

	@Override
	public boolean isPubliccations() {
		return false;
	}

	public int maxPagesChapter() {
		int max = chapters.get(0).getNumPagesOfChapter();
		for (Chapter chapter : chapters) {
			max = Math.max(max, chapter.getNumPagesOfChapter());
		}
		return max;
	}

	@Override
	public boolean isSameName(String otherName) {
		return false;
	}

	@Override
	public boolean isMagazine10Year() {
		return false;
	}

	@Override
	public boolean isMagazineOneYearAgo(int givenYear) {
		return false;
	}

	@Override
	public boolean isSameTypeAndAuthor(Publications publications) {
		if (!publications.isPubliccations()) {
			return author.equalsIgnoreCase(publications.author);
		} else {
			return false;
		}
	}

	@Override
	public boolean sameMagazineGivenYear(int yearGiven) {
		return false;
	}

	@Override
	public boolean containName(String otherName) {
		return false;
	}
	
}
