package lab9;

public abstract class Publications {
	protected String title;
	protected int numOfPages;
	protected int publishingYear;
	protected String author;
	protected double cost;

	public Publications(String title, int numOfPages, int publishingYear, String author, double cost) {
		super();
		this.title = title;
		this.numOfPages = numOfPages;
		this.publishingYear = publishingYear;
		this.author = author;
		this.cost = cost;
	}
	public abstract boolean isPubliccations();

	public abstract boolean isMagazine10Year();
	
	public abstract boolean isSameTypeAndAuthor(Publications publications);
	
	public abstract boolean isSameName(String otherName);

	public abstract boolean isMagazineOneYearAgo(int givenYear); 

	public double getCost() {
		return cost;
	}
	public abstract int maxPagesChapter();
	
	public abstract boolean sameMagazineGivenYear(int yearGiven);
	
	public abstract boolean containName(String otherName); 
	
	public int compareTitle(Publications p) {
		return title.compareToIgnoreCase(p.title);
	}
	public int comparePublishYear(Publications p) {
		return publishingYear - p.publishingYear;
	}
}
