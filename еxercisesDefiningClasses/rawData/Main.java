package еxercisesDefiningClasses.rawData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            // ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            double tirePressure1 = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            Tire tire1 = new Tire(tirePressure1, tire1Age);
            double tirePressure2 = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            Tire tire2 = new Tire(tirePressure2, tire2Age);
            double tirePressure3 = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            Tire tire3 = new Tire(tirePressure3, tire3Age);
            double tirePressure4 = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);
            Tire tire4 = new Tire(tirePressure4, tire4Age);
            Car car = new Car(model, engine, cargo,
                    tire1, tire2,
                    tirePressure3, tire3Age, tirePressure4, tire4Age);
        }

    }
}
