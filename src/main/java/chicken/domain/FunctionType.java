package chicken.domain;

import java.util.Arrays;

import chicken.domain.strategy.Ordering;
import chicken.domain.strategy.Paying;
import chicken.domain.strategy.Quitting;

public enum FunctionType {
	ORDER("1", new Ordering()),
	PAY("2", new Paying()),
	QUIT("3", new Quitting());

	private final String functionType;
	private final PosStrategy posStrategy;

	FunctionType(String functionType, PosStrategy posStrategy) {
		this.functionType = functionType;
		this.posStrategy = posStrategy;
	}

	public static FunctionType of(String functionType) {
		return Arrays.stream(FunctionType.values())
			.filter(value -> functionType.equals(value.functionType))
			.findFirst()
			.orElseThrow(NullPointerException::new);
	}

	public static PosStrategy getStrategyOf(String functionType) {
		return FunctionType.of(functionType).posStrategy;
	}
}
