package definingclasses.carinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String brand = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);
            Car car = new Car(brand, model, horsePower);
            System.out.println(car.carInfo());
            cars.add(car);
        }

        //cars.forEach(car -> car.carInfo());
    }
}
