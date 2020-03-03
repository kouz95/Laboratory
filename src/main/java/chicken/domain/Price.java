package chicken.domain;

public class Price {
	public static final String MIN_AMOUNT = "가격은 0 보다 작 수 없습니다.";
	private final int price;

	public Price(int price) {
		checkValidityOf(price);
		this.price = price;
	}

	private void checkValidityOf(int price) {
		if (price < 0) {
			throw new IllegalArgumentException(MIN_AMOUNT);
		}
	}
}
