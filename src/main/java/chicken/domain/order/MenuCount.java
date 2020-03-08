package chicken.domain.order;

import chicken.util.StringUtils;

public class MenuCount {
	public static final String COUNT_OVER = "메뉴의 최대 수량은 99 입니다.";
	public static final String NOT_NUMBER = "메뉴의 수량은 숫자 이어야 합니다.";
	private static final int MAX_NUMBER = 99;

	private final int count;

	public MenuCount(String line) {
		if (StringUtils.isNotDigit(line)) {
			throw new NumberFormatException(NOT_NUMBER);
		}

		int count = Integer.parseInt(line);
		if (count > MAX_NUMBER) {
			throw new IllegalArgumentException(COUNT_OVER);
		}
		this.count = count;
	}
}
