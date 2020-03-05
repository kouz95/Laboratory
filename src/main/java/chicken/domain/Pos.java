package chicken.domain;

import chicken.domain.strategy.PosStrategy;

public class Pos {
	private Orders orders;
	private PosStrategy posStrategy;

	public void act(String functionType, Order order) {
		posStrategy = FunctionType.getStrategyOf(functionType);
		posStrategy.act(orders, order);
	}

	public TableStates tableStates() {
		return orders.getTableStates();
	}
}
