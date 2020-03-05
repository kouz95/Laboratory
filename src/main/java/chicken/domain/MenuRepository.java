package chicken.domain;

import java.util.Collections;
import java.util.List;

import chicken.domain.menu.Category;
import chicken.domain.menu.MenuNumber;
import chicken.domain.menu.Price;
import chicken.domain.order.Menu;

public class MenuRepository {
	private static final List<Menu> menus;

	static {
		menus = List.of(
			new Menu(new MenuNumber("1"), "후라이드", Category.CHICKEN, new Price("16_000")),
			new Menu(new MenuNumber("2"), "양념치킨", Category.CHICKEN, new Price("16_000")),
			new Menu(new MenuNumber("3"), "반반치킨", Category.CHICKEN, new Price("16_000")),
			new Menu(new MenuNumber("4"), "통구이", Category.CHICKEN, new Price("16_000")),
			new Menu(new MenuNumber("5"), "간장치킨", Category.CHICKEN, new Price("17_000")),
			new Menu(new MenuNumber("6"), "순살치킨", Category.CHICKEN, new Price("17_000")),
			new Menu(new MenuNumber("21"), "콜라", Category.BEVERAGE, new Price("1_000")),
			new Menu(new MenuNumber("22"), "사이다", Category.BEVERAGE, new Price("1_000"))
		);
	}

	public static List<Menu> menus() {
		return Collections.unmodifiableList(menus);
	}

	public static boolean hasNot(String number) {
		return menus.stream()
			.noneMatch(menu -> menu.isNumberEquals(new MenuNumber(number)));
	}
}
