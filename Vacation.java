import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String stayingDay = scanner.nextLine();
        double totalPrice = 0;

        if (groupType.equals("Business") && numberOfPeople >= 100) {
            numberOfPeople = numberOfPeople - 10;
        }

        switch (groupType) {
            case "Students":
                switch (stayingDay) {
                    case "Friday" -> totalPrice = 8.45 * numberOfPeople;
                    case "Saturday" -> totalPrice = 9.8 * numberOfPeople;
                    case "Sunday" -> totalPrice = 10.46 * numberOfPeople;
                }
                break;
            case "Business":
                switch (stayingDay) {
                    case "Friday" -> totalPrice = 10.9 * numberOfPeople;
                    case "Saturday" -> totalPrice = 15.6 * numberOfPeople;
                    case "Sunday" -> totalPrice = 16 * numberOfPeople;
                }
                break;
            case "Regular":
                switch (stayingDay) {
                    case "Friday" -> totalPrice = 15 * numberOfPeople;
                    case "Saturday" -> totalPrice = 20 * numberOfPeople;
                    case "Sunday" -> totalPrice = 22.50 * numberOfPeople;
                }
                break;
        }

        if (groupType.equals("Students") && numberOfPeople >= 30) {
            totalPrice = totalPrice * 0.85;
        }
        if (groupType.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
            totalPrice = totalPrice * 0.95;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
