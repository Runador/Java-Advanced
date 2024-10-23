import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int sum = hours * 60 + minutes + 30;
        int hoursAfter = sum / 60;
        int minutesAfter = sum % 60;

        if (hoursAfter > 23) {
            hoursAfter = 0;
        }
        if (minutesAfter < 9) {
            System.out.printf("%d:0%d", hoursAfter, minutesAfter);
        } else {
            System.out.printf("%d:%d", hoursAfter, minutesAfter);
        }
    }
}
