package fuel;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final List<Car> cars;

	private RentCompany() {
		this.cars = new ArrayList<>();
	}

	public static RentCompany create() {
		return new RentCompany();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public String generateReport() {
		return cars.stream()
			.map(Car::getReport)
			.collect(joining(NEWLINE, "", NEWLINE));
	}
}
