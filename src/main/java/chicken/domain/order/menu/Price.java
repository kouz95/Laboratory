package chicken.domain.order.menu;

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
}
