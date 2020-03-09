package chicken.domain;

import static chicken.domain.Price.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
	@Test
	void throwExceptionWhenNotNumber() {
		assertThatThrownBy(() -> new Price("a"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(NOT_NUMBER);

		assertThatThrownBy(() -> new Price("-1"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(NOT_NUMBER);
	}
}