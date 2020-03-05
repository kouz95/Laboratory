package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import chicken.domain.order.Table;

public class TableRepositoryTest {
	@Test
	void getTableList() {
		List<Table> expected = List.of(
			new Table(1),
			new Table(2),
			new Table(3),
			new Table(5),
			new Table(6),
			new Table(8)
		);

		List<Table> actual = TableRepository.tables();

		assertEquals(expected, actual);
	}
}
