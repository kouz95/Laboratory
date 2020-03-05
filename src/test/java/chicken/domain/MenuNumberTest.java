package chicken.domain;

import static chicken.domain.order.menu.MenuNumber.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chicken.domain.order.menu.MenuNumber;

public class MenuNumberTest {
	@Test
	void throwExceptionForNotNumber() {
		assertThatThrownBy(() -> new MenuNumber("a"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(NOT_NUMBER);
	}
}
