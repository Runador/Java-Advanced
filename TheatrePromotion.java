import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dayType = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int result = 0;

        if (age >= 0 && age <= 18) {
            switch (dayType) {
                case "Weekday" -> result = 12;
                case "Weekend" -> result = 15;
                case "Holiday" -> result = 5;
            }
        } else if (age > 18 && age <= 64) {
            result = switch (dayType) {
                case "Weekday" -> 18;
                case "Weekend" -> 20;
                case "Holiday" -> 12;
                default -> result;
            };
        } else if (age > 64 && age <= 122) {
            result = switch (dayType) {
                case "Weekday" -> 12;
                case "Weekend" -> 15;
                case "Holiday" -> 10;
                default -> result;
            };
        } else {
            System.out.println("Error!");
        }
        if (result > 0) {
            System.out.println(result + "$");
        }
    }
}
