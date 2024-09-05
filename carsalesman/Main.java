package carsalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String engineModel = data[0];
            int enginePower = Integer.parseInt(data[1]);
            String engineDisplacement = "n/a";
            String engineEfficiency = "n/a";
            if (data.length == 4) {
                engineDisplacement = data[2];
                engineEfficiency = data[3];
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    engineDisplacement = data[2];
                } else {
                    engineEfficiency = data[2];
                }
            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String engineModel = data[1];
            String weight = "n/a";
            String color = "n/a";
            if (data.length == 4) {
                weight = data[2];
                color = data[3];
            } else if (data.length == 3) {
                if (Character.isLetter(data[2].charAt(0))) {
                    color = data[2];
                } else {
                    weight = data[2];
                }
            }
            Engine engine = getEngineByModel(engines, engineModel);
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }

    private static Engine getEngineByModel(List<Engine> engines, String model) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(model)) {
                return engine;
            }
        }
        return null;
    }
}
