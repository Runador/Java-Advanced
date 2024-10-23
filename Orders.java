import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ordersCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        while (ordersCount-- > 0) {

            double capsulePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double result = ((days * capsulesCount) * capsulePrice);
            totalPrice += result;
            System.out.printf("The price for the coffee is: $%.2f%n", result);
        }

        System.out.printf("Total: $%.2f", totalPrice);
    }
}
