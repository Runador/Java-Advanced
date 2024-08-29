package definingclasses.carconstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brand = scanner.nextLine();
        Car car1 = new Car(brand);
        System.out.println(car1.carInfo());
        String model = scanner.nextLine();
        int horsePower = Integer.parseInt(scanner.nextLine());
        Car car2 = new Car(brand, model, horsePower);
        System.out.println(car2.carInfo());
    }
}
