package DefiningClassesLab.CarInfo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            String carData = scanner.nextLine();
            String brand = carData.split(" ")[0];
            String model = carData.split(" ")[1];
            int horsePower = Integer.parseInt(carData.split(" ")[2]);

            Car car = new Car(brand, model, horsePower);
            System.out.println(car);
        }

    }

}
