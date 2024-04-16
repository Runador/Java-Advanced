package DefiningClassesLab.Car;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Car> cars = new LinkedHashSet<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCars; i++) {

            String[] carsData = scanner.nextLine().split(" ");
            Car car;

            if (carsData.length == 3) {
                car = new Car(carsData[0], carsData[1], Integer.parseInt(carsData[2]));
            } else {
                car = new Car(carsData[0]);
            }
            cars.add(car);

            System.out.println(car);
        }

    }

}
