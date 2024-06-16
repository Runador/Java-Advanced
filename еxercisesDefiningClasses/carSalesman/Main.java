package еxercisesDefiningClasses.carSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] engineTokens = scanner.nextLine().split("\\s+");
            if (engineTokens.length == 4) {

            }
            Engine engine = new Engine(engineTokens[0], Integer.parseInt(engineTokens[1]), Integer.parseInt(engineTokens[2]), engineTokens[3]);
            engines.add(engine);
        }

        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            // "{Model} {Engine} {Weight} {Color}"
            for (Engine engine : engines) {
                if (carTokens[1].equals(engine.getModel())) {
                    if (carTokens.length == 2) {

                    }
                    Car car = new Car(carTokens[0], engine, Integer.parseInt(carTokens[2]), carTokens[3]);
                    System.out.println(car);
                }
            }

        }

    }

}
