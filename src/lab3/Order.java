package lab3;

import java.util.Arrays;
import java.util.Comparator;

public class Order {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public OrderItem[] getItems() {
		return items;
	}

	public void setItems(OrderItem[] items) {
		this.items = items;
	}

	public double cost() {
		double cost = 0;
		for (OrderItem orderItem : items) {
			cost+= orderItem.cost();
		}
		return cost;
	}

	// using binary search approach
	public boolean contains(Product p) {
		if (p.compareTo(items[(items.length - 1) / 2].getP()) == 0) {
			return true;
		} else {
			if (p.compareTo(items[(items.length - 1) / 2].getP()) > 0) {
				for (int i = items.length / 2; i < items.length; i++) {
					if (p.compareTo(items[i].getP()) == 0) {
						return true;
					}
				}
			} else {
				for (int i = 0; i < (items.length + 1) / 2; i++) {
					if (p.compareTo(items[i].getP()) == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// get all products based on the given type using linear search
	public Product[] filter(String type) {
		int length = 0;
		for (OrderItem orderItem : items) {
			if (orderItem.getP().check(type)) {
				length++;
			}
		}
		Product[] listPro = new Product[length];
		int add = 0;
		for (OrderItem orderItem : items) {
			if (orderItem.getP().check(type)) {
				listPro[add] = orderItem.getP();
				add++;
			}
		}
		return listPro;
	}
	public static void bubbleSort(OrderItem[] items) {
		OrderItem a;
		boolean b = true;
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (items[j].sort(items[j + 1])) {
					a = items[j];
					items[j] = items[j + 1];
					items[j + 1] = a;
					b = false;
				}
			}
			if (b)
				break;
		}
		return;
	}
	public static void main(String[] args) {
		Product p1 = new Product("cf001", "Arabica", 30, "A");
		Product p2 = new Product("cf002", "Bourbon", 20.4, "A");
		Product p3 = new Product("cf003", "Typica", 24.4, "B");
		Product p4 = new Product("cf004", "Robusta", 26.7, "C");
		Product p5 = new Product("cf005", "Robusta", 13.5, "C");

		OrderItem orderItem1 = new OrderItem(p1, 13);
		OrderItem orderItem2 = new OrderItem(p2, 5);
		OrderItem orderItem3 = new OrderItem(p3, 17);
		OrderItem orderItem4 = new OrderItem(p5, 8);

		OrderItem[] items = { orderItem1, orderItem2, orderItem3, orderItem4 };
		Order order = new Order(items);
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].toString());
		}
		//Arrays.sort(items);
		bubbleSort(items);
		System.out.println("cost: "+order.cost());
		System.out.println(order.contains(p4));
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i].toString());
		}
	}
}
