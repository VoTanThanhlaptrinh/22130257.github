package lab9;

public class Magazine extends Publications {
	private String name;

	public Magazine(String title, int numOfPages, int publishingYear, String author, double cost, String name) {
		super(title, numOfPages, publishingYear, author, cost);
		this.name = name;
	}

	@Override
	public boolean isPubliccations() {
		return true;
	}
	@Override
	public boolean isSameName(String otherName) {
		// TODO Auto-generated method stub
		return name.equalsIgnoreCase(otherName);
	}

	@Override
	public boolean isMagazine10Year() {
		// TODO Auto-generated method stub
		return 2021 - publishingYear >= 10;
	}

	@Override
	public boolean isMagazineOneYearAgo(int givenYear) {
		return givenYear - publishingYear == 1;
	}

	@Override
	public boolean isSameTypeAndAuthor(Publications publications) {
		if(publications.isPubliccations()) {
			return author.equalsIgnoreCase(publications.author);
		}else {
			return false;
		}
	}

	@Override
	public boolean sameMagazineGivenYear(int yearGiven) {
		return publishingYear == yearGiven;
	}

	@Override
	public boolean containName(String otherName) {
		return name.equalsIgnoreCase(otherName);
	}

	@Override
	public int maxPagesChapter() {
		return 0;
	}
}
