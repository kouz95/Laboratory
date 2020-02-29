package fuel;

public class Sonata extends Car implements Reportable {
	private final String name;
	private final double mileage;

	public Sonata(int distance) {
		super(distance);
		name = "Sonata";
		mileage = 10;
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
