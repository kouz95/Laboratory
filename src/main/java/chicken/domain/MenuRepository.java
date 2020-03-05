package chicken.domain;

import java.util.Collections;
import java.util.List;

public class MenuRepository {
	private static final List<Menu> menus;

	static {
		menus = List.of(
			new Menu(1, "후라이드", Category.CHICKEN, new Price("16_000")),
			new Menu(2, "양념치킨", Category.CHICKEN, new Price("16_000")),
			new Menu(3, "반반치킨", Category.CHICKEN, new Price("16_000")),
			new Menu(4, "통구이", Category.CHICKEN, new Price("16_000")),
			new Menu(5, "간장치킨", Category.CHICKEN, new Price("17_000")),
			new Menu(6, "순살치킨", Category.CHICKEN, new Price("17_000")),
			new Menu(21, "콜라", Category.BEVERAGE, new Price("1_000")),
			new Menu(22, "사이다", Category.BEVERAGE, new Price("1_000"))
		);
	}

	public static List<Menu> menus() {
		return Collections.unmodifiableList(menus);
	}
}
