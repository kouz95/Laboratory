package chicken.domain;

import java.util.Objects;

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

	public Menu getMenu() {
		return menu;
	}

	public MenuCount getMenuCount() {
		return menuCount;
	}

	public boolean isTableEquals(Table table) {
		return this.table.equals(table);
	}

	public Price getPrice() {
		return menu.getPrice().multiply(menuCount.toString());
	}

	public int getChickenCount() {
		int count = 0;
		if (menu.isChicken()) {
			count += Integer.parseInt(menuCount.toString());
		}
		return count;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Order order = (Order)o;
		return Objects.equals(menu, order.menu) &&
			Objects.equals(menuCount, order.menuCount) &&
			Objects.equals(table, order.table);
	}

	@Override
	public int hashCode() {
		return Objects.hash(menu, menuCount, table);
	}
}
