package chicken.domain.menu;

import java.util.Objects;

import chicken.util.StringUtils;

public class MenuNumber {
	public static final String NOT_NUMBER = "메뉴 번호는 숫자이어야 합니다.";

	private final int number;

	public MenuNumber(String number) {
		if (StringUtils.isNotDigit(number)) {
			throw new NumberFormatException(NOT_NUMBER);
		}
		this.number = Integer.parseInt(number);;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MenuNumber that = (MenuNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
