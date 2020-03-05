package chicken.view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String inputFunctionType() {
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.nextLine();
	}
}
