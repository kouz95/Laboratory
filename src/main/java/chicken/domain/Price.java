package chicken.domain;

import java.util.Objects;

import chicken.util.StringUtils;

public class Price {
	public static final String NOT_NUMBER = "가격은 숫자이어야 합니다.";

	private final int price;

	public Price(String line) {
		if (StringUtils.isNotDigit(line)) {
			throw new NumberFormatException(NOT_NUMBER);
		}
		this.price = Integer.parseInt(line);
	}

	public Price multiply(String multiplier) {
		return new Price(String.valueOf(price * Integer.parseInt(multiplier)));
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.valueOf(price);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Price price1 = (Price)o;
		return price == price1.price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price);
	}
}
