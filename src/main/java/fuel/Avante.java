package fuel;

public class Avante extends Car implements Reportable {
	private final String name;
	private final double mileage;

	public Avante(int distance) {
		super(distance);
		name = "Avante";
		mileage = 15;
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
