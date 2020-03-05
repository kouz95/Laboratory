package chicken.domain;

public class Price {
	public static final String MIN_AMOUNT = "가격은 0 보다 작 수 없습니다.";
	public static final String NOT_NUMBER = "가격은 숫자이어야 합니다.";

	private final int price;

	public Price(String price) {
		checkValidityOf(price);
		this.price = Integer.parseInt(price);
	}

	private void checkValidityOf(String price) {
		if (isNotDigit(price)) {
			throw new NumberFormatException(NOT_NUMBER);
		}
		if (Integer.parseInt(price) < 0) {
			throw new IllegalArgumentException(MIN_AMOUNT);
		}
	}

	private boolean isNotDigit(String price) {
		return price.chars()
			.anyMatch(ch -> !Character.isDigit(ch));
	}
}
