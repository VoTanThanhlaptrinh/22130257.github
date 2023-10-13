package lab3;

import java.util.Comparator;

public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public boolean sort(Product other) {
		if(price > other.getPrice()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean check(String otherType) {
		if (type.equalsIgnoreCase(otherType)) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		return "id:" + id + "  name:" + name + "  price:" + price + "  type:" + type +"\t";
	}

	@Override
	public int compareTo(Product o) {
		return id.compareToIgnoreCase(o.getId());
	}
}
