package chicken.controller;

import static chicken.view.OutputView.*;
import static chicken.view.InputView.*;

import java.util.Map;
import java.util.function.Consumer;

import chicken.domain.PosFunctionType;
import chicken.domain.Order;
import chicken.domain.Pos;
import chicken.domain.order.MenuCount;
import chicken.domain.order.Table;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.repository.MenuRepository;

public class PosController {
	private static final String ORDER = "1";
	private static final Pos pos;
	private static final Map<String, Consumer<PosFunctionType>> posFunctions;

	static {
		pos = new Pos();
		posFunctions = Map.of(ORDER, createOrder());
	}

	public static void run(String input) {
		Consumer<PosFunctionType> posFunction = posFunctions.get(input);
		posFunction.accept(PosFunctionType.of(input));
	}

	private static Consumer<PosFunctionType> createOrder() {
		return posFunctionType -> {
			printTables(pos.tableStates());
			Table table = new Table(inputTableNumber());
			printMenus();
			MenuNumber menuNumber = new MenuNumber(inputMenuNumber());
			MenuCount menuCount = new MenuCount(inputMenuCount());
			pos.run(posFunctionType, new Order(MenuRepository.getMenuOf(menuNumber), menuCount, table));
		};
	}
}
