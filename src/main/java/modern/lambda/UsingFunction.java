package modern.lambda;

import java.util.function.Function;

public class UsingFunction {
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.andThen(g);

		System.out.println(h.apply(1));

		Function<Integer, Integer> h2 = f.compose(g);

		System.out.println(h2.apply(1));
	}
}
