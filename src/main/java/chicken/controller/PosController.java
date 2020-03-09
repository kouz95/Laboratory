package chicken.controller;

import static chicken.view.OutputView.*;
import static chicken.view.InputView.*;

import java.util.Map;
import java.util.function.BiConsumer;

import chicken.domain.PaymentType;
import chicken.domain.PosFunctionType;
import chicken.domain.Order;
import chicken.domain.Pos;
import chicken.domain.order.MenuCount;
import chicken.domain.order.Table;
import chicken.domain.order.menu.MenuNumber;
import chicken.domain.repository.MenuRepository;
import chicken.domain.repository.TableRepository;

public class PosController {
	private static final String ORDER = "1";
	private static final String PAY = "2";
	private static final Map<String, BiConsumer<Pos, String>> posFunctions;

	static {
		posFunctions = Map.of(ORDER, createOrder(), PAY, payOrder());
	}

	public static void run(Pos pos, String functionNumber) {
		BiConsumer<Pos, String> posFunction = posFunctions.get(functionNumber);
		posFunction.accept(pos, functionNumber);
	}

	private static BiConsumer<Pos, String> createOrder() {
		return (pos, functionNumber) -> {
			printTables(pos.tableStates());
			Table table = TableRepository.getTableOf(inputTableNumber());
			printMenus();
			MenuNumber menuNumber = new MenuNumber(inputMenuNumber());
			MenuCount menuCount = new MenuCount(inputMenuCount());
			pos.run(PosFunctionType.of(functionNumber), new Order(MenuRepository.getMenuOf(menuNumber), menuCount, table));
		};
	}

	private static BiConsumer<Pos, String> payOrder() {
		return (pos, functionNumber) -> {
			printTables(pos.tableStates());
			Table table = TableRepository.getTableOf(inputTableNumber());
			printStatement(pos.getOrdersIn(table));
			printTotalPriceOf(pos.getTotalPriceIn(table, PaymentType.of(inputPaymentType(table))));
			pos.getOrdersIn(table).forEach(order -> pos.run(PosFunctionType.of(functionNumber), order));
		};
	}
}
