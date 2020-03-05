package chicken.domain;

import java.util.List;

public class Orders {
	private final List<Order> orders;

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public TableStates getTableStates() {
		TableStates result = new TableStates();
		orders.forEach(order -> result.replace(order.getTable(), true));
		return result;
	}
}
