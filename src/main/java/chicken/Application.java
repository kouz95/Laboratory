package chicken;

import static chicken.view.InputView.*;
import static chicken.view.OutputView.*;

import chicken.controller.PosController;
import chicken.domain.Pos;

public class Application {
	public static void main(String[] args) {
		Pos pos = new Pos();
		while (true) {
			printMainScreen();
			PosController.run(pos, inputFunctionType());
		}
	}
}
