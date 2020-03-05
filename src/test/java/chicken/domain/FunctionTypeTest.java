package chicken.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.strategy.Ordering;

public class FunctionTypeTest {
	@Test
	void getOrder() {
		String value = "1";
		FunctionType expected = FunctionType.ORDER;
		FunctionType actual = FunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getPay() {
		String value = "2";
		FunctionType expected = FunctionType.PAY;
		FunctionType actual = FunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getQuit() {
		String value = "3";
		FunctionType expected = FunctionType.QUIT;
		FunctionType actual = FunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getFunctionTypeByOf() {
		String value = "1";

		FunctionType expected = FunctionType.ORDER;
		FunctionType actual = FunctionType.of(value);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void throwExceptionForNoType() {
		String value = "4";
		assertThatNullPointerException().isThrownBy(() -> FunctionType.of(value));
	}

	@Test
	void getStrategy() {
		assertThat(FunctionType.getStrategyOf("1")).isInstanceOf(Ordering.class);
	}
}
