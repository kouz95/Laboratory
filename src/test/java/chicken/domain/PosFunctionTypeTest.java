package chicken.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.strategy.Ordering;

public class PosFunctionTypeTest {
	@Test
	void getOrder() {
		String value = "1";
		PosFunctionType expected = PosFunctionType.ORDER;
		PosFunctionType actual = PosFunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getPay() {
		String value = "2";
		PosFunctionType expected = PosFunctionType.PAY;
		PosFunctionType actual = PosFunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getQuit() {
		String value = "3";
		PosFunctionType expected = PosFunctionType.QUIT;
		PosFunctionType actual = PosFunctionType.of(value);
		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void getFunctionTypeByOf() {
		String value = "1";

		PosFunctionType expected = PosFunctionType.ORDER;
		PosFunctionType actual = PosFunctionType.of(value);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void throwExceptionForNoType() {
		String value = "4";
		assertThatNullPointerException().isThrownBy(() -> PosFunctionType.of(value));
	}

	@Test
	void getStrategy() {
		assertThat(PosFunctionType.getStrategyOf("1")).isInstanceOf(Ordering.class);
	}
}
