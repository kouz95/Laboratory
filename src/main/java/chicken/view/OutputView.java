package chicken.view;

import java.util.List;

import chicken.domain.TableStates;
import chicken.domain.order.Table;
import chicken.domain.repository.TableRepository;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %d |";
	private static final String BOTTOM_LINE_NO_ORDER = "└ ─ ┘";
	private static final String BOTTOM_LINE_IN_ORDER = "└ ₩ ┘";
	private static final String NEW_LINE = "\n";

	public static void printMainScreen() {
		System.out.println("## 메인화면");
		System.out.println("1 - 주문등록");
		System.out.println("2 - 결제하기");
		System.out.println("3 - 프로그램 종료");
	}

	public static void printTables(TableStates tableStates) {
		List<Table> tables = TableRepository.tables();
		StringBuilder stringBuilder = new StringBuilder();

		System.out.println("테이블 목록");
		System.out.println(TOP_LINE.repeat(tables.size()));

		makeMiddleLine(stringBuilder, tables);
		makeBottomLine(tableStates, stringBuilder, tables);
		System.out.println(stringBuilder.toString() + NEW_LINE);
	}

	private static void makeBottomLine(TableStates tableStates, StringBuilder stringBuilder, List<Table> tables) {
		tables.forEach(table -> {
			if (tableStates.hasOrderIn(table)) {
				stringBuilder.append(BOTTOM_LINE_IN_ORDER);
				return;
			}
			stringBuilder.append(BOTTOM_LINE_NO_ORDER);
		});
	}

	private static void makeMiddleLine(StringBuilder stringBuilder, List<Table> tables) {
		tables.forEach(table -> stringBuilder.append(String.format(TABLE_FORMAT, table.getNumber())));
		stringBuilder.append(NEW_LINE);
	}
}
