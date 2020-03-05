package chicken.domain;

public enum Category {
	CHICKEN("치킨"),
	BEVERAGE("음료");

	private final String korean;

	Category(String korean) {
		this.korean = korean;
	}

	public String toKorean() {
		return korean;
	}
}
