package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chicken.domain.order.Menu;
import chicken.domain.order.MenuCount;
import chicken.domain.order.Table;
import chicken.domain.order.menu.Category;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.order.menu.Price;

class TableStatesTest {
	private Orders orders;
	private Table table;

	@BeforeEach
	void init() {
		table = new Table("1");
		Menu menu = new Menu(new MenuNumber("1"), "a", Category.CHICKEN, new Price("1"));
		Order order = new Order(menu, new MenuCount("1"), table);
		orders = new Orders(Collections.singletonList(order));
	}

	@Test
	void getHasOrderInTable() {
		TableStates tableStates = orders.getTableStates();
		assertTrue(tableStates.hasOrderIn(table));
		assertFalse(tableStates.hasOrderIn(new Table("2")));
	}

}