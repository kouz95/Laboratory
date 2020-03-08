package chicken;

import static chicken.view.InputView.*;
import static chicken.view.OutputView.*;

import chicken.controller.PosController;

public class Application {
	public static void main(String[] args) {
		while (true) {
			printMainScreen();
			PosController.run(inputFunctionType());
		}
	}
}
