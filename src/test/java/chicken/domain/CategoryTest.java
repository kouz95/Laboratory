package chicken.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {
	@Test
	void getKoreanName() {
		String expected = "치킨";
		String actual = Category.CHICKEN.toKorean();

		assertEquals(expected, actual);
	}
}