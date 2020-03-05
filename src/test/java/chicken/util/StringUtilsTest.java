package chicken.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {
	@Test
	void getIsNotDigit() {
		String notDigit = "a1";
		assertTrue(StringUtils.isNotDigit(notDigit));
	}
}