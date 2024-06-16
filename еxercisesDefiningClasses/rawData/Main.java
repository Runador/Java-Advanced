package еxercisesDefiningClasses.rawData;

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
            // ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4

            String model = data[0];

            Engine engine = new Engine(Integer.parseInt(data[1]), Integer.parseInt(data[2]));

            Cargo cargo = new Cargo(Integer.parseInt(data[3]), data[4]);

            Tire tire1 = new Tire(Double.parseDouble(data[5]), Integer.parseInt(data[6]));
            Tire tire2 = new Tire(Double.parseDouble(data[7]), Integer.parseInt(data[8]));
            Tire tire3 = new Tire(Double.parseDouble(data[9]), Integer.parseInt(data[10]));
            Tire tire4 = new Tire(Double.parseDouble(data[11]), Integer.parseInt(data[12]));

            List<Tire> tires = new ArrayList<>();
            tires.add(tire1);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();

        if ("fragile".equals(command)) {

            // cars.forEach(car -> car.getTires().filter(tire -> tire.getTirePressure() < 1.0));

            for (Car car : cars) {
                List<Tire> tires = car.getTires();
                for (Tire tire : tires) {
                    if (tire.getTirePressure() < 1.0) {
                        System.out.println(car.getModel());
                        break;
                    }
                }
            }


        } else if ("flamable".equals(command)) {
            for (Car car : cars) {
                if (car.getEngine().getEnginePower() > 250) {
                    System.out.println(car.getModel());
                }
            }
        }

    }
}
