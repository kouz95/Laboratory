package chicken.domain;

import static chicken.domain.MenuNumber.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuNumberTest {
	@Test
	void throwExceptionForNotNumber() {
		assertThatThrownBy(() -> new MenuNumber("a"))
			.isInstanceOf(NumberFormatException.class)
			.hasMessage(NOT_NUMBER);
	}
}
