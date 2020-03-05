package chicken.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import chicken.domain.order.Table;
import chicken.domain.repository.TableRepository;

public class TableStates {
	private Map<Table, Boolean> states;

	public TableStates() {
		Map<Table, Boolean> initialStates = new HashMap<>();
		TableRepository.tables().forEach(table -> initialStates.put(table, false));
		states = initialStates;
	}

	public TableStates(Map<Table, Boolean> states) {
		this.states = states;
	}

	public void replace(Table table, Boolean isOrder) {
		states.replace(table, isOrder);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TableStates that = (TableStates)o;
		return Objects.equals(states, that.states);
	}

	@Override
	public int hashCode() {
		return Objects.hash(states);
	}
}
