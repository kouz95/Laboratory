package modern.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsingComparator {
	public static void main(String[] args) {
		Comparator<Apple> byWeight =
			Comparator.comparing(Apple::getWeight);
		//.reversed();

		List<Apple> apples = new ArrayList<>();
		Apple a1 = new Apple(150, Color.RED);
		Apple a2 = new Apple(100, Color.GREEN);
		Apple a3 = new Apple(200, Color.RED);
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);

		apples.stream()
			.mapToInt(Apple::getWeight)
			.forEach(System.out::println);

		apples.sort(byWeight);

		apples.stream()
			.mapToInt(Apple::getWeight)
			.forEach(System.out::println);
	}
}

