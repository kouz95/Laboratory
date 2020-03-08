package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import chicken.domain.order.Menu;
import chicken.domain.order.MenuCount;
import chicken.domain.order.Table;
import chicken.domain.order.menu.Category;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.order.menu.Price;
import chicken.domain.repository.TableRepository;

class OrdersTest {
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
	void getTableStates() {
		Map<Table, Boolean> value = new HashMap<>();
		TableRepository.tables().forEach(table -> value.put(table, false));
		value.replace(table, true);
		TableStates expected = new TableStates(value);
		TableStates actual = orders.getTableStates();
		assertEquals(expected, actual);
	}
}