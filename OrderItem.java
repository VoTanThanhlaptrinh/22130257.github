package lab3;

public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quatity;

	public OrderItem(Product p, int quatity) {
		super();
		this.p = p;
		this.quatity = quatity;
	}

	public Product getP() {
		return p;
	}

	public double cost() {
		return p.getPrice() * quatity;
	}

	public int compareTo(OrderItem o) {
		return p.compareTo(o.getP());
	}

	public boolean check(String otherType) {
		return p.check(otherType);
	}

	public String toString() {
		return p.toString() + " quatity: " + quatity;
	}
}
