package chicken.domain;

import static chicken.domain.Price.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceTest {
	@Test
	void throwExceptionWhenUnderZero() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new Price(-1)
		).withMessage(MIN_AMOUNT);
	}
}