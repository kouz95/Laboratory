package chicken.domain;

import java.util.ArrayList;
import java.util.List;

import chicken.domain.order.Table;
import chicken.domain.strategy.PosStrategy;

public class Pos {
	private Orders orders;
	private PosStrategy posStrategy;

	public Pos() {
		this.orders = new Orders(new ArrayList<>());
	}

	public void run(PosFunctionType functionType, Order order) {
		posStrategy = functionType.getPosStrategy();
		posStrategy.act(orders, order);
	}

	public TableStates tableStates() {
		return orders.getTableStates();
	}

	public List<Order> getOrdersIn(Table table) {
		return orders.getOrdersIn(table);
	}

	public double getTotalPriceIn(Table table, PaymentType paymentType) {
		return paymentType.getDiscountedPrice(orders.getTotalPriceIn(table));
	}
}
