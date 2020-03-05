package chicken.domain;

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
