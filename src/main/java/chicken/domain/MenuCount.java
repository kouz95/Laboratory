package chicken.domain;

public class MenuCount {
	public static final String COUNT_OVER = "메뉴의 최대 수량은 99 입니다.";
	private final int count;

	public MenuCount(int count) {
		checkValidityOf(count);
		this.count = count;
	}

	private void checkValidityOf(int count) {
		if (count > 99) {
			throw new IllegalArgumentException(COUNT_OVER);
		}
	}
}
