package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {
	@Test
	void getTableNumber() {
		int value = 1;
		Table table = new Table(value);

		int expected = 1;
		int actual = table.getNumber();
		assertEquals(expected, actual);
	}
}