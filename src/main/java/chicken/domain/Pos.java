package chicken.domain;

import java.util.ArrayList;

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
}
