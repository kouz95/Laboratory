package chicken.domain;

import java.util.stream.Stream;

public enum PaymentType {
	CARD("1", 1),
	CASH("2", 0.95);

	private final String value;
	private final double discountPercent;

	PaymentType(String value, double discountPercent) {
		this.value = value;
		this.discountPercent = discountPercent;
	}

	double getDiscountedPrice(int price) {
		return price * discountPercent;
	}

	public static PaymentType of(String input) {
		return Stream.of(PaymentType.values())
			.filter(paymentType -> paymentType.value.equals(input))
			.findFirst()
			.orElseThrow(NullPointerException::new);
	}
}
