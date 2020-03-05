package chicken.domain;

public class Pos {
	private Orders orders;
	private PosStrategy posStrategy;

	public void run(String functionType) {
		posStrategy = FunctionType.getStrategyOf(functionType);
		posStrategy.act(orders);
	}
}
