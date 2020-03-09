package chicken.domain;

import java.util.List;
import java.util.stream.Collectors;

import chicken.domain.order.Table;

public class Orders {
	private final List<Order> orders;

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public void add(Order order) {
		orders.add(order);
	}

	public void delete(Order order) {
		orders.remove(order);
	}

	public TableStates getTableStates() {
		TableStates result = new TableStates();
		orders.forEach(order -> result.replace(order.getTable(), true));
		return result;
	}

	public List<Order> getOrdersIn(Table table) {
		return orders.stream()
			.filter(order -> order.isTableEquals(table))
			.collect(Collectors.toList());
	}

	public int getTotalPriceIn(Table table) {
		return orders.stream()
			.filter(order -> order.isTableEquals(table))
			.map(Order::getPrice)
			.mapToInt(price -> price.getPrice())
			.sum() - 10000 * (getChickenCountOf(table) / 10);
	}

	private int getChickenCountOf(Table table) {
		return orders.stream()
			.filter(order -> order.isTableEquals(table))
			.mapToInt(Order::getChickenCount)
			.sum();
	}
}
