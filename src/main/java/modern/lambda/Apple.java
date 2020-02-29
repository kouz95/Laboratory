package modern.lambda;

import java.util.Objects;

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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Apple apple = (Apple)o;
		return Objects.equals(weight, apple.weight) &&
			color == apple.color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, color);
	}

	@Override
	public String toString() {
		return "Apple{" +
			"weight=" + weight +
			", color=" + color +
			'}';
	}
}
