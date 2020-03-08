package chicken.domain;

import static chicken.domain.order.MenuCount.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.order.MenuCount;

public class MenuCountTest {
	@Test
	void throwExceptionsWhenGivenOver99() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new MenuCount("100")
		).withMessage(COUNT_OVER);
	}

	@Test
	void throwExceptionsWhenGivenNotNumber() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new MenuCount("notNumber")
		).withMessage(NOT_NUMBER);
	}
}
