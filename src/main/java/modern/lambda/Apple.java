package modern.lambda;

public class Apple {
	private final Integer weight;
	private final Color color;

	public Apple(Integer weight, Color color) {
		this.weight = weight;
		this.color = color;
	}

	public Integer getWeight() {
		return weight;
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Apple{" +
			"weight=" + weight +
			", color=" + color +
			'}';
	}
}
