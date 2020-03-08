package chicken.domain;

import java.util.Arrays;

import chicken.domain.strategy.Ordering;
import chicken.domain.strategy.Paying;
import chicken.domain.strategy.PosStrategy;
import chicken.domain.strategy.Quitting;

public enum PosFunctionType {
	ORDER("1", new Ordering()),
	PAY("2", new Paying()),
	QUIT("3", new Quitting());

	private final String functionType;
	private final PosStrategy posStrategy;

	PosFunctionType(String functionType, PosStrategy posStrategy) {
		this.functionType = functionType;
		this.posStrategy = posStrategy;
	}

	public static PosFunctionType of(String functionType) {
		return Arrays.stream(PosFunctionType.values())
			.filter(value -> functionType.equals(value.functionType))
			.findFirst()
			.orElseThrow(NullPointerException::new);
	}

	public static PosStrategy getStrategyOf(String functionType) {
		return PosFunctionType.of(functionType).posStrategy;
	}

	public PosStrategy getPosStrategy() {
		return posStrategy;
	}
}
