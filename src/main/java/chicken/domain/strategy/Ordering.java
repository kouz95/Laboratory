package chicken.domain.strategy;

import chicken.domain.Order;
import chicken.domain.Orders;

public class Ordering implements PosStrategy {
	@Override
	public void act(Orders orders, Order order) {
		orders.add(order);
	}
}
