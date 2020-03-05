package chicken.domain;

import static chicken.domain.MenuCount.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuCountTest {
	@Test
	void throwExceptionsWhenGivenOver99() {
		assertThatIllegalArgumentException().isThrownBy(() ->
			new MenuCount(100)
		).withMessage(COUNT_OVER);
	}
}
