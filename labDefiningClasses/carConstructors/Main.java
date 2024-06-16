package labDefiningClasses.carConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            if (tokens.length == 1) {
                Car car = new Car(brand);
                System.out.println(car.carInfo());
            } else if (tokens.length == 3) {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(brand, model, horsePower);
                System.out.println(car.carInfo());

            }

        }

    }
}
