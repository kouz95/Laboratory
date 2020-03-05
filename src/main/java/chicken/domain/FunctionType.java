package chicken.domain;

import java.util.Arrays;

public enum FunctionType {
	ORDER("1"),
	PAY("2"),
	QUIT("3");

	private final String functionType;

	FunctionType(String functionType) {
		this.functionType = functionType;
	}

	public static FunctionType of(String functionType) {
		return Arrays.stream(FunctionType.values())
			.filter(value -> functionType.equals(value.getFunctionType()))
			.findFirst()
			.orElseThrow(NullPointerException::new);
	}

	public String getFunctionType() {
		return functionType;
	}
}
