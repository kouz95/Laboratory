package fuel;

public class K5 extends Car implements Reportable {
	private final String name;
	private final double mileage;

	public K5(int distance) {
		super(distance);
		name = "K5";
		mileage = 13;
	}

	@Override
	double getDistancePerLiter() {
		return mileage;
	}

	@Override
	double getTripDistance() {
		return super.distance;
	}

	@Override
	String getName() {
		return name;
	}
}
