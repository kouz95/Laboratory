package chicken.controller;

import static chicken.view.OutputView.*;
import static chicken.view.InputView.*;

import chicken.domain.FunctionType;
import chicken.domain.Pos;
import chicken.domain.order.Table;

public class PosController {
	private static final Pos pos;

	static {
		pos = new Pos();
	}

	public static void run() {
		printMainScreen();
		FunctionType functionType = FunctionType.of(inputFunctionType());
		printTables(pos.tableStates());
		Table table = new Table(Integer.parseInt(inputTableNumber()));
		printMenus();
	}
}
