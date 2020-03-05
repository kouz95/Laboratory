package chicken.domain;

import chicken.domain.order.Menu;
import chicken.domain.order.MenuCount;
import chicken.domain.order.Table;

public class Order {
	private final Menu menu;
	private final MenuCount menuCount;
	private final Table table;

	public Order(Menu menu, MenuCount menuCount, Table table) {
		this.menu = menu;
		this.menuCount = menuCount;
		this.table = table;
	}

	public Table getTable() {
		return table;
	}
}
