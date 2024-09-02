package rawdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (n-- > 0) {
            String[] data = command.split("\\s+");
            Car car = new Car(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]), data[4], Double.parseDouble(data[5]),
                    Integer.parseInt(data[6]), Double.parseDouble(data[7]),
                    Integer.parseInt(data[8]), Double.parseDouble(data[9]),
                    Integer.parseInt(data[10]), Double.parseDouble(data[11]),
                    Integer.parseInt(data[12]));
            cars.add(car);
            command = scanner.nextLine();
        }

        switch (command) {
            case "fragile" -> {
                for (Car car : cars) {
                    if (car.getCargo().getType().equals("fragile")) {
                        for (Tire tire : car.getTires()) {
                            if (tire.getPressure() < 1) {
                                System.out.println(car.getModel());
                                break;
                            }
                        }
                    }
                }
            }
            case "flamable" -> cars.stream().filter(e -> e.getCargo().getType().equals("flamable"))
                    .filter(e -> e.getEngine().getPower() > 250).forEach(e -> System.out.println(e.getModel()));
        }
    }
}
