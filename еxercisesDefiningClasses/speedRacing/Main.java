package еxercisesDefiningClasses.speedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split(" ");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostPerKm = Double.parseDouble(data[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.add(car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split(" ");

            if (data[0].equals("Drive")) {
                String model = data[1];
                double amountOfKm = Double.parseDouble(data[2]);
                Car car = getCarByModel(cars, model);
                car.drive(amountOfKm);
            }

            input = scanner.nextLine();
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %.0f%n", car.getModel(), car.getFuelAmount(), car.getDistanceTraveled());
        }

    }

    private static Car getCarByModel(List<Car> cars, String model) {
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

}
