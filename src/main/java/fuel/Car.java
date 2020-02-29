package fuel;

public abstract class Car implements Reportable {

	protected final int distance;

	public Car(int distance) {
		this.distance = distance;
	}

	abstract double getDistancePerLiter();

	abstract double getTripDistance();

	abstract String getName();

	double getChargeQuantity() {
		return getTripDistance() / getDistancePerLiter();
	}

	public String getReport() {
		return getName() + " : " + (int)getChargeQuantity() + "리터";
	}
}

