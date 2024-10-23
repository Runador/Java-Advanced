import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sum = 0;

        String input = scanner.nextLine();

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1) {
                sum += 0.1;
            } else if (coin == 0.2) {
                sum += 0.2;
            } else if (coin == 0.5) {
                sum += 0.5;
            } else if (coin == 1.0) {
                sum += 1.0;
            } else if (coin == 2.0) {
                sum += 2.0;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String product = input;

            double price = 0;

            switch (product) {
                case "Nuts" -> price = 2.0;
                case "Water" -> price = 0.7;
                case "Crisps" -> price = 1.5;
                case "Soda" -> price = 0.8;
                case "Coke" -> price = 1.0;
                default -> System.out.println("Invalid product");
            }

            if (areMoneyEnough(price, sum) && areProductExist(product)) {
                System.out.printf("Purchased %s%n", product);
                sum -= price;
            } else if (!areMoneyEnough(price, sum) && areProductExist(product)){
                System.out.println("Sorry, not enough money");
            }

            input = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }

    private static boolean areMoneyEnough(double price, double sum) {
        return sum >= price;
    }

    private static boolean areProductExist(String product) {
        return switch (product) {
            case "Nuts", "Water", "Crisps", "Soda", "Coke" -> true;
            default -> false;
        };
    }
}
