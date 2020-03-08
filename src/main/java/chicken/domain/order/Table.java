package chicken.domain.order;

import java.util.Objects;

import chicken.util.StringUtils;

public class Table {
	public static final String NOT_NUMBER = "테이블 번호는 숫자이어야 합니다.";
	private final int number;

	public Table(String number) {
		if (StringUtils.isNotDigit(number)) {
			throw new NumberFormatException(NOT_NUMBER);
		}
		this.number = Integer.parseInt(number);
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Table table = (Table)o;
		return number == table.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
