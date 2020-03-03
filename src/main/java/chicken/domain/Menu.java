package chicken.domain;

public class Menu {
	private final int number;
	private final String name;
	private final Category category;
	private final Price price;

	public Menu(int number, String name, Category category, Price price) {
		this.number = number;
		this.name = name;
		this.category = category;
		this.price = price;
	}
}
