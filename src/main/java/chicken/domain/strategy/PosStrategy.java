package chicken.domain.strategy;

import chicken.domain.Order;
import chicken.domain.Orders;

public interface PosStrategy {
	void act(Orders orders, Order order);
}
