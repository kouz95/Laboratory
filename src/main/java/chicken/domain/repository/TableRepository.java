package chicken.domain.repository;

import java.util.Collections;
import java.util.List;

import chicken.domain.order.Table;

public class TableRepository {
	private static final List<Table> tables;

	static {
		tables = List.of(
			new Table("1"),
			new Table("2"),
			new Table("3"),
			new Table("5"),
			new Table("6"),
			new Table("8")
		);
	}

	public static List<Table> tables() {
		return Collections.unmodifiableList(tables);
	}
}
