package chicken.util;

public class StringUtils {
	public static boolean isNotDigit(String line) {
		return line.chars()
			.anyMatch(ch -> !Character.isDigit(ch));
	}
}
