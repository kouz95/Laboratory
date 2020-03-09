package chicken.view;

import java.util.Scanner;

import chicken.domain.order.Table;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static String inputFunctionType() {
		System.out.println("## 원하는 기능을 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputTableNumber() {
		System.out.println("## 테이블을 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputMenuNumber() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
		return scanner.nextLine();
	}

	public static String inputMenuCount() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
		return scanner.nextLine();
	}

	public static String inputPaymentType(Table table) {
		System.out.println("## " + table.toString() + "번 테이블의 결제를 진행합니다.");
		System.out.println("## 신용 카드는 1번, 현금은 2번");
		return scanner.nextLine();
	}
}
