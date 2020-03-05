package chicken.domain.order;

import chicken.domain.order.menu.Category;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.order.menu.Price;

public class Menu {
	private final MenuNumber number;
	private final String name;
	private final Category category;
	private final Price price;

	public Menu(MenuNumber number, String name, Category category, Price price) {
		this.number = number;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public boolean isNumberEquals(MenuNumber number) {
		return this.number.equals(number);
	}
}
