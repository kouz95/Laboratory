package modern.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingPredicate {
	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<>();
		Apple a1 = new Apple(150, Color.RED);
		Apple a2 = new Apple(100, Color.GREEN);
		Apple a3 = new Apple(200, Color.RED);
		apples.add(a1);
		apples.add(a2);
		apples.add(a3);

		Predicate<Apple> isRed = apple -> apple.getColor().equals(Color.RED);
		Function<Integer, Predicate<Apple>> isOver = weight -> apple -> apple.getWeight() > weight;
		apples.stream()
			.filter(isOver.apply(100)
			.and(isRed))
			.map(Apple::toString)
		.forEach(System.out::println);
	}
}
