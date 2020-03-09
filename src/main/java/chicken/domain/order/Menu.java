package chicken.domain.order;

import java.util.Objects;

import chicken.domain.order.menu.Category;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.Price;

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

	public String getName() {
		return name;
	}

	public MenuNumber getNumber() {
		return number;
	}

	public Category getCategory() {
		return category;
	}

	public Price getPrice() {
		return price;
	}

	public boolean isChicken() {
		return Category.CHICKEN.equals(category);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Menu menu = (Menu)o;
		return Objects.equals(number, menu.number) &&
			Objects.equals(name, menu.name) &&
			category == menu.category &&
			Objects.equals(price, menu.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(number, name, category, price);
	}
}
