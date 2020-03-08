package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.order.Table;

class TableTest {
	@Test
	void getTableNumber() {
		String value = "1";
		Table table = new Table(value);

		int expected = 1;
		int actual = table.getNumber();
		assertEquals(expected, actual);
	}
}