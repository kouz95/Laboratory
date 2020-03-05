package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.order.menu.Category;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.order.menu.Price;
import chicken.domain.order.Menu;

class MenuTest {
	@Test
	void getInNumberEquals() {
		MenuNumber number = new MenuNumber("1");
		Menu menu = new Menu(number, "a", Category.CHICKEN, new Price("1"));

		assertTrue(menu.isNumberEquals(number));
	}
}